using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam_26February2017PartI_04._Hornet_Armada
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            var activityDict = new Dictionary<string, int>();
            var dict = new Dictionary<string, Dictionary<string, long>>();

            for (int i = 0; i < n; i++)
            {
                string[] commands = Console.ReadLine()
                    .Split(new char[] { ' ', '=', '-', '>', ':' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                var lastActivity = int.Parse(commands[0]);
                var legionName = commands[1];
                var soldierType = commands[2];
                var soldierCount = long.Parse(commands[3]);
                if (!activityDict.ContainsKey(legionName))
                {
                    activityDict.Add(legionName, 0);
                }
                if (activityDict[legionName] < lastActivity)
                {
                    activityDict[legionName] = lastActivity;
                }
                if (!dict.ContainsKey(legionName))
                {
                    dict.Add(legionName, new Dictionary<string, long>());                    
                }
                if (!dict[legionName].ContainsKey(soldierType))
                {
                    dict[legionName].Add(soldierType, 0);
                }
                dict[legionName][soldierType] += soldierCount;
            }
            string[] lastCommands = Console.ReadLine()
                .Split(new char[] { '\\' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            if (lastCommands.Length == 2)
            {
                var neededActivity = int.Parse(lastCommands[0]);
                var neededSoldierType = lastCommands[1];

                var legionWithLowerActivity = dict
                   .Where(x => activityDict[x.Key] < neededActivity)
                   .Where(x => dict[x.Key].ContainsKey(neededSoldierType))
                   .OrderByDescending(x => x.Value[neededSoldierType])
                   .ToDictionary(x => x.Key, x => x.Value);

                foreach (var item in legionWithLowerActivity)
                {
                    Console.WriteLine($"{item.Key} -> {item.Value[neededSoldierType]}");
                }
                //foreach (var pair in dict.OrderByDescending(x=>x.Value.Values.Sum()))
                //{
                //    var legion = pair.Key;
                //    if (activityDict[legion] < neededActivity)
                //    {
                //        foreach (var pair1 in pair.Value)
                //        {
                //            if (pair1.Key == neededSoldierType)
                //            {
                //                Console.WriteLine($"{legion} -> {pair1.Value}");
                //            }
                //        }
                //    }
                //}
            }
            else if (lastCommands.Length == 1)
            {
                var neededSoldierType = lastCommands[0];
                foreach (var pair in activityDict.OrderByDescending(x=>x.Value))
                {
                    var legion = pair.Key;
                    if (dict[legion].ContainsKey(neededSoldierType))
                    {
                        Console.WriteLine($"{pair.Value} : {pair.Key}");
                    }
                }
            }
        }
    }
}
