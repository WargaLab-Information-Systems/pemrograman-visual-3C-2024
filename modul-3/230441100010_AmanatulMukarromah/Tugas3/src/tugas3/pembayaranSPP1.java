/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tugas3;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class pembayaranSPP1 extends javax.swing.JFrame {
    public pembayaranSPP1() {
        initComponents();
    }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtjmlspp = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbjan = new javax.swing.JCheckBox();
        cbfeb = new javax.swing.JCheckBox();
        cbmar = new javax.swing.JCheckBox();
        cbapr = new javax.swing.JCheckBox();
        cbmei = new javax.swing.JCheckBox();
        cbjuni = new javax.swing.JCheckBox();
        cbdes = new javax.swing.JCheckBox();
        cbnov = new javax.swing.JCheckBox();
        cbokt = new javax.swing.JCheckBox();
        cbsept = new javax.swing.JCheckBox();
        cbagust = new javax.swing.JCheckBox();
        cbjuli = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        tfjmlspp = new javax.swing.JTextField();
        btnhitung = new javax.swing.JButton();
        btnCT = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tRiwayat = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 3, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SPP SMP 1 SOCAH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel7)
                .addGap(330, 330, 330)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(261, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jLabel5))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 80));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe Script", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nama :");

        txtnama.setFont(new java.awt.Font("Rockwell", 3, 14)); // NOI18N
        txtnama.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jumlah SPP / BULAN :");

        txtjmlspp.setFont(new java.awt.Font("Rockwell", 3, 14)); // NOI18N
        txtjmlspp.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(187, 187, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtjmlspp, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(315, 315, 315))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtjmlspp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 880, 90));

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));

        jLabel6.setFont(new java.awt.Font("Rockwell Condensed", 3, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("BULAN :");

        cbjan.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        cbjan.setText("JANUARI");
        cbjan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbjanActionPerformed(evt);
            }
        });

        cbfeb.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        cbfeb.setText("FEBRUARI");
        cbfeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbfebActionPerformed(evt);
            }
        });

        cbmar.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        cbmar.setText("MARET");

        cbapr.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        cbapr.setText("APRIL");

        cbmei.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        cbmei.setText("MEI");

        cbjuni.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        cbjuni.setText("JUNI");

        cbdes.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        cbdes.setText("DESEMBER");

        cbnov.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        cbnov.setText("NOVEMBER");

        cbokt.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        cbokt.setText("OKTOBER");

        cbsept.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        cbsept.setText("SEPTEMBER");

        cbagust.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        cbagust.setText("AGUSTUS");

        cbjuli.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        cbjuli.setText("JULI");

        jLabel8.setFont(new java.awt.Font("Rockwell", 3, 14)); // NOI18N
        jLabel8.setText("Jumlah lunas pembayaran SPP :");

        tfjmlspp.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        tfjmlspp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfjmlsppActionPerformed(evt);
            }
        });

        btnhitung.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btnhitung.setText("print");
        btnhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhitungActionPerformed(evt);
            }
        });

        btnCT.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btnCT.setText("hitung lunas");
        btnCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCTActionPerformed(evt);
            }
        });

        btnclear.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        btnkeluar.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btnkeluar.setText("Keluar");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbjan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbjuli, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbsept)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(cbfeb, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbmar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(cbmei, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbjuni, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cbokt))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbapr, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbagust, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(btnCT)
                                                .addGap(104, 104, 104))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(btnclear)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnkeluar)))
                                        .addComponent(btnhitung))
                                    .addComponent(jLabel8)
                                    .addComponent(tfjmlspp, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbdes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(502, 502, 502))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbnov)
                        .addGap(605, 605, 605))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbjan)
                            .addComponent(cbfeb)
                            .addComponent(cbmar)
                            .addComponent(cbapr))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbagust)
                                        .addComponent(cbjuni))
                                    .addGap(5, 5, 5))
                                .addComponent(cbmei, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(cbjuli, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbdes, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbsept, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbokt)
                                .addComponent(cbnov)))
                        .addGap(65, 65, 65))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfjmlspp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCT)
                            .addComponent(btnhitung))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnclear)
                            .addComponent(btnkeluar))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 880, 210));

        tRiwayat.setBackground(new java.awt.Color(204, 204, 204));
        tRiwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nama", "pembayaran", "status", "jan", "feb", "maret", "april", "mei", "juni", "juli", "agus", "sept", "okt", "nov", "des"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tRiwayat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 880, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Yakin Ingin Keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }   
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        txtnama.setText("");
        txtjmlspp.setText("");
        tfjmlspp.setText("");
        cbjan.setSelected(false);
        cbfeb.setSelected(false);
        cbmei.setSelected(false);
        cbapr.setSelected(false);
        cbmar.setSelected(false);
        cbjuni.setSelected(false);
        cbjuli.setSelected(false);
        cbagust.setSelected(false);
        cbsept.setSelected(false);
        cbokt.setSelected(false);
        cbnov.setSelected(false);
        cbdes.setSelected(false);
        cbjan.setEnabled(true);
        cbfeb.setEnabled(true);
        cbmar.setEnabled(true);
        cbmei.setEnabled(true);
        cbjuni.setEnabled(true);
        cbjuli.setEnabled(true);
        cbagust.setEnabled(true);
        cbsept.setEnabled(true);
        cbokt.setEnabled(true);
        cbnov.setEnabled(true);
        cbdes.setEnabled(true);
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhitungActionPerformed
        if (txtnama.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Isi nama terlebih dahulu pada form diatas", "Peringatan !!!", JOptionPane.WARNING_MESSAGE);
        return;
    }
    if (!cbjan.isSelected() && !cbfeb.isSelected() && !cbmar.isSelected() && !cbapr.isSelected() && 
        !cbmei.isSelected() && !cbjuni.isSelected() && !cbjuli.isSelected() && !cbagust.isSelected() && 
        !cbsept.isSelected() && !cbokt.isSelected() && !cbnov.isSelected() && !cbdes.isSelected()) {
        JOptionPane.showMessageDialog(this, "Pilihlah antara satu bulan atau lebih", "Peringatan !!!", JOptionPane.WARNING_MESSAGE);
        return;
    } 
    if (txtjmlspp.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Isikan nominal pembayaran SPP terlebih dahulu", "Peringatan !!!", JOptionPane.WARNING_MESSAGE);
        return;
    }
    try {
        DefaultTableModel model = (DefaultTableModel) tRiwayat.getModel();
        String Nama = txtnama.getText();
        String Status = "MENUNGGAK"; 
        int bayar = Integer.parseInt(txtjmlspp.getText()); 
        int Bulan = 0;
        if (cbjan.isSelected()){
            Bulan++;
            cbjan.setEnabled(false);
        } 
        if (cbfeb.isSelected()){
            Bulan++;
             cbfeb.setEnabled(false);
        }
        if (cbmar.isSelected()) {
            Bulan++;
             cbmar.setEnabled(false);
        }
        if (cbapr.isSelected()){
            Bulan++;
             cbapr.setEnabled(false);
        }
        if (cbmei.isSelected()){
            Bulan++;
             cbmei.setEnabled(false);
        }
        if (cbjuni.isSelected()) {
            Bulan++;
             cbjuni.setEnabled(false);
        }
        if (cbjuli.isSelected()) {
            Bulan++;
             cbjuli.setEnabled(false);
        }
        if (cbagust.isSelected()) {
            Bulan++;
             cbagust.setEnabled(false);
        }
        if (cbsept.isSelected()){
            Bulan++;
             cbsept.setEnabled(false);
        }
        if (cbokt.isSelected()){
            Bulan++;
             cbokt.setEnabled(false);
        }
        if (cbnov.isSelected()){
            Bulan++;
             cbnov.setEnabled(false);
        }
        if (cbdes.isSelected()){
            Bulan++;
             cbdes.setEnabled(false);
        }

        if (Bulan == 12) {
            Status = "LUNAS";
        }

        int hutang = bayar * (12 - Bulan);
        boolean found = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).equals(txtnama.getText())) {
                // Jika ditemukan nama yang cocok, perbarui baris tersebut
                model.setValueAt(Nama, i, 0);
                model.setValueAt(hutang, i, 1);
                model.setValueAt(Status, i, 2);
                model.setValueAt(cbjan.isSelected(), i, 3);
                model.setValueAt(cbfeb.isSelected(), i, 4);
                model.setValueAt(cbmar.isSelected(), i, 5);
                model.setValueAt(cbapr.isSelected(), i, 6);
                model.setValueAt(cbmei.isSelected(), i, 7);
                model.setValueAt(cbjuni.isSelected(), i, 8);
                model.setValueAt(cbjuli.isSelected(), i, 9);
                model.setValueAt(cbagust.isSelected(), i, 10);
                model.setValueAt(cbsept.isSelected(), i, 11);
                model.setValueAt(cbokt.isSelected(), i, 12);
                model.setValueAt(cbnov.isSelected(), i, 13);
                model.setValueAt(cbdes.isSelected(), i, 14);
                found = true;
                break;  // Keluar dari loop karena sudah ditemukan
            }
        }

// Jika tidak ditemukan, tambahkan baris baru
    if (!found) {
        Object[] rowData = new Object[15];
        rowData[0] = Nama;
        rowData[1] = hutang;
        rowData[2] = Status;
        rowData[3] = cbjan.isSelected();
        rowData[4] = cbfeb.isSelected();
        rowData[5] = cbmar.isSelected();
        rowData[6] = cbapr.isSelected();
        rowData[7] = cbmei.isSelected();
        rowData[8] = cbjuni.isSelected();
        rowData[9] = cbjuli.isSelected();
        rowData[10] = cbagust.isSelected();
        rowData[11] = cbsept.isSelected();
        rowData[12] = cbokt.isSelected();
        rowData[13] = cbnov.isSelected();
        rowData[14] = cbdes.isSelected();
        model.addRow(rowData);  // Tambah baris baru
    }
//        Object[] rowData = new Object[15];
//            rowData[0] = Nama;
//            rowData[1] = hutang;
//            rowData[2] = Status;
//            rowData[3] = cbjan.isSelected();
//            rowData[4] = cbfeb.isSelected();
//            rowData[5] = cbmar.isSelected();
//            rowData[6] = cbapr.isSelected();
//            rowData[7] = cbmei.isSelected();
//            rowData[8] = cbjuni.isSelected();
//            rowData[9] = cbjuli.isSelected();
//            rowData[10] = cbagust.isSelected();
//            rowData[11] = cbsept.isSelected();
//            rowData[12] = cbokt.isSelected();
//            rowData[13] = cbnov.isSelected();
//            rowData[14] = cbdes.isSelected();
//            model.addColumn(rowData);

        JOptionPane.showMessageDialog(this, "Data sudah masuk", "SUKSES", JOptionPane.INFORMATION_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "FORMAT TIDAK SESUAI", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnhitungActionPerformed

    private void btnCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCTActionPerformed
    int jmlspp = Integer.parseInt(txtjmlspp.getText());
    int debts = 0;

    if (!cbjan.isSelected()) {
        debts++;
    }
    if (!cbfeb.isSelected()){
        debts++;
    }
    if (!cbmar.isSelected()){
        debts++;
    }
    if (!cbapr.isSelected()){
        debts++;
    }
    if (!cbmei.isSelected()){
        debts++;
    }
    if (!cbjuni.isSelected()){
        debts++;
    }
    if (!cbjuli.isSelected()){
        debts++;
    }
    if (!cbagust.isSelected()){
        debts++;
    }
    if (!cbsept.isSelected()){
        debts++;
    }
    if (!cbokt.isSelected()){
        debts++;
    }
    if (!cbnov.isSelected()){
        debts++;
    }
    if (!cbdes.isSelected()){
        debts++;
    }

    tfjmlspp.setText(String.valueOf(jmlspp * debts));
                             
    }//GEN-LAST:event_btnCTActionPerformed

    private void tfjmlsppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfjmlsppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfjmlsppActionPerformed

    private void cbfebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbfebActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbfebActionPerformed

    private void cbjanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbjanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbjanActionPerformed

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
            java.util.logging.Logger.getLogger(pembayaranSPP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pembayaranSPP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pembayaranSPP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pembayaranSPP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pembayaranSPP1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCT;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnhitung;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JCheckBox cbagust;
    private javax.swing.JCheckBox cbapr;
    private javax.swing.JCheckBox cbdes;
    private javax.swing.JCheckBox cbfeb;
    private javax.swing.JCheckBox cbjan;
    private javax.swing.JCheckBox cbjuli;
    private javax.swing.JCheckBox cbjuni;
    private javax.swing.JCheckBox cbmar;
    private javax.swing.JCheckBox cbmei;
    private javax.swing.JCheckBox cbnov;
    private javax.swing.JCheckBox cbokt;
    private javax.swing.JCheckBox cbsept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tRiwayat;
    private javax.swing.JTextField tfjmlspp;
    private javax.swing.JTextField txtjmlspp;
    private javax.swing.JTextField txtnama;
    // End of variables declaration//GEN-END:variables
}
