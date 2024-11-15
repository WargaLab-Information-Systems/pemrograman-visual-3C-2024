/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tugasmodullimaa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

 /*
 * @author izza
 */
public class main extends javax.swing.JFrame {
    Connection conn;
    //mengelola data dalam 3 table berbeda
    private  DefaultTableModel model;
    private  DefaultTableModel model2;
    private  DefaultTableModel model3;
    private ArrayList<Integer> idkaryawan = new ArrayList<>();
    private ArrayList<Integer> idproyek = new ArrayList<>();
    
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
//        
        model2 = new DefaultTableModel();
        tbl_proyek.setModel(model2);
        model2.addColumn("ID PROYEK");
        model2.addColumn("NAMA PROYEK ");
        model2.addColumn("DURASI PENGERJAAN");
//        
        model3 = new DefaultTableModel();
        tbl_transaksi.setModel(model3);
        model3.addColumn("ID KARYAWAN");
        model3.addColumn("Nama Karyawan");
        model3.addColumn("ID PROYEK ");
        model3.addColumn("Nama Proyek");
        model3.addColumn("PERAN");
        
        loadDatatransaksi();
        loadDataproyek();
//        loadData3();
        loadComboProyek();
        loadComboKaryawan();
    }
    
    private int getSelectedKaryawanId() {
        int selectedIndex = cmb_idProyek.getSelectedIndex();
        return selectedIndex >= 0 ? idkaryawan.get(selectedIndex) : -1;
    }

    private int getSelectedProyekId() {
        int selectedIndex = cmb_idproyek.getSelectedIndex();
        return selectedIndex >= 0 ? idproyek.get(selectedIndex) : -1;
    }
    
    private void loadComboKaryawan() {
    cmb_idKaryawan.removeAllItems(); // Clear all items in combobox
    cmb_idKaryawan.addItem("- Pilih Nama Karyawan -"); // Add default option
    
    idkaryawan.clear(); // Clear the list of IDs
    idkaryawan.add(-1); // Add a dummy ID for the default option
    
    try {
        String sql = "SELECT id, nama FROM karyawan";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nama = rs.getString("nama");

            idkaryawan.add(id); // Add the ID to the list
            cmb_idKaryawan.addItem(nama); // Add the name to the combo box
        }
    } catch (SQLException e) {
        System.out.println("Error loading karyawan data: " + e.getMessage());
    }

}

public void loadDatakaryawan(){
        model.setRowCount(0); // Clear any existing rows in the model
    try {
        // Ensure connection is established
        if (conn == null) {
            System.out.println("Database connection is not established.");
            return;
        }

        String query = "SELECT id, nama, jabatan, departemen FROM karyawan";
        java.sql.Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);


        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("nama"),
                rs.getString("jabatan"),
                rs.getString("departemen")
            });
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
    }
}

    private void loadComboProyek() {
//        cb_namaproyek.removeAllItems();
//        proyekIds.clear();
        cmb_idProyek.addItem("- Pilih Nama Proyek -");
        cmb_idproyek.removeAllItems(); // Menghapus semua item di combobox
        cmb_idproyek.addItem("- Pilih Nama Proyek -"); // Menambahkan opsi default
    
        idproyek.clear(); // Membersihkan daftar proyek
        idproyek.add(-1); // Tambahkan ID proyek dummy untuk opsi default

        try {
            String sql = "SELECT id, nama_proyek FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String namaProyek = rs.getString("nama_proyek");

                idproyek.add(id);
                cmb_idProyek.addItem(namaProyek);
            }
        } catch (SQLException e) {
            System.out.println("Error loading proyek data: " + e.getMessage());
        }
    }

    public void loadDataproyek() {
    model2.setRowCount(0); // Clear any existing rows in the model
    try {
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Database connection is not established.");
            return;
        }

        String query = "SELECT id, nama_proyek, durasi_pengerjaan FROM Proyek";
        java.sql.Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            model2.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("nama_proyek"),
                rs.getString("durasi_pengerjaan"),
            });
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
    }
}
    private String getKaryawanIdByName(String nama) {
         String idKaryawan = null;
         String sql = "SELECT id FROM karyawan WHERE nama = ?";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, nama);
             ResultSet rs = ps.executeQuery();
             if (rs.next()) {
                 idKaryawan = rs.getString("id");
             }
         } catch (SQLException e) {
             System.out.println("Error retrieving Karyawan ID: " + e.getMessage());
         }
         return idKaryawan;
     }
    private String getProyekIdByName(String nama) {
         String idProyek = null;
         String sql = "SELECT id FROM proyek WHERE nama_proyek = ?";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, nama);
             ResultSet rs = ps.executeQuery();
             if (rs.next()) {
                 idProyek = rs.getString("id");
             }
         } catch (SQLException e) {
             System.out.println("Error retrieving Karyawan ID: " + e.getMessage());
         }
         return idProyek;
     }
    private void saveTransaksi(String idKaryawan, String idProyek, String peran) {
//    String id_karyawan = (idKaryawan);
//    String id_proyek = (idProyek);
    String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, idKaryawan);
        ps.setString(2, idProyek);
        ps.setString(3, peran);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data saved successfully.");
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error saving data: " + e.getMessage());
    }
}

    private void loadDatatransaksi() {
      model3.setRowCount(0);
      
      try {
          String sql = """
            SELECT t.id_karyawan, k.nama AS nama, 
            t.id_proyek, p.nama_proyek, t.peran
            FROM transaksi t
            JOIN karyawan k ON t.id_karyawan = k.id
            JOIN proyek p ON t.id_proyek = p.id
        """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
           model3.addRow(new Object[]{
           rs.getString("id_karyawan"),
           rs.getString("nama"),
           rs.getString("id_proyek"),
           rs.getString("nama_proyek"),
           rs.getString("peran")
         });
        }
        } catch (SQLException e) {
         System.out.println("Error Save Datainij" + e.getMessage());
       }
    }
    
    //Simpan Data Karyawan
    private void TambahDataKaryawan(String id,String nama, String jabatan,String departemen) {
    if (txtnama.getText().isEmpty() || txtjabatan.getText().isEmpty() || txtdepartemen.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tolong lengkapi data karyawan!");
        return;
    }
    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menambahkan data karyawan?", "Konfirmasi Tambah", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "INSERT INTO karyawan (id, nama, jabatan, departemen ) VALUES (?,?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, nama);
            ps.setString(3, jabatan);
            ps.setString(4, departemen);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
//            loadData();
            loadDatakaryawan();
//            loadComboKaryawan();
//            resetForm();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
}
    //End Simpan Data Karyawan
    
    // Simpan Data Proyek
private void TambahDataProyek() {
    if (txtidproyek.getText().isEmpty() || txtdurasi.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tolong lengkapi data proyek!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menambahkan data proyek?", "Konfirmasi Tambah", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "INSERT INTO proyek (id,nama_proyek,durasi_pengerjaan) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            // Set nama proyek
            ps.setString(1, txtidproyek.getText());
            ps.setString(2, txtnama1.getText());
            
            // Mengonversi durasi menjadi integer jika diperlukan
            try {
                int durasi = Integer.parseInt(txtdurasi.getText());
                ps.setInt(3, durasi);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Durasi harus berupa angka.");
                return;  // Berhenti jika durasi tidak valid
            }
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
            loadDataproyek();
            //loadComboProyek();
            //resetForm();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error Save Data proyek: " + e.getMessage());
        }
    }
}
// End Simpan Data Proyek

    
    //Simpan Data Transaksi
    private void TambahDataTransaksi() {
    int karyawanId = getSelectedKaryawanId();
    int proyekId = getSelectedProyekId();
    String peran = txtperan.getText();
    
    if (karyawanId == -1 || proyekId == -1 || peran.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Isi Terlebih Dahulu Bagian Yang Kosong!!!");
        return;
    }

    try {
        String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, karyawanId);
        ps.setInt(2, proyekId);
        ps.setString(3, peran);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
        loadData3(); 
        resetForm();
        } catch (SQLException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }
    //End Simpan Data Transaksi
    
    //Update Data Karyawan
    private void UbahDataKaryawan() {
    if (txtnama.getText().isEmpty() || txtjabatan.getText().isEmpty() || txtdepartemen.getText().isEmpty() || txtidkaryawan.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tolong lengkapi data karyawan yang akan diubah!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin mengubah data karyawan?", "Konfirmasi Ubah", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtnama.getText());
            ps.setString(2, txtjabatan.getText());
            ps.setString(3, txtdepartemen.getText());
            ps.setInt(4, Integer.parseInt(txtidkaryawan.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
            loadData();
            resetForm();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
}
    //End Update Data Karyawan
  
    //Update Data Proyek
    private void UbahDataProyek() {
    if (txtnama1.getText().isEmpty() || txtdurasi.getText().isEmpty() || txtidproyek.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tolong lengkapi data proyek yang akan diubah!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin mengubah data proyek?", "Konfirmasi Ubah", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtnama1.getText());
            ps.setString(2, txtdurasi.getText());
            ps.setInt(3, Integer.parseInt(txtidproyek.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
            loadData2();
            resetForm();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
}
    //End Update Data Proyek
    
    //Update Data Transaksi
    private void UbahDataTransaksi() {
    int karyawanId = getSelectedKaryawanId();
    int proyekId = getSelectedProyekId();
    String peran = txtperan.getText();

    if (karyawanId == -1 || proyekId == -1 || peran.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tolong lengkapi data transaksi yang akan diubah!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin mengubah data transaksi?", "Konfirmasi Ubah", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, peran);
            ps.setInt(2, karyawanId);
            ps.setInt(3, proyekId);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
                loadData3();
                resetForm();
            } else {
                JOptionPane.showMessageDialog(this, "Update Gagal");
            }
        } catch (SQLException e) {
            System.out.println("Error updating transaction: " + e.getMessage());
        }
    }
}
    //End Update Transaksi
    
    //Delete Data Karyawan
    private void HapusDataKaryawan() {
    if (txtidkaryawan.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tolong pilih karyawan yang akan dihapus!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data karyawan?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "DELETE FROM karyawan WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txtidkaryawan.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
            loadData();
            resetForm();
        } catch (SQLException e) {
            System.out.println("Error deleting karyawan: " + e.getMessage());
        }
    }
}
    //End Delete Data Karyawan
    
     //Delete Data Proyek
    private void HapusDataProyek() {
    if (txtidproyek.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tolong pilih proyek yang akan dihapus!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data proyek?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "DELETE FROM proyek WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txtidproyek.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
            loadData2();
            resetForm();
        } catch (SQLException e) {
            System.out.println("Error deleting proyek: " + e.getMessage());
        }
    }
}
    //End Delete Data Proyek
    
    //Delete Data Transaksi
    private void HapusDataTransaksi() {
    int cmb_idkaryawan = getSelectedKaryawanId();
    int cmb_idproyek = getSelectedProyekId();

    if (cmb_idkaryawan == -1 || cmb_idproyek == -1) {
        JOptionPane.showMessageDialog(this, "Tolong pilih transaksi yang akan dihapus!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data transaksi?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cmb_idkaryawan);
            ps.setInt(2, cmb_idproyek);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
                loadData3();
                resetForm();
            } else {
                JOptionPane.showMessageDialog(this, "Data Gagal Dihapus");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting transaction: " + e.getMessage());
        }
    }
}
    //End Delete Data Transaksi
     
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmb_idproyek = new javax.swing.JComboBox<>();
        tp1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtidkaryawan = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtjabatan = new javax.swing.JTextField();
        txtdepartemen = new javax.swing.JTextField();
        btndeletekyw = new javax.swing.JButton();
        btnsimpankyw = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btneditkyw = new javax.swing.JButton();
        btnupdatekyw = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtidproyek = new javax.swing.JTextField();
        txtnama1 = new javax.swing.JTextField();
        txtdurasi = new javax.swing.JTextField();
        btndeletepro = new javax.swing.JButton();
        btnsimpanpro = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btneditpro = new javax.swing.JButton();
        btnupdatepro = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        txtperan = new javax.swing.JTextField();
        btndeletetran = new javax.swing.JButton();
        btnsimpantran = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmb_idProyek = new javax.swing.JComboBox<>();
        btnedittran = new javax.swing.JButton();
        btnupdatetran = new javax.swing.JButton();
        cmb_idKaryawan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tp1.setBackground(new java.awt.Color(255, 204, 204));
        tp1.setForeground(new java.awt.Color(255, 255, 255));
        tp1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        tp1.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 204));
        jPanel2.setLayout(null);
        jPanel2.add(txtidkaryawan);
        txtidkaryawan.setBounds(140, 2, 340, 30);
        jPanel2.add(txtnama);
        txtnama.setBounds(140, 40, 340, 30);
        jPanel2.add(txtjabatan);
        txtjabatan.setBounds(140, 80, 340, 30);
        jPanel2.add(txtdepartemen);
        txtdepartemen.setBounds(140, 120, 340, 30);

        btndeletekyw.setBackground(new java.awt.Color(204, 204, 255));
        btndeletekyw.setText("Delete");
        btndeletekyw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletekywActionPerformed(evt);
            }
        });
        jPanel2.add(btndeletekyw);
        btndeletekyw.setBounds(230, 170, 72, 23);

        btnsimpankyw.setBackground(new java.awt.Color(204, 204, 255));
        btnsimpankyw.setText("Simpan");
        btnsimpankyw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpankywActionPerformed(evt);
            }
        });
        jPanel2.add(btnsimpankyw);
        btnsimpankyw.setBounds(310, 170, 72, 23);

        jLabel1.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NAMA");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(30, 50, 100, 20);

        jLabel2.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("JABATAN");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 90, 100, 20);

        jLabel3.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DEPARTEMEN");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 130, 100, 20);

        jLabel4.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID KARYAWAN");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 10, 110, 16);

        btneditkyw.setBackground(new java.awt.Color(204, 204, 255));
        btneditkyw.setText("Edit");
        btneditkyw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditkywActionPerformed(evt);
            }
        });
        jPanel2.add(btneditkyw);
        btneditkyw.setBounds(150, 170, 72, 23);

        btnupdatekyw.setBackground(new java.awt.Color(204, 204, 255));
        btnupdatekyw.setText("Update");
        btnupdatekyw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdatekywActionPerformed(evt);
            }
        });
        jPanel2.add(btnupdatekyw);
        btnupdatekyw.setBounds(390, 170, 72, 23);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 220));

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

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

        tp1.addTab("Form Karyawan", jPanel1);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 153, 204));
        jPanel5.setLayout(null);
        jPanel5.add(txtidproyek);
        txtidproyek.setBounds(140, 10, 340, 30);
        jPanel5.add(txtnama1);
        txtnama1.setBounds(140, 50, 340, 30);
        jPanel5.add(txtdurasi);
        txtdurasi.setBounds(140, 90, 340, 30);

        btndeletepro.setBackground(new java.awt.Color(204, 204, 255));
        btndeletepro.setText("Delete");
        btndeletepro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteproActionPerformed(evt);
            }
        });
        jPanel5.add(btndeletepro);
        btndeletepro.setBounds(20, 190, 72, 23);

        btnsimpanpro.setBackground(new java.awt.Color(204, 204, 255));
        btnsimpanpro.setText("Simpan");
        btnsimpanpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanproActionPerformed(evt);
            }
        });
        jPanel5.add(btnsimpanpro);
        btnsimpanpro.setBounds(120, 170, 72, 23);

        jLabel5.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NAMA PROYEK");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(20, 60, 110, 20);

        jLabel6.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DURASI");
        jPanel5.add(jLabel6);
        jLabel6.setBounds(30, 100, 110, 20);

        jLabel8.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(" ID PROYEK");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(20, 20, 110, 16);

        btneditpro.setBackground(new java.awt.Color(204, 204, 255));
        btneditpro.setText("Edit");
        jPanel5.add(btneditpro);
        btneditpro.setBounds(20, 140, 75, 23);

        btnupdatepro.setText("Update");
        jPanel5.add(btnupdatepro);
        btnupdatepro.setBounds(200, 170, 72, 23);

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 220));

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

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

        tp1.addTab("Form Proyek", jPanel4);

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 153, 204));
        jPanel8.setLayout(null);
        jPanel8.add(txtperan);
        txtperan.setBounds(140, 90, 340, 30);

        btndeletetran.setBackground(new java.awt.Color(204, 204, 255));
        btndeletetran.setText("Delete");
        btndeletetran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletetranActionPerformed(evt);
            }
        });
        jPanel8.add(btndeletetran);
        btndeletetran.setBounds(20, 180, 72, 23);

        btnsimpantran.setBackground(new java.awt.Color(204, 204, 255));
        btnsimpantran.setText("Simpan");
        btnsimpantran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpantranActionPerformed(evt);
            }
        });
        jPanel8.add(btnsimpantran);
        btnsimpantran.setBounds(120, 140, 72, 23);

        jLabel9.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID PROYEK");
        jPanel8.add(jLabel9);
        jLabel9.setBounds(20, 60, 100, 20);

        jLabel10.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("PERAN");
        jPanel8.add(jLabel10);
        jLabel10.setBounds(20, 100, 90, 20);

        jLabel12.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ID KARYAWAN");
        jPanel8.add(jLabel12);
        jLabel12.setBounds(20, 20, 110, 16);

        jPanel8.add(cmb_idProyek);
        cmb_idProyek.setBounds(140, 50, 340, 30);

        btnedittran.setBackground(new java.awt.Color(204, 204, 255));
        btnedittran.setText("Edit");
        jPanel8.add(btnedittran);
        btnedittran.setBounds(20, 140, 75, 23);

        btnupdatetran.setBackground(new java.awt.Color(204, 204, 255));
        btnupdatetran.setText("Update");
        jPanel8.add(btnupdatetran);
        btnupdatetran.setBounds(120, 180, 72, 23);

        cmb_idKaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-pILIH ID KARYAWAN-" }));
        cmb_idKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_idKaryawanActionPerformed(evt);
            }
        });
        jPanel8.add(cmb_idKaryawan);
        cmb_idKaryawan.setBounds(140, 10, 340, 30);

        jLabel7.setFont(new java.awt.Font("Poor Richard", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ID TRANSAKSI");
        jPanel8.add(jLabel7);
        jLabel7.setBounds(200, 160, 100, 16);

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 220));

        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

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

        tp1.addTab("Form Transaksi", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tp1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tp1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpankywActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpankywActionPerformed
        // TODO add your handling code here:
        String x = txtidkaryawan.getText();
        String y = txtnama.getText();
        String z = txtjabatan.getText();
        String w = txtdepartemen.getText();
       TambahDataKaryawan(x,y,z,w);
    }//GEN-LAST:event_btnsimpankywActionPerformed

    private void btndeletekywActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletekywActionPerformed
        // TODO add your handling code here:
        HapusDataKaryawan();
    }//GEN-LAST:event_btndeletekywActionPerformed

    private void btnsimpanproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanproActionPerformed
        // TODO add your handling code here:
        TambahDataProyek();
    }//GEN-LAST:event_btnsimpanproActionPerformed

    private void btndeleteproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteproActionPerformed
        // TODO add your handling code here:
        HapusDataProyek();
    }//GEN-LAST:event_btndeleteproActionPerformed

    private void btnsimpantranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpantranActionPerformed
        // TODO add your handling code here:
//       SaveTransaksi(((String)cmb_idKaryawan.getSelectedItem()),((String) cmb_idProyek.getSelectedItem()),txtperan.getText());
        String id1 = (String)cmb_idKaryawan.getSelectedItem(); 
        String id2 = (String)cmb_idProyek.getSelectedItem(); 
        String dapatId1ByName = getKaryawanIdByName(id1);
        String dapatId2ByName = getProyekIdByName(id2);
        saveTransaksi(dapatId1ByName, dapatId2ByName, txtperan.getText());
    }//GEN-LAST:event_btnsimpantranActionPerformed

    private void btndeletetranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletetranActionPerformed
        // TODO add your handling code here:
        HapusDataTransaksi();
    }//GEN-LAST:event_btndeletetranActionPerformed

    private void btneditkywActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditkywActionPerformed
        // TODO add your handling code here:
        EditDataKaryawan();
    }//GEN-LAST:event_btneditkywActionPerformed

    private void EditDataKaryawan() {
    // Implement functionality to edit employee data
}
    
    private void btnupdatekywActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdatekywActionPerformed
        // TODO add your handling code here:
        UbahDataKaryawan();
    }//GEN-LAST:event_btnupdatekywActionPerformed

    private void cmb_idKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_idKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_idKaryawanActionPerformed

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
            @Override
            public void run() {
                new main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndeletekyw;
    private javax.swing.JButton btndeletepro;
    private javax.swing.JButton btndeletetran;
    private javax.swing.JButton btneditkyw;
    private javax.swing.JButton btneditpro;
    private javax.swing.JButton btnedittran;
    private javax.swing.JButton btnsimpankyw;
    private javax.swing.JButton btnsimpanpro;
    private javax.swing.JButton btnsimpantran;
    private javax.swing.JButton btnupdatekyw;
    private javax.swing.JButton btnupdatepro;
    private javax.swing.JButton btnupdatetran;
    private javax.swing.JComboBox<String> cmb_idKaryawan;
    private javax.swing.JComboBox<String> cmb_idProyek;
    private javax.swing.JComboBox<String> cmb_idproyek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTabbedPane tp1;
    private javax.swing.JTextField txtdepartemen;
    private javax.swing.JTextField txtdurasi;
    private javax.swing.JTextField txtidkaryawan;
    private javax.swing.JTextField txtidproyek;
    private javax.swing.JTextField txtjabatan;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnama1;
    private javax.swing.JTextField txtperan;
    // End of variables declaration//GEN-END:variables

    private void loadData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void resetForm() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void loadData2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void loadData3() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    private void SaveTransaksi() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    //private void loadDatakaryawan() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}

    private static class Statement {

        public Statement() {
        }
    }
}
    
        
