package pkg230441100099.qurrotulaini;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class TokoRotiAI extends javax.swing.JFrame {

    public TokoRotiAI() {
        initComponents();
        this.setLocationRelativeTo(null);
        harga.setEditable(false);
        kembalian.setEditable(false);
        diskon.setEditable(false);
        total.setEditable(false);
        
        cash.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                penghitungan();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roti = new javax.swing.ButtonGroup();
        topping = new javax.swing.ButtonGroup();
        header = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        JLabelMenu = new javax.swing.JLabel();
        RCoklat = new javax.swing.JRadioButton();
        RAbonSapi = new javax.swing.JRadioButton();
        RKelapa = new javax.swing.JRadioButton();
        RKismis = new javax.swing.JRadioButton();
        RKeju = new javax.swing.JRadioButton();
        RPisangKeju = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JLabelTopping = new javax.swing.JLabel();
        JRBNoTopping = new javax.swing.JRadioButton();
        JRBKacang = new javax.swing.JRadioButton();
        JRBMeses = new javax.swing.JRadioButton();
        reset = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        JLabelJumlah = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        kurang = new javax.swing.JButton();
        JLabelCash = new javax.swing.JLabel();
        cash = new javax.swing.JTextField();
        hitung = new javax.swing.JButton();
        JLabelHarga = new javax.swing.JLabel();
        JLabelKembalian = new javax.swing.JLabel();
        kembalian = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        tambah = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        diskon = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(181, 162, 154));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Book Antiqua", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("AI Bakery");
        header.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 170, 40));

        jLabel14.setIcon(new javax.swing.ImageIcon("D:\\PEMVISSS\\Logo.png")); // NOI18N
        header.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 90, 80));

        jLabel15.setIcon(new javax.swing.ImageIcon("D:\\PEMVISSS\\Logo2.png")); // NOI18N
        header.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, -1));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 80));

        body.setBackground(new java.awt.Color(212, 200, 184));
        body.setMinimumSize(new java.awt.Dimension(60, 450));
        body.setPreferredSize(new java.awt.Dimension(60, 450));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(241, 210, 179));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLabelMenu.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        JLabelMenu.setText("Menu Roti");
        jPanel1.add(JLabelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, 20));

        roti.add(RCoklat);
        RCoklat.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        RCoklat.setText("Roti Coklat -> Rp. 8.500");
        jPanel1.add(RCoklat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        roti.add(RAbonSapi);
        RAbonSapi.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        RAbonSapi.setText("Roti Abon Sapi -> Rp. 10.500");
        jPanel1.add(RAbonSapi, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, -1, -1));

        roti.add(RKelapa);
        RKelapa.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        RKelapa.setText("Roti Kelapa -> Rp. 8.500");
        RKelapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RKelapaActionPerformed(evt);
            }
        });
        jPanel1.add(RKelapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, 20));

        roti.add(RKismis);
        RKismis.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        RKismis.setText("Roti Kismis -> Rp. 8.500");
        RKismis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RKismisActionPerformed(evt);
            }
        });
        jPanel1.add(RKismis, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, 20));

        roti.add(RKeju);
        RKeju.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        RKeju.setText("Roti Keju -> Rp. 9.500");
        RKeju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RKejuActionPerformed(evt);
            }
        });
        jPanel1.add(RKeju, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        roti.add(RPisangKeju);
        RPisangKeju.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        RPisangKeju.setText("Roti Pisang Keju -> Rp. 9.500");
        jPanel1.add(RPisangKeju, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("D:\\PEMVISSS\\RotiCoklat.jpg")); // NOI18N
        jLabel4.setMaximumSize(new java.awt.Dimension(90, 63));
        jLabel4.setMinimumSize(new java.awt.Dimension(90, 63));
        jLabel4.setPreferredSize(new java.awt.Dimension(95, 63));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("D:\\PEMVISSS\\RotiKelapa.jpg")); // NOI18N
        jLabel5.setMaximumSize(new java.awt.Dimension(95, 63));
        jLabel5.setMinimumSize(new java.awt.Dimension(95, 63));
        jLabel5.setPreferredSize(new java.awt.Dimension(95, 63));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon("D:\\PEMVISSS\\RotiKismis.jpg")); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\PEMVISSS\\RotiKeju.jpg")); // NOI18N
        jLabel8.setMaximumSize(new java.awt.Dimension(95, 63));
        jLabel8.setMinimumSize(new java.awt.Dimension(95, 63));
        jLabel8.setPreferredSize(new java.awt.Dimension(95, 63));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon("D:\\PEMVISSS\\RotiPisangKeju.jpg")); // NOI18N
        jLabel7.setMaximumSize(new java.awt.Dimension(95, 63));
        jLabel7.setMinimumSize(new java.awt.Dimension(95, 63));
        jLabel7.setPreferredSize(new java.awt.Dimension(95, 63));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon("D:\\PEMVISSS\\RotiAbonSapi.jpg")); // NOI18N
        jLabel9.setMinimumSize(new java.awt.Dimension(95, 63));
        jLabel9.setPreferredSize(new java.awt.Dimension(95, 65));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, -1, -1));

        body.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 580, 270));

        jPanel2.setBackground(new java.awt.Color(241, 210, 179));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLabelTopping.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        JLabelTopping.setText("Topping");
        jPanel2.add(JLabelTopping, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        topping.add(JRBNoTopping);
        JRBNoTopping.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        JRBNoTopping.setText("No Topping -> Rp. 0");
        JRBNoTopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBNoToppingActionPerformed(evt);
            }
        });
        jPanel2.add(JRBNoTopping, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        topping.add(JRBKacang);
        JRBKacang.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        JRBKacang.setText("Kacang       -> Rp. 3.000");
        jPanel2.add(JRBKacang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        topping.add(JRBMeses);
        JRBMeses.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        JRBMeses.setText("Meses        -> Rp. 2.000");
        jPanel2.add(JRBMeses, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        body.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 170, 140));

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        body.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, -1, -1));

        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        body.add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, -1, -1));

        jPanel4.setBackground(new java.awt.Color(214, 197, 165));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLabelJumlah.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        JLabelJumlah.setText("Jumlah");
        jPanel4.add(JLabelJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jumlah.setText("0");
        jPanel4.add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 50, -1));

        kurang.setText("-");
        kurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kurangActionPerformed(evt);
            }
        });
        jPanel4.add(kurang, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        JLabelCash.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        JLabelCash.setText("Cash :");
        jPanel4.add(JLabelCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, 20));
        jPanel4.add(cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 150, -1));

        hitung.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        hitung.setText("HITUNG");
        hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungActionPerformed(evt);
            }
        });
        jPanel4.add(hitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 90, 60));

        JLabelHarga.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        JLabelHarga.setText("Harga :");
        jPanel4.add(JLabelHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 20));

        JLabelKembalian.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        JLabelKembalian.setText("Kembalian :");
        jPanel4.add(JLabelKembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, 20));
        jPanel4.add(kembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 150, -1));

        harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaActionPerformed(evt);
            }
        });
        jPanel4.add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 150, -1));

        tambah.setText("+");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        jPanel4.add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel3.setText("Diskon :");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));
        jPanel4.add(diskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 150, -1));

        jLabel10.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel10.setText("Total :");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, 20));
        jPanel4.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 150, -1));

        body.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 390, 260));

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 620, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void penghitungan() {
        try {
            double hargasetelahdiskon = Double.parseDouble(total.getText());
            double uangmasuk = Double.parseDouble(cash.getText());
            double Kembalian = uangmasuk - hargasetelahdiskon;

            if (Kembalian >= 0) {
                kembalian.setText(String.valueOf(Kembalian));
            } else {
                kembalian.setText("Uang Tidak Cukup");
            }
        } catch (NumberFormatException e) {
            kembalian.setText("Input Tidak Sesuai");
        }
    }
    private void RKejuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RKejuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RKejuActionPerformed

    private void RKismisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RKismisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RKismisActionPerformed

    private void RKelapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RKelapaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RKelapaActionPerformed

    private void JRBNoToppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBNoToppingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JRBNoToppingActionPerformed

    private void kurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kurangActionPerformed
        int Jumlah = Integer.parseInt(jumlah.getText());
        if(Jumlah <= 0){
            JOptionPane.showMessageDialog(null, "jumlah tidak boleh kurang dari 0");
        }
        else{
            Jumlah--;
        }
        
        jumlah.setText(String.valueOf(Jumlah));
    }//GEN-LAST:event_kurangActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        int Jumlah = Integer.parseInt(jumlah.getText());
        Jumlah++;
        
        jumlah.setText(String.valueOf(Jumlah));
    }//GEN-LAST:event_tambahActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        roti.clearSelection();
        topping.clearSelection();
        jumlah.setText("0");
        cash.setText("");
        harga.setText("");
        diskon.setText("");
        total.setText("");
        kembalian.setText("");
    }//GEN-LAST:event_resetActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        int exit = JOptionPane.showConfirmDialog(null,"Akhiri Pesanan?","Keluar",JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_keluarActionPerformed

    private void hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungActionPerformed
        if (roti.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Anda harus memilih menu terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else if (topping.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Anda harus memilih topping terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else if (Integer.parseInt(jumlah.getText()) <= 0) { 
            JOptionPane.showMessageDialog(null, "Jumlah pembelian harus lebih dari 0!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
        
        else{
            double Harga = 0;
            double Diskon = 0;
            double Cash = 0;
            double Kembalian = 0;
            
            if (RCoklat.isSelected()){
                String jumlahpesanan = jumlah.getText();
                Harga += 8500 * Integer.parseInt(jumlahpesanan);
                if (JRBNoTopping.isSelected()){
                    Harga += 0 * Integer.parseInt(jumlahpesanan);
                } else if (JRBKacang.isSelected()){
                    Harga += 3000 * Integer.parseInt(jumlahpesanan);
                } else {
                    Harga += 2000 * Integer.parseInt(jumlahpesanan);
                }
                harga.setText(String.valueOf(Harga));
                    if (Harga >= 100000) {
                        Diskon = Harga * 0.05;
                        diskon.setText(String.valueOf(Diskon));
                        Harga -= Diskon;
                        total.setText(String.valueOf(Harga));
                    } else {
                        diskon.setText("0");
                        total.setText(String.valueOf(Harga));
                    }
            }
            
           if (RKelapa.isSelected()){
                String jumlahpesanan = jumlah.getText();
                Harga += 8500 * Integer.parseInt(jumlahpesanan);
                if (JRBNoTopping.isSelected()){
                    Harga += 0 * Integer.parseInt(jumlahpesanan);
                } else if (JRBKacang.isSelected()){
                    Harga += 3000 * Integer.parseInt(jumlahpesanan);
                } else {
                    Harga += 2000 * Integer.parseInt(jumlahpesanan);
                }
                harga.setText(String.valueOf(Harga));
                    if (Harga >= 100000) {
                        Diskon = Harga * 0.05;
                        diskon.setText(String.valueOf(Diskon));
                        Harga -= Diskon;
                        total.setText(String.valueOf(Harga));
                    } else {
                        diskon.setText("0");
                        total.setText(String.valueOf(Harga));
                    }
            }
           
           if (RKismis.isSelected()){
                String jumlahpesanan = jumlah.getText();
                Harga += 8500 * Integer.parseInt(jumlahpesanan);
                if (JRBNoTopping.isSelected()){
                    Harga += 0 * Integer.parseInt(jumlahpesanan);
                } else if (JRBKacang.isSelected()){
                    Harga += 3000 * Integer.parseInt(jumlahpesanan);
                } else {
                    Harga += 2000 * Integer.parseInt(jumlahpesanan);
                }
                harga.setText(String.valueOf(Harga));
                    if (Harga >= 100000) {
                        Diskon = Harga * 0.05;
                        diskon.setText(String.valueOf(Diskon));
                        Harga -= Diskon;
                        total.setText(String.valueOf(Harga));
                    } else {
                        diskon.setText("0");
                        total.setText(String.valueOf(Harga));
                    }
            }
           
           if (RKeju.isSelected()){
                String jumlahpesanan = jumlah.getText();
                Harga += 9500 * Integer.parseInt(jumlahpesanan);
                if (JRBNoTopping.isSelected()){
                    Harga += 0 * Integer.parseInt(jumlahpesanan);
                } else if (JRBKacang.isSelected()){
                    Harga += 3000 * Integer.parseInt(jumlahpesanan);
                } else {
                    Harga += 2000 * Integer.parseInt(jumlahpesanan);
                }
                harga.setText(String.valueOf(Harga));
                    if (Harga >= 100000) {
                        Diskon = Harga * 0.05;
                        diskon.setText(String.valueOf(Diskon));
                        Harga -= Diskon;
                        total.setText(String.valueOf(Harga));
                    } else {
                        diskon.setText("0");
                        total.setText(String.valueOf(Harga));
                    }
            }
           
           if (RPisangKeju.isSelected()){
                String jumlahpesanan = jumlah.getText();
                Harga += 9500 * Integer.parseInt(jumlahpesanan);
                if (JRBNoTopping.isSelected()){
                    Harga += 0 * Integer.parseInt(jumlahpesanan);
                } else if (JRBKacang.isSelected()){
                    Harga += 3000 * Integer.parseInt(jumlahpesanan);
                } else {
                    Harga += 2000 * Integer.parseInt(jumlahpesanan);
                }
                harga.setText(String.valueOf(Harga));
                    if (Harga >= 100000) {
                        Diskon = Harga * 0.05;
                        diskon.setText(String.valueOf(Diskon));
                        Harga -= Diskon;
                        total.setText(String.valueOf(Harga));
                    } else {
                        diskon.setText("0");
                        total.setText(String.valueOf(Harga));
                    }
            }
           
           if (RAbonSapi.isSelected()){
                String jumlahpesanan = jumlah.getText();
                Harga += 10500 * Integer.parseInt(jumlahpesanan);
                if (JRBNoTopping.isSelected()){
                    Harga += 0 * Integer.parseInt(jumlahpesanan);
                } else if (JRBKacang.isSelected()){
                    Harga += 3000 * Integer.parseInt(jumlahpesanan);
                } else {
                    Harga += 2000 * Integer.parseInt(jumlahpesanan);
                }
                harga.setText(String.valueOf(Harga));
                    if (Harga >= 100000) {
                        Diskon = Harga * 0.05;
                        diskon.setText(String.valueOf(Diskon));
                        Harga -= Diskon;
                        total.setText(String.valueOf(Harga));
                    } else {
                        diskon.setText("0");
                        total.setText(String.valueOf(Harga));
                    }
            }
            
        }
    }//GEN-LAST:event_hitungActionPerformed

    private void hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaActionPerformed

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
            java.util.logging.Logger.getLogger(TokoRotiAI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TokoRotiAI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TokoRotiAI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TokoRotiAI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TokoRotiAI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelCash;
    private javax.swing.JLabel JLabelHarga;
    private javax.swing.JLabel JLabelJumlah;
    private javax.swing.JLabel JLabelKembalian;
    private javax.swing.JLabel JLabelMenu;
    private javax.swing.JLabel JLabelTopping;
    private javax.swing.JRadioButton JRBKacang;
    private javax.swing.JRadioButton JRBMeses;
    private javax.swing.JRadioButton JRBNoTopping;
    private javax.swing.JRadioButton RAbonSapi;
    private javax.swing.JRadioButton RCoklat;
    private javax.swing.JRadioButton RKeju;
    private javax.swing.JRadioButton RKelapa;
    private javax.swing.JRadioButton RKismis;
    private javax.swing.JRadioButton RPisangKeju;
    private javax.swing.JPanel body;
    private javax.swing.JTextField cash;
    private javax.swing.JTextField diskon;
    private javax.swing.JTextField harga;
    private javax.swing.JPanel header;
    private javax.swing.JButton hitung;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jumlah;
    private javax.swing.JButton keluar;
    private javax.swing.JTextField kembalian;
    private javax.swing.JButton kurang;
    private javax.swing.JButton reset;
    private javax.swing.ButtonGroup roti;
    private javax.swing.JButton tambah;
    private javax.swing.ButtonGroup topping;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
