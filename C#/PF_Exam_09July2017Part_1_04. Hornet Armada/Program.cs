using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam_09July2017Part_1_04._Hornet_Armada
{
    class Legion
    {
        public string Name { get; set; }
        public int Activity { get; set; }
        public Dictionary<string, long> Soldiers { get; set; }

        public Legion(string name, int activity, Dictionary<string, long> soldiers)
        {
            Name = name;
            Activity = activity;
            Soldiers = soldiers;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            List<Legion> result = new List<Legion>();
            while (n-->0)
            {
                string[] commands = Console.ReadLine()
                    .Split(new char[] { ' ', '=', '-', '>', ':' }, StringSplitOptions.RemoveEmptyEntries);

                var activity = int.Parse(commands[0]);
                var legionName = commands[1];
                var soldierType = commands[2];
                var soldierCout = long.Parse(commands[3]);
                var currLegion = new Legion(string.Empty,0,new Dictionary<string, long>());
                if (result.Any(x => x.Name == legionName))
                {
                    currLegion = result.Where(x => x.Name == legionName).FirstOrDefault();
                    if (!currLegion.Soldiers.ContainsKey(soldierType))
                    {
                        currLegion.Soldiers.Add(soldierType, soldierCout);
                    }
                    else
                    {
                        currLegion.Soldiers[soldierType] += soldierCout;
                    }
                    if (currLegion.Activity < activity)
                    {
                        currLegion.Activity = activity;
                    }
                }
                else
                {
                    var currDict = new Dictionary<string, long>();
                    currDict.Add(soldierType, soldierCout);
                    result.Add(new Legion(legionName, activity, currDict));
                }
            }
            string[] lastCommands = Console.ReadLine()
                .Split(new char[] { '\\' }, StringSplitOptions.RemoveEmptyEntries);

            if (lastCommands.Length == 1)
            {
                var soldType = lastCommands[0];
                foreach (var leg in result.Where(x=>x.Soldiers.ContainsKey(soldType)).ToList()
                    .OrderByDescending(x=>x.Activity))
                {
                    Console.WriteLine($"{leg.Activity} : {leg.Name}");
                }
            }
            else
            {
                var neededAct = int.Parse(lastCommands[0]);
                var neededSold = lastCommands[1];

                foreach (var leg in result.Where(x=>x.Soldiers.ContainsKey(neededSold)).ToList()
                    .OrderByDescending(x=>x.Soldiers[neededSold]))
                {
                    if (leg.Activity < neededAct)
                    {
                        Console.WriteLine($"{leg.Name} -> {leg.Soldiers[neededSold]}");
                    }
                }
            }
        }
    }
}
