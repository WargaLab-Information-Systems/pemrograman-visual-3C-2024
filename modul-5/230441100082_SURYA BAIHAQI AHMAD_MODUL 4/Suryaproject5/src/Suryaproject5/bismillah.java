/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Suryaproject5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class bismillah extends javax.swing.JFrame {
    Connection conn;
    private DefaultTableModel modelKaryawan;
    private DefaultTableModel modelProyek;
    private DefaultTableModel modelTransaksi;

    // Konstruktor
    public bismillah() {
        initComponents();
        conn = connection.getConnection();
        
        // Inisialisasi model untuk tabel karyawan
        modelKaryawan = new DefaultTableModel();
        tabelkaryawan.setEnabled(false);
        modelKaryawan.addColumn("ID");
        modelKaryawan.addColumn("Nama");
        modelKaryawan.addColumn("Jabatan");
        modelKaryawan.addColumn("Departemen");
        tabelkaryawan.setModel(modelKaryawan);

        // Inisialisasi model untuk tabel proyek
        modelProyek = new DefaultTableModel();
        modelProyek.addColumn("ID");
        modelProyek.addColumn("Nama_Proyek");
        modelProyek.addColumn("Durasi_Pengerjaan");
        tabelproyek.setModel(modelProyek);

        // Inisialisasi model untuk tabel transaksi
        modelTransaksi = new DefaultTableModel();
        modelTransaksi.addColumn("ID_KARYAWAN");
        modelTransaksi.addColumn("ID_PROYEK");
        modelTransaksi.addColumn("PERAN");
        //modelTransaksi.addColumn("Durasi");//
        tabeltransaksi.setModel(modelTransaksi);
        

    
        loadDataKaryawan();
        loadDataPoyek();
        loadDataTransaksi();
        loadComboBoxProyek();
        loadComboBoxKaryawan();
//       
    }
    
private void loadDataKaryawan(){
    modelKaryawan.setRowCount(0);

    try{
        String sql = "SELECT * FROM tabel_karyawan";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
           modelKaryawan.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("nama"),
                rs.getString("jabatan"),
                rs.getString("departemen")
            });
//            
        }
    } catch (SQLException e) {
        System.out.println("Error load" + e.getMessage());
    }
}

private void tambahKaryawan() {
    
    if (tf_id.getText().trim().isEmpty() || 
        namakaryawan.getText().trim().isEmpty() || 
        jabatankaryawan.getText().trim().isEmpty() || 
        departemenkaryawan.getText().trim().isEmpty()) {
        
        
        JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; 
    }

    
    int id = Integer.parseInt(tf_id.getText());
    if (isIdExist(id)) {
        
        JOptionPane.showMessageDialog(this, "ID karyawan sudah ada. Silakan gunakan ID yang berbeda!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; // Keluar dari fungsi jika ID sudah ada
    }

    try {
        String sql = "INSERT INTO tabel_karyawan (id, nama, jabatan, departemen) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2, namakaryawan.getText());
        stmt.setString(3, jabatankaryawan.getText());
        stmt.setString(4, departemenkaryawan.getText());
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data karyawan berhasil ditambahkan.");
        loadDataKaryawan(); 
    } catch (SQLException e) {
        System.out.println("Error tambah: " + e.getMessage());
    } catch (NumberFormatException e) {
        // Menangani kesalahan jika id bukan angka
        JOptionPane.showMessageDialog(this, "ID harus berupa angka!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    }
}

// Fungsi untuk memeriksa apakah ID sudah ada dalam database
private boolean isIdExist(int id) {
    String sql = "SELECT COUNT(*) FROM tabel_karyawan WHERE id = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0; // Jika ada, return true
        }
    } catch (SQLException e) {
        System.out.println("Error checking ID existence: " + e.getMessage());
    }
    return false; // Jika tidak ada, return false
}

private void editKaryawan() {
        try (Connection conn = connection.getConnection()) {
            String sql = "UPDATE tabel_karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, namakaryawan.getText());
            stmt.setString(2, jabatankaryawan.getText());
            stmt.setString(3, departemenkaryawan.getText());
            stmt.setInt(4, Integer.parseInt(tf_id.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data karyawan berhasil diubah.");
            loadDataKaryawan();
        } catch (SQLException e) {
            System.out.println("Error edit" + e.getMessage());
        }

}
private void hapusKaryawan() {
    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data karyawan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "DELETE FROM tabel_karyawan WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(tf_id.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data karyawan berhasil dihapus.");
            loadDataKaryawan();
        } catch (SQLException e) {
            System.out.println("Error hapus: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Penghapusan data dibatalkan.");
    }
}
  






// TAB baris ke dua lo ya ini  ya 
    @SuppressWarnings("unchecked")
    
    
    
    
    
 private void loadDataPoyek() {
        modelProyek.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM tabel_proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelProyek.addRow(new Object[]{
                    rs.getInt("ID"),
                    rs.getString("nama_proyek"),
                    rs.getString("durasi_pengerjaan")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
 
 
 
 // LOAD TAB KE 3 
 
     private void loadDataTransaksi() {
        modelTransaksi.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM tabel_transaksi";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelTransaksi.addRow(new Object[]{
                    rs.getInt("id_karyawan"),
                    rs.getString("id_proyek"),
                    rs.getString("peran")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }   
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        karyawan = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tambah = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelkaryawan = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        jabatankaryawan = new javax.swing.JTextField();
        namakaryawan = new javax.swing.JTextField();
        departemenkaryawan = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        proyek = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelproyek = new javax.swing.JTable();
        tambahproyek = new javax.swing.JButton();
        editproyek = new javax.swing.JButton();
        hapusproyek = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        durasi_proyek = new javax.swing.JTextField();
        id_proyek = new javax.swing.JTextField();
        nama_proyek = new javax.swing.JTextField();
        TransaksiProyek = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabeltransaksi = new javax.swing.JTable();
        id_karyawan = new javax.swing.JComboBox<>();
        comboproyek = new javax.swing.JComboBox<>();
        tambahtransaksi = new javax.swing.JButton();
        edittransaksi = new javax.swing.JButton();
        hapustransaksi = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        durasi_transaksi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N

        karyawan.setBackground(new java.awt.Color(127, 161, 195));
        karyawan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel1, java.awt.BorderLayout.CENTER);

        karyawan.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 52, -1, -1));

        tambah.setFont(new java.awt.Font("Segoe UI Semilight", 3, 14)); // NOI18N
        tambah.setText("TAMBAH");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        karyawan.add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, -1, 30));

        edit.setFont(new java.awt.Font("Segoe UI Semilight", 3, 12)); // NOI18N
        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        karyawan.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 90, 30));

        hapus.setFont(new java.awt.Font("Segoe UI Semilight", 3, 14)); // NOI18N
        hapus.setText("HAPUS");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        karyawan.add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 90, 30));

        tabelkaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelkaryawan);

        karyawan.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 540, 234));

        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 3, 14)); // NOI18N
        jLabel2.setText("id : ");
        karyawan.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 3, 14)); // NOI18N
        jLabel3.setText("Nama : ");
        karyawan.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 3, 14)); // NOI18N
        jLabel4.setText("Jabatan :");
        karyawan.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 3, 14)); // NOI18N
        jLabel5.setText("Departemen :");
        karyawan.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, -1));

        tf_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_idActionPerformed(evt);
            }
        });
        karyawan.add(tf_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 178, -1));

        jabatankaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabatankaryawanActionPerformed(evt);
            }
        });
        karyawan.add(jabatankaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 178, -1));
        karyawan.add(namakaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 178, -1));
        karyawan.add(departemenkaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 178, -1));

        jPanel10.setBackground(new java.awt.Color(117, 134, 148));
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jLabel10.setFont(new java.awt.Font("Sitka Subheading", 3, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Masukan data- data anda ");
        jPanel10.add(jLabel10, new java.awt.GridBagConstraints());

        karyawan.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 70));

        jTabbedPane1.addTab("Karyawan", karyawan);

        proyek.setBackground(new java.awt.Color(127, 161, 195));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tabelproyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelproyek);

        tambahproyek.setFont(new java.awt.Font("Segoe UI Semilight", 3, 14)); // NOI18N
        tambahproyek.setText("TAMBAH");
        tambahproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahproyekActionPerformed(evt);
            }
        });

        editproyek.setFont(new java.awt.Font("Segoe UI Semilight", 3, 14)); // NOI18N
        editproyek.setText("EDIT");
        editproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editproyekActionPerformed(evt);
            }
        });

        hapusproyek.setFont(new java.awt.Font("Segoe UI Semilight", 3, 14)); // NOI18N
        hapusproyek.setText("HAPUS");
        hapusproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusproyekActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 3, 14)); // NOI18N
        jLabel6.setText("id : ");

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 3, 14)); // NOI18N
        jLabel7.setText("Nama Proyek : ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel8.setText("Durasi Pengerjaan : ");

        javax.swing.GroupLayout proyekLayout = new javax.swing.GroupLayout(proyek);
        proyek.setLayout(proyekLayout);
        proyekLayout.setHorizontalGroup(
            proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proyekLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(proyekLayout.createSequentialGroup()
                        .addGroup(proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(proyekLayout.createSequentialGroup()
                                .addGroup(proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(74, 74, 74)
                                .addGroup(proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(durasi_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nama_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 367, Short.MAX_VALUE))
                    .addGroup(proyekLayout.createSequentialGroup()
                        .addGroup(proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(proyekLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(proyekLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addGroup(proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tambahproyek, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(editproyek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hapusproyek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(142, Short.MAX_VALUE))))
        );
        proyekLayout.setVerticalGroup(
            proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proyekLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(proyekLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(proyekLayout.createSequentialGroup()
                        .addGroup(proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(id_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(nama_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(durasi_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(proyekLayout.createSequentialGroup()
                                .addComponent(tambahproyek)
                                .addGap(30, 30, 30)
                                .addComponent(editproyek)
                                .addGap(30, 30, 30)
                                .addComponent(hapusproyek))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 85, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Proyek", proyek);

        TransaksiProyek.setBackground(new java.awt.Color(127, 161, 195));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tabeltransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tabeltransaksi);

        id_karyawan.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        id_karyawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama karyawan" }));
        id_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_karyawanActionPerformed(evt);
            }
        });

        comboproyek.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        comboproyek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Proyek" }));
        comboproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboproyekActionPerformed(evt);
            }
        });

        tambahtransaksi.setFont(new java.awt.Font("Segoe UI Semilight", 3, 14)); // NOI18N
        tambahtransaksi.setText("TAMBAH");
        tambahtransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahtransaksiActionPerformed(evt);
            }
        });

        edittransaksi.setFont(new java.awt.Font("Segoe UI Semilight", 3, 12)); // NOI18N
        edittransaksi.setText("EDIT");
        edittransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edittransaksiActionPerformed(evt);
            }
        });

        hapustransaksi.setFont(new java.awt.Font("Segoe UI Semilight", 3, 14)); // NOI18N
        hapustransaksi.setText("HAPUS");
        hapustransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapustransaksiActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Sitka Subheading", 3, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Periksa id karyan dan id proyek anda");

        durasi_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durasi_transaksiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 3, 14)); // NOI18N
        jLabel1.setText("Nama karyawan : ");

        jLabel11.setFont(new java.awt.Font("Segoe UI Semilight", 3, 14)); // NOI18N
        jLabel11.setText("nama proyek : ");

        jLabel12.setFont(new java.awt.Font("Segoe UI Semilight", 3, 14)); // NOI18N
        jLabel12.setText("peran :");

        javax.swing.GroupLayout TransaksiProyekLayout = new javax.swing.GroupLayout(TransaksiProyek);
        TransaksiProyek.setLayout(TransaksiProyekLayout);
        TransaksiProyekLayout.setHorizontalGroup(
            TransaksiProyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransaksiProyekLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(TransaksiProyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TransaksiProyekLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))
                    .addGroup(TransaksiProyekLayout.createSequentialGroup()
                        .addGroup(TransaksiProyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(TransaksiProyekLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(TransaksiProyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel12)))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(TransaksiProyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TransaksiProyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(id_karyawan, 0, 154, Short.MAX_VALUE)
                                .addComponent(comboproyek, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(durasi_transaksi)
                                .addComponent(tambahtransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(TransaksiProyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(edittransaksi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hapustransaksi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
                        .addGap(0, 23, Short.MAX_VALUE))))
        );
        TransaksiProyekLayout.setVerticalGroup(
            TransaksiProyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransaksiProyekLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(TransaksiProyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TransaksiProyekLayout.createSequentialGroup()
                        .addGroup(TransaksiProyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(id_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(TransaksiProyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(comboproyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(TransaksiProyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(durasi_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(tambahtransaksi)
                        .addGap(27, 27, 27)
                        .addComponent(hapustransaksi)
                        .addGap(33, 33, 33)
                        .addComponent(edittransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        jTabbedPane1.addTab("Transaksi Proyek", TransaksiProyek);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edittransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edittransaksiActionPerformed
   
        // edit  TAB 3  33                                    
     try {
        String sql = "UPDATE tabel_transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(id_karyawan.getSelectedItem().toString());
        int idProyek = getSelectedId(comboproyek.getSelectedItem().toString());
        
        ps.setString(1, durasi_transaksi.getText());
        ps.setInt(2, idKaryawan);
        ps.setInt(3, idProyek);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Transaksi berhasil diperbarui");
        loadDataTransaksi();
    } catch (SQLException e) {
        System.out.println("Kesalahan Memperbarui Data Transaksi: " + e.getMessage());
    }

     
    }//GEN-LAST:event_edittransaksiActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        tambahKaryawan();

      
    }//GEN-LAST:event_tambahActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        editKaryawan();
    }//GEN-LAST:event_editActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        hapusKaryawan();
    }//GEN-LAST:event_hapusActionPerformed

    private void tambahproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahproyekActionPerformed
     // tambah tap 2
try {
    int id = Integer.parseInt(id_proyek.getText());      // ID proyek
    int durasi = Integer.parseInt(durasi_proyek.getText()); // Durasi pengerjaan
    
    String sql = "INSERT INTO tabel_proyek (id, nama_Proyek, durasi_Pengerjaan) VALUES (?, ?, ?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, id);
    ps.setString(2, nama_proyek.getText());
    ps.setInt(3, durasi); // durasi_pengerjaan
    
    ps.executeUpdate();
    JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");
    loadDataPoyek();
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Durasi pengerjaan harus berupa angka.", "Input Error", JOptionPane.ERROR_MESSAGE);
} catch (SQLException e) {
    System.out.println("Error Save Data: " + e.getMessage());
}



    }//GEN-LAST:event_tambahproyekActionPerformed


    private void tambahtransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahtransaksiActionPerformed
    // TAMABAH TAB 3 
    
       try {
        if (id_karyawan.getSelectedItem() == null || comboproyek.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Pilih karyawan dan proyek terlebih dahulu");
            return;
        }
        
        String sql = "INSERT INTO tabel_transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(id_karyawan.getSelectedItem().toString());
        int idProyek = getSelectedId(comboproyek.getSelectedItem().toString());
        
        if (idKaryawan == -1 || idProyek == -1) {
            JOptionPane.showMessageDialog(this, "ID Karyawan atau ID Proyek tidak valid");
            return;
        }
        
        if (durasi_transaksi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Peran tidak boleh kosong");
            return;
        }
        
        ps.setInt(1, idKaryawan);
        ps.setInt(2, idProyek);
        ps.setString(3, durasi_transaksi.getText().trim());
        
        int result = ps.executeUpdate();
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Data Transaksi berhasil ditambahkan");
            loadDataTransaksi();
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Menambah Data Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Gagal menambah data: " + e.getMessage());
    }


    }//GEN-LAST:event_tambahtransaksiActionPerformed

    private void editproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editproyekActionPerformed
 //   EDIT TAB 2222
 if (tabelproyek.getRowCount() == 0) {
    JOptionPane.showMessageDialog(this, "THERE IS NO DATA", "DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
} else {
    try {  
        String sql = "SELECT nama_proyek, durasi_pengerjaan FROM tabel_proyek WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(id_proyek.getText()));
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(this, "THERE IS NO DATA", "DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String proname = nama_proyek.getText().isEmpty() ? rs.getString("nama_proyek") : nama_proyek.getText();
        String duration = durasi_proyek.getText().isEmpty() ? rs.getString("durasi_pengerjaan") : durasi_proyek.getText();
        String upsql = "UPDATE tabel_proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
        PreparedStatement upps = conn.prepareStatement(upsql);
        upps.setString(1, proname);
        upps.setString(2, duration);
        upps.setInt(3, Integer.parseInt(id_proyek.getText()));
        upps.executeUpdate();

        JOptionPane.showMessageDialog(this, "P SUKSES");
        loadDataPoyek();
    } catch (SQLException e) {
        System.out.println("Error updating data: " + e.getMessage());
    }
}


    }//GEN-LAST:event_editproyekActionPerformed

    private void hapusproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusproyekActionPerformed
    // HAPUS TAB 2 BELOM BSA  
        
        try {
            String sql = "DELETE FROM tabel_proyek WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(id_proyek.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data karyawan berhasil dihapus.");
            //loadDataProyek();
            loadDataPoyek();
        } catch (SQLException e) {
            System.out.println("Error hapus" + e.getMessage());
        } // TODO add your handling code here:
    }//GEN-LAST:event_hapusproyekActionPerformed

// LOAD COMBO BOK KARYA WAANNN 
    
    
    
    
    
   private void loadComboBoxKaryawan() {
    id_karyawan.removeAllItems();
    try {
        String sql = "SELECT id, nama, jabatan, departemen FROM tabel_karyawan";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String tampilan = String.format("ID: %d - %s (%s, %s)", 
                rs.getInt("id"),
                rs.getString("nama"),
                rs.getString("jabatan"),
                rs.getString("departemen")
            );
            id_karyawan.addItem(tampilan);
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Memuat Data Karyawan: " + e.getMessage());
    }
} 



    private void id_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_karyawanActionPerformed
        
 // TODO add your handling code here:
    }//GEN-LAST:event_id_karyawanActionPerformed

    
// LOAD COMBO BOX PROYEK 
      
    private void loadComboBoxProyek() {
    comboproyek.removeAllItems();
    try {
        String sql = "SELECT id, nama_proyek, durasi_pengerjaan FROM tabel_proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String tampilan = String.format("ID: %d - %s (%s)", 
                rs.getInt("id"),
                rs.getString("nama_proyek"),
                rs.getString("durasi_pengerjaan")
            );
            comboproyek.addItem(tampilan);
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Memuat Data Proyek: " + e.getMessage());
    }
}
   private int getSelectedId(String textComboBox) {
    if (textComboBox == null) return -1;
    try {
        String idPart = textComboBox.substring(textComboBox.indexOf("ID: ") + 4);
        return Integer.parseInt(idPart.substring(0, idPart.indexOf(" -")));
    } catch (Exception e) {
        System.out.println("Error parsing ID: " + e.getMessage());
        return -1;
    }
}
    
    private void comboproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboproyekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboproyekActionPerformed

    private void hapustransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapustransaksiActionPerformed
  
 // delet tab 33
try {
    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data transaksi ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        String sql = "DELETE FROM tabel_transaksi WHERE id_karyawan = ? AND id_proyek = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(id_karyawan.getSelectedItem().toString());
        int comboProyek = getSelectedId(comboproyek.getSelectedItem().toString());
        
        ps.setInt(1, idKaryawan);
        ps.setInt(2, comboProyek);
        
        int result = ps.executeUpdate();
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Data Transaksi berhasil dihapus");
            loadDataTransaksi();
        } else {
            JOptionPane.showMessageDialog(this, "Data Transaksi tidak ditemukan atau sudah dihapus.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Penghapusan data dibatalkan.");
    }
} catch (SQLException e) {
    System.out.println("Kesalahan Menghapus Data Transaksi: " + e.getMessage());
}
 

    }//GEN-LAST:event_hapustransaksiActionPerformed

    private void jabatankaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabatankaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jabatankaryawanActionPerformed

    private void tf_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_idActionPerformed

    private void durasi_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durasi_transaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_durasi_transaksiActionPerformed
       
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(bismillah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bismillah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bismillah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bismillah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bismillah().setVisible(true);
            }
        });
    }
    
   // SELECT * FROM users WHERE umur > 20;
//"INSERT INTO karyawan (id, nama, umur) VALUES (?, ?, ?)"
    //"DELETE FROM karyawan WHERE id = ?";
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TransaksiProyek;
    private javax.swing.JComboBox<String> comboproyek;
    private javax.swing.JTextField departemenkaryawan;
    private javax.swing.JTextField durasi_proyek;
    private javax.swing.JTextField durasi_transaksi;
    private javax.swing.JButton edit;
    private javax.swing.JButton editproyek;
    private javax.swing.JButton edittransaksi;
    private javax.swing.JButton hapus;
    private javax.swing.JButton hapusproyek;
    private javax.swing.JButton hapustransaksi;
    private javax.swing.JComboBox<String> id_karyawan;
    private javax.swing.JTextField id_proyek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jabatankaryawan;
    private javax.swing.JPanel karyawan;
    private javax.swing.JTextField nama_proyek;
    private javax.swing.JTextField namakaryawan;
    private javax.swing.JPanel proyek;
    private javax.swing.JTable tabelkaryawan;
    private javax.swing.JTable tabelproyek;
    private javax.swing.JTable tabeltransaksi;
    private javax.swing.JButton tambah;
    private javax.swing.JButton tambahproyek;
    private javax.swing.JButton tambahtransaksi;
    private javax.swing.JTextField tf_id;
    // End of variables declaration//GEN-END:variables
}
