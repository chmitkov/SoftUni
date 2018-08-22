using System;
using System.Collections.Generic;

namespace Methods___Exercises_06._Prime_Checker
{
    class Program
    {
        static void Main(string[] args)
        {
            int num1 = int.Parse(Console.ReadLine()); ;
            int num2 = int.Parse(Console.ReadLine()); ;
            List<int> result = new List<int>();
            for (int i = num1; i <= num2; i++)
            {
                if (IsPrime(i))
                {
                    result.Add(i);
                }
            }
            Console.WriteLine(string.Join(", ",result));
        }

        private static bool IsPrime(double n)
        {
            int counter = (int)Math.Sqrt(n);
            bool isPrime = true;
            if (n > 1)
            {
                for (int cnt = 2; cnt <= counter; cnt++)
                {
                    if (n % cnt == 0)
                    {
                        isPrime = false;
                        break;
                    }
                }
            }
            else
            {
                isPrime = false;
            }
            if (isPrime)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}