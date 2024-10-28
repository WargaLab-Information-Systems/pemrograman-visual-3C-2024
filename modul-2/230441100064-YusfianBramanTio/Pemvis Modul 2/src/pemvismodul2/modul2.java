/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pemvismodul2;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author Yusfian Braman Tio
 */
public class modul2 extends javax.swing.JFrame {

    int total = 0;
    public modul2() {
        initComponents();
        tfJumlah.setText(Integer.toString(total));
        tfTotal.setEditable(false);
        tfKembalian.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgRoti = new javax.swing.ButtonGroup();
        bgTopping = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        rbTawar = new javax.swing.JRadioButton();
        rbOdading = new javax.swing.JRadioButton();
        rbCanai = new javax.swing.JRadioButton();
        rbSisir = new javax.swing.JRadioButton();
        rbBluder = new javax.swing.JRadioButton();
        rbPanada = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rbTanpaTopping = new javax.swing.JRadioButton();
        rbKeju = new javax.swing.JRadioButton();
        rbCoklat = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnHitung = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfUang = new javax.swing.JTextField();
        tfKembalian = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        tfKurang = new javax.swing.JButton();
        tfTambah = new javax.swing.JButton();
        tfJumlah = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Semua Tersedia Disini");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 130, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ROTI ANDA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\Yusfian Braman Tio\\Downloads\\rotip1 (5).png")); // NOI18N
        jLabel11.setText("Semua Tersedia Disini\n");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 220));

        jPanel2.setBackground(new java.awt.Color(240, 196, 82));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Menu Roti");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        bgRoti.add(rbTawar);
        rbTawar.setText("Tawar - Rp.1.000");
        rbTawar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTawarActionPerformed(evt);
            }
        });
        jPanel2.add(rbTawar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        bgRoti.add(rbOdading);
        rbOdading.setText("Odading - Rp.2.500");
        jPanel2.add(rbOdading, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        bgRoti.add(rbCanai);
        rbCanai.setText("Canai - Rp.5.000");
        rbCanai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCanaiActionPerformed(evt);
            }
        });
        jPanel2.add(rbCanai, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        bgRoti.add(rbSisir);
        rbSisir.setText("Sisir - Rp.2.000");
        rbSisir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSisirActionPerformed(evt);
            }
        });
        jPanel2.add(rbSisir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        bgRoti.add(rbBluder);
        rbBluder.setText("Bluder - Rp.7.000");
        rbBluder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBluderActionPerformed(evt);
            }
        });
        jPanel2.add(rbBluder, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, -1));

        bgRoti.add(rbPanada);
        rbPanada.setText("Panada - Rp.8.000");
        rbPanada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPanadaActionPerformed(evt);
            }
        });
        jPanel2.add(rbPanada, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, -1));

        jLabel3.setText("=================================================================");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Topping");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        bgTopping.add(rbTanpaTopping);
        rbTanpaTopping.setText("Tanpa Topping - Rp.0");
        rbTanpaTopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTanpaToppingActionPerformed(evt);
            }
        });
        jPanel2.add(rbTanpaTopping, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        bgTopping.add(rbKeju);
        rbKeju.setText("Keju - Rp.1.000");
        rbKeju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbKejuActionPerformed(evt);
            }
        });
        jPanel2.add(rbKeju, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, -1, -1));

        bgTopping.add(rbCoklat);
        rbCoklat.setText("Coklat - Rp.1.000");
        jPanel2.add(rbCoklat, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, -1, -1));

        jLabel5.setText("=================================================================");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, -1));

        jLabel6.setText("=================================================================");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, -1, -1));

        btnHitung.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnHitung.setText("HITUNG");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });
        jPanel2.add(btnHitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 110, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Jumlah");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Total");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        tfTotal.setEditable(false);
        jPanel2.add(tfTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 170, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Uang");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));
        jPanel2.add(tfUang, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 110, -1));

        tfKembalian.setEditable(false);
        tfKembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKembalianActionPerformed(evt);
            }
        });
        jPanel2.add(tfKembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 130, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Kembalian");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, -1, -1));

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel2.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        tfKurang.setText("-");
        tfKurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKurangActionPerformed(evt);
            }
        });
        jPanel2.add(tfKurang, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        tfTambah.setText("+");
        tfTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTambahActionPerformed(evt);
            }
        });
        jPanel2.add(tfTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, -1));

        tfJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfJumlahActionPerformed(evt);
            }
        });
        jPanel2.add(tfJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 40, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\Yusfian Braman Tio\\Downloads\\fotojet-8-1jpg-20211219025657 (1).jpg")); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Yusfian Braman Tio\\Downloads\\canai (1).jpg")); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\Yusfian Braman Tio\\Downloads\\bluder2 (1).jpg")); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\Yusfian Braman Tio\\Downloads\\odading2 (1).jpg")); // NOI18N
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon("C:\\Users\\Yusfian Braman Tio\\Downloads\\Roti-Sisir (1).png")); // NOI18N
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\Yusfian Braman Tio\\Downloads\\panada (1).png")); // NOI18N
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\Yusfian Braman Tio\\Downloads\\keju (1).png")); // NOI18N
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\Yusfian Braman Tio\\Downloads\\meses-removebg-preview (1).png")); // NOI18N
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbTawarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTawarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbTawarActionPerformed

    private void rbPanadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPanadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbPanadaActionPerformed

    private void rbSisirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSisirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbSisirActionPerformed

    private void rbTanpaToppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTanpaToppingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbTanpaToppingActionPerformed

    private void tfKembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfKembalianActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        bgRoti.clearSelection();
        bgTopping.clearSelection();
        tfJumlah.setText(null);
        tfUang.setText(null);
        tfTotal.setText(null);
        tfKembalian.setText(null);
        total = 0;
    }//GEN-LAST:event_btnResetActionPerformed

    private void tfTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTambahActionPerformed
        // TODO add your handling code here:
        total += 1;
        tfJumlah.setText(Integer.toString(total));
    }//GEN-LAST:event_tfTambahActionPerformed

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        // TODO add your handling code here:
        if(bgTopping.getSelection()==null || bgRoti.getSelection()==null) {
           JOptionPane.showMessageDialog(null, "Silahkan pilih Menu", "Peringatan", JOptionPane.WARNING_MESSAGE);
           return;
       }
        int jumlahRoti = Integer.parseInt(tfJumlah.getText());
        if(jumlahRoti < 1){
            JOptionPane.showMessageDialog(null, "Masukkan Jumlah Roti", "Jumlah Roti < 1", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(tfUang.getText().isEmpty() || tfUang.getText() == null){
             JOptionPane.showMessageDialog(null, "Masukkan Jumlah Uang Anda", "Uang = 0", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int uang = Integer.parseInt(tfUang.getText());
        
        int hargaRoti = 0;
        if(rbTawar.isSelected()){
            hargaRoti = 1000;
        }
        if(rbOdading.isSelected()){
           hargaRoti = 2500;
       }
        if(rbCanai.isSelected()){
           hargaRoti = 5000;
       }
        if(rbSisir.isSelected()){
           hargaRoti = 2000;
       }
        if(rbBluder.isSelected()){
           hargaRoti = 7000;
       }
        if(rbPanada.isSelected()){
           hargaRoti = 8000;
       }
        
        if(rbKeju.isSelected() || rbCoklat.isSelected()){
           hargaRoti += 1000;
       }
        
        int totalHarga = hargaRoti * jumlahRoti;
        
        if (totalHarga>=100000){
            totalHarga *= 0.95;
        }
        if(uang < totalHarga){
            JOptionPane.showMessageDialog(null, "Jumlah Uang Anda tidak cukup", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else{
            tfTotal.setText("Rp." + totalHarga);
            tfKembalian.setText("Rp." + (uang - totalHarga));
        }
        
    }//GEN-LAST:event_btnHitungActionPerformed

    private void tfJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfJumlahActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tfJumlahActionPerformed

    private void tfKurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKurangActionPerformed
        // TODO add your handling code here:
        if(total == 0){
            total = 0;
        }else{
            //Operator Assignment
            total -=  1;
        }
        tfJumlah.setText(Integer.toString(total));
    }//GEN-LAST:event_tfKurangActionPerformed

    private void rbKejuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbKejuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbKejuActionPerformed

    private void rbCanaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCanaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCanaiActionPerformed

    private void rbBluderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBluderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbBluderActionPerformed

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
            java.util.logging.Logger.getLogger(modul2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modul2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modul2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modul2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modul2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgRoti;
    private javax.swing.ButtonGroup bgTopping;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnReset;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton rbBluder;
    private javax.swing.JRadioButton rbCanai;
    private javax.swing.JRadioButton rbCoklat;
    private javax.swing.JRadioButton rbKeju;
    private javax.swing.JRadioButton rbOdading;
    private javax.swing.JRadioButton rbPanada;
    private javax.swing.JRadioButton rbSisir;
    private javax.swing.JRadioButton rbTanpaTopping;
    private javax.swing.JRadioButton rbTawar;
    private javax.swing.JTextField tfJumlah;
    private javax.swing.JTextField tfKembalian;
    private javax.swing.JButton tfKurang;
    private javax.swing.JButton tfTambah;
    private javax.swing.JTextField tfTotal;
    private javax.swing.JTextField tfUang;
    // End of variables declaration//GEN-END:variables
}
