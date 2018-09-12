package classBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    /*
    Volume = lwh
    Lateral Surface Area = 2lh + 2wh
    Surface Area = 2lw + 2lh + 2wh
     */
    private double surfaceArea() {
        return 2 * this.length * this.width + 2 * this.length * this.height
                + 2 * this.width * this.height;
    }

    private double lateralSurfaceArea() {
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }

    private double volume() {
        return this.length * this.width * this.height;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f\n" +
                        "Lateral Surface Area - %.2f\n" +
                        "Volume - %.2f",
                surfaceArea(), lateralSurfaceArea(), volume()
        );
    }
}
