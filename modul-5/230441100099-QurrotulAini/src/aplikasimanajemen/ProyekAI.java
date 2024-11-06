package aplikasimanajemen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProyekAI extends javax.swing.JFrame {
    
    Connection conn;
    private DefaultTableModel model;
    private DefaultTableModel model2;
    private DefaultTableModel model3;
    
    public ProyekAI() {
        initComponents();
        this.setLocationRelativeTo(null);
        conn = koneksi.getConnection();
        loadComboBoxKaryawan();
        loadComboBoxProyek();
        
        //tabel karyawan
        model = new DefaultTableModel();
        tabelK.setModel(model);
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Jabatan");
        model.addColumn("Departemen");
        loadData();
        
        //tabel proyek
        model2 = new DefaultTableModel();
        tabelP.setModel(model2);
        model2.addColumn("ID");
        model2.addColumn("Nama Proyek");
        model2.addColumn("Durasi Pengerjaan");
        loadData2();
        
        //tabel transaksi
        model3 = new DefaultTableModel();
        tabelT.setModel(model3);
        model3.addColumn("ID Karyawan");
        model3.addColumn("ID Proyek");
        model3.addColumn("Peran");
        loadData3();
       
    }
    
    private void loadData() {
      model.setRowCount(0);
      try {
          String sql = "SELECT * FROM karyawan";
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             //menambahkan baris ke dalam model tabel
             model.addRow(new Object[]{
             rs.getInt("id"),
             rs.getString("nama"),
             rs.getString("jabatan"),
             rs.getString("departemen")
           });
          }
      } catch (SQLException e) {
         System.out.println("Error! " + e.getMessage());
       }
    }
    
    private void loadData2() {
      model2.setRowCount(0);
      try {
          String sql = "SELECT * FROM proyek";
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             //menambahkan baris ke dalam model tabel
             model2.addRow(new Object[]{
             rs.getInt("id"),
             rs.getString("nama_proyek"),
             rs.getString("durasi_pengerjaan")
           });
          }
      } catch (SQLException e) {
         System.out.println("Error! " + e.getMessage());
       }
    }
    
    private void loadData3() {
      String karyawan = "SELECT id, nama FROM karyawan"; 
      String proyek = "SELECT id, nama_proyek FROM proyek"; 
      idKT.removeAllItems();
      idPT.removeAllItems();
      try (PreparedStatement psKaryawan = conn.prepareStatement(karyawan);
         ResultSet rsKaryawan = psKaryawan.executeQuery()) {

        while (rsKaryawan.next()) {
            String namaKaryawan = rsKaryawan.getString("id");
            idKT.addItem(namaKaryawan);
        }
    } catch (SQLException e) {
        System.out.println("Error! " + e.getMessage());
    }
      try (PreparedStatement psProyek = conn.prepareStatement(proyek);
         ResultSet rsProyek = psProyek.executeQuery()) {

        while (rsProyek.next()) {
            String namaProyek = rsProyek.getString("id"); 
            idPT.addItem(namaProyek);
        }
    } catch (SQLException e) {
        System.out.println("Error! " + e.getMessage());
    }
      model3.setRowCount(0);
      
      try {
          String sql = "SELECT * FROM transaksi";
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             //menambahkan baris ke dalam model tabel
             model3.addRow(new Object[]{
             rs.getInt("id_karyawan"),
             rs.getInt("id_proyek"),
             rs.getString("peran")
           });
          }
      } catch (SQLException e) {
         System.out.println("Error! " + e.getMessage());
       }
    }
    
    private void loadComboBoxKaryawan() {
        idKT.removeAllItems();
        String sql = "SELECT id, nama FROM karyawan";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String item = String.format("ID: %d - %s", rs.getInt("id"), rs.getString("nama"));
                idKT.addItem(item);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Kesalahan Memuat Data Karyawan: " + e.getMessage());
        }
    }
    
    private void loadComboBoxProyek() {
        idPT.removeAllItems();
        String sql = "SELECT id, nama_proyek FROM proyek";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String item = String.format("ID: %d - %s", rs.getInt("id"), rs.getString("nama_proyek"));
                idPT.addItem(item);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Kesalahan Memuat Data Proyek: " + e.getMessage());
        }
    }
    
    //untuk button tambah di tab karyawan
    private void tambahDataK() {
      try{
          if (idK.getText().trim().isEmpty() || namaK.getText().trim().isEmpty() ||
              jabatanK.getText().trim().isEmpty() || departemenK.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Mohon lengkapi semua data!", "Error!", JOptionPane.WARNING_MESSAGE);
        return;
        }
         String sql = "INSERT INTO karyawan (id, nama, jabatan, departemen) VALUES (?, ?, ?, ?)";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setInt(1, Integer.parseInt(idK.getText()));
         ps.setString(2, namaK.getText());
         ps.setString(3, jabatanK.getText());
         ps.setString(4, departemenK.getText());
         ps.executeUpdate();
         JOptionPane.showMessageDialog(this, "Data successfully added!");
         //
         loadData();
         loadComboBoxKaryawan();
         loadData3();
       } catch (SQLException e) {
         System.out.println("Error! " + e.getMessage());
       }
     }
    
    //untuk button tambah di tab proyek
    private void tambahDataP() {
      try{
          if (idP.getText().trim().isEmpty() || namaP.getText().trim().isEmpty() || 
              durasiP.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Mohon lengkapi semua data!", "Error!", JOptionPane.WARNING_MESSAGE);
        return;
        }
         String sql = "INSERT INTO proyek (id, nama_proyek, durasi_pengerjaan) VALUES (?, ?, ?)";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setInt(1, Integer.parseInt(idP.getText()));
         ps.setString(2, namaP.getText());
         ps.setString(3, durasiP.getText());
         ps.executeUpdate();
         JOptionPane.showMessageDialog(this, "Data successfully added!");
         //
         loadData2();
         loadComboBoxProyek();
         loadData3();
       } catch (SQLException e) {
         System.out.println("Error! " + e.getMessage());
       }
     }
    
    //untuk button tambah di tab transaksi
    private void tambahDataT() {
          if (idKT.getSelectedItem().toString().isEmpty() || idPT.getSelectedItem().toString().isEmpty() 
             || peranT.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Mohon lengkapi semua data!", "Error!", JOptionPane.WARNING_MESSAGE);
        return;
        }
         String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(idKT.getSelectedItem().toString().split(":")[0].trim()));
            ps.setInt(2, Integer.parseInt(idPT.getSelectedItem().toString().split(":")[0].trim()));
            ps.setString(3, peranT.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
            loadData3();
        }catch (SQLException e) {
         System.out.println("Error! " + e.getMessage());
       }
     }
    
    //untuk button edit di tab karyawan
    private void editDataK() {
      try {
          if (idK.getText().trim().isEmpty() || namaK.getText().trim().isEmpty() || jabatanK.getText().trim().isEmpty() || 
              departemenK.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
        }
          String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, namaK.getText());
          ps.setString(2, jabatanK.getText());
          ps.setString(3, departemenK.getText());
          ps.setInt(4, Integer.parseInt(idK.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data successfully edited");
          loadData();
          loadComboBoxKaryawan();
          loadData3();
      }  catch (SQLException e) {
          System.out.println("Error! " + e.getMessage());
      }
     }
    
    //untuk button edit di tab proyek
    private void editDataP() {
      try {
          if (idP.getText().trim().isEmpty() || namaP.getText().trim().isEmpty() || durasiP.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
        }
          
          String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, namaP.getText());
          ps.setString(2, durasiP.getText());
          ps.setInt(3, Integer.parseInt(idP.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data successfully edited");
          loadData2();
          loadComboBoxProyek();
          loadData3();
      }  catch (SQLException e) {
          System.out.println("Error! " + e.getMessage());
      }
     }
    
    //untuk button edit di tab transaksi
    private void editDataT() {
      try {
          if (peranT.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Error", JOptionPane.WARNING_MESSAGE);
        return;
        }
   
          String selectedKaryawan = (String) idKT.getSelectedItem();
          String selectedProyek = (String) idPT.getSelectedItem();
          String peran = peranT.getText(); // Mendapatkan nilai peran dari TextField

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
            //
            loadData3();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    
    //untuk button hapus di tab karyawan
    private void hapusDataK() {
    int confirm = JOptionPane.showConfirmDialog(this, 
            "Apakah Anda yakin ingin menghapus data ini?", 
            "Konfirmasi Hapus", 
            JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "DELETE FROM karyawan WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idK.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            loadData();
            loadData3();
            loadComboBoxKaryawan();
        } catch (SQLException e) {
            System.out.println("Error! " + e.getMessage());
        }
    }else {
        JOptionPane.showMessageDialog(this, "Penghapusan data dibatalkan.");
        }
    }
    
    //untuk button hapus di tab proyek
    private void hapusDataP() {
    int confirm = JOptionPane.showConfirmDialog(this, 
            "Apakah Anda yakin ingin menghapus data ini?", 
            "Konfirmasi Hapus", 
            JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION){
     try  {
          String sql = "DELETE FROM proyek WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, Integer.parseInt(idP.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data deleted successfully");
          loadData2();
          loadData3();
          loadComboBoxProyek();
     } catch (SQLException e) {
          System.out.println("Error! " + e.getMessage());
      }
    }else{
       JOptionPane.showMessageDialog(this, "Penghapusan data dibatalkan.");
        }
    }
    
    //untuk button hapus di tab transaksi
    private void hapusDataT() {
    int confirm = JOptionPane.showConfirmDialog(this, 
            "Apakah Anda yakin ingin menghapus data ini?", 
            "Konfirmasi Hapus", 
            JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION){
     try  {
          String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, Integer.parseInt(idKT.getSelectedItem().toString()));
          ps.setInt(2, Integer.parseInt(idPT.getSelectedItem().toString()));
          ps.execute();
          JOptionPane.showMessageDialog(this, "Data yang di Hapus Sukses");
          loadData3();
     } catch (SQLException e) {
          System.out.println("Error! " + e.getMessage());
      }
    }else{
        JOptionPane.showMessageDialog(this, "Penghapusan data dibatalkan.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPKaryawan = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        idK = new javax.swing.JTextField();
        departemenK = new javax.swing.JTextField();
        jabatanK = new javax.swing.JTextField();
        namaK = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        keluarK = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelK = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        hapusK = new javax.swing.JButton();
        tambahK = new javax.swing.JButton();
        editK = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        idP = new javax.swing.JTextField();
        durasiP = new javax.swing.JTextField();
        namaP = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        hapusP = new javax.swing.JButton();
        tambahP = new javax.swing.JButton();
        editP = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelP = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        keluarP = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        keluarT = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        hapusT = new javax.swing.JButton();
        tambahT = new javax.swing.JButton();
        editT = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelT = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        peranT = new javax.swing.JTextField();
        idKT = new javax.swing.JComboBox<>();
        idPT = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria Math", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STUDIOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 160, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasimanajemen/Marvel.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasimanajemen/Avengers.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jPKaryawan.setBackground(new java.awt.Color(149, 1, 1));
        jPKaryawan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Departemen  :");
        jPKaryawan.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID                   :");
        jPKaryawan.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nama             :");
        jPKaryawan.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Jabatan          :");
        jPKaryawan.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));
        jPKaryawan.add(idK, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 250, -1));
        jPKaryawan.add(departemenK, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 250, -1));
        jPKaryawan.add(jabatanK, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 250, -1));
        jPKaryawan.add(namaK, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 250, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        keluarK.setText("Keluar");
        keluarK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarKActionPerformed(evt);
            }
        });
        jPanel2.add(keluarK);

        jPKaryawan.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 397, 510, 40));

        tabelK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Jabatan", "Departemen"
            }
        ));
        jScrollPane2.setViewportView(tabelK);

        jPKaryawan.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 340, 170));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasimanajemen/Spiderman.png"))); // NOI18N
        jPKaryawan.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));

        jPanel8.setBackground(new java.awt.Color(149, 1, 1));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        hapusK.setText("Hapus");
        hapusK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusKActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(7, 16, 7, 16);
        jPanel8.add(hapusK, gridBagConstraints);

        tambahK.setText("Tambah");
        tambahK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahKActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 17, 8, 17);
        jPanel8.add(tambahK, gridBagConstraints);

        editK.setText("Edit");
        editK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editKActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(8, 17, 8, 17);
        jPanel8.add(editK, gridBagConstraints);

        jPKaryawan.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 340, 50));

        jTabbedPane1.addTab("Karyawan", jPKaryawan);

        jPanel3.setBackground(new java.awt.Color(149, 1, 1));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ID                             :");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nama Proyek          :");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Durasi Pengerjaan  :");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        idP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPActionPerformed(evt);
            }
        });
        jPanel3.add(idP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 230, -1));

        durasiP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durasiPActionPerformed(evt);
            }
        });
        jPanel3.add(durasiP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 230, -1));
        jPanel3.add(namaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 230, -1));

        jPanel9.setBackground(new java.awt.Color(149, 1, 1));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        hapusP.setText("Hapus");
        hapusP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusPActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(7, 16, 7, 16);
        jPanel9.add(hapusP, gridBagConstraints);

        tambahP.setText("Tambah");
        tambahP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahPActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 17, 8, 17);
        jPanel9.add(tambahP, gridBagConstraints);

        editP.setText("Edit");
        editP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(8, 17, 8, 17);
        jPanel9.add(editP, gridBagConstraints);

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 340, 50));

        tabelP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nama Proyek", "Durasi Pengerjaan"
            }
        ));
        jScrollPane4.setViewportView(tabelP);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 350, 170));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        keluarP.setText("Keluar");
        keluarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarPActionPerformed(evt);
            }
        });
        jPanel5.add(keluarP);

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 397, 510, 40));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasimanajemen/Spiderman.png"))); // NOI18N
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));

        jTabbedPane1.addTab("Proyek", jPanel3);

        jPanel4.setBackground(new java.awt.Color(149, 1, 1));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        keluarT.setText("Keluar");
        keluarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarTActionPerformed(evt);
            }
        });
        jPanel6.add(keluarT);

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 397, 510, 40));

        jPanel10.setBackground(new java.awt.Color(149, 1, 1));
        jPanel10.setLayout(new java.awt.GridBagLayout());

        hapusT.setText("Hapus");
        hapusT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusTActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(7, 16, 7, 16);
        jPanel10.add(hapusT, gridBagConstraints);

        tambahT.setText("Tambah");
        tambahT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahTActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 17, 8, 17);
        jPanel10.add(tambahT, gridBagConstraints);

        editT.setText("Edit");
        editT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(8, 17, 8, 17);
        jPanel10.add(editT, gridBagConstraints);

        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 340, 50));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasimanajemen/Spiderman.png"))); // NOI18N
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));

        tabelT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Karyawan", "ID Proyek", "Peran"
            }
        ));
        jScrollPane3.setViewportView(tabelT);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 340, 170));

        jLabel12.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ID Karyawan            :");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ID Proyek                 :");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel16.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Peran                        :");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        peranT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peranTActionPerformed(evt);
            }
        });
        jPanel4.add(peranT, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 230, -1));

        jPanel4.add(idKT, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 230, -1));

        jPanel4.add(idPT, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 230, -1));

        jTabbedPane1.addTab("TransaksiProyek", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void durasiPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durasiPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_durasiPActionPerformed

    private void tambahKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahKActionPerformed
        tambahDataK();
    }//GEN-LAST:event_tambahKActionPerformed

    private void keluarKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarKActionPerformed
        int exit = JOptionPane.showConfirmDialog(null,"Ingin keluar?","Keluar",JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_keluarKActionPerformed

    private void editKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editKActionPerformed
        editDataK();
    }//GEN-LAST:event_editKActionPerformed

    private void tambahPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahPActionPerformed
        tambahDataP();
    }//GEN-LAST:event_tambahPActionPerformed

    private void editPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPActionPerformed
        editDataP();
    }//GEN-LAST:event_editPActionPerformed

    private void keluarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarPActionPerformed
        int exit = JOptionPane.showConfirmDialog(null,"Ingin keluar?","Keluar",JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_keluarPActionPerformed

    private void keluarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarTActionPerformed
        int exit = JOptionPane.showConfirmDialog(null,"Ingin keluar?","Keluar",JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_keluarTActionPerformed

    private void tambahTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahTActionPerformed
        tambahDataT();
    }//GEN-LAST:event_tambahTActionPerformed

    private void editTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTActionPerformed
        editDataT();
    }//GEN-LAST:event_editTActionPerformed

    private void peranTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peranTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peranTActionPerformed

    private void hapusKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusKActionPerformed
        hapusDataK();
    }//GEN-LAST:event_hapusKActionPerformed

    private void idPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPActionPerformed

    private void hapusPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusPActionPerformed
        hapusDataP();
    }//GEN-LAST:event_hapusPActionPerformed

    private void hapusTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusTActionPerformed
        hapusDataT();
    }//GEN-LAST:event_hapusTActionPerformed

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
            java.util.logging.Logger.getLogger(ProyekAI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProyekAI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProyekAI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProyekAI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProyekAI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField departemenK;
    private javax.swing.JTextField durasiP;
    private javax.swing.JButton editK;
    private javax.swing.JButton editP;
    private javax.swing.JButton editT;
    private javax.swing.JButton hapusK;
    private javax.swing.JButton hapusP;
    private javax.swing.JButton hapusT;
    private javax.swing.JTextField idK;
    private javax.swing.JComboBox<String> idKT;
    private javax.swing.JTextField idP;
    private javax.swing.JComboBox<String> idPT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPKaryawan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jabatanK;
    private javax.swing.JButton keluarK;
    private javax.swing.JButton keluarP;
    private javax.swing.JButton keluarT;
    private javax.swing.JTextField namaK;
    private javax.swing.JTextField namaP;
    private javax.swing.JTextField peranT;
    private javax.swing.JTable tabelK;
    private javax.swing.JTable tabelP;
    private javax.swing.JTable tabelT;
    private javax.swing.JButton tambahK;
    private javax.swing.JButton tambahP;
    private javax.swing.JButton tambahT;
    // End of variables declaration//GEN-END:variables
}
