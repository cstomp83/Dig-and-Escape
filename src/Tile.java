public class Tile {
    private final int cordX;
    private final int cordY;
    private boolean isDiggable;
    private String color;
    private boolean isEndpoint;
    private boolean isOccupied;

    public Tile(boolean isDiggable,boolean isEndpoint, String color, int cordX, int cordY) {
        this.isDiggable = isDiggable;
        this.color = color;
        this.isEndpoint = isEndpoint;
        this.cordX = cordX;
        this.cordY = cordY;
        isOccupied = false;
    }

    public boolean isDiggable() {
        return isDiggable;
    };

    public void setDiggable(boolean diggable) {
        isDiggable = diggable;
    }

    public void setIsEndpoint(boolean endpoint) {
        isEndpoint = endpoint;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean dig(Tile tile) {
        if (tile.isDiggable) {
            if (tile.isEndpoint) {
                return true;
            } else{
                tile.setColor("white");
                tile.setDiggable(false);
                return false;
            }
        }
        return false;
    }

    public int getX(){
        return cordX;
    }

    public int getY(){
        return cordY;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

}
