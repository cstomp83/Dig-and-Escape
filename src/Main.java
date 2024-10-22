import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Dig and Escape");

        Grid grid = new Grid().generateGrid(20); // Generate the grid with 100 diggable tiles
        GridPanel gridPanel = new GridPanel(grid);
        window.add(gridPanel);  // Add GridPanel to the JFrame

        window.pack(); // Pack the window based on the preferred size of GridPanel
        window.setLocationRelativeTo(null);  // Center the window on the screen
        window.setVisible(true);
        }
    }