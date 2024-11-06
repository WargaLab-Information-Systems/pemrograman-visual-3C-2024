/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package karyawandanproyek;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class apliksiManajemen extends javax.swing.JFrame {
 Connection conn;
    private DefaultTableModel modelKaryawan;
    private DefaultTableModel modelProyek;
    private DefaultTableModel modelTransaksi;

    
    public apliksiManajemen() {
        initComponents();
        conn = koneksi.getConnection();
         
        modelKaryawan = new DefaultTableModel();
        tbl_karyawan.setModel(modelKaryawan);

        modelKaryawan.addColumn("ID");
        modelKaryawan.addColumn("Nama");
        modelKaryawan.addColumn("Jabatan");
        modelKaryawan.addColumn("Departemen");
        
        modelProyek = new DefaultTableModel();
        tbl_proyek.setModel(modelProyek);

        modelProyek.addColumn("ID");
        modelProyek.addColumn("Nama Proyek");
        modelProyek.addColumn("Durasi Pengerjaan");
        
        modelTransaksi = new DefaultTableModel();
        tbl_transaksi.setModel(modelTransaksi);

        modelTransaksi.addColumn("ID Karyawan");
        modelTransaksi.addColumn("ID Proyek");
        modelTransaksi.addColumn("Peran");

        loadDataKaryawan();
        loadDataProyek();
        loadDataTransaksi();
        loadComboBoxKaryawan();
        loadComboBoxProyek();
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
        // Validasi apakah semua field telah diisi dan tidak hanya berisi spasi
        if (tf_id.getText().trim().isEmpty() || tf_nama.getText().trim().isEmpty() || 
            tf_jabatan.getText().trim().isEmpty() || tf_departemen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Maaf, pengisian belum sesuai. Semua field harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validasi apakah ID hanya berisi angka dan field lainnya tidak mengandung simbol khusus
        if (!tf_id.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka tanpa simbol atau spasi.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!tf_nama.getText().matches("[a-zA-Z ]+") || 
            !tf_jabatan.getText().matches("[a-zA-Z ]+") || 
            !tf_departemen.getText().matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(this, "Field Nama, Jabatan, dan Departemen tidak boleh mengandung simbol atau angka.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "INSERT INTO karyawan (id, nama, jabatan, departemen) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(tf_id.getText().trim())); // Ambil teks dari tf_id dan konversi ke Integer
        ps.setString(2, tf_nama.getText().trim());               
        ps.setString(3, tf_jabatan.getText().trim());          
        ps.setString(4, tf_departemen.getText().trim());         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "Data Karyawan berhasil ditambahkan.");
        loadDataKaryawan();
        loadComboBoxKaryawan();  // Panggil ulang ComboBox proyek setelah data karyawan ditambahkan
        clearKaryawanFields();  // Bersihkan input setelah menambahkan data
    } catch (SQLException e) {
        System.out.println("Error Tambah Data Karyawan: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error: ID harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}



   private void updateKaryawan() {
    try {
        // Pastikan ID sudah dimasukkan
        if (tf_id.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan ID karyawan terlebih dahulu sebelum melakukan update.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = Integer.parseInt(tf_id.getText().trim()); // Ambil ID dari JTextField

        // Validasi field lainnya agar tidak kosong
        if (tf_nama.getText().trim().isEmpty() || tf_jabatan.getText().trim().isEmpty() || tf_departemen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi untuk melakukan update.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_nama.getText().trim());
        ps.setString(2, tf_jabatan.getText().trim());
        ps.setString(3, tf_departemen.getText().trim());
        ps.setInt(4, id);
        int rowsUpdated = ps.executeUpdate();

        // Cek apakah ID ditemukan dan data terupdate
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Data Karyawan berhasil diupdate.");
            loadDataKaryawan();
            clearKaryawanFields();  // Bersihkan input setelah mengupdate data
        } else {
            JOptionPane.showMessageDialog(this, "ID Karyawan tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        System.out.println("Error Update Data Karyawan: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error: ID harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


   private void hapusKaryawan() {
    try {
        // Pastikan ID sudah dimasukkan
        if (tf_id.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan ID karyawan terlebih dahulu sebelum menghapus data.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = Integer.parseInt(tf_id.getText().trim()); // Mengambil ID dari JTextField

        String sql = "DELETE FROM karyawan WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int rowsDeleted = ps.executeUpdate();

        // Cek apakah ID ditemukan dan data terhapus
        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(this, "Data Karyawan berhasil dihapus.");
            loadDataKaryawan();
            clearKaryawanFields();  // Bersihkan input setelah menghapus data
        } else {
            JOptionPane.showMessageDialog(this, "ID Karyawan tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        System.out.println("Error Hapus Data Karyawan: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error: ID harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


   private void tambahProyek() {
    try {
        // Validasi apakah semua field telah diisi dan tidak hanya berisi spasi
        if (tf_id2.getText().trim().isEmpty() || tf_namaproyek.getText().trim().isEmpty() || 
            tf_durasi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Maaf, pengisian belum sesuai. Semua field harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validasi apakah ID hanya berisi angka dan field lainnya tidak mengandung simbol khusus
        if (!tf_id2.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka tanpa simbol atau spasi.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!tf_namaproyek.getText().matches("[a-zA-Z ]+") || !tf_durasi.getText().matches("[a-zA-Z0-9 ]+")) {
            JOptionPane.showMessageDialog(this, "Nama Proyek tidak boleh mengandung simbol atau angka, dan Durasi Pengerjaan hanya boleh berisi angka, huruf, dan spasi.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "INSERT INTO proyek (id, nama_proyek, durasi_pengerjaan) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(tf_id2.getText().trim())); // Mengambil ID proyek dari JTextField
        ps.setString(2, tf_namaproyek.getText().trim());  // Mengambil Nama Proyek dari JTextField
        ps.setString(3, tf_durasi.getText().trim());  // Mengambil Durasi Pengerjaan dari JTextField
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "Data Proyek berhasil ditambahkan.");
        loadDataProyek();
        loadComboBoxProyek();  // Memperbarui ComboBox proyek setelah data proyek ditambahkan
        clearProyekFields();  // Bersihkan input setelah menambahkan data
    } catch (SQLException e) {
        System.out.println("Error Tambah Data Proyek: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error: ID harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void updateProyek() {
    try {
        if (tf_id.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan ID karyawan terlebih dahulu sebelum melakukan update.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = Integer.parseInt(tf_id.getText().trim()); // Ambil ID dari JTextField

        // Validasi field lainnya agar tidak kosong
        if (tf_nama.getText().trim().isEmpty() || tf_jabatan.getText().trim().isEmpty() || tf_departemen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi untuk melakukan update.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //int id = Integer.parseInt(tf_id2.getText()); // Ambil ID dari JTextField
        String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_namaproyek.getText());  // Ambil Nama Proyek dari JTextField
        ps.setString(2, tf_durasi.getText());  // Ambil Durasi Pengerjaan dari JTextField
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
        // Pastikan ID proyek sudah dimasukkan
        if (tf_id2.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan ID proyek terlebih dahulu sebelum menghapus data.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = Integer.parseInt(tf_id2.getText().trim()); // Mengambil ID proyek dari JTextField

        String sql = "DELETE FROM proyek WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int rowsDeleted = ps.executeUpdate();

        // Cek apakah ID ditemukan dan data terhapus
        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(this, "Data Proyek berhasil dihapus.");
            loadDataProyek();
            clearProyekFields();  // Bersihkan input setelah menghapus data
        } else {
            JOptionPane.showMessageDialog(this, "ID Proyek tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        System.out.println("Error Hapus Data Proyek: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error: ID harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
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
        
        if (tf_peran.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Peran tidak boleh kosong");
            return;
        }
        
        ps.setInt(1, idKaryawan);
        ps.setInt(2, idProyek);
        ps.setString(3, tf_peran.getText().trim());
        
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

// Tambahkan method untuk membersihkan field
private void clearTransaksiFields() {
    tf_peran.setText("");
    cbkaryawan.setSelectedIndex(0);
    cbproyek.setSelectedIndex(0);
}

   private void updateTransaksi() {
    try {
        String sql = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(cbkaryawan.getSelectedItem().toString());
        int idProyek = getSelectedId(cbproyek.getSelectedItem().toString());
        
        ps.setString(1, tf_peran.getText());
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
    tf_id.setText("");
    tf_nama.setText("");
    tf_jabatan.setText("");
    tf_departemen.setText("");
}

private void clearProyekFields() {
    tf_id2.setText("");
    tf_namaproyek.setText("");
    tf_durasi.setText("");
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Proyek = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_nama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_jabatan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_departemen = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        btntambah = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        tf_id2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        tf_namaproyek = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tf_durasi = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        btntambah1 = new javax.swing.JButton();
        btnupdate1 = new javax.swing.JButton();
        btnhapus1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        btntambah2 = new javax.swing.JButton();
        btnupdate2 = new javax.swing.JButton();
        btnhapus2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbkaryawan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbproyek = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tf_peran = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 217, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Proyek.setBackground(new java.awt.Color(255, 188, 200));

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel8.setPreferredSize(new java.awt.Dimension(612, 330));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel8.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 520, 280));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Downloads\\kupu-kupu.jpg")); // NOI18N
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 340));

        jPanel2.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        jPanel10.setBackground(new java.awt.Color(255, 214, 234));
        jPanel10.setPreferredSize(new java.awt.Dimension(673, 260));
        jPanel10.setLayout(new java.awt.GridLayout(4, 2, 0, 15));

        jLabel1.setText("             ID");
        jPanel10.add(jLabel1);
        jPanel10.add(tf_id);

        jLabel2.setText("              NAMA");
        jPanel10.add(jLabel2);
        jPanel10.add(tf_nama);

        jLabel3.setText("             JABATAN");
        jPanel10.add(jLabel3);

        tf_jabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_jabatanActionPerformed(evt);
            }
        });
        jPanel10.add(tf_jabatan);

        jLabel4.setText("            DEPARTEMEN");
        jPanel10.add(jLabel4);

        tf_departemen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_departemenActionPerformed(evt);
            }
        });
        jPanel10.add(tf_departemen);

        jPanel2.add(jPanel10, java.awt.BorderLayout.PAGE_END);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(300, 30));

        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        jPanel9.add(btntambah);

        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel9.add(btnupdate);

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        jPanel9.add(btnhapus);

        jPanel2.add(jPanel9, java.awt.BorderLayout.CENTER);

        Proyek.addTab("Karyawan", jPanel2);

        jPanel6.setBackground(new java.awt.Color(255, 214, 221));

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel11.setPreferredSize(new java.awt.Dimension(612, 250));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jScrollPane2.setViewportView(tbl_proyek);

        jPanel11.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 520, 200));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Downloads\\kupu-kupu.jpg")); // NOI18N
        jPanel11.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 250));

        jPanel3.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel12.setBackground(new java.awt.Color(249, 222, 240));
        jPanel12.setPreferredSize(new java.awt.Dimension(673, 350));
        jPanel12.setLayout(new java.awt.GridLayout(3, 2));

        jLabel21.setText("         ID");
        jPanel12.add(jLabel21);

        tf_id2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_id2ActionPerformed(evt);
            }
        });
        jPanel12.add(tf_id2);

        jLabel22.setText("         NAMA PROYEK");
        jPanel12.add(jLabel22);
        jPanel12.add(tf_namaproyek);

        jLabel20.setText("        DURASI PENGERJAAN");
        jPanel12.add(jLabel20);

        tf_durasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_durasiActionPerformed(evt);
            }
        });
        jPanel12.add(tf_durasi);

        jPanel3.add(jPanel12, java.awt.BorderLayout.PAGE_END);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(673, 50));

        btntambah1.setText("Tambah");
        btntambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambah1ActionPerformed(evt);
            }
        });
        jPanel13.add(btntambah1);

        btnupdate1.setText("Update");
        btnupdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdate1ActionPerformed(evt);
            }
        });
        jPanel13.add(btnupdate1);

        btnhapus1.setText("Hapus");
        btnhapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapus1ActionPerformed(evt);
            }
        });
        jPanel13.add(btnhapus1);

        jPanel3.add(jPanel13, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Proyek.addTab("Proyek", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 204, 228));

        jPanel4.setBackground(new java.awt.Color(255, 199, 225));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel14.setPreferredSize(new java.awt.Dimension(612, 250));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbl_transaksi);

        jPanel14.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 520, 210));

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Downloads\\kupu-kupu.jpg")); // NOI18N
        jLabel12.setPreferredSize(new java.awt.Dimension(675, 250));
        jPanel14.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, -1, 300));

        jPanel4.add(jPanel14, java.awt.BorderLayout.PAGE_START);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setPreferredSize(new java.awt.Dimension(673, 50));

        btntambah2.setText("Tambah");
        btntambah2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambah2ActionPerformed(evt);
            }
        });
        jPanel16.add(btntambah2);

        btnupdate2.setText("Update");
        btnupdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdate2ActionPerformed(evt);
            }
        });
        jPanel16.add(btnupdate2);

        btnhapus2.setText("Hapus");
        btnhapus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapus2ActionPerformed(evt);
            }
        });
        jPanel16.add(btnhapus2);

        jPanel4.add(jPanel16, java.awt.BorderLayout.CENTER);

        jPanel5.setPreferredSize(new java.awt.Dimension(670, 350));
        jPanel5.setLayout(new java.awt.GridLayout(3, 2));

        jLabel5.setText("          ID KARYAWAN");
        jPanel5.add(jLabel5);

        cbkaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(cbkaryawan);

        jLabel7.setText("            ID PROYEK");
        jLabel7.setPreferredSize(new java.awt.Dimension(37, 5));
        jPanel5.add(jLabel7);

        cbproyek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(cbproyek);

        jLabel6.setText("             PERAN");
        jPanel5.add(jLabel6);
        jPanel5.add(tf_peran);

        jPanel4.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Proyek.addTab("Transaksi", jPanel7);

        jPanel1.add(Proyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 670));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_jabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_jabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_jabatanActionPerformed

    private void tf_departemenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_departemenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_departemenActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
     updateKaryawan();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
    tambahKaryawan();
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
    hapusKaryawan();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btntambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambah1ActionPerformed
    tambahProyek();
    }//GEN-LAST:event_btntambah1ActionPerformed

    private void btnupdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdate1ActionPerformed
    updateProyek();
    }//GEN-LAST:event_btnupdate1ActionPerformed

    private void btnhapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapus1ActionPerformed
    hapusProyek();
    }//GEN-LAST:event_btnhapus1ActionPerformed

    private void btnhapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapus2ActionPerformed
        hapusTransaksi();
    }//GEN-LAST:event_btnhapus2ActionPerformed

    private void btnupdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdate2ActionPerformed
        updateTransaksi();
    }//GEN-LAST:event_btnupdate2ActionPerformed

    private void btntambah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambah2ActionPerformed
        tambahTransaksi();
    }//GEN-LAST:event_btntambah2ActionPerformed

    private void tf_id2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_id2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_id2ActionPerformed

    private void tf_durasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_durasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_durasiActionPerformed

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
            java.util.logging.Logger.getLogger(apliksiManajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(apliksiManajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(apliksiManajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(apliksiManajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new apliksiManajemen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Proyek;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnhapus1;
    private javax.swing.JButton btnhapus2;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton btntambah1;
    private javax.swing.JButton btntambah2;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton btnupdate1;
    private javax.swing.JButton btnupdate2;
    private javax.swing.JComboBox<String> cbkaryawan;
    private javax.swing.JComboBox<String> cbproyek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
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
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTextField tf_departemen;
    private javax.swing.JTextField tf_durasi;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_id2;
    private javax.swing.JTextField tf_jabatan;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_namaproyek;
    private javax.swing.JTextField tf_peran;
    // End of variables declaration//GEN-END:variables
}
