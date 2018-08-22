using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Odd_EvenPosition
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var evenSum = 0.0;
            var evenMax = double.MinValue;
            var evenMin = double.MaxValue;
            var oddSum = 0.0;
            var oddMax = double.MinValue;
            var oddMin = double.MaxValue;
            for (int i = 1; i <= n; i++)
            {
                var num = double.Parse(Console.ReadLine());
                if (i % 2 == 0)
                {
                    if (num > evenMax)
                    {
                        evenMax = num;
                    }
                    if (num < evenMin)
                    {
                        evenMin = num;
                    }
                    evenSum += num;
                }
                else
                {
                    if (num > oddMax)
                    {
                        oddMax = num;
                    }
                    if (num < oddMin)
                    {
                        oddMin = num;
                    }
                    oddSum += num;
                }
            }
            if (n == 0)
            {
                Console.WriteLine("OddSum = {0},\nOddMin = {1},\nOddMax = {2},\nEvenSum = {3},\nEvenMin = {4},\nEvenMax = {5}"
               , oddSum, "No", "No", evenSum, "No", "No");
            }
            else if (n == 1)
            {
                Console.WriteLine("OddSum = {0},\nOddMin = {1},\nOddMax = {2},\nEvenSum = {3},\nEvenMin = {4},\nEvenMax = {5}"
               , oddSum, oddMin, oddMax, evenSum, "No", "No");
            }
            else
            {
                Console.WriteLine("OddSum = {0},\nOddMin = {1},\nOddMax = {2},\nEvenSum = {3},\nEvenMin = {4},\nEvenMax = {5}"
                , oddSum, oddMin, oddMax, evenSum, evenMin, evenMax);
            }
            
        }
    }
}
