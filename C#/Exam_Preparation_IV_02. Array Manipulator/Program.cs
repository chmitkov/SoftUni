using System;
using System.Collections.Generic;
using System.Linq;

namespace Exam_Preparation_IV_02._Array_Manipulator
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            string input = Console.ReadLine();
            while (input != "end")
            {
                string[] commands = input
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

                var action = commands[0];

                switch (action)
                {
                    case "exchange":
                        if (int.Parse(commands[1]) < 0 || int.Parse(commands[1]) >= nums.Length)
                        {
                            Console.WriteLine("Invalid index");
                        }
                        else
                        {
                            nums = Exchange(nums, int.Parse(commands[1]));
                        }
                        break;
                    case "max":
                        Max(nums, commands[1]);
                        break;
                    case "min":
                        Min(nums, commands[1]);
                        break;
                    case "first":
                        if (int.Parse(commands[1]) > nums.Length)
                        {
                            Console.WriteLine("Invalid count");
                        }
                        else
                        {
                            TakeFirst(nums, int.Parse(commands[1]), commands[2]);
                        }
                        break;
                    case "last":
                        if (int.Parse(commands[1]) > nums.Length)
                        {
                            Console.WriteLine("Invalid count");
                        }
                        else
                        {
                            TakeLast(nums, int.Parse(commands[1]), commands[2]);
                        }
                        break;
                }

                input = Console.ReadLine();
            }
            Console.WriteLine($"[{string.Join(", ", nums)}]");
        }

        private static void TakeLast(int[] nums, int v1, string v2)
        {
            List<int> result = new List<int>();
            if (v2 == "odd")
            {
                result.AddRange(nums.Where(x => x % 2 == 1).ToList().TakeLast(v1));
            }
            else
            {
                result.AddRange(nums.Where(x => x % 2 == 0).ToList().TakeLast(v1));
            }
            Console.WriteLine($"[{string.Join(", ", result)}]");
        }

        private static void TakeFirst(int[] nums, int v1, string v2)
        {
            List<int> result = new List<int>();
            if (v2 == "odd")
            {
                result.AddRange(nums.Where(x => x % 2 == 1).ToList().Take(v1));
            }
            else
            {
                result.AddRange(nums.Where(x => x % 2 == 0).ToList().Take(v1));
            }
            Console.WriteLine($"[{string.Join(", ", result)}]");
        }

        private static void Min(int[] nums, string v)
        {
            var minNum = int.MaxValue;
            var index = 0;
            if (v == "odd")
            {
                for (int i = 0; i < nums.Length; i++)
                {
                    if (nums[i] <= minNum && nums[i] % 2 == 1)
                    {
                        minNum = nums[i];
                        index = i;
                    }
                }
            }
            else
            {
                for (int i = 0; i < nums.Length; i++)
                {
                    if (nums[i] <= minNum && nums[i] % 2 == 0)
                    {
                        minNum = nums[i];
                        index = i;
                    }
                }
            }
            if (minNum != int.MaxValue)
            {
                Console.WriteLine(index);
            }
            else
            {
                Console.WriteLine("No matches");
            }
        }

        private static void Max(int[] nums, string v)
        {
            var maxNum = int.MinValue;
            var maxIndex = 0;
            if (v == "odd")
            {
                for (int i = 0; i < nums.Length; i++)
                {
                    if (nums[i] >= maxNum && nums[i] % 2 == 1)
                    {
                        maxNum = nums[i];
                        maxIndex = i;
                    }
                }
            }
            else
            {
                for (int i = 0; i < nums.Length; i++)
                {
                    if (nums[i] >= maxNum && nums[i] % 2 == 0)
                    {
                        maxNum = nums[i];
                        maxIndex = i;
                    }
                }
            }
            if (maxNum != int.MinValue)
            {
                Console.WriteLine(maxIndex);
            }
            else
            {
                Console.WriteLine("No matches");
            }
        }

        private static int[] Exchange(int[] nums, int v)
        {
            var currArray = new int[nums.Length];
            var counter = 0;
            for (int i = v + 1; i < nums.Length; i++)
            {
                currArray[counter] = nums[i];
                counter++;
            }
            for (int i = 0; i <= v; i++)
            {
                currArray[counter] = nums[i];
                counter++;
            }
            return currArray;
        }
    }
}
