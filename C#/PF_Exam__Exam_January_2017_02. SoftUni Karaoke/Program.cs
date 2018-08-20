using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam__Exam_January_2017_02._SoftUni_Karaoke
{
    class Program
    {
        static void Main(string[] args)
        {

            var dict = new Dictionary<string, List<string>>();

            string[] names = Console.ReadLine()
                .Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(x => x.Trim())
                .ToArray();

            string[] songs = Console.ReadLine()
                .Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(x => x.Trim())
                .ToArray();

            string input = Console.ReadLine();
            while (input != "dawn")
            {
                string[] commands = input
                    .Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries)
                    .Select(x => x.Trim())
                    .ToArray();

                var name = commands[0];
                var song = commands[1];
                var award = commands[2];

                if (name.Contains(name) && songs.Contains(song))
                {
                    if (!dict.ContainsKey(name))
                    {
                        dict.Add(name, new List<string>());
                        dict[name].Add(award);
                        dict[name] = dict[name].Distinct().ToList();
                    }
                    else
                    {
                        dict[name].Add(award);
                        dict[name] = dict[name].Distinct().ToList();
                    }
                }
                input = Console.ReadLine();
            }
            if (dict.Count > 0)
            {
                foreach (var pair in dict.OrderByDescending(x=>x.Value.Count)
                    .ThenBy(x=>x.Key))
                {
                    Console.WriteLine($"{pair.Key}: {pair.Value.Count} awards");
                    foreach (var award in pair.Value.OrderBy(x=>x))
                    {
                        Console.WriteLine($"--{award}");
                    }
                }
            }
            else
            {
                Console.WriteLine("No awards");
            }

        }
    }
}
