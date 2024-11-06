package crud5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WINEXCOM
 */
public class FrameMain extends javax.swing.JFrame {

    Connection conn;
    private DefaultTableModel model;
    private DefaultTableModel Gaya;
    private DefaultTableModel Model;
    
    
    public FrameMain() {
        initComponents();
        conn = koneksi.getConnection();
        
        model = new DefaultTableModel();
        tbl_karyawan.setModel(model);
        
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Jabatan");
        model.addColumn("Departemen");
        
        loadData();
        
        
        Gaya = new DefaultTableModel();
        tbl_proyek.setModel(Gaya);
        
        Gaya.addColumn("ID");
        Gaya.addColumn("Nama");
        Gaya.addColumn("Durasi");
        
        loadDataProyek();
        
        
        Model = new DefaultTableModel();
        tbl_transaksi.setModel(Model);
        
        Model.addColumn("ID");
        Model.addColumn("Nama Karyawan");
        Model.addColumn("Nama Proyek");
        Model.addColumn("Peran");
        
        loadDataTransaksi();
    }
    
        
    //AMBIL DATA KARYAWAN
    private void loadData() {
    model.setRowCount(0);
    cmb_karyawan.removeAllItems();
    
    try {
        String sql = "SELECT * FROM tb_karyawan";
        String sqli = "SELECT id, nama, jabatan, departemen FROM tb_karyawan";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        PreparedStatement psi = conn.prepareStatement(sqli);
        ResultSet rsi = psi.executeQuery();
        while (rs.next()) {
           // Menambahkan baris ke dalam model tabel
           model.addRow(new Object[]{
           rs.getInt("id"),
           rs.getString("nama"),
           rs.getString("jabatan"),
           rs.getString("departemen")      
         });
           
        while (rsi.next()) {
            String tampilan = String.format("%s", 
                rsi.getString("nama"),
                rsi.getString("jabatan"),
                rsi.getString("departemen")
            );
            cmb_karyawan.addItem(tampilan);
        }
        }
    } catch (SQLException e) {
       System.out.println("Error Save Data" + e.getMessage());
     }
  }
    
    //AMBIL DATA PROYEK
    private void loadDataProyek() {
    Gaya.setRowCount(0);
    cmb_proyek.removeAllItems();
    
    try {
        String sql = "SELECT * FROM proyek";
        String sqli = "SELECT id, nama, durasi_proyek FROM proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        PreparedStatement psi = conn.prepareStatement(sqli);
        ResultSet rsi = psi.executeQuery();
        while (rs.next()) {
           // Menambahkan baris ke dalam model tabel
           Gaya.addRow(new Object[]{
           rs.getInt("id"),
           rs.getString("nama"),
           rs.getString("durasi_proyek"), 
           
         });
        while (rsi.next()) {
           String tampilan = String.format("%s", 
                rsi.getString("nama"),
                rsi.getString("durasi_proyek")
            );
            cmb_proyek.addItem(tampilan);
        }
           
        }
    } catch (SQLException e) {
       System.out.println("Error Save Data" + e.getMessage());
     }
    
    
  }
    
    //AMBIL DATA TRANSAKSI
    private void loadDataTransaksi() {
    Model.setRowCount(0);
        
    try {
        String sql = "SELECT * FROM Tb_Transaksi";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
           // Menambahkan baris ke dalam model tabel
           Model.addRow(new Object[]{
           rs.getInt("id"),
           rs.getString("id_karyawan"),
           rs.getString("id_proyek"),
           rs.getString("peran")     
         });
        }
    } catch (SQLException e) {
       System.out.println("Error Save Data" + e.getMessage());
     }
  }
    
    
    
    //SIMPAN DATA KARYAWAN
      private void saveData() {
        try{
           String sql = "INSERT INTO tb_karyawan (nama, jabatan, departemen) VALUES (?, ?, ?)";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1, tf_nama.getText());
           ps.setString(2, tf_jabatan.getText());
           ps.setString(3, tf_dep.getText());
           ps.executeUpdate();
           JOptionPane.showMessageDialog(this, "Data saved successfully");
           
           loadData();
         } catch (SQLException e) {
           System.out.println("Error Save Data" + e.getMessage());
         }
       }
      
      //SIMPAN DATA PROYEK
      private void saveDataProyek() {
        try{
           String sql = "INSERT INTO proyek (nama, durasi_proyek) VALUES (?, ?)";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1, tf_namaP.getText());
            ps.setString(2, tf_durasi.getText());
           ps.executeUpdate();
           JOptionPane.showMessageDialog(this, "Data saved successfully");
           
           loadDataProyek();
         } catch (SQLException e) {
           System.out.println("Error Save Data" + e.getMessage());
         }
       }
      
      //SIMPAN DATA TRANSAKSI
     private void saveDataTransaksi() {
        try {
            String sql = "INSERT INTO Tb_Transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            String namaKaryawan = (String) cmb_karyawan.getSelectedItem();
            String idProyek = (String) cmb_proyek.getSelectedItem();

            if (namaKaryawan == null || namaKaryawan.isEmpty() || idProyek == null || idProyek.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select a valid employee and project");
                return;
            }

            ps.setString(1, namaKaryawan);
            ps.setString(2, idProyek);
            ps.setString(3, peran.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data saved successfully");

            loadDataTransaksi();
        } catch (SQLException e) {
            System.out.println("Error Save Data: " + e.getMessage());
        }
    }
     
      
      //UPDATE DATA KARYAWAN
      private void updateData() {
        try {
            String sql = "UPDATE tb_karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tf_nama.getText());
            ps.setString(2, tf_jabatan.getText());
            ps.setString(3, tf_dep.getText());
            ps.setInt(4, Integer.parseInt(tf_id.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data updated successfully");
            
            loadData();
     }  catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
    }
   }
      
      
      //UPDATE DATA PROYEK
       private void updateDataProyek() {
        try {
            String sql = "UPDATE proyek SET nama = ?, durasi_proyek = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tf_namaP.getText());
            ps.setString(2, tf_durasi.getText());
            ps.setInt(3, Integer.parseInt(tf_id1.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data updated successfully");
            
            loadDataProyek();
     }  catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
    }
   }
       
       //UPDATE DATA TRANSAKSI
       private void updateDataTransaksi() {
        try {
            String sql = "UPDATE Tb_Transaksi SET id_karyawan = ?, id_proyek = ?, peran = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            String Karyawan = (String) cmb_karyawan.getSelectedItem();
            String Proyek = (String) cmb_proyek.getSelectedItem();

            if (Karyawan == null || Karyawan.isEmpty() || Proyek == null || Proyek.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select a valid employee and project.");
                return; // Exit the method if validation fails
            }
            
            ps.setString(1, Karyawan);
            ps.setString(2, Proyek);
            ps.setString(3, peran.getText());
            ps.setInt(4, Integer.parseInt(ID_TF.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data saved successfully");

            loadDataTransaksi();
        } catch (SQLException e) {
            System.out.println("Error Save Data: " + e.getMessage());
        }
    }
      
      
      //DELETE DATA KARYAWAN
      private void deleteData() {
        try  {
            String sql = "DELETE FROM tb_karyawan WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(tf_id.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data deleted successfully");
            
            loadData();
     }  catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
  }
}

      private void deleteDataProyek() {
        try  {
            String sql = "DELETE FROM proyek WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(tf_id1.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data deleted successfully");
            
            loadDataProyek();
     }  catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
  }
}
      
      //DELETE DATA KARYAWAN
      private void deleteDataTransaksi() {
        try  {
            String sql = "DELETE FROM Tb_Transaksi WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(ID_TF.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data deleted successfully");
            
            loadDataTransaksi();
     }  catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
        
        
        
        
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        tf_nama = new javax.swing.JTextField();
        tf_jabatan = new javax.swing.JTextField();
        tf_dep = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        Save = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Tabbed2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf_id1 = new javax.swing.JTextField();
        tf_namaP = new javax.swing.JTextField();
        tf_durasi = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        SaveP = new javax.swing.JButton();
        UpdateP = new javax.swing.JButton();
        DeleteP = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmb_karyawan = new javax.swing.JComboBox<>();
        cmb_proyek = new javax.swing.JComboBox<>();
        peran = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        SaveT = new javax.swing.JButton();
        UpdateT = new javax.swing.JButton();
        DeleteT = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        ID_TF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID                   :");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel2.setText("Nama            :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel3.setText("Jabatan         :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel4.setText("Departemen :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));
        jPanel3.add(tf_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 260, -1));

        tf_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_namaActionPerformed(evt);
            }
        });
        jPanel3.add(tf_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 260, -1));
        jPanel3.add(tf_jabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 260, -1));
        jPanel3.add(tf_dep, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 260, -1));

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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 440, 320));

        Save.setText("Simpan");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jPanel3.add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, -1, -1));

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel3.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, -1, -1));

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jPanel3.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Karyawan", jPanel1);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("ID                   :");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel6.setText("Nama            :");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel7.setText("Durasi           :");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));
        jPanel4.add(tf_id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 260, -1));

        tf_namaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_namaPActionPerformed(evt);
            }
        });
        jPanel4.add(tf_namaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 260, -1));
        jPanel4.add(tf_durasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 260, -1));

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

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 440, 320));

        SaveP.setText("Simpan");
        SaveP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavePActionPerformed(evt);
            }
        });
        jPanel4.add(SaveP, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, -1, -1));

        UpdateP.setText("Update");
        UpdateP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatePActionPerformed(evt);
            }
        });
        jPanel4.add(UpdateP, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, -1, -1));

        DeleteP.setText("Delete");
        DeleteP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletePActionPerformed(evt);
            }
        });
        jPanel4.add(DeleteP, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, -1, -1));

        javax.swing.GroupLayout Tabbed2Layout = new javax.swing.GroupLayout(Tabbed2);
        Tabbed2.setLayout(Tabbed2Layout);
        Tabbed2Layout.setHorizontalGroup(
            Tabbed2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Tabbed2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Tabbed2Layout.setVerticalGroup(
            Tabbed2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Proyek", Tabbed2);

        jLabel8.setText("Nama Karyawan   :");

        jLabel9.setText("Nama Proyek        :");

        jLabel10.setText("Peran                     :");

        cmb_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_proyekActionPerformed(evt);
            }
        });

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

        SaveT.setText("Simpan");
        SaveT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveTActionPerformed(evt);
            }
        });

        UpdateT.setText("Update");
        UpdateT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateTActionPerformed(evt);
            }
        });

        DeleteT.setText("Delete");
        DeleteT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteTActionPerformed(evt);
            }
        });

        jLabel11.setText("ID                            :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SaveT)
                            .addComponent(UpdateT)
                            .addComponent(DeleteT)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(ID_TF))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(cmb_karyawan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(cmb_proyek, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(peran, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(ID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(cmb_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(cmb_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(peran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(SaveT)
                        .addGap(18, 18, 18)
                        .addComponent(UpdateT)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteT)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Transaksi", jPanel2);

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

        jTabbedPane1.getAccessibleContext().setAccessibleName("Proyek");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_namaActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        saveData();
    }//GEN-LAST:event_SaveActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        updateData();
    }//GEN-LAST:event_UpdateActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        deleteData();
    }//GEN-LAST:event_DeleteActionPerformed

    private void tf_namaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_namaPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_namaPActionPerformed

    private void SavePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavePActionPerformed
        // TODO add your handling code here:
        saveDataProyek();
        
    }//GEN-LAST:event_SavePActionPerformed

    private void UpdatePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatePActionPerformed
        // TODO add your handling code here:
        updateDataProyek();
        
    }//GEN-LAST:event_UpdatePActionPerformed

    private void DeletePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletePActionPerformed
        // TODO add your handling code here:
        deleteDataProyek();
    }//GEN-LAST:event_DeletePActionPerformed

    private void cmb_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_proyekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_proyekActionPerformed

    private void SaveTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveTActionPerformed
        // TODO add your handling code here:
        saveDataTransaksi();
    }//GEN-LAST:event_SaveTActionPerformed

    private void UpdateTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTActionPerformed
        // TODO add your handling code here:
        updateDataTransaksi();
    }//GEN-LAST:event_UpdateTActionPerformed

    private void DeleteTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteTActionPerformed
        // TODO add your handling code here:
        deleteDataTransaksi();
    }//GEN-LAST:event_DeleteTActionPerformed

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
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton DeleteP;
    private javax.swing.JButton DeleteT;
    private javax.swing.JTextField ID_TF;
    private javax.swing.JButton Save;
    private javax.swing.JButton SaveP;
    private javax.swing.JButton SaveT;
    private javax.swing.JPanel Tabbed2;
    private javax.swing.JButton Update;
    private javax.swing.JButton UpdateP;
    private javax.swing.JButton UpdateT;
    private javax.swing.JComboBox<String> cmb_karyawan;
    private javax.swing.JComboBox<String> cmb_proyek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField peran;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTextField tf_dep;
    private javax.swing.JTextField tf_durasi;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_id1;
    private javax.swing.JTextField tf_jabatan;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_namaP;
    // End of variables declaration//GEN-END:variables
}
