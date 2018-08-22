using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam_Preparation_IV_02._Array_Manipulator
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToList();
            string input = Console.ReadLine();
            while (input != "end")
            {
                string[] commands = input
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                switch (commands[0])
                {
                    case "exchange":
                        
                        var index = int.Parse(commands[1]);
                        if (index >= numbers.Count)
                        {
                            Console.WriteLine("Invalid index");
                        }
                        else
                        {
                            List<int> current = new List<int>();
                            current.AddRange(numbers.Skip(index + 1));
                            current.AddRange(numbers.Take(index + 1));
                            numbers = current;
                        }                       
                        break;
                    case "max":
                        if (commands[1] == "even")
                        {
                            var bestIndex = 0;
                            var currMax = int.MinValue;
                            for (int i = 0; i < numbers.Count; i++)
                            {
                                if (numbers[i] % 2 == 0 && numbers[i] >= currMax)
                                {
                                    currMax = numbers[i];
                                    bestIndex = i;
                                }
                            }
                            if (currMax == int.MinValue)
                            {
                                Console.WriteLine("No matches");
                            }
                            else
                            {
                                Console.WriteLine(bestIndex);
                            }
                        }
                        else
                        {
                            var bestIndex = 0;
                            var currMax = int.MinValue;
                            for (int i = 0; i < numbers.Count; i++)
                            {
                                if (numbers[i] % 2 != 0 && numbers[i] >= currMax)
                                {
                                    currMax = numbers[i];
                                    bestIndex = i;
                                }
                            }
                            if (currMax == int.MinValue)
                            {
                                Console.WriteLine("No matches");
                            }
                            else
                            {
                                Console.WriteLine(bestIndex);
                            }
                        }
                        break;
                    case "min":
                        if (commands[1] == "even")
                        {
                            var bestIndex = 0;
                            var currMin = int.MaxValue;
                            for (int i = 0; i < numbers.Count; i++)
                            {
                                if (numbers[i] % 2 == 0 && numbers[i] <= currMin)
                                {
                                    currMin = numbers[i];
                                    bestIndex = i;
                                }
                            }
                            if (currMin == int.MaxValue)
                            {
                                Console.WriteLine("No matches");
                            }
                            else
                            {
                                Console.WriteLine(bestIndex);
                            }
                        }
                        else
                        {
                            var bestIndex = 0;
                            var currMin= int.MaxValue;
                            for (int i = 0; i < numbers.Count; i++)
                            {
                                if (numbers[i] % 2 != 0 && numbers[i] <= currMin)
                                {
                                    currMin = numbers[i];
                                    bestIndex = i;
                                }
                            }
                            if (currMin == int.MaxValue)
                            {
                                Console.WriteLine("No matches");
                            }
                            else
                            {
                                Console.WriteLine(bestIndex);
                            }
                        }
                        break;
                    case "first":
                        var count = int.Parse(commands[1]);
                        if (count > numbers.Count)
                        {
                            Console.WriteLine("Invalid count");
                        }
                        else
                        {
                            List<int> currentList = new List<int>();
                            if (commands[2] == "even")
                            {
                                currentList.AddRange(
                                    numbers.Where(x => x % 2 == 0).Take(count));
                            }
                            else
                            {
                                currentList.AddRange(
                                numbers.Where(x => x % 2 != 0).Take(count));
                            }
                            Console.WriteLine($"[{string.Join(", ", currentList)}]");
                        }
                        break;
                    case "last":
                        var count2 = int.Parse(commands[1]);
                        if (count2 > numbers.Count)
                        {
                            Console.WriteLine("Invalid count");
                        }
                        else
                        {
                            List<int> currentList2 = new List<int>();
                            if (commands[2] == "even")
                            {
                                currentList2.AddRange(
                                    numbers.Where(x => x % 2 == 0).Take(count2));
                            }
                            else
                            {
                                currentList2.AddRange(
                                numbers.Where(x => x % 2 != 0).Take(count2));
                            }
                            Console.WriteLine($"[{string.Join(", ", currentList2)}]");
                        }
                        break;
                }
                input = Console.ReadLine();
            }
            Console.WriteLine($"[{string.Join(", ",numbers)}]");
        }
    }
}
