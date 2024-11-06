/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modul5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

public class main extends javax.swing.JFrame {

    Connection conn;
    private final DefaultTableModel modelKarywan;
    private final DefaultTableModel modelProyek;
    private final DefaultTableModel modelTransaksi;
    private final DefaultComboBoxModel modelCmbKaryawan;
    private final DefaultComboBoxModel modelCmbProyek;
    public main() {
        initComponents();
        conn = koneksi.getConnection();
        
        modelCmbKaryawan = new DefaultComboBoxModel();
        modelCmbProyek = new DefaultComboBoxModel();
        
        modelKarywan = new DefaultTableModel();
        tb_karyawan.setModel(modelKarywan);

        modelKarywan.addColumn("ID");
        modelKarywan.addColumn("Nama");
        modelKarywan.addColumn("Jabatan");
        modelKarywan.addColumn("Departemen");
        
        modelProyek = new DefaultTableModel();
        tb_proyek.setModel(modelProyek);

        modelProyek.addColumn("ID");
        modelProyek.addColumn("Nama Proyek");
        modelProyek.addColumn("Durasi Pengerjaan");
        
        modelTransaksi = new DefaultTableModel();
        tb_transaksi.setModel(modelTransaksi);
        modelTransaksi.addColumn("Nama Karyawan");
        modelTransaksi.addColumn("Peran");
        modelTransaksi.addColumn("Proyek");
        modelTransaksi.addColumn("Durasi Pengerjaan");
        
        
        
        loadDataKaryawan();
        loadDataProyek();
        loadDataTransaksi();
        loadDataCmbProyek();
        loadDataCmbKaryawan();
    }
    
private void loadDataKaryawan() {
  modelKarywan.setRowCount(0);
        
  try {
      String sql = "SELECT * FROM tb_karyawan";
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
         
         modelKarywan.addRow(new Object[]{
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

private void loadDataCmbKaryawan() {
    cmbKaryawan.removeAllItems();
        
  try {
      String sql = "SELECT id,nama FROM tb_karyawan";
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        String data = rs.getString("nama");
        modelCmbKaryawan.addElement(data);
      }
  } catch (SQLException e) {
     System.out.println("Error Save Data" + e.getMessage());
   }
  cmbKaryawan.setModel(modelCmbKaryawan);
}

private void loadDataCmbProyek() {
    cmbProyek.removeAllItems();
        
try {
      String sql = "SELECT id, nama_proyek, durasi_pengerjaan FROM tb_proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
              String data = rs.getString("nama_proyek");
              modelCmbProyek.addElement(data);
            
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Memuat Data Proyek: " + e.getMessage());
    }
    cmbProyek.setModel(modelCmbProyek);
}

private void loadDataProyek() {
  modelProyek.setRowCount(0);
        
  try {
      String sql = "SELECT * FROM tb_proyek";
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
         
         modelProyek.addRow(new Object[]{
         rs.getInt("id"),
         rs.getString("nama_proyek"),
         rs.getString("durasi_pengerjaan")
       });
      }
  } catch (SQLException e) {
     System.out.println("Error Save Data" + e.getMessage());
   }
}

private void loadDataTransaksi() {
    modelTransaksi.setRowCount(0);

    try {
        String sql = "SELECT t.id_karyawan, t.id_proyek, t.peran, " +
                             "k.nama AS nama_karyawan, p.nama_proyek AS nama_proyek, " +
                             "p.durasi_pengerjaan " +
                             "FROM tb_transaksi t " +
                             "JOIN tb_karyawan k ON t.id_karyawan = k.id " +
                             "JOIN tb_proyek p ON t.id_proyek = p.id";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    modelTransaksi.addRow(new Object[]{
                        rs.getString("nama_karyawan"),
                        rs.getString("peran"),
                        rs.getString("nama_proyek"),
                        rs.getInt("durasi_pengerjaan")
                    });
                }
            } catch (SQLException e) {
                System.out.println("Error Load Data Transaksi: " + e.getMessage());
            }
}

private int getIdKaryawan() throws SQLException { 
    String namaKaryawan = (String) cmbKaryawan.getSelectedItem(); 
    String sql = "SELECT id FROM tb_karyawan WHERE nama = ?"; 
    PreparedStatement ps = conn.prepareStatement(sql); 
    ps.setString(1, namaKaryawan); 
    ResultSet rs = ps.executeQuery(); 
    if (rs.next()) { 
        return rs.getInt("id"); 
    }   
    throw new SQLException("ID karyawan tidak ditemukan"); 
}

private int getIdProyek() throws SQLException { 
    String namaProyek = (String) cmbProyek.getSelectedItem(); 
    String sql = "SELECT id FROM tb_proyek WHERE nama_proyek = ?"; 
    PreparedStatement ps = conn.prepareStatement(sql); 
    ps.setString(1, namaProyek); 
    ResultSet rs = ps.executeQuery(); 
    if (rs.next()) { 
        return rs.getInt("id"); 
    } 
    throw new SQLException("ID proyek tidak ditemukan"); 
}

private void SimpanDataTransaksi(){
    try{
       String sql = "INSERT INTO tb_transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);

                int idKaryawan = getIdKaryawan();
                int idProyek = getIdProyek();

                ps.setInt(1, idKaryawan);
                ps.setInt(2, idProyek);
                ps.setString(3, tf_peran.getText().trim());

                int result = ps.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Data Transaksi berhasil ditambahkan");
                    loadDataTransaksi();
                    
                    
                }
            } catch (SQLException e) {
                System.out.println("Kesalahan Menambah Data Transaksi: " + e.getMessage());
                JOptionPane.showMessageDialog(this, "Gagal menambah data: " + e.getMessage());
            }
}

private void UpdateDataTransaksi(){
   try { 
            if (tf_peran.getText().trim().isEmpty()) { 
                JOptionPane.showMessageDialog(this, "Peran tidak boleh kosong"); 
                return; 
            } 
            int idKaryawan = getIdKaryawan(); 
            int idProyek = getIdProyek();
 
            String sqlCheck = "SELECT * FROM tb_transaksi WHERE id_karyawan = ? AND id_proyek = ?"; 
            PreparedStatement psCheck = conn.prepareStatement(sqlCheck); 
            psCheck.setInt(1, idKaryawan); 
            psCheck.setInt(2, idProyek); 
            ResultSet rs = psCheck.executeQuery(); 
 
            if (rs.next()) { 
                String peran = rs.getString("peran"); 
                if (peran.equals(tf_peran.getText().trim())) { 
                    JOptionPane.showMessageDialog(this, "Data masih sama,Mohon ubah dulu perannya"); 
                    return; 
                }
                String sqlUpdate = "UPDATE tb_transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?"; 
                PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate); 
                psUpdate.setString(1, tf_peran.getText()); 
                psUpdate.setInt(2, idKaryawan); 
                psUpdate.setInt(3, idProyek); 
                psUpdate.executeUpdate(); 
                JOptionPane.showMessageDialog(this, "Data transaksi berhasil diperbarui"); 
                cmbKaryawan.setSelectedIndex(0); 
                cmbProyek.setSelectedIndex(0); 
                tf_peran.setText(""); 
                loadDataTransaksi(); 
            } else { 
                JOptionPane.showMessageDialog(this, "Transaksi tidak ditemukan. Pilih Karyawan dan Projek dengan Benar."); 
            } 
        } catch (SQLException e) { 
            System.out.println("Error Update Data: " + e.getMessage()); 
        }
}

private void DeleteTransaksi(){
    try{
        int idKaryawan = getIdKaryawan(); 
        int idProyek = getIdProyek(); 
 
            String sql = "DELETE FROM tb_transaksi WHERE id_karyawan = ? AND id_proyek = ?"; 
            PreparedStatement ps = conn.prepareStatement(sql); 
            ps.setInt(1, idKaryawan); 
            ps.setInt(2, idProyek); 
            int rowsDeleted = ps.executeUpdate(); 
            if (rowsDeleted > 0) { 
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus"); 
            } else { 
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan, Mohon Masukan dengan benar"); 
            } 
            tf_peran.setText(""); 
            loadDataTransaksi(); 
        } catch (SQLException e) { 
            System.out.println("Error Delete Data: " + e.getMessage()); 
        } 
    }         


private void SimpanData(){
    try{
        if(tf_id_karyawan.getText().trim().isEmpty()||tf_nama_karyawan.getText().trim().isEmpty()||tf_jabatan_karyawan.getText().trim().isEmpty()||tf_departemen.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this,"Lengkapi Semua Data!!!","Info",JOptionPane.INFORMATION_MESSAGE);
        return;
        }
        
        String sqlCekId = "SELECT id FROM tb_Karyawan WHERE id = ?";
        PreparedStatement psCek = conn.prepareStatement(sqlCekId);
        psCek.setInt(1,Integer.parseInt(tf_id_karyawan.getText().trim()));
        ResultSet rs = psCek.executeQuery();
        if(rs.next()){
        JOptionPane.showMessageDialog(this,"ID sudah ada masukan ID lain","WARNING",JOptionPane.WARNING_MESSAGE);
        return;
        }
        
        String sql ="INSERT INTO tb_karyawan (id,nama,jabatan,departemen)VALUES (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(tf_id_karyawan.getText().trim()));
        ps.setString(2,tf_nama_karyawan.getText().trim());
        ps.setString(3,tf_jabatan_karyawan.getText().trim());
        ps.setString(4,tf_departemen.getText().trim());
        ps.execute();

        JOptionPane.showMessageDialog(this,"Data berhasil Disimpan","Info",JOptionPane.INFORMATION_MESSAGE);
        loadDataKaryawan();
        loadDataCmbKaryawan();
    
    }catch(SQLException e){
        System.out.println("Gagal");
    }
}

private void SimpanDataProyek(){
    try{
        if(tf_id_proyek.getText().trim().isEmpty()||tf_nama_proyek.getText().trim().isEmpty()||tf_durasi_pengerjaan.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this,"Lengkapi Semua Data!!!","Info",JOptionPane.INFORMATION_MESSAGE);
        return;
        }
        
        String sqlCekId = "SELECT id FROM tb_Proyek WHERE id = ?";
        PreparedStatement psCek = conn.prepareStatement(sqlCekId);
        psCek.setInt(1,Integer.parseInt(tf_id_proyek.getText().trim()));
        ResultSet rs = psCek.executeQuery();
        if(rs.next()){
        JOptionPane.showMessageDialog(this,"ID sudah ada masukan ID lain","WARNING",JOptionPane.WARNING_MESSAGE);
        return;
        }
        
        String sql ="INSERT INTO tb_proyek (id,nama_proyek,durasi_pengerjaan)VALUES (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(tf_id_proyek.getText().trim()));
        ps.setString(2,tf_nama_proyek.getText().trim());
        ps.setInt(3,Integer.parseInt(tf_durasi_pengerjaan.getText().trim()));
        ps.execute();

        JOptionPane.showMessageDialog(this,"Data berhasil Disimpan","Info",JOptionPane.INFORMATION_MESSAGE);
        loadDataProyek();
        loadDataCmbProyek();
       
    }catch(SQLException e){
        System.out.println("Gagal");
    }
}

private void UpdateData(){
    try{
        if (tf_id_karyawan.getText().trim().isEmpty() || tf_nama_karyawan.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID dan Nama Karyawan tidak boleh kosong", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String sqlCekId = "SELECT id FROM tb_karyawan WHERE id = ?";
        PreparedStatement psCek = conn.prepareStatement(sqlCekId);
        psCek.setInt(1, Integer.parseInt(tf_id_karyawan.getText().trim()));
        ResultSet rs = psCek.executeQuery();
        if (!rs.next()) {
            JOptionPane.showMessageDialog(this, "ID tidak ditemukan, masukkan ID yang valid", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String sql ="UPDATE tb_karyawan SET nama = ?,jabatan =?,departemen=? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,tf_nama_karyawan.getText().trim());
        ps.setString(2,tf_jabatan_karyawan.getText().trim());
        ps.setString(3, tf_departemen.getText().trim());
        ps.setInt(4, Integer.parseInt(tf_id_karyawan.getText().trim()));
        ps.execute();

        JOptionPane.showMessageDialog(this,"Data berhasil Diupdate","Info",JOptionPane.INFORMATION_MESSAGE);
        loadDataKaryawan();
        loadDataCmbKaryawan();
    }catch(SQLException e){
        System.out.println("Gagal");
    }
}

private void UpdateDataProyek(){
    try{
        if (tf_id_proyek.getText().trim().isEmpty() || tf_nama_proyek.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID dan Nama Karyawan tidak boleh kosong", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String sqlCekId = "SELECT id FROM tb_proyek WHERE id = ?";
        PreparedStatement psCek = conn.prepareStatement(sqlCekId);
        psCek.setInt(1, Integer.parseInt(tf_id_proyek.getText().trim()));
        ResultSet rs = psCek.executeQuery();
        if (!rs.next()) {
            JOptionPane.showMessageDialog(this, "ID tidak ditemukan, masukkan ID yang valid", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String sql ="UPDATE tb_proyek SET nama_proyek = ?,durasi_pengerjaan =? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,tf_nama_proyek.getText().trim());
        ps.setString(2,tf_durasi_pengerjaan.getText().trim());
        ps.setInt(3,Integer.parseInt(tf_id_proyek.getText().trim()));
        ps.execute();

        JOptionPane.showMessageDialog(this,"Data berhasil Diupdate","Info",JOptionPane.INFORMATION_MESSAGE);
        loadDataProyek();
        loadDataCmbProyek();
    }catch(SQLException e){
        System.out.println("Gagal");
    }
}

private void HapusData(){
    try{ 
        String sql = "DELETE FROM tb_karyawan WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(tf_id_karyawan.getText().trim()));
        ps.execute();
        
        JOptionPane.showMessageDialog(this,"Data Berhasil Dihapus","Info",JOptionPane.INFORMATION_MESSAGE);
        loadDataKaryawan();
        loadDataCmbKaryawan();
        
    }catch(SQLException e){
        System.out.println("Gagal");
    }
}

private void HapusDataProyek(){
    try{
        String sql = "DELETE FROM tb_proyek WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(tf_id_proyek.getText().trim()));
        ps.execute();
        
        JOptionPane.showMessageDialog(this,"Data Berhasil Dihapus","Info",JOptionPane.INFORMATION_MESSAGE);
        loadDataProyek();
        loadDataCmbProyek();
        
    }catch(SQLException e){
        System.out.println("Gagal");
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
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_id_karyawan = new javax.swing.JTextField();
        tf_jabatan_karyawan = new javax.swing.JTextField();
        tf_nama_karyawan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_departemen = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_karyawan = new javax.swing.JTable();
        btn_simpan_karyawan = new javax.swing.JButton();
        btn_update_karyawan = new javax.swing.JButton();
        btn_delete_karyawan = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_proyek = new javax.swing.JTable();
        tf_id_proyek = new javax.swing.JTextField();
        tf_nama_proyek = new javax.swing.JTextField();
        tf_durasi_pengerjaan = new javax.swing.JTextField();
        btn_Simpan_proyek = new javax.swing.JButton();
        btn_update_proyek = new javax.swing.JButton();
        btn_hapus_proyek = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbKaryawan = new javax.swing.JComboBox<>();
        cmbProyek = new javax.swing.JComboBox<>();
        tf_peran = new javax.swing.JTextField();
        peran = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_transaksi = new javax.swing.JTable();
        btnSimpanProyek = new javax.swing.JButton();
        btnUpdateProyek = new javax.swing.JButton();
        btnDeleteProyek = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(163, 243, 235));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setText("Karyawan");
        jPanel4.add(jLabel1);

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(241, 255, 171));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel5.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Nama");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel5.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Jabatan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel5.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        jPanel5.add(tf_id_karyawan, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        jPanel5.add(tf_jabatan_karyawan, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        jPanel5.add(tf_nama_karyawan, gridBagConstraints);

        jLabel5.setText("Departemen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel5.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        jPanel5.add(tf_departemen, gridBagConstraints);

        tb_karyawan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tb_karyawan);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 10;
        jPanel5.add(jScrollPane1, gridBagConstraints);

        btn_simpan_karyawan.setText("Simpan");
        btn_simpan_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan_karyawanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        jPanel5.add(btn_simpan_karyawan, gridBagConstraints);

        btn_update_karyawan.setText("Update");
        btn_update_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_karyawanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 11);
        jPanel5.add(btn_update_karyawan, gridBagConstraints);

        btn_delete_karyawan.setText("Delete");
        btn_delete_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_karyawanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 0);
        jPanel5.add(btn_delete_karyawan, gridBagConstraints);

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Karyawan", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 255, 204));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel6.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Nama Proyek");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel7, gridBagConstraints);

        jLabel8.setText("Durasi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel8, gridBagConstraints);

        tb_proyek.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tb_proyek);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 10;
        jPanel2.add(jScrollPane2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(tf_id_proyek, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(tf_nama_proyek, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(tf_durasi_pengerjaan, gridBagConstraints);

        btn_Simpan_proyek.setText("Simpan");
        btn_Simpan_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Simpan_proyekActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        jPanel2.add(btn_Simpan_proyek, gridBagConstraints);

        btn_update_proyek.setText("Update");
        btn_update_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_proyekActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(btn_update_proyek, gridBagConstraints);

        btn_hapus_proyek.setText("Hapus");
        btn_hapus_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_proyekActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        jPanel2.add(btn_hapus_proyek, gridBagConstraints);

        jPanel6.setBackground(new java.awt.Color(255, 102, 102));

        jLabel11.setFont(new java.awt.Font("STHupo", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("PROYEK");
        jPanel6.add(jLabel11);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 47;
        gridBagConstraints.ipady = 47;
        jPanel2.add(jPanel6, gridBagConstraints);

        jTabbedPane1.addTab("Proyek", jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(205, 193, 255));

        jLabel12.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel12.setText("Transaksi");
        jPanel7.add(jLabel12);

        jPanel3.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(191, 236, 255));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabel13.setText("Karyawan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel8.add(jLabel13, gridBagConstraints);

        jLabel14.setText("Proyek");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel8.add(jLabel14, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel8.add(cmbKaryawan, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel8.add(cmbProyek, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel8.add(tf_peran, gridBagConstraints);

        peran.setText("peran");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel8.add(peran, gridBagConstraints);

        tb_transaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tb_transaksi);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 10;
        jPanel8.add(jScrollPane3, gridBagConstraints);

        btnSimpanProyek.setText("Simpan");
        btnSimpanProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanProyekActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        jPanel8.add(btnSimpanProyek, gridBagConstraints);

        btnUpdateProyek.setText("Update");
        btnUpdateProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProyekActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel8.add(btnUpdateProyek, gridBagConstraints);

        btnDeleteProyek.setText("Delete");
        btnDeleteProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProyekActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        jPanel8.add(btnDeleteProyek, gridBagConstraints);

        jPanel3.add(jPanel8, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Transaksi Proyek", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpan_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan_karyawanActionPerformed
        // TODO add your handling code here:
        SimpanData();
    }//GEN-LAST:event_btn_simpan_karyawanActionPerformed

    private void btn_update_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_karyawanActionPerformed
        // TODO add your handling code here:
        UpdateData();
    }//GEN-LAST:event_btn_update_karyawanActionPerformed

    private void btn_delete_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_karyawanActionPerformed

        try{
            if(tf_id_karyawan.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"ID perlu di isi!!","Awas",JOptionPane.WARNING_MESSAGE);
            return;
            }
            String sqlCekId = "SELECT id FROM tb_karyawan WHERE id = ?";
            PreparedStatement psCek = conn.prepareStatement(sqlCekId);
            psCek.setInt(1, Integer.parseInt(tf_id_karyawan.getText().trim()));
            ResultSet rs = psCek.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "ID tidak ditemukan, masukkan ID yang valid", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(SQLException e){
            System.out.println("Gagal");
        }
        
        int pilihan = JOptionPane.showConfirmDialog(this,"APakah anda yakin ingin Menghapus?","Warning",JOptionPane.YES_NO_OPTION);
        if (pilihan == JOptionPane.YES_OPTION){
        HapusData();
        }
    }//GEN-LAST:event_btn_delete_karyawanActionPerformed

    private void btn_Simpan_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Simpan_proyekActionPerformed
        // TODO add your handling code here:
        SimpanDataProyek();
    }//GEN-LAST:event_btn_Simpan_proyekActionPerformed

    private void btn_hapus_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_proyekActionPerformed
        // TODO add your handling code here:
        try{
            if(tf_id_proyek.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"ID perlu di isi!!","Awas",JOptionPane.WARNING_MESSAGE);
            return;
            }
            String sqlCekId = "SELECT id FROM tb_proyek WHERE id = ?";
            PreparedStatement psCek = conn.prepareStatement(sqlCekId);
            psCek.setInt(1, Integer.parseInt(tf_id_proyek.getText().trim()));
            ResultSet rs = psCek.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "ID tidak ditemukan, masukkan ID yang valid", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(SQLException e){
            System.out.println("Gagal");
        }
        
        int pilihan = JOptionPane.showConfirmDialog(this,"APakah anda yakin ingin Menghapus?","Warning",JOptionPane.YES_NO_OPTION);
        if (pilihan == JOptionPane.YES_OPTION){
        HapusDataProyek();
        }
    
    }//GEN-LAST:event_btn_hapus_proyekActionPerformed

    private void btn_update_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_proyekActionPerformed
        // TODO add your handling code here:
        UpdateDataProyek();
    }//GEN-LAST:event_btn_update_proyekActionPerformed

    private void btnSimpanProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanProyekActionPerformed
        // TODO add your handling code here:
        SimpanDataTransaksi();
    }//GEN-LAST:event_btnSimpanProyekActionPerformed

    private void btnUpdateProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProyekActionPerformed
        // TODO add your handling code here:
        UpdateDataTransaksi();
    }//GEN-LAST:event_btnUpdateProyekActionPerformed

    private void btnDeleteProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProyekActionPerformed
        // TODO add your handling code here:
        DeleteTransaksi();
    }//GEN-LAST:event_btnDeleteProyekActionPerformed

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
    private javax.swing.JButton btnDeleteProyek;
    private javax.swing.JButton btnSimpanProyek;
    private javax.swing.JButton btnUpdateProyek;
    private javax.swing.JButton btn_Simpan_proyek;
    private javax.swing.JButton btn_delete_karyawan;
    private javax.swing.JButton btn_hapus_proyek;
    private javax.swing.JButton btn_simpan_karyawan;
    private javax.swing.JButton btn_update_karyawan;
    private javax.swing.JButton btn_update_proyek;
    private javax.swing.JComboBox<String> cmbKaryawan;
    private javax.swing.JComboBox<String> cmbProyek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel peran;
    private javax.swing.JTable tb_karyawan;
    private javax.swing.JTable tb_proyek;
    private javax.swing.JTable tb_transaksi;
    private javax.swing.JTextField tf_departemen;
    private javax.swing.JTextField tf_durasi_pengerjaan;
    private javax.swing.JTextField tf_id_karyawan;
    private javax.swing.JTextField tf_id_proyek;
    private javax.swing.JTextField tf_jabatan_karyawan;
    private javax.swing.JTextField tf_nama_karyawan;
    private javax.swing.JTextField tf_nama_proyek;
    private javax.swing.JTextField tf_peran;
    // End of variables declaration//GEN-END:variables
}
