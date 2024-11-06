import javax.swing.JOptionPane;
import java.util.Random;
import javax.swing.DefaultListModel;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author user
 */
public class Frame1 extends javax.swing.JFrame {
    private int target; 
    private int kesempatan = 10; 
    DefaultListModel<String> historyModel = new DefaultListModel<>();
    /**
     * Creates new form Frame1
     */
    public Frame1() {
        initComponents();
        resetGame(); 
        jList1.setModel(historyModel);
    }
    
    private void resetGame() {
        target = new Random().nextInt(100) + 1;
        kesempatan = 10;
        input.setText("");
        cek.setText("");
        skor.setText("-"); 
        tebak.setText("PLAY (10)"); 
    }
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        input = new javax.swing.JTextField();
        skor = new javax.swing.JTextField();
        cek = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        tebak = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(127, 161, 195));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Masukan Angka Anda !!!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 230, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("GUESS HERE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CHECK HERE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 113, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("YOUR SCORE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 159, -1, -1));
        jPanel1.add(input, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 67, 317, -1));

        skor.setEditable(false);
        jPanel1.add(skor, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 156, 317, -1));

        cek.setEditable(false);
        jPanel1.add(cek, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 110, 317, -1));

        jPanel3.setLayout(new java.awt.GridLayout(2, 0));

        tebak.setBackground(new java.awt.Color(117, 134, 148));
        tebak.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        tebak.setForeground(new java.awt.Color(255, 255, 255));
        tebak.setText("PLAY");
        tebak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tebakActionPerformed(evt);
            }
        });
        jPanel3.add(tebak);

        reset.setBackground(new java.awt.Color(117, 134, 148));
        reset.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel3.add(reset);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 212, 524, 110));

        jTabbedPane1.addTab("Permainan", jPanel1);

        jPanel2.setBackground(new java.awt.Color(127, 161, 195));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Yu Gothic Medium", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("HAsil Score");
        jPanel2.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        jList1.setBackground(new java.awt.Color(96, 102, 118));
        jList1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Score", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed

        resetGame(); 
    }//GEN-LAST:event_resetActionPerformed

    private void tebakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tebakActionPerformed
     try {
            int tebakan = Integer.parseInt(input.getText());


            if (tebakan > target) {
                System.out.println(target);
                cek.setText("Angka terlalu besar!");
                int score = kesempatan * 10 ;
                skor.setText(String.valueOf(score));
            } else if (tebakan < target) { 
                cek.setText("Angka terlalu kecil");
                int score = kesempatan * 10 - 10;
                skor.setText(String.valueOf(score));
            } else {
                cek.setText("HEBAT, KAMU BERHASIL!");
                int score = kesempatan * 10;
                skor.setText(String.valueOf(score)); 
//                JOptionPane.showMessageDialog(this, "Anda berhasil menebak!");
                JOptionPane.showMessageDialog(this," selamat anda benar");
                String nama = JOptionPane.showInputDialog("Put Your Name Here !");
                // Tambahkan ke history list di Tab 2
                historyModel.addElement(nama + " - Score: " + score);


                return; 
    }

    // Kurangi kesempatan jika tebakan salah
    kesempatan--;
    tebak.setText("PLAY (" + kesempatan + ")"); 

 
    if (kesempatan == 0 && tebakan != target) {
        cek.setText("YOU LOSE!");
        JOptionPane.showMessageDialog(this, "You Lose!!! Try It Again!!.");
        resetGame(); // Reset 
    }

} catch (NumberFormatException e) {
    cek.setText("ANDA SALAH, ISI DENGAN NOMOR!!"); 
}

    }//GEN-LAST:event_tebakActionPerformed

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
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cek;
    private javax.swing.JTextField input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton reset;
    private javax.swing.JTextField skor;
    private javax.swing.JButton tebak;
    // End of variables declaration//GEN-END:variables
}
