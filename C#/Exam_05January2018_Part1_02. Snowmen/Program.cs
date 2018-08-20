using System;
using System.Collections.Generic;
using System.Linq;

namespace Exam_05January2018_Part1_02._Snowmen
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> snowmans = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToList();
            var index = 0;
            while (snowmans.Count > 1)
            {
                var attacker = index;
                var target = 0;
                if (snowmans[index] > snowmans.Count - 1)
                {
                    target = snowmans[index] % snowmans.Count;
                }
                else
                {
                    target = snowmans[index];
                }
                if (attacker == target)
                {
                    Console.WriteLine($"{attacker} performed harakiri");
                    snowmans.RemoveRange(index - 1, snowmans.Count - index);
                    index = 0;
                }
                else
                {
                    if ((attacker - target) % 2 == 0)
                    {
                        Console.WriteLine($"{attacker} x {target} -> {attacker} wins");
                    }
                    else
                    {
                        Console.WriteLine($"{attacker} x {target} -> {target} wins");
                    }
                    index++;
                }
            }
        }
    }
}
