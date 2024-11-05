/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modul5;

import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Modul_55 extends javax.swing.JFrame {
        Connection conn;
        private DefaultTableModel modelkaryawan;
        private DefaultTableModel modelproyek;
        private DefaultTableModel modeltransaksi;
      
        HashMap<String, Integer> karyawanMap = new HashMap<>(); 
        HashMap<String, Integer> proyekMap = new HashMap<>();

        public Modul_55() {
        initComponents();
        
        //public main
        conn = koneksi.getConnection();

        modelkaryawan = new DefaultTableModel();
        tbl_karyawan.setModel(modelkaryawan);

        modelkaryawan.addColumn("ID KARYAWAN");
        modelkaryawan.addColumn("NAMA");
        modelkaryawan.addColumn("JABATAN");
        modelkaryawan.addColumn("DEPARTEMEN");

        loadDatakaryawan();
        
        
        modelproyek = new DefaultTableModel();
        tbl_proyek.setModel(modelproyek);

        modelproyek.addColumn("ID PROYEK");
        modelproyek.addColumn("NAMA PROYEK ");
        modelproyek.addColumn("DURASI");

        loadDataproyek();
        
        
         modeltransaksi = new DefaultTableModel();
        tbl_transaksi.setModel(modeltransaksi);

        modeltransaksi.addColumn("ID KARYAWAN");
        modeltransaksi.addColumn("ID PROYEK ");
        modeltransaksi.addColumn("PERAN");

        loadDatatransaksi();
        loadDatatransaksi1();
        //end public main
    
    }

    private void loadDatakaryawan() {
      modelkaryawan.setRowCount(0);

      try {
          String sql = "SELECT * FROM karyawan";
           PreparedStatement ps = conn.prepareStatement(sql);//menyiapkan query
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             modelkaryawan.addRow(new Object[]{
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
      modelproyek.setRowCount(0);

      try {
          String sql = "SELECT * FROM proyek";
           PreparedStatement ps = conn.prepareStatement(sql);//menyiapkan query
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             modelproyek.addRow(new Object[]{
             rs.getInt("id"),
             rs.getString("nama_proyek"),
             rs.getString("durasi_pengerjaan")
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }
    private void loadDatatransaksi1() {
      modeltransaksi.setRowCount(0);

      try {
          String sql = "SELECT * FROM transaksi";
           PreparedStatement ps = conn.prepareStatement(sql);//menyiapkan query
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             modeltransaksi.addRow(new Object[]{
             rs.getInt("id_karyawan"),
             rs.getString("id_proyek"),
             rs.getString("peran")
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }
    
    private void loadDatatransaksi() {
         String proyek= "SELECT  id,nama_proyek FROM proyek"; 
         String karyawan = "SELECT id,nama FROM karyawan"; 

    try (PreparedStatement psProyek = conn.prepareStatement(proyek);
         ResultSet rsProyek = psProyek.executeQuery()) {

        while (rsProyek.next()) {
            String namaProyek = rsProyek.getString("nama_proyek"); 
            cmb_idproyek.addItem(namaProyek);
            int idProyek = rsProyek.getInt("id");
            proyekMap.put(namaProyek, idProyek);
        }
    } catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
        }

    try (PreparedStatement psKaryawan = conn.prepareStatement(karyawan);
         ResultSet rsKaryawan = psKaryawan.executeQuery()) {

        while (rsKaryawan.next()) {
            String namaKaryawan = rsKaryawan.getString("nama"); // Ganti nama kolom sesuai tabel
            cmb_idkaryawan.addItem(namaKaryawan);
            int idKaryawan = rsKaryawan.getInt("id");
            karyawanMap.put(namaKaryawan, idKaryawan);
        }
    } catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
    }   

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_namakaryawan = new javax.swing.JTextField();
        tf_jabatan = new javax.swing.JTextField();
        tf_departemen = new javax.swing.JTextField();
        tf_idkaryawan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        resetkaryawan = new javax.swing.JButton();
        exitkaryawan = new javax.swing.JButton();
        updatekaryawan = new javax.swing.JButton();
        deletekaryawan = new javax.swing.JButton();
        savekaryawan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_namaproyek = new javax.swing.JTextField();
        tf_durasi = new javax.swing.JTextField();
        tf_idproyek = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        exitproyek = new javax.swing.JButton();
        saveproyek = new javax.swing.JButton();
        updateproyek = new javax.swing.JButton();
        deleteproyek = new javax.swing.JButton();
        resetproyek = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tf_peran = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmb_idkaryawan = new javax.swing.JComboBox<>();
        cmb_idproyek = new javax.swing.JComboBox<>();
        exittransaksi = new javax.swing.JButton();
        savetransaksi = new javax.swing.JButton();
        updatetransaksi = new javax.swing.JButton();
        deletetransaksi = new javax.swing.JButton();
        resettransaksi = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 153, 153));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("NAMA:");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(30, 50, 50, 20);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("JABATAN:");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(30, 80, 80, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("DEPARTEMEN:");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(30, 110, 110, 20);

        tf_namakaryawan.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.add(tf_namakaryawan);
        tf_namakaryawan.setBounds(140, 50, 370, 22);

        tf_jabatan.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.add(tf_jabatan);
        tf_jabatan.setBounds(140, 80, 370, 22);

        tf_departemen.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.add(tf_departemen);
        tf_departemen.setBounds(140, 110, 370, 22);

        tf_idkaryawan.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.add(tf_idkaryawan);
        tf_idkaryawan.setBounds(140, 20, 370, 22);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("ID KARYAWAN:");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(30, 20, 110, 20);

        resetkaryawan.setBackground(new java.awt.Color(255, 153, 153));
        resetkaryawan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        resetkaryawan.setText("RESET");
        resetkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetkaryawanActionPerformed(evt);
            }
        });
        jPanel4.add(resetkaryawan);
        resetkaryawan.setBounds(420, 150, 90, 60);

        exitkaryawan.setBackground(new java.awt.Color(255, 153, 153));
        exitkaryawan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exitkaryawan.setText("EXIT");
        exitkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitkaryawanActionPerformed(evt);
            }
        });
        jPanel4.add(exitkaryawan);
        exitkaryawan.setBounds(30, 150, 110, 60);

        updatekaryawan.setBackground(new java.awt.Color(255, 153, 153));
        updatekaryawan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updatekaryawan.setText("UPDATE");
        updatekaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatekaryawanActionPerformed(evt);
            }
        });
        jPanel4.add(updatekaryawan);
        updatekaryawan.setBounds(240, 150, 90, 60);

        deletekaryawan.setBackground(new java.awt.Color(255, 153, 153));
        deletekaryawan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deletekaryawan.setText("DELETE");
        deletekaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletekaryawanActionPerformed(evt);
            }
        });
        jPanel4.add(deletekaryawan);
        deletekaryawan.setBounds(330, 150, 90, 60);

        savekaryawan.setBackground(new java.awt.Color(255, 153, 153));
        savekaryawan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        savekaryawan.setText("SAVE");
        savekaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savekaryawanActionPerformed(evt);
            }
        });
        jPanel4.add(savekaryawan);
        savekaryawan.setBounds(140, 150, 100, 60);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 230));

        tbl_karyawan.setBackground(new java.awt.Color(255, 204, 204));
        tbl_karyawan.setForeground(new java.awt.Color(102, 102, 102));
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 480, 290));

        jTabbedPane1.addTab("Form Karyawan", jPanel1);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));
        jPanel7.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("NAMA PROYEK:");
        jPanel7.add(jLabel5);
        jLabel5.setBounds(30, 50, 110, 20);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("DURASI:");
        jPanel7.add(jLabel6);
        jLabel6.setBounds(30, 80, 80, 20);

        tf_namaproyek.setBackground(new java.awt.Color(255, 204, 204));
        jPanel7.add(tf_namaproyek);
        tf_namaproyek.setBounds(140, 50, 370, 22);

        tf_durasi.setBackground(new java.awt.Color(255, 204, 204));
        jPanel7.add(tf_durasi);
        tf_durasi.setBounds(140, 80, 370, 22);

        tf_idproyek.setBackground(new java.awt.Color(255, 204, 204));
        jPanel7.add(tf_idproyek);
        tf_idproyek.setBounds(140, 20, 370, 22);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("ID PROYEK:");
        jPanel7.add(jLabel8);
        jLabel8.setBounds(30, 20, 110, 20);

        exitproyek.setBackground(new java.awt.Color(255, 153, 153));
        exitproyek.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exitproyek.setText("EXIT");
        exitproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitproyekActionPerformed(evt);
            }
        });
        jPanel7.add(exitproyek);
        exitproyek.setBounds(30, 150, 110, 60);

        saveproyek.setBackground(new java.awt.Color(255, 153, 153));
        saveproyek.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saveproyek.setText("SAVE");
        saveproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveproyekActionPerformed(evt);
            }
        });
        jPanel7.add(saveproyek);
        saveproyek.setBounds(140, 150, 100, 60);

        updateproyek.setBackground(new java.awt.Color(255, 153, 153));
        updateproyek.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updateproyek.setText("UPDATE");
        updateproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateproyekActionPerformed(evt);
            }
        });
        jPanel7.add(updateproyek);
        updateproyek.setBounds(240, 150, 90, 60);

        deleteproyek.setBackground(new java.awt.Color(255, 153, 153));
        deleteproyek.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteproyek.setText("DELETE");
        deleteproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteproyekActionPerformed(evt);
            }
        });
        jPanel7.add(deleteproyek);
        deleteproyek.setBounds(330, 150, 90, 60);

        resetproyek.setBackground(new java.awt.Color(255, 153, 153));
        resetproyek.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        resetproyek.setText("RESET");
        resetproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetproyekActionPerformed(evt);
            }
        });
        jPanel7.add(resetproyek);
        resetproyek.setBounds(420, 150, 90, 60);

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 230));

        tbl_proyek.setBackground(new java.awt.Color(255, 204, 204));
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

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 480, 290));

        jTabbedPane1.addTab("Form Proyek", jPanel6);

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));
        jPanel9.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("ID PROYEK:");
        jPanel9.add(jLabel9);
        jLabel9.setBounds(30, 50, 90, 20);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("PERAN:");
        jPanel9.add(jLabel10);
        jLabel10.setBounds(30, 80, 80, 20);

        tf_peran.setBackground(new java.awt.Color(255, 204, 204));
        jPanel9.add(tf_peran);
        tf_peran.setBounds(140, 80, 370, 22);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("ID KARYAWAN:");
        jPanel9.add(jLabel12);
        jLabel12.setBounds(30, 20, 110, 20);

        cmb_idkaryawan.setBackground(new java.awt.Color(255, 204, 204));
        jPanel9.add(cmb_idkaryawan);
        cmb_idkaryawan.setBounds(140, 20, 370, 22);

        cmb_idproyek.setBackground(new java.awt.Color(255, 204, 204));
        jPanel9.add(cmb_idproyek);
        cmb_idproyek.setBounds(140, 50, 370, 22);

        exittransaksi.setBackground(new java.awt.Color(255, 153, 153));
        exittransaksi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exittransaksi.setText("EXIT");
        exittransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exittransaksiActionPerformed(evt);
            }
        });
        jPanel9.add(exittransaksi);
        exittransaksi.setBounds(30, 150, 110, 60);

        savetransaksi.setBackground(new java.awt.Color(255, 153, 153));
        savetransaksi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        savetransaksi.setText("SAVE");
        savetransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savetransaksiActionPerformed(evt);
            }
        });
        jPanel9.add(savetransaksi);
        savetransaksi.setBounds(140, 150, 100, 60);

        updatetransaksi.setBackground(new java.awt.Color(255, 153, 153));
        updatetransaksi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updatetransaksi.setText("UPDATE");
        updatetransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatetransaksiActionPerformed(evt);
            }
        });
        jPanel9.add(updatetransaksi);
        updatetransaksi.setBounds(240, 150, 90, 60);

        deletetransaksi.setBackground(new java.awt.Color(255, 153, 153));
        deletetransaksi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deletetransaksi.setText("DELETE");
        deletetransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletetransaksiActionPerformed(evt);
            }
        });
        jPanel9.add(deletetransaksi);
        deletetransaksi.setBounds(330, 150, 90, 60);

        resettransaksi.setBackground(new java.awt.Color(255, 153, 153));
        resettransaksi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        resettransaksi.setText("RESET");
        resettransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resettransaksiActionPerformed(evt);
            }
        });
        jPanel9.add(resettransaksi);
        resettransaksi.setBounds(420, 150, 90, 60);

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 230));

        tbl_transaksi.setBackground(new java.awt.Color(255, 204, 204));
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

        jPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 480, 290));

        jTabbedPane1.addTab("Form Transaksi", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void savekaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savekaryawanActionPerformed
        if(tf_namakaryawan.getText().isEmpty()||tf_jabatan.getText().isEmpty()||tf_departemen.getText().isEmpty()||tf_idkaryawan.getText().isEmpty()){
    JOptionPane.showMessageDialog(this, "Pastikan Anda sudah mengisi semua.", "Error", JOptionPane.ERROR_MESSAGE);
    return; // Keluar dari metode jika input tidak valid
        }
        try{
         String sql = "INSERT INTO karyawan (nama, jabatan,departemen) VALUES (?, ?,?)";//tanda tanya binable parameter(bind_param)
         PreparedStatement ps = conn.prepareStatement(sql);//pelingdung untuk si query
         ps.setString(1, tf_namakaryawan.getText());
         ps.setString(2, tf_jabatan.getText());
         ps.setString(3, tf_departemen.getText());
 
         ps.executeUpdate();//(eksekusi)menyimpan data kedalam basis data
         JOptionPane.showMessageDialog(this, "Data saved successfully");
         loadDatakaryawan();
         loadDatatransaksi();
       } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }//GEN-LAST:event_savekaryawanActionPerformed

    private void deletekaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletekaryawanActionPerformed
        try  {
          String sql = "DELETE FROM karyawan WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, Integer.parseInt(tf_idkaryawan.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data deleted successfully");
          loadDatakaryawan();
          loadDatatransaksi();
     } catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
    }//GEN-LAST:event_deletekaryawanActionPerformed

    private void exitkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitkaryawanActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitkaryawanActionPerformed
  
    private void updatekaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatekaryawanActionPerformed
        try {
          String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ?WHERE id = ?";
          
          PreparedStatement ps = conn.prepareStatement(sql);//pelingdung untuk si query
          
          ps.setString(1, tf_namakaryawan.getText());
          ps.setString(2, tf_jabatan.getText());
          ps.setString(3, tf_departemen.getText());
          ps.setInt(4, Integer.parseInt(tf_idkaryawan.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data updated successfully");
          loadDatakaryawan();
          loadDatatransaksi();
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
    }//GEN-LAST:event_updatekaryawanActionPerformed

    private void resetkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetkaryawanActionPerformed
        tf_idkaryawan.setText("");
        tf_namakaryawan.setText("");
        tf_jabatan.setText("");
        tf_departemen.setText("");
    }//GEN-LAST:event_resetkaryawanActionPerformed

    
    
    
    
    
    
    
    
    
    private void exitproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitproyekActionPerformed
      System.exit(0);  
    }//GEN-LAST:event_exitproyekActionPerformed

    private void saveproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveproyekActionPerformed
        if(tf_namaproyek.getText().isEmpty()||tf_durasi.getText().isEmpty()){
    JOptionPane.showMessageDialog(this, "Pastikan Anda sudah mengisi semua.", "Error", JOptionPane.ERROR_MESSAGE);
    return; // Keluar dari metode jika input tidak valid
        }
        try{
         String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";//tanda tanya binable parameter(bind_param)
         PreparedStatement ps = conn.prepareStatement(sql);//pelingdung untuk si query
         ps.setString(1, tf_namaproyek.getText());
         ps.setString(2, tf_durasi.getText());
         ps.executeUpdate();//(eksekusi)menyimpan data kedalam basis data
         JOptionPane.showMessageDialog(this, "Data saved successfully");
         loadDataproyek();
         loadDatatransaksi();
       } catch (SQLException e) {
           
         System.out.println("Error Save Data" + e.getMessage());
       }
    }//GEN-LAST:event_saveproyekActionPerformed

    private void updateproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateproyekActionPerformed
     try {
          String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
          
          PreparedStatement ps = conn.prepareStatement(sql);//pelingdung untuk si query
          ps.setString(1, tf_namaproyek.getText());
          ps.setString(2, tf_durasi.getText());
          ps.setInt(3, Integer.parseInt(tf_idproyek.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data updated successfully");
          loadDataproyek();
          loadDatatransaksi();
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }   
    }//GEN-LAST:event_updateproyekActionPerformed

    private void deleteproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteproyekActionPerformed
        try  {
          String sql = "DELETE FROM proyek WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, Integer.parseInt(tf_idproyek.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data deleted successfully");
          loadDataproyek();
          loadDatatransaksi();
     } catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
    }//GEN-LAST:event_deleteproyekActionPerformed

    private void resetproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetproyekActionPerformed
        tf_idproyek.setText("");
        tf_namaproyek.setText("");
        tf_durasi.setText("");
    }//GEN-LAST:event_resetproyekActionPerformed

    
    
    
    
    
    
    
    
    
    
    
    private void exittransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exittransaksiActionPerformed
     System.exit(0);   
    }//GEN-LAST:event_exittransaksiActionPerformed

    private void savetransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savetransaksiActionPerformed
                                              
    // Validasi jika Peran belum diisi
    if (tf_peran.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Pastikan Anda sudah mengisi semua data.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Keluar dari metode jika input tidak valid
    }
    
    try {
        // Ambil nama yang dipilih dari combo box
        String selectedKaryawan = cmb_idkaryawan.getSelectedItem().toString();
        String selectedProyek = cmb_idproyek.getSelectedItem().toString();
        
        // Gunakan HashMap untuk mendapatkan ID yang sesuai
        Integer idKaryawan = karyawanMap.get(selectedKaryawan);
        Integer idProyek = proyekMap.get(selectedProyek);
        
        // Validasi jika ID Karyawan dan ID Proyek tidak ditemukan di HashMap
        if (idKaryawan == null || idProyek == null) {
            JOptionPane.showMessageDialog(this, "ID Karyawan atau ID Proyek tidak valid.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Jika ID tidak ditemukan, keluar dari metode
        }
        
        // Cek apakah idProyek ada di tabel proyek
        String checkProyekQuery = "SELECT COUNT(*) FROM proyek WHERE id = ?";
        PreparedStatement psCheckProyek = conn.prepareStatement(checkProyekQuery);
        psCheckProyek.setInt(1, idProyek);
        ResultSet rsProyek = psCheckProyek.executeQuery();
        if (rsProyek.next() && rsProyek.getInt(1) == 0) {
            JOptionPane.showMessageDialog(this, "ID Proyek tidak ditemukan di database.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Jika ID Proyek tidak ditemukan, keluar dari metode
        }

        // Cek apakah idKaryawan ada di tabel karyawan
        String checkKaryawanQuery = "SELECT COUNT(*) FROM karyawan WHERE id = ?";
        PreparedStatement psCheckKaryawan = conn.prepareStatement(checkKaryawanQuery);
        psCheckKaryawan.setInt(1, idKaryawan);
        ResultSet rsKaryawan = psCheckKaryawan.executeQuery();
        if (rsKaryawan.next() && rsKaryawan.getInt(1) == 0) {
            JOptionPane.showMessageDialog(this, "ID Karyawan tidak ditemukan di database.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Jika ID Karyawan tidak ditemukan, keluar dari metode
        }

        // Siapkan query untuk menyimpan data transaksi
        String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        // Set nilai-nilai parameter untuk query
        ps.setInt(1, idKaryawan); // Menyimpan ID Karyawan
        ps.setInt(2, idProyek);    // Menyimpan ID Proyek
        ps.setString(3, tf_peran.getText()); // Menyimpan Peran
        
        // Eksekusi query untuk memasukkan data
        ps.executeUpdate();
        
        // Tampilkan pesan sukses
        JOptionPane.showMessageDialog(this, "Data saved successfully");
        
        // Muat ulang data transaksi
        loadDatatransaksi();
        loadDatatransaksi1();

    } catch (SQLException e) {
        // Tangani error SQL dan tampilkan pesan kesalahan
        System.out.println("Error Save Data: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_savetransaksiActionPerformed

    private void updatetransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatetransaksiActionPerformed
        try {
        String selectedKaryawan = cmb_idkaryawan.getSelectedItem().toString();
        String selectedProyek = cmb_idproyek.getSelectedItem().toString();

        // Gunakan HashMap untuk mendapatkan ID yang sesuai
        Integer idKaryawan = karyawanMap.get(selectedKaryawan);
        Integer idProyek = proyekMap.get(selectedProyek);
        
          String sql = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek= ?";
          
          PreparedStatement ps = conn.prepareStatement(sql);//pelingdung untuk si query
          ps.setString(1, tf_peran.getText());
          ps.setInt(2, idKaryawan); // Menyimpan ID Karyawan
          ps.setInt(3, idProyek);    // Menyimpan ID Proyek
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data updated successfully");
          loadDatatransaksi1();
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
    }//GEN-LAST:event_updatetransaksiActionPerformed

    private void deletetransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletetransaksiActionPerformed
                                               
    try {
        // Ambil nama yang dipilih dari combo box
        String selectedKaryawan = cmb_idkaryawan.getSelectedItem().toString();
        String selectedProyek = cmb_idproyek.getSelectedItem().toString();

        // Gunakan HashMap untuk mendapatkan ID yang sesuai
        Integer idKaryawan = karyawanMap.get(selectedKaryawan);
        Integer idProyek = proyekMap.get(selectedProyek);

        // Cek jika ID ditemukan
        if (idKaryawan == null || idProyek == null) {
            JOptionPane.showMessageDialog(this, "ID Karyawan atau Proyek tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Query SQL untuk menghapus data
        String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?"; // Pastikan ada spasi antara AND dan kondisi
        PreparedStatement ps = conn.prepareStatement(sql);
        
        // Set parameter untuk ID Karyawan dan ID Proyek
        ps.setInt(1, idKaryawan); // ID Karyawan
        ps.setInt(2, idProyek);    // ID Proyek
        
        // Eksekusi query
        int rowsAffected = ps.executeUpdate();
        
        // Cek jika ada data yang dihapus
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
        } else {
            JOptionPane.showMessageDialog(this, "Tidak ada data yang dihapus. Periksa ID Karyawan dan Proyek.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        
        // Memuat ulang data setelah penghapusan
        loadDatatransaksi1();
    } catch (SQLException e) {
        // Tampilkan pesan error jika ada masalah dengan query
        System.out.println("Error saat menghapus data: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data.", "Error", JOptionPane.ERROR_MESSAGE);
    }
  
 
    }//GEN-LAST:event_deletetransaksiActionPerformed

    private void resettransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resettransaksiActionPerformed
        cmb_idkaryawan.setSelectedItem("");
        cmb_idproyek.setSelectedItem("");
        tf_peran.setText("");
                                 
    }//GEN-LAST:event_resettransaksiActionPerformed

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
            java.util.logging.Logger.getLogger(Modul_55.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modul_55.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modul_55.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modul_55.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modul_55().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_idkaryawan;
    private javax.swing.JComboBox<String> cmb_idproyek;
    private javax.swing.JButton deletekaryawan;
    private javax.swing.JButton deleteproyek;
    private javax.swing.JButton deletetransaksi;
    private javax.swing.JButton exitkaryawan;
    private javax.swing.JButton exitproyek;
    private javax.swing.JButton exittransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton resetkaryawan;
    private javax.swing.JButton resetproyek;
    private javax.swing.JButton resettransaksi;
    private javax.swing.JButton savekaryawan;
    private javax.swing.JButton saveproyek;
    private javax.swing.JButton savetransaksi;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTextField tf_departemen;
    private javax.swing.JTextField tf_durasi;
    private javax.swing.JTextField tf_idkaryawan;
    private javax.swing.JTextField tf_idproyek;
    private javax.swing.JTextField tf_jabatan;
    private javax.swing.JTextField tf_namakaryawan;
    private javax.swing.JTextField tf_namaproyek;
    private javax.swing.JTextField tf_peran;
    private javax.swing.JButton updatekaryawan;
    private javax.swing.JButton updateproyek;
    private javax.swing.JButton updatetransaksi;
    // End of variables declaration//GEN-END:variables
}
