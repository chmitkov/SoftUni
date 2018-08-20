using System;
using System.Collections.Generic;
using System.Linq;

namespace Exam_04March2018__Part1_04._ForceBook
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var dict = new Dictionary<string, List<string>>();
            while (input != "Lumpawaroo")
            {
                if (input.Contains("|"))
                {
                    string[] commands = input
                        .Split(new char[] { '|', }, StringSplitOptions.RemoveEmptyEntries);
                    var side = commands[0].Trim();
                    var name = commands[1].Trim();
                    if (!dict.ContainsKey(side))
                    {
                        dict.Add(side, new List<string>());
                        dict[side].Add(name);
                    }
                    else
                    {
                        if (!dict[side].Contains(name))
                        {
                            dict[side].Add(name);
                        }
                    }
                }
                else
                {
                    string[] commands = input
                        .Split(new char[] {'-', '>', }, StringSplitOptions.RemoveEmptyEntries);
                    var side = commands[1].Trim();
                    var name = commands[0].Trim();
                    bool flag = false;
                    var sideToRemoveFrom = string.Empty;
                    foreach (var pair in dict)
                    {
                        foreach (var currN in pair.Value)
                        {
                            if (currN.Contains(name))
                            {
                               sideToRemoveFrom = pair.Key;
                                flag = true;
                            }
                        }
                    }
                    if (flag)
                    {
                        dict[sideToRemoveFrom].Remove(name);
                    }
                    if (!dict.ContainsKey(side))
                    {
                        dict.Add(side, new List<string>());
                        dict[side].Add(name);
                        Console.WriteLine($"{name} joins the {side} side!");
                    }
                    else
                    {
                        if (!dict[side].Contains(name))
                        {
                            dict[side].Add(name);
                            Console.WriteLine($"{name} joins the {side} side!");
                        }
                    }
                }
                input = Console.ReadLine();
            }
            foreach (var pair in dict.OrderByDescending(x=>x.Value.Count).ThenBy(x=>x.Key))
            {
                if (pair.Value.Count > 0)
                {
                    Console.WriteLine($"Side: {pair.Key}, Members: {pair.Value.Count}");
                    foreach (var p in pair.Value.OrderBy(x => x))
                    {
                        Console.WriteLine($"! {p}");
                    }
                }

            }
        }
    }
}
