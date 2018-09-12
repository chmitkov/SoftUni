package classBoxDataValidation;

public class BoxWithValidation {
    private double length;
    private double width;
    private double height;

    public BoxWithValidation(Double length, Double width, Double height){
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

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
