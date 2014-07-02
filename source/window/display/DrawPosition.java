package display;

public class DrawPosition {
    private int hight;
    private int width;
    private int xpos;
    private int ypos;

    public DrawPosition(int hight, int width, int xpos, int ypos) {
        this.hight = hight;
        this.width = width;
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public int getHight() {
        return this.hight;
    }

    public int getWidth() {
        return this.width;
    }

    public int xpos() {
        return this.xpos;
    }

    public int ypos() {
        return this.ypos;
    }
}
