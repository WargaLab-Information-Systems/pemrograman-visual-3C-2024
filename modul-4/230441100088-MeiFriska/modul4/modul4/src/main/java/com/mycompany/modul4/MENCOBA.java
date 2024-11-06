
package com.mycompany.modul4;

import javax.swing.JOptionPane;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;


public class MENCOBA extends javax.swing.JFrame {
Random Angka = new Random();
int target = Angka.nextInt(100)+1;
String Target = Integer.toString(target);
private int score = 100;
private List<String> history = new ArrayList<>(); // List untuk menyimpan data skor pemain



    public MENCOBA() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        
    
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hasil = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        scoremain = new javax.swing.JTextField();
        angka = new javax.swing.JTextField();
        main = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        p = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txascore = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 235, 212));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 235, 212));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 198, 198));

        jLabel1.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 24)); // NOI18N
        jLabel1.setText("Number Quest");
        jPanel4.add(jLabel1);

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 50));

        jPanel5.setBackground(new java.awt.Color(255, 235, 212));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 198, 198));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 18)); // NOI18N
        jLabel2.setText("AYO MAIN !!");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 130, 40));

        jLabel3.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        jLabel3.setText("Ayo Masukan Angka");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 160, 40));

        jLabel4.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        jLabel4.setText("Tebakan");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 160, 40));

        hasil.setEditable(false);
        hasil.setBackground(new java.awt.Color(255, 235, 212));
        jPanel6.add(hasil, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 220, -1));

        jLabel5.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        jLabel5.setText("Score");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 115, 160, 30));

        scoremain.setEditable(false);
        scoremain.setBackground(new java.awt.Color(255, 235, 212));
        scoremain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoremainActionPerformed(evt);
            }
        });
        jPanel6.add(scoremain, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 220, -1));

        angka.setBackground(new java.awt.Color(255, 235, 212));
        jPanel6.add(angka, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 220, -1));

        main.setBackground(new java.awt.Color(255, 235, 212));
        main.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        main.setText("main");
        main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainActionPerformed(evt);
            }
        });
        jPanel6.add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        reset.setBackground(new java.awt.Color(255, 235, 212));
        reset.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        reset.setText("reset game");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel6.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        keluar.setBackground(new java.awt.Color(255, 235, 212));
        keluar.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12)); // NOI18N
        keluar.setText("keluar game");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        jPanel6.add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Downloads\\aamong_Us_Holding_Flower-removebg-preview.png")); // NOI18N
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 180, -1, 160));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Downloads\\Among_Us_Holding_Balloon-removebg-preview.png")); // NOI18N
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 110, 120));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Downloads\\among_Us_Holding_Heart___TopPNG-removebg-preview.png")); // NOI18N
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 130, 110));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Downloads\\among_Us_Wearing_Halloween_Witch_Hat___TopPNG__1_-removebg-preview.png")); // NOI18N
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 130, 130));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 420, 370));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 520, 460));

        jTabbedPane1.addTab("AYO MAIN !!", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 235, 212));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 198, 198));

        p.setFont(new java.awt.Font("Matura MT Script Capitals", 1, 24)); // NOI18N
        p.setText("SCORE");
        jPanel7.add(p);

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 53));

        jPanel8.setBackground(new java.awt.Color(255, 235, 212));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 198, 198));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txascore.setEditable(false);
        txascore.setColumns(20);
        txascore.setRows(5);
        jScrollPane1.setViewportView(txascore);

        jPanel9.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 420, 190));

        jLabel6.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        jLabel6.setText("DATA PEROLEHAN SCORE");
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 170, 30));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 480, 270));

        jButton1.setBackground(new java.awt.Color(255, 198, 198));
        jButton1.setText("KELUAR GAME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Downloads\\aamong_Us_Holding_Flower-removebg-preview.png")); // NOI18N
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, 120));

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Downloads\\Among_Us_Holding_Balloon-removebg-preview.png")); // NOI18N
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 120, 130));

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Downloads\\among_Us_Wearing_Halloween_Witch_Hat___TopPNG__1_-removebg-preview.png")); // NOI18N
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, 120));

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Downloads\\among_Us_Holding_Heart___TopPNG-removebg-preview.png")); // NOI18N
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 120, 110));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 49, 520, 460));

        jTabbedPane1.addTab("SCORE MAIN", jPanel3);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scoremainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoremainActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scoremainActionPerformed

    private void mainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainActionPerformed
        System.out.println(target);
        try {
            int tebakan = Integer.parseInt(angka.getText());

            if (tebakan < target) {
                hasil.setText("Aku Lebih Besar dari " + tebakan);
                score -= 10;
                System.out.println("Integer.toString: " + Target);

            } else if (tebakan > target) {
                hasil.setText("Aku Lebih Kecil dari " + tebakan);
                score -= 10;
//                System.out.println("Integer.toString: " + Target);
 
            } else {
                hasil.setText("Tebakan Benar! Angka " + tebakan);
                JOptionPane.showMessageDialog(this, "WAHHH BENER !");

                String playerName = JOptionPane.showInputDialog("SIAPA NAMA KAMU!:");
                while (playerName == null || playerName.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "SIAPKAN NAMA KAMU!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    playerName = JOptionPane.showInputDialog("NAMANYA SIAPA:");
                }
                String result = playerName + " = Score: " + score;
                history.add(result);
                
                txascore.setText(""); // Kosongkan area teks sebelum mengisi ulang
                for (String entry : history) {
                    txascore.append(entry + "\n");
                }
                
                target = Angka.nextInt(100) + 1; 
                score = 100;
                angka.setText("");
                main.setText("main (10)");
                hasil.setText("");
                scoremain.setText(String.valueOf(score)); 
//                System.out.println("Integer.toString: " + Target);

                
            }
            scoremain.setText(String.valueOf(score));
            int tebak = score / 10;
            main.setText("Main (" + tebak + ")");
            
            if (score <= 0) {
                hasil.setText("Game Over! Coba lagi.");
                JOptionPane.showMessageDialog(null, "KAMU GAGAL WLEE!! AYO ULANG", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                target = Angka.nextInt(100) + 1; 
                score = 100;
                angka.setText("");
                main.setText("main (10)");
                hasil.setText("");
                scoremain.setText(String.valueOf(score));    
             }
            } catch (NumberFormatException ex) {
                hasil.setText("ANGKA BANGG!");
        }
    }//GEN-LAST:event_mainActionPerformed
  
    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
    int keluar = JOptionPane.showConfirmDialog(null,"beneran mau keluar?","Keluar",JOptionPane.YES_NO_OPTION);
        if (keluar == JOptionPane.YES_OPTION) {
            System.exit(0);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_keluarActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        target = Angka.nextInt(100) + 1; 
        score = 100;
        angka.setText("");
        main.setText("main (10)");
        hasil.setText("");
        scoremain.setText(String.valueOf(score));         
    }//GEN-LAST:event_resetActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    int keluar = JOptionPane.showConfirmDialog(null,"beneran mau keluar?","Keluar",JOptionPane.YES_NO_OPTION);
        if (keluar == JOptionPane.YES_OPTION) {
            System.exit(0);
        }    
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MENCOBA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField angka;
    private javax.swing.JTextField hasil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton keluar;
    private javax.swing.JButton main;
    private javax.swing.JLabel p;
    private javax.swing.JButton reset;
    private javax.swing.JTextField scoremain;
    private javax.swing.JTextArea txascore;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativveTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
