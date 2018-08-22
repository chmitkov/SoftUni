using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam_04March2018PartII_04._ForceBook
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
                        .Split(new char[] { '|' }, StringSplitOptions.RemoveEmptyEntries);
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
                        .Split(new char[] { '-','>' }, StringSplitOptions.RemoveEmptyEntries);
                    var name = commands[0].Trim();
                    var newSide = commands[1].Trim();
                    foreach (var pair in dict)
                    {
                        if (pair.Value.Contains(name))
                        {
                            dict[pair.Key].Remove(name);
                        }
                    }
                    if (!dict.ContainsKey(newSide))
                    {
                        dict.Add(newSide, new List<string>());
                        dict[newSide].Add(name);
                    }
                    else
                    {
                        if (!dict[newSide].Contains(name))
                        {
                            dict[newSide].Add(name);
                        }
                    }
                    Console.WriteLine($"{name} joins the {newSide} side!");
                }
                input = Console.ReadLine();
            }
            foreach (var pair in dict.OrderByDescending(x=>x.Value.Count)
                .ThenBy(x=>x.Key))
            {
                Console.WriteLine($"Side: {pair.Key}, Members: {pair.Value.Count}");
                foreach (var name in pair.Value.OrderBy(x=>x))
                {
                    Console.WriteLine($"! {name}");
                }
            }
        }
    }
}
