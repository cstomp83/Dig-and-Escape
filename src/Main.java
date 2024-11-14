import javax.swing.*;
import java.awt.*;


public class Main {
        public static void main(String[] args) {
                new GameWindow();
        }
}

class GameWindow extends JFrame {
        private CardLayout cardLayout;
        private JPanel mainPanel;
        private GridPanel gridPanel;


        public GameWindow() {
                // Set up the main window
                setTitle("Dig and Escape");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setResizable(true);

                // Initialize CardLayout and main panel
                cardLayout = new CardLayout();
                mainPanel = new JPanel(cardLayout);

                // Create start menu panel and game panel (GridPanel)
                JPanel startMenuPanel = createStartMenuPanel();


                // Add start menu panel and empty placeholder for game panel
                mainPanel.add(startMenuPanel, "StartMenu");
                mainPanel.add(new JPanel(), "GamePanel");



                // Add main panel to JFrame and set it visible
                add(mainPanel);
                pack();
                setLocationRelativeTo(null); // Center the window on the screen
                setVisible(true);
        }

        private JPanel createStartMenuPanel() {
                JPanel panel = new JPanel();
                panel.setLayout(new GridBagLayout()); // Center buttons on the panel
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);

                // Difficulty buttons
                JButton easyButton = new JButton("Easy");
                JButton mediumButton = new JButton("Medium");
                JButton hardButton = new JButton("Hard");
                JLabel label = new JLabel("<html> A,W,S,D is to move.<br>X is to dig.</html>");

                // Set up button actions
                easyButton.addActionListener(e -> startGame(10,0));  // Easy: 10 grid
                mediumButton.addActionListener(e -> startGame(15,1)); // Medium: 15 grid
                hardButton.addActionListener(e -> startGame(20,2));   // Hard: 20 grid

                // Add buttons to the panel
                panel.add(label, gbc);
                panel.add(easyButton, gbc);
                panel.add(mediumButton, gbc);
                panel.add(hardButton, gbc);


                return panel;
        }

        private void startGame(int gridSize, int mode) {
                // Generate the grid and initialize the game panel
                Grid grid = new Grid().generateGrid(gridSize);// Generate grid based on difficulty
                gridPanel = new GridPanel(grid);
                gridPanel.addEnemeys(mode);


                // Set up key listener for game panel
                gridPanel.addKeyListener(gridPanel);
                gridPanel.setFocusable(true);

                // Replace empty game panel with initialized gridPanel and switch to it
                mainPanel.add(gridPanel, "GamePanel");
                cardLayout.show(mainPanel, "GamePanel");

                // Adjust window size to fit GridPanel content
                pack();
                gridPanel.requestFocusInWindow();
        }
}
