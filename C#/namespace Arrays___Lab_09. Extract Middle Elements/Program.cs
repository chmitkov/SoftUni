using System;
using System.Linq;

namespace Arrays___Lab_09._Extract_Middle_Elements
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();

            if (nums.Length == 1)
            {
                Console.WriteLine("{ " + $"{string.Join(", ", nums)}" + " }");
            }
            else if (nums.Length % 2 == 0)
            {
                int[] result = new int[2];
                int counter = 1;
                for (int i = nums.Length / 2 - 1; i < nums.Length/2 + 1; i++)
                {
                    if (counter == 1)
                    {
                        Console.Write("{ ");
                        Console.Write($"{nums[i]}, ");
                    }
                    else
                    {
                        Console.Write($"{nums[i]}");
                        Console.WriteLine(" }");
                    }
                    counter++;
                }
            }
            else if (nums.Length % 2 != 0)
            {
                int[] result = new int[3];
                int counter = 1;
                for (int i = nums.Length / 2 - 1; i <= nums.Length/2 + 1; i++)
                {
                    if (counter == 1)
                    {
                        Console.Write("{ ");
                        Console.Write($"{nums[i]}, ");
                    }
                    else if (counter == 2)
                    {
                        Console.Write($"{nums[i]}, ");
                    }
                    else
                    {
                        Console.Write($"{nums[i]}");
                        Console.WriteLine(" }");
                    }
                    counter++;
                }
            }
        }
    }
}
