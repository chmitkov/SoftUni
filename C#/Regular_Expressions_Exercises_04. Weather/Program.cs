using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace Regular_Expressions_Exercises_04._Weather
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var dict = new Dictionary<string, Dictionary<string, double>>();
            string pattern = @"([A-Z]{2})([0-9]+\.[0-9]+)([A-Za-z]+)\|";
            while (input != "end")
            {
                if (Regex.IsMatch(input, pattern))
                {
                    var city = Regex.Match(input, pattern).Groups[1].Value;
                    var temp = double.Parse(Regex.Match(input, pattern).Groups[2].Value);
                    var type = Regex.Match(input, pattern).Groups[3].Value;

                    if (!dict.ContainsKey(city))
                    {
                        dict.Add(city, new Dictionary<string, double>());
                        dict[city].Add(type, temp);
                    }
                    else
                    {
                        dict[city].Clear();
                        dict[city].Add(type, temp);
                    }
                }
                input = Console.ReadLine();
            }

            foreach (var pair in dict.OrderBy(x=>x.Value.Values.Sum()))
            {
                foreach (var pair1 in pair.Value)
                {
                    Console.WriteLine($"{pair.Key} => {pair1.Value:f2} => {pair1.Key}");
                }
            }
        }
    }
}
