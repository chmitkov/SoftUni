package problem_11_Threeuple;

public class Threeuple<F, S, T> {
    private F firstValue;
    private S secondValue;
    private T thirdValue;

    public Threeuple(F firstValue, S secondValue, T thirdValue) {
        this.setFirstValue(firstValue);
        this.setSecondValue(secondValue);
        this.setThirdValue(thirdValue);
    }

    public F getFirstValue() {
        return firstValue;
    }

    private void setFirstValue(F firstValue) {
        this.firstValue = firstValue;
    }

    public S getSecondValue() {
        return secondValue;
    }

    private void setSecondValue(S secondValue) {
        this.secondValue = secondValue;
    }

    public T getThirdValue() {
        return thirdValue;
    }

    private void setThirdValue(T thirdValue) {
        this.thirdValue = thirdValue;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s",
                getFirstValue(), getSecondValue(), getThirdValue());
    }
}
