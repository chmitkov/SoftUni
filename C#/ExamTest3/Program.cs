using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamTest3
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
                string[] command = Console.ReadLine()
                    .Split(new char[] { ' ', '=', '-', '>', ':' }
                    , StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                var lastActivity = int.Parse(command[0]);
                var legionName = command[1];
                var soldierType = command[2];
                var soldierCount = long.Parse(command[3]);
                if (!dict.ContainsKey(legionName))
                {
                    dict[legionName] = new Dictionary<string, long>();
                }
                if (!dict[legionName].ContainsKey(soldierType))
                {
                    dict[legionName][soldierType] = 0;
                }
                dict[legionName][soldierType] += soldierCount;
                if (!activity.ContainsKey(legionName))
                {
                    activity.Add(legionName, lastActivity);
                }
                else
                {
                    if (activity[legionName] < lastActivity)
                    {
                        activity[legionName] = lastActivity;
                    }
                }
            }
            var input = Console.ReadLine()
                .Split(new char[] { '\\' }
                , StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            if (input.Length > 1)
            {
                var neededAct = int.Parse(input[0]);
                var neededType = input[1];
                foreach (var pair in dict.OrderByDescending(x => x.Value[neededType]))
                {
                    if (activity[pair.Key] < neededAct)
                    {
                        Console.WriteLine($"{pair.Key} -> {pair.Value[neededType]}");
                    }
                }
            }
            else
            {
                var neededType = input[0];
                foreach (var pair in activity.OrderByDescending(x => x.Value))
                {
                    if (dict[pair.Key].ContainsKey(neededType))
                    {
                        Console.WriteLine($"{pair.Value} : {pair.Key}");
                    }
                }
            }
        }
    }
}
