using System;
using System.Linq;

namespace Arrays___Lab_05._Rounding_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            double[] nums = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(double.Parse)
                .ToArray();

            foreach (var num in nums)
            {
                var rounded = Math.Round(num, MidpointRounding.AwayFromZero);
                Console.WriteLine($"{num} => {rounded}");
            }
        }
    }
}
