using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Retake_Exam___05_January_2018_Part_I_04._Snowwhite
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var dict = new Dictionary<string, Dictionary<string, int>>();
            while (input != "Once upon a time")
            {
                string[] commands = input
                    .Split(new char[] { ' ', '<', ':', '>' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                var name = commands[0];
                var color = commands[1];
                var physics = int.Parse(commands[2]);

                if (!dict.ContainsKey(name))
                {
                    dict[name] = new Dictionary<string, int>();
                }
                if (!dict[name].ContainsKey(color))
                {
                    dict[name][color] = 0;
                }
                if (dict[name][color] < physics)
                {
                    dict[name][color] = physics;
                }
                input = Console.ReadLine();
            }
            dict.OrderByDescending(x => x.Value.Values.Sum()).ThenByDescending(x=>x.Value.Count);
            foreach (var pair in dict)
            {
                var name = pair.Key;
                foreach (var pair1 in pair.Value)
                {
                    Console.WriteLine($"({pair1.Key}) {name} <-> {pair1.Value}");
                }
            }

        }
    }
}
