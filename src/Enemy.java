import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public abstract class Enemy {
    protected int x;
    protected int y;
    protected Image image;
    {
        try{
            image = ImageIO.read(ClassLoader.getSystemResourceAsStream("enemy.png"));
            image = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Enemy (int x, int y) {
        this.x = x;
        this.y = y;
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
        g.drawImage(image, x, y, null);
    }

    public abstract void move();

}
