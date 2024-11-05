/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package manajemen;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Bekerja extends javax.swing.JFrame {
    Connection conn;
    private DefaultTableModel modelKaryawan;
    private DefaultTableModel modelProyek;
    private DefaultTableModel modelTransaksi;

    public Bekerja() {
        initComponents();
        conn = koneksi.getConnection();

        initTableModels();
        loadDataKaryawan();
        loadDataProyek();
        loadDataTransaksi();
        loadComboBoxKaryawan();
        loadComboBoxProyek();
        clearTransaksiFields();
       

        clearTransaksiFields();
    }

    private void initTableModels() {
        modelKaryawan = new DefaultTableModel(new String[] { "ID", "Nama", "Jabatan", "Departemen" }, 0);
        tbl_karyawan.setModel(modelKaryawan);

        modelProyek = new DefaultTableModel(new String[] { "ID", "Nama Proyek", "Pengerjaan Mingguan" }, 0);
        tbl_proyek.setModel(modelProyek);

        modelTransaksi = new DefaultTableModel(new String[] { "Nama Karyawan", "Peran",  "Nama Proyek", "Durasi Kerja Mingguan" }, 0);
        tbl_transaksi.setModel(modelTransaksi);
    }

    private void loadDataKaryawan() {
        modelKaryawan.setRowCount(0);
        try {
            String sql = "SELECT * FROM tb_karyawan";
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
                String sql = "SELECT * FROM tb_proyek";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    modelProyek.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("nama_proyek"),
                        rs.getInt("durasi_pengerjaan") // Pastikan mengambil sebagai int
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
                             "k.nama AS nama_karyawan, p.nama_proyek AS nama_proyek, " +
                             "p.durasi_pengerjaan " +
                             "FROM tb_transaksi t " +
                             "JOIN tb_karyawan k ON t.id_karyawan = k.id " +
                             "JOIN tb_proyek p ON t.id_proyek = p.id";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    modelTransaksi.addRow(new Object[]{
                        rs.getString("nama_karyawan"),
                        rs.getString("peran"),
                        rs.getString("nama_proyek"),
                        rs.getInt("durasi_pengerjaan")
                    });
                }
            } catch (SQLException e) {
                System.out.println("Error Load Data Transaksi: " + e.getMessage());
                JOptionPane.showMessageDialog(this, "Gagal memuat data transaksi: " + e.getMessage());
            }
        }
        
    private void tambahKaryawan() {
        if (tf_nmkaryawan.getText().trim().isEmpty() || 
        tf_jbtkaryawan.getText().trim().isEmpty() || 
        tf_dptkaryawan.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua field harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; // Hentikan eksekusi jika ada field yang kosong
    }
        PreparedStatement ps = null;
        try {
        String sql = "INSERT INTO tb_karyawan (nama, jabatan, departemen) VALUES (?, ?, ?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, tf_nmkaryawan.getText().trim());
        ps.setString(2, tf_jbtkaryawan.getText().trim());
        ps.setString(3, tf_dptkaryawan.getText().trim());

        int affectedRows = ps.executeUpdate(); 
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(this, "Data Karyawan berhasil ditambahkan.");
            loadDataKaryawan();
            clearKaryawanFields();
            loadComboBoxKaryawan();
            clearTransaksiFields();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menambahkan data karyawan.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Kesalahan saat menambah Data Karyawan: " + e.getMessage(), 
                                      "Kesalahan", JOptionPane.ERROR_MESSAGE);
    } finally {
        
        try {
            if (ps != null) ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Kesalahan saat menutup PreparedStatement: " + e.getMessage(), 
                                          "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    private void updateKaryawan() {
    // Validasi ID Karyawan
    if (id_karyawan.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "ID Karyawan harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; // Hentikan eksekusi jika ID kosong
    }

    int id;
    try {
        id = Integer.parseInt(id_karyawan.getText().trim()); 
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID Karyawan tidak valid.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        return; 
    }

    
    if (tf_nmkaryawan.getText().trim().isEmpty() || 
        tf_jbtkaryawan.getText().trim().isEmpty() || 
        tf_dptkaryawan.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua field harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; 
    }

    PreparedStatement ps = null; 
    try {
        String sql = "UPDATE tb_karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, tf_nmkaryawan.getText().trim());
        ps.setString(2, tf_jbtkaryawan.getText().trim());
        ps.setString(3, tf_dptkaryawan.getText().trim());
        ps.setInt(4, id);

        int affectedRows = ps.executeUpdate(); 
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(this, "Data Karyawan berhasil diupdate.");
            loadDataKaryawan();
            clearKaryawanFields();
            loadComboBoxKaryawan();
            clearTransaksiFields();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal memperbarui data karyawan. ID tidak ditemukan.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Kesalahan saat memperbarui Data Karyawan: " + e.getMessage(), 
                                      "Kesalahan", JOptionPane.ERROR_MESSAGE);
    } finally {
        
        try {
            if (ps != null) ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Kesalahan saat menutup PreparedStatement: " + e.getMessage(), 
                                          "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
}


    private void hapusKaryawan() {
    try {
        int id = Integer.parseInt(id_karyawan.getText()); 
        String sql = "DELETE FROM tb_karyawan WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Karyawan berhasil dihapus.");
        loadDataKaryawan();
        clearKaryawanFields();
        loadComboBoxKaryawan();
        clearTransaksiFields();
    } catch (SQLException e) {
        System.out.println("Error Hapus Data Karyawan: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID tidak valid");
    }
    loadComboBoxKaryawan();
}

    private void tambahProyek() {

    try {
        String sql = "INSERT INTO tb_proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_nmproyek.getText());  
        ps.setString(2, tf_dpproyek.getText()); 
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Proyek berhasil ditambahkan.");
        loadDataProyek();
        clearProyekFields(); 
        loadComboBoxProyek();
        clearTransaksiFields();
    } catch (SQLException e) {
        System.out.println("Error Tambah Data Proyek: " + e.getMessage());
    }
}
    private void updateProyek() {
         if (id_proyek.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "ID proyek tidak boleh kosong.", 
                                      "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; 
    }
    try {
        int id = Integer.parseInt(id_proyek.getText()); 
        String sql = "UPDATE tb_proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_nmproyek.getText()); 
        ps.setString(2, tf_dpproyek.getText());  
        ps.setInt(3, id);
        
        
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Proyek berhasil diupdate.");
        loadDataProyek();
        clearProyekFields();  
        loadComboBoxProyek();
        clearTransaksiFields();
    } catch (SQLException e) {
        System.out.println("Error Update Data Proyek: " + e.getMessage());
    }
}
    private void hapusProyek() {
    try {
        int id = Integer.parseInt(id_proyek.getText()); 

        DefaultTableModel model = (DefaultTableModel) tbl_proyek.getModel();
        
        for (int i = 0; i < model.getRowCount(); i++) {
            int tableId = (int) model.getValueAt(i, 0); 
            if (tableId == id) {
                // Hapus dari database
                String sqlDelete = "DELETE FROM tb_proyek WHERE id = ?";
                PreparedStatement psDelete = conn.prepareStatement(sqlDelete);
                psDelete.setInt(1, id);
                psDelete.executeUpdate();
                
                // Hapus baris dari tabel GUI
                model.removeRow(i); 
                JOptionPane.showMessageDialog(this, "Data Proyek berhasil dihapus dari tabel dan database.");
                loadDataProyek();
                clearProyekFields();
                loadComboBoxProyek();
                clearTransaksiFields();
 
                clearProyekFields();
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Data Proyek tidak ditemukan di tabel.");
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID tidak valid");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error menghapus data: " + e.getMessage());
    }
}
    
    private void loadComboBoxKaryawan() {
    cmb_karyawan.removeAllItems();
    try {
        String sql = "SELECT id, nama, jabatan, departemen FROM tb_karyawan";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String tampilan = String.format("ID: %d - %s (%s, %s)", 
                rs.getInt("id"),
                rs.getString("nama"),
                rs.getString("jabatan"),
                rs.getString("departemen")
            );
            cmb_karyawan.addItem(tampilan);
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Memuat Data Karyawan: " + e.getMessage());
    }
}

    private void loadComboBoxProyek() {
    cmb_proyek.removeAllItems();
    try {
        String sql = "SELECT id, nama_proyek, durasi_pengerjaan FROM tb_proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String tampilan = String.format("ID: %d - %s (%s)", 
                rs.getInt("id"),
                rs.getString("nama_proyek"),
                rs.getString("durasi_pengerjaan")
            );
            cmb_proyek.addItem(tampilan);
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
                if (cmb_karyawan.getSelectedItem() == null || cmb_proyek.getSelectedItem() == null || tf_perantransaksi.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Pilih karyawan, proyek, dan isi peran terlebih dahulu");
                    return;
                }

                String sql = "INSERT INTO tb_transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);

                int idKaryawan = getSelectedId(cmb_karyawan.getSelectedItem().toString());
                int idProyek = getSelectedId(cmb_proyek.getSelectedItem().toString());

                ps.setInt(1, idKaryawan);
                ps.setInt(2, idProyek);
                ps.setString(3, tf_perantransaksi.getText().trim());

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

        private void updateTransaksi() {
                if (tf_perantransaksi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Peran tidak boleh kosong.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; 
        }
               PreparedStatement ps = null; 
    try {
        String sql = "UPDATE tb_transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
        ps = conn.prepareStatement(sql);

        int idKaryawan = getSelectedId(cmb_karyawan.getSelectedItem().toString());
        int idProyek = getSelectedId(cmb_proyek.getSelectedItem().toString());

        ps.setString(1, tf_perantransaksi.getText().trim());
        ps.setInt(2, idKaryawan);
        ps.setInt(3, idProyek);

        int affectedRows = ps.executeUpdate(); 
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(this, "Data Transaksi berhasil diperbarui");
            loadDataTransaksi();
            clearTransaksiFields();
        } else {
            JOptionPane.showMessageDialog(this, "Tidak ada data transaksi yang diperbarui. Pastikan ID karyawan dan proyek benar.", 
                                          "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Kesalahan Memperbarui Data Transaksi: " + e.getMessage(), 
                                      "Kesalahan", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (ps != null) ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Kesalahan saat menutup PreparedStatement: " + e.getMessage(), 
                                          "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    }

    private void hapusTransaksi() {
    // Memastikan ComboBox tidak kosong
    if (cmb_karyawan.getSelectedItem() == null || cmb_proyek.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Silakan pilih karyawan dan proyek sebelum menghapus transaksi.", 
                                      "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    PreparedStatement ps = null; 
    try {
        String sql = "DELETE FROM tb_transaksi WHERE id_karyawan = ? AND id_proyek = ?";
        ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(cmb_karyawan.getSelectedItem().toString());
        int idProyek = getSelectedId(cmb_proyek.getSelectedItem().toString());
        
        ps.setInt(1, idKaryawan);
        ps.setInt(2, idProyek);
        
        int affectedRows = ps.executeUpdate(); 
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(this, "Data Transaksi berhasil dihapus.");
            loadDataTransaksi();
            clearTransaksiFields();
        } else {
            JOptionPane.showMessageDialog(this, "Tidak ada transaksi yang dihapus. Pastikan ID karyawan dan proyek benar.", 
                                          "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Kesalahan Menghapus Data Transaksi: " + e.getMessage(), 
                                      "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (ps != null) ps.close();
        } catch (SQLException e) {
            System.out.println("Kesalahan saat menutup PreparedStatement: " + e.getMessage());
        }
    }
}

    private void clearKaryawanFields() {
        id_karyawan.setText("");
        tf_nmkaryawan.setText("");
        tf_jbtkaryawan.setText("");
        tf_dptkaryawan.setText("");
    }

    private void clearProyekFields() {
        id_proyek.setText("");
        tf_nmproyek.setText("");
        tf_dpproyek.setText("");
    }
    
    private void clearTransaksiFields() {
        cmb_karyawan.setSelectedIndex(-1);
        cmb_proyek.setSelectedIndex(-1);
        tf_perantransaksi.setText("");
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
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        id_karyawan = new javax.swing.JTextField();
        tf_nmkaryawan = new javax.swing.JTextField();
        tf_jbtkaryawan = new javax.swing.JTextField();
        tf_dptkaryawan = new javax.swing.JTextField();
        btn_crkaryawan = new javax.swing.JButton();
        btn_upkaryawan = new javax.swing.JButton();
        btn_delkaryawan = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        id_proyek = new javax.swing.JTextField();
        tf_nmproyek = new javax.swing.JTextField();
        tf_dpproyek = new javax.swing.JTextField();
        btn_crproyek = new javax.swing.JButton();
        btn_upproyek = new javax.swing.JButton();
        btn_delproyek = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        tf_perantransaksi = new javax.swing.JTextField();
        btn_crtransaksi = new javax.swing.JButton();
        btn_uptransaksi = new javax.swing.JButton();
        btn_deltransaksi = new javax.swing.JButton();
        cmb_karyawan = new javax.swing.JComboBox<>();
        cmb_proyek = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(0, 153, 204));
        jPanel6.setToolTipText("");
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel11.setFont(new java.awt.Font("Montserrat SemiBold", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 0);
        jPanel6.add(jLabel11, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("Montserrat SemiBold", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Nama");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 0);
        jPanel6.add(jLabel12, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Montserrat SemiBold", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Jabatan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 0);
        jPanel6.add(jLabel13, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Montserrat SemiBold", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Departemen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 0);
        jPanel6.add(jLabel14, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 35, 6, 0);
        jPanel6.add(id_karyawan, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 35, 6, 0);
        jPanel6.add(tf_nmkaryawan, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 35, 6, 0);
        jPanel6.add(tf_jbtkaryawan, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 35, 6, 0);
        jPanel6.add(tf_dptkaryawan, gridBagConstraints);

        btn_crkaryawan.setText("Create");
        btn_crkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crkaryawanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 35, 20, 0);
        jPanel6.add(btn_crkaryawan, gridBagConstraints);

        btn_upkaryawan.setText("Update");
        btn_upkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_upkaryawanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 35, 20, 0);
        jPanel6.add(btn_upkaryawan, gridBagConstraints);

        btn_delkaryawan.setText("Delete");
        btn_delkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delkaryawanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 35, 20, 0);
        jPanel6.add(btn_delkaryawan, gridBagConstraints);

        jPanel8.setBackground(new java.awt.Color(0, 153, 204));
        jPanel8.setLayout(new java.awt.BorderLayout(5, 10));

        jLabel8.setFont(new java.awt.Font("Montserrat SemiBold", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("TABEL KARYAWAN");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel8.add(jLabel8, java.awt.BorderLayout.PAGE_START);

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
        tbl_karyawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_karyawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_karyawan);

        jPanel8.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel9.setBackground(new java.awt.Color(0, 153, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(new javax.swing.ImageIcon("C:\\Users\\123\\Downloads\\ini icon\\image1-2.png")), "JUDULNYA APA INI", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Montserrat SemiBold", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tab. KARYAWAN");
        jPanel9.add(jLabel1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Karyawan", jPanel1);

        jPanel10.setBackground(new java.awt.Color(0, 153, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(new javax.swing.ImageIcon("C:\\Users\\123\\Downloads\\ini icon\\image1-2.png")), "JUDULNYA APA INI", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Montserrat SemiBold", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tab. PROYEK");
        jPanel10.add(jLabel2);

        jPanel7.setBackground(new java.awt.Color(0, 153, 204));
        jPanel7.setToolTipText("");
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel15.setFont(new java.awt.Font("Montserrat SemiBold", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 0);
        jPanel7.add(jLabel15, gridBagConstraints);

        jLabel16.setFont(new java.awt.Font("Montserrat SemiBold", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Nama Proyek");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 0);
        jPanel7.add(jLabel16, gridBagConstraints);

        jLabel17.setFont(new java.awt.Font("Montserrat SemiBold", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Minggu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        jPanel7.add(jLabel17, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 35, 6, 0);
        jPanel7.add(id_proyek, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 35, 6, 0);
        jPanel7.add(tf_nmproyek, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 35, 6, 0);
        jPanel7.add(tf_dpproyek, gridBagConstraints);

        btn_crproyek.setText("Create");
        btn_crproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crproyekActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 35, 20, 0);
        jPanel7.add(btn_crproyek, gridBagConstraints);

        btn_upproyek.setText("Update");
        btn_upproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_upproyekActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 35, 20, 0);
        jPanel7.add(btn_upproyek, gridBagConstraints);

        btn_delproyek.setText("Delete");
        btn_delproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delproyekActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 35, 20, 0);
        jPanel7.add(btn_delproyek, gridBagConstraints);

        jLabel18.setFont(new java.awt.Font("Montserrat SemiBold", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Durasi Pengerjaan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 0);
        jPanel7.add(jLabel18, gridBagConstraints);

        jPanel12.setBackground(new java.awt.Color(0, 153, 204));
        jPanel12.setLayout(new java.awt.BorderLayout(5, 10));

        jLabel9.setFont(new java.awt.Font("Montserrat SemiBold", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("TABEL KARYAWAN");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel12.add(jLabel9, java.awt.BorderLayout.PAGE_START);

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
        tbl_proyek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_proyekMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_proyek);

        jPanel12.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGap(0, 509, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGap(0, 198, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Proyek", jPanel2);

        jPanel11.setBackground(new java.awt.Color(0, 153, 204));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(new javax.swing.ImageIcon("C:\\Users\\123\\Downloads\\ini icon\\image1-2.png")), "JUDULNYA APA INI", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Montserrat SemiBold", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel11.setForeground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        jLabel3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tab. TRANSAKSI");
        jPanel11.add(jLabel3);

        jPanel14.setBackground(new java.awt.Color(0, 153, 204));
        jPanel14.setToolTipText("");
        jPanel14.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 30, 15, 0);
        jPanel14.add(tf_perantransaksi, gridBagConstraints);

        btn_crtransaksi.setText("Create");
        btn_crtransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crtransaksiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 30, 15, 0);
        jPanel14.add(btn_crtransaksi, gridBagConstraints);

        btn_uptransaksi.setText("Update");
        btn_uptransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_uptransaksiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 30, 15, 0);
        jPanel14.add(btn_uptransaksi, gridBagConstraints);

        btn_deltransaksi.setText("Delete");
        btn_deltransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deltransaksiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 30, 15, 0);
        jPanel14.add(btn_deltransaksi, gridBagConstraints);

        cmb_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_karyawanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 30, 15, 0);
        jPanel14.add(cmb_karyawan, gridBagConstraints);

        cmb_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_proyekActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 30, 15, 0);
        jPanel14.add(cmb_proyek, gridBagConstraints);

        jLabel22.setFont(new java.awt.Font("Montserrat SemiBold", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Proyek");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel14.add(jLabel22, gridBagConstraints);

        jLabel23.setFont(new java.awt.Font("Montserrat SemiBold", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Peran");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 15, 0);
        jPanel14.add(jLabel23, gridBagConstraints);

        jLabel24.setFont(new java.awt.Font("Montserrat SemiBold", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Karyawan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel14.add(jLabel24, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));
        jPanel4.setLayout(new java.awt.BorderLayout(5, 10));

        jLabel4.setFont(new java.awt.Font("Montserrat SemiBold", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TABEL TRANSAKSI");
        jPanel4.add(jLabel4, java.awt.BorderLayout.PAGE_START);

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
        tbl_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_transaksiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_transaksi);

        jPanel4.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Transaksi", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_crkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crkaryawanActionPerformed
        tambahKaryawan();
    }//GEN-LAST:event_btn_crkaryawanActionPerformed

    private void btn_upkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_upkaryawanActionPerformed
        updateKaryawan();
    }//GEN-LAST:event_btn_upkaryawanActionPerformed

    private void btn_delkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delkaryawanActionPerformed
        hapusKaryawan();
    }//GEN-LAST:event_btn_delkaryawanActionPerformed

    private void btn_crtransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crtransaksiActionPerformed
        tambahTransaksi();
    }//GEN-LAST:event_btn_crtransaksiActionPerformed

    private void btn_uptransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uptransaksiActionPerformed
        updateTransaksi();
    }//GEN-LAST:event_btn_uptransaksiActionPerformed

    private void btn_deltransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deltransaksiActionPerformed
        hapusTransaksi();
        
    }//GEN-LAST:event_btn_deltransaksiActionPerformed

    private void cmb_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_karyawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_karyawanActionPerformed

    private void btn_crproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crproyekActionPerformed
        tambahProyek();
    }//GEN-LAST:event_btn_crproyekActionPerformed

    private void btn_upproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_upproyekActionPerformed
        updateProyek();
    }//GEN-LAST:event_btn_upproyekActionPerformed

    private void btn_delproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delproyekActionPerformed
        hapusProyek();
    }//GEN-LAST:event_btn_delproyekActionPerformed

    private void cmb_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_proyekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_proyekActionPerformed

    private void tbl_karyawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_karyawanMouseClicked
    int selectedRow = tbl_karyawan.getSelectedRow();
    if (selectedRow != -1) {
        id_karyawan.setText(modelKaryawan.getValueAt(selectedRow, 0).toString());
        tf_nmkaryawan.setText(modelKaryawan.getValueAt(selectedRow, 1).toString());
        tf_jbtkaryawan.setText(modelKaryawan.getValueAt(selectedRow, 2).toString());
        tf_dptkaryawan.setText(modelKaryawan.getValueAt(selectedRow, 3).toString());
    }
    }//GEN-LAST:event_tbl_karyawanMouseClicked

    private void tbl_proyekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_proyekMouseClicked
    int selectedRow = tbl_proyek.getSelectedRow();
    if (selectedRow != -1) {
        id_proyek.setText(modelProyek.getValueAt(selectedRow, 0).toString());
        tf_nmproyek.setText(modelProyek.getValueAt(selectedRow, 1).toString());
        tf_dpproyek.setText(modelProyek.getValueAt(selectedRow, 2).toString());
    }
    }//GEN-LAST:event_tbl_proyekMouseClicked

    private void tbl_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_transaksiMouseClicked
    int selectedRow = tbl_transaksi.getSelectedRow();
    if (selectedRow != -1) {
        String namaKaryawan = modelTransaksi.getValueAt(selectedRow, 0).toString();
        String peran = modelTransaksi.getValueAt(selectedRow, 1).toString();
        String namaProyek = modelTransaksi.getValueAt(selectedRow, 2).toString();
        
        // Menemukan item di ComboBox berdasarkan nama
        for (int i = 0; i < cmb_karyawan.getItemCount(); i++) {
            if (cmb_karyawan.getItemAt(i).contains(namaKaryawan)) {
                cmb_karyawan.setSelectedIndex(i);
                break;
            }
        }
        
        for (int i = 0; i < cmb_proyek.getItemCount(); i++) {
            if (cmb_proyek.getItemAt(i).contains(namaProyek)) {
                cmb_proyek.setSelectedIndex(i);
                break;
            }
        }
        
        tf_perantransaksi.setText(peran);
    }
    }//GEN-LAST:event_tbl_transaksiMouseClicked

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
            java.util.logging.Logger.getLogger(Bekerja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bekerja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bekerja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bekerja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bekerja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_crkaryawan;
    private javax.swing.JButton btn_crproyek;
    private javax.swing.JButton btn_crtransaksi;
    private javax.swing.JButton btn_delkaryawan;
    private javax.swing.JButton btn_delproyek;
    private javax.swing.JButton btn_deltransaksi;
    private javax.swing.JButton btn_upkaryawan;
    private javax.swing.JButton btn_upproyek;
    private javax.swing.JButton btn_uptransaksi;
    private javax.swing.JComboBox<String> cmb_karyawan;
    private javax.swing.JComboBox<String> cmb_proyek;
    private javax.swing.JTextField id_karyawan;
    private javax.swing.JTextField id_proyek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTextField tf_dpproyek;
    private javax.swing.JTextField tf_dptkaryawan;
    private javax.swing.JTextField tf_jbtkaryawan;
    private javax.swing.JTextField tf_nmkaryawan;
    private javax.swing.JTextField tf_nmproyek;
    private javax.swing.JTextField tf_perantransaksi;
    // End of variables declaration//GEN-END:variables
}
