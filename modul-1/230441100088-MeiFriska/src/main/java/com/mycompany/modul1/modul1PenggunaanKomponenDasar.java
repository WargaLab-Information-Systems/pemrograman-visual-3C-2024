
package com.mycompany.modul1;

import javax.swing.JOptionPane;

public class modul1PenggunaanKomponenDasar extends javax.swing.JFrame {

    public modul1PenggunaanKomponenDasar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        hallo = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        tglpinjem = new javax.swing.JTextField();
        tglkembali = new javax.swing.JTextField();
        keadaanbuku = new javax.swing.JComboBox<>();
        jender1 = new javax.swing.JRadioButton();
        jender2 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        judulbuku = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        hai5 = new javax.swing.JRadioButton();
        hai2 = new javax.swing.JRadioButton();
        hai3 = new javax.swing.JRadioButton();
        hai4 = new javax.swing.JRadioButton();
        hai1 = new javax.swing.JRadioButton();
        hai6 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        kirim = new javax.swing.JButton();
        konfirmasi = new javax.swing.JCheckBox();
        batal = new javax.swing.JButton();

        jLabel11.setText("jLabel11");

        jLabel12.setText("jLabel12");

        jTextField6.setEditable(false);
        jTextField6.setText("jTextField6");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Downloads\\library-removebg-preview.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 80, 80));

        jLabel3.setFont(new java.awt.Font("Sitka Display", 3, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Formulir Peminjaman Buku ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 330, 40));

        jLabel4.setFont(new java.awt.Font("Sitka Heading", 3, 18)); // NOI18N
        jLabel4.setText("Perpustakaan Library Infinitum");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 280, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        jLabel5.setText("Jl.Raya Rahmad no2 Blok.F");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 180, 20));

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Downloads\\book (1).png")); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 70, 80));
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 80, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 551, 90));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel6.setText("Nama");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 36));

        jLabel7.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel7.setText("Tgl Peminjaman");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, 40));

        jLabel8.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel8.setText("Tgl Pengembalian");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 40));

        jLabel9.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel9.setText("Jenis kelamin");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 30));

        jLabel10.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel10.setText("Keadaan Buku");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 120, 30));

        nama.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });
        jPanel2.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 350, -1));

        tglpinjem.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jPanel2.add(tglpinjem, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 350, -1));

        tglkembali.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jPanel2.add(tglkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 350, -1));

        keadaanbuku.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        keadaanbuku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bagus", "Rusak Biasa", "Rusak Berat" }));
        keadaanbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keadaanbukuActionPerformed(evt);
            }
        });
        jPanel2.add(keadaanbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 110, -1));

        hallo.add(jender1);
        jender1.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jender1.setText("Laki - Laki");
        jender1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jender1ActionPerformed(evt);
            }
        });
        jPanel2.add(jender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 150, 50));

        hallo.add(jender2);
        jender2.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jender2.setText("Perempuan");
        jender2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jender2ActionPerformed(evt);
            }
        });
        jPanel2.add(jender2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 150, 30));

        jLabel13.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel13.setText("Judul Buku");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 130, 20));

        judulbuku.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        judulbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                judulbukuActionPerformed(evt);
            }
        });
        jPanel2.add(judulbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 350, -1));

        jLabel14.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel14.setText("Katagori Buku");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 140, 30));

        buttonGroup1.add(hai5);
        hai5.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        hai5.setText("Fiksi");
        hai5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hai5ActionPerformed(evt);
            }
        });
        jPanel2.add(hai5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 130, 40));

        buttonGroup1.add(hai2);
        hai2.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        hai2.setText("Non-Fiksi");
        jPanel2.add(hai2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 110, 30));

        buttonGroup1.add(hai3);
        hai3.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        hai3.setText("Komik");
        jPanel2.add(hai3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, 30));

        buttonGroup1.add(hai4);
        hai4.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        hai4.setText("Sastra");
        hai4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hai4ActionPerformed(evt);
            }
        });
        jPanel2.add(hai4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

        buttonGroup1.add(hai1);
        hai1.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        hai1.setText("Petualangan");
        jPanel2.add(hai1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, 30));

        buttonGroup1.add(hai6);
        hai6.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        hai6.setText("Sejarah");
        hai6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hai6ActionPerformed(evt);
            }
        });
        jPanel2.add(hai6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, -1));

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 80, 20));

        kirim.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        kirim.setText("Submit");
        kirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kirimActionPerformed(evt);
            }
        });
        jPanel2.add(kirim, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 80, 20));

        konfirmasi.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        konfirmasi.setText("Data Yang Saya Masukan Sudah Benar");
        konfirmasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konfirmasiActionPerformed(evt);
            }
        });
        jPanel2.add(konfirmasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        batal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        jPanel2.add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 80, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 550, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jender1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jender1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jender1ActionPerformed

    private void jender2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jender2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jender2ActionPerformed

    private void keadaanbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keadaanbukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keadaanbukuActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void hai4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hai4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hai4ActionPerformed

    private void hai6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hai6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hai6ActionPerformed

    private void konfirmasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konfirmasiActionPerformed
          // TODO add your handling code here:
    }//GEN-LAST:event_konfirmasiActionPerformed

    private void judulbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_judulbukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_judulbukuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        nama.setText("");
        tglpinjem.setText("");
        hallo.clearSelection();
        buttonGroup1.clearSelection();
        tglkembali.setText("");
        judulbuku.setText("");
        keadaanbuku.setSelectedIndex(0);
        konfirmasi.setSelected(false);   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void kirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kirimActionPerformed
    
        if(konfirmasi.isSelected()){
            modul1tampilan2 tampilan2 = new modul1tampilan2();
            
            tampilan2.Nama.setText(nama.getText());
            
            if(jender1.isSelected()== true){
                tampilan2.jeniskelamin.setText(jender1.getText());
            }else if(jender2.isSelected()== true){
                tampilan2.jeniskelamin.setText(jender2.getText());
            }else {
               tampilan2.jeniskelamin.setText("");
            }

            tampilan2.tglpinjem.setText(tglpinjem.getText());
            tampilan2.tglkembali.setText(tglkembali.getText());
            tampilan2.judulbuku.setText(judulbuku.getText());
            
            if(hai1.isSelected()==true){
                tampilan2.katagori.setText(hai1.getText());
            }
            else if(hai2.isSelected()){
                tampilan2.katagori.setText(hai2.getText());
            }
            else if(hai3.isSelected()){
                tampilan2.katagori.setText(hai3.getText());
            }
            else if(hai4.isSelected()){
                tampilan2.katagori.setText(hai4.getText());
            }
            else if(hai5.isSelected()){
                tampilan2.katagori.setText(hai5.getText());
            }
            else if(hai6.isSelected()){
                tampilan2.katagori.setText(hai6.getText());
            }
            else{
               tampilan2.katagori.setText("");
            }
            String kondisi = keadaanbuku.getSelectedItem().toString();
            tampilan2.keadaanbuku.setText(kondisi);
            
             if(nama.getText().trim().isEmpty()||hallo.equals(false)||tglpinjem.getText().trim().isEmpty()||
                    tglkembali.getText().trim().isEmpty()||judulbuku.getText().trim().isEmpty()||buttonGroup1.equals(false)){
                JOptionPane.showMessageDialog(this,"ADA YANG BELUM DI ISI LOOOO!!!", "INPO", JOptionPane.INFORMATION_MESSAGE);
            }
             else{  
                 tampilan2.setVisible(true);
             }
            
        }
        else{
            JOptionPane.showMessageDialog(this, "lololo kok belum di centang", "inpo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_kirimActionPerformed

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed

        int batal = JOptionPane.showConfirmDialog(this,"kenapa kok gak jadi?","Batal",JOptionPane.YES_NO_OPTION);
        if (batal == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_batalActionPerformed

    private void hai5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hai5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hai5ActionPerformed

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
            java.util.logging.Logger.getLogger(modul1PenggunaanKomponenDasar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modul1PenggunaanKomponenDasar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modul1PenggunaanKomponenDasar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modul1PenggunaanKomponenDasar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modul1PenggunaanKomponenDasar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batal;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JRadioButton hai1;
    public javax.swing.JRadioButton hai2;
    public javax.swing.JRadioButton hai3;
    public javax.swing.JRadioButton hai4;
    public javax.swing.JRadioButton hai5;
    public javax.swing.JRadioButton hai6;
    private javax.swing.ButtonGroup hallo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextPane jTextPane1;
    public javax.swing.JRadioButton jender1;
    public javax.swing.JRadioButton jender2;
    public javax.swing.JTextField judulbuku;
    public javax.swing.JComboBox<String> keadaanbuku;
    private javax.swing.JButton kirim;
    private javax.swing.JCheckBox konfirmasi;
    public javax.swing.JTextField nama;
    public javax.swing.JTextField tglkembali;
    public javax.swing.JTextField tglpinjem;
    // End of variables declaration//GEN-END:variables
}
