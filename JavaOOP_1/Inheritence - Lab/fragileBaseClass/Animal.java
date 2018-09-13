package fragileBaseClass;

import java.util.Collections;
import java.util.List;

public class Animal {
    protected List<Food> foodEaten;

    public final void eat(Food food) {
        this.foodEaten.add(food);
    }

    public final void eatAll(Food[] foods) {
        Collections.addAll(this.foodEaten,foods);
    }
}
