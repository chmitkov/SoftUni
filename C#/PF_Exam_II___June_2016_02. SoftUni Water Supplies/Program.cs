using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam_II___June_2016_02._SoftUni_Water_Supplies
{
    class Program
    {
        static void Main(string[] args)
        {
            int totalWater = int.Parse(Console.ReadLine());
            int[] bottles = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            int bottleCapacity = int.Parse(Console.ReadLine());

            if (totalWater > bottles.Length * bottleCapacity)
            {
                Console.WriteLine($"Enough water!\nWater left: " +
                    $"{totalWater-(bottles.Length*bottleCapacity)}l.");
            }
            else
            {
                if (totalWater % 2 == 0)
                {
                    var index = 0;
                    var restIndex = new List<int>();
                    for (int i = 0; i < bottles.Length; i++)
                    {
                        totalWater -= bottleCapacity;
                        if (totalWater < 0)
                        {
                            index = i;
                            break;
                        }
                    }
                    for (int i = index; i < bottles.Length; i++)
                    {
                        restIndex.Add(i);
                    }
                    Console.WriteLine($"We need more water!\n" +
                        $"Bottles left: {bottles.Length-1-index}\nWith indexes: {string.Join(", ",restIndex)}\n" +
                        $"We need {bottles.Length*bottleCapacity-totalWater} more liters!");
                }
                else
                {
                    var index = 0;
                    var restIndex = new List<int>();
                    for (int i = bottles.Length - 1; i >= 0; i--)
                    {
                        totalWater -= bottleCapacity;
                        if (totalWater < 0)
                        {
                            index = i;
                            break;
                        }
                    }
                    for (int i = index; i >= 0; i--)
                    {
                        restIndex.Add(i);
                    }
                    Console.WriteLine($"We need more water!\n" +
                        $"Bottles left: {bottles.Length - 1 - index}\nWith indexes: {string.Join(", ", restIndex)}\n" +
                        $"We need {bottles.Length * bottleCapacity - totalWater} more liters!");
                }
            }
        }
    }
}
