using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SortList
{
    class Program
    {
        static void Main(string[] args)
        {
            var nums = Console.ReadLine().Split(' ').Select(decimal.Parse).ToList();
            nums.Sort();
            Console.WriteLine(String.Join(" <= ", nums));
            nums.Reverse();
            for (int i = 0; i < 3; i++)
            {
                Console.WriteLine(nums[i]);
            }
        }
    }
}
