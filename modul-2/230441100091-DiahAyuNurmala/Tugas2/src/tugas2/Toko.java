
package tugas2;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class Toko extends javax.swing.JFrame {
    private int total = 0;
    /**
     * Creates new form Toko
     */
    public Toko() {
        initComponents();
        tfjumlahpesan.setText("1");
         
        tfcash.getDocument().addDocumentListener(new DocumentListener() {
            public void removeUpdate(DocumentEvent e) {
                hitungKembalian();
            }
            public void insertUpdate(DocumentEvent e) {
                hitungKembalian();
            }

            public void changedUpdate(DocumentEvent e) {
                 }

            private void hitungKembalian() {
                try {
        
        int total = Integer.parseInt(tftotalbayar.getText());
        int uangPembeli = Integer.parseInt(tfcash.getText());
        int kembalian = uangPembeli - total;

        // Tampilkan kembalian di TextField tfKembalian
        if (kembalian < 0) {
            tfkembalian.setText("Uang kurang");
        } else {
            tfkembalian.setText(String.valueOf(kembalian));
        }
    } catch (NumberFormatException e) {
        tfkembalian.setText("Input Tidak Sesuai");
    }}
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.ButtonGroup();
        Toping = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rbcoklat = new javax.swing.JRadioButton();
        rbroti = new javax.swing.JRadioButton();
        rbcookis = new javax.swing.JRadioButton();
        rbbrownis = new javax.swing.JRadioButton();
        rbcroisant = new javax.swing.JRadioButton();
        rbdonat = new javax.swing.JRadioButton();
        rbcake = new javax.swing.JRadioButton();
        rbkeju = new javax.swing.JRadioButton();
        rbtiramisu = new javax.swing.JRadioButton();
        rbstrobery = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tftotalbayar = new javax.swing.JTextField();
        tfcash = new javax.swing.JTextField();
        tfkembalian = new javax.swing.JTextField();
        tfjumlahpesan = new javax.swing.JTextField();
        btnhitung = new javax.swing.JButton();
        btnkurangi = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Downloads\\bread.png")); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Downloads\\cookies.png")); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Downloads\\brownie.png")); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Downloads\\croissant.png")); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Downloads\\donut.png")); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Downloads\\cake-slice.png")); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, -1, -1));

        jLabel8.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jLabel8.setText("TOPING");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 70, -1));

        jLabel9.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jLabel9.setText("MENU Diah's Bakery");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        Toping.add(rbcoklat);
        rbcoklat.setFont(new java.awt.Font("Serif", 2, 14)); // NOI18N
        rbcoklat.setText("Coklat Rp.2000");
        jPanel1.add(rbcoklat, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, -1, -1));

        Menu.add(rbroti);
        rbroti.setFont(new java.awt.Font("Serif", 2, 14)); // NOI18N
        rbroti.setText("13.000");
        rbroti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbrotiActionPerformed(evt);
            }
        });
        jPanel1.add(rbroti, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        Menu.add(rbcookis);
        rbcookis.setFont(new java.awt.Font("Serif", 2, 14)); // NOI18N
        rbcookis.setText("10.000");
        rbcookis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbcookisActionPerformed(evt);
            }
        });
        jPanel1.add(rbcookis, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        Menu.add(rbbrownis);
        rbbrownis.setFont(new java.awt.Font("Serif", 2, 14)); // NOI18N
        rbbrownis.setText("15.000");
        rbbrownis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbbrownisActionPerformed(evt);
            }
        });
        jPanel1.add(rbbrownis, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        Menu.add(rbcroisant);
        rbcroisant.setFont(new java.awt.Font("Serif", 2, 14)); // NOI18N
        rbcroisant.setText("20.000");
        jPanel1.add(rbcroisant, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));

        Menu.add(rbdonat);
        rbdonat.setFont(new java.awt.Font("Serif", 2, 14)); // NOI18N
        rbdonat.setText("15.000");
        rbdonat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbdonatActionPerformed(evt);
            }
        });
        jPanel1.add(rbdonat, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        Menu.add(rbcake);
        rbcake.setFont(new java.awt.Font("Serif", 2, 14)); // NOI18N
        rbcake.setText("20.000");
        jPanel1.add(rbcake, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, -1, -1));

        Toping.add(rbkeju);
        rbkeju.setFont(new java.awt.Font("Serif", 2, 14)); // NOI18N
        rbkeju.setText("Keju Rp.3000");
        rbkeju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbkejuActionPerformed(evt);
            }
        });
        jPanel1.add(rbkeju, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, -1, -1));

        Toping.add(rbtiramisu);
        rbtiramisu.setFont(new java.awt.Font("Serif", 2, 14)); // NOI18N
        rbtiramisu.setText("Tiramisu Rp.3000");
        jPanel1.add(rbtiramisu, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, -1, -1));

        Toping.add(rbstrobery);
        rbstrobery.setFont(new java.awt.Font("Serif", 2, 14)); // NOI18N
        rbstrobery.setText("Strobery Rp.4000");
        rbstrobery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbstroberyActionPerformed(evt);
            }
        });
        jPanel1.add(rbstrobery, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, -1, -1));

        jLabel11.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel11.setText("Cash");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, -1));

        jLabel12.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel12.setText("Kembalian");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, -1, -1));

        tftotalbayar.setEditable(false);
        tftotalbayar.setBackground(new java.awt.Color(255, 153, 153));
        tftotalbayar.setFont(new java.awt.Font("Serif", 3, 12)); // NOI18N
        tftotalbayar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(tftotalbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, 120, 50));

        tfcash.setFont(new java.awt.Font("Serif", 3, 12)); // NOI18N
        tfcash.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfcash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfcashActionPerformed(evt);
            }
        });
        jPanel1.add(tfcash, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 120, -1));

        tfkembalian.setEditable(false);
        tfkembalian.setFont(new java.awt.Font("Serif", 3, 12)); // NOI18N
        tfkembalian.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(tfkembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 120, -1));

        tfjumlahpesan.setEditable(false);
        tfjumlahpesan.setFont(new java.awt.Font("Serif", 3, 12)); // NOI18N
        tfjumlahpesan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(tfjumlahpesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 140, 30));

        btnhitung.setBackground(new java.awt.Color(255, 153, 153));
        btnhitung.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btnhitung.setText("Hitung");
        btnhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhitungActionPerformed(evt);
            }
        });
        jPanel1.add(btnhitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, 90, 30));

        btnkurangi.setFont(new java.awt.Font("Serif", 3, 12)); // NOI18N
        btnkurangi.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Downloads\\minus.png")); // NOI18N
        btnkurangi.setText("Kurangi");
        btnkurangi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkurangiActionPerformed(evt);
            }
        });
        jPanel1.add(btnkurangi, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 150, 30));

        btntambah.setFont(new java.awt.Font("Serif", 3, 12)); // NOI18N
        btntambah.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Downloads\\add.png")); // NOI18N
        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        jPanel1.add(btntambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 150, 30));

        btnhapus.setBackground(new java.awt.Color(255, 153, 153));
        btnhapus.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btnhapus.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Downloads\\trash.png")); // NOI18N
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, -1, -1));

        jLabel13.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel13.setText("Total Pembayaran :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 310, 120, -1));

        jLabel10.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        jLabel10.setText("Roti Isi Coklat");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jLabel14.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        jLabel14.setText("Cookies");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jLabel15.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        jLabel15.setText("Donat");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        jLabel16.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        jLabel16.setText("Cake");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, -1, -1));

        jLabel17.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        jLabel17.setText("Croissant");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        jLabel18.setFont(new java.awt.Font("Serif", 2, 12)); // NOI18N
        jLabel18.setText("Brownies");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Downloads\\Toko Roti.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbrotiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbrotiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbrotiActionPerformed

    private void rbbrownisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbbrownisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbbrownisActionPerformed

    private void rbdonatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbdonatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbdonatActionPerformed

    private void rbstroberyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbstroberyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbstroberyActionPerformed

    private void rbcookisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbcookisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbcookisActionPerformed

    private void btnhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhitungActionPerformed
        if(!rbroti.isSelected() && !rbbrownis.isSelected() && !rbdonat.isSelected() && !rbcookis.isSelected()
           && !rbcroisant.isSelected() && !rbcake.isSelected()){
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Menu Terlebih Dahulu");
        }else{
            total = 0;
            int Jumlah = Integer.parseInt(tfjumlahpesan.getText()); // Ambil nilai jumlah

            if (rbroti.isSelected()) total+= 13000;
                else if (rbbrownis.isSelected()) total += 15000;
                else if (rbdonat.isSelected()) total += 15000;
                else if (rbcroisant.isSelected()) total += 20000;
                else if (rbcookis.isSelected()) total += 10000;
                else if (rbcake.isSelected()) total += 20000;
            
            if (rbcoklat.isSelected()) total+= 2000;
                else if (rbkeju.isSelected()) total += 3000;
                else if (rbtiramisu.isSelected()) total += 3000;
                else if (rbstrobery.isSelected()) total += 4000;
            
            total *= Jumlah;
             if (total > 100000) {
                    total *= 0.95;
                }
            tftotalbayar.setText(String.valueOf(total));

        }
    }//GEN-LAST:event_btnhitungActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        int Jumlah = Integer.parseInt(tfjumlahpesan.getText());
                Jumlah++; 
                tfjumlahpesan.setText(String.valueOf(Jumlah));
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnkurangiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkurangiActionPerformed
        int Jumlah = Integer.parseInt(tfjumlahpesan.getText());
                if (Jumlah > 1) { 
                    Jumlah--; 
                }
                tfjumlahpesan.setText(String.valueOf(Jumlah));
    }//GEN-LAST:event_btnkurangiActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
                tfkembalian.setText("");
                tftotalbayar.setText("");
                tfjumlahpesan.setText("1");
                tfcash.setText("");
                Menu.clearSelection();
                Toping.clearSelection();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void rbkejuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbkejuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbkejuActionPerformed

    private void tfcashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfcashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfcashActionPerformed

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
            java.util.logging.Logger.getLogger(Toko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Toko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Toko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Toko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Toko().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Menu;
    private javax.swing.ButtonGroup Toping;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnhitung;
    private javax.swing.JButton btnkurangi;
    private javax.swing.JButton btntambah;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbbrownis;
    private javax.swing.JRadioButton rbcake;
    private javax.swing.JRadioButton rbcoklat;
    private javax.swing.JRadioButton rbcookis;
    private javax.swing.JRadioButton rbcroisant;
    private javax.swing.JRadioButton rbdonat;
    private javax.swing.JRadioButton rbkeju;
    private javax.swing.JRadioButton rbroti;
    private javax.swing.JRadioButton rbstrobery;
    private javax.swing.JRadioButton rbtiramisu;
    private javax.swing.JTextField tfcash;
    private javax.swing.JTextField tfjumlahpesan;
    private javax.swing.JTextField tfkembalian;
    private javax.swing.JTextField tftotalbayar;
    // End of variables declaration//GEN-END:variables
}
