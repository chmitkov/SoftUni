using System;
using System.Collections.Generic;
using System.Linq;

namespace exam
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var dict = new Dictionary<string, Dictionary<string, int>>();
            while (input != "Season end")
            {
                var inputList = new List<string>();

                if (input.Contains("vs")){
                    inputList = input.Split(" vs ").ToList();
                }
                else
                {
                    inputList = input.Split(" -> ").ToList();
                }
                if (inputList.Count == 3)
                {
                    var name = inputList[0];
                    var position = inputList[1];
                    var skill = int.Parse(inputList[2]);
                    if (!dict.ContainsKey(name))
                    {
                        // dict[name] = new Dictionary<string, int>();
                        dict.Add(name, new Dictionary<string, int>());
                    }
                    if (!dict[name].ContainsKey(position))
                    {
                        //dict[name][position] = 0;
                        dict[name].Add(position, skill);
                    }
                    else
                    {
                        if (dict[name][position] < skill)
                        {
                            dict[name][position] = skill;
                        }
                    }
                }
                else if (inputList.Count == 2)
                {
                    var player1 = inputList[0];
                    var player2 = inputList[1];
                    if (dict.ContainsKey(player1) && dict.ContainsKey(player2))
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
                                    dict[player1].Clear();
                                }
                            }
                        }
                    }
                }

                input = Console.ReadLine();

            }
            foreach (var pair in dict.OrderByDescending(x => x.Value.Keys.Count)
                   )
            {
                var name = pair.Key;
                Console.WriteLine($"{name}: {pair.Value.Values.Sum()} skill");
                foreach (var pair1 in pair.Value.OrderByDescending(x => x.Value).ThenBy(x => x.Key))
                {
                    Console.WriteLine($"- {pair1.Key} <::> {pair1.Value}");
                }
            }
        }
    }
}
