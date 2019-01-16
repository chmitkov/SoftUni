package problem_03_ListIterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator listIterator;

    @Before
    public void creteListIterator() {
        this.listIterator = new ListIterator();
    }


    @Test
    public void move() throws NoSuchFieldException, IllegalAccessException {
        Field index = this.listIterator.getClass()
                .getDeclaredField("index");
        index.setAccessible(true);
        int indexBeforeMove = index.getInt(this.listIterator);

        this.listIterator.move();

        Assert.assertEquals(++indexBeforeMove, index.getInt(this.listIterator));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void printWithZeroStringListSize() throws OperationNotSupportedException {
        this.listIterator.print();
    }

}