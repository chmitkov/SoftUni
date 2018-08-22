using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam_05November2017_PartII_04._Anonymous_Cache
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, Dictionary<string, decimal>>();
            var cache = new Dictionary<string, Dictionary<string, decimal>>();

            string input = Console.ReadLine();

            while (input != "thetinggoesskrra")
            {
                string[] commands = input
                    .Split(new char[] { ' ', '-', '>', '|' }, StringSplitOptions.RemoveEmptyEntries);

                if (commands.Length == 1)
                {
                    var dataSet = commands[0];
                    if (!dict.ContainsKey(dataSet))
                    {
                        dict.Add(dataSet, new Dictionary<string, decimal>());
                    }
                    if (cache.ContainsKey(dataSet))
                    {
                        dict[dataSet] = cache[dataSet];
                    }
                }
                else
                {
                    var dataKey = commands[0];
                    var dataSize = decimal.Parse(commands[1]);
                    var dataSet  = commands[2];

                    if (dict.ContainsKey(dataSet))
                    {
                        dict[dataSet].Add(dataKey, dataSize);
                    }
                    else
                    {
                        if (!cache.ContainsKey(dataSet))
                        {
                            cache.Add(dataSet, new Dictionary<string, decimal>());
                            cache[dataSet].Add(dataKey, dataSize);
                        }
                        else
                        {
                            cache[dataSet].Add(dataKey, dataSize);
                        }
                    }
                }
                input = Console.ReadLine();
            }
            foreach (var pair in dict.OrderByDescending(x=>x.Value.Values.Sum()).Take(1))
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
