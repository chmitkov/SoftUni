using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OddNumsInOddPositions
{
    class Program
    {
        static void Main(string[] args)
        {
            var nums = Console.ReadLine().Split().ToArray();
            int[] array = new int[nums.Length];
            for (int i = 0; i < array.Length; i++)
            {
                array[i] = int.Parse(nums[i]);
            }
            for (int i = 0; i < array.Length; i++)
            {
                if (array[i] % 2 != 0 && i % 2 != 0)
                {
                    //Console.WriteLine("Index {0} -> {1}", i, array[i]);
                    Console.WriteLine($"Index {i} -> {array[i]}");
                }
            }
        }
    }
}
