/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tugas2praktikum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author HP
 */
public class Bakery extends javax.swing.JFrame {
    private int total = 0; // variabel total global

    public Bakery() {
        initComponents();
         tfJumlah.setText("0");
         
        tfCash.getDocument().addDocumentListener(new DocumentListener() {
            public void removeUpdate(DocumentEvent e) {
                hitungKembalian();
            }
            public void insertUpdate(DocumentEvent e) {
                hitungKembalian();
            }

            public void changedUpdate(DocumentEvent e) {
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

        btntopping = new javax.swing.ButtonGroup();
        btnmenu = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        rbMuffin = new javax.swing.JRadioButton();
        rbDonat = new javax.swing.JRadioButton();
        rbCroissant = new javax.swing.JRadioButton();
        rbBagel = new javax.swing.JRadioButton();
        rbCromboloni = new javax.swing.JRadioButton();
        rbBaguette = new javax.swing.JRadioButton();
        rbCiabatta = new javax.swing.JRadioButton();
        rbLoaf = new javax.swing.JRadioButton();
        tfCash = new javax.swing.JTextField();
        tfKembalian = new javax.swing.JTextField();
        lbCash = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        lbKembali = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        lbTopping = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        tfJumlah = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnHitung = new javax.swing.JButton();
        btnKurang = new javax.swing.JButton();
        rbCK = new javax.swing.JRadioButton();
        rbKeju = new javax.swing.JRadioButton();
        rbCoklat = new javax.swing.JRadioButton();
        rbNoTopping = new javax.swing.JRadioButton();
        rbStrawberry = new javax.swing.JRadioButton();
        rbMatcha = new javax.swing.JRadioButton();
        Muffin = new javax.swing.JLabel();
        Donat = new javax.swing.JLabel();
        Bagel = new javax.swing.JLabel();
        Loaf = new javax.swing.JLabel();
        Cromboloni = new javax.swing.JLabel();
        Croissant = new javax.swing.JLabel();
        Ciabatta = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tfTotalDiskon = new javax.swing.JTextField();
        TotalDiskon = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(250, 199, 148));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnmenu.add(rbMuffin);
        rbMuffin.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rbMuffin.setForeground(new java.awt.Color(255, 255, 255));
        rbMuffin.setText("Rp 12.000");
        jPanel4.add(rbMuffin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 90, 30));

        btnmenu.add(rbDonat);
        rbDonat.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rbDonat.setForeground(new java.awt.Color(255, 255, 255));
        rbDonat.setText("Rp. 10.000");
        jPanel4.add(rbDonat, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, -1, 30));

        btnmenu.add(rbCroissant);
        rbCroissant.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rbCroissant.setForeground(new java.awt.Color(255, 255, 255));
        rbCroissant.setText("Rp 15.000");
        rbCroissant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCroissantActionPerformed(evt);
            }
        });
        jPanel4.add(rbCroissant, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 80, 30));

        btnmenu.add(rbBagel);
        rbBagel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rbBagel.setForeground(new java.awt.Color(255, 255, 255));
        rbBagel.setText("Rp 20.000");
        rbBagel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBagelActionPerformed(evt);
            }
        });
        jPanel4.add(rbBagel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, -1, 30));

        btnmenu.add(rbCromboloni);
        rbCromboloni.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rbCromboloni.setForeground(new java.awt.Color(255, 255, 255));
        rbCromboloni.setText("Rp 15.000");
        jPanel4.add(rbCromboloni, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, -1, 30));

        btnmenu.add(rbBaguette);
        rbBaguette.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rbBaguette.setForeground(new java.awt.Color(255, 255, 255));
        rbBaguette.setText("Rp 30.000");
        jPanel4.add(rbBaguette, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, -1, 30));

        btnmenu.add(rbCiabatta);
        rbCiabatta.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rbCiabatta.setForeground(new java.awt.Color(255, 255, 255));
        rbCiabatta.setText("Rp 25.000");
        jPanel4.add(rbCiabatta, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, -1, 30));

        btnmenu.add(rbLoaf);
        rbLoaf.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rbLoaf.setForeground(new java.awt.Color(255, 255, 255));
        rbLoaf.setText("Rp 25.000");
        rbLoaf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLoafActionPerformed(evt);
            }
        });
        jPanel4.add(rbLoaf, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, -1, 30));

        tfCash.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        tfCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCashActionPerformed(evt);
            }
        });
        jPanel4.add(tfCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 70, 20));

        tfKembalian.setEditable(false);
        tfKembalian.setBackground(new java.awt.Color(255, 255, 255));
        tfKembalian.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        tfKembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKembalianActionPerformed(evt);
            }
        });
        jPanel4.add(tfKembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 80, -1));

        lbCash.setText("Cash");
        jPanel4.add(lbCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 50, -1));

        tfTotal.setEditable(false);
        tfTotal.setBackground(new java.awt.Color(255, 255, 255));
        tfTotal.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jPanel4.add(tfTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 130, 20));

        lbKembali.setText("Kembalian");
        jPanel4.add(lbKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 70, -1));

        lbTotal.setText("Harga Diskon");
        jPanel4.add(lbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 80, -1));

        lbTopping.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbTopping.setText("TOPPING");
        jPanel4.add(lbTopping, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 60, 20));

        btnTambah.setBackground(new java.awt.Color(204, 204, 204));
        btnTambah.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnTambah.setText("+");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel4.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 90, -1));

        tfJumlah.setEditable(false);
        tfJumlah.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.add(tfJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 40, -1));

        btnReset.setBackground(new java.awt.Color(204, 204, 204));
        btnReset.setFont(new java.awt.Font("Times New Roman", 1, 8)); // NOI18N
        btnReset.setText("Reset");
        btnReset.setMargin(new java.awt.Insets(2, 0, 3, 0));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel4.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 50, 20));

        btnHitung.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });
        jPanel4.add(btnHitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 80, 50));

        btnKurang.setBackground(new java.awt.Color(204, 204, 204));
        btnKurang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKurang.setText("-");
        btnKurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKurangActionPerformed(evt);
            }
        });
        jPanel4.add(btnKurang, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 80, -1));

        btntopping.add(rbCK);
        rbCK.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        rbCK.setText("Coklat & Keju - Rp 5.000");
        rbCK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCKActionPerformed(evt);
            }
        });
        jPanel4.add(rbCK, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 150, -1));

        btntopping.add(rbKeju);
        rbKeju.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        rbKeju.setText("Keju - Rp 3.000");
        jPanel4.add(rbKeju, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, 20));

        btntopping.add(rbCoklat);
        rbCoklat.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        rbCoklat.setText("Coklat Rp 3.000");
        rbCoklat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCoklatActionPerformed(evt);
            }
        });
        jPanel4.add(rbCoklat, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        btntopping.add(rbNoTopping);
        rbNoTopping.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        rbNoTopping.setText("No Topping - Rp 0");
        jPanel4.add(rbNoTopping, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, -1));

        btntopping.add(rbStrawberry);
        rbStrawberry.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        rbStrawberry.setText("Strawberry Rp 3.000");
        rbStrawberry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbStrawberryActionPerformed(evt);
            }
        });
        jPanel4.add(rbStrawberry, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 120, -1));

        btntopping.add(rbMatcha);
        rbMatcha.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        rbMatcha.setText(" Matcha Rp 5.000");
        rbMatcha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMatchaActionPerformed(evt);
            }
        });
        jPanel4.add(rbMatcha, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        Muffin.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Muffin.setForeground(new java.awt.Color(255, 255, 255));
        Muffin.setText("Muffin");
        jPanel4.add(Muffin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, 30));

        Donat.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Donat.setForeground(new java.awt.Color(255, 255, 255));
        Donat.setText("Donat");
        jPanel4.add(Donat, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, -1, 30));

        Bagel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Bagel.setForeground(new java.awt.Color(255, 255, 255));
        Bagel.setText("Bagel");
        jPanel4.add(Bagel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 376, -1, 30));

        Loaf.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Loaf.setForeground(new java.awt.Color(255, 255, 255));
        Loaf.setText("Roti Loaf");
        jPanel4.add(Loaf, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, -1, 30));

        Cromboloni.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Cromboloni.setForeground(new java.awt.Color(255, 255, 255));
        Cromboloni.setText("Cromboloni");
        jPanel4.add(Cromboloni, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, 30));

        Croissant.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Croissant.setForeground(new java.awt.Color(255, 255, 255));
        Croissant.setText("Croissant");
        jPanel4.add(Croissant, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, 30));

        Ciabatta.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Ciabatta.setForeground(new java.awt.Color(255, 255, 255));
        Ciabatta.setText("Ciabatta");
        jPanel4.add(Ciabatta, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, -1, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Baguette");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, -1, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tugas2praktikum/List Topping.png"))); // NOI18N
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 300, -1));

        tfTotalDiskon.setEditable(false);
        tfTotalDiskon.setBackground(new java.awt.Color(255, 255, 255));
        tfTotalDiskon.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        tfTotalDiskon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTotalDiskonActionPerformed(evt);
            }
        });
        jPanel4.add(tfTotalDiskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 130, 20));

        TotalDiskon.setText("Total");
        jPanel4.add(TotalDiskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 60, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tugas2praktikum/komputer.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tugas2praktikum/Papan kayu.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 200, 610, 40));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tugas2praktikum/pantry 1.png"))); // NOI18N
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 300, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tugas2praktikum/pantry 2.png"))); // NOI18N
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 310, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel1.setText("Jl. Ketapang Besar 36 A");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 140, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("The Bread Basket: Crust & Crumb");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbCKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCKActionPerformed

    private void rbMatchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMatchaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbMatchaActionPerformed

    private void rbStrawberryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbStrawberryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbStrawberryActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
                int jumlah = Integer.parseInt(tfJumlah.getText());
                jumlah++; // Menambah jumlah pesanan
                tfJumlah.setText(String.valueOf(jumlah));
           
    }//GEN-LAST:event_btnTambahActionPerformed

    private void tfCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCashActionPerformed
   
    }//GEN-LAST:event_tfCashActionPerformed
private void hitungKembalian() {
    try {
        int total = Integer.parseInt(tfTotal.getText());
    
        int uangPembeli = Integer.parseInt(tfCash.getText());

        int kembalian = uangPembeli - total;

        if (kembalian < 0) {
            tfKembalian.setText("Uang kurang");
        } else {
            tfKembalian.setText(String.valueOf(kembalian));
        }
    } catch (NumberFormatException e) {
        tfKembalian.setText("");
    }
}

    private void tfKembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKembalianActionPerformed

    }//GEN-LAST:event_tfKembalianActionPerformed

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        if(!rbMuffin.isSelected() && !rbDonat.isSelected() && !rbCromboloni.isSelected() && !rbCroissant.isSelected()
           && !rbCiabatta.isSelected() && !rbBagel.isSelected() && !rbBaguette.isSelected() && !rbLoaf.isSelected()
                && !rbCK.isSelected() && !rbCoklat.isSelected() && !rbKeju.isSelected() && !rbStrawberry.isSelected() 
                && !rbMatcha.isSelected() && !rbNoTopping.isSelected()){
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Menu & Topping Terlebih Dahulu");
        }else if(!rbCK.isSelected() && !rbCoklat.isSelected() && !rbKeju.isSelected() && !rbStrawberry.isSelected() 
                && !rbMatcha.isSelected() && !rbNoTopping.isSelected()){
                    JOptionPane.showMessageDialog(null, "Silahkan Pilih Menu & Topping Terlebih Dahulu");
        }else{   
            total = 0;
            int jumlah = Integer.parseInt(tfJumlah.getText()); // Ambil nilai jumlah
            
            if (rbMuffin.isSelected()) total+= 12000;
                else if (rbDonat.isSelected()) total += 10000;
                else if (rbCromboloni.isSelected()) total += 15000;
                else if (rbCroissant.isSelected()) total += 15000;
                else if (rbCiabatta.isSelected()) total += 25000;
                else if (rbBagel.isSelected()) total += 20000;
                else if (rbBaguette.isSelected()) total += 30000;
                else if (rbLoaf.isSelected()) total += 25000;

            if (rbCK.isSelected()) total+= 5000;
                else if (rbCoklat.isSelected()) total += 3000;
                else if (rbKeju.isSelected()) total += 3000;
                else if (rbStrawberry.isSelected()) total += 3000;
                else if (rbMatcha.isSelected()) total += 5000;
                else if (rbNoTopping.isSelected()) total += 0;
            //diskon
            total *= jumlah;
            tfTotal.setText(String.valueOf(total));
            
            if (total > 100000) {
                    total *= 0.95;
                }
            tfTotalDiskon.setText( String.valueOf(total));
                }
            
        
    }//GEN-LAST:event_btnHitungActionPerformed

    
    private void rbCoklatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCoklatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCoklatActionPerformed

    private void rbLoafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLoafActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbLoafActionPerformed

    private void rbCroissantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCroissantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCroissantActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
                tfKembalian.setText("");
                tfTotal.setText("");
                tfJumlah.setText("0");
                tfCash.setText("");
                btnmenu.clearSelection();
                btntopping.clearSelection();
                tfTotalDiskon.setText("");
               
    }//GEN-LAST:event_btnResetActionPerformed

    private void rbBagelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBagelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbBagelActionPerformed

    private void btnKurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKurangActionPerformed
                int jumlah = Integer.parseInt(tfJumlah.getText());
                if (jumlah > 0) { // Minimal pesanan adalah 1
                    jumlah--; // Mengurangi jumlah pesanan
                }
                tfJumlah.setText(String.valueOf(jumlah));
            
    }//GEN-LAST:event_btnKurangActionPerformed

    private void tfTotalDiskonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTotalDiskonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTotalDiskonActionPerformed

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
            java.util.logging.Logger.getLogger(Bakery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bakery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bakery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bakery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bakery().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bagel;
    private javax.swing.JLabel Ciabatta;
    private javax.swing.JLabel Croissant;
    private javax.swing.JLabel Cromboloni;
    private javax.swing.JLabel Donat;
    private javax.swing.JLabel Loaf;
    private javax.swing.JLabel Muffin;
    private javax.swing.JLabel TotalDiskon;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnKurang;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.ButtonGroup btnmenu;
    private javax.swing.ButtonGroup btntopping;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbCash;
    private javax.swing.JLabel lbKembali;
    private javax.swing.JLabel lbTopping;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JRadioButton rbBagel;
    private javax.swing.JRadioButton rbBaguette;
    private javax.swing.JRadioButton rbCK;
    private javax.swing.JRadioButton rbCiabatta;
    private javax.swing.JRadioButton rbCoklat;
    private javax.swing.JRadioButton rbCroissant;
    private javax.swing.JRadioButton rbCromboloni;
    private javax.swing.JRadioButton rbDonat;
    private javax.swing.JRadioButton rbKeju;
    private javax.swing.JRadioButton rbLoaf;
    private javax.swing.JRadioButton rbMatcha;
    private javax.swing.JRadioButton rbMuffin;
    private javax.swing.JRadioButton rbNoTopping;
    private javax.swing.JRadioButton rbStrawberry;
    private javax.swing.JTextField tfCash;
    private javax.swing.JTextField tfJumlah;
    private javax.swing.JTextField tfKembalian;
    private javax.swing.JTextField tfTotal;
    private javax.swing.JTextField tfTotalDiskon;
    // End of variables declaration//GEN-END:variables
}