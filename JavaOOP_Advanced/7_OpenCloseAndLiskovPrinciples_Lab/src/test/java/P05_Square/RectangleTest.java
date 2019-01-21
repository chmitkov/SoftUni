package P05_Square;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RectangleTest {
    
    private Rectangle rectangle;
    
    @Before
     public void createRectangle(){
        this.rectangle = new Rectangle();
    }
    
    @Test
    public void getSidesTest() {
        rectangle.setHeight(5);
        rectangle.setWidth(10);
        Assert.assertEquals(10, rectangle.getWidth());
        Assert.assertEquals(5, rectangle.getHeight());
    }

    @Test
    public void getAreaTest() {
        rectangle.setHeight(5);
        rectangle.setWidth(10);
        Assert.assertEquals(50, rectangle.getArea());
    }
}