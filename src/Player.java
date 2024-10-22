import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Player {
    private int x; // Current x position of the player
    private int y; // Current y position of the player
    private final int GRID_SIZE = 50;
    private Tile[][] legalMoves; // A 2D array representing occupied tiles
    private Image image;
    {
        try{
            image = ImageIO.read(ClassLoader.getSystemResourceAsStream("player.png"));
            image = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;

    }

    // Method to move the player
    public void move(int newX, int newY) {

    }

    private Tile[][] getLegalMoves(Grid g) {
        Tile[][] tiles = g.getTiles();
        int playerX = getX();
        int playerY = getY();
        Tile[][] legalMoves = new Tile[3][3];
        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                try{
                    Tile tile = tiles[playerX + i][playerY + j];

                    if ((!tile.isOccupied())) {
                        legalMoves[playerX + i][playerY + j] = tile;
                    }
                } catch  (ArrayIndexOutOfBoundsException e) {
                }
            }
        }
        return legalMoves;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void paint(Graphics g) {
        g.drawImage(image, x, y, null);
    }
}

