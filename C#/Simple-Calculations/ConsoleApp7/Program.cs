using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam___04_March_2018_Part_I__04._ForceBook
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var dict = new Dictionary<string, List<string>>();
            var result = new List<string>();
            while (input != "Lumpawaroo")
            {
                if (input.Contains("|"))
                {
                    var commands = input
                        .Split(new char[] { '|' }, StringSplitOptions.RemoveEmptyEntries)
                        .ToArray();
                    var side = commands[0].Trim();
                    var user = commands[1].Trim();
                    if (!dict.ContainsKey(side))
                    {
                        dict[side] = new List<string>();
                    }
                    if (!dict.Values.Any(x => x.Contains(user)))
                    {
                        dict[side].Add(user);
                    }

                }
                else
                {
                    var commands = input
                        .Split(new char[] { '-', '>' }, StringSplitOptions.RemoveEmptyEntries)
                        .ToArray();
                    var side = commands[1].Trim();
                    var user = commands[0].Trim();
                    if (!dict.ContainsKey(side))
                    {
                        dict[side] = new List<string>();
                    }
                    dict[side].Add(user);
                    dict[side].Distinct();
                    result.Add($"{user} joins the {side} side!");
                    foreach (var pair in dict)
                    {
                        if (pair.Value.Contains(user) && pair.Key != side)
                        {
                            dict[pair.Key].Remove(user);
                        }
                    }


                }
                input = Console.ReadLine();
            }

            foreach (var name in result)
            {
                Console.WriteLine(name);
            }
            foreach (var pair in dict.OrderByDescending(x => x.Value.Count).ThenBy(x => x.Key))
            {
                var side = pair.Key;
                if (pair.Value.Count > 0)
                {
                    Console.WriteLine($"Side: {side}, Members: {pair.Value.Count}");
                    foreach (var name in pair.Value.OrderBy(x => x))
                    {
                        Console.WriteLine($"! {name}");
                    }
                }

            }
        }
    }
}
