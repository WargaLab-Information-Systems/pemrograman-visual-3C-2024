/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tugasmodullimaa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

 /*
 * @author Sesilia Febi
 */
public class main extends javax.swing.JFrame {
    Connection conn;
    private  DefaultTableModel model;
    private  DefaultTableModel model2;
    private  DefaultTableModel model3;
    
    
    
    /**
     * Creates new form main
     */
    public main() {
        initComponents();
        conn = koneksi.getConnection();
        
        model = new DefaultTableModel();
        tbl_karyawan.setModel(model);
        model.addColumn("ID KARYAWAN");
        model.addColumn("NAMA");
        model.addColumn("JABATAN");
        model.addColumn("DEPATERMEN");
        loadDatakaryawan();
        
        model2 = new DefaultTableModel();
        tbl_proyek.setModel(model2);
        model2.addColumn("ID PROYEK");
        model2.addColumn("NAMA PROYEK ");
        model2.addColumn("DURASI PENGERJAAN");
        loadDataproyek();
        
        model3 = new DefaultTableModel();
        tbl_transaksi.setModel(model3);
        model3.addColumn("ID KARYAWAN");
        model3.addColumn("ID PROYEK ");
        model3.addColumn("PERAN");
        loadDatatransaksi();
    }
    
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

     private void loadDataproyek() {
      model2.setRowCount(0);

      try {
          String sql = "SELECT * FROM proyek";
           PreparedStatement ps = conn.prepareStatement(sql);//menyiapkan query
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             model2.addRow(new Object[]{
             rs.getInt("id"),
             rs.getString("nama_proyek"),
             rs.getInt("durasi_pengerjaan")
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }

     private void loadDatatransaksi() {
      model3.setRowCount(0);

    String proyek= "SELECT id, Nama_Proyek FROM proyek"; 
    String karyawan = "SELECT id, Nama FROM karyawan"; 
    cmb_idkaryawan.removeAllItems();
    cmb_idproyek.removeAllItems();
    try (PreparedStatement psProyek = conn.prepareStatement(proyek);
         ResultSet rsProyek = psProyek.executeQuery()) {

        while (rsProyek.next()) {
            String namaProyek = rsProyek.getString("id"); 
            cmb_idproyek.addItem(namaProyek);
        }
    } catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
    }

    try (PreparedStatement psKaryawan = conn.prepareStatement(karyawan);
         ResultSet rsKaryawan = psKaryawan.executeQuery()) {

        while (rsKaryawan.next()) {
            String namaKaryawan = rsKaryawan.getString("id"); // Ganti nama kolom sesuai tabel
            cmb_idkaryawan.addItem(namaKaryawan);
        }
    } catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
    }
    try {
          String sql = "SELECT * FROM transaksi";
           PreparedStatement ps = conn.prepareStatement(sql);//menyiapkan query
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             model3.addRow(new Object[]{
             rs.getInt("id_karyawan"),
             rs.getInt("id_proyek"),
             rs.getString("peran")
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }

     //Simpan Data
    private void saveDatakaryawan() {
       String idKaryawanStr = txtidkaryawan.getText().trim(); // Menghapus spasi di awal dan akhir
String nama = txtnama.getText().trim();
String jabatan = txtjabatan.getText().trim();
String departemen = txtdepartemen.getText().trim();

// Cek apakah ada field yang kosong atau hanya terdiri dari spasi
if (idKaryawanStr.isEmpty() || nama.isEmpty() || jabatan.isEmpty() || departemen.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Isi dulu formnya", "Peringatan", JOptionPane.WARNING_MESSAGE);
    return; // Keluar dari method jika ada field yang kosong
}

try {
    // Parsing input yang diharapkan
    int idKaryawan = Integer.parseInt(idKaryawanStr);

    // Siapkan pernyataan SQL untuk menyimpan data
    String sql = "INSERT INTO karyawan (id, nama, jabatan, departemen) VALUES (?, ?, ?, ?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, idKaryawan);
    ps.setString(2, nama);
    ps.setString(3, jabatan);
    ps.setString(4, departemen);

    // Eksekusi pernyataan untuk menyimpan data ke dalam basis data
    ps.executeUpdate();

    // Tampilkan pesan sukses
    JOptionPane.showMessageDialog(this, "Data saved successfully");
    
    // Memuat data setelah penyimpanan
    loadDatakaryawan();
} catch (NumberFormatException e) {
    // Menangani kesalahan jika input tidak dapat diparse menjadi integer
    JOptionPane.showMessageDialog(this, "Masukkan ID yang valid untuk Karyawan", "Error", JOptionPane.ERROR_MESSAGE);
} catch (SQLException e) {
    // Menangani kesalahan SQL
    System.out.println("Error Save Data: " + e.getMessage());
    JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data", "Error", JOptionPane.ERROR_MESSAGE);
}
     }
    
     private void saveDataproyek() {
         
      String idProyekStr = txtidproyek.getText().trim(); // Menghapus spasi di awal dan akhir
    String namaProyek = txtnama1.getText().trim();
    String durasiStr = txtdurasi.getText().trim();

    // Cek apakah ada field yang kosong atau hanya terdiri dari spasi
    if (idProyekStr.isEmpty() || namaProyek.isEmpty() || durasiStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Isi dulu formnya", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; // Keluar dari method jika ada field yang kosong
    }

    try {
        // Parsing input yang diharapkan
        int idProyek = Integer.parseInt(idProyekStr);
        int durasi = Integer.parseInt(durasiStr);

        // Siapkan pernyataan SQL untuk menyimpan data
        String sql = "INSERT INTO proyek (id, nama_proyek, durasi_pengerjaan) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idProyek);
        ps.setString(2, namaProyek);
        ps.setInt(3, durasi);

        // Eksekusi pernyataan untuk menyimpan data ke dalam basis data
        ps.executeUpdate();

        // Tampilkan pesan sukses
        JOptionPane.showMessageDialog(this, "Data saved successfully");
        
        // Memuat data setelah penyimpanan
        loadDataproyek();
        loadDatatransaksi();
    } catch (NumberFormatException e) {
        // Menangani kesalahan jika input tidak dapat diparse menjadi integer
        JOptionPane.showMessageDialog(this, "Masukkan angka yang valid untuk ID dan Durasi", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        // Menangani kesalahan SQL
        System.out.println("Error Save Data: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data", "Error", JOptionPane.ERROR_MESSAGE);
    }
     }
     
     private void saveDatatransaksi() {
        String idKaryawanStr = cmb_idkaryawan.getSelectedItem().toString().trim(); // Menghapus spasi di awal dan akhir
    String idProyekStr = cmb_idproyek.getSelectedItem().toString().trim();
    String peran = txtperan.getText().trim();

    // Cek apakah ada field yang kosong atau hanya terdiri dari spasi
    if (idKaryawanStr.isEmpty() || idProyekStr.isEmpty() || peran.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Isi dulu formnya", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; // Keluar dari method jika ada field yang kosong
    }

    try {
        // Parsing input yang diharapkan
        int idKaryawan = Integer.parseInt(idKaryawanStr);
        int idProyek = Integer.parseInt(idProyekStr);

        // Siapkan pernyataan SQL untuk menyimpan data
        String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idKaryawan);
        ps.setInt(2, idProyek);
        ps.setString(3, peran);

        // Eksekusi pernyataan untuk menyimpan data ke dalam basis data
        ps.executeUpdate();

        // Tampilkan pesan sukses
        JOptionPane.showMessageDialog(this, "Data saved successfully");
        
        // Memuat data setelah penyimpanan
        loadDatatransaksi();
    } catch (NumberFormatException e) {
        // Menangani kesalahan jika input tidak dapat diparse menjadi integer
        JOptionPane.showMessageDialog(this, "Masukkan ID yang valid untuk Karyawan dan Proyek", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        // Menangani kesalahan SQL
        System.out.println("Error Save Data: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data", "Error", JOptionPane.ERROR_MESSAGE);
    }
     }
     
      //Update Data
    private void updateDatakaryawan() {
      try {
          String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ?WHERE id = ?";
          
          PreparedStatement ps = conn.prepareStatement(sql);//pelingdung untuk si query
          
          ps.setString(1, txtnama.getText());
          ps.setString(2, txtjabatan.getText());
          ps.setString(3, txtdepartemen.getText());
          ps.setInt(4, Integer.parseInt(txtidkaryawan.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data updated successfully");
          loadDatakaryawan();
          
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
     }
    
    private void updateDataproyek() {
      try {
          String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ?WHERE id = ?";
          
          PreparedStatement ps = conn.prepareStatement(sql);//pelingdung untuk si query
          ps.setInt(1, Integer.parseInt((String)txtidproyek.getText()));
          ps.setString(2, txtnama1.getText());
          ps.setInt(3, Integer.parseInt((String) txtdurasi.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data updated successfully");
          loadDataproyek();
          loadDatatransaksi();
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
     }
    
    private void updateDatatransaksi() {
       try {
          String sql = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ? ";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1,txtperan.getText());
          ps.setInt(2, Integer.parseInt((String) cmb_idkaryawan.getSelectedItem()));
          ps.setInt(3, Integer.parseInt((String) cmb_idproyek.getSelectedItem()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data updated successfully");
          loadDatatransaksi();
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }

     }
    
     //Delete Data
    private void deleteDatakaryawan() {
     int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus karyawan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    
    // Jika pengguna memilih 'Ya', lanjutkan dengan penghapusan
    if (response == JOptionPane.YES_OPTION) {
        try {
            String sql = "DELETE FROM karyawan WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txtidkaryawan.getText()));
            
            // Eksekusi pernyataan untuk menghapus data
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data deleted successfully");
            
            // Memuat ulang data setelah penghapusan
            loadDatakaryawan();
        } catch (SQLException e) {
            System.out.println("Error Delete Data: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            // Menangani kesalahan jika input tidak dapat diparse menjadi integer
            JOptionPane.showMessageDialog(this, "ID karyawan tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        // Jika pengguna memilih 'Tidak', tidak melakukan apa-apa
        JOptionPane.showMessageDialog(this, "Penghapusan karyawan dibatalkan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }
    }
    
     private void deleteDataproyek() {
      int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus proyek ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    
    // Jika pengguna memilih 'Ya', lanjutkan dengan penghapusan
    if (response == JOptionPane.YES_OPTION) {
        try {
            String sql = "DELETE FROM proyek WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txtidproyek.getText()));
            
            // Eksekusi pernyataan untuk menghapus data
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data deleted successfully");
            
            // Memuat ulang data setelah penghapusan
            loadDataproyek();
            loadDatatransaksi();
        } catch (SQLException e) {
            System.out.println("Error Delete Data: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            // Menangani kesalahan jika input tidak dapat diparse menjadi integer
            JOptionPane.showMessageDialog(this, "ID proyek tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        // Jika pengguna memilih 'Tidak', tidak melakukan apa-apa
        JOptionPane.showMessageDialog(this, "Penghapusan proyek dibatalkan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }
    }
     
     private void deleteDatatransaksi() {
     int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    
    // Jika pengguna memilih 'Ya', lanjutkan dengan penghapusan
    if (response == JOptionPane.YES_OPTION) {
        try {
            String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt((String) cmb_idkaryawan.getSelectedItem()));
            ps.setInt(2, Integer.parseInt((String) cmb_idproyek.getSelectedItem()));
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data deleted successfully");
            loadDatatransaksi();
        } catch (SQLException e) {
            System.out.println("Error Delete Data: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            // Menangani kesalahan jika input tidak dapat diparse menjadi integer
            JOptionPane.showMessageDialog(this, "ID yang dipilih tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        // Jika pengguna memilih 'Tidak', tidak melakukan apa-apa
        JOptionPane.showMessageDialog(this, "Penghapusan data dibatalkan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtidkaryawan = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtjabatan = new javax.swing.JTextField();
        txtdepartemen = new javax.swing.JTextField();
        btnkeluar = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnupdate = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtidproyek = new javax.swing.JTextField();
        txtnama1 = new javax.swing.JTextField();
        txtdurasi = new javax.swing.JTextField();
        btnkeluar1 = new javax.swing.JButton();
        btndelete1 = new javax.swing.JButton();
        btnsimpan1 = new javax.swing.JButton();
        btnreset1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnupdate1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        txtperan = new javax.swing.JTextField();
        btnkeluar2 = new javax.swing.JButton();
        btndelete2 = new javax.swing.JButton();
        btnsimpan2 = new javax.swing.JButton();
        btnreset2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnupdate2 = new javax.swing.JButton();
        cmb_idkaryawan = new javax.swing.JComboBox<>();
        cmb_idproyek = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(102, 102, 102));
        jTabbedPane1.setForeground(new java.awt.Color(255, 153, 0));
        jTabbedPane1.setOpaque(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setLayout(null);

        txtidkaryawan.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.add(txtidkaryawan);
        txtidkaryawan.setBounds(140, 10, 340, 22);

        txtnama.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.add(txtnama);
        txtnama.setBounds(140, 40, 340, 20);

        txtjabatan.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.add(txtjabatan);
        txtjabatan.setBounds(140, 80, 340, 20);

        txtdepartemen.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.add(txtdepartemen);
        txtdepartemen.setBounds(140, 120, 340, 20);

        btnkeluar.setBackground(new java.awt.Color(102, 102, 102));
        btnkeluar.setText("Keluar");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });
        jPanel2.add(btnkeluar);
        btnkeluar.setBounds(150, 170, 72, 22);

        btndelete.setBackground(new java.awt.Color(102, 102, 102));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btndelete);
        btndelete.setBounds(230, 170, 72, 22);

        btnsimpan.setBackground(new java.awt.Color(102, 102, 102));
        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(btnsimpan);
        btnsimpan.setBounds(310, 170, 72, 22);

        btnreset.setBackground(new java.awt.Color(102, 102, 102));
        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        jPanel2.add(btnreset);
        btnreset.setBounds(390, 170, 72, 22);

        jLabel1.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("NAMA");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 40, 100, 20);

        jLabel2.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("JABATAN");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 80, 100, 20);

        jLabel3.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setText("DEPARTEMEN");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 120, 100, 20);

        jLabel4.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("ID KARYAWAN");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 10, 110, 16);

        btnupdate.setBackground(new java.awt.Color(102, 102, 102));
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnupdate);
        btnupdate.setBounds(70, 170, 75, 22);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 220));

        jPanel3.setLayout(new java.awt.GridLayout());

        tbl_karyawan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_karyawan);

        jPanel3.add(jScrollPane1);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 540, 330));

        jTabbedPane1.addTab("Form Karyawan", jPanel1);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 51, 102));
        jPanel5.setLayout(null);

        txtidproyek.setBackground(new java.awt.Color(0, 204, 204));
        jPanel5.add(txtidproyek);
        txtidproyek.setBounds(140, 10, 340, 22);

        txtnama1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel5.add(txtnama1);
        txtnama1.setBounds(140, 40, 340, 20);

        txtdurasi.setBackground(new java.awt.Color(0, 204, 204));
        jPanel5.add(txtdurasi);
        txtdurasi.setBounds(140, 80, 340, 20);

        btnkeluar1.setBackground(new java.awt.Color(102, 102, 102));
        btnkeluar1.setText("Keluar");
        btnkeluar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluar1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnkeluar1);
        btnkeluar1.setBounds(150, 170, 72, 22);

        btndelete1.setBackground(new java.awt.Color(102, 102, 102));
        btndelete1.setText("Delete");
        btndelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelete1ActionPerformed(evt);
            }
        });
        jPanel5.add(btndelete1);
        btndelete1.setBounds(230, 170, 72, 22);

        btnsimpan1.setBackground(new java.awt.Color(102, 102, 102));
        btnsimpan1.setText("Simpan");
        btnsimpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpan1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnsimpan1);
        btnsimpan1.setBounds(310, 170, 72, 22);

        btnreset1.setBackground(new java.awt.Color(102, 102, 102));
        btnreset1.setText("Reset");
        btnreset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreset1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnreset1);
        btnreset1.setBounds(390, 170, 72, 22);

        jLabel5.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setText("NAMA PROYEK");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(20, 40, 110, 20);

        jLabel6.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("DURASI");
        jPanel5.add(jLabel6);
        jLabel6.setBounds(20, 80, 110, 20);

        jLabel8.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 0));
        jLabel8.setText(" ID PROYEK");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(20, 10, 110, 16);

        btnupdate1.setBackground(new java.awt.Color(102, 102, 102));
        btnupdate1.setText("Update");
        btnupdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdate1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnupdate1);
        btnupdate1.setBounds(70, 170, 75, 22);

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 220));

        jPanel6.setLayout(new java.awt.GridLayout());

        tbl_proyek.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_proyek);

        jPanel6.add(jScrollPane2);

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 540, 330));

        jTabbedPane1.addTab("Form Proyek", jPanel4);

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(0, 51, 102));
        jPanel8.setLayout(null);

        txtperan.setBackground(new java.awt.Color(0, 204, 204));
        jPanel8.add(txtperan);
        txtperan.setBounds(140, 80, 340, 20);

        btnkeluar2.setBackground(new java.awt.Color(102, 102, 102));
        btnkeluar2.setText("Keluar");
        btnkeluar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluar2ActionPerformed(evt);
            }
        });
        jPanel8.add(btnkeluar2);
        btnkeluar2.setBounds(150, 170, 72, 22);

        btndelete2.setBackground(new java.awt.Color(102, 102, 102));
        btndelete2.setText("Delete");
        btndelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelete2ActionPerformed(evt);
            }
        });
        jPanel8.add(btndelete2);
        btndelete2.setBounds(230, 170, 72, 22);

        btnsimpan2.setBackground(new java.awt.Color(102, 102, 102));
        btnsimpan2.setText("Simpan");
        btnsimpan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpan2ActionPerformed(evt);
            }
        });
        jPanel8.add(btnsimpan2);
        btnsimpan2.setBounds(310, 170, 72, 22);

        btnreset2.setBackground(new java.awt.Color(102, 102, 102));
        btnreset2.setText("Reset");
        btnreset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreset2ActionPerformed(evt);
            }
        });
        jPanel8.add(btnreset2);
        btnreset2.setBounds(390, 170, 72, 22);

        jLabel9.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 0));
        jLabel9.setText("ID PROYEK");
        jPanel8.add(jLabel9);
        jLabel9.setBounds(20, 40, 100, 20);

        jLabel10.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 0));
        jLabel10.setText("PERAN");
        jPanel8.add(jLabel10);
        jLabel10.setBounds(20, 80, 90, 20);

        jLabel12.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 0));
        jLabel12.setText("ID KARYAWAN");
        jPanel8.add(jLabel12);
        jLabel12.setBounds(20, 10, 110, 16);

        btnupdate2.setBackground(new java.awt.Color(102, 102, 102));
        btnupdate2.setText("Update");
        btnupdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdate2ActionPerformed(evt);
            }
        });
        jPanel8.add(btnupdate2);
        btnupdate2.setBounds(70, 170, 75, 22);

        cmb_idkaryawan.setBackground(new java.awt.Color(0, 204, 204));
        jPanel8.add(cmb_idkaryawan);
        cmb_idkaryawan.setBounds(140, 10, 340, 22);

        cmb_idproyek.setBackground(new java.awt.Color(0, 204, 204));
        jPanel8.add(cmb_idproyek);
        cmb_idproyek.setBounds(140, 40, 340, 22);

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 220));

        jPanel9.setLayout(new java.awt.GridLayout());

        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbl_transaksi);

        jPanel9.add(jScrollPane3);

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 540, 330));

        jTabbedPane1.addTab("Form Transaksi", jPanel7);

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

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        saveDatakaryawan();
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        deleteDatakaryawan();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        txtidkaryawan.setText("");
        txtnama.setText("");
        txtjabatan.setText("");
        txtdepartemen.setText("");
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        updateDatakaryawan();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnsimpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpan1ActionPerformed
        // TODO add your handling code here:
        saveDataproyek();
    }//GEN-LAST:event_btnsimpan1ActionPerformed

    private void btndelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelete1ActionPerformed
        // TODO add your handling code here:
        deleteDataproyek();
    }//GEN-LAST:event_btndelete1ActionPerformed

    private void btnkeluar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluar1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnkeluar1ActionPerformed

    private void btnreset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreset1ActionPerformed
        // TODO add your handling code here:
        txtidproyek.setText("");
        txtnama1.setText("");
        txtdurasi.setText("");
    }//GEN-LAST:event_btnreset1ActionPerformed

    private void btnupdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdate1ActionPerformed
        // TODO add your handling code here:
        updateDataproyek();
    }//GEN-LAST:event_btnupdate1ActionPerformed

    private void btnupdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdate2ActionPerformed
        // TODO add your handling code here:
        updateDatatransaksi();
    }//GEN-LAST:event_btnupdate2ActionPerformed

    private void btnsimpan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpan2ActionPerformed
        // TODO add your handling code here:
        saveDatatransaksi();
    }//GEN-LAST:event_btnsimpan2ActionPerformed

    private void btnkeluar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluar2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnkeluar2ActionPerformed

    private void btnreset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreset2ActionPerformed
        // TODO add your handling code here:
        cmb_idkaryawan.setSelectedItem("");
        cmb_idproyek.setSelectedItem("");
        txtperan.setText("");
    }//GEN-LAST:event_btnreset2ActionPerformed

    private void btndelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelete2ActionPerformed
        // TODO add your handling code here:
        deleteDatatransaksi();
    }//GEN-LAST:event_btndelete2ActionPerformed

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btndelete1;
    private javax.swing.JButton btndelete2;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnkeluar1;
    private javax.swing.JButton btnkeluar2;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnreset1;
    private javax.swing.JButton btnreset2;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnsimpan1;
    private javax.swing.JButton btnsimpan2;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton btnupdate1;
    private javax.swing.JButton btnupdate2;
    private javax.swing.JComboBox<String> cmb_idkaryawan;
    private javax.swing.JComboBox<String> cmb_idproyek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTextField txtdepartemen;
    private javax.swing.JTextField txtdurasi;
    private javax.swing.JTextField txtidkaryawan;
    private javax.swing.JTextField txtidproyek;
    private javax.swing.JTextField txtjabatan;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnama1;
    private javax.swing.JTextField txtperan;
    // End of variables declaration//GEN-END:variables
}
