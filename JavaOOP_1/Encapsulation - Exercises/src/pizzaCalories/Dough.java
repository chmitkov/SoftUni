package pizzaCalories;

public class Dough {
    private String type;
    private String bakingTechnique;
    private int doughWeight;

    public Dough(String type, String bakingTechnique, int doughWeight) {
        setType(type);
        setBakingTechnique(bakingTechnique);
        setDoughWeight(doughWeight);
    }

    private void setDoughWeight(Integer doughWeight) {
        if (doughWeight < 1 || doughWeight > 200) {
            throw new IllegalArgumentException(
                    "Dough weight should be in the range [1..200].");
        }
        this.doughWeight = doughWeight;
    }

    private void setType(String type) {
        if (!"White".equals(type) && !"Wholegrain".equals(type)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.type = type;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!"Crispy".equals(bakingTechnique) &&
                !"Chewy".equals(bakingTechnique) &&
                !"Homemade".equals(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private double getTypeModifier() {
        return this.type.equals("White") ?
                1.5 : 1.0;
    }

    private double getBakingTechniqueModifier() {
        double result = 0;
        switch (this.bakingTechnique) {
            case "Crispy":
                result = 0.9;
                break;
            case "Chewy":
                result = 1.1;
                break;
            case "Homemade":
                result = 1;
                break;
        }
        return result;
    }

    public double getDougCalories() {
        return this.doughWeight * 2 * getTypeModifier() * getBakingTechniqueModifier();
    }
}
