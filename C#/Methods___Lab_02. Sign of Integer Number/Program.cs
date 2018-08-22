using System;

namespace Methods___Lab_02._Sign_of_Integer_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            NumberSign(int.Parse(Console.ReadLine()));
        }

         static void NumberSign(int v)
        {
            if (v > 0)
            {
                Console.WriteLine($"The number {v} is positive.");
            }
            else if (v < 0)
            {
                Console.WriteLine($"The number {v} is negative.");
            }
            else
            {
                Console.WriteLine($"The number {v} is zero.");
            }
        }
    }
}
