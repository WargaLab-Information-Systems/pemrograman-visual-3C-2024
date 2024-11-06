package gametebakangka;

import java.util.Random;
import javax.swing.JOptionPane;

public class TebakAngka extends javax.swing.JFrame {
    int kesempatan = 10;
    int maxrandom = 100;
    String[][] data_score = new String[10][2];
    int index = 0;
    Random angka1 = new Random();
    int tebak = angka1.nextInt(maxrandom) + 1;
    
    public TebakAngka() {
        initComponents();
        this.setLocationRelativeTo(null);
        jawaban.setEditable(false);
        score.setEditable(false);
        System.out.println(tebak);
//        resetGame();
    }
    
    private void resetGame() {
        kesempatan = 10;
        tebak = angka1.nextInt(maxrandom) + 1; 
        go.setText("Tebak (" + kesempatan + ")");
        tebakan.setText(""); // Reset input tebakan untuk input baru
        jawaban.setText(""); // Kosongkan jawaban
        score.setText("0"); // Reset skor display
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        Game = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        Keluar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        score = new javax.swing.JTextField();
        tebakan = new javax.swing.JTextField();
        jawaban = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        go = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        Score = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        Keluar1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scoreList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Game.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(165, 148, 249));
        jPanel1.setPreferredSize(new java.awt.Dimension(415, 40));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("GOOD LUCK AND HAVE FUN-!");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 200, -1));

        Keluar.setText("Out");
        Keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeluarActionPerformed(evt);
            }
        });
        jPanel1.add(Keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 50, -1));

        Game.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBackground(new java.awt.Color(229, 217, 242));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Small", 3, 24)); // NOI18N
        jLabel1.setText("TEBAK ANGKA");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 40, 190, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gametebakangka/game2.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gametebakangka/game.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 90, -1));

        jLabel4.setFont(new java.awt.Font("Spline Sans Mono", 1, 12)); // NOI18N
        jLabel4.setText("Score      :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 20));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel5.setText("==============================================");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 420, 20));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel6.setText("==============================================");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 81, 420, 20));

        jLabel7.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel7.setText("NB : Angka tebakan harus diantara 1 - 100");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        score.setText("0");
        score.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreActionPerformed(evt);
            }
        });
        jPanel2.add(score, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 180, -1));

        tebakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tebakanActionPerformed(evt);
            }
        });
        jPanel2.add(tebakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 180, -1));

        jawaban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jawabanActionPerformed(evt);
            }
        });
        jPanel2.add(jawaban, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 180, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gametebakangka/ghost.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 130, 180));

        jLabel12.setFont(new java.awt.Font("Spline Sans Mono", 1, 12)); // NOI18N
        jLabel12.setText("Coba Tebak :");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 20));

        jLabel13.setFont(new java.awt.Font("Spline Sans Mono", 1, 12)); // NOI18N
        jLabel13.setText("Jawaban    :");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 20));

        go.setText("Go! (10)");
        go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goActionPerformed(evt);
            }
        });
        jPanel2.add(go, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel2.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        Game.add(jPanel2, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab("Game", Game);

        Score.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(165, 148, 249));
        jPanel3.setPreferredSize(new java.awt.Dimension(420, 40));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("CONGRATULATIONS-!");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 160, -1));

        Keluar1.setText("Out");
        Keluar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Keluar1ActionPerformed(evt);
            }
        });
        jPanel3.add(Keluar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 50, -1));

        Score.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel4.setBackground(new java.awt.Color(229, 217, 242));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Sitka Small", 3, 24)); // NOI18N
        jLabel8.setText("SCORE LIST");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 150, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gametebakangka/game2.png"))); // NOI18N
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, 40));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gametebakangka/game.png"))); // NOI18N
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 90, -1));

        jLabel15.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel15.setText("==============================================");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 81, 420, 20));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gametebakangka/ghost.png"))); // NOI18N
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 140, 180));

        jScrollPane1.setViewportView(scoreList);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 240, 160));

        Score.add(jPanel4, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab("Score", Score);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scoreActionPerformed

    private void tebakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tebakanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tebakanActionPerformed

    private void jawabanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jawabanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jawabanActionPerformed

    private void goActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goActionPerformed
        try {
            int angka2 = Integer.parseInt(tebakan.getText());

            // Memastikan angka tebakan dalam rentang 1 hingga 100
            if (angka2 < 1 || angka2 > maxrandom) {
                JOptionPane.showMessageDialog(this, "TEBAKAN HARUS BERADA DI ANTARA 1 DAN " + maxrandom);
                return; // Keluar dari metode jika tebakan tidak valid
            }

            if (tebak > angka2) {
                kesempatan--;
                jawaban.setText("Angka Tebakan Lebih Besar");
            } else if (tebak < angka2) {
                kesempatan--;
                jawaban.setText("Angka Tebakan Lebih Kecil");
            } else {
                int hasil = kesempatan * 10;
                jawaban.setText("GOTCHA! Angka Tebakan : " + tebak);
                score.setText(String.valueOf(hasil));
                JOptionPane.showMessageDialog(this, "SELAMAT TEBAKAN ANDA BENAR");

                String nama = JOptionPane.showInputDialog(this, "SILAKAN MASUKAN NAMA");
                while (nama == null || nama.isEmpty()){
                    JOptionPane.showMessageDialog(null, "NAMA TIDAK BOLEH KOSONG!", 
                            "Kesalahan", JOptionPane.WARNING_MESSAGE);
                    nama = JOptionPane.showInputDialog(null, "SILAKAN MASUKAN NAMA");
                }
                if (index < data_score.length) {
                    data_score[index][0] = nama;
                    data_score[index][1] = String.valueOf(hasil);
                    index++; // Increment index setelah data ditambahkan
                    
                    // Update JList setelah data ditambahkan
                    updateScoreList();
                }

                // Jaga agar kesempatan tetap 10 dan menghasilkan angka tebakan baru
                tebak = angka1.nextInt(maxrandom) + 1; // Menghasilkan angka tebakan baru
            }

            go.setText("Tebak (" + kesempatan + ")");
            if (kesempatan == 0) {
                JOptionPane.showMessageDialog(this, "KESEMPATAN ANDA HABIS! Angka yang benar adalah: " + tebak);
                resetGame(); // Reset permainan jika kesempatan habis
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "TEBAKAN HARUS BERUPA ANGKA");
        }
    }//GEN-LAST:event_goActionPerformed
    
    private void updateScoreList() {
        String[] scores = new String[index]; // Membuat array baru untuk skor
        for (int i = 0; i < index; i++) {
            scores[i] = "Nama: " + data_score[i][0] + ", Score: " + data_score[i][1];
        }
        scoreList.setListData(scores); // Set data untuk JList
    }
    
    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        resetGame();
    }//GEN-LAST:event_resetActionPerformed

    private void KeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeluarActionPerformed
        int exit = JOptionPane.showConfirmDialog(null,"Keluar permainan?","Keluar",JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_KeluarActionPerformed

    private void Keluar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Keluar1ActionPerformed
        int exit = JOptionPane.showConfirmDialog(null,"Keluar permainan?","Keluar",JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_Keluar1ActionPerformed

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
            java.util.logging.Logger.getLogger(TebakAngka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TebakAngka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TebakAngka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TebakAngka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TebakAngka().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Game;
    private javax.swing.JButton Keluar;
    private javax.swing.JButton Keluar1;
    private javax.swing.JPanel Score;
    private javax.swing.JButton go;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jawaban;
    private javax.swing.JButton reset;
    private javax.swing.JTextField score;
    private javax.swing.JList<String> scoreList;
    private javax.swing.JTextField tebakan;
    // End of variables declaration//GEN-END:variables

}
