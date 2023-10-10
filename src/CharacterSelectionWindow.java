import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CharacterSelectionWindow extends JFrame implements ActionListener {
    private JPanel panel;
    private JButton[] cells;
    private String[] characterNames;
    private String[] characterClasses;
    private int selectedCellIndex = -1;
    private int[][] characterStats;

    public CharacterSelectionWindow() {
        setTitle("Character Selection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);

        // Create the character names and classes
        characterNames = new String[] { "Character 1", "Character 2", "Character 3", "Character 4", "Character 5" };
        characterClasses = new String[] { "Mage", "Warrior", "Orc", "Archer", "Knight" };

        // Create the character stats
        characterStats = new int[characterNames.length][3];
        for (int i = 0; i < characterNames.length; i++) {
            characterStats[i][0] = (int)(Math.random() * 100);
            characterStats[i][1] = (int)(Math.random() * 100);
            characterStats[i][2] = (int)(Math.random() * 100);
        }

        // Create the cells
        cells = new JButton[characterNames.length];
        for (int i = 0; i < characterNames.length; i++) {
            cells[i] = new JButton(characterNames[i] + " (" + characterClasses[i] + ")");
            cells[i].addActionListener(this);
            cells[i].setBorder(BorderFactory.createRaisedBevelBorder());
            cells[i].setBackground(Color.WHITE);
            cells[i].setOpaque(true);
        }

        // Create the panel and add the cells
        panel = new JPanel(new GridLayout(1, 5));
        for (int i = 0; i < cells.length; i++) {
            panel.add(cells[i]);
        }

        // Add the panel to the frame
        add(panel);

        // Show the frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Get the selected cell index
        for (int i = 0; i < cells.length; i++) {
            if (e.getSource() == cells[i]) {
                selectedCellIndex = i;
                break;
            }
        }

        // Deselect the previously selected cell
        if (selectedCellIndex!= -1) {
            cells[selectedCellIndex].setBorder(BorderFactory.createRaisedBevelBorder());
            cells[selectedCellIndex].setBackground(Color.WHITE);
        }

        // Select the clicked cell
        ((JButton)e.getSource()).setBorder(BorderFactory.createLoweredBevelBorder());
        ((JButton)e.getSource()).setBackground(Color.LIGHT_GRAY);

        // Show the character stats
        String stats = "Stats for " + characterNames[selectedCellIndex] + ":\n";
        stats += "Attack: " + characterStats[selectedCellIndex][0] + "\n";
        stats += "Defense: " + characterStats[selectedCellIndex][1] + "\n";
        stats += "Health: " + characterStats[selectedCellIndex][2] + "\n";
        JOptionPane.showMessageDialog(this, stats);
    }

    public static void main(String[] args) {
        new CharacterSelectionWindow();
    }
}
