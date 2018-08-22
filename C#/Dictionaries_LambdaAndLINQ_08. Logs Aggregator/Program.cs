using System;
using System.Collections.Generic;
using System.Linq;

namespace Dictionaries_LambdaAndLINQ_08._Logs_Aggregator
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new SortedDictionary<string, int>();
            var ipDict = new SortedDictionary<string, List<string>>();

            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string[] commands = Console.ReadLine()
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
                var ip = commands[0];
                var name = commands[1];
                var dur = int.Parse(commands[2]);

                if (!dict.ContainsKey(name))
                {
                    dict.Add(name, dur);
                }
                else
                {
                    dict[name] += dur;
                }
                if (!ipDict.ContainsKey(name))
                {
                    ipDict.Add(name, new List<string>());
                    ipDict[name].Add(ip);
                }
                else
                {
                    ipDict[name].Add(ip);
                    ipDict[name] = ipDict[name].Distinct().ToList();
                }

            }
            foreach (var pair in dict)
            {
                Console.WriteLine($"{pair.Key}: {pair.Value} " +
                    $"[{string.Join(", ", ipDict[pair.Key].OrderBy(x=>x))}]");
            }
        }
    }
}
