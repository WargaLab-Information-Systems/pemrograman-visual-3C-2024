/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pemvis5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Karyawan extends javax.swing.JFrame {
    Connection conn;
    private DefaultTableModel modelkaryawan;
    private DefaultTableModel modelproyek;
    private DefaultTableModel modeltransaksi;
    public Karyawan() {
        initComponents();
        conn = koneksi.getConnection();
        
        modelkaryawan = new DefaultTableModel();
        tbl_karyawan.setModel(modelkaryawan);
        
        modelproyek = new DefaultTableModel();
        tbl_proyek.setModel(modelproyek);
        
        modeltransaksi = new DefaultTableModel();
        tbl_transaksi.setModel(modeltransaksi);
       
        modelkaryawan.addColumn("ID");
        modelkaryawan.addColumn("NAMA");
        modelkaryawan.addColumn("JABATAN");
        modelkaryawan.addColumn("DEPARTEMEN");
        
        modelproyek.addColumn("ID");
        modelproyek.addColumn("NAMA PROYEK");
        modelproyek.addColumn("DURASI PENGERJAAN");
          
        modeltransaksi.addColumn("ID KARYAWAN");
        modeltransaksi.addColumn("ID PROYEK");
        modeltransaksi.addColumn("PROYEK");
       
        loadKaryawanData();
        loadProyekData();
        loadTransaksiData();
        
        idkaryawan();
        idproyek();
    }

    
  
private void loadKaryawanData(){
    modelkaryawan.setRowCount(0);
    try {
      String sql = "SELECT * FROM karyawan";
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
         // Menambahkan baris ke dalam model tabel
         modelkaryawan.addRow(new Object[]{
         rs.getInt("id"),
         rs.getString("nama"),
         rs.getString("jabatan"),
         rs.getString("departemen")
       });
      }
  } catch (SQLException e) {
     System.out.println("Error Save Data" + e.getMessage());
   }
}

private void loadProyekData() {
    modelproyek.setRowCount(0);        
    try {
        String sql = "SELECT * FROM proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            modelproyek.addRow(new Object[]{
            rs.getInt("id"),
            rs.getString("nama_proyek"),
            rs.getString("durasi_pengerjaan")
          });
        }
    } catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
      }
}

private void loadTransaksiData() {
        modeltransaksi.setRowCount(0);
        try {
            String sql = "SELECT * FROM transaksi";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modeltransaksi.addRow(new Object[]{
                    rs.getString("id_karyawan"),
                    rs.getString("id_proyek"),
                    rs.getString("peran")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
    
    private void idkaryawan() {
        try {
            String sql = "SELECT id, nama FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            cbWork.removeAllItems(); 
 
            while (rs.next()) {
                cbWork.addItem(rs.getString("nama"));
 
            }
        } catch (SQLException e) {
            System.out.println("Error loading Worker IDs: " + e.getMessage());
        }
    }  
    private void idproyek() {
        try {
            String sql = "SELECT id, nama_proyek FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            cbProj.removeAllItems();
 
            while (rs.next()) {
                cbProj.addItem(rs.getString("nama_proyek"));
          
            }
        } catch (SQLException e) {
            System.out.println("Error loading Project IDs: " + e.getMessage());
        }
    }    
private void saveKaryawanData() {
        try {
            String sql = "INSERT INTO karyawan (nama, jabatan, departemen) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tf_nama.getText());
            ps.setString(2, cb_jabatan.getSelectedItem().toString()); 
            ps.setString(3, cb_departemen.getSelectedItem().toString());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data saved successfully");
            loadKaryawanData();
            idkaryawan();
        } catch (SQLException e) {
            System.out.println("Error Save Data: " + e.getMessage());
        }

    }
private void saveProyekData() {
        try {
            int durasi = Integer.parseInt(tf_durasi.getText());
            String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tf_nama_proyek.getText());
            ps.setInt(2, durasi);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data saved successfully");
            loadProyekData();
            idproyek();
        } catch (SQLException e) {
            System.out.println("Error Save Data: " + e.getMessage());
        }
    }
private void updateKaryawanData() {
   try {
        String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_nama.getText());
        ps.setString(2, cb_jabatan.getSelectedItem().toString());
        ps.setString(3, cb_departemen.getSelectedItem().toString());
        ps.setInt(4, Integer.parseInt(tf_id_karyawan.getText())); // Use the correct field for karyawan ID
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Karyawan data updated successfully");
        loadKaryawanData();
    } catch (SQLException e) {
        System.out.println("Error updating Karyawan data: " + e.getMessage());
    }

}
private void updateProyekData() {
    try {
        String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_nama_proyek.getText()); // Mengisi nama proyek
        int durasi = Integer.parseInt(tf_durasi.getText()); // Mengonversi durasi ke integer
        ps.setInt(2, durasi); // Mengisi durasi pengerjaan
        ps.setInt(3, Integer.parseInt(id_proyek.getText())); // Mengisi ID proyek untuk kondisi WHERE
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data proyek berhasil diperbarui");
        loadProyekData();
    } catch (SQLException e) {
        System.out.println("Error updating Karyawan data: " + e.getMessage());
    }
}

private void deleteKaryawanData() {
        try  {
            String sql = "DELETE FROM karyawan WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(tf_id_karyawan.getText()));
            ps.executeUpdate();
            conn.prepareStatement("SET @count = 0;").execute();
            conn.prepareStatement("UPDATE karyawan SET id = @count := @count + 1;").executeUpdate();
            conn.prepareStatement("ALTER TABLE karyawan AUTO_INCREMENT = 1;").execute();
            JOptionPane.showMessageDialog(this, "Data deleted successfully");
            loadKaryawanData();
            idkaryawan();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }

}
private void deleteProyekData() {
    try  {
            String sql = "DELETE FROM proyek WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id_proyek.getText()));
            ps.executeUpdate();
            conn.prepareStatement("SET @count = 0;").execute();
            conn.prepareStatement("UPDATE proyek SET id = @count := @count + 1;").executeUpdate();
            conn.prepareStatement("ALTER TABLE proyek AUTO_INCREMENT = 1;").execute();
            JOptionPane.showMessageDialog(this, "Data deleted successfully");
            loadProyekData();
            idproyek();
    } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_id_karyawan = new javax.swing.JTextField();
        tf_nama = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cb_jabatan = new javax.swing.JComboBox<>();
        cb_departemen = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        tambah_karyawan = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete_karyawan = new javax.swing.JButton();
        exit_karyawan = new javax.swing.JButton();
        reset_karyawan = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        id_proyek = new javax.swing.JTextField();
        tf_nama_proyek = new javax.swing.JTextField();
        tf_durasi = new javax.swing.JTextField();
        tambah_proyek = new javax.swing.JButton();
        edit_proyek = new javax.swing.JButton();
        delete_proyek = new javax.swing.JButton();
        reset_proyek = new javax.swing.JButton();
        exit_proyek = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tf_peran = new javax.swing.JTextField();
        cbWork = new javax.swing.JComboBox<>();
        cbProj = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        tambah_transaksi = new javax.swing.JButton();
        edit_transaksi = new javax.swing.JButton();
        delete_transaksi = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        reset_transaksi = new javax.swing.JButton();
        exit_transaksi = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane5.setBackground(new java.awt.Color(153, 204, 0));
        jTabbedPane5.setFont(new java.awt.Font("Stencil", 1, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(102, 102, 0));

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel1.setText("DATA KARYAWAN");

        tbl_karyawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NAMA", "JABATAN", "DEPARTEMEN"
            }
        ));
        jScrollPane4.setViewportView(tbl_karyawan);

        jPanel3.setBackground(new java.awt.Color(153, 153, 0));

        jLabel2.setText("ID :");

        jLabel3.setText("NAMA :");

        jLabel4.setText("JABATAN :");

        jLabel5.setText("DEPARTEMEN :");

        tf_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_namaActionPerformed(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Pictures\\img\\batu2.png")); // NOI18N
        jLabel15.setText("jLabel15");

        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Pictures\\img\\batu2.png")); // NOI18N
        jLabel16.setText("jLabel15");

        jLabel17.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Pictures\\img\\batu2.png")); // NOI18N
        jLabel17.setText("jLabel15");

        cb_jabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--pilih--", "manager", "staff", "supervisor" }));

        cb_departemen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--pilih departemen--", "keuangan", "operasional", "pemasaran" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_nama)
                            .addComponent(cb_jabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_departemen, 0, 231, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_id_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_id_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cb_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_departemen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Pictures\\img\\perusahaan.png")); // NOI18N

        jPanel6.setBackground(new java.awt.Color(153, 153, 0));

        tambah_karyawan.setText("TAMBAH");
        tambah_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah_karyawanActionPerformed(evt);
            }
        });
        jPanel6.add(tambah_karyawan);

        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel6.add(edit);

        delete_karyawan.setText("DELETE");
        delete_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_karyawanActionPerformed(evt);
            }
        });
        jPanel6.add(delete_karyawan);

        exit_karyawan.setText("EXIT");
        exit_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_karyawanActionPerformed(evt);
            }
        });
        jPanel6.add(exit_karyawan);

        reset_karyawan.setText("RESET");
        reset_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_karyawanActionPerformed(evt);
            }
        });
        jPanel6.add(reset_karyawan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)))
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("karyawan", jPanel2);

        jPanel4.setBackground(new java.awt.Color(102, 102, 0));

        jLabel6.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        jLabel6.setText("data proyek");

        jPanel8.setBackground(new java.awt.Color(153, 153, 0));

        jLabel11.setText("ID:");

        jLabel12.setText("NAMA PROYEK:");

        jLabel13.setText("DURASI PENGERJAAN:");

        id_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_proyekActionPerformed(evt);
            }
        });

        tf_nama_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nama_proyekActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(id_proyek, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(tf_nama_proyek)
                            .addComponent(tf_durasi)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel11))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 77, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(72, 72, 72))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_nama_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_durasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tambah_proyek.setText("TAMBAH");
        tambah_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah_proyekActionPerformed(evt);
            }
        });

        edit_proyek.setText("EDIT");
        edit_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_proyekActionPerformed(evt);
            }
        });

        delete_proyek.setText("DELETE");
        delete_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_proyekActionPerformed(evt);
            }
        });

        reset_proyek.setText("RESET");
        reset_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_proyekActionPerformed(evt);
            }
        });

        exit_proyek.setText("EXIT");
        exit_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_proyekActionPerformed(evt);
            }
        });

        tbl_proyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "NAMA PROYEK", "DURASI PENGERJAAN"
            }
        ));
        jScrollPane5.setViewportView(tbl_proyek);

        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Pictures\\img\\batu2.png")); // NOI18N

        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Pictures\\img\\perusahaan.png")); // NOI18N

        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Pictures\\img\\batu2.png")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edit_proyek)
                            .addComponent(delete_proyek)
                            .addComponent(tambah_proyek))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(exit_proyek)
                                    .addComponent(reset_proyek))))
                        .addGap(38, 38, 38))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(tambah_proyek)
                        .addGap(2, 2, 2)
                        .addComponent(reset_proyek)
                        .addGap(18, 18, 18)
                        .addComponent(edit_proyek)
                        .addGap(22, 22, 22)
                        .addComponent(exit_proyek)
                        .addGap(4, 4, 4)
                        .addComponent(delete_proyek)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane5.addTab("proyek", jPanel4);

        jPanel5.setBackground(new java.awt.Color(102, 102, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel7.setText("data transaksi");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 0));

        jLabel8.setText("ID KARYAWAN:");

        jLabel9.setText("ID PROYEK :");

        jLabel10.setText("PERAN:");

        cbWork.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pilih--", " " }));
        cbWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbWorkActionPerformed(evt);
            }
        });

        cbProj.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pilih--", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(109, 109, 109))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(124, 124, 124))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_peran, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbWork, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbProj, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbWork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(9, 9, 9)
                .addComponent(cbProj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_peran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 300, 170));

        jPanel7.setLayout(new java.awt.GridLayout(3, 1));

        tambah_transaksi.setText("TAMBAH");
        tambah_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah_transaksiActionPerformed(evt);
            }
        });
        jPanel7.add(tambah_transaksi);

        edit_transaksi.setText("EDIT");
        edit_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_transaksiActionPerformed(evt);
            }
        });
        jPanel7.add(edit_transaksi);

        delete_transaksi.setText("DELETE");
        delete_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_transaksiActionPerformed(evt);
            }
        });
        jPanel7.add(delete_transaksi);

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 140, 150));

        jPanel9.setLayout(new java.awt.GridLayout(2, 1));

        reset_transaksi.setText("RESET");
        jPanel9.add(reset_transaksi);

        exit_transaksi.setText("EXIT");
        exit_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_transaksiActionPerformed(evt);
            }
        });
        jPanel9.add(exit_transaksi);

        jPanel5.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, -1, 150));

        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Pictures\\img\\batu2.png")); // NOI18N
        jLabel21.setText("jLabel21");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 80, 40));

        jLabel22.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Pictures\\img\\batu2.png")); // NOI18N
        jLabel22.setText("jLabel22");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, 80, 40));

        jLabel23.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Pictures\\img\\kaktus.png")); // NOI18N
        jLabel23.setText("jLabel23");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 70, 50));

        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID KARYAWAN", "ID PROYEK", "PERAN"
            }
        ));
        jScrollPane3.setViewportView(tbl_transaksi);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 230));

        jTabbedPane5.addTab("transaksi", jPanel5);

        getContentPane().add(jTabbedPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_namaActionPerformed
      
    }//GEN-LAST:event_tf_namaActionPerformed

    private void tambah_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_karyawanActionPerformed
    if (tf_nama.getText().trim().isEmpty() ||
        cb_jabatan.getSelectedItem() == null ||
        cb_departemen.getSelectedItem() == null) { 
            JOptionPane.showMessageDialog(null, "Harap isi semua data yang diperlukan untuk menambahkan karyawan", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            saveKaryawanData(); 
        }
    }//GEN-LAST:event_tambah_karyawanActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        if (tf_nama.getText().trim().isEmpty() ||
            cb_jabatan.getSelectedItem() == null ||
            cb_departemen.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin memperbarui data karyawan dengan ID " + tf_id_karyawan.getText() + "?", "Konfirmasi Pembaruan", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                updateKaryawanData(); // Memanggil metode updateKaryawanData
            }
        }
    }//GEN-LAST:event_editActionPerformed

    private void delete_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_karyawanActionPerformed
        if (tf_id_karyawan.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap isi ID karyawan yang ingin dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus karyawan dengan ID " + tf_id_karyawan.getText() + "?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                deleteKaryawanData(); // Memanggil metode deleteKaryawanData
            }
        }
    }//GEN-LAST:event_delete_karyawanActionPerformed

    private void edit_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_transaksiActionPerformed
        if (tbl_transaksi.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "THERE IS NO DATA", "DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else{
         try {
            String sql = "SELECT peran FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cbWork.getSelectedItem().toString());
            ps.setString(2, cbProj.getSelectedItem().toString());
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "THERE IS NO DATA", "DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String role = tf_peran.getText().isEmpty() ? rs.getString("peran") : tf_peran.getText();
            String upsql = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement upps = conn.prepareStatement(upsql);
            upps.setString(1, role);
            upps.setString(2, cbWork.getSelectedItem().toString());
            upps.setString(3, cbProj.getSelectedItem().toString());
            upps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data saved successfully");
            loadTransaksiData();
    } catch (SQLException e) {
        System.out.println("Error updating data: " + e.getMessage());
    }
     }     
    }//GEN-LAST:event_edit_transaksiActionPerformed

    private void exit_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_karyawanActionPerformed
       System.exit(0);
    }//GEN-LAST:event_exit_karyawanActionPerformed

    private void reset_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_karyawanActionPerformed
      tf_id_karyawan.setText("");
      tf_nama.setText("");
      cb_jabatan.setSelectedIndex(0); // Mengatur ke item pertama pada ComboBox jabatan
      cb_departemen.setSelectedIndex(0); 
    }//GEN-LAST:event_reset_karyawanActionPerformed

    private void reset_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_proyekActionPerformed
      id_proyek.setText("");
      tf_nama_proyek.setText("");  
      tf_durasi.setText("");  
    }//GEN-LAST:event_reset_proyekActionPerformed

    private void tambah_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_proyekActionPerformed
        if (tf_nama_proyek.getText().trim().isEmpty()||
           tf_durasi.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(null, "Harap isi semua data yang diperlukan untuk menambahkan proyek", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
        saveProyekData(); // Memanggil metode tambahProyekData jika semua data sudah terisi
}
    }//GEN-LAST:event_tambah_proyekActionPerformed

    private void tf_nama_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nama_proyekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nama_proyekActionPerformed

    private void id_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_proyekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_proyekActionPerformed

    private void edit_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_proyekActionPerformed

    if (id_proyek.getText().trim().isEmpty() ||
        tf_durasi.getText().trim().isEmpty() ||
        tf_nama_proyek.getText().trim().isEmpty()) {
           JOptionPane.showMessageDialog(null, "Harap isi semua data yang diperlukan untuk memperbarui proyek", "Peringatan", JOptionPane.WARNING_MESSAGE);
    } else {
        updateProyekData(); // Memanggil metode updateProyekData jika semua data sudah terisi
    }
    }//GEN-LAST:event_edit_proyekActionPerformed

    private void delete_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_proyekActionPerformed
       if (id_proyek.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap isi ID karyawan yang ingin dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            // Konfirmasi sebelum menghapus
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus karyawan dengan ID " + id_proyek.getText() + "?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                deleteProyekData(); // Memanggil metode deleteKaryawanData
            }
        }
    }//GEN-LAST:event_delete_proyekActionPerformed

    private void exit_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_proyekActionPerformed
       System.exit(0);
    }//GEN-LAST:event_exit_proyekActionPerformed

    private void tambah_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_transaksiActionPerformed
  if(tf_peran.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"PLEASE FILL IN THE BLANKS","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else{
            try{
                String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, cbWork.getSelectedItem().toString());
                ps.setString(2, cbProj.getSelectedItem().toString());
                ps.setString(3, tf_peran.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data saved successfully");
                loadTransaksiData();
            } catch (SQLException e) {
                System.out.println("Error Save Data" + e.getMessage());
            }
        }    
    }//GEN-LAST:event_tambah_transaksiActionPerformed

    private void exit_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_transaksiActionPerformed
         System.exit(0);
    }//GEN-LAST:event_exit_transaksiActionPerformed

    private void delete_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_transaksiActionPerformed
    try {
        // Get the selected names
        String selectedKaryawan = cbWork.getSelectedItem().toString();
        String selectedProyek = cbProj.getSelectedItem().toString();

        // Retrieve the corresponding ID for karyawan
        String sqlKaryawan = "SELECT id FROM karyawan WHERE nama = ?";
        PreparedStatement psKaryawan = conn.prepareStatement(sqlKaryawan);
        psKaryawan.setString(1, selectedKaryawan);
        ResultSet rsKaryawan = psKaryawan.executeQuery();
        int karyawanId = -1;

        if (rsKaryawan.next()) {
            karyawanId = rsKaryawan.getInt("id"); // Get the integer ID
        } else {
            JOptionPane.showMessageDialog(this, "Karyawan not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit if not found
        }

        // Retrieve the corresponding ID for proyek
        String sqlProyek = "SELECT id FROM proyek WHERE nama_proyek = ?";
        PreparedStatement psProyek = conn.prepareStatement(sqlProyek);
        psProyek.setString(1, selectedProyek);
        ResultSet rsProyek = psProyek.executeQuery();
        int proyekId = -1;

        if (rsProyek.next()) {
            proyekId = rsProyek.getInt("id"); // Get the integer ID
        } else {
            JOptionPane.showMessageDialog(this, "Proyek not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit if not found
        }

        // Debug: Print the IDs being used for deletion
        System.out.println("Deleting transaction with Proyek ID: " + proyekId + " and Karyawan ID: " + karyawanId);

        // Now perform the DELETE operation using the retrieved IDs
        String sqlDelete = "DELETE FROM transaksi WHERE id_proyek = ? AND id_karyawan = ?";
        PreparedStatement psDelete = conn.prepareStatement(sqlDelete);
        psDelete.setInt(1, proyekId); // Use the integer ID
        psDelete.setInt(2, karyawanId); // Use the integer ID
        int rowsAffected = psDelete.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Data deleted successfully");
        } else {
            JOptionPane.showMessageDialog(this, "No matching record found to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        loadProyekData(); // Reload the data if necessary

    } catch (SQLException e) {
        System.out.println("Error Save Data: " + e.getMessage());
    }
    }//GEN-LAST:event_delete_transaksiActionPerformed

    private void cbWorkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbWorkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbWorkActionPerformed

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
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Karyawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbProj;
    private javax.swing.JComboBox<String> cbWork;
    private javax.swing.JComboBox<String> cb_departemen;
    private javax.swing.JComboBox<String> cb_jabatan;
    private javax.swing.JButton delete_karyawan;
    private javax.swing.JButton delete_proyek;
    private javax.swing.JButton delete_transaksi;
    private javax.swing.JButton edit;
    private javax.swing.JButton edit_proyek;
    private javax.swing.JButton edit_transaksi;
    private javax.swing.JButton exit_karyawan;
    private javax.swing.JButton exit_proyek;
    private javax.swing.JButton exit_transaksi;
    private javax.swing.JTextField id_proyek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton reset_karyawan;
    private javax.swing.JButton reset_proyek;
    private javax.swing.JButton reset_transaksi;
    private javax.swing.JButton tambah_karyawan;
    private javax.swing.JButton tambah_proyek;
    private javax.swing.JButton tambah_transaksi;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTextField tf_durasi;
    private javax.swing.JTextField tf_id_karyawan;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_nama_proyek;
    private javax.swing.JTextField tf_peran;
    // End of variables declaration//GEN-END:variables
}
