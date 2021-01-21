import java.awt.event.KeyEvent;

public class Rabbit extends GameEntity {
    public Rabbit(Position pos) {
        super(pos);
    }  

    public void move(Player p, GameConfig config) {
        if (pos.getX() < p.getPosition().getX()) {
            if (pos.getX() != 0) {
                pos.setX(pos.getX() - 1);
            } else {
                teleport(config);
            }
        } else if (pos.getX() > p.getPosition().getX()) {
            if (pos.getX() != config.getWidth() - 1) {
                pos.setX(pos.getX() + 1);
            } else {
                teleport(config);
            }
        }

        if (pos.getY() < p.getPosition().getY()) {
            if (pos.getY() != 0) {
                pos.setY(pos.getY() - 1);
            } else {
                teleport(config);
            } 
        } else if (pos.getY() > p.getPosition().getY()) {
            if (pos.getY() != config.getHeight() - 1) {
                pos.setY(pos.getY() + 1);
            } else {
                teleport(config);
            }   
        }
    }

    private void teleport(GameConfig config) {
        pos = Position.generateRandom(config);
    }
}
