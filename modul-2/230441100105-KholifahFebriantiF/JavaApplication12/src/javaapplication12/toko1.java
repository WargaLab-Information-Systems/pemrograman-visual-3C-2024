/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication12;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author USER EBC
 */
public class toko1 extends javax.swing.JFrame {

    /**
     * Creates new form toko1
     */
    public toko1() {
        initComponents();
        jm.setText("0");
        jT2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                penghitungan();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.ButtonGroup();
        sauce = new javax.swing.ButtonGroup();
        panel1 = new javax.swing.JPanel();
        judul = new javax.swing.JLabel();
        gm1 = new javax.swing.JLabel();
        jR1 = new javax.swing.JRadioButton();
        gm2 = new javax.swing.JLabel();
        jR2 = new javax.swing.JRadioButton();
        gm3 = new javax.swing.JLabel();
        jR3 = new javax.swing.JRadioButton();
        gm4 = new javax.swing.JLabel();
        jR4 = new javax.swing.JRadioButton();
        gm5 = new javax.swing.JLabel();
        jR5 = new javax.swing.JRadioButton();
        gm6 = new javax.swing.JLabel();
        jR6 = new javax.swing.JRadioButton();
        hr1 = new javax.swing.JLabel();
        hr2 = new javax.swing.JLabel();
        hr3 = new javax.swing.JLabel();
        hr4 = new javax.swing.JLabel();
        hr5 = new javax.swing.JLabel();
        hr6 = new javax.swing.JLabel();
        mnu = new javax.swing.JLabel();
        tpg = new javax.swing.JLabel();
        jS1 = new javax.swing.JRadioButton();
        jS2 = new javax.swing.JRadioButton();
        jS3 = new javax.swing.JRadioButton();
        psn = new javax.swing.JLabel();
        jum = new javax.swing.JLabel();
        ttl = new javax.swing.JLabel();
        jt1 = new javax.swing.JTextField();
        jT2 = new javax.swing.JTextField();
        uang = new javax.swing.JLabel();
        kem = new javax.swing.JLabel();
        jt3 = new javax.swing.JTextField();
        reset = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        jm = new javax.swing.JTextField();
        jbt = new javax.swing.JButton();
        jbt1 = new javax.swing.JButton();
        hitung = new javax.swing.JButton();
        bgrd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        judul.setFont(new java.awt.Font("Showcard Gothic", 2, 36)); // NOI18N
        judul.setForeground(new java.awt.Color(255, 255, 255));
        judul.setText("DAGING HUHAAA");
        panel1.add(judul, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 300, 30));

        gm1.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER EBC\\Downloads\\gmb1 (1).png")); // NOI18N
        panel1.add(gm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        menu.add(jR1);
        jR1.setForeground(new java.awt.Color(255, 255, 255));
        jR1.setText("STEAK CHIKEN");
        panel1.add(jR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 120, -1));

        gm2.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER EBC\\Downloads\\gmb2 (1).png")); // NOI18N
        panel1.add(gm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        menu.add(jR2);
        jR2.setForeground(new java.awt.Color(255, 255, 255));
        jR2.setText("BEEF TENDERLOIN");
        panel1.add(jR2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        gm3.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER EBC\\Downloads\\gmb3 (1).png")); // NOI18N
        panel1.add(gm3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, -1, -1));

        menu.add(jR3);
        jR3.setForeground(new java.awt.Color(255, 255, 255));
        jR3.setText("BEEF BBQ");
        panel1.add(jR3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, -1, -1));

        gm4.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER EBC\\Downloads\\gmb4 (1).png")); // NOI18N
        panel1.add(gm4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        menu.add(jR4);
        jR4.setForeground(new java.awt.Color(255, 255, 255));
        jR4.setText("BEEF TERIYAKI");
        panel1.add(jR4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 110, -1));

        gm5.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER EBC\\Downloads\\gmb5 (1).jpg")); // NOI18N
        panel1.add(gm5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, -1));

        menu.add(jR5);
        jR5.setForeground(new java.awt.Color(255, 255, 255));
        jR5.setText("BEEF MASHROM");
        panel1.add(jR5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, -1, -1));

        gm6.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER EBC\\Downloads\\gmb6 (1).jpg")); // NOI18N
        panel1.add(gm6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, -1, -1));

        menu.add(jR6);
        jR6.setForeground(new java.awt.Color(255, 255, 255));
        jR6.setText("BEEF CHILI");
        panel1.add(jR6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, -1, -1));

        hr1.setForeground(new java.awt.Color(255, 255, 255));
        hr1.setText("55K");
        panel1.add(hr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        hr2.setForeground(new java.awt.Color(255, 255, 255));
        hr2.setText("65K");
        panel1.add(hr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));

        hr3.setForeground(new java.awt.Color(255, 255, 255));
        hr3.setText("50K");
        panel1.add(hr3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, -1, -1));

        hr4.setForeground(new java.awt.Color(255, 255, 255));
        hr4.setText("45K");
        panel1.add(hr4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        hr5.setForeground(new java.awt.Color(255, 255, 255));
        hr5.setText("55K");
        panel1.add(hr5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        hr6.setForeground(new java.awt.Color(255, 255, 255));
        hr6.setText("40K");
        panel1.add(hr6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, -1, -1));

        mnu.setFont(new java.awt.Font("Stencil", 2, 18)); // NOI18N
        mnu.setForeground(new java.awt.Color(255, 255, 255));
        mnu.setText("MENU");
        panel1.add(mnu, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 60, -1));

        tpg.setFont(new java.awt.Font("Stencil", 2, 18)); // NOI18N
        tpg.setForeground(new java.awt.Color(255, 255, 255));
        tpg.setText("SAUCE");
        panel1.add(tpg, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 80, -1));

        sauce.add(jS1);
        jS1.setForeground(new java.awt.Color(255, 255, 255));
        jS1.setText("LADA HITAM : 15K");
        panel1.add(jS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        sauce.add(jS2);
        jS2.setForeground(new java.awt.Color(255, 255, 255));
        jS2.setText("PAPPERCORN : 25K");
        panel1.add(jS2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, -1, -1));

        sauce.add(jS3);
        jS3.setForeground(new java.awt.Color(255, 255, 255));
        jS3.setText("NO ADD SAUCE : 0 K");
        panel1.add(jS3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, -1, -1));

        psn.setFont(new java.awt.Font("Stencil", 2, 18)); // NOI18N
        psn.setForeground(new java.awt.Color(255, 255, 255));
        psn.setText("YANG DIPESAN");
        panel1.add(psn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 130, -1));

        jum.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        jum.setForeground(new java.awt.Color(255, 255, 255));
        jum.setText("JUMLAH PEMBELIAN :");
        panel1.add(jum, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, -1, -1));

        ttl.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        ttl.setForeground(new java.awt.Color(255, 255, 255));
        ttl.setText("TOTAL HARGA :");
        panel1.add(ttl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, -1, 10));

        jt1.setEditable(false);
        jt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt1ActionPerformed(evt);
            }
        });
        panel1.add(jt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 160, -1));

        jT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT2ActionPerformed(evt);
            }
        });
        panel1.add(jT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 150, -1));

        uang.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        uang.setForeground(new java.awt.Color(255, 255, 255));
        uang.setText("CASH :");
        panel1.add(uang, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, 50, 20));

        kem.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        kem.setForeground(new java.awt.Color(255, 255, 255));
        kem.setText("KEMBALIAN :");
        panel1.add(kem, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, 90, 20));

        jt3.setEditable(false);
        panel1.add(jt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 550, 160, -1));

        reset.setBackground(new java.awt.Color(102, 0, 0));
        reset.setFont(new java.awt.Font("Stencil", 2, 12)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        panel1.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 610, -1, -1));

        batal.setBackground(new java.awt.Color(102, 0, 0));
        batal.setFont(new java.awt.Font("Stencil", 2, 12)); // NOI18N
        batal.setForeground(new java.awt.Color(255, 255, 255));
        batal.setText("BATAL");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        panel1.add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 610, -1, -1));
        panel1.add(jm, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 50, 30));

        jbt.setText("+");
        jbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtActionPerformed(evt);
            }
        });
        panel1.add(jbt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 40, 30));

        jbt1.setText("-");
        jbt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt1ActionPerformed(evt);
            }
        });
        panel1.add(jbt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 40, 30));

        hitung.setBackground(new java.awt.Color(102, 0, 0));
        hitung.setFont(new java.awt.Font("Stencil", 2, 12)); // NOI18N
        hitung.setForeground(new java.awt.Color(255, 255, 255));
        hitung.setText("HITUNG");
        hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungActionPerformed(evt);
            }
        });
        panel1.add(hitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 610, -1, -1));

        bgrd.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER EBC\\Downloads\\P (1).png")); // NOI18N
        panel1.add(bgrd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     private void penghitungan() {
        try {
            double hargasetelahdiskon = Double.parseDouble(jt1.getText());
            double uangmasuk = Double.parseDouble(jT2.getText());
            double kembalian = uangmasuk - hargasetelahdiskon;

            if (kembalian >= 0) {
                jt3.setText(String.valueOf(kembalian));
            } else {
                jt3.setText("Uang Tidak Cukup");
            }
        } catch (NumberFormatException e) {
            jt3.setText("Input Tidak Sesuai");
        }
    }
    
    private void jT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT2ActionPerformed
    double bayar = Double.parseDouble(jT2.getText()); // Mengambil nilai uang yang dibayar
    double totalHarga = Double.parseDouble(jt1.getText()); // Mengambil nilai total harga
    double kembalian = bayar - totalHarga; // Menghitung kembalian

    if (kembalian < 0) {
        JOptionPane.showMessageDialog(this, "Uang yang Anda masukkan kurang!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Kembalian Anda: Rp. " + String.valueOf(kembalian));
    }        // TODO add your handling code here:
    }//GEN-LAST:event_jT2ActionPerformed

    private void jbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtActionPerformed
        // TODO add your handling code here:
        int jbt = Integer.parseInt(jm.getText());
        jbt +=1;
        jm.setText(String.valueOf(jbt));
        
    }//GEN-LAST:event_jbtActionPerformed

    private void jbt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt1ActionPerformed
        // TODO add your handling code here:
       if(Integer.parseInt(jm.getText())> 0){
           int jumlah = Integer.parseInt(jm.getText());
           jumlah -= 1;
           jm.setText(String.valueOf(jumlah));
       }else{
           jm.setText("0");
       }
    }//GEN-LAST:event_jbt1ActionPerformed

    private void jt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jt1ActionPerformed

    private void hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungActionPerformed
        // TODO add your handling code here:
        
       double jumlah = Integer.parseInt(jm.getText());
      
       double totalHarga = 0;
       boolean menuDipilih = false;
       
      if(jR1.isSelected()){
           totalHarga += jumlah * 55000; 
           menuDipilih = true;
        }if(jR2.isSelected()){
            totalHarga += jumlah * 65000;
            menuDipilih = true;
        }if(jR3.isSelected()){
            totalHarga += jumlah * 50000;
            menuDipilih = true;
        }if(jR4.isSelected()){
            totalHarga += jumlah * 45000;
            menuDipilih = true;
        }if(jR5.isSelected()){
            totalHarga += jumlah * 55000;
            menuDipilih = true;
        }if(jR6.isSelected()){
            totalHarga += jumlah * 40000;
            menuDipilih = true;
        }if(jS1.isSelected()){
            totalHarga += jumlah * 15000;
            menuDipilih = true;
        }if(jS2.isSelected()){
            totalHarga += jumlah * 25000;
            menuDipilih = true;
        }if(jS3.isSelected()){
            totalHarga += jumlah *0;
            menuDipilih = true;
        }jt1.setText("Rp." + String.valueOf(totalHarga));
        if(menuDipilih== false){
           JOptionPane.showMessageDialog(this, "Pilih setidaknya satu menu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
           return;
        }
        if(totalHarga > 100000){
            double diskon = totalHarga * 0.05;
            double hasill = totalHarga - diskon;
            JOptionPane.showMessageDialog(this, "Selamat anada mendapatkan Diskon 5%");
            jt1.setText(String.valueOf(hasill));
        }else{
            jt1.setText(String.valueOf(totalHarga));
        }
    }//GEN-LAST:event_hitungActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        menu.clearSelection();
        sauce.clearSelection();
        jm.setText("0");
        jt1.setText("");
        jT2.setText("");
        jt3.setText("");
    }//GEN-LAST:event_resetActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Yakin mau meinggalkan halaman ini?", "Peringatan", JOptionPane.WARNING_MESSAGE);
        System.exit(0);
    }//GEN-LAST:event_batalActionPerformed

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
            java.util.logging.Logger.getLogger(toko1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(toko1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(toko1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(toko1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new toko1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batal;
    private javax.swing.JLabel bgrd;
    private javax.swing.JLabel gm1;
    private javax.swing.JLabel gm2;
    private javax.swing.JLabel gm3;
    private javax.swing.JLabel gm4;
    private javax.swing.JLabel gm5;
    private javax.swing.JLabel gm6;
    private javax.swing.JButton hitung;
    private javax.swing.JLabel hr1;
    private javax.swing.JLabel hr2;
    private javax.swing.JLabel hr3;
    private javax.swing.JLabel hr4;
    private javax.swing.JLabel hr5;
    private javax.swing.JLabel hr6;
    private javax.swing.JRadioButton jR1;
    private javax.swing.JRadioButton jR2;
    private javax.swing.JRadioButton jR3;
    private javax.swing.JRadioButton jR4;
    private javax.swing.JRadioButton jR5;
    private javax.swing.JRadioButton jR6;
    private javax.swing.JRadioButton jS1;
    private javax.swing.JRadioButton jS2;
    private javax.swing.JRadioButton jS3;
    private javax.swing.JTextField jT2;
    private javax.swing.JButton jbt;
    private javax.swing.JButton jbt1;
    private javax.swing.JTextField jm;
    private javax.swing.JTextField jt1;
    private javax.swing.JTextField jt3;
    private javax.swing.JLabel judul;
    private javax.swing.JLabel jum;
    private javax.swing.JLabel kem;
    private javax.swing.ButtonGroup menu;
    private javax.swing.JLabel mnu;
    private javax.swing.JPanel panel1;
    private javax.swing.JLabel psn;
    private javax.swing.JButton reset;
    private javax.swing.ButtonGroup sauce;
    private javax.swing.JLabel tpg;
    private javax.swing.JLabel ttl;
    private javax.swing.JLabel uang;
    // End of variables declaration//GEN-END:variables
}
