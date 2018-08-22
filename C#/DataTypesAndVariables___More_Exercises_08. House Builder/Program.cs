using System;
using System.Numerics;

namespace DataTypesAndVariables___More_Exercises_08._House_Builder
{
    class Program
    {
        static void Main(string[] args)
        {
            long intPrice = 0;
            sbyte sbytePrice = 0;
            long num1 = long.Parse(Console.ReadLine());
            long num2 = long.Parse(Console.ReadLine());

            if (num1 > sbyte.MaxValue || num1 < sbyte.MinValue)
            {
                intPrice = num1;
                sbytePrice = (sbyte)num2;
            }
            else
            {
                intPrice = num2;
                sbytePrice = (sbyte)num1;
            }

            BigInteger total = sbytePrice * 4 + intPrice * 10;
            Console.WriteLine(total);
        }
    }
}
