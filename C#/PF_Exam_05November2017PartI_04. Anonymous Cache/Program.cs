using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam_05November2017PartI_04._Anonymous_Cache
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, Dictionary<string, long>>();
            var cache = new Dictionary<string, Dictionary<string, long>>();
            string input = Console.ReadLine();

            while (input!= "thetinggoesskrra")
            {
                string[] commmands = input
                .Split(new char[] { ' ', '-', '>', '|' }, StringSplitOptions.RemoveEmptyEntries);
                if (commmands.Length == 1)
                {
                    var dataSet = commmands[0];
                    if (!dict.ContainsKey(dataSet))
                    {
                        dict.Add(dataSet, new Dictionary<string, long>());
                    }
                    if (cache.ContainsKey(dataSet))
                    {
                        dict[dataSet] = cache[dataSet];
                    }
                }
                else
                {
                    var dataSet = commmands[2];
                    var dataKey = commmands[0];
                    long dataSize = long.Parse(commmands[1]);
                    if (dict.ContainsKey(dataSet))
                    {
                        dict[dataSet].Add(dataKey, dataSize);
                    }
                    else
                    {
                        if (!cache.ContainsKey(dataSet))
                        {
                            cache.Add(dataSet, new Dictionary<string, long>());
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
