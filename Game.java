import java.awt.event.KeyListener;
import java.time.Duration;
import java.time.Instant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class Game extends JPanel implements KeyListener, ActionListener {
    private GameConfig config;
    private Player player;
    private ArrayList<Rabbit> rabbits = new ArrayList<Rabbit>();
    private Timer t;
    private boolean isRunning;
    private Instant startTime, endTime;

    public Game(GameConfig config) {
        this.config = config;
        this.setPreferredSize(new Dimension(config.getWidthPx(), config.getHeightPx() + 20));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(this);

        startGame();
    }

    private void startGame() {
        this.isRunning = true;
        populateGame();
        t = new Timer(config.getDelay(), this);
        t.start();
        startTime = Instant.now();
    }

    private void populateGame() {
        player = new Player(new Position(config.getWidth() / 2, config.getHeight() / 2));

        rabbits.clear();
        for (int i = 0; i < config.getMaxRabbits(); i++) {
            rabbits.add(new Rabbit(Position.generateRandom(config)));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (isRunning) {        
            g.setColor(Color.green);
            g.fillRect(player.getPosition().getX() * config.getUnitSize(), player.getPosition().getY() * config.getUnitSize(), 
                config.getUnitSize(), config.getUnitSize());
            
            g.setColor(Color.red);
            for (Rabbit rabbit : rabbits) {
                g.fillRect(rabbit.getPosition().getX() * config.getUnitSize(), rabbit.getPosition().getY() * config.getUnitSize(), 
                config.getUnitSize(), config.getUnitSize());
            }        
            
            g.setColor(Color.white);
            g.drawRect(0, 0, config.getWidthPx() - 1, config.getHeightPx());

            g.setFont(new Font("TimesRoman", Font.BOLD, 15));
            g.drawString("Time: " + Duration.between(startTime, Instant.now()).toMillis() / 1000 + " s", config.getWidthPx() - 170, config.getHeightPx() + 16);
        } else {
            g.setColor(Color.white);
            g.setFont(new Font("TimesRoman", Font.BOLD, 40));
            String msg = "Try again? Press '1'";
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString(msg, (config.getWidthPx() - metrics.stringWidth(msg)) / 2 , config.getHeightPx() / 2);
            msg = String.format("Time: %.2fs", (Duration.between(startTime, endTime).toMillis() / 1000.0));
            g.drawString(msg, (config.getWidthPx() - metrics.stringWidth(msg)) / 2 , config.getHeightPx() / 2 - 50);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (isRunning) {
            player.move(e.getKeyCode(), config);
            handleCollisions();
        } else {
            if (e.getKeyCode() == KeyEvent.VK_1) {
                startGame();
            }
        }
        repaint();
    }

    private void handleCollisions() {
        ArrayList<Rabbit> rabbitsToRemove = new ArrayList<Rabbit>();
        for (Rabbit rabbit : rabbits) {
            if (rabbit.getPosition().equals(player.getPosition())) {
                rabbitsToRemove.add(rabbit);
            }
        }
        
        for (Rabbit rabbitToRemove : rabbitsToRemove) {
            rabbits.remove(rabbitToRemove);
        }

        if (rabbits.size() == 0) {
            isRunning = false;
            endTime = Instant.now();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Rabbit rabbit : rabbits) {
            rabbit.move(player, config);
        }
        repaint();
    }
}
