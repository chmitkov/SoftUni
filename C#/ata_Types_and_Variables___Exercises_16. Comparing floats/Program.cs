using System;

namespace Data_Types_and_Variables___Exercises_16._Comparing_floats
{
    class Program
    {
        static void Main(string[] args)
        {
            double firstNumber = (double.Parse(Console.ReadLine()));
            double secondNumber = (double.Parse(Console.ReadLine()));
            bool equal = Math.Abs(firstNumber - secondNumber) < 0.000001;
            Console.WriteLine(equal);
        }
    }
}
