using System;

namespace Data_Types_and_Variables___Exercises_14.IntegertoHexandBinary
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            var hex  = Convert.ToString(n, 16).ToUpper();
            var binary = Convert.ToString(n, 2);
            Console.WriteLine(hex);
            Console.WriteLine(binary);
        }
    }
}
