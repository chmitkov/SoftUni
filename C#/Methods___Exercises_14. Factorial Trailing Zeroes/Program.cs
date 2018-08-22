using System;
using System.Numerics;

namespace Methods___Exercises_14._Factorial_Trailing_Zeroes
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            var num = Factorial(n);
            Console.WriteLine(TrailingZeroes(num)); ;
        }

         static int TrailingZeroes(BigInteger num)
        {
            string str = num.ToString();
            var counter = 0;
            for (int i = str.Length - 1; i >= 0; i--)
            {
                if (str[i].ToString() == "0")
                {
                    counter++;
                }
                else
                {
                    return counter;
                }
            }
            return counter;
        }

        static BigInteger Factorial(int n)
        {
            BigInteger result = 1;
            for (int i = 1; i <= n; i++)
            {
                result = result * i;
            }
            return result;
        }
    }
}
