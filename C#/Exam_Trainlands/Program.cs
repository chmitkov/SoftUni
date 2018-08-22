using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam_Trainlands
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var dict = new Dictionary<string, Dictionary<string, int>>();
            while (input != "It's Training Men!")
            {
                string[] commands = input
                    .Split(new char[] { ' ' }
                    , StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();

                if (commands.Length == 5)
                {
                    var trainName = commands[0];
                    var wagonName = commands[2];
                    var wagonPower = int.Parse(commands[4]);
                    if (!dict.ContainsKey(trainName))
                    {
                        dict[trainName] = new Dictionary<string, int>();
                    }
                    dict[trainName].Add(wagonName, wagonPower);
                }
                else
                {
                    if (input.Contains("->"))
                    {
                        var trainName = commands[0];
                        var otherTrainName = commands[2];
                        if (!dict.ContainsKey(trainName))
                        {
                            dict[trainName] = new Dictionary<string, int>();
                        }
                        if (!dict.ContainsKey(otherTrainName))
                        {
                            dict[otherTrainName] = new Dictionary<string, int>();
                        }
                        foreach (var pair in dict[otherTrainName])
                        {
                            dict[trainName].Add(pair.Key, pair.Value);
                        }
                        dict.Remove(otherTrainName);
                    }
                    else
                    { 
                        var trainName = commands[0];
                        var otherTrainName = commands[2];
                        if (!dict.ContainsKey(trainName))
                        {
                            dict[trainName] = new Dictionary<string, int>();
                        }
                        if (!dict.ContainsKey(otherTrainName))
                        {
                            dict[otherTrainName] = new Dictionary<string, int>();
                        }
                        dict[trainName].Clear();
                        foreach (var pair in dict[otherTrainName])
                        {
                            dict[trainName].Add(pair.Key, pair.Value);
                        }
                    }
                }
                input = Console.ReadLine();
            }
            foreach (var pair in dict.OrderByDescending(x => x.Value.Values.Sum())
                .ThenBy(x => x.Value.Values.Count))
            {
                var trainName = pair.Key;
                Console.WriteLine($"Train: {trainName}");
                var wagons = pair.Value.OrderByDescending(x => x.Value);
                foreach (var pair1 in wagons)
                {
                    Console.WriteLine($"###{pair1.Key} - {pair1.Value}");
                }
            }
        }
    }
}
