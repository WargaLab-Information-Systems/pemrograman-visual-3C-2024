/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pemvis.modul5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**

/**
 *
 * @author HP
 */
public class main extends javax.swing.JFrame {
    //inisiasi GLobal Variable
    Connection conn;
    private DefaultTableModel model;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    HashMap<String, Integer> karyawanMap = new HashMap<>(); 
    HashMap<String, Integer> proyekMap = new HashMap<>();

    
    //end global variable
    
    public main() {
        initComponents();
        //public main
    conn = koneksi.getConnection();

    model = new DefaultTableModel();
    tblkaryawan.setModel(model);
    

    model.addColumn("ID");
    model.addColumn("Nama");
    model.addColumn("Jabatan");
    model.addColumn("Departemen");

    loadData();
    
    model1 = new DefaultTableModel();
    tblproyek.setModel(model1);
    

    model1.addColumn("ID");
    model1.addColumn("Nama_proyek");
    model1.addColumn("Durasi_pengerjaan");

    loadData1();
    
    model2 = new DefaultTableModel();
    tbltransaksi.setModel(model2);
    

    model2.addColumn("ID_karyawan");
    model2.addColumn("ID_proyek");
    model2.addColumn("Peran");

    loadData2();
    

    //end public main
    }
    
    //Load Data karyawan
    private void loadData() {
      model.setRowCount(0);

      try {
          String sql = "SELECT * FROM karyawan";
          PreparedStatement ps = conn.prepareStatement(sql);//menyiapkan query 
          ResultSet rs = ps.executeQuery();//menyimpan data
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
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
    //end Load Data
    
    //Load Data proyek
    private void loadData1() {
      model1.setRowCount(0);

      try {
          String sql = "SELECT * FROM proyek";
          PreparedStatement ps = conn.prepareStatement(sql);//menyiapkan query 
          ResultSet rs = ps.executeQuery();//menyimpan data
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             model1.addRow(new Object[]{
             rs.getInt("id"),
             rs.getString("nama_proyek"),
             rs.getInt("durasi_pengerjaan")
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }
    //end Load Data
    
    //Load Data proyek
    private void loadData2() {
    String proyek= "SELECT id, Nama_Proyek FROM proyek"; 
    String karyawan = "SELECT id, Nama FROM karyawan"; 
    cbxproyek.removeAllItems();
    cbxkaryawan.removeAllItems();
   
    
    try (PreparedStatement psKaryawan = conn.prepareStatement(karyawan);
         ResultSet rsKaryawan = psKaryawan.executeQuery()) {

        while (rsKaryawan.next()) {
            String namaKaryawan = rsKaryawan.getString("id");
            cbxkaryawan.addItem(namaKaryawan);
            
        }
    } catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
    }
    
    try (PreparedStatement psProyek = conn.prepareStatement(proyek);
         ResultSet rsProyek = psProyek.executeQuery()) {

        while (rsProyek.next()) {
            String namaProyek = rsProyek.getString("id"); 
            cbxproyek.addItem(namaProyek);
        }
    } catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
    }
    model2.setRowCount(0);

      try {
          String sql = "SELECT * FROM transaksi";
          PreparedStatement ps = conn.prepareStatement(sql);//menyiapkan query 
          ResultSet rs = ps.executeQuery();//menyimpan data
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             model2.addRow(new Object[]{
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
    private void saveData() {
      try{
        if (txtnama.getText().trim().isEmpty() || txtjabatan.getText().trim().isEmpty()|| txtdepartemen.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return; // Menghentikan proses jika ada field yang kosong     
        }
         String sql = "INSERT INTO karyawan (id, nama, jabatan, departemen) VALUES (?, ?, ?, ?)";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setInt(1, Integer.parseInt(txtid.getText())); 
         ps.setString(2, txtnama.getText());
         ps.setString(3, txtjabatan.getText());
         ps.setString(4, txtdepartemen.getText());
         ps.executeUpdate();
         JOptionPane.showMessageDialog(this, "Data saved successfully");
         
         //
         loadData();
       } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
         JOptionPane.showMessageDialog(null, "Mohon Diisi terlebih Dahulu");
       }
     }
    //End Simpan Data
    
    
    
    //Update Data
    private void updateData() {
      try {
          if (txtnama.getText().trim().isEmpty() || txtjabatan.getText().trim().isEmpty()|| txtdepartemen.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return; // Menghentikan proses jika ada field yang kosong
          }
          String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, txtnama.getText());
          ps.setString(2, txtjabatan.getText());
          ps.setString(3, txtdepartemen.getText());
          ps.setInt(4, Integer.parseInt(txtid.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data updated successfully");
          loadData();
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
     }
    //End Update Data
    
    private void deleteData() {
     try  {
         if (txtnama.getText().trim().isEmpty() || txtjabatan.getText().trim().isEmpty()|| txtdepartemen.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return; // Menghentikan proses jika ada field yang kosong
          }
          String sql = "DELETE FROM karyawan WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, Integer.parseInt(txtid.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data deleted successfully");
          loadData();
          
     }catch (SQLException e) {
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

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btntambah = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtjabatan = new javax.swing.JTextField();
        txtdepartemen = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblkaryawan = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btntambah2 = new javax.swing.JButton();
        btnupdate2 = new javax.swing.JButton();
        btndelete2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtid2 = new javax.swing.JTextField();
        txtnamaproyek = new javax.swing.JTextField();
        txtdurasipengerjaan = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblproyek = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btntambah3 = new javax.swing.JButton();
        btnupdate3 = new javax.swing.JButton();
        btndelete3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtperan = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbltransaksi = new javax.swing.JTable();
        cbxkaryawan = new javax.swing.JComboBox<>();
        cbxproyek = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setText("KARYAWAN");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 88, -1));

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        btntambah.setText("TAMBAH");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        jPanel3.add(btntambah, new java.awt.GridBagConstraints());

        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel3.add(btnupdate, new java.awt.GridBagConstraints());

        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel3.add(btndelete, new java.awt.GridBagConstraints());

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 260, 50));

        jLabel1.setText("ID");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel3.setText("Nama");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel4.setText("Jabatan");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel5.setText("Departemen");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));
        jPanel2.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 250, -1));
        jPanel2.add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 250, -1));

        txtjabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjabatanActionPerformed(evt);
            }
        });
        jPanel2.add(txtjabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 250, -1));
        jPanel2.add(txtdepartemen, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 250, -1));

        tblkaryawan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblkaryawan);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 430, 280));

        jPanel5.add(jPanel2);
        jPanel2.setBounds(0, 0, 470, 610);

        jTabbedPane2.addTab("FORM KARYAWAN", jPanel5);

        jPanel1.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(153, 204, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel7.setText("PROYEK");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 60, -1));

        jPanel7.setBackground(new java.awt.Color(0, 102, 255));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        btntambah2.setText("TAMBAH");
        btntambah2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambah2ActionPerformed(evt);
            }
        });
        jPanel7.add(btntambah2, new java.awt.GridBagConstraints());

        btnupdate2.setText("UPDATE");
        btnupdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdate2ActionPerformed(evt);
            }
        });
        jPanel7.add(btnupdate2, new java.awt.GridBagConstraints());

        btndelete2.setText("DELETE");
        btndelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelete2ActionPerformed(evt);
            }
        });
        jPanel7.add(btndelete2, new java.awt.GridBagConstraints());

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 260, 50));

        jLabel8.setText("ID");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel9.setText("Nama Proyek");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 20));

        jLabel10.setText("Durasi Pengerjaan");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));
        jPanel6.add(txtid2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 250, -1));
        jPanel6.add(txtnamaproyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 250, -1));

        txtdurasipengerjaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdurasipengerjaanActionPerformed(evt);
            }
        });
        jPanel6.add(txtdurasipengerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 250, -1));

        tblproyek.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblproyek);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 430, 280));

        jPanel1.add(jPanel6);
        jPanel6.setBounds(0, 0, 470, 610);

        jTabbedPane2.addTab("FORM PROYEK", jPanel1);

        jPanel8.setLayout(null);

        jPanel9.setBackground(new java.awt.Color(153, 204, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel11.setText("TRANSAKSI");
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 88, -1));

        jPanel10.setBackground(new java.awt.Color(0, 102, 255));
        jPanel10.setLayout(new java.awt.GridBagLayout());

        btntambah3.setText("TAMBAH");
        btntambah3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambah3ActionPerformed(evt);
            }
        });
        jPanel10.add(btntambah3, new java.awt.GridBagConstraints());

        btnupdate3.setText("UPDATE");
        btnupdate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdate3ActionPerformed(evt);
            }
        });
        jPanel10.add(btnupdate3, new java.awt.GridBagConstraints());

        btndelete3.setText("DELETE");
        btndelete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelete3ActionPerformed(evt);
            }
        });
        jPanel10.add(btndelete3, new java.awt.GridBagConstraints());

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 260, 50));

        jLabel12.setText("ID Karyawan");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel13.setText("ID Proyek");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 20));

        jLabel14.setText("Peran");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 40, -1));

        txtperan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtperanActionPerformed(evt);
            }
        });
        jPanel9.add(txtperan, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 250, -1));

        tbltransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tbltransaksi);

        jPanel9.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 430, 290));

        cbxkaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel9.add(cbxkaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 250, -1));

        cbxproyek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel9.add(cbxproyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 250, -1));

        jPanel8.add(jPanel9);
        jPanel9.setBounds(0, 0, 460, 610);

        jTabbedPane2.addTab("FORM TRANSAKSI", jPanel8);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 470, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
        saveData();
    }//GEN-LAST:event_btntambahActionPerformed

    private void txtjabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjabatanActionPerformed

    private void btntambah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambah2ActionPerformed
        // TODO add your handling code here:
        try{
         if (txtid.getText().trim().isEmpty() || txtnamaproyek.getText().trim().isEmpty()|| txtdurasipengerjaan.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return; // Menghentikan proses jika ada field yang kosong
          }
         String sql = "INSERT INTO proyek (id, nama_proyek, durasi_pengerjaan) VALUES (?, ?, ?)";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setInt(1, Integer.parseInt(txtid2.getText())); 
         ps.setString(2, txtnamaproyek.getText());
         ps.setInt(3, Integer.parseInt(txtdurasipengerjaan.getText()));
         ps.executeUpdate();
         JOptionPane.showMessageDialog(this, "Data saved successfully");
         //
         loadData1();
       } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }//GEN-LAST:event_btntambah2ActionPerformed

    private void txtdurasipengerjaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdurasipengerjaanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdurasipengerjaanActionPerformed

    private void btntambah3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambah3ActionPerformed
    // TODO add your handling code here:
    if(txtperan.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Mohon Di isi Terlebih dahulu","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else{
            try{
                String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, cbxkaryawan.getSelectedItem().toString());
                ps.setString(2, cbxproyek.getSelectedItem().toString());
                ps.setString(3, txtperan.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data saved successfully");
                loadData2();
            } catch (SQLException e) {
                System.out.println("Error Save Data" + e.getMessage());
            }
        }              
    }//GEN-LAST:event_btntambah3ActionPerformed

    private void txtperanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtperanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtperanActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
    // TODO add your handling code here:
    updateData();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
    // TODO add your handling code here:
    deleteData();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnupdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdate2ActionPerformed
         try {
             if (txtid.getText().trim().isEmpty() || txtnamaproyek.getText().trim().isEmpty()|| txtdurasipengerjaan.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return; // Menghentikan proses jika ada field yang kosong
          }
          String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, txtnamaproyek.getText());
          ps.setInt(2, Integer.parseInt(txtdurasipengerjaan.getText()));
          ps.setInt(3, Integer.parseInt(txtid2.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data updated successfully");
          loadData1();
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
// TODO add your handling code here:
    }//GEN-LAST:event_btnupdate2ActionPerformed

    private void btnupdate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdate3ActionPerformed
        // TODO add your handling code here:
         if(txtperan.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Mohon Di isi Terlebih dahulu","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else{
    try {
           // Validasi apakah semua field telah diisi
            if (txtperan.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return; // Menghentikan proses jika ada field yang kosong
            }

            String selectedKaryawan = (String) cbxkaryawan.getSelectedItem();
            String selectedProyek = (String) cbxproyek.getSelectedItem();
            String peran = txtperan.getText(); // Mendapatkan nilai peran dari TextField

            // Perbarui data transaksi di database
            String sqlUpdate = "UPDATE transaksi SET Peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sqlUpdate);
            ps.setString(1, peran);    // Menyimpan nilai peran yang baru
            ps.setInt(2, Integer.parseInt(selectedKaryawan));  // Berdasarkan id_karyawan
            ps.setInt(3, Integer.parseInt(selectedProyek));    // Berdasarkan id_proyek
            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil diperbarui!", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan atau tidak ada perubahan.", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
            }
            
             // Refresh data setelah update
            loadData2();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    
         }
    }//GEN-LAST:event_btnupdate3ActionPerformed

    private void btndelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelete2ActionPerformed
        try  {
            if (txtid.getText().trim().isEmpty() || txtnamaproyek.getText().trim().isEmpty()|| txtdurasipengerjaan.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data Gagal Di Hapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return; // Menghentikan proses jika ada field yang kosong
            }
            String sql = "DELETE FROM proyek WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txtid2.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data deleted successfully");
            loadData1();
        }catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btndelete2ActionPerformed

    private void btndelete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelete3ActionPerformed
        // TODO add your handling code here:
         if(txtperan.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Delete Tidak Berhasil","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else{
        try{
            String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(cbxkaryawan.getSelectedItem().toString()));
            ps.setInt(2, Integer.parseInt(cbxproyek.getSelectedItem().toString()));
            ps.execute();
            JOptionPane.showMessageDialog(this, "Data yang di Hapus Sukses");
            loadData2();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
         }
    }//GEN-LAST:event_btndelete3ActionPerformed

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btndelete2;
    private javax.swing.JButton btndelete3;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton btntambah2;
    private javax.swing.JButton btntambah3;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton btnupdate2;
    private javax.swing.JButton btnupdate3;
    private javax.swing.JComboBox<String> cbxkaryawan;
    private javax.swing.JComboBox<String> cbxproyek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tblkaryawan;
    private javax.swing.JTable tblproyek;
    private javax.swing.JTable tbltransaksi;
    private javax.swing.JTextField txtdepartemen;
    private javax.swing.JTextField txtdurasipengerjaan;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtid2;
    private javax.swing.JTextField txtjabatan;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnamaproyek;
    private javax.swing.JTextField txtperan;
    // End of variables declaration//GEN-END:variables
}
