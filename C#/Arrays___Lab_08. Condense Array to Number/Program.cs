using System;
using System.Linq;

namespace Arrays___Lab_08._Condense_Array_to_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();

            int length = nums.Length;
            while (length-- > 1)
            {
                int[] currNums =new int [length];
                for (int i = 0; i < nums.Length-1; i++)
                {
                    currNums[i] = nums[i] + nums[i + 1];
                }
                nums = currNums;
            }
            Console.WriteLine(string.Join(" ",nums));
        }
    }
}
