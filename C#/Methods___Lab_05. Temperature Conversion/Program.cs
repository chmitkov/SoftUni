using System;

namespace Methods___Lab_05._Temperature_Conversion
{
    class Program
    {
        static void Main(string[] args)
        {
            FromFarToC(decimal.Parse(Console.ReadLine()));
        }

         static void FromFarToC(decimal v)
        {
           decimal result = (v - 32) * 5 / 9;
            Console.WriteLine($"{result:F2}");
        }
    }
}
