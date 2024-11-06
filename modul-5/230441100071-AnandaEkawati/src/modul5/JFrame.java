package modul5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrame extends javax.swing.JFrame {
    Connection conn;
    private DefaultTableModel model;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    HashMap<String, Integer> karyawanMap = new HashMap<>(); 
    HashMap<String, Integer> proyekMap = new HashMap<>();
    /**
     * Creates new form JFrame
     */
    public JFrame() {
        initComponents();
        
        conn = konek.getConnection();
        
        model = new DefaultTableModel();
        Tabelkaryawan.setModel(model);
        
        model.addColumn("ID");
        model.addColumn("NAMA");
        model.addColumn("JABATAN");
        model.addColumn("DEPATERMEN");
        
        loadDatakaryawan();
        
        model1 = new DefaultTableModel();
        Tabelproyek.setModel(model1);
    

        model1.addColumn("ID");
        model1.addColumn("NAMA PROYEK");
        model1.addColumn("DURASI");

        loadDataproyek();
        
        model2 = new DefaultTableModel();
        Tabeltransaksi.setModel(model2);
    
        model2.addColumn("ID KARYAWAN");
        model2.addColumn("ID PROYEK");
        model2.addColumn("PERAN");

        loadDatatransaksi();
    }
    
// LOAD DATA KARYAWAN

    private void loadDatakaryawan() {
      model.setRowCount(0);

      try {
          String sql = "SELECT * FROM karyawan";
           PreparedStatement ps = conn.prepareStatement(sql);//menyiapkan query
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             model.addRow(new Object[]{
             rs.getInt("id"),
             rs.getString("nama"),
             rs.getString("jabatan"),
             rs.getString("departemen"),
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }
//END
    
// LOAD DATA PROYEK
    // Metode untuk memuat data proyek ke dalam combo box

private void loadProyekToComboBox() {
    
    try {
        // Hapus item yang ada di combo box
        cbxidp.removeAllItems();

        // Mengambil kolom id dan nama_proyek
        String sql = "SELECT id FROM proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            // Tambahkan nama proyek ke dalam combo box (atau gunakan id jika diperlukan)
            cbxidp.addItem(rs.getString("id"));
        }
    } catch (SQLException e) {
        System.out.println("Error saat memuat data combo box: " + e.getMessage());
    }
}


    private void loadDataproyek() {
    model1.setRowCount(0);

    try {
        String sql = "SELECT * FROM proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            model1.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("nama_proyek"),
                rs.getString("durasi_pengerjaan")
            });
        }

        // Setelah data dimuat ke model1, muat ulang data di combo box
        loadProyekToComboBox();

    } catch (SQLException e) {
        System.out.println("Error saat memuat data: " + e.getMessage());
    }
    }
//END
     
// LOAD DATA TRANSAKSI
    private void loadDatatransaksi() {
    String proyek= "SELECT id, Nama_Proyek FROM proyek"; 
    String karyawan = "SELECT id, Nama FROM karyawan"; 
    cbxidp.removeAllItems();
    cbxidk.removeAllItems();
   
    
    try (PreparedStatement psKaryawan = conn.prepareStatement(karyawan);
         ResultSet rsKaryawan = psKaryawan.executeQuery()) {

        while (rsKaryawan.next()) {
            String namaKaryawan = rsKaryawan.getString("id");
            cbxidk.addItem(namaKaryawan);
            
        }
    } catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
    }
    
    try (PreparedStatement psProyek = conn.prepareStatement(proyek);
         ResultSet rsProyek = psProyek.executeQuery()) {

        while (rsProyek.next()) {
            String namaProyek = rsProyek.getString("id"); 
            cbxidp.addItem(namaProyek);
        }
    } catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
    }
    model2.setRowCount(0);

      try {
          String sql = "SELECT * FROM transaksi";
          PreparedStatement ps = conn.prepareStatement(sql);//menyiapkan query 
          ResultSet rs = ps.executeQuery();//menyimpan data
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             model2.addRow(new Object[]{
             rs.getInt("id_karyawan"),
             rs.getInt("id_proyek"),
             rs.getString("peran")
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }

    }
//END
    
//Simpan Data
    private void saveDatakaryawan() {
      try {
    // Validasi input
    if (idkaryawan.getText().trim().isEmpty() || Nama.getText().trim().isEmpty() || Jabatan.getText().trim().isEmpty() || Departemen.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Data tidak lengkap", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Cek apakah inputan hanya spasi atau berisi "0"
    if (idkaryawan.getText().trim().equals("0") || Nama.getText().trim().equals("0") || Jabatan.getText().trim().equals("0") || Departemen.getText().trim().equals("0")) {
        JOptionPane.showMessageDialog(this, "Data tidak valid", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String sql = "INSERT INTO karyawan (id, nama, jabatan, departemen) VALUES (?, ?, ?, ?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, idkaryawan.getText().trim());
    ps.setString(2, Nama.getText().trim());
    ps.setString(3, Jabatan.getText().trim());
    ps.setString(4, Departemen.getText().trim());
    
    ps.executeUpdate();
    JOptionPane.showMessageDialog(this, "Data saved successfully");
    loadDatakaryawan();
} catch (SQLException e) {
    System.out.println("Error Save Data: " + e.getMessage());
}

     }
     
      //Update Data
    private void updateDatakaryawan() {
      try {
          String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ?WHERE id = ?";
          
          PreparedStatement ps = conn.prepareStatement(sql);//untuk meningkatkan keamanan
          
//          ps.setString(1, idkaryawan.getText());
          ps.setString(1, Nama.getText());
          ps.setString(2, Jabatan.getText());
          ps.setString(3, Departemen.getText());
          ps.setInt(4, Integer.parseInt(idkaryawan.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data updated successfully");
          loadDatakaryawan();
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
     }
    
     //Delete Data
    private void deleteDatakaryawan() {
    try {
        int confirm = JOptionPane.showConfirmDialog(null, "Yakin nih mau dihapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        // Jika pengguna memilih "Yes" (nilai 0), lanjutkan penghapusan
        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM karyawan WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idkaryawan.getText()));
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            loadDatakaryawan();
        }
    } catch (SQLException e) {
        System.out.println("Error Delete Data: " + e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TP = new javax.swing.JTabbedPane();
        PanelKaryawan = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        id = new javax.swing.JLabel();
        jabatan = new javax.swing.JLabel();
        departemen = new javax.swing.JLabel();
        Jabatan = new javax.swing.JTextField();
        Nama = new javax.swing.JTextField();
        nama = new javax.swing.JLabel();
        idkaryawan = new javax.swing.JTextField();
        Departemen = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        SIMPAN = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabelkaryawan = new javax.swing.JTable();
        PanelTransaksi = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        namaproyek = new javax.swing.JLabel();
        id2 = new javax.swing.JLabel();
        idproyek = new javax.swing.JTextField();
        Durasi = new javax.swing.JTextField();
        durasi = new javax.swing.JLabel();
        NamaProyek = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        SIMPAN2 = new javax.swing.JButton();
        UPDATE2 = new javax.swing.JButton();
        DELETE2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabelproyek = new javax.swing.JTable();
        PanelProyek = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        IDproyek = new javax.swing.JLabel();
        peran = new javax.swing.JLabel();
        IDkaryawan = new javax.swing.JLabel();
        cbxidk = new javax.swing.JComboBox<>();
        cbxidp = new javax.swing.JComboBox<>();
        Peran = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        SIMPAN3 = new javax.swing.JButton();
        UPDATE3 = new javax.swing.JButton();
        DELETE3 = new javax.swing.JButton();
        tabelproyek = new javax.swing.JScrollPane();
        Tabeltransaksi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TP.setBackground(new java.awt.Color(255, 255, 255));

        PanelKaryawan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setLayout(null);

        id.setFont(new java.awt.Font("STZhongsong", 1, 14)); // NOI18N
        id.setText("ID");
        jPanel5.add(id);
        id.setBounds(70, 40, 50, 20);

        jabatan.setFont(new java.awt.Font("STZhongsong", 1, 14)); // NOI18N
        jabatan.setText("JABATAN");
        jPanel5.add(jabatan);
        jabatan.setBounds(70, 100, 70, 20);

        departemen.setFont(new java.awt.Font("STZhongsong", 1, 14)); // NOI18N
        departemen.setText("DEPARTEMEN");
        jPanel5.add(departemen);
        departemen.setBounds(70, 130, 106, 20);
        jPanel5.add(Jabatan);
        Jabatan.setBounds(210, 100, 210, 22);
        jPanel5.add(Nama);
        Nama.setBounds(210, 70, 210, 22);

        nama.setFont(new java.awt.Font("STZhongsong", 1, 14)); // NOI18N
        nama.setText("NAMA");
        jPanel5.add(nama);
        nama.setBounds(70, 70, 50, 20);
        jPanel5.add(idkaryawan);
        idkaryawan.setBounds(210, 40, 210, 22);
        jPanel5.add(Departemen);
        Departemen.setBounds(210, 130, 210, 22);

        PanelKaryawan.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 220));

        jPanel6.setBackground(new java.awt.Color(153, 153, 255));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        SIMPAN.setBackground(new java.awt.Color(153, 153, 255));
        SIMPAN.setFont(new java.awt.Font("STFangsong", 1, 14)); // NOI18N
        SIMPAN.setText("SIMPAN");
        SIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SIMPANActionPerformed(evt);
            }
        });
        jPanel6.add(SIMPAN);

        UPDATE.setBackground(new java.awt.Color(102, 102, 255));
        UPDATE.setFont(new java.awt.Font("STFangsong", 1, 14)); // NOI18N
        UPDATE.setText("UPDATE");
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });
        jPanel6.add(UPDATE);

        DELETE.setBackground(new java.awt.Color(0, 0, 204));
        DELETE.setFont(new java.awt.Font("STFangsong", 1, 14)); // NOI18N
        DELETE.setText("DELETE");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });
        jPanel6.add(DELETE);

        PanelKaryawan.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 224, 500, 80));

        Tabelkaryawan.setBackground(new java.awt.Color(204, 204, 255));
        Tabelkaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tabelkaryawan);

        PanelKaryawan.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 370, 330));

        TP.addTab("Tabel Karyawan", PanelKaryawan);

        PanelTransaksi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 204, 204));
        jPanel7.setLayout(null);

        namaproyek.setFont(new java.awt.Font("STFangsong", 1, 14)); // NOI18N
        namaproyek.setText("NAMA PROYEK");
        jPanel7.add(namaproyek);
        namaproyek.setBounds(60, 80, 110, 19);

        id2.setFont(new java.awt.Font("STFangsong", 1, 14)); // NOI18N
        id2.setText("ID");
        jPanel7.add(id2);
        id2.setBounds(60, 50, 60, 30);
        jPanel7.add(idproyek);
        idproyek.setBounds(200, 50, 240, 22);
        jPanel7.add(Durasi);
        Durasi.setBounds(200, 110, 240, 22);

        durasi.setFont(new java.awt.Font("STFangsong", 1, 14)); // NOI18N
        durasi.setText("DURASI");
        jPanel7.add(durasi);
        durasi.setBounds(60, 110, 60, 19);
        jPanel7.add(NamaProyek);
        NamaProyek.setBounds(200, 80, 240, 22);

        PanelTransaksi.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 220));

        jPanel8.setBackground(new java.awt.Color(255, 153, 153));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        SIMPAN2.setBackground(new java.awt.Color(255, 153, 153));
        SIMPAN2.setFont(new java.awt.Font("STFangsong", 1, 14)); // NOI18N
        SIMPAN2.setText("SIMPAN");
        SIMPAN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SIMPAN2ActionPerformed(evt);
            }
        });
        jPanel8.add(SIMPAN2);

        UPDATE2.setBackground(new java.awt.Color(255, 102, 102));
        UPDATE2.setFont(new java.awt.Font("STFangsong", 1, 14)); // NOI18N
        UPDATE2.setText("UPDATE");
        UPDATE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATE2ActionPerformed(evt);
            }
        });
        jPanel8.add(UPDATE2);

        DELETE2.setBackground(new java.awt.Color(204, 0, 0));
        DELETE2.setFont(new java.awt.Font("STZhongsong", 1, 14)); // NOI18N
        DELETE2.setText("DELETE");
        DELETE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETE2ActionPerformed(evt);
            }
        });
        jPanel8.add(DELETE2);

        PanelTransaksi.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 500, 90));

        Tabelproyek.setBackground(new java.awt.Color(255, 204, 204));
        Tabelproyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(Tabelproyek);

        PanelTransaksi.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 370, 330));

        TP.addTab("Tabel Proyek", PanelTransaksi);

        PanelProyek.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 204, 255));
        jPanel4.setLayout(null);

        IDproyek.setFont(new java.awt.Font("STFangsong", 1, 14)); // NOI18N
        IDproyek.setText("ID PROYEK");
        jPanel4.add(IDproyek);
        IDproyek.setBounds(60, 70, 130, 19);

        peran.setFont(new java.awt.Font("STFangsong", 1, 14)); // NOI18N
        peran.setText("PERAN");
        jPanel4.add(peran);
        peran.setBounds(60, 130, 120, 19);

        IDkaryawan.setFont(new java.awt.Font("STFangsong", 1, 14)); // NOI18N
        IDkaryawan.setText("ID KARYAWAN");
        jPanel4.add(IDkaryawan);
        IDkaryawan.setBounds(60, 100, 130, 19);

        jPanel4.add(cbxidk);
        cbxidk.setBounds(220, 100, 210, 24);

        jPanel4.add(cbxidp);
        cbxidp.setBounds(220, 70, 210, 24);
        jPanel4.add(Peran);
        Peran.setBounds(220, 130, 210, 22);

        PanelProyek.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 230));

        jPanel10.setBackground(new java.awt.Color(255, 153, 255));
        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        SIMPAN3.setBackground(new java.awt.Color(255, 153, 255));
        SIMPAN3.setFont(new java.awt.Font("STFangsong", 1, 14)); // NOI18N
        SIMPAN3.setText("SIMPAN");
        SIMPAN3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SIMPAN3ActionPerformed(evt);
            }
        });
        jPanel10.add(SIMPAN3);

        UPDATE3.setBackground(new java.awt.Color(255, 102, 255));
        UPDATE3.setFont(new java.awt.Font("STFangsong", 1, 14)); // NOI18N
        UPDATE3.setText("UPDATE");
        UPDATE3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATE3ActionPerformed(evt);
            }
        });
        jPanel10.add(UPDATE3);

        DELETE3.setBackground(new java.awt.Color(153, 0, 153));
        DELETE3.setFont(new java.awt.Font("STFangsong", 1, 14)); // NOI18N
        DELETE3.setText("DELETE");
        DELETE3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETE3ActionPerformed(evt);
            }
        });
        jPanel10.add(DELETE3);

        PanelProyek.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 500, 80));

        Tabeltransaksi.setBackground(new java.awt.Color(255, 204, 255));
        Tabeltransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelproyek.setViewportView(Tabeltransaksi);

        PanelProyek.add(tabelproyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 370, 330));

        TP.addTab("Tabel Transaksi", PanelProyek);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TP, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        // Tombol delet 
        deleteDatakaryawan();
    }//GEN-LAST:event_DELETEActionPerformed

    private void SIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SIMPANActionPerformed
        // Tombol simpan 
        saveDatakaryawan();
    }//GEN-LAST:event_SIMPANActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        // Tombol update 
        updateDatakaryawan();
    }//GEN-LAST:event_UPDATEActionPerformed

// BUTTON TABEL PROYEK
    
    private void SIMPAN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SIMPAN2ActionPerformed
        // Tombol Simpan
        try {
    // Validasi input
    if (idproyek.getText().trim().isEmpty() || NamaProyek.getText().trim().isEmpty() || Durasi.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Data tidak lengkap", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Cek apakah inputan hanya spasi atau berisi "0"
    if (idproyek.getText().trim().equals("0") || NamaProyek.getText().trim().equals("0") || Durasi.getText().trim().equals("0")) {
        JOptionPane.showMessageDialog(this, "Data tidak valid", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String sql = "INSERT INTO proyek (id, nama_proyek, durasi_pengerjaan) VALUES (?, ?, ?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, Integer.parseInt(idproyek.getText().trim()));
    ps.setString(2, NamaProyek.getText().trim());
    ps.setInt(3, Integer.parseInt(Durasi.getText().trim()));
    
    ps.executeUpdate();
    JOptionPane.showMessageDialog(this, "Data saved successfully");
    loadDataproyek();
} catch (SQLException e) {
    System.out.println("Error Save Data: " + e.getMessage());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Durasi harus berupa angka", "Peringatan", JOptionPane.WARNING_MESSAGE);
}

    }//GEN-LAST:event_SIMPAN2ActionPerformed

    private void UPDATE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATE2ActionPerformed
        // Tombol update
         try {
          String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, NamaProyek.getText());
          ps.setInt(2, Integer.parseInt(Durasi.getText()));
          ps.setInt(3, Integer.parseInt(idproyek.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data updated successfully");
          loadDataproyek();
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
    }//GEN-LAST:event_UPDATE2ActionPerformed

    private void DELETE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETE2ActionPerformed
        // Tombol delet
        try {
            int confirm = JOptionPane.showConfirmDialog(this, "Yakin nih mau dihapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            // Jika pengguna memilih "Yes" (nilai 0), lanjutkan penghapusan
            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM proyek WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(idproyek.getText()));
                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Data deleted successfully");
                loadDataproyek();
            }
        } catch (SQLException e) {
            System.out.println("Error Delete Data: " + e.getMessage());
        }
    }//GEN-LAST:event_DELETE2ActionPerformed

// BUTTON TABEL TRANSAKSI
    
    private void SIMPAN3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SIMPAN3ActionPerformed
        // Tombol simpan
    // Validasi input "Peran"
if (Peran.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(this, "harap isi data dengan benar", "DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
} else if (Peran.getText().trim().matches("^\\s+$")) {
    JOptionPane.showMessageDialog(this, "Data tidak valid", "Peringatan", JOptionPane.WARNING_MESSAGE);
} else {
    try {
        String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cbxidk.getSelectedItem().toString());
        ps.setString(2, cbxidp.getSelectedItem().toString());
        ps.setString(3, Peran.getText().trim());

        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data saved successfully");
        loadDatatransaksi();
    } catch (SQLException e) {
        System.out.println("Error Save Data: " + e.getMessage());
    }
}
    }//GEN-LAST:event_SIMPAN3ActionPerformed

    private void UPDATE3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATE3ActionPerformed
        // Tombol update
    try {
           // Validasi apakah semua field telah diisi
            if (Peran.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return; // Menghentikan proses jika ada field yang kosong
            }

            String selectedKaryawan = (String) cbxidk.getSelectedItem();
            String selectedProyek = (String) cbxidp.getSelectedItem();
            String peran = Peran.getText(); // Mendapatkan nilai peran dari TextField

            // Perbarui data transaksi di database
            String sqlUpdate = "UPDATE transaksi SET Peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sqlUpdate);
            ps.setString(1, peran);    // Menyimpan nilai peran yang baru
            ps.setInt(2, Integer.parseInt(selectedKaryawan));  // Berdasarkan id_karyawan
            ps.setInt(3, Integer.parseInt(selectedProyek));    // Berdasarkan id_proyek
            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil diperbarui!", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan atau tidak ada perubahan.", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
            }
            
             // Refresh data setelah update
            loadDatatransaksi();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_UPDATE3ActionPerformed

    private void DELETE3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETE3ActionPerformed
        // Tombol delete
        try {
            int confirm = JOptionPane.showConfirmDialog(this, "Yakin nih mau dihapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            // Jika pengguna memilih "Yes" (nilai 0), lanjutkan penghapusan
            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(cbxidk.getSelectedItem().toString()));
                ps.setInt(2, Integer.parseInt(cbxidp.getSelectedItem().toString()));
                ps.execute();

                JOptionPane.showMessageDialog(this, "Data yang dihapus sukses");
                loadDatatransaksi();
            }
        } catch (SQLException e) {
            System.out.println("Error Delete Data: " + e.getMessage());
        }

        
    }//GEN-LAST:event_DELETE3ActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DELETE;
    private javax.swing.JButton DELETE2;
    private javax.swing.JButton DELETE3;
    private javax.swing.JTextField Departemen;
    private javax.swing.JTextField Durasi;
    private javax.swing.JLabel IDkaryawan;
    private javax.swing.JLabel IDproyek;
    private javax.swing.JTextField Jabatan;
    private javax.swing.JTextField Nama;
    private javax.swing.JTextField NamaProyek;
    private javax.swing.JPanel PanelKaryawan;
    private javax.swing.JPanel PanelProyek;
    private javax.swing.JPanel PanelTransaksi;
    private javax.swing.JTextField Peran;
    private javax.swing.JButton SIMPAN;
    private javax.swing.JButton SIMPAN2;
    private javax.swing.JButton SIMPAN3;
    private javax.swing.JTabbedPane TP;
    private javax.swing.JTable Tabelkaryawan;
    private javax.swing.JTable Tabelproyek;
    private javax.swing.JTable Tabeltransaksi;
    private javax.swing.JButton UPDATE;
    private javax.swing.JButton UPDATE2;
    private javax.swing.JButton UPDATE3;
    private javax.swing.JComboBox<String> cbxidk;
    private javax.swing.JComboBox<String> cbxidp;
    private javax.swing.JLabel departemen;
    private javax.swing.JLabel durasi;
    private javax.swing.JLabel id;
    private javax.swing.JLabel id2;
    private javax.swing.JTextField idkaryawan;
    private javax.swing.JTextField idproyek;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jabatan;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel namaproyek;
    private javax.swing.JLabel peran;
    private javax.swing.JScrollPane tabelproyek;
    // End of variables declaration//GEN-END:variables
}
