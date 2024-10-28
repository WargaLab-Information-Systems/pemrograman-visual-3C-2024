/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugaspraktikum3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApotekMini extends JFrame {
    private JLabel gambarObat, detailObat;

    public ApotekMini() {
        // Mengatur layout utama menggunakan BorderLayout
        setLayout(new BorderLayout());

        // Bagian Utara (Judul)
        JLabel title = new JLabel("Apotek Mini - Pilih Obat dan Lihat Detailnya", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        // Bagian Tengah (Daftar Obat)
        JPanel obatPanel = new JPanel(new GridLayout(2, 5, 10, 10));  // Grid untuk 10 obat
        for (int i = 1; i <= 10; i++) {
            JButton obatButton = new JButton("Obat " + i);
            obatButton.addActionListener(new PilihObatListener(i));
            obatPanel.add(obatButton);
        }
        add(obatPanel, BorderLayout.CENTER);

        // Bagian Timur (Gambar Obat)
        gambarObat = new JLabel();
        gambarObat.setHorizontalAlignment(JLabel.CENTER);
        gambarObat.setPreferredSize(new Dimension(200, 200));  // Ukuran gambar obat
        add(gambarObat, BorderLayout.EAST);

        // Bagian Selatan (Detail Obat)
        detailObat = new JLabel("Detail Obat: ");
        detailObat.setFont(new Font("Arial", Font.PLAIN, 14));
        detailObat.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(detailObat, BorderLayout.SOUTH);

        setTitle("Apotek Mini");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Listener untuk menampilkan gambar dan deskripsi saat obat dipilih
    private class PilihObatListener implements ActionListener {
        int index;

        PilihObatListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Path untuk gambar obat
            String imagePath = "path_to_images/obat" + index + ".png";
            ImageIcon icon = new ImageIcon(imagePath);
            Image img = icon.getImage();
            Image imgScaled = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            gambarObat.setIcon(new ImageIcon(imgScaled));

            // Deskripsi obat yang akan ditampilkan
            String deskripsi = "Obat " + index + ": Deskripsi obat ini...";
            detailObat.setText(deskripsi);
        }
    }

    public static void main(String[] args) {
        new ApotekMini();
    }
}
