import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // Screen settings displayed here
    // Set pixel size
    final int originalPixelSize = 16;
    final int scale = 3;
    // Size of the tiles on screen
    final int pixelSize = originalPixelSize * scale;
    final int maxScreenCol = 50;
    final int maxScreenRow = 50;
    final int screenWidth = pixelSize * maxScreenCol;
    final int screenHeight = pixelSize * maxScreenRow;
    int FPS = 60;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;


    int playerX = 100 , playerY =100, playerSpeed =4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // ??
        this.addKeyListener(keyHandler);
        this.setFocusable(true); // The Game panel can be focused to receive key input


    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // Creating game loop in this run method
    /* two things we doing in this run method
    1. Update the game logic
    2. Repaint the screen

     */
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta =0;
        long lastTime = System.nanoTime();
        long currentTime;
        while(true) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if(delta >= 1) {
                update();
                repaint(); // calls paintComponet
                delta --;
            }


        }


    }

    public void update(){

        if (keyHandler.upPressed==true){
            playerY -= playerSpeed;
        }
        else if (keyHandler.downPressed==true){
            playerY += playerSpeed;
        }
        else if (keyHandler.leftPressed==true){
            playerX -= playerSpeed;

        }
        else if (keyHandler.rightPressed==true){
            playerX += playerSpeed;
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.fillRect(playerX, playerY, pixelSize, pixelSize);
        g2d.dispose();
    }
}
