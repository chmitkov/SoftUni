using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Retake_Exam_25April2018Part_I_04._MOBA_Challenger
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, Dictionary<string, int>>();

            string input = Console.ReadLine();

            while (input != "Season end")
            {
                string[] commands = input
                    .Split(new char[] { ' ', '-', '>' }, StringSplitOptions.RemoveEmptyEntries);
                if (commands[1] != "vs")
                {
                    var name = commands[0];
                    var place = commands[1];
                    var skill = int.Parse(commands[2]);

                    if (!dict.ContainsKey(name))
                    {
                        dict.Add(name, new Dictionary<string, int>());
                        dict[name].Add(place, skill);
                    }
                    else
                    {
                        if (!dict[name].ContainsKey(place))
                        {
                            dict[name].Add(place, skill);
                        }
                        else
                        {
                            if (dict[name][place] < skill)
                            {
                                dict[name][place] = skill;
                            }
                        }
                    }

                }
                else
                {
                    var player1 = commands[0];
                    var player2 = commands[2];
                    bool haveSamePlace = false;
                    if (dict.ContainsKey(player1) && dict.ContainsKey(player2))
                    {
                        foreach (var pair in dict[player1])
                        {
                            if (dict[player2].ContainsKey(pair.Key))
                            {
                                haveSamePlace = true;
                                break;
                            }
                        }
                        if (haveSamePlace)
                        {
                            if (dict[player1].Values.Sum() >
                                dict[player2].Values.Sum())
                            {
                                dict.Remove(player2);
                            }
                            else if (dict[player1].Values.Sum() <
                                dict[player2].Values.Sum())
                            {
                                dict.Remove(player1);
                            }
                        }
                    }
                }
                input = Console.ReadLine();
            }
            foreach (var pair  in dict.OrderByDescending(x=>x.Value.Values.Sum())
                .ThenBy(x=>x.Key))
            {
                Console.WriteLine($"{pair.Key}: {dict[pair.Key].Values.Sum()} skill");
                foreach (var pair1 in pair.Value.OrderByDescending(x=>x.Value)
                    .ThenBy(x=>x.Key))
                {
                    Console.WriteLine($"- {pair1.Key} <::> {pair1.Value}");
                }
                {

                }
            }
        }
    }
}
