/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class NewJFrame extends javax.swing.JFrame {
    Connection conn;
    private  DefaultTableModel model;
    private  DefaultTableModel model2;
    private  DefaultTableModel model3;
    HashMap<String, Integer> karyawanMap = new HashMap<>(); 
    HashMap<String, Integer> proyekMap = new HashMap<>();

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        conn = koneksi.getConnection();
        
        model = new DefaultTableModel();
        tbl_karyawan.setModel(model);
        model.addColumn("ID KARYAWAN");
        model.addColumn("NAMA");
        model.addColumn("JABATAN");
        model.addColumn("DEPATERMEN");
        loadDatakaryawan();
        
        model2 = new DefaultTableModel();
        tbl_proyek.setModel(model2);
        model2.addColumn("ID PROYEK");
        model2.addColumn("NAMA PROYEK ");
        model2.addColumn("DURASI PENGERJAAN");
        loadDataproyek();
        
        model3 = new DefaultTableModel();
        tbl_transaksi.setModel(model3);
        model3.addColumn("ID KARYAWAN");
        model3.addColumn("ID PROYEK ");
        model3.addColumn("PERAN");
        loadDatatransaksi();
    }
    private void loadDatakaryawan() {
      model.setRowCount(0);

      try {
          String sql = "SELECT * FROM karyawan";
           PreparedStatement ps = conn.prepareStatement(sql);//menyiapkan query
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             model.addRow(new Object[]{
             rs.getInt("id"),
             rs.getString("nama"),
             rs.getString("jabatan"),
             rs.getString("departemen"),
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }
    private void loadDataproyek() {
      model2.setRowCount(0);

      try {
          String sql = "SELECT * FROM proyek";
           PreparedStatement ps = conn.prepareStatement(sql);//menyiapkan query
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             model2.addRow(new Object[]{
             rs.getInt("id_proyek"),
             rs.getString("nama_proyek"),
             rs.getInt("durasi_pengerjaan")
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }
    private void loadDatatransaksi() {
      model3.setRowCount(0);

    String proyek= "SELECT id_proyek, nama_proyek FROM proyek"; 
    String karyawan = "SELECT id, Nama FROM karyawan"; 
    cmb_idkaryawan.removeAllItems();
    cmb_idproyek.removeAllItems();
    try (PreparedStatement psProyek = conn.prepareStatement(proyek);
         ResultSet rsProyek = psProyek.executeQuery()) {

        while (rsProyek.next()) {
            String namaProyek = rsProyek.getString("Nama_Proyek"); 
            cmb_idproyek.addItem(namaProyek);
            int idProyek = rsProyek.getInt("id_proyek");
            proyekMap.put(namaProyek, idProyek);
        }
    } catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
    }

    try (PreparedStatement psKaryawan = conn.prepareStatement(karyawan);
         ResultSet rsKaryawan = psKaryawan.executeQuery()) {

        while (rsKaryawan.next()) {
            String namaKaryawan = rsKaryawan.getString("Nama");
            cmb_idkaryawan.addItem(namaKaryawan);
            int idKaryawan = rsKaryawan.getInt("id");
            karyawanMap.put(namaKaryawan, idKaryawan);
        }
    } catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
    }
    try {
          String sql = "SELECT * FROM transaksi";
           PreparedStatement ps = conn.prepareStatement(sql);//menyiapkan query
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             model3.addRow(new Object[]{
             rs.getInt("id_karyawan"),
             rs.getInt("id_proyek"),
             rs.getString("peran")
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }
    
    //Simpan Data
    private void saveDatakaryawan() {
      try{
         String sql = "INSERT INTO karyawan ( nama, jabatan,departemen) VALUES ( ?, ?,?)";//tanda tanya binable parameter(bind_param)
         PreparedStatement ps = conn.prepareStatement(sql);//pelingdung untuk si query
         ps.setString(1, txtnama.getText());
         ps.setString(2, txtjabatan.getText());
         ps.setString(3, txtdepartemen.getText());
//         kalau combo box nulisnya
 
         ps.executeUpdate();//(eksekusi)menyimpan data kedalam basis data
         JOptionPane.showMessageDialog(this, "Data saved successfully");
         loadDatakaryawan();
       } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
     }
    
     private void saveDataproyek() {
      try{
         String sql = "INSERT INTO proyek ( nama_proyek, durasi_pengerjaan) VALUES ( ?, ?)";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, txtnama1.getText());
          ps.setInt(2, Integer.parseInt((String)txtdurasi.getText()) );
//         kalau combo box nulisnya
 
         ps.executeUpdate();//(eksekusi)menyimpan data kedalam basis data
         JOptionPane.showMessageDialog(this, "Data saved successfully");
         loadDataproyek();
       } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
     }
     
     private void saveDatatransaksi() {
      try{
          String selectedKaryawan = (String) cmb_idkaryawan.getSelectedItem();
          String selectedProyek = (String) cmb_idproyek.getSelectedItem();
          String peran = txtperan.getText();  // Mendapatkan nilai peran dari TextField
          int idKaryawan = karyawanMap.get(selectedKaryawan);
          int idProyek = proyekMap.get(selectedProyek);
         String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";//tanda tanya binable parameter(bind_param)
         PreparedStatement ps = conn.prepareStatement(sql);//pelingdung untuk si query
         ps.setInt(1, idKaryawan);
         ps.setInt(2, idProyek);
         ps.setString(3, peran);
       
//         kalau combo box nulisnya
 
         ps.executeUpdate();//(eksekusi)menyimpan data kedalam basis data
         JOptionPane.showMessageDialog(this, "Data saved successfully");
         loadDatatransaksi();
       } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
     }
     
     //Update Data
    private void updateDatakaryawan() {
      try {
          String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ?WHERE id = ?";
          
          PreparedStatement ps = conn.prepareStatement(sql);//pelingdung untuk si query
          
          ps.setString(1, txtnama.getText());
          ps.setString(2, txtjabatan.getText());
          ps.setString(3, txtdepartemen.getText());
          ps.setInt(4, Integer.parseInt(txtidkaryawan.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data updated successfully");
          loadDatakaryawan();
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
     }
    
    private void updateDataproyek() {

    try {
        String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id_proyek = ?";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setString(1, txtnama1.getText());
        ps.setInt(2, Integer.parseInt(txtdurasi.getText()));
        ps.setInt(3, Integer.parseInt(txtidproyek.getText()));
        
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data updated successfully");
        
        loadDataproyek();
    } catch (SQLException e) {
        System.out.println("Error updating data: " + e.getMessage());
    }


     }
    
    private void updateDatatransaksi() {
      try {
          String selectedKaryawan = (String) cmb_idkaryawan.getSelectedItem();
          String selectedProyek = (String) cmb_idproyek.getSelectedItem();
          String peran = txtperan.getText(); // Mendapatkan nilai peran dari TextField
          int idKaryawan = karyawanMap.get(selectedKaryawan);
          int idProyek = proyekMap.get(selectedProyek);
          String sql = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ? ";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1,peran);
          ps.setInt(2, idKaryawan);
          ps.setInt(3, idProyek);
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data updated successfully");
          loadDatatransaksi();
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
     }
    
    //Delete Data
    private void deleteDatakaryawan() {
     try  {
          String sql = "DELETE FROM karyawan WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, Integer.parseInt(txtidkaryawan.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data deleted successfully");
          loadDatakaryawan();
     } catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
    }
    
     private void deleteDataproyek() {
     try  {
          String sql = "DELETE FROM proyek WHERE id_proyek = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, Integer.parseInt(txtidproyek.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data deleted successfully");
          loadDataproyek();
     } catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
    }
     
     private void deleteDatatransaksi() {
    try {
        String selectedKaryawan = (String) cmb_idkaryawan.getSelectedItem();
        String selectedProyek = (String) cmb_idproyek.getSelectedItem();
        int idKaryawan = karyawanMap.get(selectedKaryawan);
        int idProyek = proyekMap.get(selectedProyek);

        String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idKaryawan);
        ps.setInt(2, idProyek);
        
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data deleted successfully");
        
        loadDatatransaksi();
    } catch (SQLException e) {
        System.out.println("Error deleting data: " + e.getMessage());
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtidkaryawan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtjabatan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtdepartemen = new javax.swing.JTextField();
        btnsimpan = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtidproyek = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtnama1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtdurasi = new javax.swing.JTextField();
        btnsimpan1 = new javax.swing.JButton();
        btnupdate1 = new javax.swing.JButton();
        btnreset1 = new javax.swing.JButton();
        btndelete1 = new javax.swing.JButton();
        btnkeluar1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtperan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmb_idkaryawan = new javax.swing.JComboBox<>();
        cmb_idproyek = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel4.setBackground(new java.awt.Color(0, 102, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID KARYAWAN :");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 110, -1));

        txtidkaryawan.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.add(txtidkaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 160, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NAMA                :");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 100, -1));

        txtnama.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 160, -1));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("JABATAN           :");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 110, -1));

        txtjabatan.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.add(txtjabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 160, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DEPARTEMEN   :");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 110, -1));

        txtdepartemen.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.add(txtdepartemen, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 160, -1));

        btnsimpan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        jPanel4.add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        btnupdate.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel4.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, -1));

        btnreset.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        jPanel4.add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, -1));

        btndelete.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel4.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));

        btnkeluar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnkeluar.setText("Keluar");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });
        jPanel4.add(btnkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        tbl_karyawan.setBackground(new java.awt.Color(0, 102, 153));
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

        jPanel5.add(jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Form Karyawan", jPanel1);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 102, 153));
        jPanel7.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID PROYEK       :");
        jPanel7.add(jLabel5);
        jLabel5.setBounds(50, 30, 100, 15);

        txtidproyek.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.add(txtidproyek);
        txtidproyek.setBounds(170, 30, 190, 22);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NAMA PROYEK :");
        jPanel7.add(jLabel6);
        jLabel6.setBounds(50, 70, 110, 15);

        txtnama1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.add(txtnama1);
        txtnama1.setBounds(170, 70, 190, 22);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DURASI            :");
        jPanel7.add(jLabel7);
        jLabel7.setBounds(50, 110, 90, 15);

        txtdurasi.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.add(txtdurasi);
        txtdurasi.setBounds(170, 110, 190, 22);

        btnsimpan1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnsimpan1.setText("Simpan");
        btnsimpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpan1ActionPerformed(evt);
            }
        });
        jPanel7.add(btnsimpan1);
        btnsimpan1.setBounds(60, 160, 72, 22);

        btnupdate1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnupdate1.setText("Update");
        btnupdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdate1ActionPerformed(evt);
            }
        });
        jPanel7.add(btnupdate1);
        btnupdate1.setBounds(210, 160, 72, 22);

        btnreset1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnreset1.setText("Reset");
        btnreset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreset1ActionPerformed(evt);
            }
        });
        jPanel7.add(btnreset1);
        btnreset1.setBounds(420, 40, 72, 22);

        btndelete1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btndelete1.setText("Delete");
        btndelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelete1ActionPerformed(evt);
            }
        });
        jPanel7.add(btndelete1);
        btndelete1.setBounds(420, 90, 72, 22);

        btnkeluar1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnkeluar1.setText("Keluar");
        btnkeluar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluar1ActionPerformed(evt);
            }
        });
        jPanel7.add(btnkeluar1);
        btnkeluar1.setBounds(420, 160, 72, 22);

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 260));

        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        tbl_proyek.setBackground(new java.awt.Color(0, 102, 153));
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
        jScrollPane3.setViewportView(tbl_proyek);

        jPanel8.add(jScrollPane3);

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 550, 230));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Form Proyek", jPanel2);

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(0, 102, 153));
        jPanel10.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ID KARYAWAN :");
        jPanel10.add(jLabel8);
        jLabel8.setBounds(50, 30, 110, 15);

        txtperan.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.add(txtperan);
        txtperan.setBounds(170, 110, 180, 22);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID PROYEK       :");
        jPanel10.add(jLabel9);
        jLabel9.setBounds(50, 70, 100, 15);

        cmb_idkaryawan.setBackground(new java.awt.Color(204, 204, 204));
        cmb_idkaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel10.add(cmb_idkaryawan);
        cmb_idkaryawan.setBounds(170, 30, 180, 22);

        cmb_idproyek.setBackground(new java.awt.Color(204, 204, 204));
        cmb_idproyek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel10.add(cmb_idproyek);
        cmb_idproyek.setBounds(170, 70, 180, 22);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("PERAN              :");
        jPanel10.add(jLabel11);
        jLabel11.setBounds(50, 110, 110, 15);

        jButton11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton11.setText("Simpan");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton11);
        jButton11.setBounds(110, 160, 72, 22);

        jButton12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton12.setText("Update");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton12);
        jButton12.setBounds(250, 160, 72, 22);

        jButton13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton13.setText("Reset");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton13);
        jButton13.setBounds(410, 40, 72, 22);

        jButton14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton14.setText("Delete");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton14);
        jButton14.setBounds(410, 90, 72, 22);

        jButton15.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton15.setText("Keluar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton15);
        jButton15.setBounds(410, 160, 72, 22);

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 250));

        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        tbl_transaksi.setBackground(new java.awt.Color(0, 102, 153));
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
        jScrollPane2.setViewportView(tbl_transaksi);

        jPanel11.add(jScrollPane2);

        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 550, 250));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        saveDatakaryawan();
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        txtidkaryawan.setText("");
        txtnama.setText("");
        txtjabatan.setText("");
        txtdepartemen.setText("");
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void btnsimpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpan1ActionPerformed
        // TODO add your handling code here:
        saveDataproyek();
    }//GEN-LAST:event_btnsimpan1ActionPerformed

    private void btnupdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdate1ActionPerformed
        // TODO add your handling code here:
        updateDataproyek();
    }//GEN-LAST:event_btnupdate1ActionPerformed

    private void btnreset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreset1ActionPerformed
        // TODO add your handling code here:
        txtidproyek.setText("");
        txtnama1.setText("");
        txtdurasi.setText("");
    }//GEN-LAST:event_btnreset1ActionPerformed

    private void btnkeluar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluar1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnkeluar1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        saveDatatransaksi();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        updateDatatransaksi();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        cmb_idkaryawan.setSelectedItem("");
        cmb_idproyek.setSelectedItem("");
        txtperan.setText("");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        updateDatakaryawan();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        deleteDatakaryawan();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btndelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelete1ActionPerformed
        // TODO add your handling code here:
        deleteDataproyek();
    }//GEN-LAST:event_btndelete1ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        deleteDatatransaksi();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton15ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btndelete1;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnkeluar1;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnreset1;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnsimpan1;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton btnupdate1;
    private javax.swing.JComboBox<String> cmb_idkaryawan;
    private javax.swing.JComboBox<String> cmb_idproyek;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTextField txtdepartemen;
    private javax.swing.JTextField txtdurasi;
    private javax.swing.JTextField txtidkaryawan;
    private javax.swing.JTextField txtidproyek;
    private javax.swing.JTextField txtjabatan;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnama1;
    private javax.swing.JTextField txtperan;
    // End of variables declaration//GEN-END:variables

}
