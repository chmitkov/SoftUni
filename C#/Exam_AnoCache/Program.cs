using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam_AnoCache
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var allSet = new Dictionary<string, Dictionary<string, List<int>>>();
            var cacheSet = new Dictionary<string, Dictionary<string, List<int>>>();

            while (input != "thetinggoesskrra")
            {
                string[] command = input
                .Split(new char[] { ' ', '-', '>', '|' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();

                if (command.Length == 1)
                {
                    var dataSet = command[0];
                    if (!allSet.ContainsKey(dataSet))
                    {
                        allSet[dataSet] = new Dictionary<string, List<int>>();
                    }
                    if (cacheSet.ContainsKey(dataSet))
                    {
                        allSet.Add(dataSet, cacheSet[dataSet]);
                    }
                }
                else
                {
                    var dataSet = command[2];
                    var dataKey = command[0];
                    var dataSize = int.Parse(command[1]);
                    if (allSet.ContainsKey(dataSet))
                    {
                        if (!allSet[dataSet].ContainsKey(dataKey))
                        {
                            allSet[dataSet][dataKey] = new List<int>();
                        }
                        allSet[dataSet][dataKey].Add(dataSize);
                    }
                    else
                    {
                        cacheSet[dataSet][dataKey].Add(dataSize);
                    }
                }

                input = Console.ReadLine();
            }
            //if (allSet.Count > 0)
            //{
            //    var newSet = allSet.OrderByDescending(x => x.Value.Values).Take(1);
            //    foreach (var pair in newSet)
            //    {
            //        Console.WriteLine($"Data Set: {pair.Key}, Total Size: {pair.Value.Values.Sum() }");
            //        foreach (var pair1 in pair.Value)
            //        {
            //            Console.WriteLine($"$.{pair1.Key}");
            //        }
            //    }
            //    //Data Set: Users, Total Size: 26233
            //    //$.Students
            //    //$.Workers
            Console.WriteLine(allSet.Count);
            foreach (var pair in allSet)
            {
                Console.WriteLine(pair.Key);
                foreach(var pair1 in pair.Value)
                {
                    Console.WriteLine(pair1.Key);
                    Console.WriteLine(string.Join(" ",pair1.Value));

                }
                //Console.WriteLine(pair.Value.Keys);
                //Console.WriteLine(string.Join(" ", pair.Value.Values));
            }
            foreach (var pair in allSet.OrderByDescending(x => x.Value.Values).Take(1)) { }
        }
    }
}

