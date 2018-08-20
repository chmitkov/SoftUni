using System;
using System.Collections.Generic;
using System.Linq;

namespace ConsoleApp8
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, Dictionary<string, long>>();
            string input = Console.ReadLine();

            while (input != "Once upon a time")
            {
               string [] command = input
                   .Split(new char[] { ' ', '<', ':', '>' }, StringSplitOptions.RemoveEmptyEntries)
                   .ToArray();

                var name = command[0];
                var color = command[1];
                var physics = long.Parse(command[2]);

                if (!dict.ContainsKey(name))
                {
                    dict.Add(name, new Dictionary<string, long>());
                    dict[name].Add(color, physics);
                }
                else
                {
                    if (!dict[name].ContainsKey(color))
                    {
                        dict[name].Add(color, physics);
                    }
                    else
                    {
                        if (dict[name][color] < physics)
                        {
                            dict[name][color] = physics;
                        }
                    }
                }
                input = Console.ReadLine();
            }
            foreach (var pair in dict.OrderByDescending(x=>x.Value.Values.Sum()).ThenBy(x=>x.Value.Keys))
            {

                foreach (var pair1 in pair.Value)
                {
                    Console.WriteLine($"({pair1.Key}) {pair.Key} <-> {pair1.Value}");
                }
                //(Yellow) Sasho <-> 4500

            }

        }
    }
}
