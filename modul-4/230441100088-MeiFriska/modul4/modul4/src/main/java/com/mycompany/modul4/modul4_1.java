
package com.mycompany.modul4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;


public class modul4_1 extends javax.swing.JFrame {

  
    public modul4_1() {
        initComponents();
       this.setLocationRelativeTo(null);
        resetGame();
        
        reset.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            resetGame(); 
        }
        });
        
        main.addActionListener(new ActionListener() {
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
        angka.setText("");
        main.setText("main (10)");
        hasil.setText("");
        score2.setText(String.valueOf(score));      
}
   private void playGame() {
        try {
            int tebakan = Integer.parseInt(angka.getText());
            if (tebakan < 1 || tebakan > 100) {
                hasil.setText("Masukkan angka 1 - 100");
                return;
            }
            
            if (tebakan < target) {
                hasil.setText("Aku Lebih Besar dari " + tebakan);
                score -= 10;
            } else if (tebakan > target) {
                hasil.setText("Aku Lebih Kecil dari " + tebakan);
                score -= 10;
            } else {
                hasil.setText("Tebakan Benar! Angka " + tebakan);
                JOptionPane.showMessageDialog(this, "WAHHH BENER !");

                String playerName = JOptionPane.showInputDialog("SIAPA NAMA KAMU!:");
                while (playerName == null || playerName.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "SIAPKAN NAMA KAMU!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    playerName = JOptionPane.showInputDialog("NAMANYA SIAPA:");
                }

                txascore.append(playerName + " = Score: " + score + "\n");
                angka.setEditable(false); 
            }
            
            score2.setText(String.valueOf(score));
            int tebak = score / 10;
            main.setText("Main (" + tebak + ")");
            
            if (score <= 0) {
                hasil.setText("Game Over! Coba lagi.");
               JOptionPane.showMessageDialog(null, "KAMU GAGAL WLEE!! AYO ULANG", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                resetGame();
            }
        } catch (NumberFormatException ex) {
            hasil.setText("ANGKA BANGG!");
        }
        
        
    }  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        main = new javax.swing.JButton();
        angka = new javax.swing.JTextField();
        hasil = new javax.swing.JTextField();
        score2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txascore = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField4.setText("jTextField4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 235, 212));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 235, 212));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 198, 198));

        jLabel2.setFont(new java.awt.Font("Matura MT Script Capitals", 1, 24)); // NOI18N
        jLabel2.setText("Number Quest");
        jPanel5.add(jLabel2);

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, -1));

        jPanel8.setBackground(new java.awt.Color(255, 235, 212));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 198, 198));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        jLabel5.setText("Masukan Angka");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 120, 40));

        jLabel6.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        jLabel6.setText("Hasil Jawapan");
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, 40));

        jLabel7.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        jLabel7.setText("Score");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 100, 20));

        reset.setBackground(new java.awt.Color(255, 235, 212));
        reset.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        reset.setText("Reset");
        jPanel9.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        keluar.setBackground(new java.awt.Color(255, 235, 212));
        keluar.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        keluar.setText("keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        jPanel9.add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, -1, -1));

        main.setBackground(new java.awt.Color(255, 235, 212));
        main.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        main.setText("main");
        main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainActionPerformed(evt);
            }
        });
        jPanel9.add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, -1, -1));

        angka.setBackground(new java.awt.Color(255, 235, 212));
        jPanel9.add(angka, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 190, -1));

        hasil.setEditable(false);
        hasil.setBackground(new java.awt.Color(255, 235, 212));
        jPanel9.add(hasil, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 190, -1));

        score2.setEditable(false);
        score2.setBackground(new java.awt.Color(255, 235, 212));
        jPanel9.add(score2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 190, -1));

        jLabel8.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 18)); // NOI18N
        jLabel8.setText("AYO MAIN !!");
        jPanel9.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 150, 30));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 380, 380));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 480, 460));

        jTabbedPane1.addTab("ayo main", jPanel3);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 198, 198));

        jLabel1.setFont(new java.awt.Font("Matura MT Script Capitals", 1, 24)); // NOI18N
        jLabel1.setText("SCORE");
        jPanel4.add(jLabel1);

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, -1));

        jPanel7.setBackground(new java.awt.Color(255, 235, 212));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 198, 198));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txascore.setEditable(false);
        txascore.setColumns(20);
        txascore.setRows(5);
        jScrollPane1.setViewportView(txascore);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 380, 190));

        jPanel7.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 420, 230));

        jButton4.setBackground(new java.awt.Color(255, 198, 198));
        jButton4.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        jButton4.setText("Kembali");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, -1, -1));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 480, 460));

        jTabbedPane1.addTab("scor main", jPanel2);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 530));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainActionPerformed
       
    }//GEN-LAST:event_mainActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
    int keluar = JOptionPane.showConfirmDialog(null,"beneran mau keluar?","Keluar",JOptionPane.YES_NO_OPTION);
        if (keluar == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_keluarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    int keluar = JOptionPane.showConfirmDialog(null,"benera mau keluar?","Keluar",JOptionPane.YES_NO_OPTION);
        if (keluar == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modul4_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField angka;
    private javax.swing.JTextField hasil;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton keluar;
    private javax.swing.JButton main;
    private javax.swing.JButton reset;
    private javax.swing.JTextField score2;
    private javax.swing.JTextArea txascore;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativveTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
 
