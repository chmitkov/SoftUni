using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LargestNElemenst
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> nums = Console.ReadLine().Split().Select(int.Parse)
                .ToList();
            int n = int.Parse(Console.ReadLine());
            nums.Sort();
            nums.Reverse();
            for (int i = 0; i < n; i++)
            {
                Console.WriteLine(nums[i]);
            }
        }
    }
}
