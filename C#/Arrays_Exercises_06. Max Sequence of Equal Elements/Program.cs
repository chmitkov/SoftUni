using System;
using System.Linq;

namespace Arrays_Exercises_06._Max_Sequence_of_Equal_Elements
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();

            int counter = 0;
            int counterMax = 0;
            int index = 0;
            int indexMax = 0;
            for (int i = 0; i < nums.Length - 1; i++)
            {
                if (nums[i] == nums[i + 1])
                {
                    index = i;
                    counter++;
                    if (counter > counterMax)
                    {
                        counterMax = counter;
                        indexMax = i;
                    }
                }
                else
                {
                    counter = 0;
                }
            }
            for (int i = indexMax - counterMax + 1; i <= indexMax + 1; i++)
            {
                Console.Write(nums[i] + " ");
            }
        }
    }
}
