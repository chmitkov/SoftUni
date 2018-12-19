package problem_10_Tuple;

public class Tuple<F, S> {
    private F firstValue;
    private S secondValue;

    public Tuple(F firstValue, S secondValue) {
        this.setFirstValue(firstValue);
        this.setSecondValue(secondValue);
    }

    public F getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(F firstValue) {
        this.firstValue = firstValue;
    }

    public S getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(S secondValue) {
        this.secondValue = secondValue;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.getFirstValue(), this.getSecondValue());
    }
}
