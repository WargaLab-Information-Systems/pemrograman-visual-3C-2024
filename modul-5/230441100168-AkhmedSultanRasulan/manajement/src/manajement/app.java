/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package manajement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//end Import
/**
 *
 * @author Lenovo
 */
public class app extends javax.swing.JFrame {

    ///inisiasi GLobal Variable
    Connection conn;
    private DefaultTableModel karyawan;
    private DefaultTableModel proyek;
    private DefaultTableModel transaksi;
    //end global variable
    public app() {
        initComponents();
        conn = koneksi.getConnection();
        
        proyek = new DefaultTableModel();
        tbl_proyek.setModel(proyek);  
        proyek.addColumn("id");
        proyek.addColumn("nama_proyek");
        proyek.addColumn("durasi");
        
        karyawan = new DefaultTableModel();
        tbl_karyawan.setModel(karyawan);
        karyawan.addColumn("id");
        karyawan.addColumn("nama");
        karyawan.addColumn("jabatan");
        karyawan.addColumn("departemen");
        
        transaksi = new DefaultTableModel();
        tbl_transaksi.setModel(transaksi);
        transaksi.addColumn("id_transaksi");
        transaksi.addColumn("id_karyawan");
        transaksi.addColumn("id_proyek");
        transaksi.addColumn("peran");
        
        loadDatakaryawan();
        loadDataproyek();
        loadDatatransaksi();
        loadcbkaryawan();
        loadcbproyek();
    }
    //Load Data
    private void loadDatakaryawan() {
    karyawan.setRowCount(0);

    try {
        String sql = "SELECT * FROM karyawan";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
           // Menambahkan baris ke dalam model tabel
           karyawan.addRow(new Object[]{
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
  private void loadDataproyek() {
       proyek.setRowCount(0);
    try {
        String sql = "SELECT * FROM proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet pr = ps.executeQuery();
        while (pr.next()) {
           // Menambahkan baris ke dalam model tabel
           proyek.addRow(new Object[]{
           pr.getInt("id"),
           pr.getString("nama_proyek"),
           pr.getString("durasi")
         });
        }
    } catch (SQLException e) {
       System.out.println("Error Save Data" + e.getMessage());
     }
  }  
  
    private void loadDatatransaksi() {
    transaksi.setRowCount(0);
    try {
       String sql = "SELECT * FROM transaksi";
       PreparedStatement ps = conn.prepareStatement(sql);
       ResultSet ts = ps.executeQuery();
       while (ts.next()) {
          // Menambahkan baris ke dalam model tabel
          transaksi.addRow(new Object[]{
          ts.getInt("id_transaksi"),    
          ts.getInt("id_karyawan"),
          ts.getInt("id_proyek"),
          ts.getString("peran")
        });
       }
    }catch (SQLException e) {
      System.out.println("Error Save Data" + e.getMessage());
    }
  }  
    
  //end Load Data
    
    private void loadcbkaryawan() {
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
    private void loadcbproyek() {
    cbproyek.removeAllItems();
    try {
        String sql = "SELECT id, nama_proyek, durasi FROM proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String tampilan = String.format("ID: %d - %s (%s)", 
                rs.getInt("id"),
                rs.getString("nama_proyek"),
                rs.getString("durasi")
            );
            cbproyek.addItem(tampilan);
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Memuat Data Proyek: " + e.getMessage());
    }
}
    private int getSelectedKaryawanId() {
    int selectedIndex = cbkaryawan.getSelectedIndex();
    return selectedIndex >= 0 ? (int) karyawan.getValueAt(selectedIndex, 0) : -1; // Ambil ID dari model karyawan
}

    private int getSelectedProyekId() {
    int selectedIndex = cbproyek.getSelectedIndex();
    return selectedIndex >= 0 ? (int) proyek.getValueAt(selectedIndex, 0) : -1; // Ambil ID dari model proyek
}

    //End Delete Data

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idkaryawan = new javax.swing.JTextField();
        nkaryawan = new javax.swing.JTextField();
        jabatan = new javax.swing.JTextField();
        skaryawan = new javax.swing.JButton();
        ekaryawan = new javax.swing.JButton();
        hkaryawan = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        departemen = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        idproyek = new javax.swing.JTextField();
        nproyek = new javax.swing.JTextField();
        durasi = new javax.swing.JTextField();
        sproyek = new javax.swing.JButton();
        eproyek = new javax.swing.JButton();
        hproyek = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        cbkaryawan = new javax.swing.JComboBox<>();
        cbproyek = new javax.swing.JComboBox<>();
        peran = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        stransaksi = new javax.swing.JButton();
        etransaksi = new javax.swing.JButton();
        htransaksi = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        idtransaksi = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 146, 25, -1));

        jLabel2.setText("Nama");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 186, -1, -1));

        jLabel3.setText("Jabatan");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 226, -1, -1));

        idkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idkaryawanActionPerformed(evt);
            }
        });
        jPanel1.add(idkaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 134, -1));
        jPanel1.add(nkaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 134, -1));
        jPanel1.add(jabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 134, -1));

        skaryawan.setText("Simpan");
        skaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skaryawanActionPerformed(evt);
            }
        });
        jPanel1.add(skaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        ekaryawan.setText("Edit");
        ekaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekaryawanActionPerformed(evt);
            }
        });
        jPanel1.add(ekaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, -1, -1));

        hkaryawan.setText("Hapus");
        hkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hkaryawanActionPerformed(evt);
            }
        });
        jPanel1.add(hkaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, -1, -1));

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("KodchiangUPC", 0, 36)); // NOI18N
        jLabel4.setText("Data Karyawan");
        jPanel4.add(jLabel4, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 100));

        jPanel7.setLayout(new java.awt.BorderLayout());

        tbl_karyawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id_kayawan", "nama", "jabatan", "departemen"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_karyawan);

        jPanel7.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 360, 330));

        jLabel9.setText("departemen");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));
        jPanel1.add(departemen, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 130, -1));

        jTabbedPane1.addTab("karyawan", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("KodchiangUPC", 0, 36)); // NOI18N
        jLabel5.setText("Data Proyek");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 252, 37, 346);
        jPanel5.add(jLabel5, gridBagConstraints);

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, -1));

        jPanel6.setBackground(new java.awt.Color(153, 204, 255));

        jLabel6.setText("id_proyek");

        jLabel7.setText("nama_proyek");

        jLabel8.setText("durasi");

        sproyek.setText("simpan");
        sproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sproyekActionPerformed(evt);
            }
        });

        eproyek.setText("edit");
        eproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eproyekActionPerformed(evt);
            }
        });

        hproyek.setText("hapus");
        hproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hproyekActionPerformed(evt);
            }
        });

        jPanel8.setLayout(new java.awt.BorderLayout());

        tbl_proyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id_proyek", "nama_proyek", "durasi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_proyek);

        jPanel8.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idproyek)
                            .addComponent(nproyek)
                            .addComponent(durasi, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(sproyek)
                        .addGap(28, 28, 28)
                        .addComponent(eproyek)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(hproyek)))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(idproyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(nproyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(durasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sproyek)
                            .addComponent(eproyek)
                            .addComponent(hproyek)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 730, 350));

        jTabbedPane1.addTab("proyek", jPanel2);

        jPanel9.setBackground(new java.awt.Color(153, 255, 255));

        jLabel11.setFont(new java.awt.Font("KodchiangUPC", 0, 36)); // NOI18N
        jLabel11.setText("Data Transaksi");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel10.setBackground(new java.awt.Color(102, 204, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbkaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkaryawanActionPerformed(evt);
            }
        });
        jPanel10.add(cbkaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 138, -1));

        cbproyek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel10.add(cbproyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 138, -1));

        peran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peranActionPerformed(evt);
            }
        });
        jPanel10.add(peran, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 138, -1));

        jLabel10.setText("peran");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 43, 22));

        stransaksi.setText("simpan");
        stransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stransaksiActionPerformed(evt);
            }
        });
        jPanel10.add(stransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        etransaksi.setText("edit");
        etransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etransaksiActionPerformed(evt);
            }
        });
        jPanel10.add(etransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, -1));

        htransaksi.setText("hapus");
        htransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                htransaksiActionPerformed(evt);
            }
        });
        jPanel10.add(htransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));

        jLabel12.setText("id_transaksi");
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        jPanel10.add(idtransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 58, 140, -1));

        jPanel11.setBackground(new java.awt.Color(255, 204, 153));
        jPanel11.setLayout(new java.awt.BorderLayout());

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

        jPanel11.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("transaksi", jPanel3);

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

    private void skaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skaryawanActionPerformed
        // TODO add your handling code here:
         try{
           if (nkaryawan.getText().trim().isEmpty() || jabatan.getText().trim().isEmpty() || departemen.getText().trim().isEmpty() ) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Input Error", JOptionPane.WARNING_MESSAGE);
            return; 
            } 
         String sql = "INSERT INTO karyawan (nama, jabatan, departemen) VALUES (?, ?, ?)";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, nkaryawan.getText());
         ps.setString(2, jabatan.getText());
         ps.setString(3, departemen.getText());
         ps.executeUpdate();
         JOptionPane.showMessageDialog(this, "Data saved successfully");
         loadDatakaryawan();
       } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }//GEN-LAST:event_skaryawanActionPerformed

    private void ekaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekaryawanActionPerformed
        // TODO add your handling code here:
        try {
            if (nkaryawan.getText().trim().isEmpty() || jabatan.getText().trim().isEmpty() || departemen.getText().trim().isEmpty() || idkaryawan.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Input Error", JOptionPane.WARNING_MESSAGE);
                return; 
            }  
          
          String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, nkaryawan.getText());
          ps.setString(2, jabatan.getText());
          ps.setString(3, departemen.getText());
          ps.setInt(4, Integer.parseInt(idkaryawan.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data updated successfully");
          loadDatakaryawan();
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
    }//GEN-LAST:event_ekaryawanActionPerformed

    private void hkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hkaryawanActionPerformed
        // TODO add your handling code here:
         try  {
            if (idkaryawan.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID Karyawan tidak boleh kosong! Masukkan ID yang akan dihapus.", "Input Error", JOptionPane.WARNING_MESSAGE);
                return; 
            }
          int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data transaksi ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
          
          if (confirm == JOptionPane.YES_OPTION) {
          String sql = "DELETE FROM karyawan WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, Integer.parseInt(idkaryawan.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data deleted successfully");
          loadDatakaryawan();
          }else {
            JOptionPane.showMessageDialog(this, "Tidak ada data yang diperbarui. Pastikan ID Karyawan dan Proyek benar.","Delete Error", JOptionPane.WARNING_MESSAGE);
        }
     } catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
    }//GEN-LAST:event_hkaryawanActionPerformed

    private void idkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idkaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idkaryawanActionPerformed

    private void peranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peranActionPerformed

    private void stransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stransaksiActionPerformed
        // TODO add your handling code here:
    try {
        String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        int idKaryawan = getSelectedKaryawanId(); 
        int idProyek = getSelectedProyekId();
        ps.setInt(1, idKaryawan);
        ps.setInt(2, idProyek);
        ps.setString(3, peran.getText());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data saved successfully");
        loadDatatransaksi();
    } catch (SQLException e) {
        System.out.println("Error Save Data: " + e.getMessage());

    }
    }//GEN-LAST:event_stransaksiActionPerformed

    private void sproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sproyekActionPerformed
        // TODO add your handling code here:
        try{
          if (nproyek.getText().trim().isEmpty() || durasi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Input Error", JOptionPane.WARNING_MESSAGE);
            return; 
            }
    int durasiValue;
    try {
        durasiValue = Integer.parseInt(durasi.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Field durasi harus berupa angka!", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }
         String sql = "INSERT INTO proyek (nama_proyek, durasi) VALUES (?, ?)";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, nproyek.getText());
         ps.setString(2, durasi.getText());
         ps.executeUpdate();
         JOptionPane.showMessageDialog(this, "Data saved successfully");
         loadDataproyek();
       } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }//GEN-LAST:event_sproyekActionPerformed

    private void etransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etransaksiActionPerformed
        // TODO add your handling code here:
      try {
        if (idtransaksi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID Transaksi tidak boleh kosong! Masukkan ID Transaksi yang akan diperbarui.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return; 
        }
        String sql = "UPDATE transaksi SET peran = ? WHERE id_transaksi = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setString(1, peran.getText());
        ps.setInt(2, Integer.parseInt(idtransaksi.getText()));

        int updatedRows = ps.executeUpdate();
        if (updatedRows > 0) {
            JOptionPane.showMessageDialog(this, "Data Transaksi berhasil diperbarui");
        } else {
            JOptionPane.showMessageDialog(this, "Tidak ada data yang diperbarui. Pastikan ID Karyawan dan Proyek benar.");
        }
        loadDatatransaksi();
    } catch (SQLException e) {
        System.out.println("Kesalahan Memperbarui Data Transaksi: " + e.getMessage());
    }
    }//GEN-LAST:event_etransaksiActionPerformed

    private void eproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eproyekActionPerformed
        // TODO add your handling code here:
        try {
         if (nproyek.getText().trim().isEmpty() || durasi.getText().trim().isEmpty() || idproyek.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Input Error", JOptionPane.WARNING_MESSAGE);
                return; 
            }  
    int durasiValue;
    try {
        durasiValue = Integer.parseInt(durasi.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Field durasi harus berupa angka!", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }
         String sql = "UPDATE proyek SET nama_proyek = ?, durasi = ? WHERE id = ?";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, nproyek.getText());
         ps.setString(2, durasi.getText());
         ps.setInt(3, Integer.parseInt(idproyek.getText()));
         ps.executeUpdate();
         JOptionPane.showMessageDialog(this, "Data updated successfully");
         loadDataproyek();
     }  catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
     }
    }//GEN-LAST:event_eproyekActionPerformed

    private void hproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hproyekActionPerformed
        // TODO add your handling code here:
        try  {
            if (idproyek.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID Proyek tidak boleh kosong! Masukkan ID yang akan dihapus.", "Input Error", JOptionPane.WARNING_MESSAGE);
                return; 
            }
          int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data transaksi ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
          
          if (confirm == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM proyek WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idproyek.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data deleted successfully");
            loadDataproyek();
          }else {
                JOptionPane.showMessageDialog(this, "Data Transaksi tidak ditemukan atau sudah dihapus.");
            }
         } catch (SQLException e) {
             System.out.println("Error Save Data" + e.getMessage());
      }
    }//GEN-LAST:event_hproyekActionPerformed

    private void htransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_htransaksiActionPerformed
        // TODO add your handling code here:
        try {
            if (idtransaksi.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID Transaksi tidak boleh kosong! Masukkan ID Transaksi yang akan dihapus.", "Input Error", JOptionPane.WARNING_MESSAGE);
                return; // Menghentikan proses jika ID Transaksi kosong
            }
            int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data transaksi ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                PreparedStatement ps = conn.prepareStatement("DELETE FROM transaksi WHERE id_transaksi= ?");

                ps.setInt(1, Integer.parseInt(idtransaksi.getText()));

                // Eksekusi perintah DELETE
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(this, "Data Transaksi berhasil dihapus");
                    loadDatatransaksi(); // Muat ulang data
                } else {
                    JOptionPane.showMessageDialog(this, "Data Transaksi tidak ditemukan atau sudah dihapus.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Penghapusan data dibatalkan.");
            }
        } catch (SQLException e) {
            System.out.println("Kesalahan Menghapus Data Transaksi: " + e.getMessage());
        }

    }//GEN-LAST:event_htransaksiActionPerformed

    private void cbkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbkaryawanActionPerformed

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
            java.util.logging.Logger.getLogger(app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new app().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbkaryawan;
    private javax.swing.JComboBox<String> cbproyek;
    private javax.swing.JTextField departemen;
    private javax.swing.JTextField durasi;
    private javax.swing.JButton ekaryawan;
    private javax.swing.JButton eproyek;
    private javax.swing.JButton etransaksi;
    private javax.swing.JButton hkaryawan;
    private javax.swing.JButton hproyek;
    private javax.swing.JButton htransaksi;
    private javax.swing.JTextField idkaryawan;
    private javax.swing.JTextField idproyek;
    private javax.swing.JTextField idtransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField jabatan;
    private javax.swing.JTextField nkaryawan;
    private javax.swing.JTextField nproyek;
    private javax.swing.JTextField peran;
    private javax.swing.JButton skaryawan;
    private javax.swing.JButton sproyek;
    private javax.swing.JButton stransaksi;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    // End of variables declaration//GEN-END:variables

}
