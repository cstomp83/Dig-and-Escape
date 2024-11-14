import javax.imageio.ImageIO;
import java.awt.*;

public class Player {
    private int PlayerX; // Current x position of the player
    private int PlayerY; // Current PlayerY position of the player
    private final int GRID_SIZE = 50;
    private Image image;
    {
        try{
            image = ImageIO.read(ClassLoader.getSystemResourceAsStream("player.png"));
            image = image.getScaledInstance(28, 28, Image.SCALE_SMOOTH);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public Player() {
        PlayerX = 24;
        PlayerY = 24;

    }


    // Method to move the player
    public void move(Grid grid, int x, int y) {
        Tile[][] tiles = grid.getTiles();
        if(-1 < x && x < tiles.length && -1 < y && y < tiles.length) {
            Tile tile = tiles[x][y];
            if (tile.isOccupied() == false) {
                PlayerX = x;
                PlayerY = y;
            }
        }

    }



    public int getPlayerX() {
        return PlayerX;
    }
    public int getPlayerY() {
        return PlayerY;
    }
    // Paints the poistion of player
    public void paint(Graphics g) {
        g.drawImage(image, PlayerX *GridPanel.TILE_SIZE, PlayerY *GridPanel.TILE_SIZE, null);
    }

    // Digs and turns tile from diggable to non diggable
    public boolean dig(Grid grid) {
        Tile[][] tiles = grid.getTiles();
        Tile tile = tiles[PlayerX][PlayerY];
        if (tile.isDiggable()){
            if(tile.isEndpoint()){
                return true;
            }else{
                tile.setDiggable(false);
                tile.setColor("white");
            }
        }
        return false;
    }
}

