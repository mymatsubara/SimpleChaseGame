public class Main {
    public static void main(String[] args) {  
        GameConfig config = new GameConfig(35, 35, 20, 5, 500);
        Game game = new Game(config);
        GameWindow gw = new GameWindow(game);        
    }
}