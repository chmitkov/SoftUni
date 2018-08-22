using System;
using System.Collections.Generic;
using System.Linq;

namespace Lists_Exercises_03._Search_for_a_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> list = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToList();
            int[] commands = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            var toTake = commands[0];
            var toDel = commands[1];
            var neededNum = commands[2];

            list.Take(toTake);
            for (int i = 0; i < toDel; i++)
            {
                list.RemoveAt(0);
            }
            Console.WriteLine(list.Contains(neededNum)?"YES!":"NO!");
        }
    }
}
