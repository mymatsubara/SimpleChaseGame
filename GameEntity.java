public abstract class GameEntity {
    protected Position pos;

    public GameEntity(Position pos) {
        this.pos = pos;
    }

    public Position getPosition() {
        return pos;
    }
}
