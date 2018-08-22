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
            //  var last = 0;
            for (int i = 0; i < n; i++)
            {
                var input = Console.ReadLine()
                    .Split(new char[] { '=', '-', ' ', '>', ':' }
                    , StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                //{lastActivity} = {legionName} -> {soldierType}:{soldierCount}
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
                        //last = lastActivity;
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
                //{ lastActivity} : { legionName}
                foreach (var pair in activity)
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
                //{legionName} -> {soldierCount}
                foreach (var pair in dict)
                {
                    if (activity[pair.Key] < neededActivity)
                    {
                        Console.WriteLine($"{pair.Key} -> {pair.Value[neededType]}");
                    }
                }

            }

            //foreach (var pair in dict)
            //{
            //    var legion = pair.Key;
            //    foreach (var pair1 in pair.Value)
            //    {
            //        var type = pair1.Key;
            //        var count = pair1.Value;
            //        Console.WriteLine($"{legion} {type} {count}");
            //    }
            //}
        }
    }
}
