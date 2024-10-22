import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    void generateGrid() {
        Grid grid = new Grid();
        grid.generateGrid(8);
        Tile[][] tile = grid.getTiles();
        int count =0;
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                Tile t = tile[i][j];
                if (t.isDiggable()) {
                    count++;
                }
            }
        }
        assertEquals(8, count);
    }

    @Test
    void generateGridMoreTiles() {
        Grid grid = new Grid();
        grid.generateGrid(12);
        Tile[][] tile = grid.getTiles();
        int count =0;
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                Tile t = tile[i][j];
                if (t.isDiggable()) {
                    count++;
                }
            }
        }
        assertEquals(12, count);
    }



    @Test
    void checkRandomTilesPosition(){
        Grid grid = new Grid();
        grid.generateGrid(8);
        Tile[][] tile = grid.getTiles();
        int count =0;
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                Tile t = tile[i][j];
                if (t.isDiggable()) {
                    if( t.getX() < 26 && t.getY() < 26){
                        count ++;
                    }
                    }
                }
            }
        assertEquals(8, count);
        }

    @Test
    void checkRandomEndpoint(){
        Grid grid = new Grid();
        grid.generateGrid(8);
        Tile[][] tile = grid.getTiles();
        int count =0;
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                Tile t = tile[i][j];
                if (t.isDiggable()) {
                    if( t.getX() < 26 && t.getY() < 26){
                        count ++;
                    }
                }
            }
        }
        assertEquals(8, count);
    }






    @Test
    void getLength() {
        Grid grid = new Grid();
        int length = grid.getLength();
        assertEquals(50, length);
    }
}