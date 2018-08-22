using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamTest
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            var dict = new Dictionary<string, Dictionary<string, long>>();
            var activity = new Dictionary<string, int>();
            for (int i = 0; i < n; i++)
            {
                var input = Console.ReadLine()
                    .Split(new char[] { '=', '-', ' ', '>', ':' }
                    , StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                var lastActivity = int.Parse(input[0]);
                var legionName = input[1];
                var soldierType = input[2];
                var soldierCount = long.Parse(input[3]);
                if (!activity.ContainsKey(legionName))
                {
                    activity[legionName] = lastActivity;
                }
                else
                {
                    if (activity[legionName] < lastActivity)
                    {
                        activity[legionName] = lastActivity;
                    }
                }

                if (!dict.ContainsKey(legionName))
                {
                    dict[legionName] = new Dictionary<string, long>();
                }
                if (!dict[legionName].ContainsKey(soldierType))
                {
                    dict[legionName][soldierType] = 0;
                }
                dict[legionName][soldierType] += soldierCount;
            }

            var command = Console.ReadLine()
                .Split(new char[] { '\\' }
                , StringSplitOptions.RemoveEmptyEntries)
                .ToArray();

            if (command.Length == 1)
            {
                foreach (var pair in activity.OrderByDescending(x=>x.Value))
                {
                    if (dict[pair.Key].ContainsKey(command[0]))
                    {
                        Console.WriteLine($"{pair.Value} : {pair.Key}");
                    }
                }
            }
            else
            {
                var neededActivity = int.Parse(command[0]);
                var neededType = command[1];
                foreach (var pair in dict.OrderByDescending(x=>x.Value[neededType]))
                {
                    if (dict[pair.Key].ContainsKey(neededType))
                    {
                        if (activity[pair.Key] < neededActivity)
                        {
                            Console.WriteLine($"{pair.Key} -> {pair.Value[neededType]}");
                        }
                    }                   
                }
            }
        }
    }
}
