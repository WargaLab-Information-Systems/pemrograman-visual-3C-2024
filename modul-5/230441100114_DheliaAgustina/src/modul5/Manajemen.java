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


public class Manajemen extends javax.swing.JFrame {

    Connection conn;//
    private DefaultTableModel modelKaryawan;
    private DefaultTableModel modelProyek;
    private DefaultTableModel modelTransaksi;
    
    public Manajemen() {
        initComponents();
        conn = Koneksidb.getConnection();
        
        modelKaryawan = new DefaultTableModel();
        tabl_1.setModel(modelKaryawan);
        
        modelKaryawan.addColumn("ID");
        modelKaryawan.addColumn("Nama");
        modelKaryawan.addColumn("JABATAN");
        modelKaryawan.addColumn("DEPARTEMEN");
        
        
        modelProyek = new DefaultTableModel();
        tbl_2.setModel(modelProyek);
        
        modelProyek.addColumn("ID");
        modelProyek.addColumn("Nama_proyek");
        modelProyek.addColumn("Durasi_proyek");
        
        modelTransaksi = new DefaultTableModel();
        tbl_3.setModel(modelTransaksi);
        
        modelTransaksi.addColumn("ID Transaksi");
        modelTransaksi.addColumn("ID Karyawan");
        modelTransaksi.addColumn("ID Proyek"); 
        modelTransaksi.addColumn("Peran");

        loadDataKaryawan();
        loadDataProyek();
        loadDataTransaksi();
        loadDataToKaryawanComboBox();
        loadDataToProyekComboBox();
    }

    private void loadDataKaryawan() {//
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
        modelProyek.setRowCount(0); // Kosongkan hanya modelProyek

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
    
    private void saveDataKaryawan() {
      try{
         String sql = "INSERT INTO karyawan (nama, jabatan, departemen) VALUES (?, ?, ?)";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, tf_nama_1.getText());
         ps.setString(2, tf_jabatan_1.getText());
         ps.setString(3, tf_depar_1.getText());
         ps.executeUpdate();
         JOptionPane.showMessageDialog(this, "Data saved successfully");
         loadDataKaryawan();
         loadDataToKaryawanComboBox();
       } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
     }
    
    private void saveDataProyek() {
        try {
            String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tf_namproyek_2.getText());
            ps.setString(2, tf_duras_2.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data proyek saved successfully");
            loadDataProyek();
            loadDataToProyekComboBox();
        } catch (SQLException e) {
            System.out.println("Error Save Data Proyek: " + e.getMessage());
        }
    }
    
    private void updateDataKaryawan() {
        try {
            String sql = "UPDATE karyawan SET nama = ?, jabatan = ? , departemen= ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tf_nama_1.getText());
            ps.setString(2, tf_jabatan_1.getText());
            ps.setString(3, tf_depar_1.getText());
            ps.setInt(4, Integer.parseInt(tf_id_1.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data updated successfully");
            loadDataKaryawan();
            loadDataToKaryawanComboBox();
        }catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
    
    private void updateDataProyek() {   
        try {
            String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tf_namproyek_2.getText());
            ps.setString(2, tf_duras_2.getText());
            ps.setInt(3, Integer.parseInt(tf_id_2.getText())); // Ubah ke 3
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data proyek updated successfully");
            loadDataProyek();
            loadDataToProyekComboBox();
        } catch (SQLException e) {
            System.out.println("Error Update Data Proyek: " + e.getMessage());
        }
    }
    
    private void deleteDataKaryawan() {
     try  {
          String sql = "DELETE FROM karyawan WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, Integer.parseInt(tf_id_1.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data deleted successfully");
          loadDataKaryawan();
          loadDataToKaryawanComboBox();
     } catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
    }
    
    private void deleteDataProyek() {
        try  {
            String sql = "DELETE FROM proyek WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(tf_id_2.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data deleted successfully");
            loadDataProyek();
            loadDataToProyekComboBox();
        }catch (SQLException e) {
             System.out.println("Error Save Data" + e.getMessage());
        }
    }
    
    private void loadDataToKaryawanComboBox() {
    try {
        // Kosongkan ComboBox terlebih dahulu
        cmb_karyawan_3.removeAllItems();
        
        // Query untuk mengambil nama karyawan
        String sql = "SELECT nama FROM karyawan";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        // Tambahkan setiap nama karyawan ke ComboBox
        while (rs.next()) {
            cmb_karyawan_3.addItem(rs.getString("nama"));
        }
    } catch (SQLException e) {
        System.out.println("Error loading karyawan to ComboBox: " + e.getMessage());
    }
}

// Tambahkan method baru untuk memuat data ke ComboBox proyek
private void loadDataToProyekComboBox() {
    try {
        // Kosongkan ComboBox terlebih dahulu
        cmb_proyek_3.removeAllItems();
        
        // Query untuk mengambil nama proyek
        String sql = "SELECT nama_proyek FROM proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        // Tambahkan setiap nama proyek ke ComboBox
        while (rs.next()) {
            cmb_proyek_3.addItem(rs.getString("nama_proyek"));
        }
    } catch (SQLException e) {
        System.out.println("Error loading proyek to ComboBox: " + e.getMessage());
    }
}
    
 

// Method untuk mendapatkan ID karyawan berdasarkan nama
    private int getKaryawanId(String namaKaryawan) {
    try {
        String sql = "SELECT id FROM karyawan WHERE nama = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, namaKaryawan);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("id");
        }
    } catch (SQLException e) {
        System.out.println("Error getting karyawan ID: " + e.getMessage());
    }
    return -1;
}

// Method untuk mendapatkan ID proyek berdasarkan nama
    private int getProyekId(String namaProyek) {
    try {
        String sql = "SELECT id FROM proyek WHERE nama_proyek = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, namaProyek);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("id");
        }
    } catch (SQLException e) {
        System.out.println("Error getting proyek ID: " + e.getMessage());
    }
    return -1;
}

// Method untuk menyimpan data transaksi
   private void saveDataTransaksi() {
    try {
        String selectedKaryawan = cmb_karyawan_3.getSelectedItem().toString();//mengambil data dari combobox dan teksfield
        String selectedProyek = cmb_proyek_3.getSelectedItem().toString();
        String peran = tf_peran_3.getText();
        
        int karyawanId = getKaryawanId(selectedKaryawan);
        int proyekId = getProyekId(selectedProyek);
        
        if (karyawanId != -1 && proyekId != -1) {
            String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, karyawanId);//mengatur nilai pertama pada query (id_karyawan) dengan karyawanId.
            ps.setInt(2, proyekId);
            ps.setString(3, peran);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Data transaksi saved successfully");
            loadDataTransaksi();
        } else {
            JOptionPane.showMessageDialog(this, "Error: Karyawan or Proyek not found");
        }
    } catch (SQLException e) {
        System.out.println("Error Save Data Transaksi: " + e.getMessage());
    }
}

// Method untuk menampilkan data transaksi
   // Method untuk menampilkan data transaksi
private void loadDataTransaksi() {
    modelTransaksi.setRowCount(0); // Menghapus semua data di tabel

    try {
        String sql = "SELECT t.id_transaksi, k.nama AS nama_karyawan, " +
                     "p.nama_proyek, t.peran " +
                     "FROM transaksi t " +
                     "JOIN karyawan k ON t.id_karyawan = k.id " +
                     "JOIN proyek p ON t.id_proyek = p.id";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            modelTransaksi.addRow(new Object[]{
                rs.getInt("id_transaksi"), // Menambahkan kolom ID Transaksi
                rs.getString("nama_karyawan"), // Menampilkan hanya nama karyawan
                rs.getString("nama_proyek"), // Menampilkan hanya nama proyek
                rs.getString("peran")
            });
        }
    } catch (SQLException e) {
        System.out.println("Error Load Data Transaksi: " + e.getMessage());
    }
}


// Method untuk update data transaksi
private void updateDataTransaksi() {
    try {
        // Ambil nilai dari text field dan combo box
        int idTransaksi = Integer.parseInt(tf_idTransaksi_3.getText()); // Ambil ID Transaksi dari text field
        String karyawanBaru = cmb_karyawan_3.getSelectedItem().toString();
        String proyekBaru = cmb_proyek_3.getSelectedItem().toString();
        String peranBaru = tf_peran_3.getText();
        
        // Dapatkan ID karyawan dan proyek baru
        int karyawanIdBaru = getKaryawanId(karyawanBaru);
        int proyekIdBaru = getProyekId(proyekBaru);
        
        if (karyawanIdBaru == -1 || proyekIdBaru == -1) {
            JOptionPane.showMessageDialog(this, "Error: Data karyawan dan proyek tidak valid.");
            return;
        }

        // Update transaksi berdasarkan id_transaksi
        String sql = "UPDATE transaksi SET id_karyawan = ?, id_proyek = ?, peran = ? WHERE id_transaksi = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, karyawanIdBaru);       
        ps.setInt(2, proyekIdBaru);         
        ps.setString(3, peranBaru);         
        ps.setInt(4, idTransaksi);          // Kondisi WHERE berdasarkan id_transaksi
        
        int rowsUpdated = ps.executeUpdate();
        
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Data transaksi berhasil diperbarui.");
        } else {
            JOptionPane.showMessageDialog(this, "Error: Tidak ada data yang diperbarui. Pastikan ID Transaksi benar.");
        }
        
        loadDataTransaksi(); // Memuat ulang tabel transaksi untuk menampilkan perubahan
    } catch (SQLException e) {
        System.out.println("Error Update Data Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Error saat memperbarui data transaksi.");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID Transaksi harus berupa angka.");
    }
}




// Method untuk delete data transaksi
private void deleteDataTransaksi() {
    try {
        String selectedKaryawan = cmb_karyawan_3.getSelectedItem().toString();//mengambil data dari cmb karyawan dan proyek 
        String selectedProyek = cmb_proyek_3.getSelectedItem().toString();
        
        int karyawanId = getKaryawanId(selectedKaryawan); //mengambil id dari data karyawan dan proyek yang akan di tambpilkan di teble transaksi
        int proyekId = getProyekId(selectedProyek);
        
        if (karyawanId != -1 && proyekId != -1) {
            String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, karyawanId);//mengatur nilai
            ps.setInt(2, proyekId);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Data transaksi deleted successfully");
            loadDataTransaksi();
        } else {
            JOptionPane.showMessageDialog(this, "Error: Karyawan or Proyek not found");
        }
    } catch (SQLException e) {
        System.out.println("Error Delete Data Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Error deleting transaksi data");
    }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tf_jabatan_1 = new javax.swing.JTextField();
        tf_depar_1 = new javax.swing.JTextField();
        tf_id_1 = new javax.swing.JTextField();
        tf_nama_1 = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        tbh_1 = new javax.swing.JButton();
        updt_1 = new javax.swing.JButton();
        delt_1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabl_1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_id_2 = new javax.swing.JTextField();
        tf_namproyek_2 = new javax.swing.JTextField();
        tf_duras_2 = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        tbh_2 = new javax.swing.JButton();
        updt_2 = new javax.swing.JButton();
        delt_2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_2 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tf_peran_3 = new javax.swing.JTextField();
        cmb_karyawan_3 = new javax.swing.JComboBox<>();
        cmb_proyek_3 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        tf_idTransaksi_3 = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        tbh_3 = new javax.swing.JButton();
        updt_3 = new javax.swing.JButton();
        delt_3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Swis721 Blk BT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Manajemen Karyawan & Proyek");

        jDesktopPane1.setBackground(new java.awt.Color(51, 51, 51));

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.white));

        jLabel5.setFont(new java.awt.Font("Swis721 Blk BT", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Karyawan");

        jPanel10.setLayout(new java.awt.GridLayout(1, 2, 3, 3));

        jPanel21.setBackground(new java.awt.Color(204, 204, 204));
        jPanel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.white));
        jPanel21.setLayout(new java.awt.GridBagLayout());

        jLabel7.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        jLabel7.setText("id");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel21.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        jLabel8.setText("Nama");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel21.add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        jLabel9.setText("Jabatan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel21.add(jLabel9, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        jLabel10.setText("Departemen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPanel21.add(jLabel10, gridBagConstraints);

        tf_jabatan_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_jabatan_1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 177;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 4, 0);
        jPanel21.add(tf_jabatan_1, gridBagConstraints);

        tf_depar_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_depar_1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 177;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel21.add(tf_depar_1, gridBagConstraints);

        tf_id_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_id_1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 177;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 4, 0);
        jPanel21.add(tf_id_1, gridBagConstraints);

        tf_nama_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nama_1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 177;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 4, 0);
        jPanel21.add(tf_nama_1, gridBagConstraints);

        jPanel10.add(jPanel21);

        jPanel20.setBackground(new java.awt.Color(204, 204, 204));
        jPanel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.white));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbh_1.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        tbh_1.setText("Tambah");
        tbh_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbh_1ActionPerformed(evt);
            }
        });
        jPanel20.add(tbh_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        updt_1.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        updt_1.setText("Update");
        updt_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updt_1ActionPerformed(evt);
            }
        });
        jPanel20.add(updt_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        delt_1.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        delt_1.setText("Delete");
        delt_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delt_1ActionPerformed(evt);
            }
        });
        jPanel20.add(delt_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\Downloads\\download__4_-removebg-preview_11zon (1).png")); // NOI18N
        jPanel20.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 200, 170));

        jPanel10.add(jPanel20);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(382, 382, 382)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel5);

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.white));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabl_1.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Nama", "Jabatan", "Departemen"
            }
        ));
        jScrollPane1.setViewportView(tabl_1);

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 520, 250));

        jPanel2.add(jPanel7);

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(new java.awt.GridLayout(2, 1));

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.white));

        jLabel15.setFont(new java.awt.Font("Swis721 Blk BT", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Proyek");

        jPanel17.setLayout(new java.awt.GridLayout(1, 2, 0, 3));

        jPanel19.setBackground(new java.awt.Color(51, 51, 51));
        jPanel19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.white));
        jPanel19.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("id");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel19.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama_proyek");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel19.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Durasi_proyek");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel19.add(jLabel4, gridBagConstraints);

        tf_id_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_id_2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 177;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 4, 0);
        jPanel19.add(tf_id_2, gridBagConstraints);

        tf_namproyek_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_namproyek_2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 177;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 4, 0);
        jPanel19.add(tf_namproyek_2, gridBagConstraints);

        tf_duras_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_duras_2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 177;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel19.add(tf_duras_2, gridBagConstraints);

        jPanel17.add(jPanel19);

        jPanel18.setBackground(new java.awt.Color(51, 51, 51));
        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.white));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbh_2.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        tbh_2.setText("Tambah");
        tbh_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbh_2ActionPerformed(evt);
            }
        });
        jPanel18.add(tbh_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        updt_2.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        updt_2.setText("Update");
        updt_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updt_2ActionPerformed(evt);
            }
        });
        jPanel18.add(updt_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        delt_2.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        delt_2.setText("Delete");
        delt_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delt_2ActionPerformed(evt);
            }
        });
        jPanel18.add(delt_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\Downloads\\download__2_-removebg-preview_11zon (1).png")); // NOI18N
        jPanel18.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 220, 210));

        jPanel17.add(jPanel18);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(399, 399, 399)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel6);

        jPanel16.setBackground(new java.awt.Color(153, 153, 153));

        tbl_2.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Nama_proyek", "Durasi"
            }
        ));
        jScrollPane2.setViewportView(tbl_2);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel3.add(jPanel16);

        jTabbedPane1.addTab("tab2", jPanel3);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new java.awt.GridLayout(2, 1, 0, 2));

        jPanel11.setBackground(new java.awt.Color(153, 153, 153));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.white));

        jLabel6.setFont(new java.awt.Font("Swis721 Blk BT", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Transaksi");

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));
        jPanel13.setLayout(new java.awt.GridLayout(1, 2, 2, 2));

        jPanel15.setBackground(new java.awt.Color(102, 102, 102));
        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.white));
        jPanel15.setLayout(new java.awt.GridBagLayout());

        jLabel12.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("karyawan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel15.add(jLabel12, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("proyek");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel15.add(jLabel13, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("peran");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel15.add(jLabel14, gridBagConstraints);

        tf_peran_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_peran_3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel15.add(tf_peran_3, gridBagConstraints);

        cmb_karyawan_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_karyawan_3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 6, 0);
        jPanel15.add(cmb_karyawan_3, gridBagConstraints);

        cmb_proyek_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_proyek_3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 180;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 7, 1);
        jPanel15.add(cmb_proyek_3, gridBagConstraints);

        jLabel18.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("id_transaksi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel15.add(jLabel18, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel15.add(tf_idTransaksi_3, gridBagConstraints);

        jPanel13.add(jPanel15);

        jPanel14.setBackground(new java.awt.Color(102, 102, 102));
        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.white));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbh_3.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        tbh_3.setText("Tambah");
        tbh_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbh_3ActionPerformed(evt);
            }
        });
        jPanel14.add(tbh_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 90, -1));

        updt_3.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        updt_3.setText("Update");
        updt_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updt_3ActionPerformed(evt);
            }
        });
        jPanel14.add(updt_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 90, -1));

        delt_3.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        delt_3.setText("Delete");
        delt_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delt_3ActionPerformed(evt);
            }
        });
        jPanel14.add(delt_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 90, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\Downloads\\download__1_-removebg-preview_11zon.png")); // NOI18N
        jPanel14.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 190, 190));

        jPanel13.add(jPanel14);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(413, 413, 413)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(153, 153, 153));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.white));

        tbl_3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "id_transaksi", "id_karyawan", "id_proyek", "peran"
            }
        ));
        jScrollPane3.setViewportView(tbl_3);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel12);

        jTabbedPane1.addTab("tab3", jPanel4);

        jDesktopPane1.setLayer(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(210, 210, 210))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDesktopPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void delt_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delt_3ActionPerformed
        // TODO add your handling code here:
        deleteDataTransaksi();
    }//GEN-LAST:event_delt_3ActionPerformed

    private void tf_id_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_id_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_id_1ActionPerformed

    private void tf_nama_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nama_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nama_1ActionPerformed

    private void tf_jabatan_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_jabatan_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_jabatan_1ActionPerformed

    private void tf_depar_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_depar_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_depar_1ActionPerformed

    private void tbh_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbh_1ActionPerformed
        // TODO add your handling code here:
        saveDataKaryawan();
    }//GEN-LAST:event_tbh_1ActionPerformed

    private void updt_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updt_1ActionPerformed
        // TODO add your handling code here:
        updateDataKaryawan();
    }//GEN-LAST:event_updt_1ActionPerformed

    private void delt_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delt_1ActionPerformed
        // TODO add your handling code here:
        deleteDataKaryawan();
    }//GEN-LAST:event_delt_1ActionPerformed

    private void tf_id_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_id_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_id_2ActionPerformed

    private void tf_namproyek_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_namproyek_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_namproyek_2ActionPerformed

    private void tf_duras_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_duras_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_duras_2ActionPerformed

    private void tbh_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbh_2ActionPerformed
        // TODO add your handling code here:
        saveDataProyek();
    }//GEN-LAST:event_tbh_2ActionPerformed

    private void updt_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updt_2ActionPerformed
        // TODO add your handling code here:
        updateDataProyek();
    }//GEN-LAST:event_updt_2ActionPerformed

    private void delt_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delt_2ActionPerformed
        // TODO add your handling code here:
        deleteDataProyek();
    }//GEN-LAST:event_delt_2ActionPerformed

    private void cmb_karyawan_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_karyawan_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_karyawan_3ActionPerformed

    private void cmb_proyek_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_proyek_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_proyek_3ActionPerformed

    private void tf_peran_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_peran_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_peran_3ActionPerformed

    private void tbh_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbh_3ActionPerformed
        // TODO add your handling code here:
        saveDataTransaksi();
    }//GEN-LAST:event_tbh_3ActionPerformed

    private void updt_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updt_3ActionPerformed
        // TODO add your handling code here:
        updateDataTransaksi();
    }//GEN-LAST:event_updt_3ActionPerformed

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
            java.util.logging.Logger.getLogger(Manajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manajemen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_karyawan_3;
    private javax.swing.JComboBox<String> cmb_proyek_3;
    private javax.swing.JButton delt_1;
    private javax.swing.JButton delt_2;
    private javax.swing.JButton delt_3;
    private javax.swing.JDesktopPane jDesktopPane1;
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
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabl_1;
    private javax.swing.JButton tbh_1;
    private javax.swing.JButton tbh_2;
    private javax.swing.JButton tbh_3;
    private javax.swing.JTable tbl_2;
    private javax.swing.JTable tbl_3;
    private javax.swing.JTextField tf_depar_1;
    private javax.swing.JTextField tf_duras_2;
    private javax.swing.JTextField tf_idTransaksi_3;
    private javax.swing.JTextField tf_id_1;
    private javax.swing.JTextField tf_id_2;
    private javax.swing.JTextField tf_jabatan_1;
    private javax.swing.JTextField tf_nama_1;
    private javax.swing.JTextField tf_namproyek_2;
    private javax.swing.JTextField tf_peran_3;
    private javax.swing.JButton updt_1;
    private javax.swing.JButton updt_2;
    private javax.swing.JButton updt_3;
    // End of variables declaration//GEN-END:variables
}
