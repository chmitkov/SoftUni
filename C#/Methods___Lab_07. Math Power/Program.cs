using System;

namespace Methods___Lab_07._Math_Power
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(MathPower(double.Parse(Console.ReadLine())
                , int.Parse(Console.ReadLine())));
        }

        static double MathPower(double v1, int v2)
        {
            double result = v1;
            for (int i = 2; i <= v2; i++)
            {
                result = result * v1;
            }
            return result;
        }
    }
}
