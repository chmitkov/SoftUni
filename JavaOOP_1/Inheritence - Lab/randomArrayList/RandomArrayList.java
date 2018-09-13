package randomArrayList;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    private Random random;

    public RandomArrayList() {
        this.random = new Random();
    }

    public Object getRandomElement() {
        int randomIndex = this.random.nextInt(super.size());
        Object element = super.get(randomIndex);
        super.remove(element);
        return element;
    }
}
