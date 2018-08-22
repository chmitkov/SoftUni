using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam___05_November_2017_Part_I_04._Anonymous_Cache
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var dict = new Dictionary<string, Dictionary<string, long>>();
            var cache = new Dictionary<string, Dictionary<string, long>>();
            while (input != "thetinggoesskrra")
            {
                string[] commands = input
                    .Split(new char[] { '|', '-', '>', ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                if (commands.Length == 1)
                {
                    var dataSet = commands[0];
                    if (!dict.ContainsKey(dataSet))
                    {
                        dict[dataSet] = new Dictionary<string, long>();
                    }
                    if (cache.ContainsKey(dataSet))
                    {
                        foreach (var pair in cache[dataSet])
                        {
                            dict[dataSet][pair.Key] = pair.Value;
                        }
                    }
                }
                else
                {
                    var dataKey = commands[0];
                    var dataSize = long.Parse(commands[1]);
                    var dataSet = commands[2];

                    if (dict.ContainsKey(dataSet))
                    {
                        dict[dataSet][dataKey] = dataSize;
                    }
                    else
                    {
                        if (!cache.ContainsKey(dataSet))
                        {
                            cache[dataSet] = new Dictionary<string, long>();
                        }
                        if (!cache[dataSet].ContainsKey(dataKey))
                        {
                            cache[dataSet][dataKey] = 0;
                        }
                        cache[dataSet][dataKey] = dataSize;
                    }

                }
                input = Console.ReadLine();
            }
            if (dict.Count != 0)
            {
                foreach (var pair in dict.OrderByDescending(x => x.Value.Values.Sum())
                 .Take(1))
                {
                    Console.WriteLine($"Data Set: {pair.Key}, Total Size: {pair.Value.Values.Sum()}");
                    foreach (var pair1 in pair.Value)
                    {
                        Console.WriteLine($"$.{pair1.Key}");
                    }
                }
            }
            
        }
    }
}
