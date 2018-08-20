using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Retake_Exam___25_April_2018_Part_I_04._MOBA_Challenger
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var dict = new Dictionary<string, Dictionary<string, int>>();
            while (input != "Season end")
            {
                string[] commands = input
                    .Split(new char[] { ' ', '-', '>' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                if (commands[1] != "vs")
                {
                    var name = commands[0];
                    var position = commands[1];
                    var skill = int.Parse(commands[2]);
                    if (!dict.ContainsKey(name))
                    {
                        dict[name] = new Dictionary<string, int>();
                    }
                    if (!dict[name].ContainsKey(position))
                    {
                        dict[name][position] = 0;
                    }
                    if (dict[name][position] < skill)
                    {
                        dict[name][position] = skill;
                    }
                }
                else
                {
                    var player1 = commands[0];
                    var player2 = commands[2];
                    if (dict.ContainsKey(player1) && dict.ContainsKey(player2) )
                    {
                        foreach (var place in dict[player1])
                        {
                            if (dict[player2].ContainsKey(place.Key))
                            {
                                if (dict[player1].Values.Sum() > dict[player2].Values.Sum())
                                {
                                    dict.Remove(player2);
                                }
                                else if (dict[player2].Values.Sum() > dict[player1].Values.Sum())
                                {
                                    dict.Remove(player1);
                                }
                            }
                        }
                    }
                }
                input = Console.ReadLine();
            }
            foreach (var pair in dict.OrderByDescending(x=>x.Value.Keys.Count)
                .ThenBy(x=>x.Key))
            {
                var name = pair.Key;
                Console.WriteLine($"{name}: {pair.Value.Values.Sum()} skill");
                foreach (var pair1 in pair.Value.OrderByDescending(x=>x.Value).ThenBy(x=>x.Key))
                {
                    Console.WriteLine($"- {pair1.Key} <::> {pair1.Value}");
                }
            }
        }
    }
}
