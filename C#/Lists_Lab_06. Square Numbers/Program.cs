using System;
using System.Collections.Generic;
using System.Linq;

namespace Lists_Lab_06._Square_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            List<int> result = new List<int>();
            foreach (var num in array)
            {
                if (Math.Sqrt(num) == (int)Math.Sqrt(num))
                {
                    result.Add(num);
                }
            }
            result.Sort((a, b) => b.CompareTo(a));
            Console.WriteLine(string.Join(" ",result));
        }
    }
}
