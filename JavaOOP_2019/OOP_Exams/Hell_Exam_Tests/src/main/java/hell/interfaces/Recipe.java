package hell.interfaces;

import java.util.List;

public interface Recipe extends Item {
    List<String> getRequiredItems();
}
