import java.util.Random;

public class Position {
   private int x;
   private int y;
   
   public Position(int x, int y) {
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

   public String toString() {
       return String.format("(%d, %d)", x, y);
   }

   public boolean equals(Position pos) {
        return this.x == pos.getX() && this.y == pos.getY();
   }

   static Position generateRandom(GameConfig config) {  
       Random random = new Random();     
       return new Position(random.nextInt(config.getWidth()), random.nextInt(config.getHeight()));
   }
}
