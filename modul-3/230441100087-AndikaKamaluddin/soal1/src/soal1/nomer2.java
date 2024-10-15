/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package soal1;

import javax.swing.*;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author USEr
 */
public class nomer2 extends javax.swing.JFrame {
    private JCheckBox[] bulan;
    private HashMap<String, Boolean> bulan_status = new HashMap<>();
    private int totalbayar = 0;
    private String[] bulanArray = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
    private DefaultTableModel tabel;
    
    /**
     * Creates new form nomer2
     */
    public nomer2(){
        initComponents();
        setTitle("Form Pembayaran SPP Ponpes Aji Kumar");
        buy.requestFocusInWindow();
        ta_bulan.setEditable(false);
        keluar.setEnabled(false);

        for (String nama_bulan : bulanArray){
            bulan_status.put(nama_bulan, false);
        }

        bulan = new JCheckBox[12];
        bulan[0] = januari;
        bulan[1] = februari;
        bulan[2] = maret;
        bulan[3] = april;
        bulan[4] = mei;
        bulan[5] = juni;
        bulan[6] = juli;
        bulan[7] = agustus;
        bulan[8] = september;
        bulan[9] = oktober;
        bulan[10] = november;
        bulan[11] = desember;
        
        tabel = (DefaultTableModel) tbl_riwayat.getModel();
        
        statusbulanan();  
    }

    private void hitung(){
        String nama = tf_nama.getText();
        int hargaspp;

        if(nama.isEmpty()){
            JOptionPane.showMessageDialog(this, "masukkan nama duluuu!", "hmmmm", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try{
            hargaspp = Integer.parseInt(tf_spp.getText());
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "masukkan jumlah SPP yang sesuai yaa!", "heeiii", JOptionPane.ERROR_MESSAGE);
            tf_uang.setText("");
            return;
        }

        if(tf_uang.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "masukkan uangnya yaaa!", "hmmzzz", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int uangbayar;
        try{
            uangbayar = Integer.parseInt(tf_uang.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "masukkan jumlah uang yang sesuai yaa!", "hei heii", JOptionPane.ERROR_MESSAGE);
            tf_uang.setText("");
            return;
        }

        boolean checkboxdipilih = false;
        totalbayar = 0;
        int totalbelumbayar = 0;

        for(int i = 0; i < bulan.length; i++){
            if(bulan[i].isEnabled()){
                totalbelumbayar += hargaspp;
            }
        }

        for(int i = 0; i < bulan.length; i++){
            if(bulan[i].isSelected() && bulan[i].isEnabled()){
                checkboxdipilih = true;
                totalbayar += hargaspp;
            }
        }

        if(!checkboxdipilih){
            JOptionPane.showMessageDialog(this, "pilih setidaknya minimal 1 bulan yang mau dibayar!", "infooo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(uangbayar < totalbayar){
            JOptionPane.showMessageDialog(this, "uang yang dimasukkan kurang kak! total yang harus dibayar: Rp " + totalbayar, "Error", JOptionPane.ERROR_MESSAGE);
            tf_uang.setText("");
            return;
        }

        if(uangbayar > totalbayar){
            int kembalian = uangbayar - totalbayar;
            String invoice = "Nama: " + nama +
                             "\nTotal Pembayaran: Rp " + totalbayar +
                             "\nUang Diberikan: Rp " + uangbayar +
                             "\nKembalian: Rp " + kembalian;
            JOptionPane.showMessageDialog(this, invoice, "pembayaran sukses", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "pembayaran berhasil", "pembayaran sukses", JOptionPane.INFORMATION_MESSAGE);
        }

        for(int i = 0; i < bulan.length; i++){
            if(bulan[i].isSelected() && bulan[i].isEnabled()){
                String bulanNama = bulanArray[i];
                bulan_status.put(bulanNama, true);
                
                tabel.addRow(new Object[]{nama, bulanNama, hargaspp, "Lunas"});
                
                bulan[i].setEnabled(false);
            }
        }
        statusbulanan();

        totalbelumbayar = 0;
        for(int i = 0; i < bulan.length; i++){
            if (bulan[i].isEnabled()) {
                totalbelumbayar += hargaspp;
            }
        }

        lbl_total.setText("Total Pembayaran Tersisa: Rp " + totalbelumbayar);

        if(bulan_status.values().stream().allMatch(status -> status)){
            lbl_status.setText("Status Pembayaran: Lunas");
            keluar.setEnabled(true);
            tf_uang.setEditable(false);
            buy.setEnabled(false);
        }else{
            lbl_status.setText("Status Pembayaran: Menunggak");
            keluar.setEnabled(false);
        }

        tf_spp.setEditable(false);
        tf_nama.setEditable(false);
        tf_uang.setText("");
    }

    
    private void statusbulanan(){
        StringBuilder statusBulanan = new StringBuilder();
        for(int i = 0; i < bulan.length; i++){
            String bulanNama = bulanArray[i];
            if(bulan_status.get(bulanNama)){
                statusBulanan.append(bulanNama).append(": Lunas\n");
            }else{
                statusBulanan.append(bulanNama).append(": Belum Dibayar\n");
            }
        }
        ta_bulan.setText(statusBulanan.toString());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tf_nama = new javax.swing.JTextField();
        tf_spp = new javax.swing.JTextField();
        januari = new javax.swing.JCheckBox();
        februari = new javax.swing.JCheckBox();
        maret = new javax.swing.JCheckBox();
        april = new javax.swing.JCheckBox();
        mei = new javax.swing.JCheckBox();
        juni = new javax.swing.JCheckBox();
        juli = new javax.swing.JCheckBox();
        agustus = new javax.swing.JCheckBox();
        september = new javax.swing.JCheckBox();
        oktober = new javax.swing.JCheckBox();
        november = new javax.swing.JCheckBox();
        desember = new javax.swing.JCheckBox();
        buy = new javax.swing.JButton();
        tf_uang = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_riwayat = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_status = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        keluar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_bulan = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Masukkan Uang:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Pilih Bulan:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Jumlah Spp per bulan:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Masukkan Nama Siswa:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 450, 290));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));

        tf_nama.setBackground(new java.awt.Color(204, 204, 204));

        tf_spp.setBackground(new java.awt.Color(204, 204, 204));

        januari.setFont(new java.awt.Font("Franklin Gothic Medium", 2, 12)); // NOI18N
        januari.setForeground(new java.awt.Color(255, 255, 255));
        januari.setText("Januari");

        februari.setFont(new java.awt.Font("Franklin Gothic Medium", 2, 12)); // NOI18N
        februari.setForeground(new java.awt.Color(255, 255, 255));
        februari.setText("Februari");

        maret.setFont(new java.awt.Font("Franklin Gothic Medium", 2, 12)); // NOI18N
        maret.setForeground(new java.awt.Color(255, 255, 255));
        maret.setText("Maret");

        april.setFont(new java.awt.Font("Franklin Gothic Medium", 2, 12)); // NOI18N
        april.setForeground(new java.awt.Color(255, 255, 255));
        april.setText("April");

        mei.setFont(new java.awt.Font("Franklin Gothic Medium", 2, 12)); // NOI18N
        mei.setForeground(new java.awt.Color(255, 255, 255));
        mei.setText("Mei");

        juni.setFont(new java.awt.Font("Franklin Gothic Medium", 2, 12)); // NOI18N
        juni.setForeground(new java.awt.Color(255, 255, 255));
        juni.setText("Juni");

        juli.setFont(new java.awt.Font("Franklin Gothic Medium", 2, 12)); // NOI18N
        juli.setForeground(new java.awt.Color(255, 255, 255));
        juli.setText("Juli");

        agustus.setFont(new java.awt.Font("Franklin Gothic Medium", 2, 12)); // NOI18N
        agustus.setForeground(new java.awt.Color(255, 255, 255));
        agustus.setText("Agustus");

        september.setFont(new java.awt.Font("Franklin Gothic Medium", 2, 12)); // NOI18N
        september.setForeground(new java.awt.Color(255, 255, 255));
        september.setText("September");

        oktober.setFont(new java.awt.Font("Franklin Gothic Medium", 2, 12)); // NOI18N
        oktober.setForeground(new java.awt.Color(255, 255, 255));
        oktober.setText("Oktober");

        november.setFont(new java.awt.Font("Franklin Gothic Medium", 2, 12)); // NOI18N
        november.setForeground(new java.awt.Color(255, 255, 255));
        november.setText("November");

        desember.setFont(new java.awt.Font("Franklin Gothic Medium", 2, 12)); // NOI18N
        desember.setForeground(new java.awt.Color(255, 255, 255));
        desember.setText("Desember");

        buy.setBackground(new java.awt.Color(255, 255, 255));
        buy.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 12)); // NOI18N
        buy.setForeground(new java.awt.Color(0, 0, 0));
        buy.setText("Bayar");
        buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyActionPerformed(evt);
            }
        });

        tf_uang.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(buy)
                                    .addGap(111, 111, 111))
                                .addComponent(tf_uang, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_spp, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(februari)
                            .addComponent(maret)
                            .addComponent(april)
                            .addComponent(januari))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mei)
                            .addComponent(juni)
                            .addComponent(juli)
                            .addComponent(agustus))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(desember)
                            .addComponent(november)
                            .addComponent(oktober)
                            .addComponent(september))
                        .addGap(75, 75, 75))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_spp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(januari)
                    .addComponent(mei)
                    .addComponent(september))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(februari)
                    .addComponent(juni)
                    .addComponent(oktober))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maret)
                    .addComponent(juli)
                    .addComponent(november))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(april)
                    .addComponent(agustus)
                    .addComponent(desember))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_uang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buy))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 84, -1, 290));

        jPanel7.setBackground(new java.awt.Color(51, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\USEr\\Downloads\\money-bag_1809678 (1).png")); // NOI18N
        jPanel7.add(jLabel9);

        jLabel3.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("SPP PAYMENT FORM");
        jPanel7.add(jLabel3);

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\USEr\\Downloads\\bribe_9373920 (1).png")); // NOI18N
        jPanel7.add(jLabel8);

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 80));

        getContentPane().add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(2, 0));

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Riwayat:");

        tbl_riwayat.setBackground(new java.awt.Color(153, 153, 153));
        tbl_riwayat.setFont(new java.awt.Font("Gadugi", 1, 11)); // NOI18N
        tbl_riwayat.setForeground(new java.awt.Color(0, 0, 0));
        tbl_riwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Bulan", "Nominal", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_riwayat);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(263, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(401, 401, 401))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(254, 254, 254))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel2.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Status:");

        lbl_status.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        lbl_status.setForeground(new java.awt.Color(0, 0, 0));
        lbl_status.setText("Status Pembayaran: Menunggak");

        lbl_total.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(0, 0, 0));
        lbl_total.setText("Total Pembayaran Tersisa:  Rp 0");

        keluar.setBackground(new java.awt.Color(255, 255, 255));
        keluar.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 12)); // NOI18N
        keluar.setForeground(new java.awt.Color(0, 0, 0));
        keluar.setText("Exit");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        ta_bulan.setBackground(new java.awt.Color(0, 0, 0));
        ta_bulan.setColumns(20);
        ta_bulan.setFont(new java.awt.Font("Franklin Gothic Medium", 3, 10)); // NOI18N
        ta_bulan.setForeground(new java.awt.Color(255, 255, 255));
        ta_bulan.setRows(5);
        jScrollPane2.setViewportView(ta_bulan);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_total)
                            .addComponent(lbl_status))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(433, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(keluar)
                            .addComponent(jLabel2))
                        .addGap(92, 92, 92)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_status)
                        .addGap(33, 33, 33)
                        .addComponent(lbl_total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(keluar))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        jPanel2.add(jPanel6);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyActionPerformed
        hitung();
    }//GEN-LAST:event_buyActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        if(bulan_status.values().stream().allMatch(status -> status)) {
            System.exit(0); 
        }
    }//GEN-LAST:event_keluarActionPerformed

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
            java.util.logging.Logger.getLogger(nomer2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nomer2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nomer2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nomer2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nomer2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox agustus;
    private javax.swing.JCheckBox april;
    private javax.swing.JButton buy;
    private javax.swing.JCheckBox desember;
    private javax.swing.JCheckBox februari;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox januari;
    private javax.swing.JCheckBox juli;
    private javax.swing.JCheckBox juni;
    private javax.swing.JButton keluar;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JCheckBox maret;
    private javax.swing.JCheckBox mei;
    private javax.swing.JCheckBox november;
    private javax.swing.JCheckBox oktober;
    private javax.swing.JCheckBox september;
    private javax.swing.JTextArea ta_bulan;
    private javax.swing.JTable tbl_riwayat;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_spp;
    private javax.swing.JTextField tf_uang;
    // End of variables declaration//GEN-END:variables
}
