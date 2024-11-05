/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modul5;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AplikasiManajemen extends javax.swing.JFrame {
    Connection conn;

    private DefaultTableModel karyawanModel;
    private DefaultTableModel proyekModel;
    private DefaultTableModel transaksiModel;
    
    public AplikasiManajemen() {
        initComponents();
         conn = koneksi.getConnection();

        karyawanModel= new DefaultTableModel();
        tbl_karyawan.setModel(karyawanModel);

        karyawanModel.addColumn("ID");
        karyawanModel.addColumn("Nama");
        karyawanModel.addColumn("Jabatan");
        karyawanModel.addColumn("Departemen");

        proyekModel= new DefaultTableModel();
        tbl_proyek.setModel(proyekModel);

        proyekModel.addColumn("ID");
        proyekModel.addColumn("Nama Proyek");
        proyekModel.addColumn("Durasi");

        transaksiModel= new DefaultTableModel();
        tbl_transaksiProyek.setModel(transaksiModel);

        transaksiModel.addColumn("ID");
        transaksiModel.addColumn("ID Karyawan");
        transaksiModel.addColumn("ID Proyek");
        transaksiModel.addColumn("Peran");
  
        loadDataKaryawan();
        loadDataProyek();
        loadDataTransaksi();
        loadComboBoxKaryawan();
        loadComboBoxProyek();
    }
    private void loadDataKaryawan() {
        karyawanModel.setRowCount(0);
        try {
            String sql = "SELECT * FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                karyawanModel.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("jabatan"),
                    rs.getString("departemen")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Load Data Karyawan: " + e.getMessage());
        }
    }
    private void loadDataProyek() {
        proyekModel.setRowCount(0);
        try {
            String sql = "SELECT * FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                proyekModel.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nama_proyek"),
                    rs.getString("durasi_pengerjaan")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Load Data Proyek: " + e.getMessage());
        }
    }
    private void loadDataTransaksi() {
    transaksiModel.setRowCount(0);
    try {
        String sql = "SELECT t.id, t.id_karyawan, t.id_proyek, t.peran, " +
                     "k.nama as nama_karyawan, p.nama_proyek " +
                     "FROM transaksi t " +
                     "JOIN karyawan k ON t.id_karyawan = k.id " +
                     "JOIN proyek p ON t.id_proyek = p.id";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            transaksiModel.addRow(new Object[]{
                rs.getInt("id"),
                rs.getInt("id_karyawan"),
                rs.getInt("id_proyek"),
                rs.getString("peran"),
                rs.getString("nama_karyawan"),
                rs.getString("nama_proyek")
            });
        }
        
        String[] columnNames = {"ID","ID Karyawan", "ID Proyek", "Peran", "Nama Karyawan", "Nama Proyek"};
        transaksiModel.setColumnIdentifiers(columnNames);
        
    } catch (SQLException e) {
        System.out.println("Error Load Data Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Gagal memuat data transaksi: " + e.getMessage());
    }
}

    private void tambahKaryawan() {
         if (tf_nama.getText().isEmpty() || tf_jabatan.getText().isEmpty() || tf_departemen.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Mohon Lengkapi Data - Data Anda dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;  
    }
    try {
        String sql = "INSERT INTO karyawan (nama, jabatan, departemen) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_nama.getText());
        ps.setString(2, tf_jabatan.getText());
        ps.setString(3, tf_departemen.getText());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Karyawan berhasil ditambahkan.");
        loadDataKaryawan();
        loadComboBoxKaryawan();
        clearKaryawanFields();  
    } catch (SQLException e) {
        System.out.println("Error Tambah Data Karyawan: " + e.getMessage());
    }
}
   private void updateKaryawan() {
    try {
        int id = Integer.parseInt(tf_id.getText()); 
        String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_nama.getText());
        ps.setString(2, tf_jabatan.getText());
        ps.setString(3, tf_departemen.getText());
        ps.setInt(4, id);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Karyawan berhasil diupdate.");
        loadDataKaryawan();
        clearKaryawanFields();  
    } catch (SQLException e) {
        System.out.println("Error Update Data Karyawan: " + e.getMessage());
    }
}
   private void hapusKaryawan() {
    try {
        int id = Integer.parseInt(tf_id.getText()); 
        String sql = "DELETE FROM karyawan WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Karyawan berhasil dihapus.");
        loadDataKaryawan();
    } catch (SQLException e) {
        System.out.println("Error Hapus Data Karyawan: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID tidak valid");
    }
}
    private void clearKaryawanFields() {
    tf_id.setText("");
    tf_nama.setText("");
    tf_jabatan.setText("");
    tf_departemen.setText("");
}
   private void tambahProyek() {
        if (tf_namaProyek.getText().isEmpty() || tf_durasi.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Mohon Lengkapi Data - Data Anda dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;  
    }
    try {
        String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_namaProyek.getText());  
        ps.setString(2, tf_durasi.getText());  
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Proyek berhasil ditambahkan.");
        loadDataProyek();
        loadComboBoxProyek();
        clearProyekFields();  
    } catch (SQLException e) {
        System.out.println("Error Tambah Data Proyek: " + e.getMessage());
    }
}
    private void updateProyek() {
    try {
        int id = Integer.parseInt(tf_idProyek.getText()); 
        String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_namaProyek.getText());  
        ps.setString(2, tf_durasi.getText()); 
        ps.setInt(3, id);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Proyek berhasil diupdate.");
        loadDataProyek();
        clearProyekFields();  
    } catch (SQLException e) {
        System.out.println("Error Update Data Proyek: " + e.getMessage());
    }
}
    private void hapusProyek() {
    try {
        int id = Integer.parseInt(tf_idProyek.getText()); 
        String sql = "DELETE FROM proyek WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Proyek berhasil dihapus.");
        loadDataProyek();
    } catch (SQLException e) {
        System.out.println("Error Hapus Data Proyek: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID tidak valid");
    }
} 
    private void clearProyekFields() {
        tf_idProyek.setText("");
        tf_namaProyek.setText("");
        tf_durasi.setText("");
    } 
    private void loadComboBoxKaryawan() {
    cbkaryawan.removeAllItems();
    try {
        String sql = "SELECT id, nama, jabatan, departemen FROM karyawan";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String tampilan = String.format("ID: %d - %s (%s, %s)", 
                rs.getInt("id"),
                rs.getString("nama"),
                rs.getString("jabatan"),
                rs.getString("departemen")
            );
            cbkaryawan.addItem(tampilan);
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Memuat Data Karyawan: " + e.getMessage());
    }
}
    private void loadComboBoxProyek() {
    cbproyek.removeAllItems();
    try {
        String sql = "SELECT id, nama_proyek, durasi_pengerjaan FROM proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String tampilan = String.format("ID: %d - %s (%s)", 
                rs.getInt("id"),
                rs.getString("nama_proyek"),
                rs.getString("durasi_pengerjaan")
            );
            cbproyek.addItem(tampilan);
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
   private void tambahTransaksi() {
      try {
        if (cbkaryawan.getSelectedItem() == null || cbproyek.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Pilih karyawan dan proyek terlebih dahulu");
            return;
        }
        
        String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(cbkaryawan.getSelectedItem().toString());
        int idProyek = getSelectedId(cbproyek.getSelectedItem().toString());
        
        if (idKaryawan == -1 || idProyek == -1) {
            JOptionPane.showMessageDialog(this, "ID Karyawan atau ID Proyek tidak valid");
            return;
        }
        if (tf_Peran.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Peran tidak boleh kosong");
            return;
        }
        ps.setInt(1, idKaryawan);
        ps.setInt(2, idProyek);
        ps.setString(3, tf_Peran.getText().trim());
        
        int result = ps.executeUpdate();
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Data Transaksi berhasil ditambahkan");
            loadDataTransaksi();
            loadComboBoxKaryawan();
            loadComboBoxProyek();
            clearTransaksiFields();
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Menambah Data Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Gagal menambah data: " + e.getMessage());
    }
}
    private void clearTransaksiFields() {
        tf_Peran.setText("");
        cbkaryawan.setSelectedIndex(0);
        cbproyek.setSelectedIndex(0);
    }
   private void updateTransaksi() {
    try {
        String sql = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(cbkaryawan.getSelectedItem().toString());
        int idProyek = getSelectedId(cbproyek.getSelectedItem().toString());
        
        ps.setString(1, tf_Peran.getText());
        ps.setInt(2, idKaryawan);
        ps.setInt(3, idProyek);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Transaksi berhasil diperbarui");
        loadDataTransaksi();
    } catch (SQLException e) {
        System.out.println("Kesalahan Memperbarui Data Transaksi: " + e.getMessage());
    }
}
    private void hapusTransaksi() {
    try {
        String sql = "DELETE FROM transaksi WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int id = Integer.parseInt(TF_id.getText());
        ps.setInt(1, id);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Transaksi berhasil dihapus");
        loadDataTransaksi();
    } catch (SQLException e) {
        System.out.println("Kesalahan Menghapus Data Transaksi: " + e.getMessage());
    }
}

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        karyawan = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tf_nama = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tf_jabatan = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tf_departemen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Proyek = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        tf_idProyek = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tf_namaProyek = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tf_durasi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        btn_tambah = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        transaksi3 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_transaksiProyek = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        TF_id = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        cbkaryawan = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        cbproyek = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        tf_Peran = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        bttambah = new javax.swing.JButton();
        btedit = new javax.swing.JButton();
        bthapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N

        karyawan.setBackground(new java.awt.Color(255, 204, 255));
        karyawan.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 220));
        jPanel2.setLayout(new java.awt.GridLayout(4, 2, 0, 20));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("   ID  Karyawan                            :");
        jPanel2.add(jLabel15);
        jPanel2.add(tf_id);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel16.setText("   NAMA                                         :");
        jPanel2.add(jLabel16);
        jPanel2.add(tf_nama);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel17.setText("   JABATAN                                     :");
        jPanel2.add(jLabel17);
        jPanel2.add(tf_jabatan);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel18.setText("   DEPARTEMEN                              :");
        jPanel2.add(jLabel18);
        jPanel2.add(tf_departemen);

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 430, 200));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\tbl.jpg")); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 220));

        karyawan.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMinimumSize(new java.awt.Dimension(237, 200));
        jPanel4.setPreferredSize(new java.awt.Dimension(480, 400));

        btnTambah.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel4.add(btnTambah);

        btnUpdate.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel4.add(btnUpdate);

        btnHapus.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel4.add(btnHapus);

        karyawan.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setMinimumSize(new java.awt.Dimension(500, 300));
        jPanel5.setPreferredSize(new java.awt.Dimension(480, 300));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_karyawan.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        tbl_karyawan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_karyawan);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 440, 240));

        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jButton2.setText("Keluar");
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\bg blue.jpg")); // NOI18N
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 300));

        karyawan.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Karyawan", karyawan);

        Proyek.setBackground(new java.awt.Color(255, 204, 255));
        Proyek.setLayout(new java.awt.BorderLayout());

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(500, 220));
        jPanel13.setLayout(new java.awt.GridLayout(3, 2, 0, 30));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("   ID  Proyek                              :");
        jPanel13.add(jLabel19);
        jPanel13.add(tf_idProyek);

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel20.setText("   NAMA  PROYEK                     :");
        jPanel13.add(jLabel20);
        jPanel13.add(tf_namaProyek);

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel21.setText("  DURASI PENGERJAAN           :");
        jPanel13.add(jLabel21);
        jPanel13.add(tf_durasi);

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 430, 140));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\tbl.jpg")); // NOI18N
        jPanel12.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 220));

        Proyek.add(jPanel12, java.awt.BorderLayout.PAGE_END);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setMinimumSize(new java.awt.Dimension(237, 200));
        jPanel14.setPreferredSize(new java.awt.Dimension(480, 400));

        btn_tambah.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        jPanel14.add(btn_tambah);

        btn_edit.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        btn_edit.setText("Update");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        jPanel14.add(btn_edit);

        btn_hapus.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel14.add(btn_hapus);

        Proyek.add(jPanel14, java.awt.BorderLayout.CENTER);

        jPanel23.setBackground(new java.awt.Color(204, 255, 255));
        jPanel23.setMinimumSize(new java.awt.Dimension(500, 300));
        jPanel23.setPreferredSize(new java.awt.Dimension(480, 300));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_proyek.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        tbl_proyek.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tbl_proyek);

        jPanel23.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 440, 240));

        jButton3.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jButton3.setText("Keluar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel23.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\bg blue.jpg")); // NOI18N
        jPanel23.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 300));

        Proyek.add(jPanel23, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Proyek", Proyek);

        jPanel24.setLayout(new java.awt.BorderLayout());

        jPanel25.setPreferredSize(new java.awt.Dimension(490, 330));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_transaksiProyek.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        tbl_transaksiProyek.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_transaksiProyek.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_transaksiProyek.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane7.setViewportView(tbl_transaksiProyek);

        jPanel25.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 450, 240));

        jButton6.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jButton6.setText("Keluar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel25.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5/biruuuu.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel25.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 330));

        jPanel24.add(jPanel25, java.awt.BorderLayout.PAGE_END);

        jPanel6.setPreferredSize(new java.awt.Dimension(496, 200));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setPreferredSize(new java.awt.Dimension(490, 200));
        jPanel26.setLayout(new java.awt.GridLayout(4, 2, 0, 25));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("ID TRANSAKSI                             :");
        jPanel26.add(jLabel7);
        jPanel26.add(TF_id);

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel29.setText("   ID Karyawan                              :");
        jPanel26.add(jLabel29);

        cbkaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel26.add(cbkaryawan);

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel30.setText("  ID Proyek                                   :");
        jPanel26.add(jLabel30);

        cbproyek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel26.add(cbproyek);

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel31.setText("    Peran                                       :");
        jPanel26.add(jLabel31);
        jPanel26.add(tf_Peran);

        jPanel6.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 450, 160));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5/tbl.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 200));

        jPanel24.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        bttambah.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        bttambah.setText("Tambah");
        bttambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttambahbtntambahActionPerformed(evt);
            }
        });
        jPanel27.add(bttambah);

        btedit.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        btedit.setText("Edit");
        btedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteditbtneditActionPerformed(evt);
            }
        });
        jPanel27.add(btedit);

        bthapus.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        bthapus.setText("Hapus");
        bthapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthapusbtnhapusActionPerformed(evt);
            }
        });
        jPanel27.add(bthapus);

        jPanel24.add(jPanel27, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout transaksi3Layout = new javax.swing.GroupLayout(transaksi3);
        transaksi3.setLayout(transaksi3Layout);
        transaksi3Layout.setHorizontalGroup(
            transaksi3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
            .addGroup(transaksi3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(transaksi3Layout.createSequentialGroup()
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        transaksi3Layout.setVerticalGroup(
            transaksi3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
            .addGroup(transaksi3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Transaksi", transaksi3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
    hapusProyek();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
    updateProyek();
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
    tambahProyek();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapusKaryawan();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateKaryawan();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        tambahKaryawan();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void bttambahbtntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttambahbtntambahActionPerformed
    tambahTransaksi();
    }//GEN-LAST:event_bttambahbtntambahActionPerformed

    private void bteditbtneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteditbtneditActionPerformed
    updateTransaksi();
    }//GEN-LAST:event_bteditbtneditActionPerformed

    private void bthapusbtnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthapusbtnhapusActionPerformed
    hapusTransaksi();
    }//GEN-LAST:event_bthapusbtnhapusActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
     System.exit(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AplikasiManajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikasiManajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikasiManajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikasiManajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiManajemen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Proyek;
    private javax.swing.JTextField TF_id;
    private javax.swing.JButton btedit;
    private javax.swing.JButton bthapus;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton bttambah;
    private javax.swing.JComboBox<String> cbkaryawan;
    private javax.swing.JComboBox<String> cbproyek;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel karyawan;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksiProyek;
    private javax.swing.JTextField tf_Peran;
    private javax.swing.JTextField tf_departemen;
    private javax.swing.JTextField tf_durasi;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_idProyek;
    private javax.swing.JTextField tf_jabatan;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_namaProyek;
    private javax.swing.JPanel transaksi3;
    // End of variables declaration//GEN-END:variables
}
