using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam_Preparation_II_04._Roli_The_Coder
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var dict = new Dictionary<int, Dictionary<string, List<string>>>();
            while (input != "Time for Code")
            {
                if (input.Contains("#") && input.Contains("@"))
                {
                    string[] commands = input
                    .Split(new char[] { ' ', '#', '@' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();

                    int id = int.Parse(commands[0]);
                    string eventName = commands[1];
                    List<string> names = new List<string>();
                    for (int i = 2; i < commands.Length; i++)
                    {
                        names.Add(commands[i]);
                    }

                    if (!dict.ContainsKey(id))
                    {
                        dict[id] = new Dictionary<string, List<string>>();
                        if (!dict[id].ContainsKey(eventName))
                        {
                            dict[id][eventName] = new List<string>();
                        }
                        dict[id][eventName].AddRange(names);
                         dict[id][eventName].Distinct();
                    }
                    else
                    {
                        if (dict[id].ContainsKey(eventName))
                        {
                            dict[id][eventName].AddRange(names);
                            dict[id][eventName].Distinct();
                        }
                    }
                }

                input = Console.ReadLine();
            }

            foreach (var pair in dict.OrderByDescending(x=>x.Value.Values.Count))              
            {
                var id = pair.Key;
                foreach (var pair1 in pair.Value)
                {
                    var nameOfEvent = pair1.Key;
                    var participants = pair1.Value;
                    Console.WriteLine($"{nameOfEvent} - {participants.Count}");
                    foreach (var m in participants)
                    {
                        Console.WriteLine($"@{m}");
                    }
                }
            }
        }
    }
}
