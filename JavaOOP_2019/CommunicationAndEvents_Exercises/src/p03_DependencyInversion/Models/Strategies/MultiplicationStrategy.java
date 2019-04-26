package p03_DependencyInversion.Models.Strategies;


import p03_DependencyInversion.Interfaces.CalculationStrategy;

public class MultiplicationStrategy implements CalculationStrategy{
    @Override
    public int calculate(int firstOperand, int secondOperand){
        return firstOperand * secondOperand;
    }
}
