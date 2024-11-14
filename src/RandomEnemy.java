import java.util.Random;

public class RandomEnemy extends Enemy{
    private Random rand = new Random();

    public RandomEnemy(int startPosition) {
        super(startPosition);
    }
    // moves randomly moves enemy
    @Override
    public void move(Grid grid,Player player) {
        Tile[][] tiles = grid.getTiles();
            Tile tile;
            int moveChoice = rand.nextInt(3);
            switch (moveChoice) {

                case 0:
                    if (y > 0) {
                        tile = tiles[x][y-1];
                        if(!tile.isOccupied()){
                            y =y-1;
                        }
                        break;
                    }
                case 1:
                    if (y < 24) {
                        tile = tiles[x][y+1];
                        if(!tile.isOccupied()){
                            y =y+1;
                        }
                        break;
                    }
                case 2:
                    if (x > 0) {
                        tile = tiles[x-1][y];
                        if(!tile.isOccupied()){
                            x--;
                        }
                        break;
                    }
                case 3:
                    if (x < 24) {
                        tile = tiles[x+1][y];
                        if(!tile.isOccupied()){
                            x++;
                        }
                        break;
                    }
            }
        }



    }
