using System;
using System.Collections.Generic;
using System.Linq;

namespace Dictionaries_LambdaAndLINQ_07._Population_Counter
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, Dictionary<string, long>>();

            string input = Console.ReadLine();
            while (input != "report")
            {
                string[] commands = input
                    .Split(new char[] { '|' }, StringSplitOptions.RemoveEmptyEntries);
                var country = commands[1];
                var city = commands[0];
                var popul = long.Parse(commands[2]);

                if (!dict.ContainsKey(country))
                {
                    dict.Add(country, new Dictionary<string, long>());
                    dict[country].Add(city, popul);
                }
                else
                {
                    if (!dict[country].ContainsKey(city))
                    {
                        dict[country].Add(city, popul);
                    }
                    else
                    {
                        dict[country][city] += popul;
                    }
                }
                input = Console.ReadLine();
            }

            foreach (var pair in dict.OrderByDescending(x=>x.Value.Values.Sum()))
            {
                Console.WriteLine($"{pair.Key} (total population: {pair.Value.Values.Sum()})");
                foreach (var pair1 in pair.Value.OrderByDescending(x=>x.Value))
                {
                    Console.WriteLine($"=>{pair1.Key}: {pair1.Value}");
                }
            }
        }
    }
}
