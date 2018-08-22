using System;
using System.Numerics;

namespace Methods___Exercises_13._Factorial
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            Factorial(n);
        }

         static void Factorial(int n)
        {
            BigInteger result = 1;
            for (int i = 1; i <= n; i++)
            {
                result = result * i;
            }
            Console.WriteLine(result);
        }
    }
}
