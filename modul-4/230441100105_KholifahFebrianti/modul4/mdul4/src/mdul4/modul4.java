/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mdul4;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;


public class modul4 extends javax.swing.JFrame {

 
    public modul4() {
       initComponents();
       resetGame();
        
        jBreset.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mereset permainan?", "Konfirmasi Reset", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                resetGame();
            }
            resetGame(); 
        }
        });
        
        jBtebak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame();
            }
        }); 
    }
    private int target;
    private int score = 100;
    
   private void resetGame() {
   
        target = new Random().nextInt(100) + 1; 
        score = 100;
        jTscore.setText(String.valueOf(score));
        jThasil.setText("");
        jTangka.setText("");
        jTangka.setEditable(true);
        jBtebak.setText("Tebak");
}

      
   private void playGame() {
    try {
        int tebakan = Integer.parseInt(jTangka.getText());
        if (tebakan < 1 || tebakan > 100) {
            jThasil.setText("Masukkan angka 1 - 100");
            return;
        }
        
        if (tebakan < target) {
            jThasil.setText("Aku Lebih Besar dari " + tebakan);
            score -= 10;
        } else if (tebakan > target) {
            jThasil.setText("Aku Lebih Kecil dari " + tebakan);
            score -= 10;
        } else {
            jThasil.setText("Tebakan Benar! Angka " + tebakan);
            JOptionPane.showMessageDialog(null, "Anda Berhasil!");

            String playerName = JOptionPane.showInputDialog("Masukkan Nama Anda:");
            while (playerName == null || playerName.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Anda harus memasukkan nama!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                playerName = JOptionPane.showInputDialog("Masukkan Nama Anda:");
            }

            jTa.append(playerName + " - Score: " + score + "\n");
            jTangka.setEditable(false); 
        }

        // Update tampilan skor setelah pengurangan atau ketika tebakan benar
        jTscore.setText(String.valueOf(score));
        
        // Jika skor mencapai 0 atau lebih kecil, game over
        if (score <= 0) {
        jThasil.setText("Game Over! Coba lagi.");
        JOptionPane.showMessageDialog(this, "Game Over! Kesempatan bermain Anda telah habis.", "Game Over", JOptionPane.WARNING_MESSAGE);
        jTangka.setEditable(false);
    }

    } catch (NumberFormatException ex) {
        jThasil.setText("Masukkan angka yang valid!");
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLnama = new javax.swing.JLabel();
        jLhasil = new javax.swing.JLabel();
        jLscore = new javax.swing.JLabel();
        jTangka = new javax.swing.JTextField();
        jThasil = new javax.swing.JTextField();
        jTscore = new javax.swing.JTextField();
        jBexit = new javax.swing.JButton();
        jBreset = new javax.swing.JButton();
        jBtebak = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jjudul = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTa = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(51, 204, 255));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLnama.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        jLnama.setText("Masukkan Angka   ");
        jPanel4.add(jLnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 130, 20));

        jLhasil.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        jLhasil.setText("Hasil jawaban         ");
        jPanel4.add(jLhasil, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, 20));

        jLscore.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        jLscore.setText("SCORE                          ");
        jPanel4.add(jLscore, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, -1, 20));

        jTangka.setBackground(new java.awt.Color(153, 204, 255));
        jTangka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTangkaActionPerformed(evt);
            }
        });
        jPanel4.add(jTangka, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 200, 30));

        jThasil.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.add(jThasil, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 200, 30));

        jTscore.setBackground(new java.awt.Color(153, 204, 255));
        jTscore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTscoreActionPerformed(evt);
            }
        });
        jPanel4.add(jTscore, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 200, 30));

        jBexit.setBackground(new java.awt.Color(102, 204, 255));
        jBexit.setText("EXIT");
        jBexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBexitActionPerformed(evt);
            }
        });
        jPanel4.add(jBexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));

        jBreset.setBackground(new java.awt.Color(102, 204, 255));
        jBreset.setText("RESET");
        jBreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBresetActionPerformed(evt);
            }
        });
        jPanel4.add(jBreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, -1, -1));

        jBtebak.setBackground(new java.awt.Color(102, 204, 255));
        jBtebak.setText("TEBAK");
        jBtebak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtebakActionPerformed(evt);
            }
        });
        jPanel4.add(jBtebak, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER EBC\\Downloads\\1 (2).png")); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 770, 530));

        jjudul.setFont(new java.awt.Font("Stencil", 2, 18)); // NOI18N
        jjudul.setForeground(new java.awt.Color(255, 255, 255));
        jjudul.setText("Siap untuk tantangan baru?");
        jPanel4.add(jjudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 280, -1));

        jLabel3.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Number Rush");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 30, 140, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, -1));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 750, 530));

        jTabbedPane1.addTab("GAME", jPanel2);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(829, 1394, -1, -1));

        jPanel7.setBackground(new java.awt.Color(0, 153, 204));

        jLabel5.setBackground(new java.awt.Color(51, 204, 255));
        jLabel5.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SCORE");
        jPanel7.add(jLabel5);

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 770, 53));

        jPanel6.setBackground(new java.awt.Color(51, 204, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(51, 204, 255));

        jTa.setColumns(20);
        jTa.setRows(5);
        jScrollPane1.setViewportView(jTa);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 350, 250));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER EBC\\Downloads\\inii.png")); // NOI18N
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 454));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 760, 580));

        jTabbedPane1.addTab("SCORE", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 780, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTangkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTangkaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTangkaActionPerformed

    private void jTscoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTscoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTscoreActionPerformed

    private void jBresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBresetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBresetActionPerformed

    private void jBexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBexitActionPerformed
        // TODO add your handling code here:
           int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);
           if (confirm == JOptionPane.YES_OPTION) {
           System.exit(0); // Keluar dari aplikasi jika pengguna memilih "YES"
        }
    }//GEN-LAST:event_jBexitActionPerformed

    private void jBtebakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtebakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtebakActionPerformed

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
            java.util.logging.Logger.getLogger(modul4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modul4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modul4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modul4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modul4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBexit;
    private javax.swing.JButton jBreset;
    private javax.swing.JButton jBtebak;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLhasil;
    private javax.swing.JLabel jLnama;
    private javax.swing.JLabel jLscore;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTa;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTangka;
    private javax.swing.JTextField jThasil;
    private javax.swing.JTextField jTscore;
    private javax.swing.JLabel jjudul;
    // End of variables declaration//GEN-END:variables
}
