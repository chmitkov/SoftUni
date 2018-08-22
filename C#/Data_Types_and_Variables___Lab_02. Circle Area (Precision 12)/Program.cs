using System;

namespace Data_Types_and_Variables___Lab_02._Circle_Area__Precision_12_
{
    class Program
    {
        static void Main(string[] args)
        {
            double r = double.Parse(Console.ReadLine());
            Console.WriteLine($"{(Math.PI*r*r):F12}");
        }
    }
}
