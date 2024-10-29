/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author MY HP
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MY HP
 */import javax.swing.*;
   import java.awt.*;
   import java.awt.event.ActionEvent;
   import java.awt.event.ActionListener;
   import java.util.ArrayList;
   import java.util.Random;
   import javax.swing.JFrame;

public class Game extends JFrame {
    private int targetNumber;
    private int attempts;
    private int score;
    private ArrayList<String> scoreList;

    private JTextField Input;
    private JLabel feedbackLabel, scoreLabel;
    private JButton Button, resetButton;
    private JList<String> scoreJList;
    private DefaultListModel<String> scoreListModel;

    public Game() {
        setTitle("Permainan Sederhana");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // komponen game
        scoreList = new ArrayList<>();
        scoreListModel = new DefaultListModel<>();
        scoreJList = new JList<>(scoreListModel);

        JPanel mainPanel = new JPanel(new CardLayout());
        JTabbedPane tabbedPane = new JTabbedPane();

        // Setup game panel
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(5, 1, 10, 10)); //5bsrid 1 klm
        Input = new JTextField(); //masukan angka
        feedbackLabel = new JLabel("Angka Berapa Aku?");
        scoreLabel = new JLabel("Score: 0");

        Button = new JButton("TEBAK (5)");
        resetButton = new JButton("RESET");

        gamePanel.add(feedbackLabel);
        gamePanel.add(new JLabel("COBA TEBAK:"));
        gamePanel.add(Input);
        gamePanel.add(scoreLabel);
        gamePanel.add(Button);
        gamePanel.add(resetButton);

        // Setup score panel
        JPanel scorePanel = new JPanel(new BorderLayout());
        scorePanel.add(new JLabel("SCORE", SwingConstants.CENTER), BorderLayout.NORTH);
        scorePanel.add(new JScrollPane(scoreJList), BorderLayout.CENTER);

        tabbedPane.addTab("Permainan", gamePanel);
        tabbedPane.addTab("Score", scorePanel);
        mainPanel.add(tabbedPane); //panel menampung tpan

        add(mainPanel);
        resetGame();

        // Button Listeners
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeGuess(); //untuk menjalankan logika permainan
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
    }

    private void resetGame() {
        targetNumber = new Random().nextInt(100) + 1;
        attempts = 10; //kesempatan bermain
        score = 0;
        feedbackLabel.setText("Angka Berapa Aku?");
        scoreLabel.setText("Score: 0");
        Input.setText("");
        Button.setEnabled(true);
    }

    private void makeGuess() {
        try {
            int guess = Integer.parseInt(Input.getText()); //mengonversi teks menjadi bilangan bulat.
            attempts--; //mengurangi jumlah kesempatan yg tersisa untk pemain

            if (guess == targetNumber) {
                score = attempts * 10; //score sama dengan di x 10 (sisa kesempatan)
                String name = JOptionPane.showInputDialog(this, "Masukkan Nama Anda:");
                if (name != null && !name.isEmpty()) { //Memeriksa apakah nama yang dimasukkan oleh pemain tidak null
                    scoreListModel.addElement(name + " - Score: " + score); //pengelolaan skorr
                    scoreList.add(name + " - Score: " + score);
                }
                feedbackLabel.setText("Anda Berhasil!");
                Button.setEnabled(false); //menonaktifkan setelah berhasil nebak
            } else if (attempts == 0) { //memeriksa jumlah kesempatan
                feedbackLabel.setText("Anda Gagal");
                Button.setEnabled(false);
            } else {
                feedbackLabel.setText(guess < targetNumber ? "Angka lebih besar" : "Angka lebih kecil");
            }

            scoreLabel.setText("Score: " + (attempts * 10));
            Input.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Game().setVisible(true);
        });
    }
}
