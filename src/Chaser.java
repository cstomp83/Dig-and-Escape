
public class Chaser extends Enemy {

    public Chaser(int startPoistion) {
        super(startPoistion);
    }

    @Override
    public void move(Grid grid, Player player) {
        int playerX = player.getPlayerX();
        int playerY = player.getPlayerY();
        int oldX = x;
        int oldY = y;
        int distanceX = x - playerX;
        int distanceY = y - playerY;
        Tile[][] tiles = grid.getTiles();
        Tile tile = tiles[x][y];
        /*
        This method finds the absolute value of both y and x direction and if you are closer in the x direction
        try to go in that direction if a wall is there then will attempt to go through the y direction
         */
        if (Math.abs(distanceX) > Math.abs(distanceY)) {
            if (distanceX > 0) {
                tile = tiles[x - 1][y];
                if (!tile.isOccupied()) {
                    x = x - 1;
                }
            } else {
                tile = tiles[x + 1][y];
                if (!tile.isOccupied()) {
                    x = x + 1;
                }
            }

        } else {
            if (distanceY > 0) {
                tile = tiles[x][y - 1];
                if (!tile.isOccupied()) {
                    y = y - 1;
                }
            } else {
                tile = tiles[x][y + 1];
                if (!tile.isOccupied()) {
                    y = y + 1;
                }
            }
        }
        // This one is if the cop stay ins the same place try and move in a different
        // direction
        if (oldY == y && oldX == x) {
            if (Math.abs(distanceX) > Math.abs(distanceY)) {
                if (distanceY > 0) {
                    tile = tiles[x][y - 1];
                    if (!tile.isOccupied()) {
                        y = y - 1;
                    }
                } else {
                    tile = tiles[x][y + 1];
                    if (!tile.isOccupied()) {
                        y = y + 1;
                    }

                }
            }else  if (distanceX > 0) {
                tile = tiles[x - 1][y];
                if (!tile.isOccupied()) {
                    x = x - 1;
                }
            } else {
                tile = tiles[x + 1][y];
                if (!tile.isOccupied()) {
                    x = x + 1;
                }
            }
        }

        Tile oldTile = tiles[oldX][oldY];
        oldTile.setOccupied(false);
        Tile newTile = tiles[x][y];
        newTile.setOccupied(true);
    }
}
