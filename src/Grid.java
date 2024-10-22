import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class Grid {
    private Tile[][] tiles;
    private int length = 50;
    private Random rand = new Random();


    public Grid() {
        tiles = new Tile[length][length];
    }

    public Grid generateGrid(int diggableTiles) {
        int max = 25;
        while (diggableTiles > 0) {
            //First populates grid with diggable tiles first
            //Last diggable tile is always endpoint
            int x = rand.nextInt(max);
            int y = rand.nextInt(max);
            Tile tile = new Tile(true, false, "purple", x, y);
            if (tiles[x][y] == null) {
                tiles[x][y] = tile;
                diggableTiles--;
            }
            if (diggableTiles == 0) {
                tile.setIsEndpoint(true);
            }

        }
        //populates rest of grid with nondiggable tiles
        for(int i = 0; i < length; i++){
            for (int y = 0; y < length; y++) {
                if (tiles[i][y] == null) {
                    Tile tile = new Tile(false, false, "white", i, y);
                    tiles[i][y] = tile;
                }
            }
        }
        return this;
    }


    public Tile[][] getTiles() {
        return tiles;
    }


    public int getLength() {
        return length;
    }



}
