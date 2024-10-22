import java.util.Random;

public class RandomEnemy extends Enemy{
    private Random rand = new Random();

    public RandomEnemy(int x, int y) {
        super(x, y);
    }

    @Override
    public void move() {
        int x = getX();
        int y = getY();

        int moveChoice = rand.nextInt(3);
        switch (moveChoice) {
            case 0:
                if (y > 0) {
                    setY(y - 1);
                    break;
                }
            case 1:
                if (y < 49) {
                    setY(y + 1);
                    break;
                }
            case 2:
                if(x > 0){
                    setX(x - 1);
                    break;
                }
            case 3:
                if(x < 49){
                    setX(x + 1);
                    break;
                }
        default:
            break;
        }


    }
}
