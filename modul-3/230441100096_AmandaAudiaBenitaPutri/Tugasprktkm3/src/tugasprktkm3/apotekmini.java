/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tugasprktkm3;

import javax.swing.JOptionPane;

public class apotekmini extends javax.swing.JFrame {
    
    public apotekmini() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        cbgejala = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        rbAmbroxol = new javax.swing.JRadioButton();
        rbAmlodipine = new javax.swing.JRadioButton();
        rbDextro = new javax.swing.JRadioButton();
        rbOralit = new javax.swing.JRadioButton();
        rbIbuprofen = new javax.swing.JRadioButton();
        rbBisoprolol = new javax.swing.JRadioButton();
        rbOseltamivir = new javax.swing.JRadioButton();
        rbCaptropil = new javax.swing.JRadioButton();
        rbParacetamol = new javax.swing.JRadioButton();
        rbLoperamide = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfhasil = new javax.swing.JTextField();
        btnkeluar = new javax.swing.JButton();
        btnprint = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\pmcy-removebg-preview (1).png")); // NOI18N
        jPanel1.add(jLabel6);

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bloom Pharmacy ");
        jPanel1.add(jLabel1);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\logo-removebg-preview (1).png")); // NOI18N
        jPanel1.add(jLabel4);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 100));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 3, 14)); // NOI18N
        jLabel2.setText("NAMA :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 60, -1));

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 3, 14)); // NOI18N
        jLabel3.setText("GEJALA :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 50, 70, -1));

        txtnama.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jPanel3.add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 240, -1));

        cbgejala.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        cbgejala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "== PILIH ==", "Demam", "Hipertensi", "Diare", "Flu", "Batuk" }));
        cbgejala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbgejalaActionPerformed(evt);
            }
        });
        jPanel3.add(cbgejala, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 240, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 740, 90));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new java.awt.GridLayout(2, 5));

        rbAmbroxol.setBackground(new java.awt.Color(0, 102, 102));
        rbAmbroxol.setFont(new java.awt.Font("Baskerville Old Face", 3, 14)); // NOI18N
        rbAmbroxol.setForeground(new java.awt.Color(255, 255, 255));
        rbAmbroxol.setText("Ambroxol");
        rbAmbroxol.setToolTipText("");
        rbAmbroxol.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        rbAmbroxol.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\Ambroxol.png")); // NOI18N
        rbAmbroxol.setOpaque(true);
        rbAmbroxol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAmbroxolActionPerformed(evt);
            }
        });
        jPanel2.add(rbAmbroxol);

        rbAmlodipine.setBackground(new java.awt.Color(0, 102, 102));
        rbAmlodipine.setFont(new java.awt.Font("Baskerville Old Face", 3, 14)); // NOI18N
        rbAmlodipine.setForeground(new java.awt.Color(255, 255, 255));
        rbAmlodipine.setText("Amlodipine");
        rbAmlodipine.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\amlodipine.jpg")); // NOI18N
        rbAmlodipine.setOpaque(true);
        rbAmlodipine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAmlodipineActionPerformed(evt);
            }
        });
        jPanel2.add(rbAmlodipine);

        rbDextro.setBackground(new java.awt.Color(0, 102, 102));
        rbDextro.setFont(new java.awt.Font("Baskerville Old Face", 3, 12)); // NOI18N
        rbDextro.setForeground(new java.awt.Color(255, 255, 255));
        rbDextro.setText("Dextromethorphan");
        rbDextro.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\dextrometrhorphan.jpg")); // NOI18N
        rbDextro.setOpaque(true);
        rbDextro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDextroActionPerformed(evt);
            }
        });
        jPanel2.add(rbDextro);

        rbOralit.setBackground(new java.awt.Color(0, 102, 102));
        rbOralit.setFont(new java.awt.Font("Baskerville Old Face", 3, 14)); // NOI18N
        rbOralit.setForeground(new java.awt.Color(255, 255, 255));
        rbOralit.setText("Oralit");
        rbOralit.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\Oralit.jpg")); // NOI18N
        rbOralit.setOpaque(true);
        rbOralit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbOralitActionPerformed(evt);
            }
        });
        jPanel2.add(rbOralit);

        rbIbuprofen.setBackground(new java.awt.Color(0, 102, 102));
        rbIbuprofen.setFont(new java.awt.Font("Baskerville Old Face", 3, 14)); // NOI18N
        rbIbuprofen.setForeground(new java.awt.Color(255, 255, 255));
        rbIbuprofen.setText("Ibuprofen");
        rbIbuprofen.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\Ibuprofen.jpg")); // NOI18N
        rbIbuprofen.setOpaque(true);
        rbIbuprofen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbIbuprofenActionPerformed(evt);
            }
        });
        jPanel2.add(rbIbuprofen);

        rbBisoprolol.setBackground(new java.awt.Color(0, 102, 102));
        rbBisoprolol.setFont(new java.awt.Font("Baskerville Old Face", 3, 14)); // NOI18N
        rbBisoprolol.setForeground(new java.awt.Color(255, 255, 255));
        rbBisoprolol.setText("Bisoprolol");
        rbBisoprolol.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\Bisoprolol.png")); // NOI18N
        rbBisoprolol.setOpaque(true);
        rbBisoprolol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBisoprololActionPerformed(evt);
            }
        });
        jPanel2.add(rbBisoprolol);

        rbOseltamivir.setBackground(new java.awt.Color(0, 102, 102));
        rbOseltamivir.setFont(new java.awt.Font("Baskerville Old Face", 3, 14)); // NOI18N
        rbOseltamivir.setForeground(new java.awt.Color(255, 255, 255));
        rbOseltamivir.setText("Oseltamivir");
        rbOseltamivir.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\Oseltamivir.jpg")); // NOI18N
        rbOseltamivir.setOpaque(true);
        rbOseltamivir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbOseltamivirActionPerformed(evt);
            }
        });
        jPanel2.add(rbOseltamivir);

        rbCaptropil.setBackground(new java.awt.Color(0, 102, 102));
        rbCaptropil.setFont(new java.awt.Font("Baskerville Old Face", 3, 14)); // NOI18N
        rbCaptropil.setForeground(new java.awt.Color(255, 255, 255));
        rbCaptropil.setText("Captropil");
        rbCaptropil.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\Captopril.png")); // NOI18N
        rbCaptropil.setOpaque(true);
        rbCaptropil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCaptropilActionPerformed(evt);
            }
        });
        jPanel2.add(rbCaptropil);

        rbParacetamol.setBackground(new java.awt.Color(0, 102, 102));
        rbParacetamol.setFont(new java.awt.Font("Baskerville Old Face", 3, 14)); // NOI18N
        rbParacetamol.setForeground(new java.awt.Color(255, 255, 255));
        rbParacetamol.setText("Paracetamol");
        rbParacetamol.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\Parasetamol.png")); // NOI18N
        rbParacetamol.setOpaque(true);
        rbParacetamol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbParacetamolActionPerformed(evt);
            }
        });
        jPanel2.add(rbParacetamol);

        rbLoperamide.setBackground(new java.awt.Color(0, 102, 102));
        rbLoperamide.setFont(new java.awt.Font("Baskerville Old Face", 3, 15)); // NOI18N
        rbLoperamide.setForeground(new java.awt.Color(255, 255, 255));
        rbLoperamide.setText("Loperamide");
        rbLoperamide.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\Curcuma.png")); // NOI18N
        rbLoperamide.setOpaque(true);
        rbLoperamide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLoperamideActionPerformed(evt);
            }
        });
        jPanel2.add(rbLoperamide);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 740, 260));

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 3, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("BILL");
        jPanel4.add(jLabel5, java.awt.BorderLayout.PAGE_START);
        jPanel4.add(tfhasil, java.awt.BorderLayout.CENTER);

        btnkeluar.setBackground(new java.awt.Color(255, 204, 204));
        btnkeluar.setFont(new java.awt.Font("Baskerville Old Face", 3, 14)); // NOI18N
        btnkeluar.setText("KELUAR");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });
        jPanel4.add(btnkeluar, java.awt.BorderLayout.PAGE_END);

        btnprint.setBackground(new java.awt.Color(255, 204, 204));
        btnprint.setFont(new java.awt.Font("Baskerville Old Face", 3, 14)); // NOI18N
        btnprint.setText("PRINT");
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });
        jPanel4.add(btnprint, java.awt.BorderLayout.LINE_END);

        btnclear.setBackground(new java.awt.Color(255, 204, 204));
        btnclear.setFont(new java.awt.Font("Baskerville Old Face", 3, 14)); // NOI18N
        btnclear.setText("CLEAR");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        jPanel4.add(btnclear, java.awt.BorderLayout.LINE_START);

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 740, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbAmbroxolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAmbroxolActionPerformed
        String Gejala =  String.valueOf(apotekmini.cbgejala.getSelectedItem());
    if (rbAmbroxol.isSelected()){
        if(Gejala.equals("== PILIH ==")){
        JOptionPane.showMessageDialog(this,"HARAP PILIH GEJALA SEBELUM MELANJUTKAN","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else if(!Gejala.equals("Batuk")){
        JOptionPane.showMessageDialog(this,"INI BUKAN OBAT UNTUK GEJALA TERSEBUT","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        rbAmbroxol.setSelected(false);
        }else{
            JOptionPane.showMessageDialog(this,"Ambroxol adalah obat untuk mengencerkan dahak, Ambroxol sirup 15mg/60ml. Harga = Rp. 15.000/Botol","AMBROXOL", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    }//GEN-LAST:event_rbAmbroxolActionPerformed

    private void rbAmlodipineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAmlodipineActionPerformed
         String Gejala =  String.valueOf(apotekmini.cbgejala.getSelectedItem());
    if (rbAmlodipine.isSelected()){
        if(Gejala.equals("== PILIH ==")){
        JOptionPane.showMessageDialog(this,"HARAP PILIH GEJALA SEBELUM MELANJUTKAN","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else if(!Gejala.equals("Hipertensi")){
        JOptionPane.showMessageDialog(this,"INI BUKAN OBAT UNTUK GEJALA TERSEBUT","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        rbAmlodipine.setSelected(false);
        }else{
            JOptionPane.showMessageDialog(this,"Amlodipine digunakan untuk mengobati hipertensi, Amlodipine 10 mg. Harga = Rp. 30.000/Strip(10 Tablets)","AMLODIPINE", JOptionPane.INFORMATION_MESSAGE);
        }
    }  
    }//GEN-LAST:event_rbAmlodipineActionPerformed

    private void rbDextroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDextroActionPerformed
         String Gejala =  String.valueOf(apotekmini.cbgejala.getSelectedItem());
    if (rbDextro.isSelected()){
        if(Gejala.equals("== PILIH ==")){
        JOptionPane.showMessageDialog(this,"HARAP PILIH GEJALA SEBELUM MELANJUTKAN","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else if(!Gejala.equals("Batuk")){
        JOptionPane.showMessageDialog(this,"INI BUKAN OBAT UNTUK GEJALA TERSEBUT","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        rbDextro.setSelected(false);
        }else{
            JOptionPane.showMessageDialog(this,"Dextromethorphan digunakan untuk meredakan batuk jangka pendek, Dextromethorphan sirup 60 ml. Harga = Rp. 16.000/Botol","DEXTROMETHORPHAN", JOptionPane.INFORMATION_MESSAGE);
        }
    }       
    }//GEN-LAST:event_rbDextroActionPerformed

    private void rbOralitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbOralitActionPerformed
         String Gejala =  String.valueOf(apotekmini.cbgejala.getSelectedItem());
    if (rbOralit.isSelected()){
        if(Gejala.equals("== PILIH ==")){
        JOptionPane.showMessageDialog(this,"HARAP PILIH GEJALA SEBELUM MELANJUTKAN","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else if(!Gejala.equals("Diare")){
        JOptionPane.showMessageDialog(this,"INI BUKAN OBAT UNTUK GEJALA TERSEBUT","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        rbOralit.setSelected(false);
        }else{
            JOptionPane.showMessageDialog(this,"Oralit digunakan untuk mencegah dan mengobati kurang cairan (dehidrasi) akibat diare dan muntah, Oralit 1g . Harga = Rp. 5.000/Sachet","ORALIT", JOptionPane.INFORMATION_MESSAGE);
        }
    }       
    }//GEN-LAST:event_rbOralitActionPerformed

    private void rbIbuprofenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbIbuprofenActionPerformed
         String Gejala =  String.valueOf(apotekmini.cbgejala.getSelectedItem());
    if (rbIbuprofen.isSelected()){
        if(Gejala.equals("== PILIH ==")){
        JOptionPane.showMessageDialog(this,"HARAP PILIH GEJALA SEBELUM MELANJUTKAN","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else if(!Gejala.equals("Demam")){
        JOptionPane.showMessageDialog(this,"INI BUKAN OBAT UNTUK GEJALA TERSEBUT","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        rbIbuprofen.setSelected(false);
        }else{
            JOptionPane.showMessageDialog(this,"Ibuprofen obat untuk meredakan nyeri dan peradangan, Ibuprofen capsule 200mg . Harga = Rp. 110.000/tabung(30 capsule)","IBUPROFEN", JOptionPane.INFORMATION_MESSAGE);
        }
    }    
    }//GEN-LAST:event_rbIbuprofenActionPerformed

    private void rbBisoprololActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBisoprololActionPerformed
         String Gejala =  String.valueOf(apotekmini.cbgejala.getSelectedItem());
    if (rbBisoprolol.isSelected()){
        if(Gejala.equals("== PILIH ==")){
        JOptionPane.showMessageDialog(this,"HARAP PILIH GEJALA SEBELUM MELANJUTKAN","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else if(!Gejala.equals("Hipertensi")){
        JOptionPane.showMessageDialog(this,"INI BUKAN OBAT UNTUK GEJALA TERSEBUT","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        rbBisoprolol.setSelected(false);
        }else{
            JOptionPane.showMessageDialog(this,"Bisoprolol untuk mengobati tekanan darah tinggi, Bisoprolol sirup 60ml . Harga = Rp. 15.000/Botol","BISOPROLOL", JOptionPane.INFORMATION_MESSAGE);
        }
    }    
    }//GEN-LAST:event_rbBisoprololActionPerformed

    private void rbOseltamivirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbOseltamivirActionPerformed
         String Gejala =  String.valueOf(apotekmini.cbgejala.getSelectedItem());
    if (rbOseltamivir.isSelected()){
        if(Gejala.equals("== PILIH ==")){
        JOptionPane.showMessageDialog(this,"HARAP PILIH GEJALA SEBELUM MELANJUTKAN","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else if(!Gejala.equals("Flu")){
        JOptionPane.showMessageDialog(this,"INI BUKAN OBAT UNTUK GEJALA TERSEBUT","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        rbOseltamivir.setSelected(false);
        }else{
            JOptionPane.showMessageDialog(this,"Oseltamivir untuk mengobati flu untuk gejala influenza, Oseltamivir tablet 75mg . Harga = Rp. 215.000/strip(10 kapsul)","OSELTAMIVIR", JOptionPane.INFORMATION_MESSAGE);
        }
    }     
    }//GEN-LAST:event_rbOseltamivirActionPerformed

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
       System.exit(0);
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void rbCaptropilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCaptropilActionPerformed
          String Gejala =  String.valueOf(apotekmini.cbgejala.getSelectedItem());
    if (rbCaptropil.isSelected()){
        if(Gejala.equals("== PILIH ==")){
        JOptionPane.showMessageDialog(this,"HARAP PILIH GEJALA SEBELUM MELANJUTKAN","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else if(!Gejala.equals("Hipertensi")){
        JOptionPane.showMessageDialog(this,"INI BUKAN OBAT UNTUK GEJALA TERSEBUT","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        rbOralit.setSelected(false);
        }else{
            JOptionPane.showMessageDialog(this,"Captropil adalah obat anti hipertensi, Captropil tablet 25mg . Harga = Rp. 4.000/strip(10 tablet)","OSELTAMIVIR", JOptionPane.INFORMATION_MESSAGE);
        }
    }     
    }//GEN-LAST:event_rbCaptropilActionPerformed

    private void rbParacetamolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbParacetamolActionPerformed
          String Gejala =  String.valueOf(apotekmini.cbgejala.getSelectedItem());
    if (rbParacetamol.isSelected()){
        if(Gejala.equals("== PILIH ==")){
        JOptionPane.showMessageDialog(this,"HARAP PILIH GEJALA SEBELUM MELANJUTKAN","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else if(!Gejala.equals("Demam") && !Gejala.equals("Flu")){
        JOptionPane.showMessageDialog(this,"INI BUKAN OBAT UNTUK GEJALA TERSEBUT","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        rbParacetamol.setSelected(false);
        }else{
            JOptionPane.showMessageDialog(this,"Paracetamol merupakan obat yang dapat digunakan untuk menurunkan demam, Paracetamol tablet 500mg . Harga = Rp. 5.000/strip(10 kaplet)","PARACETAMOL", JOptionPane.INFORMATION_MESSAGE);
        }
    }     
    }//GEN-LAST:event_rbParacetamolActionPerformed

    private void rbLoperamideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLoperamideActionPerformed
       String Gejala =  String.valueOf(apotekmini.cbgejala.getSelectedItem());
    if (rbLoperamide.isSelected()){
        if(Gejala.equals("== PILIH ==")){
        JOptionPane.showMessageDialog(this,"HARAP PILIH GEJALA SEBELUM MELANJUTKAN","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else if(!Gejala.equals("Diare")){
        JOptionPane.showMessageDialog(this,"INI BUKAN OBAT UNTUK GEJALA TERSEBUT","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        rbLoperamide.setSelected(false);
        }else{
            JOptionPane.showMessageDialog(this,"Loperamide Obat ini dapat digunakan untuk mengobati diare akut dan kronis., Loperamide tablet 2mg . Harga = Rp. 35.000/strip(10 kaplet)","LOPERAMIDE", JOptionPane.INFORMATION_MESSAGE);
        }
    }     
    }//GEN-LAST:event_rbLoperamideActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
    rbAmbroxol.setSelected(false);
    rbAmlodipine.setSelected(false);
    rbDextro.setSelected(false);
    rbOralit.setSelected(false);
    rbIbuprofen.setSelected(false);
    rbBisoprolol.setSelected(false);
    rbOseltamivir.setSelected(false);
    rbCaptropil.setSelected(false);
    rbParacetamol.setSelected(false);
    rbLoperamide.setSelected(false);
    txtnama.setText(null);
    cbgejala.setSelectedIndex(0);
    tfhasil.setText(null);
    }//GEN-LAST:event_btnclearActionPerformed

    private void cbgejalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbgejalaActionPerformed
    String Gejala =  String.valueOf(apotekmini.cbgejala.getSelectedItem());
        if(Gejala.equals("Demam")){
        JOptionPane.showMessageDialog(this,"Obat untuk demam adalah Ibuprofen dan Paracetamol","DISCLAIMER !!!", JOptionPane.INFORMATION_MESSAGE);
        } else if(Gejala.equals("Hipertensi")){
        JOptionPane.showMessageDialog(this,"Obat untuk hipertensi adalah Captropil, Bisoprolol, dan Amlodipine","DISCLAIMER !!!", JOptionPane.INFORMATION_MESSAGE);  
        }else if(Gejala.equals("Diare")){
        JOptionPane.showMessageDialog(this,"Obat untuk diare adalah Oralit dan Loperamide","DISCLAIMER !!!", JOptionPane.INFORMATION_MESSAGE);  
        }else if(Gejala.equals("Flu")){
        JOptionPane.showMessageDialog(this,"Obat untuk flu adalah Oseltemivir dan Paracetamol","DISCLAIMER !!!", JOptionPane.INFORMATION_MESSAGE);  
        }else if(Gejala.equals("Batuk")){
        JOptionPane.showMessageDialog(this,"Obat untuk batuk adalah Dextromethorphan dan Ambroxol","DISCLAIMER !!!", JOptionPane.INFORMATION_MESSAGE);  
        }
    }//GEN-LAST:event_cbgejalaActionPerformed

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
    double Harga = 0;
    String Obat = "";
    String Gejala = String.valueOf(apotekmini.cbgejala.getSelectedItem());
    String Nama = txtnama.getText();

    if (rbAmbroxol.isSelected()) {
        Harga += 15000;
        Obat += "Ambroxol\n";
    }
    if (rbAmlodipine.isSelected()) {
        Harga += 30000;
        Obat += "Amlodipine\n";
    }
    if (rbBisoprolol.isSelected()) {
        Harga += 15000;
        Obat += "Bisoprolol\n";
    }
    if (rbCaptropil.isSelected()) {
        Harga += 4000;
        Obat += "Captropil\n";
    }
    if (rbDextro.isSelected()) {
        Harga += 16000;
        Obat += "Dextromethorphan\n";
    }
    if (rbParacetamol.isSelected()) {
        Harga += 5000;
        Obat += "Paracetamol\n";
    }
    if (rbIbuprofen.isSelected()) {
        Harga += 110000;
        Obat += "Ibuprofen\n";
    }
    if (rbLoperamide.isSelected()) {
        Harga += 35000;
        Obat += "Loperamide\n";
    }
    if (rbOralit.isSelected()) {
        Harga += 5000;
        Obat += "Oralit\n";
    }
    if (rbOseltamivir.isSelected()) {
        Harga += 5000;
        Obat += "Oseltamivir\n";
    }
    if (Gejala.isEmpty() || Obat.isEmpty() || Nama.isEmpty()) {
        JOptionPane.showMessageDialog(this,"Anda belum mengisi form dengan benar, tolong lengkapi data terlebih dahulu","SILAHKAN MENGISI FORM !", JOptionPane.WARNING_MESSAGE);
    }
    else {tfhasil.setText("Nama = "+ txtnama.getText() +" || Gejala = "+ Gejala + " || Obat =" + Obat + " || Total Harga : Rp. " + Harga);
    }
    }//GEN-LAST:event_btnprintActionPerformed

    
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
            java.util.logging.Logger.getLogger(apotekmini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(apotekmini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(apotekmini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(apotekmini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new apotekmini().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnprint;
    private static javax.swing.JComboBox<String> cbgejala;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton rbAmbroxol;
    private javax.swing.JRadioButton rbAmlodipine;
    private javax.swing.JRadioButton rbBisoprolol;
    private javax.swing.JRadioButton rbCaptropil;
    private javax.swing.JRadioButton rbDextro;
    private javax.swing.JRadioButton rbIbuprofen;
    private javax.swing.JRadioButton rbLoperamide;
    private javax.swing.JRadioButton rbOralit;
    private javax.swing.JRadioButton rbOseltamivir;
    private javax.swing.JRadioButton rbParacetamol;
    private javax.swing.JTextField tfhasil;
    private javax.swing.JTextField txtnama;
    // End of variables declaration//GEN-END:variables
}
