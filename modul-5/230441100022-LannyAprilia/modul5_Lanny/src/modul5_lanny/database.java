/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modul5_lanny;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lanny aprilia
 */
public class database extends javax.swing.JFrame {

    /**
     * Creates new form database
     */
    
    //inisiasi GLobal Variable
    Connection conn;
    private DefaultTableModel model;
    private DefaultTableModel model2;
    private DefaultTableModel model3;
    private Map<String, String> karyawanMap = new HashMap<>();
    private Map<String, String> proyekMap = new HashMap<>();
    //end global variable
    
    public database() {
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
        model2.addColumn("Durasi Per - Minggu");
        
        model3 = new DefaultTableModel();
        tbl_transaksi.setModel(model3);

        model3.addColumn("ID Karyawan");
        model3.addColumn("ID Proyek");
        model3.addColumn("Peran");
        
        
        loadKaryawanIDs();
        loadProyekIDs();
        
        loadData();
        loadData2();
        loadData3();
       
    }
    
    private String getSelectedKaryawanID() {
        String selectedName = (String) cmb_idkaryawan2.getSelectedItem();
        return karyawanMap.getOrDefault(selectedName, null);
    }
    private void loadKaryawanIDs() {
        cmb_idkaryawan2.removeAllItems();
        cmb_idkaryawan2.addItem("-Pilih Karyawan-");
        karyawanMap.clear();

        try {
            String sql = "SELECT id, nama FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("nama");
                cmb_idkaryawan2.addItem(name); // Tambahkan nama ke ComboBox
                karyawanMap.put(name, id);     // Simpan pasangan nama dan ID di Map
            }
        } catch (SQLException e) {
            System.out.println("Error loading karyawan IDs: " + e.getMessage());
        }
    }
    
    
        private String getSelectedProyekID() {
        String selectedName = (String) cmb_idproyek2.getSelectedItem();
        return proyekMap.getOrDefault(selectedName, null);
    }
    private void loadProyekIDs() {
        cmb_idproyek2.removeAllItems();
        cmb_idproyek2.addItem("-Pilih Karyawan-");
        proyekMap.clear();

        try {
            String sql = "SELECT id, nama_proyek FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("nama_proyek");
                cmb_idproyek2.addItem(name); 
                proyekMap.put(name, id);
            }
        } catch (SQLException e) {
            System.out.println("Error loading karyawan IDs: " + e.getMessage());
        }
    }
    
    //Load Data 1 = Karyawan
    private void loadData() {
      model.setRowCount(0);

      try {
        String sql = "SELECT * FROM karyawan";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
           model.addRow(new Object[]{
           rs.getInt("id"),
           rs.getString("nama"),
           rs.getString("jabatan"),
           rs.getString("departemen")
         });
        }
        } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }
    
    //Load Data 2 = Proyek
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
    
    //Load Data 3 = Transaksi
    private void loadData3() {
        model3.setRowCount(0);

        try {
            String sql = "SELECT t.id_karyawan, k.nama AS nama_karyawan, t.id_proyek, p.nama_proyek, t.peran " +
                         "FROM transaksi t " +
                         "JOIN karyawan k ON t.id_karyawan = k.id " +
                         "JOIN proyek p ON t.id_proyek = p.id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model3.addRow(new Object[]{
                    rs.getString("nama_karyawan"),
                    rs.getString("nama_proyek"),
                    rs.getString("peran")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error loading Data: " + e.getMessage());
        }
    }

    
    //Simpan Data Karyawan
    private void saveData() {
      try{
        if (tf_namakaryawan.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama harus diisi terlebih dahulu!");
            return; 
        }
        
        if (cmb_jabatan.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Jabatan harus dipilih terlebih dahulu!");
            return; 
        }
        
        if (cmb_departemen.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Departemen harus dipilih terlebih dahulu!");
            return; 
        }
        getSelectedKaryawanID() ;
        String cekdatasql = "SELECT COUNT(*) FROM karyawan WHERE nama = ? && jabatan = ? && departemen = ?";
        PreparedStatement checkPs = conn.prepareStatement(cekdatasql);
        checkPs.setString(1, tf_namakaryawan.getText());
        checkPs.setString(2, cmb_jabatan.getSelectedItem().toString());
        checkPs.setString(3, cmb_departemen.getSelectedItem().toString());
        ResultSet rs = checkPs.executeQuery();
        rs.next();

        if (rs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(this, "Data sudah ada di database!");
            return;
        }

        String sql = "INSERT INTO karyawan (nama, jabatan, departemen) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_namakaryawan.getText());
        ps.setString(2, cmb_jabatan.getSelectedItem().toString());
        ps.setString(3, cmb_departemen.getSelectedItem().toString());
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data saved successfully");
        loadData();
        loadKaryawanIDs();
        loadData3();
        } catch (SQLException e) {
            System.out.println("Error Save Data: " + e.getMessage());
        }
    }
    //End Simpan Data Karyawan
    
    //Simpan Data Proyek
    private void saveData2() {
      try{
        if (tf_namaproyek.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama proyek harus diisi terlebih dahulu!");
            return; 
        }
        
        if (tf_durasi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Durasi proyek harus diisi terlebih dahulu!");
            return; 
        }
        
        try {
            Integer.parseInt(tf_durasi.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Durasi proyek harus berupa angka!");
            return;
        }
        
        getSelectedProyekID();
        String cekdatasql = "SELECT COUNT(*) FROM proyek WHERE nama_proyek = ? && durasi_pengerjaan = ? ";
        PreparedStatement checkPs = conn.prepareStatement(cekdatasql);
        checkPs.setString(1, tf_namaproyek.getText());
        checkPs.setString(2, tf_durasi.getText());
        ResultSet rs = checkPs.executeQuery();
        rs.next();

        if (rs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(this, "Data sudah disimpan!");
            return;
        }

        String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_namaproyek.getText());
        ps.setString(2, tf_durasi.getText());
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data saved successfully");
        loadData2();
        loadProyekIDs();
        loadData3();
        } catch (SQLException e) {
            System.out.println("Error Save Data: " + e.getMessage());
        }
    }
    //End Simpan Data Proyek
    
    //Simpan Data Transaksi
    private void saveData3() {
      try{
        if (cmb_idkaryawan2.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "ID Karyawan harus dipilih terlebih dahulu!");
            return; 
        }
        
        if (cmb_idproyek2.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "ID Proyek harus dipilih terlebih dahulu!");
            return; 
        }
        
        if (tf_peran.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isi peran terlebih dahulu");
            return; 
        }
        String idKaryawan = getSelectedKaryawanID();
        String idProyek = getSelectedProyekID();
        String cekdatasql = "SELECT COUNT(*) FROM transaksi WHERE id_karyawan = ? && id_proyek = ?";
        PreparedStatement checkPs = conn.prepareStatement(cekdatasql);
        checkPs.setInt(1, Integer.parseInt(idKaryawan));
        checkPs.setInt(2, Integer.parseInt(idProyek));
        ResultSet rs = checkPs.executeQuery();
        rs.next();

        if (rs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(this, "Data sudah ditambahkan di database!");
            return;
        }
        
        String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(idKaryawan));
        ps.setInt(2, Integer.parseInt(idProyek));
        ps.setString(3, tf_peran.getText());
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data saved successfully");
        loadData3();
        } catch (SQLException e) {
            System.out.println("Error Save Data: " + e.getMessage());
        }
    }
    //End Simpan Data Transaksi
    
    //Update Data Karyawan
    private void updateData() {
      try {
        if (tf_idkaryawan1.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih ID yang ingin anda update");
            return; 
        }
        getSelectedKaryawanID() ;
        String checkIdSql = "SELECT COUNT(*) FROM karyawan WHERE id = ?";
        PreparedStatement checkIdPs = conn.prepareStatement(checkIdSql);
        checkIdPs.setInt(1, Integer.parseInt(tf_idkaryawan1.getText()));
        ResultSet rsId = checkIdPs.executeQuery();
        rsId.next();

        if (rsId.getInt(1) == 0) {
            JOptionPane.showMessageDialog(this, "ID tidak ditemukan di database! Silakan cek ID dengan benar.");
            return;
        }
          
        if (tf_namakaryawan.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama harus diisi terlebih dahulu!");
            return; 
        }
        
        if (cmb_jabatan.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Jabatan harus dipilih terlebih dahulu!");
            return; 
        }
        
        if (cmb_departemen.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Departemen harus dipilih terlebih dahulu!");
            return; 
        }
        
        String cekdatasql = "SELECT COUNT(*) FROM karyawan WHERE nama = ? && jabatan = ? && departemen = ?";
        PreparedStatement checkPs = conn.prepareStatement(cekdatasql);
        checkPs.setString(1, tf_namakaryawan.getText());
        checkPs.setString(2, cmb_jabatan.getSelectedItem().toString());
        checkPs.setString(3, cmb_departemen.getSelectedItem().toString());
        ResultSet rs = checkPs.executeQuery();
        rs.next();

        if (rs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(this, "Data sudah ada di database!");
            return;
        }
        
        String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_namakaryawan.getText());
        ps.setString(2, cmb_jabatan.getSelectedItem().toString());
        ps.setString(3, cmb_departemen.getSelectedItem().toString());
        ps.setInt(4, Integer.parseInt(tf_idkaryawan1.getText()));
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data saved successfully");
        loadData();
        loadKaryawanIDs();
        loadData3();
        } catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
        }
    }
    //End Update Data
    
    //Update Data Proyek
    private void updateData2() {
      try {
        if (tf_idproyek1.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih ID yang ingin anda update");
            return; 
        }
        getSelectedProyekID();
        String checkIdSql = "SELECT COUNT(*) FROM proyek WHERE id = ?";
        PreparedStatement checkIdPs = conn.prepareStatement(checkIdSql);
        checkIdPs.setInt(1, Integer.parseInt(tf_idproyek1.getText()));
        ResultSet rsId = checkIdPs.executeQuery();
        rsId.next();

        if (rsId.getInt(1) == 0) {
            JOptionPane.showMessageDialog(this, "ID tidak ditemukan di database! Silakan cek ID dengan benar.");
            return;
        }
          
        if (tf_namaproyek.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama harus diisi terlebih dahulu!");
            return; 
        }
        
        if (tf_durasi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Durasi harus diisi terlebih dahulu!");
            return; 
        }
        
        try {
            Integer.parseInt(tf_durasi.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Durasi proyek harus berupa angka!");
            return;
        }
        
        String cekdatasql = "SELECT COUNT(*) FROM proyek WHERE nama_proyek = ? && durasi_pengerjaan = ?";
        PreparedStatement checkPs = conn.prepareStatement(cekdatasql);
        checkPs.setString(1, tf_namaproyek.getText());
        checkPs.setString(2, tf_durasi.getText());
        ResultSet rs = checkPs.executeQuery();
        rs.next();

        if (rs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(this, "Data sudah ada di database!");
            return;
        }
        
        String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_namaproyek.getText());
        ps.setString(2, tf_durasi.getText());
        ps.setInt(3, Integer.parseInt(tf_idproyek1.getText()));
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data saved successfully");
        loadData2();
        loadProyekIDs();
        loadData3();
        } catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
        }
    }
    //End Update Data Proyek
    
    //Update Data Transaksi
    private void UpdateData3() {
      try{
        String idKaryawan = getSelectedKaryawanID();
        String idProyek = getSelectedProyekID();
        String checkIdSql = "SELECT COUNT(*) FROM transaksi WHERE id_karyawan = ? AND id_proyek = ? ";
        PreparedStatement checkIdPs = conn.prepareStatement(checkIdSql);
        checkIdPs.setInt(1, Integer.parseInt(idKaryawan));
        checkIdPs.setInt(2, Integer.parseInt(idProyek));
        ResultSet rsId = checkIdPs.executeQuery();
        rsId.next();

        if (rsId.getInt(1) == 0) {
            JOptionPane.showMessageDialog(this, "ID tidak ditemukan di database! Silakan cek ID dengan benar.");
            return;
        }
        
        if (tf_peran.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isi peran terlebih dahulu");
            return; 
        }
        
        String sql = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? && id_proyek = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_peran.getText());
        ps.setInt(2, Integer.parseInt(idKaryawan));
        ps.setInt(3, Integer.parseInt(idProyek));
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data saved successfully");
        loadData3();
        } catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
        }
    }
    //End Update Transaksi
    
    //Delete Data Karyawan
    private void deleteData() {
        try {
        if (tf_idkaryawan1.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih ID yang ingin anda hapus");
            return; 
        }
        
        getSelectedKaryawanID();
        String checkIdSql = "SELECT COUNT(*) FROM karyawan WHERE id = ?";
        PreparedStatement checkIdPs = conn.prepareStatement(checkIdSql);
        checkIdPs.setInt(1, Integer.parseInt(tf_idkaryawan1.getText()));
        ResultSet rsId = checkIdPs.executeQuery();
        rsId.next();

        if (rsId.getInt(1) == 0) {
            JOptionPane.showMessageDialog(this, "ID tidak ditemukan di database! Silakan cek ID dengan benar.");
            return;
        }

        String sqlDelete = "DELETE FROM karyawan WHERE id = ?";
        PreparedStatement psDelete = conn.prepareStatement(sqlDelete);
        psDelete.setInt(1, Integer.parseInt(tf_idkaryawan1.getText()));
        psDelete.executeUpdate();

        String sqlReset = "SET @new_id = 0";
        String sqlUpdateId = "UPDATE karyawan SET id = (@new_id := @new_id + 1)";
        String sqlSetAutoIncrement = "ALTER TABLE karyawan AUTO_INCREMENT = 1";

        conn.prepareStatement(sqlReset).executeUpdate();       
        conn.prepareStatement(sqlUpdateId).executeUpdate();    
        conn.prepareStatement(sqlSetAutoIncrement).executeUpdate(); 

        JOptionPane.showMessageDialog(this, "Data deleted and IDs reset successfully");
        loadData();
        loadKaryawanIDs();
        loadData3();
        } catch (SQLException e) {
            System.out.println("Error deleting data: " + e.getMessage());
        }
    }
    //End Delete Data Karyawan
    
    //Delete Data Proyek
    private void deleteData2() {
        try {
        if (tf_idproyek1.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih ID yang ingin anda hapus");
            return; 
        }
        getSelectedProyekID();
        String checkIdSql = "SELECT COUNT(*) FROM proyek WHERE id = ?";
        PreparedStatement checkIdPs = conn.prepareStatement(checkIdSql);
        checkIdPs.setInt(1, Integer.parseInt(tf_idproyek1.getText()));
        ResultSet rsId = checkIdPs.executeQuery();
        rsId.next();

        if (rsId.getInt(1) == 0) {
            JOptionPane.showMessageDialog(this, "ID tidak ditemukan di database! Silakan cek ID dengan benar.");
            return;
        }

        String sqlDelete = "DELETE FROM proyek WHERE id = ?";
        PreparedStatement psDelete = conn.prepareStatement(sqlDelete);
        psDelete.setInt(1, Integer.parseInt(tf_idproyek1.getText()));
        psDelete.executeUpdate();

        String sqlReset = "SET @new_id = 0";
        String sqlUpdateId = "UPDATE proyek SET id = (@new_id := @new_id + 1)";
        String sqlSetAutoIncrement = "ALTER TABLE proyek AUTO_INCREMENT = 1";

        conn.prepareStatement(sqlReset).executeUpdate();       
        conn.prepareStatement(sqlUpdateId).executeUpdate();    
        conn.prepareStatement(sqlSetAutoIncrement).executeUpdate(); 

        JOptionPane.showMessageDialog(this, "Data deleted and IDs reset successfully");
        loadData2();
        loadProyekIDs();
        loadData3();
        } catch (SQLException e) {
            System.out.println("Error deleting data: " + e.getMessage());
        }
    }
    //End Delete Data Proyek
    
    //Delete Data Transaksi
    private void deleteData3() {
        try {
        // Mengecek apakah data dengan id_karyawan dan id_proyek yang dipilih ada di database
        String idKaryawan = getSelectedKaryawanID();
        String idProyek = getSelectedProyekID();
        String checkIdSql = "SELECT COUNT(*) FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
        PreparedStatement checkIdPs = conn.prepareStatement(checkIdSql);
        checkIdPs.setInt(1, Integer.parseInt(idKaryawan));
        checkIdPs.setInt(2, Integer.parseInt(idProyek));
        ResultSet rsId = checkIdPs.executeQuery();
        rsId.next();

        if (rsId.getInt(1) == 0) {
            JOptionPane.showMessageDialog(this, "ID tidak ditemukan di database! Silakan pilih ID dengan benar.");
            return;
        }

        String sqlDelete = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
        PreparedStatement psDelete = conn.prepareStatement(sqlDelete);
        psDelete.setInt(1, Integer.parseInt(idKaryawan));
        psDelete.setInt(2, Integer.parseInt(idProyek));
        psDelete.executeUpdate();

        String sqlResetAutoIncrement = "ALTER TABLE transaksi AUTO_INCREMENT = 1";
        conn.prepareStatement(sqlResetAutoIncrement).executeUpdate();

        JOptionPane.showMessageDialog(this, "Data berhasil dihapus dan ID berhasil di-reset.");
        loadData3();

        } catch (SQLException e) {
            System.out.println("Error deleting data: " + e.getMessage());
        }
    }
    //End Delete Data Transaksi

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel11 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_idkaryawan1 = new javax.swing.JTextField();
        tf_namakaryawan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmb_jabatan = new javax.swing.JComboBox<>();
        cmb_departemen = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnupdatekaryawan = new javax.swing.JButton();
        btncreatekaryawan = new javax.swing.JButton();
        btndeletekaryawan = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tf_idproyek1 = new javax.swing.JTextField();
        tf_namaproyek = new javax.swing.JTextField();
        tf_durasi = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btnupdateproject = new javax.swing.JButton();
        btncreateobject = new javax.swing.JButton();
        btndeleteproject = new javax.swing.JButton();
        btnresetproyek = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        tf_peran = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cmb_idkaryawan2 = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        cmb_idproyek2 = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        btnupdatetransaksi = new javax.swing.JButton();
        btncreatetransaksi = new javax.swing.JButton();
        btndeletetransaksi = new javax.swing.JButton();
        btnresettransaksi = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();

        jLabel11.setText("jLabel11");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(204, 153, 255));

        jPanel1.setBackground(new java.awt.Color(176, 196, 222));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(204, 153, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel1.setText("ID");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel2.setText("Nama");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel3.setText("Jabatan");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel4.setText("Departemen");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));
        jPanel5.add(tf_idkaryawan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 420, -1));
        jPanel5.add(tf_namakaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 420, -1));

        jLabel5.setText(":");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 40, -1));

        jLabel6.setText(":");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 20, 20));

        jLabel7.setText(":");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 50, -1));

        jLabel8.setText(":");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 50, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\lanny aprilia\\Downloads\\p3.png")); // NOI18N
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, -1, 140));

        cmb_jabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- PILIH JABATAN -", "Recruitment Specialist", "Accountant", "Financial Analyst", "Digital Marketing Specialist", "Sales Executive", "Data Analyst/Scientist", "System Administrator" }));
        jPanel5.add(cmb_jabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 420, -1));

        cmb_departemen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- PILIH DEPARTEMEN -", "Sumber Daya Manusia (HR)", "Keuangan", "Pemasaran", "Operasional", "Teknologi Informasi (IT)" }));
        jPanel5.add(cmb_departemen, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 420, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 630, 240));

        jPanel6.setBackground(new java.awt.Color(255, 204, 255));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel9.setFont(new java.awt.Font("Script MT Bold", 0, 27)); // NOI18N
        jLabel9.setText("Karyawan Lan's Project 7");
        jPanel6.add(jLabel9, new java.awt.GridBagConstraints());

        jLabel10.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel10.setText("- Berkarya dengan Keberanian dan Integritas -");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        jPanel6.add(jLabel10, gridBagConstraints);

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 100));

        jPanel7.setBackground(new java.awt.Color(204, 153, 255));
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 33, 10));

        btnupdatekaryawan.setText("Update");
        btnupdatekaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdatekaryawanActionPerformed(evt);
            }
        });
        jPanel7.add(btnupdatekaryawan);

        btncreatekaryawan.setText("Create");
        btncreatekaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreatekaryawanActionPerformed(evt);
            }
        });
        jPanel7.add(btncreatekaryawan);

        btndeletekaryawan.setText("Delete");
        btndeletekaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletekaryawanActionPerformed(evt);
            }
        });
        jPanel7.add(btndeletekaryawan);

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1);

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 630, 50));

        jScrollPane1.setBackground(new java.awt.Color(255, 153, 153));

        tbl_karyawan.setBackground(new java.awt.Color(255, 153, 153));
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 630, 110));

        jTabbedPane1.addTab("Karyawan", jPanel1);

        jPanel2.setBackground(new java.awt.Color(173, 216, 230));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel14.setText("ID");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel15.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel15.setText("Nama Proyek");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel16.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel16.setText("Durasi");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        jPanel8.add(tf_idproyek1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 420, -1));
        jPanel8.add(tf_namaproyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 420, -1));
        jPanel8.add(tf_durasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 420, -1));

        jLabel18.setText(":");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 40, -1));

        jLabel20.setText(":");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 50, -1));

        jLabel21.setText(":");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 50, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon("C:\\Users\\lanny aprilia\\Downloads\\p4.png")); // NOI18N
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, -1, 170));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 630, 230));

        jPanel9.setBackground(new java.awt.Color(153, 153, 255));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        jLabel23.setFont(new java.awt.Font("Script MT Bold", 0, 27)); // NOI18N
        jLabel23.setText("Lan's Project 7");
        jPanel9.add(jLabel23, new java.awt.GridBagConstraints());

        jLabel24.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel24.setText("- Berkarya dengan Keberanian dan Integritas -");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        jPanel9.add(jLabel24, gridBagConstraints);

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 100));

        jPanel10.setBackground(new java.awt.Color(204, 204, 255));
        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 33, 10));

        btnupdateproject.setText("Update");
        btnupdateproject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateprojectActionPerformed(evt);
            }
        });
        jPanel10.add(btnupdateproject);

        btncreateobject.setText("Create");
        btncreateobject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreateobjectActionPerformed(evt);
            }
        });
        jPanel10.add(btncreateobject);

        btndeleteproject.setText("Delete");
        btndeleteproject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteprojectActionPerformed(evt);
            }
        });
        jPanel10.add(btndeleteproject);

        btnresetproyek.setText("Reset");
        btnresetproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetproyekActionPerformed(evt);
            }
        });
        jPanel10.add(btnresetproyek);

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 630, 50));

        jScrollPane2.setBackground(new java.awt.Color(102, 102, 255));

        tbl_proyek.setBackground(new java.awt.Color(153, 153, 255));
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

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 630, 120));

        jTabbedPane1.addTab("Proyek", jPanel2);

        jPanel3.setBackground(new java.awt.Color(95, 158, 160));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(0, 153, 204));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel26.setText("ID Karyawan");
        jPanel11.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel27.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel27.setText("ID Proyek");
        jPanel11.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel28.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel28.setText("Peran");
        jPanel11.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        tf_peran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_peranActionPerformed(evt);
            }
        });
        jPanel11.add(tf_peran, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 420, -1));

        jLabel30.setText(":");
        jPanel11.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 20, 20));

        jLabel31.setText(":");
        jPanel11.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 50, -1));

        jLabel32.setText(":");
        jPanel11.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 50, -1));

        cmb_idkaryawan2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- PILIH ID KARYAWAN -" }));
        jPanel11.add(cmb_idkaryawan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 420, -1));

        jLabel33.setIcon(new javax.swing.ImageIcon("C:\\Users\\lanny aprilia\\Downloads\\p5.png")); // NOI18N
        jPanel11.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, -1, 160));

        cmb_idproyek2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- PILIH ID PROYEK -" }));
        jPanel11.add(cmb_idproyek2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 420, -1));

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 630, 240));

        jPanel12.setBackground(new java.awt.Color(204, 204, 255));
        jPanel12.setLayout(new java.awt.GridBagLayout());

        jLabel34.setFont(new java.awt.Font("Script MT Bold", 0, 27)); // NOI18N
        jLabel34.setText("Lan's Project 7");
        jPanel12.add(jLabel34, new java.awt.GridBagConstraints());

        jLabel35.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel35.setText("- Berkarya dengan Keberanian dan Integritas -");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        jPanel12.add(jLabel35, gridBagConstraints);

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 100));

        jPanel13.setBackground(new java.awt.Color(0, 153, 204));
        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 33, 10));

        btnupdatetransaksi.setText("Update");
        btnupdatetransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdatetransaksiActionPerformed(evt);
            }
        });
        jPanel13.add(btnupdatetransaksi);

        btncreatetransaksi.setText("Create");
        btncreatetransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreatetransaksiActionPerformed(evt);
            }
        });
        jPanel13.add(btncreatetransaksi);

        btndeletetransaksi.setText("Delete");
        btndeletetransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletetransaksiActionPerformed(evt);
            }
        });
        jPanel13.add(btndeletetransaksi);

        btnresettransaksi.setText("Reset");
        btnresettransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresettransaksiActionPerformed(evt);
            }
        });
        jPanel13.add(btnresettransaksi);

        jPanel3.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 630, 60));

        jScrollPane3.setBackground(new java.awt.Color(102, 102, 255));

        tbl_transaksi.setBackground(new java.awt.Color(153, 153, 255));
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

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 630, 110));

        jTabbedPane1.addTab("Transaksi", jPanel3);

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

    private void tf_peranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_peranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_peranActionPerformed

    private void btncreatekaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreatekaryawanActionPerformed
        saveData();
    }//GEN-LAST:event_btncreatekaryawanActionPerformed

    private void btnupdatekaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdatekaryawanActionPerformed
        updateData();
    }//GEN-LAST:event_btnupdatekaryawanActionPerformed

    private void btndeletekaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletekaryawanActionPerformed
        deleteData();
    }//GEN-LAST:event_btndeletekaryawanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tf_idkaryawan1.setText("");
        tf_namakaryawan.setText("");
        cmb_jabatan.setSelectedIndex(0);
        cmb_departemen.setSelectedIndex(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btncreateobjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreateobjectActionPerformed
        saveData2();
    }//GEN-LAST:event_btncreateobjectActionPerformed

    private void btnupdateprojectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateprojectActionPerformed
        updateData2();
    }//GEN-LAST:event_btnupdateprojectActionPerformed

    private void btndeleteprojectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteprojectActionPerformed
        deleteData2();
    }//GEN-LAST:event_btndeleteprojectActionPerformed

    private void btnresetproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetproyekActionPerformed
        tf_idproyek1.setText("");
        tf_namaproyek.setText("");
        tf_durasi.setText("");
    }//GEN-LAST:event_btnresetproyekActionPerformed

    private void btncreatetransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreatetransaksiActionPerformed
        saveData3();
    }//GEN-LAST:event_btncreatetransaksiActionPerformed

    private void btnupdatetransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdatetransaksiActionPerformed
        UpdateData3();
    }//GEN-LAST:event_btnupdatetransaksiActionPerformed

    private void btndeletetransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletetransaksiActionPerformed
        deleteData3();
    }//GEN-LAST:event_btndeletetransaksiActionPerformed

    private void btnresettransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresettransaksiActionPerformed
        cmb_idkaryawan2.setSelectedIndex(0);
        cmb_idproyek2.setSelectedIndex(0);
        tf_peran.setText("");
    }//GEN-LAST:event_btnresettransaksiActionPerformed

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
            java.util.logging.Logger.getLogger(database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new database().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncreatekaryawan;
    private javax.swing.JButton btncreateobject;
    private javax.swing.JButton btncreatetransaksi;
    private javax.swing.JButton btndeletekaryawan;
    private javax.swing.JButton btndeleteproject;
    private javax.swing.JButton btndeletetransaksi;
    private javax.swing.JButton btnresetproyek;
    private javax.swing.JButton btnresettransaksi;
    private javax.swing.JButton btnupdatekaryawan;
    private javax.swing.JButton btnupdateproject;
    private javax.swing.JButton btnupdatetransaksi;
    private javax.swing.JComboBox<String> cmb_departemen;
    private javax.swing.JComboBox<String> cmb_idkaryawan2;
    private javax.swing.JComboBox<String> cmb_idproyek2;
    private javax.swing.JComboBox<String> cmb_jabatan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
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
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
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
    private javax.swing.JTextField tf_durasi;
    private javax.swing.JTextField tf_idkaryawan1;
    private javax.swing.JTextField tf_idproyek1;
    private javax.swing.JTextField tf_namakaryawan;
    private javax.swing.JTextField tf_namaproyek;
    private javax.swing.JTextField tf_peran;
    // End of variables declaration//GEN-END:variables
}
