using System;
using System.Collections.Generic;
using System.Linq;

namespace _02._Snowmen
{
    class Program
    {
        static void Main(string[] args)
        {
            var snowmen = Console.ReadLine()
                .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToList();
            while (snowmen.Count(x => x != -1) > 1)
            {
                var indexToRemove = new List<int>();
                for (int i = 0; i < snowmen.Count; i++)
                {
                    
                    if (snowmen[i] == -1)
                    {
                        continue;
                    }
                    int attacker = i;
                    int target = snowmen[i] % snowmen.Count;

                    int diffrent = Math.Abs(attacker - target);

                    if (attacker == target)
                    {
                        snowmen[attacker] = -1;
                        Console.WriteLine($"{attacker} performed harakiri");
                        indexToRemove.Add(attacker);
                    }
                    else if (diffrent % 2 == 0)
                    {
                        snowmen[target] = -1;
                        Console.WriteLine($"{attacker} x {target} -> {attacker} wins");
                        indexToRemove.Add(target);
                    }
                    else
                    {
                        snowmen[attacker] = -1;
                        Console.WriteLine($"{attacker} x {target} -> {target} wins");
                        indexToRemove.Add(attacker);
                    }
                    snowmen = snowmen
                        .Where(x => x != -1)
                        .ToList();
                }
            }
        }
    }
}