import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class GridPanel extends JPanel {
    private Grid grid;
    private int tileSize = 20;  // Size of each tile
    ArrayList<Enemy> pieces = new ArrayList<>();


    public GridPanel(Grid grid) {
        this.grid = grid;
        setPreferredSize(new Dimension(grid.getLength() * tileSize, grid.getLength() * tileSize));
        addEnemeys();
    }

    public void addEnemeys(){
        pieces.add(new Chaser(0,0));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Tile[][] tiles = grid.getTiles();
        for (int i = 0; i < grid.getLength(); i++) {
            for (int j = 0; j < grid.getLength(); j++) {
                Tile tile = tiles[i][j];
                if (tile.getColor() == "white") {
                    g.setColor(Color.white);
                }else{
                    g.setColor(Color.BLACK);
                }
                g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
                g.drawRect(grid.getLength() * tileSize, grid.getLength() * tileSize, tileSize, tileSize);


            }

        }
        for (Enemy piece : pieces) {
            piece.paint(g);

        }






    }
}
