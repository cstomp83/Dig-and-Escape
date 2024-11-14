import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void moveUp(){
        Player p = new Player();
        Grid g = new Grid();
        g.generateGrid(2);
        p.move(g,10,19);
        assertEquals(10,p.getPlayerX());
        assertEquals(19,p.getPlayerY());
    }

    @Test
    void getX() {
    }

    @Test
    void getY() {
    }

    @Test
    void setX() {
    }

    @Test
    void setY() {
    }

    @Test
    void getLegalMoves(){

    }
}