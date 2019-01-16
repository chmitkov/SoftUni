package problem_04_BubbleSort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class BubbleTest {

    private Bubble bubble;

    @Before
    public void createBubble() {
        this.bubble = new Bubble(new ArrayList<>() {{
            add(6);
            add(4);
            add(2);
            add(1);
            add(5);
        }});
    }

    @Test
    public void sort() {
        List<Integer> listBeforeSorting = this.bubble.getNumbers();
        this.bubble.sort();
        listBeforeSorting.sort(Comparator.naturalOrder());
        Assert.assertEquals(listBeforeSorting, this.bubble.getNumbers());
    }
}