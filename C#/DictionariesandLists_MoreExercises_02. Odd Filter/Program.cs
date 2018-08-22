using System;
using System.Linq;

namespace DictionariesandLists_MoreExercises_02._Odd_Filter
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .Where(x => x % 2 == 0)
                .ToArray();
            var average = nums.Average();
            for (int i = 0; i < nums.Length; i++)
            {
                if (nums[i] > average)
                {
                    nums[i]++;
                }
                else if (nums[i] < average)
                {
                    nums[i]--;
                }
            }
            Console.WriteLine(string.Join(" ",nums));

        }
    }
}
