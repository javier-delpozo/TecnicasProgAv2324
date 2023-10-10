import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedievalGameWindow extends JFrame {
    private JLabel titleLabel;
    private JComboBox<String> classComboBox;
    private JTextArea statsTextArea;
    private JButton startButton;

    public MedievalGameWindow() {
        setTitle("Medieval Adventure Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Choose your character class:");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        classComboBox = new JComboBox<>(new String[]{"Mage", "Orc", "Soldier", "Archer"});
        add(classComboBox, BorderLayout.CENTER);

        statsTextArea = new JTextArea();
        statsTextArea.setEditable(false);
        add(new JScrollPane(statsTextArea), BorderLayout.CENTER);

        startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        add(startButton, BorderLayout.SOUTH);
    }

    private void startGame() {
        String selectedClass = (String) classComboBox.getSelectedItem();
        int health, attack, defense;

        switch (selectedClass) {
            case "Mage":
                health = 50;
                attack = 20;
                defense = 10;
                break;
            case "Orc":
                health = 80;
                attack = 10;
                defense = 5;
                break;
            case "Soldier":
                health = 70;
                attack = 15;
                defense = 15;
                break;
            case "Archer":
                health = 60;
                attack = 25;
                defense = 8;
                break;
            default:
                health = 0;
                attack = 0;
                defense = 0;
        }

        String statsText = "Class: " + selectedClass + "\n" +
                "Health: " + health + "\n" +
                "Attack: " + attack + "\n" +
                "Defense: " + defense;

        statsTextArea.setText(statsText);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MedievalGameWindow gameWindow = new MedievalGameWindow();
                gameWindow.setVisible(true);
            }
        });
    }
}
