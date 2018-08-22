using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam___09_July_2017_Part_04._Pokemon_Evolution
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] commands = Console.ReadLine()
                 .Split(new char[] { ' ', '-', '>' }, StringSplitOptions.RemoveEmptyEntries)
                 .ToArray();
            var dict = new Dictionary<string, Dictionary<string, List<int>>>();
            while (commands[0] != "wubbalubbadubdub")
            {
                if (commands.Length == 1)
                {
                    var pokemonName = commands[0];
                    if (dict.ContainsKey(pokemonName))
                    {
                        foreach (var pair in dict[pokemonName])
                        {
                            //Console.WriteLine($"{pair.Key} <-> {pair.Value}");
                            foreach (var pair1 in pair.Value)
                            {
                                Console.WriteLine($"{pair.Key} <-> {pair1}");
                            }
                        }
                    }
                }
                else
                {
                    var pokemonName = commands[0];
                    var evolutionType = commands[1];
                    var evolutionIndex = int.Parse(commands[2]);

                    if (!dict.ContainsKey(pokemonName))
                    {
                        dict[pokemonName] = new Dictionary<string, List<int>>();
                    }
                    if (!dict[pokemonName].ContainsKey(evolutionType))
                    {
                        dict[pokemonName][evolutionType] = new List<int>();
                    }

                    dict[pokemonName][evolutionType].Add(evolutionIndex);
                }
                commands = Console.ReadLine()
                 .Split(new char[] { ' ', '-', '>' }, StringSplitOptions.RemoveEmptyEntries)
                 .ToArray();
            }
            foreach (var pair in dict)
            {
                Console.WriteLine($"# {pair.Key}");
                foreach(var pair1 in pair.Value)
                {
                    var list = pair1.Value;
                    list.Sort();
                    list.Reverse();
                    foreach (var pair2 in list)
                    {
                        Console.WriteLine($"{pair1.Key} <-> {pair2}");
                    }
                }
            }
        }
    }
}
