import javax.swing.JFrame;

public class GameWindow extends JFrame {
    public GameWindow(Game game) {      
        this.add(game);       
        this.setTitle("Chase game");
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}
