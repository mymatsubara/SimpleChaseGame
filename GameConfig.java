public class GameConfig {
    private int width;
    private int height;
    private int unitSize;
    private int maxRabbits;
    private int delay;

    public GameConfig(int width, int height, int unitSize, int maxRabbits, int delay) {
        this.width = width;
        this.height = height;
        this.unitSize = unitSize;
        this.maxRabbits = maxRabbits;
        this.delay = delay;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getMaxRabbits() {
        return maxRabbits;
    }

    public int getDelay() {
        return delay;
    }

    public int getUnitSize() {
        return unitSize;
    }

    public int getWidthPx() {
        return unitSize * width;
    }

    public int getHeightPx() {
        return unitSize * height;
    }
}
