using System;
using System.Collections.Generic;
using System.Linq;

namespace Exam_AnoCache
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var database = new Dictionary<string, Dictionary<string, long>>();
            var cache = new Dictionary<string, Dictionary<string, long>>();
            while (input != "thetinggoesskrra")
            {
                var info = input.Split(new char[] { ' ', '-', '>', '|' }
                 , StringSplitOptions.RemoveEmptyEntries)
                 .ToArray();
                if (info.Length == 1)
                {
                    var dataSet = info[0];
                    if (!cache.ContainsKey(dataSet))
                    {
                        database[dataSet] = new Dictionary<string, long>();
                    }
                    else
                    {
                        database.Add(dataSet, cache[dataSet]);
                        cache.Remove(dataSet);
                    }
                }
                else
                {
                    var key = info[0];
                    var set = info[2];
                    var size = long.Parse(info[1]);
                    if (!database.ContainsKey(set))
                    {
                        if (!cache.ContainsKey(set))
                        {
                            cache[set] = new Dictionary<string, long>();
                        }
                        if (!cache[set].ContainsKey(key))
                        {
                            cache[set][key] = 0;
                        }
                        cache[set][key] += size;
                    }
                    else
                    {
                        if (!database[set].ContainsKey(key))
                        {
                            database[set][key] = 0;
                        }
                        database[set][key] += size;
                    }
                }

                input = Console.ReadLine();
            }
            foreach (var pair in database.OrderByDescending(x => x.Value.Values.Sum())
                .Take(1))
            {
                Console.WriteLine($"Data set: {pair.Key}, Total size: {pair.Value.Values.Sum()}");
                foreach (var pair1 in pair.Value)
                {
                    Console.WriteLine($"$.{pair1.Key}");
                }
            }
        }
    }
}