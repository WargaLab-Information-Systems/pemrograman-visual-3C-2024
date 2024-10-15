/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pembayaranmodul3;

import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class spp extends javax.swing.JFrame {

    private boolean[] statusPembayaran = new boolean[12]; // Status pembayaran untuk tiap bulan

    /**
     * Creates new form spp
     */
    public spp() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nama = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        namasiswa = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sppbulanan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        button = new javax.swing.JPanel();
        btncek = new javax.swing.JButton();
        btnbayar = new javax.swing.JButton();
        btnhitung = new javax.swing.JButton();
        heading = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        jan = new javax.swing.JCheckBox();
        feb = new javax.swing.JCheckBox();
        mar = new javax.swing.JCheckBox();
        apr = new javax.swing.JCheckBox();
        mei = new javax.swing.JCheckBox();
        jun = new javax.swing.JCheckBox();
        jul = new javax.swing.JCheckBox();
        agu = new javax.swing.JCheckBox();
        sep = new javax.swing.JCheckBox();
        okto = new javax.swing.JCheckBox();
        nov = new javax.swing.JCheckBox();
        des = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nama.setPreferredSize(new java.awt.Dimension(300, 150));
        nama.setRequestFocusEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nama       :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("SPP/Bulan :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Total         :");

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\H\\Pictures\\FTO KTP\\logo_madura-removebg-preview.png")); // NOI18N

        javax.swing.GroupLayout namaLayout = new javax.swing.GroupLayout(nama);
        nama.setLayout(namaLayout);
        namaLayout.setHorizontalGroup(
            namaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(namaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(namaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sppbulanan, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, namaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(71, 71, 71))
        );
        namaLayout.setVerticalGroup(
            namaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel6)
                .addGap(61, 61, 61)
                .addGroup(namaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(namaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sppbulanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(namaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(80, 80, 80))
        );

        getContentPane().add(nama, java.awt.BorderLayout.LINE_END);

        button.setBackground(new java.awt.Color(153, 153, 153));
        button.setPreferredSize(new java.awt.Dimension(234, 50));
        button.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 100, 15));

        btncek.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btncek.setText("Cek");
        btncek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekActionPerformed(evt);
            }
        });
        button.add(btncek);

        btnbayar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnbayar.setText("Bayar");
        btnbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbayarActionPerformed(evt);
            }
        });
        button.add(btnbayar);

        btnhitung.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnhitung.setText("Hitung");
        btnhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhitungActionPerformed(evt);
            }
        });
        button.add(btnhitung);

        getContentPane().add(button, java.awt.BorderLayout.PAGE_END);

        heading.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Sitka Small", 1, 24)); // NOI18N
        jLabel1.setText("PEMBAYARAN SPP ASRAMA PUTRA ");
        heading.add(jLabel1);

        getContentPane().add(heading, java.awt.BorderLayout.PAGE_START);

        menu.setBackground(new java.awt.Color(102, 102, 255));
        menu.setPreferredSize(new java.awt.Dimension(400, 500));
        menu.setLayout(new java.awt.GridLayout(6, 2, 15, 0));

        jan.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jan.setText("Januari");
        jan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                janActionPerformed(evt);
            }
        });
        menu.add(jan);

        feb.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        feb.setText("Februari");
        menu.add(feb);

        mar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        mar.setText("Maret");
        menu.add(mar);

        apr.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        apr.setText("April");
        menu.add(apr);

        mei.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        mei.setText("Mei");
        mei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meiActionPerformed(evt);
            }
        });
        menu.add(mei);

        jun.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jun.setText("Juni");
        menu.add(jun);

        jul.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jul.setText("Juli");
        menu.add(jul);

        agu.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        agu.setText("Agustus");
        menu.add(agu);

        sep.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        sep.setText("September");
        menu.add(sep);

        okto.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        okto.setText("Oktober");
        menu.add(okto);

        nov.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        nov.setText("November");
        menu.add(nov);

        des.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        des.setText("Desember");
        menu.add(des);

        getContentPane().add(menu, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void janActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_janActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_janActionPerformed

    private void meiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meiActionPerformed

    private void btnbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbayarActionPerformed
       
   // TODO add your handling code here:
boolean isAnySelected = false;

if (jan.isSelected()) {
    statusPembayaran[0] = true;
    isAnySelected = true;
}
if (feb.isSelected()) {
    statusPembayaran[1] = true;
    isAnySelected = true;
}
if (mar.isSelected()) {
    statusPembayaran[2] = true;
    isAnySelected = true;
}
if (apr.isSelected()) {
    statusPembayaran[3] = true;
    isAnySelected = true;
}
if (mei.isSelected()) {
    statusPembayaran[4] = true;
    isAnySelected = true;
}
if (jun.isSelected()) {
    statusPembayaran[5] = true;
    isAnySelected = true;
}
if (jul.isSelected()) {
    statusPembayaran[6] = true;
    isAnySelected = true;
}
if (agu.isSelected()) {
    statusPembayaran[7] = true;
    isAnySelected = true;
}
if (sep.isSelected()) {
    statusPembayaran[8] = true;
    isAnySelected = true;
}
if (okto.isSelected()) {
    statusPembayaran[9] = true;
    isAnySelected = true;
}
if (nov.isSelected()) {
    statusPembayaran[10] = true;
    isAnySelected = true;
}
if (des.isSelected()) {
    statusPembayaran[11] = true;
    isAnySelected = true;
}

// Cek apakah ada bulan yang dipilih
if (isAnySelected) {
    JOptionPane.showMessageDialog(this, "Pembayaran berhasil!");
} else {
    JOptionPane.showMessageDialog(this, "Harap pilih setidaknya satu bulan untuk melanjutkan pembayaran.", "Peringatan", JOptionPane.WARNING_MESSAGE);
}
     

    }//GEN-LAST:event_btnbayarActionPerformed

    private void btnhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhitungActionPerformed
        // TODO add your handling code here:
        int sppPerBulan = Integer.parseInt(sppbulanan.getText());
        int totalPembayaran = 0;

        if (jan.isSelected() && !statusPembayaran[0]) {
            totalPembayaran += sppPerBulan;
        }
        if (feb.isSelected() && !statusPembayaran[1]) {
            totalPembayaran += sppPerBulan;
        }
        if (mar.isSelected() && !statusPembayaran[2]) {
            totalPembayaran += sppPerBulan;
        }
        if (apr.isSelected() && !statusPembayaran[3]) {
            totalPembayaran += sppPerBulan;
        }
        if (mei.isSelected() && !statusPembayaran[4]) {
            totalPembayaran += sppPerBulan;
        }
        if (jun.isSelected() && !statusPembayaran[5]) {
            totalPembayaran += sppPerBulan;
        }
        if (jul.isSelected() && !statusPembayaran[6]) {
            totalPembayaran += sppPerBulan;
        }
        if (agu.isSelected() && !statusPembayaran[7]) {
            totalPembayaran += sppPerBulan;
        }
        if (sep.isSelected() && !statusPembayaran[8]) {
            totalPembayaran += sppPerBulan;
        }
        if (okto.isSelected() && !statusPembayaran[9]) {
            totalPembayaran += sppPerBulan;
        }
        if (nov.isSelected() && !statusPembayaran[10]) {
            totalPembayaran += sppPerBulan;
        }
        if (des.isSelected() && !statusPembayaran[11]) {
            totalPembayaran += sppPerBulan;
        }

        total.setText(String.valueOf(totalPembayaran));
        total.setEditable(false);
    }//GEN-LAST:event_btnhitungActionPerformed

    private void btncekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekActionPerformed
//       String Nama = nama.getText();
//        String Alamat = alamat.getText();
        // TODO add your handling code here:
//        new cek(statusPembayaran).setVisible(true);
        statusPembayaran[0] = jan.isSelected();  // contoh jika ada checkbox Januari
        statusPembayaran[1] = feb.isSelected(); // contoh jika ada checkbox Februari
        statusPembayaran[2] = mar.isSelected();
        statusPembayaran[3] = apr.isSelected();
        statusPembayaran[4] = mei.isSelected();
        statusPembayaran[5] = jun.isSelected();
        statusPembayaran[6] = jul.isSelected();
        statusPembayaran[7] = agu.isSelected();
        statusPembayaran[8] = sep.isSelected();
        statusPembayaran[9] = okto.isSelected();
        statusPembayaran[10] = nov.isSelected();
        statusPembayaran[11] = des.isSelected();

        cek Cek = new cek(statusPembayaran);
        Cek.setVisible(true);
        this.dispose(); // Tutup JFrame1 jika diinginkan
    }//GEN-LAST:event_btncekActionPerformed

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
            java.util.logging.Logger.getLogger(spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new spp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox agu;
    private javax.swing.JCheckBox apr;
    private javax.swing.JButton btnbayar;
    private javax.swing.JButton btncek;
    private javax.swing.JButton btnhitung;
    private javax.swing.JPanel button;
    private javax.swing.JCheckBox des;
    private javax.swing.JCheckBox feb;
    private javax.swing.JPanel heading;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JCheckBox jan;
    private javax.swing.JCheckBox jul;
    private javax.swing.JCheckBox jun;
    private javax.swing.JCheckBox mar;
    private javax.swing.JCheckBox mei;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel nama;
    private javax.swing.JTextField namasiswa;
    private javax.swing.JCheckBox nov;
    private javax.swing.JCheckBox okto;
    private javax.swing.JCheckBox sep;
    private javax.swing.JTextField sppbulanan;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
