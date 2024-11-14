import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    @Test
    void isDiggable() {
        Tile tile = new Tile(true,false,"purple", 2, 2);
        assertTrue(tile.isDiggable());
    }

    @Test
    void setDiggable() {
        Tile tile = new Tile(true,false,"purple", 2, 2);
        tile.setDiggable(false);
        assertFalse(tile.isDiggable());
    }

    @Test
    void setEndpoint() {
        Tile tile = new Tile(true,false,"purple", 2, 2);
        tile.setIsEndpoint(true);
        assertTrue(tile.isDiggable());
    }

    @Test
    void diggableTileDigColorTest() {
        Tile tile = new Tile(true,false,"purple", 2, 2);
        tile.dig(tile);
        assertEquals("white", tile.getColor());
    }

    @Test
    void nonDiggableTileDigColorTest() {
        Tile tile = new Tile(false,false,"white", 2, 2);
        tile.dig(tile);
        assertEquals("white", tile.getColor());
    }

    @Test
    void nonDiggableTile(){
        Tile tile = new Tile(false,false,"white", 2, 2);
        assertFalse(tile.dig(tile));
    }

    @Test
    void diggableTileNotEndpoint(){
        Tile tile = new Tile(true,false,"purple", 2, 2);
        assertFalse(tile.dig(tile));
    }

    @Test
    void setOccupied(){
        Tile tile = new Tile(true,false,"purple", 2, 2);
        tile.setOccupied(true);
        assertTrue(tile.isOccupied());
    }
    @Test
    void findTileInGrid(){
        Grid grid = new Grid();
        grid.generateGrid(0);
        Tile[][] tileGrid = grid.getTiles();
        Tile tile = tileGrid[0][0];
        assertFalse(tile.isDiggable());
        assertEquals(tile.getX(),0);
        assertEquals(tile.getY(),0);
        assertEquals(tile.getColor(),"white");

    }
}