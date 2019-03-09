package p11_Threeuple;

public class Threeuple<F, S, T> {

    private F firstItem;
    private S secondItem;
    private T thirdItem;

    public Threeuple(F firstItem, S secondItem, T thirdItem) {
        this.firstItem = firstItem;
        this.secondItem = secondItem;
        this.thirdItem = thirdItem;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.firstItem,
                this.secondItem, this.thirdItem);
    }
}
