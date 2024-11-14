import java.util.Random;

// This class is the map
public class Grid {
    private Tile[][] tiles;
    private int length = 25;
    private Random rand = new Random();
    private int numWalls = 60;


    public Grid() {
        tiles = new Tile[length][length];
    }

    // This generates the grid with a fixed number of walls and a passed integer
    // for diggable tiles
    public Grid generateGrid(int diggableTiles) {
        int max = 23;
        // This function puts the number of walls
        // the while loop runs and only decrements
        // when a valid placement is made (I.E only 3 tiles per 6 spaces)
        while(numWalls > 0) {
            int lowerbound = 1;
            int x = rand.nextInt(max-lowerbound) + lowerbound;
            int y = rand.nextInt(max-lowerbound) + lowerbound;
            if (tiles[x][y] == null) {
                int count = 0;
                for (int i = -1; i <3 ; i++) {
                    for (int j = -1; j < 3; j++) {
                        if(tiles[x+i][y+j] != null) {
                            count++;
                        }

                    }
                }
                if (count < 3) {
                    Tile tile = new Tile(false, false, "black", x, y);
                    tile.setOccupied(true);
                    tiles[x][y] = tile;
                    numWalls--;
                }
            }
        }

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
