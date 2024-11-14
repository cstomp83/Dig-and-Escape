import javax.imageio.ImageIO;
import java.awt.*;
// Enemy every enemy inherits this with a start position
public abstract class Enemy {
    protected int x;
    protected int y;
    protected int startPoistion;
    protected Image image;
    {
        try{
            image = ImageIO.read(ClassLoader.getSystemResourceAsStream("southparkcop.png"));
            image = image.getScaledInstance(28, 28, Image.SCALE_SMOOTH);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Enemy (int startPostion) {
        this.startPoistion = startPostion;
        y = 1*startPostion;
        x = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paint(Graphics g) {
        g.drawImage(image, x*GridPanel.TILE_SIZE, y*GridPanel.TILE_SIZE, null);
    }

    public abstract void move(Grid grid, Player player);

}
