/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modul5;
//Import 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//end Import
/**
 *
 * @author Citra
 */
public class ManajemenKaryawanProyek extends javax.swing.JFrame {
    //inisiasi GLobal Variable
    Connection conn;
    private DefaultTableModel model;
    private DefaultTableModel model2;
    private DefaultTableModel model3;
    private ArrayList<Integer> karyawanIds = new ArrayList<>();
    private ArrayList<Integer> proyekIds = new ArrayList<>();
    
    public ManajemenKaryawanProyek() {
        initComponents();
        conn = koneksi.getConnection();
        
        model = new DefaultTableModel();
        tbl_karyawan.setModel(model);

        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Jabatan");
        model.addColumn("Departemen");
        
        model2 = new DefaultTableModel();
        tbl_proyek.setModel(model2);
        
        model2.addColumn("ID");
        model2.addColumn("Nama Proyek");
        model2.addColumn("Durasi Pengerjaan");
        
        model3 = new DefaultTableModel();
        tbl_transaksi.setModel(model3);

        model3.addColumn("ID Karyawan");
        model3.addColumn("Nama Karyawan");
        model3.addColumn("ID Proyek");
        model3.addColumn("Nama Proyek");
        model3.addColumn("Peran");
        loadData();
        loadData2();
        loadData3();
        //loadKaryawanId();
        //loadProyekId();
        loadComboProyek();
        loadComboKaryawan();
    }
    private int getSelectedKaryawanId() {
        int selectedIndex = cb_namakaryawan.getSelectedIndex();
        return selectedIndex >= 0 ? karyawanIds.get(selectedIndex) : -1;
    }

    private int getSelectedProyekId() {
        int selectedIndex = cb_namaproyek.getSelectedIndex();
        return selectedIndex >= 0 ? proyekIds.get(selectedIndex) : -1;
    }
    
    private void loadComboKaryawan() {
        cb_namakaryawan.removeAllItems(); // Menghapus semua item di combobox
        cb_namakaryawan.addItem("- Pilih Nama Proyek -"); // Menambahkan opsi default
    
        karyawanIds.clear(); // Membersihkan daftar proyek
        karyawanIds.add(-1); // Tambahkan ID proyek dummy untuk opsi default
        

        try {
            String sql = "SELECT id, nama FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");

                karyawanIds.add(id);
                cb_namakaryawan.addItem(nama);
            }
        } catch (SQLException e) {
            System.out.println("Error loading karyawan data: " + e.getMessage());
        }
    }

    private void loadComboProyek() {
//        cb_namaproyek.removeAllItems();
//        proyekIds.clear();
        //cb_namaproyek.addItem("- Pilih Nama Proyek -");
        cb_namaproyek.removeAllItems(); // Menghapus semua item di combobox
        cb_namaproyek.addItem("- Pilih Nama Proyek -"); // Menambahkan opsi default
    
        proyekIds.clear(); // Membersihkan daftar proyek
        proyekIds.add(-1); // Tambahkan ID proyek dummy untuk opsi default

        try {
            String sql = "SELECT id, nama_proyek FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String namaProyek = rs.getString("nama_proyek");

                proyekIds.add(id);
                cb_namaproyek.addItem(namaProyek);
            }
        } catch (SQLException e) {
            System.out.println("Error loading proyek data: " + e.getMessage());
        }
    }
    
    //Load Data Tabel Karyawan
    private void loadData() {
        model.setRowCount(0);

        String sql = "SELECT * FROM karyawan";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet hasil = ps.executeQuery()) {
             
            while (hasil.next()) {
                model.addRow(new Object[]{
                    hasil.getInt("id"),
                    hasil.getString("nama"),
                    hasil.getString("jabatan"),
                    hasil.getString("departemen") // Added missing column
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Loading Data: " + e.getMessage());
        }
    }
    //end Load Data Tabel Karyawan
    
    //Load Data Tabel Proyek
    private void loadData2() {
        model2.setRowCount(0);

      try {
        String sql = "SELECT * FROM proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
           model2.addRow(new Object[]{
           rs.getInt("id"),
           rs.getString("nama_proyek"),
           rs.getString("durasi_pengerjaan")
         });
        }
        } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }
    
    //Load Data Tabel Transaksi
    private void loadData3() {
      model3.setRowCount(0);

      try {
        String sql = """
            SELECT t.id_karyawan, k.nama AS nama, 
                   t.id_proyek, p.nama_proyek, t.peran
            FROM transaksi t
            JOIN karyawan k ON t.id_karyawan = k.id
            JOIN proyek p ON t.id_proyek = p.id
        """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
           model3.addRow(new Object[]{
           rs.getString("id_karyawan"),
           rs.getString("nama"),
           rs.getString("id_proyek"),
           rs.getString("nama_proyek"),
           rs.getString("peran")
         });
        }
        } catch (SQLException e) {
         System.out.println("Error Save Datainij" + e.getMessage());
       }
    }
    
    //Simpan Data Karyawan
    private void TambahDataKaryawan() {
    if (tf_nama_karyawan.getText().isEmpty() || tf_jabatan_karyawan.getText().isEmpty() || tf_departemen_karyawan.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tolong lengkapi data karyawan!");
        return;
    }
    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menambahkan data karyawan?", "Konfirmasi Tambah", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "INSERT INTO karyawan (nama, jabatan, departemen ) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tf_nama_karyawan.getText());
            ps.setString(2, tf_jabatan_karyawan.getText());
            ps.setString(3, tf_departemen_karyawan.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
            loadData();
            loadComboKaryawan();
            resetForm();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
}
    //End Simpan Data Karyawan
    
    //Simpan Data Proyek
    private void TambahDataProyek() {
    if (tf_nama_proyek.getText().isEmpty() || tf_durasi_pengerjaan.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tolong lengkapi data proyek!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menambahkan data proyek?", "Konfirmasi Tambah", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tf_nama_proyek.getText());
            ps.setString(2, tf_durasi_pengerjaan.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
            loadData2();
            loadComboProyek();
            resetForm();
        } catch (SQLException e) {
            System.out.println("Error Save Data proyek" + e.getMessage());
        }
    }
}
    //End Simpan Data Proyek
    
    //Simpan Data Transaksi
    private void TambahDataTransaksi() {
    int karyawanId = getSelectedKaryawanId();
    int proyekId = getSelectedProyekId();
    String peran = tf_peran.getText();
    
    if (karyawanId == -1 || proyekId == -1 || peran.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Isi Terlebih Dahulu Bagian Yang Kosong!!!");
        return;
    }

    try {
        String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, karyawanId);
        ps.setInt(2, proyekId);
        ps.setString(3, peran);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
        loadData3(); 
        resetForm();
        } catch (SQLException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }
    //End Simpan Data Transaksi
    //Update Data Karyawan
    private void UbahDataKaryawan() {
    if (tf_nama_karyawan.getText().isEmpty() || tf_jabatan_karyawan.getText().isEmpty() || tf_departemen_karyawan.getText().isEmpty() || tf_id_karyawan.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tolong lengkapi data karyawan yang akan diubah!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin mengubah data karyawan?", "Konfirmasi Ubah", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tf_nama_karyawan.getText());
            ps.setString(2, tf_jabatan_karyawan.getText());
            ps.setString(3, tf_departemen_karyawan.getText());
            ps.setInt(4, Integer.parseInt(tf_id_karyawan.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
            loadData();
            resetForm();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
}
    //End Update Data Karyawan
    
    //Update Data Proyek
    private void UbahDataProyek() {
    if (tf_nama_proyek.getText().isEmpty() || tf_durasi_pengerjaan.getText().isEmpty() || tf_id_proyek.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tolong lengkapi data proyek yang akan diubah!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin mengubah data proyek?", "Konfirmasi Ubah", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tf_nama_proyek.getText());
            ps.setString(2, tf_durasi_pengerjaan.getText());
            ps.setInt(3, Integer.parseInt(tf_id_proyek.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
            loadData2();
            resetForm();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
}
    //End Update Data Proyek
    
    //Update Data Transaksi
    private void UbahDataTransaksi() {
    int karyawanId = getSelectedKaryawanId();
    int proyekId = getSelectedProyekId();
    String peran = tf_peran.getText();

    if (karyawanId == -1 || proyekId == -1 || peran.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tolong lengkapi data transaksi yang akan diubah!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin mengubah data transaksi?", "Konfirmasi Ubah", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, peran);
            ps.setInt(2, karyawanId);
            ps.setInt(3, proyekId);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
                loadData3();
                resetForm();
            } else {
                JOptionPane.showMessageDialog(this, "Update Gagal");
            }
        } catch (SQLException e) {
            System.out.println("Error updating transaction: " + e.getMessage());
        }
    }
}
    //End Update Transaksi
    
    //Delete Data Karyawan
    private void HapusDataKaryawan() {
    if (tf_id_karyawan.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tolong pilih karyawan yang akan dihapus!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data karyawan?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "DELETE FROM karyawan WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(tf_id_karyawan.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
            loadData();
            resetForm();
        } catch (SQLException e) {
            System.out.println("Error deleting karyawan: " + e.getMessage());
        }
    }
}
    //End Delete Data Karyawan
    
    //Delete Data Proyek
    private void HapusDataProyek() {
    if (tf_id_proyek.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tolong pilih proyek yang akan dihapus!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data proyek?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "DELETE FROM proyek WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(tf_id_proyek.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
            loadData2();
            resetForm();
        } catch (SQLException e) {
            System.out.println("Error deleting proyek: " + e.getMessage());
        }
    }
}
    //End Delete Data Proyek
    
    //Delete Data Transaksi
    private void HapusDataTransaksi() {
    int karyawanId = getSelectedKaryawanId();
    int proyekId = getSelectedProyekId();

    if (karyawanId == -1 || proyekId == -1) {
        JOptionPane.showMessageDialog(this, "Tolong pilih transaksi yang akan dihapus!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data transaksi?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, karyawanId);
            ps.setInt(2, proyekId);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
                loadData3();
                resetForm();
            } else {
                JOptionPane.showMessageDialog(this, "Data Gagal Dihapus");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting transaction: " + e.getMessage());
        }
    }
}
    //End Delete Data Transaksi
    private void resetForm() {
    tf_nama_karyawan.setText("");
    tf_jabatan_karyawan.setText("");
    tf_departemen_karyawan.setText("");
    tf_id_karyawan.setText("");
    tf_nama_proyek.setText("");
    tf_durasi_pengerjaan.setText("");
    tf_id_proyek.setText("");
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
        PanelKaryawan = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_keluar_karyawan = new javax.swing.JButton();
        btn_tambah_karyawan = new javax.swing.JButton();
        btn_perbarui_karyawan = new javax.swing.JButton();
        btn_hapus_karyawan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tf_id_karyawan = new javax.swing.JTextField();
        tf_nama_karyawan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_jabatan_karyawan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tf_departemen_karyawan = new javax.swing.JTextField();
        PanelProyek = new javax.swing.JPanel();
        PanelKaryawan1 = new javax.swing.JPanel();
        PanelKaryawan2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btn_keluar_proyek = new javax.swing.JButton();
        btn_tambah_proyek = new javax.swing.JButton();
        btn_perbarui_proyek = new javax.swing.JButton();
        btn_hapus_proyek = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        tf_id_proyek = new javax.swing.JTextField();
        tf_nama_proyek = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tf_durasi_pengerjaan = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        PanelTransaksi = new javax.swing.JPanel();
        PanelProyek1 = new javax.swing.JPanel();
        PanelKaryawan3 = new javax.swing.JPanel();
        PanelKaryawan4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btn_keluar_trasnsaksi = new javax.swing.JButton();
        btn_tambah_transaksi = new javax.swing.JButton();
        btn_perbarui_transaksi = new javax.swing.JButton();
        btn_hapus_transaksi = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        tf_peran = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        cb_namaproyek = new javax.swing.JComboBox<>();
        cb_namakaryawan = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelKaryawan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(246, 190, 0));
        jPanel2.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(219, 219, 219));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 31)); // NOI18N
        jLabel1.setText("KARYAWAN");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 9)); // NOI18N
        jLabel3.setText("PT. Brantas Abipraya, Jawa Timur, Indonesia.");

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Citra\\Downloads\\karyawan__2_-removebg-preview.png")); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 9)); // NOI18N
        jLabel4.setText("NO. 90, Telp. 099823.");

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Citra\\Downloads\\karyawan__2_-removebg-preview.png")); // NOI18N
        jLabel5.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(56, 56, 56))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        PanelKaryawan.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        jPanel3.setBackground(new java.awt.Color(246, 190, 0));
        jPanel3.setOpaque(true);
        jPanel3.setLayout(null);

        btn_keluar_karyawan.setBackground(new java.awt.Color(211, 205, 192));
        btn_keluar_karyawan.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        btn_keluar_karyawan.setForeground(new java.awt.Color(102, 102, 102));
        btn_keluar_karyawan.setText("Keluar");
        btn_keluar_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluar_karyawanActionPerformed(evt);
            }
        });
        jPanel3.add(btn_keluar_karyawan);
        btn_keluar_karyawan.setBounds(10, 10, 80, 26);

        btn_tambah_karyawan.setBackground(new java.awt.Color(211, 205, 192));
        btn_tambah_karyawan.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        btn_tambah_karyawan.setForeground(new java.awt.Color(102, 102, 102));
        btn_tambah_karyawan.setText("Tambah");
        btn_tambah_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah_karyawanActionPerformed(evt);
            }
        });
        jPanel3.add(btn_tambah_karyawan);
        btn_tambah_karyawan.setBounds(260, 10, 80, 26);

        btn_perbarui_karyawan.setBackground(new java.awt.Color(211, 205, 192));
        btn_perbarui_karyawan.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        btn_perbarui_karyawan.setForeground(new java.awt.Color(102, 102, 102));
        btn_perbarui_karyawan.setText("Perbarui");
        btn_perbarui_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_perbarui_karyawanActionPerformed(evt);
            }
        });
        jPanel3.add(btn_perbarui_karyawan);
        btn_perbarui_karyawan.setBounds(340, 10, 80, 26);

        btn_hapus_karyawan.setBackground(new java.awt.Color(211, 205, 192));
        btn_hapus_karyawan.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        btn_hapus_karyawan.setForeground(new java.awt.Color(102, 102, 102));
        btn_hapus_karyawan.setText("Hapus");
        btn_hapus_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_karyawanActionPerformed(evt);
            }
        });
        jPanel3.add(btn_hapus_karyawan);
        btn_hapus_karyawan.setBounds(420, 10, 70, 26);

        PanelKaryawan.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 500, 40));

        jPanel1.setBackground(new java.awt.Color(211, 205, 192));
        jPanel1.setLayout(new java.awt.CardLayout());

        tbl_karyawan.setAutoCreateRowSorter(true);
        tbl_karyawan.setBackground(new java.awt.Color(251, 240, 198));
        tbl_karyawan.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        tbl_karyawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Jabatan", "Departemen"
            }
        ));
        jScrollPane2.setViewportView(tbl_karyawan);

        jPanel1.add(jScrollPane2, "card2");

        PanelKaryawan.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 500, 160));

        jPanel4.setBackground(new java.awt.Color(251, 240, 198));
        jPanel4.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel6.setText("ID");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel7.setText("Nama");

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel8.setText("Jabatan");

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel9.setText("Departemen");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_id_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_nama_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(97, 97, 97)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_jabatan_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_departemen_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(tf_jabatan_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(tf_id_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(tf_departemen_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(tf_nama_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelKaryawan.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 500, 80));

        jTabbedPane1.addTab("Karyawan", PanelKaryawan);

        PanelKaryawan1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelKaryawan2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(246, 190, 0));
        jPanel5.setOpaque(true);

        jLabel10.setBackground(new java.awt.Color(219, 219, 219));
        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 31)); // NOI18N
        jLabel10.setText("PROYEK");

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 9)); // NOI18N
        jLabel11.setText("PT. Brantas Abipraya, Jawa Timur, Indonesia.");

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 9)); // NOI18N
        jLabel13.setText("NO. 90, Telp. 099823.");

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Citra\\Downloads\\proyek__2_-removebg-preview.png")); // NOI18N
        jLabel14.setText("jLabel2");

        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\Citra\\Downloads\\proyek__2_-removebg-preview.png")); // NOI18N
        jLabel18.setText("jLabel2");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(161, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel13))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PanelKaryawan2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        jPanel6.setBackground(new java.awt.Color(246, 190, 0));
        jPanel6.setOpaque(true);
        jPanel6.setLayout(null);

        btn_keluar_proyek.setBackground(new java.awt.Color(211, 205, 192));
        btn_keluar_proyek.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        btn_keluar_proyek.setForeground(new java.awt.Color(102, 102, 102));
        btn_keluar_proyek.setText("Keluar");
        btn_keluar_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluar_proyekActionPerformed(evt);
            }
        });
        jPanel6.add(btn_keluar_proyek);
        btn_keluar_proyek.setBounds(10, 10, 80, 26);

        btn_tambah_proyek.setBackground(new java.awt.Color(211, 205, 192));
        btn_tambah_proyek.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        btn_tambah_proyek.setForeground(new java.awt.Color(102, 102, 102));
        btn_tambah_proyek.setText("Tambah");
        btn_tambah_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah_proyekActionPerformed(evt);
            }
        });
        jPanel6.add(btn_tambah_proyek);
        btn_tambah_proyek.setBounds(260, 10, 80, 26);

        btn_perbarui_proyek.setBackground(new java.awt.Color(211, 205, 192));
        btn_perbarui_proyek.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        btn_perbarui_proyek.setForeground(new java.awt.Color(102, 102, 102));
        btn_perbarui_proyek.setText("Perbarui");
        btn_perbarui_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_perbarui_proyekActionPerformed(evt);
            }
        });
        jPanel6.add(btn_perbarui_proyek);
        btn_perbarui_proyek.setBounds(340, 10, 80, 26);

        btn_hapus_proyek.setBackground(new java.awt.Color(211, 205, 192));
        btn_hapus_proyek.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        btn_hapus_proyek.setForeground(new java.awt.Color(102, 102, 102));
        btn_hapus_proyek.setText("Hapus");
        btn_hapus_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_proyekActionPerformed(evt);
            }
        });
        jPanel6.add(btn_hapus_proyek);
        btn_hapus_proyek.setBounds(420, 10, 70, 26);

        PanelKaryawan2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 500, 40));

        jPanel7.setBackground(new java.awt.Color(211, 205, 192));
        jPanel7.setLayout(new java.awt.CardLayout());

        tbl_proyek.setAutoCreateRowSorter(true);
        tbl_proyek.setBackground(new java.awt.Color(251, 240, 198));
        tbl_proyek.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        tbl_proyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nama Proyek", "Durasi Pengerjaan"
            }
        ));
        jScrollPane3.setViewportView(tbl_proyek);

        jPanel7.add(jScrollPane3, "card2");

        PanelKaryawan2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 500, 150));

        jPanel8.setBackground(new java.awt.Color(251, 240, 198));
        jPanel8.setOpaque(true);

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel15.setText("ID");

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel16.setText(" Nama Proyek");

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel17.setText("Durasi Pengerjaan");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(tf_nama_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_id_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_durasi_pengerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(tf_id_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(tf_nama_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(tf_durasi_pengerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        PanelKaryawan2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 500, 90));

        javax.swing.GroupLayout PanelProyekLayout = new javax.swing.GroupLayout(PanelProyek);
        PanelProyek.setLayout(PanelProyekLayout);
        PanelProyekLayout.setHorizontalGroup(
            PanelProyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProyekLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PanelKaryawan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PanelProyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelProyekLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelKaryawan2, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PanelProyekLayout.setVerticalGroup(
            PanelProyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProyekLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelKaryawan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(PanelProyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelProyekLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelKaryawan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Proyek", PanelProyek);

        PanelKaryawan3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelKaryawan4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(246, 190, 0));
        jPanel9.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(219, 219, 219));
        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 31)); // NOI18N
        jLabel12.setText("TRANSAKSI");

        jLabel19.setFont(new java.awt.Font("Segoe UI Semibold", 0, 9)); // NOI18N
        jLabel19.setText("PT. Brantas Abipraya, Jawa Timur, Indonesia.");

        jLabel20.setFont(new java.awt.Font("Segoe UI Semibold", 0, 9)); // NOI18N
        jLabel20.setText("NO. 90, Telp. 099823.");

        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Users\\Citra\\Downloads\\trans-removebg-preview (1).png")); // NOI18N
        jLabel21.setText("jLabel2");

        jLabel22.setIcon(new javax.swing.ImageIcon("C:\\Users\\Citra\\Downloads\\trans-removebg-preview (1).png")); // NOI18N
        jLabel22.setText("jLabel2");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap(161, Short.MAX_VALUE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PanelKaryawan4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        jPanel10.setBackground(new java.awt.Color(246, 190, 0));
        jPanel10.setOpaque(true);
        jPanel10.setLayout(null);

        btn_keluar_trasnsaksi.setBackground(new java.awt.Color(211, 205, 192));
        btn_keluar_trasnsaksi.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        btn_keluar_trasnsaksi.setForeground(new java.awt.Color(102, 102, 102));
        btn_keluar_trasnsaksi.setText("Keluar");
        btn_keluar_trasnsaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluar_trasnsaksiActionPerformed(evt);
            }
        });
        jPanel10.add(btn_keluar_trasnsaksi);
        btn_keluar_trasnsaksi.setBounds(10, 10, 80, 26);

        btn_tambah_transaksi.setBackground(new java.awt.Color(211, 205, 192));
        btn_tambah_transaksi.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        btn_tambah_transaksi.setForeground(new java.awt.Color(102, 102, 102));
        btn_tambah_transaksi.setText("Tambah");
        btn_tambah_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah_transaksiActionPerformed(evt);
            }
        });
        jPanel10.add(btn_tambah_transaksi);
        btn_tambah_transaksi.setBounds(260, 10, 80, 26);

        btn_perbarui_transaksi.setBackground(new java.awt.Color(211, 205, 192));
        btn_perbarui_transaksi.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        btn_perbarui_transaksi.setForeground(new java.awt.Color(102, 102, 102));
        btn_perbarui_transaksi.setText("Perbarui");
        btn_perbarui_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_perbarui_transaksiActionPerformed(evt);
            }
        });
        jPanel10.add(btn_perbarui_transaksi);
        btn_perbarui_transaksi.setBounds(340, 10, 80, 26);

        btn_hapus_transaksi.setBackground(new java.awt.Color(211, 205, 192));
        btn_hapus_transaksi.setFont(new java.awt.Font("Elephant", 0, 11)); // NOI18N
        btn_hapus_transaksi.setForeground(new java.awt.Color(102, 102, 102));
        btn_hapus_transaksi.setText("Hapus");
        btn_hapus_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_transaksiActionPerformed(evt);
            }
        });
        jPanel10.add(btn_hapus_transaksi);
        btn_hapus_transaksi.setBounds(420, 10, 70, 26);

        PanelKaryawan4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 500, 40));

        jPanel11.setBackground(new java.awt.Color(211, 205, 192));
        jPanel11.setLayout(new java.awt.CardLayout());

        tbl_transaksi.setAutoCreateRowSorter(true);
        tbl_transaksi.setBackground(new java.awt.Color(251, 240, 198));
        tbl_transaksi.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nama Proyek", "Durasi Pengerjaan"
            }
        ));
        jScrollPane4.setViewportView(tbl_transaksi);

        jPanel11.add(jScrollPane4, "card2");

        PanelKaryawan4.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 500, 130));

        jPanel12.setBackground(new java.awt.Color(251, 240, 198));
        jPanel12.setOpaque(true);

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel23.setText("Nama Karyawan");

        jLabel24.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel24.setText("Nama Proyek");

        jLabel25.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel25.setText("Peran");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addGap(42, 42, 42)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_namakaryawan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_namaproyek, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_peran, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(cb_namakaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cb_namaproyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(tf_peran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        PanelKaryawan4.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 500, 110));

        javax.swing.GroupLayout PanelProyek1Layout = new javax.swing.GroupLayout(PanelProyek1);
        PanelProyek1.setLayout(PanelProyek1Layout);
        PanelProyek1Layout.setHorizontalGroup(
            PanelProyek1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProyek1Layout.createSequentialGroup()
                .addGap(0, 501, Short.MAX_VALUE)
                .addComponent(PanelKaryawan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PanelProyek1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelProyek1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelKaryawan4, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PanelProyek1Layout.setVerticalGroup(
            PanelProyek1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProyek1Layout.createSequentialGroup()
                .addContainerGap(354, Short.MAX_VALUE)
                .addComponent(PanelKaryawan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(PanelProyek1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelProyek1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelKaryawan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout PanelTransaksiLayout = new javax.swing.GroupLayout(PanelTransaksi);
        PanelTransaksi.setLayout(PanelTransaksiLayout);
        PanelTransaksiLayout.setHorizontalGroup(
            PanelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
            .addGroup(PanelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelTransaksiLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelProyek1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PanelTransaksiLayout.setVerticalGroup(
            PanelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
            .addGroup(PanelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelTransaksiLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelProyek1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Transaksi", PanelTransaksi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambah_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah_karyawanActionPerformed
        // TODO add your handling code here:
        TambahDataKaryawan();
    }//GEN-LAST:event_btn_tambah_karyawanActionPerformed

    private void btn_perbarui_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perbarui_karyawanActionPerformed
        // TODO add your handling code here:
        UbahDataKaryawan();
    }//GEN-LAST:event_btn_perbarui_karyawanActionPerformed

    private void btn_hapus_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_karyawanActionPerformed
        // TODO add your handling code here:
        HapusDataKaryawan();
    }//GEN-LAST:event_btn_hapus_karyawanActionPerformed

    private void btn_tambah_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah_proyekActionPerformed
        // TODO add your handling code here:
        TambahDataProyek();
    }//GEN-LAST:event_btn_tambah_proyekActionPerformed

    private void btn_perbarui_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perbarui_proyekActionPerformed
        // TODO add your handling code here:
        UbahDataProyek();
    }//GEN-LAST:event_btn_perbarui_proyekActionPerformed

    private void btn_hapus_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_proyekActionPerformed
        // TODO add your handling code here:
        HapusDataProyek();
    }//GEN-LAST:event_btn_hapus_proyekActionPerformed

    private void btn_keluar_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluar_karyawanActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_keluar_karyawanActionPerformed

    private void btn_keluar_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluar_proyekActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_keluar_proyekActionPerformed

    private void btn_keluar_trasnsaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluar_trasnsaksiActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_keluar_trasnsaksiActionPerformed

    private void btn_tambah_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah_transaksiActionPerformed
        // TODO add your handling code here:
        TambahDataTransaksi();
    }//GEN-LAST:event_btn_tambah_transaksiActionPerformed

    private void btn_perbarui_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perbarui_transaksiActionPerformed
        // TODO add your handling code here:
        UbahDataTransaksi();
    }//GEN-LAST:event_btn_perbarui_transaksiActionPerformed

    private void btn_hapus_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_transaksiActionPerformed
        // TODO add your handling code here:
        HapusDataTransaksi();
    }//GEN-LAST:event_btn_hapus_transaksiActionPerformed

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
            java.util.logging.Logger.getLogger(ManajemenKaryawanProyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManajemenKaryawanProyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManajemenKaryawanProyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManajemenKaryawanProyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManajemenKaryawanProyek().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelKaryawan;
    private javax.swing.JPanel PanelKaryawan1;
    private javax.swing.JPanel PanelKaryawan2;
    private javax.swing.JPanel PanelKaryawan3;
    private javax.swing.JPanel PanelKaryawan4;
    private javax.swing.JPanel PanelProyek;
    private javax.swing.JPanel PanelProyek1;
    private javax.swing.JPanel PanelTransaksi;
    private javax.swing.JButton btn_hapus_karyawan;
    private javax.swing.JButton btn_hapus_proyek;
    private javax.swing.JButton btn_hapus_transaksi;
    private javax.swing.JButton btn_keluar_karyawan;
    private javax.swing.JButton btn_keluar_proyek;
    private javax.swing.JButton btn_keluar_trasnsaksi;
    private javax.swing.JButton btn_perbarui_karyawan;
    private javax.swing.JButton btn_perbarui_proyek;
    private javax.swing.JButton btn_perbarui_transaksi;
    private javax.swing.JButton btn_tambah_karyawan;
    private javax.swing.JButton btn_tambah_proyek;
    private javax.swing.JButton btn_tambah_transaksi;
    private javax.swing.JComboBox<String> cb_namakaryawan;
    private javax.swing.JComboBox<String> cb_namaproyek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTextField tf_departemen_karyawan;
    private javax.swing.JTextField tf_durasi_pengerjaan;
    private javax.swing.JTextField tf_id_karyawan;
    private javax.swing.JTextField tf_id_proyek;
    private javax.swing.JTextField tf_jabatan_karyawan;
    private javax.swing.JTextField tf_nama_karyawan;
    private javax.swing.JTextField tf_nama_proyek;
    private javax.swing.JTextField tf_peran;
    // End of variables declaration//GEN-END:variables
}
