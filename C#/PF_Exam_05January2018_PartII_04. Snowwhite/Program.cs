using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam_05January2018_PartII_04._Snowwhite
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, Dictionary<string, decimal>>();

            string input = Console.ReadLine();

            while (input != "Once upon a time")
            {
                string[] commands = input
                    .Split(new char[] { ' ', '<',':','>' }, StringSplitOptions.RemoveEmptyEntries);
                var name = commands[0];
                var color = commands[1];
                var physics = decimal.Parse(commands[2]);
                if (!dict.ContainsKey(color))
                {
                    dict.Add(color, new Dictionary<string, decimal>());
                    dict[color].Add(name, physics);
                }
                else
                {
                    if (!dict[color].ContainsKey(name))
                    {
                        dict[color].Add(name, physics);
                    }
                    else
                    {
                        if (dict[color][name] < physics)
                        {
                            dict[color][name] = physics;
                        }
                    }
                }
                input = Console.ReadLine();
            }
            foreach (var pair in dict.OrderByDescending(x=>x.Value.Values.Sum())
                .ThenByDescending(x=>x.Value.Count))
            {
                foreach (var pair1 in pair.Value)
                {
                    Console.WriteLine($"({pair.Key}) {pair1.Key} <-> {pair1.Value}");
                }
            }
        }
    }
}
