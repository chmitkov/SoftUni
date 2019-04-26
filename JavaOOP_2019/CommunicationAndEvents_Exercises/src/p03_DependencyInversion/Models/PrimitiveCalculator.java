package p03_DependencyInversion.Models;

import p03_DependencyInversion.Interfaces.CalculationStrategy;
import p03_DependencyInversion.Models.Strategies.AdditionStrategy;

public class PrimitiveCalculator {
    private CalculationStrategy strategy;

    public PrimitiveCalculator(){
        this.strategy = new AdditionStrategy();
    }

    public PrimitiveCalculator(CalculationStrategy strategy){
        this.strategy = strategy;
    }

    public void changeStrategy(CalculationStrategy strategy){
        this.strategy = strategy;
    }

    public int performCalculation(int firstOperand,int secondOperand){
        return this.strategy.calculate(firstOperand,secondOperand);
    }
}
