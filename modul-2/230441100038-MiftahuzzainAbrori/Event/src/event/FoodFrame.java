package event;

import javax.swing.JOptionPane;

public class FoodFrame extends javax.swing.JFrame {
    int JumlahPesanan ;
    double HargaMenu ;
    double HargaToping ;

    public FoodFrame() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.ButtonGroup();
        Topping = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Coklat = new javax.swing.JRadioButton();
        Macha = new javax.swing.JRadioButton();
        Brownis = new javax.swing.JRadioButton();
        Caramel = new javax.swing.JRadioButton();
        Keju = new javax.swing.JRadioButton();
        Strawbery = new javax.swing.JRadioButton();
        Vanila = new javax.swing.JRadioButton();
        Blubery = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        TanpaToping = new javax.swing.JRadioButton();
        Kacang = new javax.swing.JRadioButton();
        Sosis = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        JumlahKurang = new javax.swing.JButton();
        FieldJumlah = new javax.swing.JTextField();
        JumlahTambah = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Total = new javax.swing.JButton();
        FieldTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Cash = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Kembali = new javax.swing.JTextField();
        Reset = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("MENU MAKANAN");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        Menu.add(Coklat);
        Coklat.setText("Coklat -- Rp. 10000");
        Coklat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoklatActionPerformed(evt);
            }
        });

        Menu.add(Macha);
        Macha.setText("Macha -- Rp. 13000");

        Menu.add(Brownis);
        Brownis.setText("Brownis -- Rp. 15000");
        Brownis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrownisActionPerformed(evt);
            }
        });

        Menu.add(Caramel);
        Caramel.setText("Caramel -- Rp. 15000");
        Caramel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaramelActionPerformed(evt);
            }
        });

        Menu.add(Keju);
        Keju.setText("Keju -- Rp. 10000");
        Keju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KejuActionPerformed(evt);
            }
        });

        Menu.add(Strawbery);
        Strawbery.setText("Strawbery -- Rp. 12000");
        Strawbery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StrawberyActionPerformed(evt);
            }
        });

        Menu.add(Vanila);
        Vanila.setText("Vanila -- Rp. 12000");

        Menu.add(Blubery);
        Blubery.setText("Blubery -- Rp. 12000");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Caramel)
                    .addComponent(Brownis)
                    .addComponent(Macha)
                    .addComponent(Coklat))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Strawbery)
                    .addComponent(Vanila)
                    .addComponent(Blubery)
                    .addComponent(Keju))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Coklat)
                    .addComponent(Keju))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Macha)
                    .addComponent(Strawbery))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Brownis)
                    .addComponent(Vanila))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Caramel)
                    .addComponent(Blubery))
                .addGap(48, 48, 48))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        Topping.add(TanpaToping);
        TanpaToping.setText("No-Topping -- Rp. 0");

        Topping.add(Kacang);
        Kacang.setText("Kacang -- Rp. 3000");

        Topping.add(Sosis);
        Sosis.setText("Sosis -- Rp. 4000");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Sosis)
                    .addComponent(Kacang)
                    .addComponent(TanpaToping))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TanpaToping)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Kacang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sosis)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("TOPPING");

        JumlahKurang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JumlahKurang.setText("-");
        JumlahKurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JumlahKurangActionPerformed(evt);
            }
        });

        JumlahTambah.setText("+");
        JumlahTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JumlahTambahActionPerformed(evt);
            }
        });

        jLabel5.setText("JUMLAH");

        Total.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Total.setText("TOTAL");
        Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalActionPerformed(evt);
            }
        });

        jLabel6.setText("CASH");

        jLabel7.setText("KEMBALI");

        Reset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Reset.setText("RESET");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel6))
                                    .addComponent(Cash, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(Kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(JumlahKurang)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(FieldJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JumlahTambah)
                                .addGap(18, 18, 18)
                                .addComponent(Total))
                            .addComponent(FieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Reset)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JumlahKurang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FieldJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JumlahTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 520, 490));

        jLabel1.setBackground(new java.awt.Color(204, 0, 0));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ROTI   PANGGANG");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("=================================");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BrownisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrownisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BrownisActionPerformed

    private void StrawberyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StrawberyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StrawberyActionPerformed

    private void CaramelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaramelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CaramelActionPerformed

    private void CoklatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoklatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CoklatActionPerformed

    private void KejuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KejuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KejuActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        // TODO add your handling code here:
        Menu.clearSelection();
        Topping.clearSelection();
        FieldJumlah.setText("");
        FieldTotal.setText("");
        Cash.setText("");
        Kembali.setText("");
    }//GEN-LAST:event_ResetActionPerformed

    private void JumlahKurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JumlahKurangActionPerformed
        // TODO add your handling code here:
        JumlahPesanan --;
        FieldJumlah.setText(String.valueOf(JumlahPesanan));
    }//GEN-LAST:event_JumlahKurangActionPerformed

    private void JumlahTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JumlahTambahActionPerformed
        // TODO add your handling code here:
        JumlahPesanan ++;
        FieldJumlah.setText(String.valueOf(JumlahPesanan));
    }//GEN-LAST:event_JumlahTambahActionPerformed

    private void TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalActionPerformed
        // TODO add your handling code here:
        if (Coklat.isSelected()){
            HargaMenu = 10000;
        }else if(Macha.isSelected()){
            HargaMenu = 13000;
        }else if(Keju.isSelected()){
            HargaMenu = 10000;
        }else if(Strawbery.isSelected()){
            HargaMenu = 12000;
        }else if(Brownis.isSelected()){
            HargaMenu = 15000;
        }else if(Caramel.isSelected()){
            HargaMenu = 15000;
        }else if(Vanila.isSelected()){
            HargaMenu = 12000;
        }else if(Blubery.isSelected()){
            HargaMenu = 12000;
        }
        
        if (Kacang.isSelected()){
            HargaToping = 3000;
        }else if(Sosis.isSelected()){
            HargaToping = 4000;
        }else if(TanpaToping.isSelected()){
            HargaToping = 0;
        }
        
        double Diskon = (HargaMenu + HargaToping)*JumlahPesanan;
        
        if (Diskon > 100000){
            Diskon*=0.95;
        }
        
        FieldTotal.setText(String.format("$ %.2f", Diskon));
        FieldTotal.setEditable(false);
        
        if (Cash.getText() .isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mohon pilih salah satu menu terlebih dahulu");
            return;
        }
        
        try {
            double CashPembeli = Double.parseDouble(Cash.getText());
            double Kembalian = CashPembeli - Diskon;
            
            Kembali.setText(String.format("$ %.2f", Kembalian));
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Sesuaikan Cash");
        }
    }//GEN-LAST:event_TotalActionPerformed

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
            java.util.logging.Logger.getLogger(FoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FoodFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Blubery;
    private javax.swing.JRadioButton Brownis;
    private javax.swing.JRadioButton Caramel;
    private javax.swing.JTextField Cash;
    private javax.swing.JRadioButton Coklat;
    private javax.swing.JTextField FieldJumlah;
    private javax.swing.JTextField FieldTotal;
    private javax.swing.JButton JumlahKurang;
    private javax.swing.JButton JumlahTambah;
    private javax.swing.JRadioButton Kacang;
    private javax.swing.JRadioButton Keju;
    private javax.swing.JTextField Kembali;
    private javax.swing.JRadioButton Macha;
    private javax.swing.ButtonGroup Menu;
    private javax.swing.JButton Reset;
    private javax.swing.JRadioButton Sosis;
    private javax.swing.JRadioButton Strawbery;
    private javax.swing.JRadioButton TanpaToping;
    private javax.swing.ButtonGroup Topping;
    private javax.swing.JButton Total;
    private javax.swing.JRadioButton Vanila;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
