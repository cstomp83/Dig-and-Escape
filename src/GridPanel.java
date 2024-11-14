import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

// This displays the game
class GridPanel extends JPanel implements KeyListener {
    private Grid grid;
    public static int TILE_SIZE = 30;  // Size of each tile
    ArrayList<Enemy> enemies = new ArrayList<>();
    Player player = new Player();
    private boolean isGameOver = false;



    public GridPanel(Grid grid) {
        this.grid = grid;
        setPreferredSize(new Dimension(grid.getLength() * TILE_SIZE, grid.getLength() * TILE_SIZE));
        setLayout(new GridLayout(grid.getLength(), grid.getLength()));
    }

    // Based on difficulty given generates the enemies in a different way
    public void addEnemeys(int mode){
        switch (mode){
            case 0:
                enemies.add(new Chaser(0));
                enemies.add(new IntermediateEnemy(1));
                enemies.add(new RandomEnemy(2));
                enemies.add(new RandomEnemy(3));
                break;

            case 1:
                enemies.add(new Chaser(0));
                enemies.add(new IntermediateEnemy(1));
                enemies.add(new IntermediateEnemy(2));
                enemies.add(new RandomEnemy(3));
                break;

            case 2:
                enemies.add(new Chaser(0));
                enemies.add(new IntermediateEnemy(1));
                enemies.add(new IntermediateEnemy(2));
                enemies.add(new Chaser(3));
                break;


        }
    }
    // Genrates a new grid every time for new game update
    // First checks in any cop is in the same square as the player
    // Then checks if the player has dug an endpoint
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameLost(enemies)) {
            drawLossFrame(g);
        } else {
            if (isGameOver) {
                drawWinFrame(g);
            } else {

                Tile[][] tiles = grid.getTiles();
                for (int i = 0; i < grid.getLength(); i++) {
                    for (int j = 0; j < grid.getLength(); j++) {
                        Tile tile = tiles[i][j];
                        if (tile.getColor() == "white") {
                            g.setColor(Color.white);
                        } else if (tile.getColor() == "black") {
                            g.setColor(Color.black);
                        } else {
                            g.setColor(new Color(226, 226, 33));
                        }

                        g.fillRect(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE - 2, TILE_SIZE - 2);
                        g.drawRect(grid.getLength() * TILE_SIZE, grid.getLength() * TILE_SIZE, TILE_SIZE, TILE_SIZE);


                    }

                }
                for (Enemy piece : enemies) {
                    piece.paint(g);

                }
                player.paint(g);
            }
        }
    }

    private void drawLossFrame(Graphics g) {
        // Set the background color if you want a solid color (optional)
        g.setColor(new Color(0, 0, 0, 150)); // Black with transparency
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw "You Win!" message in green
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        String message = "You Got Caught!";

        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(message)) / 2;
        int y = (getHeight() / 2) + (fm.getAscent() / 2);  // Vertical center adjustment

        g.drawString(message, x, y);
    }




    private void drawWinFrame(Graphics g) {
        // Set the background color if you want a solid color (optional)
        g.setColor(new Color(0, 0, 0, 150)); // Black with transparency
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw "You Win!" message in green
        g.setColor(Color.green);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        String message = "You Win!";

        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(message)) / 2;
        int y = (getHeight() / 2) + (fm.getAscent() / 2);  // Vertical center adjustment

        g.drawString(message, x, y);
    }

    private boolean gameLost(ArrayList<Enemy> enemies){
        for(Enemy e: enemies){
            if (e.x == player.getPlayerX() && e.y == player.getPlayerY()){
                return true;
            }
        }
        return false;
    }


    @Override
    public void keyTyped(KeyEvent e) {
        //
    }
    // Key handler here to update the game every time you move
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            int x = player.getPlayerX();
            int y = player.getPlayerY();
            player.move(grid, x, y-1);
            if (x != player.getPlayerX() || y != player.getPlayerY()) {
                moveEnemies();
            }
            repaint();
        }
        if (key == KeyEvent.VK_A) {
            int x = player.getPlayerX();
            int y = player.getPlayerY();
            player.move(grid, x - 1, y);
            if (x != player.getPlayerX() || y != player.getPlayerY()) {
                moveEnemies();
            }
            repaint();
        }
        if (key == KeyEvent.VK_S) {
            int x = player.getPlayerX();
            int y = player.getPlayerY();
            player.move(grid, x, y + 1);
            if (x != player.getPlayerX() || y != player.getPlayerY()) {
                moveEnemies();
            }
            repaint();
        }
        if (key == KeyEvent.VK_D) {
            int x = player.getPlayerX();
            int y = player.getPlayerY();
            player.move(grid, x + 1, y);
            if (x != player.getPlayerX() || y != player.getPlayerY()) {
                moveEnemies();
            }

            repaint();
        }
        if (key == KeyEvent.VK_X){
            if(player.dig(grid)){
                isGameOver = true;
            }
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void moveEnemies(){
        for(Enemy e : enemies){
            e.move(grid,player);
        }
    }
}
