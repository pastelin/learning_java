package composition_examples.challenges_02;

public class Ceiling {

    private int height;
    private int paintedColor;

    public Ceiling(int height, int color) {
        this.height = height;
        this.paintedColor = color;
    }

    public int getHeight() {
        return height;
    }

    public int getPaintedColor() {
        return paintedColor;
    }
}
