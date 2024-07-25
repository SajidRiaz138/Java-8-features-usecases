package org.functions.bifunction;

import java.util.function.BiFunction;

public class Calculator
{
    public static void main(String[] args)
    {
        BiFunction<Double, Double, Double> add = (a, b) -> a + b;
        BiFunction<Double, Double, Double> subtract = (a, b) -> a - b;
        BiFunction<Double, Double, Double> divide = (a, b) ->
        {
            if (b == 0)
            {
                throw new ArithmeticException("Divide by Zero");
            }
            return a / b;
        };

        System.out.println("Addition : " + calculate(3, 3, add));
        System.out.println("Subtract : " + calculate(3, 3, subtract));
        System.out.println("Divide : " + calculate(3, 3, divide));
    }

    private static double calculate(double a, double b, BiFunction<Double, Double, Double> operation)
    {
        return operation.apply(a, b);
    }
}
