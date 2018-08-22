using System;
using System.Collections.Generic;
using System.Linq;

namespace Programing_Fundamentals_Part2_04._Roli_The_Coder
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var dict = new Dictionary<string, Dictionary<string,List<string>>>();
            while (input != "Time for Code")
            {
                if (input.Contains("#"))
                {
                    string[] commands = input
                    .Split(new char[] { '#', ' ', '@' }, StringSplitOptions.RemoveEmptyEntries);

                    var id = commands[0];
                    var eventName = commands[1];
                    List<string> participants = new List<string>();
                    participants.AddRange(commands.Skip(2).ToList());

                    if (!dict.ContainsKey(id))
                    {
                        dict.Add(id, new Dictionary<string, List<string>>());
                        dict[id].Add(eventName, new List<string>());
                        dict[id][eventName].AddRange(participants);
                        dict[id][eventName] = dict[id][eventName].Distinct().ToList();
                    }
                    else
                    {
                        if (dict[id].ContainsKey(eventName))
                        {
                            dict[id][eventName].AddRange(participants);
                            dict[id][eventName] = dict[id][eventName].Distinct().ToList();
                        }
                    }
                }
                input = Console.ReadLine();
            }
            foreach (var pair in dict.OrderByDescending(x=>x.Value.Values.))
            {
                bool flag = true;
                foreach (var pair1 in pair.Value)
                {
                    if (flag)
                    {
                        Console.WriteLine($"{pair1.Key} - {pair1.Value.Count}");
                        flag = false;
                    }
                    foreach (var name in pair1.Value.OrderBy(x=>x))
                    {
                        Console.WriteLine($"@{name}");
                    }
                }
            }
        }
    }
}
