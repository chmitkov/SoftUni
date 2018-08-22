using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OddNumbersInOddPositions
{
    class Program
    {
        static void Main(string[] args)
        {
            var nums = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            for (int i = 0; i < nums.Length; i++)
            {
                if (i % 2 != 0 && Math.Abs(nums[i]) % 2 != 0)
                {
                    Console.WriteLine($"Index {i} -> {nums[i]}");
                }
            }
        }
    }
}
