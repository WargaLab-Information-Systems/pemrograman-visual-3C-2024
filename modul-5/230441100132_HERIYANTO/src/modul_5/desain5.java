/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modul_5;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class desain5 extends javax.swing.JFrame {
    Connection conn;
    private DefaultTableModel modelKaryawan;
    private DefaultTableModel modelProyek;
    private DefaultTableModel modelTransaksi;

    

    /**
     * Creates new form desain5
     */
    public desain5() {
        initComponents();
          conn = koneksi.getConnection();

        // Inisialisasi model tabel untuk karyawan dan proyek
        initTableModels();
        loadDataKaryawan();
        loadDataProyek();
        loadDataTransaksi();
        loadComboBoxKaryawan();
        loadComboBoxProyek();
    }
      private void initTableModels() {
        // Model untuk tabel karyawan
        modelKaryawan = new DefaultTableModel(new String[] { "ID", "Nama", "Jabatan", "Departemen" }, 0);
        jTable1.setModel(modelKaryawan);

        // Model untuk tabel proyek
        modelProyek = new DefaultTableModel(new String[] { "ID", "Nama Proyek", "Durasi Pengerjaan" }, 0);
        jTable4.setModel(modelProyek);
        
        modelTransaksi = new DefaultTableModel(new String[]{"ID Karyawan", "ID Proyek", "Peran"}, 0);
        jTable3.setModel(modelTransaksi);
    }

    private void loadDataKaryawan() {
        modelKaryawan.setRowCount(0);
        try {
            String sql = "SELECT * FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelKaryawan.addRow(new Object[]{
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
        modelProyek.setRowCount(0);
        try {
            String sql = "SELECT * FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelProyek.addRow(new Object[]{
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
    modelTransaksi.setRowCount(0);
    try {
        String sql = "SELECT t.id_karyawan, t.id_proyek, t.peran, " +
                     "k.nama as nama_karyawan, p.nama_proyek " +
                     "FROM transaksi t " +
                     "JOIN karyawan k ON t.id_karyawan = k.id " +
                     "JOIN proyek p ON t.id_proyek = p.id";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            modelTransaksi.addRow(new Object[]{
                rs.getInt("id_karyawan"),
                rs.getInt("id_proyek"),
                rs.getString("peran"),
                rs.getString("nama_karyawan"),
                rs.getString("nama_proyek")
            });
        }
        
        // Update column names
        String[] columnNames = {"ID Karyawan", "ID Proyek", "Peran", "Nama Karyawan", "Nama Proyek"};
        modelTransaksi.setColumnIdentifiers(columnNames);
        
    } catch (SQLException e) {
        System.out.println("Error Load Data Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Gagal memuat data transaksi: " + e.getMessage());
    }
}

    private void tambahKaryawan() {
    try {
        String sql = "INSERT INTO karyawan (nama, jabatan, departemen) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tnama.getText());
        ps.setString(2, tjabatan.getText());
        ps.setString(3, tdepartemen.getText());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Karyawan berhasil ditambahkan.");
        loadDataKaryawan();
        clearKaryawanFields();  // Bersihkan input setelah menambahkan data
    } catch (SQLException e) {
        System.out.println("Error Tambah Data Karyawan: " + e.getMessage());
    }
}
   private void updateKaryawan() {
    try {
        int id = Integer.parseInt(tid.getText()); // Ambil ID dari JTextField
        String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tnama.getText());
        ps.setString(2, tjabatan.getText());
        ps.setString(3, tdepartemen.getText());
        ps.setInt(4, id);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Karyawan berhasil diupdate.");
        loadDataKaryawan();
        clearKaryawanFields();  // Bersihkan input setelah mengupdate data
    } catch (SQLException e) {
        System.out.println("Error Update Data Karyawan: " + e.getMessage());
    }
}

   private void hapusKaryawan() {
    try {
        int id = Integer.parseInt(tid.getText()); // Mengambil ID dari JTextField
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

   private void tambahProyek() {
    try {
        String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, txt2.getText());  // Ambil Nama Proyek dari JTextField
        ps.setString(2, txt3.getText());  // Ambil Durasi Pengerjaan dari JTextField
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Proyek berhasil ditambahkan.");
        loadDataProyek();
        clearProyekFields();  // Bersihkan input setelah menambahkan data
    } catch (SQLException e) {
        System.out.println("Error Tambah Data Proyek: " + e.getMessage());
    }
}
    private void updateProyek() {
    try {
        int id = Integer.parseInt(txt1.getText()); // Ambil ID dari JTextField
        String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, txt2.getText());  // Ambil Nama Proyek dari JTextField
        ps.setString(2, txt3.getText());  // Ambil Durasi Pengerjaan dari JTextField
        ps.setInt(3, id);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Proyek berhasil diupdate.");
        loadDataProyek();
        clearProyekFields();  // Bersihkan input setelah mengupdate data
    } catch (SQLException e) {
        System.out.println("Error Update Data Proyek: " + e.getMessage());
    }
}
    private void hapusProyek() {
    try {
        int id = Integer.parseInt(txt1.getText()); // Mengambil ID dari JTextField
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
        
        if (txtperan.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Peran tidak boleh kosong");
            return;
        }
        
        ps.setInt(1, idKaryawan);
        ps.setInt(2, idProyek);
        ps.setString(3, txtperan.getText().trim());
        
        int result = ps.executeUpdate();
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Data Transaksi berhasil ditambahkan");
            loadDataTransaksi();
            clearTransaksiFields();
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Menambah Data Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Gagal menambah data: " + e.getMessage());
    }
}

// Tambahkan method untuk membersihkan field
private void clearTransaksiFields() {
    txtperan.setText("");
    cbkaryawan.setSelectedIndex(0);
    cbproyek.setSelectedIndex(0);
}

   private void updateTransaksi() {
    try {
        String sql = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(cbkaryawan.getSelectedItem().toString());
        int idProyek = getSelectedId(cbproyek.getSelectedItem().toString());
        
        ps.setString(1, txtperan.getText());
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
        String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(cbkaryawan.getSelectedItem().toString());
        int idProyek = getSelectedId(cbproyek.getSelectedItem().toString());
        
        ps.setInt(1, idKaryawan);
        ps.setInt(2, idProyek);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Transaksi berhasil dihapus");
        loadDataTransaksi();
    } catch (SQLException e) {
        System.out.println("Kesalahan Menghapus Data Transaksi: " + e.getMessage());
    }
}

    
    private void clearKaryawanFields() {
    tid.setText("");
    tnama.setText("");
    tjabatan.setText("");
    tdepartemen.setText("");
}

private void clearProyekFields() {
    txt1.setText("");
    txt2.setText("");
    txt3.setText("");
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btntambah = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tnama = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tjabatan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tdepartemen = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btntambah1 = new javax.swing.JButton();
        btnupdate2 = new javax.swing.JButton();
        btnhapus1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt3 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        cbkaryawan = new javax.swing.JComboBox<>();
        cbproyek = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        btnsimpan3 = new javax.swing.JButton();
        btnhapus3 = new javax.swing.JButton();
        btnupdate3 = new javax.swing.JButton();
        txtperan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 23, 341, 204));

        jPanel5.setBackground(new java.awt.Color(0, 102, 255));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        btntambah.setText("tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        jPanel5.add(btntambah, gridBagConstraints);

        btnupdate.setText("update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        jPanel5.add(btnupdate, gridBagConstraints);

        btnhapus.setText("hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        jPanel5.add(btnhapus, gridBagConstraints);

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 130, 200));

        jPanel8.setBackground(new java.awt.Color(0, 102, 255));
        jPanel8.setLayout(null);

        jLabel4.setText("id");
        jPanel8.add(jLabel4);
        jLabel4.setBounds(16, 15, 37, 16);
        jPanel8.add(tid);
        tid.setBounds(71, 15, 71, 22);

        jLabel5.setText("nama");
        jPanel8.add(jLabel5);
        jLabel5.setBounds(16, 66, 37, 16);

        tnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamaActionPerformed(evt);
            }
        });
        jPanel8.add(tnama);
        tnama.setBounds(71, 63, 71, 22);

        jLabel6.setText("jabatan");
        jPanel8.add(jLabel6);
        jLabel6.setBounds(194, 18, 40, 16);

        tjabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tjabatanActionPerformed(evt);
            }
        });
        jPanel8.add(tjabatan);
        tjabatan.setBounds(260, 15, 71, 22);

        jLabel7.setText("departemen");
        jPanel8.add(jLabel7);
        jLabel7.setBounds(170, 70, 70, 16);

        tdepartemen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tdepartemenActionPerformed(evt);
            }
        });
        jPanel8.add(tdepartemen);
        tdepartemen.setBounds(260, 63, 71, 22);

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 380, 110));

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable4);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 23, 341, 204));

        jPanel6.setBackground(new java.awt.Color(0, 153, 255));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        btntambah1.setText("tambah");
        btntambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambah1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(13, 13, 13, 13);
        jPanel6.add(btntambah1, gridBagConstraints);

        btnupdate2.setText("update");
        btnupdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdate2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(13, 13, 13, 13);
        jPanel6.add(btnupdate2, gridBagConstraints);

        btnhapus1.setText("hapus");
        btnhapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapus1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(14, 14, 14, 14);
        jPanel6.add(btnhapus1, gridBagConstraints);

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 130, 200));

        jPanel7.setBackground(new java.awt.Color(0, 153, 255));
        jPanel7.setLayout(null);

        jLabel1.setText("id");
        jPanel7.add(jLabel1);
        jLabel1.setBounds(40, 10, 37, 16);
        jPanel7.add(txt1);
        txt1.setBounds(110, 10, 120, 22);

        jLabel2.setText("nama proyek");
        jPanel7.add(jLabel2);
        jLabel2.setBounds(10, 50, 69, 16);
        jPanel7.add(txt2);
        txt2.setBounds(110, 50, 120, 30);

        jLabel3.setText("durasi pengerjaan");
        jPanel7.add(jLabel3);
        jLabel3.setBounds(0, 100, 100, 16);
        jPanel7.add(txt3);
        txt3.setBounds(110, 100, 120, 30);

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 250, 140));

        jTabbedPane1.addTab("tab2", jPanel3);

        jPanel4.setBackground(new java.awt.Color(51, 0, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 23, 341, 204));

        jPanel9.setBackground(new java.awt.Color(51, 0, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.add(cbkaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, -1));

        jPanel9.add(cbproyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, -1));

        jPanel4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 130, 210));

        jPanel10.setLayout(new java.awt.GridLayout());

        btnsimpan3.setText("simpan");
        btnsimpan3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpan3ActionPerformed(evt);
            }
        });
        jPanel10.add(btnsimpan3);

        btnhapus3.setText("hapus");
        btnhapus3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapus3ActionPerformed(evt);
            }
        });
        jPanel10.add(btnhapus3);

        btnupdate3.setText("update");
        btnupdate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdate3ActionPerformed(evt);
            }
        });
        jPanel10.add(btnupdate3);

        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 390, 30));
        jPanel4.add(txtperan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 140, -1));

        jLabel8.setText("peran :");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        jTabbedPane1.addTab("tab3", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 97, 540, 430));

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
          tambahKaryawan();
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
         updateKaryawan();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
         hapusKaryawan();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnhapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapus1ActionPerformed
        // TODO add your handling code here:
        hapusProyek();
    }//GEN-LAST:event_btnhapus1ActionPerformed

    private void btntambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambah1ActionPerformed
        // TODO add your handling code here:
              tambahProyek();  
        
    }//GEN-LAST:event_btntambah1ActionPerformed

    private void btnupdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdate2ActionPerformed
        // TODO add your handling code here:
          updateProyek();
    }//GEN-LAST:event_btnupdate2ActionPerformed

    private void tnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaActionPerformed

    private void tjabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tjabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tjabatanActionPerformed

    private void tdepartemenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tdepartemenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tdepartemenActionPerformed

    private void btnsimpan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpan3ActionPerformed
        // TODO add your handling code here:
       tambahTransaksi();
    }//GEN-LAST:event_btnsimpan3ActionPerformed

    private void btnhapus3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapus3ActionPerformed
        // TODO add your handling code here:
        hapusTransaksi();
    }//GEN-LAST:event_btnhapus3ActionPerformed

    private void btnupdate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdate3ActionPerformed
        // TODO add your handling code here:
           updateTransaksi();
    }//GEN-LAST:event_btnupdate3ActionPerformed

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
            java.util.logging.Logger.getLogger(desain5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(desain5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(desain5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(desain5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new desain5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnhapus1;
    private javax.swing.JButton btnhapus3;
    private javax.swing.JButton btnsimpan3;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton btntambah1;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton btnupdate2;
    private javax.swing.JButton btnupdate3;
    private javax.swing.JComboBox<String> cbkaryawan;
    private javax.swing.JComboBox<String> cbproyek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField tdepartemen;
    private javax.swing.JTextField tid;
    private javax.swing.JTextField tjabatan;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txtperan;
    // End of variables declaration//GEN-END:variables
}
