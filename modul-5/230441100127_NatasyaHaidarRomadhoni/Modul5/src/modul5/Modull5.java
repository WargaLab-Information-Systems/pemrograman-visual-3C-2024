/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modul5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author natas
 */
public class Modull5 extends javax.swing.JFrame {

    Connection conn;
    private DefaultTableModel modelKaryawan;
    private DefaultTableModel modelProyek;
    private DefaultTableModel modelTransaksi;

    public Modull5() {
        initComponents();
        conn = Koneksi.getConnection();

        // Model tabel Karyawan
        modelKaryawan = new DefaultTableModel();
        tbl_karyawan.setModel(modelKaryawan);
        modelKaryawan.addColumn("ID Karyawan");
        modelKaryawan.addColumn("Nama");
        modelKaryawan.addColumn("Jabatan");
        modelKaryawan.addColumn("Departemen");

        // Model tabel Proyek
        modelProyek = new DefaultTableModel();
        tbl_proyek.setModel(modelProyek);
        modelProyek.addColumn("ID Proyek");
        modelProyek.addColumn("Nama Proyek");
        modelProyek.addColumn("Tanggal Mulai");
        modelProyek.addColumn("Tanggal Selesai");
        modelProyek.addColumn("Durasi Minggu");

        // Model tabel Transaksi Proyek
        modelTransaksi = new DefaultTableModel();
        tbl_transaksi.setModel(modelTransaksi);
        modelTransaksi.addColumn("ID Transaksi");
        modelTransaksi.addColumn("Nama Karyawan");
        modelTransaksi.addColumn("Nama Proyek");
        modelTransaksi.addColumn("Peran");

        loadDataKaryawan();
        loadDataProyek();
        loadDataTransaksi();
        loadComboBoxData();
       
    }

    private void loadDataKaryawan() {
        modelKaryawan.setRowCount(0);
        try {
            String sql = "SELECT * FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelKaryawan.addRow(new Object[]{
                    rs.getInt("id_karyawan"),
                    rs.getString("nama_karyawan"),
                    rs.getString("jabatan"),
                    rs.getString("departemen")
                });
            }
            updateComboBoxKaryawan(); // Perbarui ComboBox setelah data karyawan dimuat
        } catch (SQLException e) {
            System.out.println("Error Load Data Karyawan: " + e.getMessage());
        }
    }


    private void saveDataKaryawan() {
        // Pastikan semua komponen input terisi sebelum menyimpan
        if (tfNamaKaryawan.getText().isEmpty() || tfJabatan.getText().isEmpty() || tfDepartemen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pastikan semua komponen telah terisi sebelum menyimpan data!", "Error", JOptionPane.ERROR_MESSAGE);;
            return;
        }

        try {
            String sql = "INSERT INTO karyawan (nama_karyawan, jabatan, departemen) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tfNamaKaryawan.getText());
            ps.setString(2, tfJabatan.getText());
            ps.setString(3, tfDepartemen.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data karyawan berhasil disimpan");
            loadDataKaryawan();
            updateComboBoxKaryawan();
            resetSemuaData(); 
        } catch (SQLException e) {
            System.out.println("Error Save Data Karyawan: " + e.getMessage());
        }
    }

    private void updateDataKaryawan() {
        // Pastikan semua komponen input terisi sebelum memperbarui
        if (tfIDKaryawan.getText().isEmpty() || tfNamaKaryawan.getText().isEmpty() || 
            tfJabatan.getText().isEmpty() || tfDepartemen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pastikan semua komponen telah terisi sebelum mengupdate data!", "Error", JOptionPane.ERROR_MESSAGE);;
            return;
        }

        try {
            String sql = "UPDATE karyawan SET nama_karyawan = ?, jabatan = ?, departemen = ? WHERE id_karyawan = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tfNamaKaryawan.getText());
            ps.setString(2, tfJabatan.getText());
            ps.setString(3, tfDepartemen.getText());
            ps.setInt(4, Integer.parseInt(tfIDKaryawan.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data karyawan berhasil diupdate");
            loadDataKaryawan();
            updateComboBoxKaryawan();
            resetSemuaData(); 
        } catch (SQLException e) {
            System.out.println("Error Update Data Karyawan: " + e.getMessage());
        }
    }


    private void deleteDataKaryawan() {
        if (tfIDKaryawan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID karyawan tidak boleh kosong!","Error", JOptionPane.ERROR_MESSAGE);;
            return;
        }
        try {
            String sql = "DELETE FROM karyawan WHERE id_karyawan = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(tfIDKaryawan.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data karyawan berhasil dihapus");
            loadDataKaryawan();
            updateComboBoxKaryawan();
            resetSemuaData(); 
        } catch (SQLException e) {
            System.out.println("Error Delete Data Karyawan: " + e.getMessage());
        }
    }

    // Fungsi untuk memuat data proyek ke dalam tabel
    private void loadDataProyek() {
        modelProyek.setRowCount(0);
        try {
            String sql = "SELECT * FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelProyek.addRow(new Object[]{
                    rs.getInt("id_proyek"),
                    rs.getString("nama_proyek"),
                    rs.getDate("tanggal_mulai"),
                    rs.getDate("tanggal_selesai"),
                    rs.getInt("durasi_minggu") // Jika durasi_minggu adalah integer
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Load Data Proyek: " + e.getMessage());
        }
    }

    // Fungsi untuk menyimpan data proyek
    private void saveDataProyek() {
        if (calenderTanggalMulai.getDate() == null || calenderTanggalSelesai.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Tanggal mulai, tanggal selesai dan peran harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "INSERT INTO proyek (nama_proyek, tanggal_mulai, tanggal_selesai, durasi_minggu) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tfNamaProyek.getText());
            ps.setDate(2, new java.sql.Date(calenderTanggalMulai.getDate().getTime()));
            ps.setDate(3, new java.sql.Date(calenderTanggalSelesai.getDate().getTime()));
            ps.setInt(4, Integer.parseInt(tfDurasiPengerjaan.getText())); // Pastikan ini adalah integer
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data proyek berhasil disimpan");
            loadDataProyek();
            updateComboBoxProyek();
            resetSemuaData(); 
        } catch (SQLException e) {
            System.out.println("Error Save Data Proyek: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Durasi harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Fungsi untuk memperbarui data proyek
    private void updateDataProyek() {
        if (tfIDProyek.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID proyek tidak boleh kosong!");
            return;
        }

        if (calenderTanggalMulai.getDate() == null || calenderTanggalSelesai.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Tanggal mulai, tanggal selesai dan durasi pengerjaan harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "UPDATE proyek SET nama_proyek = ?, tanggal_mulai = ?, tanggal_selesai = ?, durasi_minggu = ? WHERE id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tfNamaProyek.getText());
            ps.setDate(2, new java.sql.Date(calenderTanggalMulai.getDate().getTime()));
            ps.setDate(3, new java.sql.Date(calenderTanggalSelesai.getDate().getTime()));
            ps.setInt(4, Integer.parseInt(tfDurasiPengerjaan.getText()));
            ps.setInt(5, Integer.parseInt(tfIDProyek.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data proyek berhasil diupdate");
            loadDataProyek();
            updateComboBoxProyek();
            resetSemuaData(); 
        } catch (SQLException e) {
            System.out.println("Error Update Data Proyek: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Pastikan ID dan durasi berformat angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Fungsi untuk menghapus data proyek
    private void deleteDataProyek() {
        if (tfIDProyek.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID proyek tidak boleh kosong!");
            return;
        }
        try {
            String sql = "DELETE FROM proyek WHERE id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(tfIDProyek.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data proyek berhasil dihapus");
            loadDataProyek();
            updateComboBoxProyek();
            resetSemuaData(); 
        } catch (SQLException e) {
            System.out.println("Error Delete Data Proyek: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID proyek harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Memuat data ke ComboBox Karyawan dan Proyek
    private void loadComboBoxData() {
        try {
            String sql = "SELECT nama_karyawan FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cbKaryawan.removeAllItems();
            while (rs.next()) {
                cbKaryawan.addItem(rs.getString("nama_karyawan"));
            }
        } catch (SQLException e) {
            System.out.println("Error Load Karyawan: " + e.getMessage());
        }

        try {
            String sql = "SELECT nama_proyek FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cbProyek.removeAllItems();
            while (rs.next()) {
                cbProyek.addItem(rs.getString("nama_proyek"));
            }
        } catch (SQLException e) {
            System.out.println("Error Load Proyek: " + e.getMessage());
        }
    }

    // CRUD Transaksi Proyek
    private void loadDataTransaksi() {
          modelTransaksi.setRowCount(0);
          try {
              String sql = "SELECT transaksi.id_transaksi, karyawan.nama_karyawan, proyek.nama_proyek, transaksi.peran " +
                           "FROM transaksi_proyek transaksi " +
                           "JOIN karyawan ON transaksi.id_karyawan = karyawan.id_karyawan " +
                           "JOIN proyek ON transaksi.id_proyek = proyek.id_proyek";
              PreparedStatement ps = conn.prepareStatement(sql);
              ResultSet rs = ps.executeQuery();
              while (rs.next()) {
                  modelTransaksi.addRow(new Object[]{
                      rs.getInt("id_transaksi"),
                      rs.getString("nama_karyawan"),
                      rs.getString("nama_proyek"),
                      rs.getString("peran")  // Ganti int ke String
                  });
              }
          } catch (SQLException e) {
              System.out.println("Error Load Data Transaksi: " + e.getMessage());
          }
          resetSemuaData(); // Reset setelah load data
    }

    private void saveDataTransaksi() {
        // Pastikan semua komponen input terisi sebelum menyimpan
        if (tfPeran.getText().isEmpty() || getSelectedKaryawanId() == -1 || getSelectedProyekId() == -1) {
            JOptionPane.showMessageDialog(this, "Pastikan semua komponen telah terisi sebelum menyimpan data transaksi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String peran = tfPeran.getText(); // Ambil sebagai String
            String sql = "INSERT INTO transaksi_proyek (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, getSelectedKaryawanId());
            ps.setInt(2, getSelectedProyekId());
            ps.setString(3, peran); // Simpan sebagai String
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data transaksi berhasil disimpan");
            loadDataTransaksi();
        } catch (SQLException e) {
            System.out.println("Error Save Data Transaksi: " + e.getMessage());
        }
    }


    private void updateDataTransaksi() {
        // Pastikan semua input field terisi sebelum proses update
        if (tfIDTransaksi.getText().isEmpty() || tfPeran.getText().isEmpty() || 
            getSelectedKaryawanId() == -1 || getSelectedProyekId() == -1) {
            JOptionPane.showMessageDialog(this, "Pastikan semua komponen telah terisi sebelum mengedit data!", "Error", JOptionPane.ERROR_MESSAGE);;
            return;
        }

        try {
            int idKaryawan = getSelectedKaryawanId();
            int idProyek = getSelectedProyekId();
            String peran = tfPeran.getText(); // Ambil sebagai String
            int idTransaksi = Integer.parseInt(tfIDTransaksi.getText());

            String sql = "UPDATE transaksi_proyek SET id_karyawan = ?, id_proyek = ?, peran = ? WHERE id_transaksi = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idKaryawan);
            ps.setInt(2, idProyek);
            ps.setString(3, peran); // Simpan sebagai String
            ps.setInt(4, idTransaksi);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Data transaksi berhasil diupdate");
                loadDataTransaksi();
            } else {
                JOptionPane.showMessageDialog(this, "ID transaksi tidak ditemukan!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Pastikan ID berformat angka!");
        } catch (SQLException e) {
            System.out.println("Error Update Data Transaksi: " + e.getMessage());
        }
    }


    private void deleteDataTransaksi() {
            if (tfIDTransaksi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID transaksi tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int idTransaksi = Integer.parseInt(tfIDTransaksi.getText());

                String sql = "DELETE FROM transaksi_proyek WHERE id_transaksi = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, idTransaksi);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Data transaksi berhasil dihapus");
                    loadDataTransaksi();
                } else {
                    JOptionPane.showMessageDialog(this, "ID transaksi tidak ditemukan!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Pastikan ID berformat angka!");
            } catch (SQLException e) {
                System.out.println("Error Delete Data Transaksi: " + e.getMessage());
            }
    }


    private int getSelectedKaryawanId() {
        // Metode untuk mendapatkan ID karyawan berdasarkan ComboBox
        String karyawanName = (String) cbKaryawan.getSelectedItem();
        try {
            String sql = "SELECT id_karyawan FROM karyawan WHERE nama_karyawan = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, karyawanName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_karyawan");
            }
        } catch (SQLException e) {
            System.out.println("Error Get Karyawan ID: " + e.getMessage());
        }
        return -1; // Kembalikan nilai negatif jika tidak ditemukan
    }

    private int getSelectedProyekId() {
        // Metode untuk mendapatkan ID proyek berdasarkan ComboBox
        String proyekName = (String) cbProyek.getSelectedItem();
        try {
            String sql = "SELECT id_proyek FROM proyek WHERE nama_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, proyekName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_proyek");
            }
        } catch (SQLException e) {
            System.out.println("Error Get Proyek ID: " + e.getMessage());
        }
        return -1; // Kembalikan nilai negatif jika tidak ditemukan
    }
    
    private void updateComboBoxKaryawan() {
        cbKaryawan.removeAllItems(); // Hapus semua item di ComboBox terlebih dahulu
        try {
            String sql = "SELECT nama_karyawan FROM karyawan"; // Ambil data nama karyawan dari tabel karyawan
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbKaryawan.addItem(rs.getString("nama_karyawan")); // Tambahkan setiap nama karyawan ke ComboBox
            }
        } catch (SQLException e) {
            System.out.println("Error Update ComboBox Karyawan: " + e.getMessage());
        }
    }
    
    private void updateComboBoxProyek() {
            cbProyek.removeAllItems(); // Hapus semua item di ComboBox terlebih dahulu
            try {
                String sql = "SELECT nama_proyek FROM proyek"; // Ambil data nama proyek dari tabel proyek
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    cbProyek.addItem(rs.getString("nama_proyek")); // Tambahkan setiap nama proyek ke ComboBox
                }
            } catch (SQLException e) {
                System.out.println("Error Update ComboBox Proyek: " + e.getMessage());
        }
    }


    private void resetSemuaData() {
        // Tab Karyawan
        tfNamaKaryawan.setText("");
        tfJabatan.setText("");
        tfDepartemen.setText("");
        tfIDKaryawan.setText("");

        // Tab Proyek
        tfNamaProyek.setText("");
        tfIDProyek.setText("");
        tfDurasiPengerjaan.setText(""); // Reset tfDurasiPengerjaan

        // Tab Transaksi Proyek
        tfIDTransaksi.setText("");
        cbKaryawan.setSelectedIndex(-1); // Mengatur ke pilihan kosong
        cbProyek.setSelectedIndex(-1);
        tfPeran.setText("");

        // Mengosongkan semua JDateChooser
        calenderTanggalMulai.setDate(null);
        calenderTanggalSelesai.setDate(null);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNamaKaryawan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfJabatan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfDepartemen = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btnTambahKaryawan = new javax.swing.JButton();
        btnEditKaryawan = new javax.swing.JButton();
        btnHapusKaryawan = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        tfIDKaryawan = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        tfNamaProyek = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        calenderTanggalSelesai = new com.toedter.calendar.JDateChooser();
        calenderTanggalMulai = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        btnTambahProyek = new javax.swing.JButton();
        btnEditProyek = new javax.swing.JButton();
        btnHapusProyek = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        tfIDProyek = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tfDurasiPengerjaan = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbKaryawan = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbProyek = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        tfPeran = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        btnTambahTransaksi = new javax.swing.JButton();
        btnEditTransaksi = new javax.swing.JButton();
        btnHapusTransaksi = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        tfIDTransaksi = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));
        setForeground(new java.awt.Color(255, 255, 204));

        jTabbedPane1.setForeground(new java.awt.Color(102, 0, 0));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(249, 249, 223));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Nama Karyawan : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        tfNamaKaryawan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfNamaKaryawan.setForeground(new java.awt.Color(102, 0, 0));
        tfNamaKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaKaryawanActionPerformed(evt);
            }
        });
        jPanel1.add(tfNamaKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 200, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("Jabatan : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        tfJabatan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfJabatan.setForeground(new java.awt.Color(102, 0, 0));
        jPanel1.add(tfJabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 200, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("Departemen :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, -1));

        tfDepartemen.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfDepartemen.setForeground(new java.awt.Color(102, 0, 0));
        jPanel1.add(tfDepartemen, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 200, -1));

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        tbl_karyawan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbl_karyawan.setForeground(new java.awt.Color(102, 0, 0));
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

        jPanel4.add(jScrollPane1);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 390, 260));

        jPanel8.setBackground(new java.awt.Color(255, 255, 204));
        jPanel8.setForeground(new java.awt.Color(255, 255, 204));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        btnTambahKaryawan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTambahKaryawan.setForeground(new java.awt.Color(102, 0, 0));
        btnTambahKaryawan.setText("Tambah");
        btnTambahKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahKaryawanActionPerformed(evt);
            }
        });
        jPanel8.add(btnTambahKaryawan);

        btnEditKaryawan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEditKaryawan.setForeground(new java.awt.Color(102, 0, 0));
        btnEditKaryawan.setText("Edit");
        btnEditKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditKaryawanActionPerformed(evt);
            }
        });
        jPanel8.add(btnEditKaryawan);

        btnHapusKaryawan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnHapusKaryawan.setForeground(new java.awt.Color(102, 0, 0));
        btnHapusKaryawan.setText("Hapus");
        btnHapusKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusKaryawanActionPerformed(evt);
            }
        });
        jPanel8.add(btnHapusKaryawan);

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 0, 0));
        jLabel12.setText("ID Karyawan :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        tfIDKaryawan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfIDKaryawan.setForeground(new java.awt.Color(102, 0, 0));
        tfIDKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIDKaryawanActionPerformed(evt);
            }
        });
        jPanel1.add(tfIDKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 200, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5/proyek.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 700, 670));

        jTabbedPane1.addTab("Karyawan", jPanel1);

        jPanel2.setBackground(new java.awt.Color(249, 249, 223));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("Nama Proyek : ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        tbl_proyek.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
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

        jPanel6.add(jScrollPane2);

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 470, 250));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 0));
        jLabel8.setText("Tanggal Selesai :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        tfNamaProyek.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfNamaProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaProyekActionPerformed(evt);
            }
        });
        jPanel2.add(tfNamaProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 180, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 0));
        jLabel9.setText("Tanggal Mulai :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        calenderTanggalSelesai.setForeground(new java.awt.Color(102, 0, 0));
        calenderTanggalSelesai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(calenderTanggalSelesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 180, -1));

        calenderTanggalMulai.setForeground(new java.awt.Color(102, 0, 0));
        calenderTanggalMulai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(calenderTanggalMulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 180, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        btnTambahProyek.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTambahProyek.setForeground(new java.awt.Color(102, 0, 0));
        btnTambahProyek.setText("Tambah");
        btnTambahProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahProyekActionPerformed(evt);
            }
        });
        jPanel5.add(btnTambahProyek);

        btnEditProyek.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEditProyek.setForeground(new java.awt.Color(102, 0, 0));
        btnEditProyek.setText("Edit");
        btnEditProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProyekActionPerformed(evt);
            }
        });
        jPanel5.add(btnEditProyek);

        btnHapusProyek.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnHapusProyek.setForeground(new java.awt.Color(102, 0, 0));
        btnHapusProyek.setText("Hapus");
        btnHapusProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusProyekActionPerformed(evt);
            }
        });
        jPanel5.add(btnHapusProyek);

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 0));
        jLabel11.setText("ID Proyek :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        tfIDProyek.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(tfIDProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 190, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 0, 0));
        jLabel16.setText("Durasi Pengerjaan/Minggu :");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, -1));

        tfDurasiPengerjaan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfDurasiPengerjaan.setForeground(new java.awt.Color(102, 0, 0));
        jPanel2.add(tfDurasiPengerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 180, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5/proyek.png"))); // NOI18N
        jLabel14.setText("jLabel14");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 720, 670));

        jTabbedPane1.addTab("Proyek", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 0));
        jLabel5.setText("Pilih Karyawan :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        cbKaryawan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbKaryawan.setForeground(new java.awt.Color(102, 0, 0));
        jPanel3.add(cbKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 158, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 0));
        jLabel6.setText("Pilih Proyek :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

        cbProyek.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbProyek.setForeground(new java.awt.Color(102, 0, 0));
        jPanel3.add(cbProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 158, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 0));
        jLabel7.setText("Peran :");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 50, -1));

        tfPeran.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel3.add(tfPeran, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 164, -1));

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        tbl_transaksi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
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
        jScrollPane4.setViewportView(tbl_transaksi);

        jPanel9.add(jScrollPane4);

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 105, 430, 240));

        jPanel10.setBackground(new java.awt.Color(255, 255, 204));
        jPanel10.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        btnTambahTransaksi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTambahTransaksi.setForeground(new java.awt.Color(102, 0, 0));
        btnTambahTransaksi.setText("Tambah");
        btnTambahTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahTransaksiActionPerformed(evt);
            }
        });
        jPanel10.add(btnTambahTransaksi);

        btnEditTransaksi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEditTransaksi.setForeground(new java.awt.Color(102, 0, 0));
        btnEditTransaksi.setText("Edit");
        btnEditTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditTransaksiActionPerformed(evt);
            }
        });
        jPanel10.add(btnEditTransaksi);

        btnHapusTransaksi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnHapusTransaksi.setForeground(new java.awt.Color(102, 0, 0));
        btnHapusTransaksi.setText("Hapus");
        btnHapusTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusTransaksiActionPerformed(evt);
            }
        });
        jPanel10.add(btnHapusTransaksi);

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 0, 0));
        jLabel10.setText("ID Transaksi : ");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        tfIDTransaksi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tfIDTransaksi.setForeground(new java.awt.Color(102, 0, 0));
        jPanel3.add(tfIDTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 166, -1));

        jPanel7.setBackground(new java.awt.Color(249, 249, 223));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5/proyek.png"))); // NOI18N
        jLabel15.setText("jLabel15");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 680));

        jTabbedPane1.addTab("Transaksi Proyek", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahProyekActionPerformed
        saveDataProyek();
    }//GEN-LAST:event_btnTambahProyekActionPerformed

    private void btnTambahKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahKaryawanActionPerformed
        saveDataKaryawan();
    }//GEN-LAST:event_btnTambahKaryawanActionPerformed

    private void btnTambahTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahTransaksiActionPerformed
        saveDataTransaksi();
    }//GEN-LAST:event_btnTambahTransaksiActionPerformed

    private void btnEditProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProyekActionPerformed
        updateDataProyek();
    }//GEN-LAST:event_btnEditProyekActionPerformed

    private void btnEditKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditKaryawanActionPerformed
        updateDataKaryawan();
    }//GEN-LAST:event_btnEditKaryawanActionPerformed

    private void btnHapusKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusKaryawanActionPerformed
       deleteDataKaryawan();
    }//GEN-LAST:event_btnHapusKaryawanActionPerformed

    private void btnHapusProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusProyekActionPerformed
        deleteDataProyek();
    }//GEN-LAST:event_btnHapusProyekActionPerformed

    private void btnEditTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditTransaksiActionPerformed
        updateDataTransaksi();
    }//GEN-LAST:event_btnEditTransaksiActionPerformed

    private void btnHapusTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusTransaksiActionPerformed
        deleteDataTransaksi();
    }//GEN-LAST:event_btnHapusTransaksiActionPerformed

    private void tfIDKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIDKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIDKaryawanActionPerformed

    private void tfNamaKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaKaryawanActionPerformed

    private void tfNamaProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaProyekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaProyekActionPerformed

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
            java.util.logging.Logger.getLogger(Modull5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modull5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modull5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modull5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modull5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditKaryawan;
    private javax.swing.JButton btnEditProyek;
    private javax.swing.JButton btnEditTransaksi;
    private javax.swing.JButton btnHapusKaryawan;
    private javax.swing.JButton btnHapusProyek;
    private javax.swing.JButton btnHapusTransaksi;
    private javax.swing.JButton btnTambahKaryawan;
    private javax.swing.JButton btnTambahProyek;
    private javax.swing.JButton btnTambahTransaksi;
    private com.toedter.calendar.JDateChooser calenderTanggalMulai;
    private com.toedter.calendar.JDateChooser calenderTanggalSelesai;
    private javax.swing.JComboBox<String> cbKaryawan;
    private javax.swing.JComboBox<String> cbProyek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTextField tfDepartemen;
    private javax.swing.JTextField tfDurasiPengerjaan;
    private javax.swing.JTextField tfIDKaryawan;
    private javax.swing.JTextField tfIDProyek;
    private javax.swing.JTextField tfIDTransaksi;
    private javax.swing.JTextField tfJabatan;
    private javax.swing.JTextField tfNamaKaryawan;
    private javax.swing.JTextField tfNamaProyek;
    private javax.swing.JTextField tfPeran;
    // End of variables declaration//GEN-END:variables
}
