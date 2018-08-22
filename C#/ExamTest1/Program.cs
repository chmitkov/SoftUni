using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamTest1
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
                var command = input.Split(new char[] { ' ', '-', '>', '|' }
                , StringSplitOptions.RemoveEmptyEntries)
                .ToArray();                
                if (command.Length > 1)
                {
                    var dataKey = command[0];
                    var dataSize = long.Parse(command[1]);
                    var dataSet = command[2];
                    if (!dict.ContainsKey(dataSet))
                    {
                        if (!cache.ContainsKey(dataSet))
                        {
                            cache[dataSet] = new Dictionary<string, long>();
                        }
                        if (!cache[dataSet].ContainsKey(dataKey))
                        {
                            cache[dataSet][dataKey] = 0;
                        }
                        cache[dataSet][dataKey] += dataSize;
                    }
                    else
                    {
                        if (!dict[dataSet].ContainsKey(dataKey))
                        {
                            dict[dataSet][dataKey] = 0;
                        }
                        dict[dataSet][dataKey] += dataSize;
                    }                   
                }
                else
                {
                    var dataSet = command[0];
                    if (!dict.ContainsKey(dataSet))
                    {
                        dict[dataSet] = new Dictionary<string, long>();
                    }
                    if (cache.ContainsKey(dataSet))
                    {
                        foreach (var pair in cache[dataSet])
                        {
                            if (!dict[dataSet].ContainsKey(pair.Key))
                            {
                                dict[dataSet][pair.Key] = 0;
                            }
                            dict[dataSet][pair.Key] += pair.Value;
                        }
                    }
                }
                input = Console.ReadLine();
            }
            if (dict.Count != 0)
            {
                foreach (var pair in dict.OrderByDescending(x=>x.Value.Values.Sum()).Take(1))
                {
                    Console.WriteLine($"Data Set: {pair.Key}, Total Size: {pair.Value.Values.Sum()}");
                    foreach (var pair1 in pair.Value)
                    {
                        Console.WriteLine($"$.{pair1.Key}");
                    }
                    
                    //Data Set: { dataSet}, Total Size: { sumOfAllDataSizes}
                    //   $.{ dataKey1}
                    //       $.{ dataKey2}
                }
            }
        }
    }
}
