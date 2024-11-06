/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tugasprktkm3;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class pembayaranSPP extends javax.swing.JFrame {

    public pembayaranSPP() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtjmlspp = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
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
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tRiwayat = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnCK = new javax.swing.JButton();
        tfjmlspp = new javax.swing.JTextField();
        btnhitungg = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();

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

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\earn-money_4578534 (1).png")); // NOI18N
        jPanel2.add(jLabel7);

        jLabel1.setFont(new java.awt.Font("Algerian", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MySPP Wallet");
        jPanel2.add(jLabel1);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\Simple_Black_and_White_School_Building_Illustration_with_Flag_on_Roof_Stock_Vector-removebg-preview (1).png")); // NOI18N
        jPanel2.add(jLabel5);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 80));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nama :");

        txtnama.setFont(new java.awt.Font("Rockwell", 3, 14)); // NOI18N
        txtnama.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jumlah SPP Per Bulan :");

        txtjmlspp.setFont(new java.awt.Font("Rockwell", 3, 14)); // NOI18N
        txtjmlspp.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(txtjmlspp, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtjmlspp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 790, 80));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        cbjan.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        cbjan.setText("JANUARI");

        cbfeb.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        cbfeb.setText("FEBRUARI");

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

        jLabel6.setFont(new java.awt.Font("Rockwell Condensed", 3, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("BULAN :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(cbjuli, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbagust, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(cbsept)
                .addGap(18, 18, 18)
                .addComponent(cbokt)
                .addGap(18, 18, 18)
                .addComponent(cbnov)
                .addGap(18, 18, 18)
                .addComponent(cbdes, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(cbjan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbfeb, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbmar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbapr, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(cbmei, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbjuni, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbjan)
                            .addComponent(cbfeb)
                            .addComponent(cbmar)
                            .addComponent(cbapr)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbmei)
                            .addComponent(cbjuni))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbdes)
                    .addComponent(cbnov)
                    .addComponent(cbokt)
                    .addComponent(cbsept)
                    .addComponent(cbagust)
                    .addComponent(cbjuli))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 790, 140));

        tRiwayat.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        tRiwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Pmbyrn", "Status", "Jan", "Feb", "Maret", "April", "Mei", "Juni", "Juli", "Agust", "Sep", "Okt", "Nov", "Des"
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 790, 100));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(new java.awt.BorderLayout());

        btnCK.setBackground(new java.awt.Color(0, 0, 0));
        btnCK.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btnCK.setForeground(new java.awt.Color(255, 255, 255));
        btnCK.setText("Cek Tunggakan");
        btnCK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCKActionPerformed(evt);
            }
        });
        jPanel6.add(btnCK, java.awt.BorderLayout.LINE_END);

        tfjmlspp.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        tfjmlspp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfjmlsppActionPerformed(evt);
            }
        });
        jPanel6.add(tfjmlspp, java.awt.BorderLayout.CENTER);

        btnhitungg.setBackground(new java.awt.Color(0, 0, 0));
        btnhitungg.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btnhitungg.setForeground(new java.awt.Color(255, 255, 255));
        btnhitungg.setText("Hasil");
        btnhitungg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhitunggActionPerformed(evt);
            }
        });
        jPanel6.add(btnhitungg, java.awt.BorderLayout.LINE_START);

        btnclear.setBackground(new java.awt.Color(0, 0, 0));
        btnclear.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btnclear.setForeground(new java.awt.Color(255, 255, 255));
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        jPanel6.add(btnclear, java.awt.BorderLayout.PAGE_START);

        btnkeluar.setBackground(new java.awt.Color(0, 0, 0));
        btnkeluar.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btnkeluar.setForeground(new java.awt.Color(255, 255, 255));
        btnkeluar.setText("Keluar");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });
        jPanel6.add(btnkeluar, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 790, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed

            System.exit(0);
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
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnCKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCKActionPerformed
        if (txtnama.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isi nama terlebih dahulu pada form diatas", "Peringatan !!!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!cbjan.isSelected() && !cbfeb.isSelected() && !cbmar.isSelected() && !cbapr.isSelected()
                && !cbmei.isSelected() && !cbjuni.isSelected() && !cbjuli.isSelected() && !cbagust.isSelected()
                && !cbsept.isSelected() && !cbokt.isSelected() && !cbnov.isSelected() && !cbdes.isSelected()) {
            JOptionPane.showMessageDialog(this, "Pilihlah antara satu bulan atau lebih", "Peringatan!!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txtjmlspp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isikan nominal pembayaran SPP terlebih dahulu", "Peringatan!!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            DefaultTableModel model = (DefaultTableModel) tRiwayat.getModel();
            String Nama = txtnama.getText();
            String Status = "MENUNGGAK";
            int bayar = Integer.parseInt(txtjmlspp.getText());

            int Bulan = 0;

            if (cbjan.isSelected()) {
                Bulan = Bulan + 1;
            }
            if (cbfeb.isSelected()) {
                Bulan = Bulan + 1;
            }
            if (cbmar.isSelected()) {
                Bulan = Bulan + 1;
            }
            if (cbapr.isSelected()) {
                Bulan = Bulan + 1;
            }
            if (cbmei.isSelected()) {
                Bulan = Bulan + 1;
            }
            if (cbjuni.isSelected()) {
                Bulan = Bulan + 1;
            }
            if (cbjuli.isSelected()) {
                Bulan = Bulan + 1;
            }
            if (cbagust.isSelected()) {
                Bulan = Bulan + 1;
            }
            if (cbsept.isSelected()) {
                Bulan = Bulan + 1;
            }
            if (cbokt.isSelected()) {
                Bulan = Bulan + 1;
            }
            if (cbnov.isSelected()) {
                Bulan = Bulan + 1;
            }
            if (cbdes.isSelected()) {
                Bulan = Bulan + 1;
            }

            if (Bulan == 12) {
                Status = "LUNAS";
            }

            int hutang = bayar * (12 - Bulan);

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

            model.addRow(rowData);

            JOptionPane.showMessageDialog(this, "Data sudah masuk", "SUKSES", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "FORMAT TIDAK SESUAI", "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCKActionPerformed

    private void btnhitunggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhitunggActionPerformed
        int jmlspp = Integer.parseInt(txtjmlspp.getText());
        int hutang = 0;

        if (!cbjan.isSelected()) {
            hutang++;
        }
        if (!cbfeb.isSelected()) {
            hutang++;
        }
        if (!cbmar.isSelected()) {
            hutang++;
        }
        if (!cbapr.isSelected()) {
            hutang++;
        }
        if (!cbmei.isSelected()) {
            hutang++;
        }
        if (!cbjuni.isSelected()) {
            hutang++;
        }
        if (!cbjuli.isSelected()) {
            hutang++;
        }
        if (!cbagust.isSelected()) {
            hutang++;
        }
        if (!cbsept.isSelected()) {
            hutang++;
        }
        if (!cbokt.isSelected()) {
            hutang++;
        }
        if (!cbnov.isSelected()) {
            hutang++;
        }
        if (!cbdes.isSelected()) {
            hutang++;
        }

        tfjmlspp.setText(String.valueOf(jmlspp * hutang));

    }//GEN-LAST:event_btnhitunggActionPerformed

    private void tfjmlsppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfjmlsppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfjmlsppActionPerformed

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
            java.util.logging.Logger.getLogger(pembayaranSPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pembayaranSPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pembayaranSPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pembayaranSPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pembayaranSPP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCK;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnhitungg;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tRiwayat;
    private javax.swing.JTextField tfjmlspp;
    private javax.swing.JTextField txtjmlspp;
    private javax.swing.JTextField txtnama;
    // End of variables declaration//GEN-END:variables
}
