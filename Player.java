import java.awt.event.KeyEvent;

public class Player extends GameEntity {
    public Player(Position pos) {
        super(pos);
    }

    public void move(int key, GameConfig config) {
        switch (key) {
            case KeyEvent.VK_RIGHT:
                if (pos.getX() != config.getWidth() - 1) {
                    pos.setX(pos.getX() + 1);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (pos.getX() != 0) {
                    pos.setX(pos.getX() - 1);
                }
                break;
            case KeyEvent.VK_DOWN:   
                if (pos.getY() != config.getHeight() - 1) {
                    pos.setY(pos.getY() + 1);
                }   
                break;      
            case KeyEvent.VK_UP:
                if (pos.getY() != 0) {
                    pos.setY(pos.getY() - 1);
                }  
                break;       
        }
    }
}
