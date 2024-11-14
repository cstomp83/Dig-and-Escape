public class IntermediateEnemy extends Enemy{
    private int moveCount;


    public IntermediateEnemy(int startPosition) {
        super(startPosition);
        moveCount = 0;
    }

    // Same movement as the chaser but only does it on the second movement
    @Override
    public void move(Grid grid, Player player) {
        if(moveCount%2==0){
            int playerX = player.getPlayerX();
            int playerY = player.getPlayerY();
            int oldX = x;
            int oldY = y;
            int distanceX = x - playerX;
            int distanceY = y - playerY;
            Tile[][] tiles = grid.getTiles();
            Tile tile = tiles[x][y];
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
        moveCount++;
        }


    }
