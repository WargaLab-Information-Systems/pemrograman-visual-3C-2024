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

public class proyek extends javax.swing.JFrame {

       //inisiasi GLobal Variable
    Connection conn;
    private  DefaultTableModel modelw;
    private  DefaultTableModel modelp;
    private  DefaultTableModel modelt;
    //end global variable
    
    public proyek() {
        initComponents();
        conn = koneksi.getConnection();
        
        modelw = new DefaultTableModel();
        modelp = new DefaultTableModel();
        modelt = new DefaultTableModel();
        
        tabelkar.setModel(modelw);
        tabelkar.setEnabled(false);
        modelw.addColumn("ID");
        modelw.addColumn("nama");
        modelw.addColumn("jabatan");
        modelw.addColumn("departemen");
        
        tabelpro.setModel(modelp);
        tabelpro.setEnabled(false);
        modelp.addColumn("ID");
        modelp.addColumn("nama_proyek");
        modelp.addColumn("durasi_pengerjaan");
        
        tbtrans.setModel(modelt);
        tabelpro.setEnabled(false);
        modelt.addColumn("ID_karyawan");
        modelt.addColumn("ID_proyek");
        modelt.addColumn("Peran");
        
        loadDataK();
        loadDataP();
        loadDataT(); 
        loadComboBoxKaryawan();
        loadComboBoxProyek();
        
        
    }
    private void loadDataK() {
        modelw.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelw.addRow(new Object[]{
                    rs.getInt("ID"),
                    rs.getString("nama"),
                    rs.getString("jabatan"),
                    rs.getString("departemen")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }   
     private void loadDataP() {
        modelp.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelp.addRow(new Object[]{
                    rs.getInt("ID"),
                    rs.getString("nama_proyek"),
                    rs.getString("durasi_pengerjaan")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
        private void loadDataT() {
        modelt.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM transaksi";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelt.addRow(new Object[]{
                    rs.getInt("id_karyawan"),
                    rs.getString("id_proyek"),
                    rs.getString("peran")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }

private void loadComboBoxKaryawan() {
    idkar.removeAllItems();
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
            idkar.addItem(tampilan);
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Memuat Data Karyawan: " + e.getMessage());
    }
}
    

    private void loadComboBoxProyek() {
    idpro.removeAllItems();
    try {
        String sql = "SELECT id, nama_proyek, durasi_pengerjaan FROM proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String tampilan = String.format("ID: %d - %s (%s)", 
                rs.getInt("id"),
                rs.getString("nama_proyek"),
                rs.getString("durasi_pengerjaan")
            );
            idpro.addItem(tampilan);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel7 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLid = new javax.swing.JLabel();
        jLnama = new javax.swing.JLabel();
        jLjabatan = new javax.swing.JLabel();
        jdepar = new javax.swing.JLabel();
        jTFid = new javax.swing.JTextField();
        jTFnm = new javax.swing.JTextField();
        jTFjb = new javax.swing.JTextField();
        jTFdep = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelkar = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jbup = new javax.swing.JButton();
        jbcr = new javax.swing.JButton();
        jbdlt = new javax.swing.JButton();
        jbreset = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jbexit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLid1 = new javax.swing.JLabel();
        jLnama1 = new javax.swing.JLabel();
        jLjabatan1 = new javax.swing.JLabel();
        jTFid1 = new javax.swing.JTextField();
        jTFnmpr = new javax.swing.JTextField();
        jTFdur = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelpro = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jBupd = new javax.swing.JButton();
        jBcr = new javax.swing.JButton();
        dlt = new javax.swing.JButton();
        jBreset = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        Bexit = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLid2 = new javax.swing.JLabel();
        jLnama2 = new javax.swing.JLabel();
        jLjabatan2 = new javax.swing.JLabel();
        peran = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbtrans = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        Bup = new javax.swing.JButton();
        Bdlt = new javax.swing.JButton();
        bcreate = new javax.swing.JButton();
        Breset = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        exit = new javax.swing.JButton();
        idkar = new javax.swing.JComboBox<>();
        idpro = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER EBC\\Downloads\\hm-removebg-preview (1).png")); // NOI18N
        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(212, 246, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLid.setText("ID                       :");
        jPanel1.add(jLid, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 26, -1, -1));

        jLnama.setText("NAMA               :");
        jPanel1.add(jLnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 66, -1, -1));

        jLjabatan.setText("JABATAN          :");
        jPanel1.add(jLjabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 109, -1, -1));

        jdepar.setText("DEPARTEMEN  :");
        jPanel1.add(jdepar, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 149, -1, -1));
        jPanel1.add(jTFid, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 26, 198, -1));
        jPanel1.add(jTFnm, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 66, 197, -1));
        jPanel1.add(jTFjb, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 106, 198, -1));
        jPanel1.add(jTFdep, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 146, 198, -1));

        tabelkar.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "ID", "NAMA", "JABATAN", "DEPARTEMEN"
            }
        ));
        jScrollPane1.setViewportView(tabelkar);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 350, 200));

        jPanel5.setBackground(new java.awt.Color(198, 231, 255));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jbup.setText("UPDATE");
        jbup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbupActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 8, 10);
        jPanel5.add(jbup, gridBagConstraints);

        jbcr.setText("CREATE");
        jbcr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcrActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 8, 10);
        jPanel5.add(jbcr, gridBagConstraints);

        jbdlt.setText("DELETE");
        jbdlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbdltActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 8, 10);
        jPanel5.add(jbdlt, gridBagConstraints);

        jbreset.setText("RESET");
        jbreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbresetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel5.add(jbreset, gridBagConstraints);

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 390, 60));

        jPanel6.setBackground(new java.awt.Color(212, 246, 255));

        jbexit.setText("EXIT");
        jbexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbexitActionPerformed(evt);
            }
        });
        jPanel6.add(jbexit);

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 90, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER EBC\\Downloads\\hm-removebg-preview (2).png")); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 800, 260));

        jTabbedPane1.addTab("Karyawan", jPanel1);

        jPanel2.setBackground(new java.awt.Color(212, 246, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLid1.setText("ID                                        :");
        jPanel2.add(jLid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 26, -1, -1));

        jLnama1.setText("NAMA PROYEK                 :");
        jPanel2.add(jLnama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 66, -1, -1));

        jLjabatan1.setText("DURASI PENGERJAAN      :");
        jPanel2.add(jLjabatan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 109, -1, -1));
        jPanel2.add(jTFid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 198, -1));
        jPanel2.add(jTFnmpr, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 197, -1));
        jPanel2.add(jTFdur, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 198, -1));

        tabelpro.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null}
            },
            new String [] {
                "ID", "NAMA_PROYEK", "DURASI PROYEK"
            }
        ));
        jScrollPane2.setViewportView(tabelpro);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 350, 180));

        jPanel7.setBackground(new java.awt.Color(198, 231, 255));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jBupd.setText("UPDATE");
        jBupd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBupdActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(4, 21, 4, 21);
        jPanel7.add(jBupd, gridBagConstraints);

        jBcr.setText("CREATE");
        jBcr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcrActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(4, 41, 4, 41);
        jPanel7.add(jBcr, gridBagConstraints);

        dlt.setText("DELETE");
        dlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 30, 8, 30);
        jPanel7.add(dlt, gridBagConstraints);

        jBreset.setText("RESET");
        jBreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBresetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 0, 21);
        jPanel7.add(jBreset, gridBagConstraints);

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 770, 60));

        jPanel8.setBackground(new java.awt.Color(212, 246, 255));

        Bexit.setText("EXIT");
        Bexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BexitActionPerformed(evt);
            }
        });
        jPanel8.add(Bexit);

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 90, 60));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER EBC\\Downloads\\uu-removebg-preview (2).png")); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, 210));

        jTabbedPane1.addTab("Proyek", jPanel2);

        jPanel3.setBackground(new java.awt.Color(212, 246, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLid2.setText("KARYAWAN                       :");
        jPanel3.add(jLid2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 26, -1, -1));

        jLnama2.setText("PROYEK                              :");
        jPanel3.add(jLnama2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 66, -1, -1));

        jLjabatan2.setText("PERAN                                :");
        jPanel3.add(jLjabatan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 109, -1, -1));
        jPanel3.add(peran, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 190, -1));

        tbtrans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "KARYAWAN", "ID_PROYEK", "PERAN"
            }
        ));
        jScrollPane3.setViewportView(tbtrans);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 360, 200));

        jPanel9.setBackground(new java.awt.Color(198, 231, 255));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        Bup.setText("UPDATE");
        Bup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BupActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 0, 22);
        jPanel9.add(Bup, gridBagConstraints);

        Bdlt.setText("DELETE");
        Bdlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BdltActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 0, 22);
        jPanel9.add(Bdlt, gridBagConstraints);

        bcreate.setText("CREATE");
        bcreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcreateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 0, 22);
        jPanel9.add(bcreate, gridBagConstraints);

        Breset.setText("RESET");
        Breset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BresetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 0, 22);
        jPanel9.add(Breset, gridBagConstraints);

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 770, 50));

        jPanel10.setBackground(new java.awt.Color(212, 246, 255));

        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel10.add(exit);

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 90, 40));

        idkar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(idkar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 190, -1));

        idpro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        idpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idproActionPerformed(evt);
            }
        });
        jPanel3.add(idpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 190, -1));

        jTabbedPane1.addTab("Transaksi", jPanel3);

        jPanel4.setBackground(new java.awt.Color(198, 231, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER EBC\\Downloads\\dis-removebg-preview (1) (2).png")); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, -1, 100));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER EBC\\Downloads\\miki-removebg-preview (1).png")); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 10, 140, 100));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER EBC\\Downloads\\toy-removebg-preview (1).png")); // NOI18N
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 170, 70));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER EBC\\Downloads\\win-removebg-preview (1).png")); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER EBC\\Downloads\\lagi-removebg-preview (1).png")); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, -1, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBcrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcrActionPerformed
      try {
            // Cek apakah durasi berisi angka
            int durasi = Integer.parseInt(jTFdur.getText().trim()); // Mengonversi input durasi menjadi integer
            int id = Integer.parseInt(jTFid1.getText().trim());
            String namaProyek = jTFnmpr.getText().trim();

            // Validasi untuk memastikan semua field diisi dengan benar
            if (namaProyek.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama proyek tidak boleh kosong atau hanya berisi spasi.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return; // Hentikan eksekusi jika validasi gagal
            }

            String sql = "INSERT INTO proyek (id, nama_proyek, durasi_pengerjaan) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, namaProyek);
            ps.setInt(3, durasi); // Menggunakan setInt untuk kolom durasi_pengerjaan
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");
            loadDataP();
            loadComboBoxKaryawan();
            loadComboBoxProyek();

        } catch (NumberFormatException e) {
            // Menampilkan pesan jika durasi tidak valid
            JOptionPane.showMessageDialog(this, "Durasi pengerjaan harus berupa angka.", "Input Error", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException e) {
            System.out.println("Error Save Data: " + e.getMessage());
        }

    }//GEN-LAST:event_jBcrActionPerformed

    private void jbexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbexitActionPerformed
    int keluar = JOptionPane.showConfirmDialog(null,"beneran mau keluar?","Keluar",JOptionPane.YES_NO_OPTION);
        if (keluar == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jbexitActionPerformed

    private void idproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idproActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idproActionPerformed

    private void jbupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbupActionPerformed
        try {
          String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, jTFnm.getText());
          ps.setString(2, jTFjb.getText());
          ps.setString(3, jTFdep.getText());
          ps.setInt(4,Integer.parseInt(jTFid.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "sudah di update bang!!");
          loadDataK();
          loadComboBoxKaryawan();
          loadComboBoxProyek();
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
    }//GEN-LAST:event_jbupActionPerformed

    private void jbcrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcrActionPerformed
    try {
                int id = Integer.parseInt(jTFid.getText().trim());
                String nama = jTFnm.getText().trim();
                String jabatan = jTFjb.getText().trim();
                String departemen = jTFdep.getText().trim();

                // Check if any field is empty or contains only spaces
                if (nama.isEmpty() || jabatan.isEmpty() || departemen.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "bang jangan sepasi bang!", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Stop execution if validation fails
                }

                String sql = "INSERT INTO karyawan (id, nama, jabatan, departemen) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.setString(2, nama);
                ps.setString(3, jabatan);
                ps.setString(4, departemen);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Data successfully added!");
                loadDataK();
                loadComboBoxKaryawan();
                loadComboBoxProyek();

            } catch (SQLException e) {
                System.out.println("Error saving data: " + e.getMessage());
            }

    }//GEN-LAST:event_jbcrActionPerformed

    private void jbdltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbdltActionPerformed
        try  {
            
            String sql = "DELETE FROM karyawan WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(jTFid.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Udah ya bang");
            loadDataK();
            loadComboBoxKaryawan();
            loadComboBoxProyek();
//            IdProj();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }//GEN-LAST:event_jbdltActionPerformed

    private void jbresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbresetActionPerformed
    jTFnm.setText("");
    jTFjb.setText("");
    jTFdep.setText("");
    jTFid.setText("");
    }//GEN-LAST:event_jbresetActionPerformed

    private void jBupdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBupdActionPerformed
         if (tabelpro.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "THERE IS NO DATA", "DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
            }else{
                try {  
                    String sql = "SELECT nama_proyek, durasi_pengerjaan FROM proyek WHERE id = ?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, Integer.parseInt(jTFid1.getText()));
                    ResultSet rs = ps.executeQuery();

                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(this, "THERE IS NO DATA", "DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String proname = jTFnmpr.getText().isEmpty() ? rs.getString("nama_proyek") : jTFnmpr.getText();
                    String duration = jTFdur.getText().isEmpty() ? rs.getString("durasi_pengerjaan") : jTFdur.getText();
                    String upsql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
                    PreparedStatement upps = conn.prepareStatement(upsql);
                    upps.setString(1, proname);
                    upps.setString(2, duration);
                    upps.setInt(3, Integer.parseInt(jTFid1.getText()));
                    upps.executeUpdate();

                    JOptionPane.showMessageDialog(this, "P SUKSES");
                    loadDataP();
                    loadComboBoxKaryawan();
                    loadComboBoxProyek();
            } catch (SQLException e) {
                System.out.println("Error updating data: " + e.getMessage());
            }
                }
    }//GEN-LAST:event_jBupdActionPerformed

    private void dltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltActionPerformed
        try  {
            String sql = "DELETE FROM proyek WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(jTFid1.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Udah ke hapus ya bang");
            loadDataP();
            loadComboBoxKaryawan();
            loadComboBoxProyek();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }//GEN-LAST:event_dltActionPerformed

    private void jBresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBresetActionPerformed
    jTFnmpr.setText("");
    jTFdur.setText("");
    jTFid1.setText("");
    }//GEN-LAST:event_jBresetActionPerformed

    private void BexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BexitActionPerformed
        int keluar = JOptionPane.showConfirmDialog(null,"beneran mau keluar?","Keluar",JOptionPane.YES_NO_OPTION);
        if (keluar == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_BexitActionPerformed

    private void BupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BupActionPerformed
      try {
        String sql = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(idkar.getSelectedItem().toString());
        int idProyek = getSelectedId(idpro.getSelectedItem().toString());
        
        ps.setString(1, peran.getText());
        ps.setInt(2, idKaryawan);
        ps.setInt(3, idProyek);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Transaksi berhasil diperbarui");
        loadDataT();
    } catch (SQLException e) {
        System.out.println("Kesalahan Memperbarui Data Transaksi: " + e.getMessage());
    }
    }//GEN-LAST:event_BupActionPerformed

    private void BdltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BdltActionPerformed
          try {
        String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(idkar.getSelectedItem().toString());
        int idProyek = getSelectedId(idpro.getSelectedItem().toString());
        
        ps.setInt(1, idKaryawan);
        ps.setInt(2, idProyek);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Transaksi berhasil dihapus");
        loadDataT();
    } catch (SQLException e) {
        System.out.println("Kesalahan Menghapus Data Transaksi: " + e.getMessage());
    }
    }//GEN-LAST:event_BdltActionPerformed

    private void bcreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcreateActionPerformed
       try {
        if (idkar.getSelectedItem() == null || idpro.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Pilih karyawan dan proyek terlebih dahulu");
            return;
        }
        
        String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(idkar.getSelectedItem().toString());
        int idProyek = getSelectedId(idpro.getSelectedItem().toString());
        
        if (idKaryawan == -1 || idProyek == -1) {
            JOptionPane.showMessageDialog(this, "ID Karyawan atau ID Proyek tidak valid");
            return;
        }
        
        if (peran.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Peran tidak boleh kosong");
            return;
        }
        
        ps.setInt(1, idKaryawan);
        ps.setInt(2, idProyek);
        ps.setString(3, peran.getText().trim());
        
        int result = ps.executeUpdate();
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Data Transaksi berhasil ditambahkan");
            loadDataT();
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Menambah Data Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Gagal menambah data: " + e.getMessage());
    }
    }//GEN-LAST:event_bcreateActionPerformed

    private void BresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BresetActionPerformed
    peran.setText("");
    idkar.setSelectedIndex(0);
    idpro.setSelectedIndex(0);
    }//GEN-LAST:event_BresetActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        int keluar = JOptionPane.showConfirmDialog(null,"beneran mau keluar?","Keluar",JOptionPane.YES_NO_OPTION);
        if (keluar == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitActionPerformed
// TODO add your handling code here:
                                       
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
            java.util.logging.Logger.getLogger(proyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(proyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(proyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(proyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new proyek().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bdlt;
    private javax.swing.JButton Bexit;
    private javax.swing.JButton Breset;
    private javax.swing.JButton Bup;
    private javax.swing.JButton bcreate;
    private javax.swing.JButton dlt;
    private javax.swing.JButton exit;
    private javax.swing.JComboBox<String> idkar;
    private javax.swing.JComboBox<String> idpro;
    private javax.swing.JButton jBcr;
    private javax.swing.JButton jBreset;
    private javax.swing.JButton jBupd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLid;
    private javax.swing.JLabel jLid1;
    private javax.swing.JLabel jLid2;
    private javax.swing.JLabel jLjabatan;
    private javax.swing.JLabel jLjabatan1;
    private javax.swing.JLabel jLjabatan2;
    private javax.swing.JLabel jLnama;
    private javax.swing.JLabel jLnama1;
    private javax.swing.JLabel jLnama2;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTFdep;
    private javax.swing.JTextField jTFdur;
    private javax.swing.JTextField jTFid;
    private javax.swing.JTextField jTFid1;
    private javax.swing.JTextField jTFjb;
    private javax.swing.JTextField jTFnm;
    private javax.swing.JTextField jTFnmpr;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbcr;
    private javax.swing.JButton jbdlt;
    private javax.swing.JButton jbexit;
    private javax.swing.JButton jbreset;
    private javax.swing.JButton jbup;
    private javax.swing.JLabel jdepar;
    private javax.swing.JTextField peran;
    private javax.swing.JTable tabelkar;
    private javax.swing.JTable tabelpro;
    private javax.swing.JTable tbtrans;
    // End of variables declaration//GEN-END:variables
}
