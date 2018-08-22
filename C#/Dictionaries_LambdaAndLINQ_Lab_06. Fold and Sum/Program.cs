using System;
using System.Collections.Generic;
using System.Linq;

namespace Dictionaries_LambdaAndLINQ_Lab_06._Fold_and_Sum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            int k = nums.Length / 4;

            List<int> upper = new List<int>();
            List<int> down = new List<int>();
            List<int> result = new List<int>();

            upper.AddRange(nums.Take(k).Reverse());
            upper.AddRange(nums.TakeLast(k).Reverse());
            down.AddRange(nums.Skip(k).Take(k * 2));

            for (int i = 0; i < upper.Count; i++)
            {
                result.Add(upper[i] + down[i]);
            }
            Console.WriteLine(string.Join(" ", result));

        }
    }
}
