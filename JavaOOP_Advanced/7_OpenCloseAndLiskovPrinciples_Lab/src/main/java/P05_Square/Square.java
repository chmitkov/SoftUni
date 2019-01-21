package P05_Square;

public class Square extends Rectangle {

    @Override
    public void setWidth(int width){
        super.setWidth(width);
    }

    @Override
    public void setHeight(int height){
        super.setWidth(height);
    }

    @Override
    public int getArea() {
        return super.getWidth() * super.getWidth();
    }
}
