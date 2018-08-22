using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace PF_Exam_I___June_2016_04._Population_Aggregation
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var dict = new Dictionary<string, Dictionary<string, decimal>>();
            
            while (input != "stop")
            {
                string[] command = input
                    .Split(new char[] { '\\' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                var population = decimal.Parse(command[2]);
                string bannedSimbols = @"[@|$|#|&|0-9]";
                Regex regex = new Regex(bannedSimbols);
                input = regex.Replace(input, "");

                string countryPattern = @"(?:\\)*([A-Z]+[a-z]*)(?:\\)*";
                Regex regex2 = new Regex(countryPattern);
                var country = regex2.Match(input).Groups[1].ToString();
               
                string cityPattertn = @"(?:\\)([a-z]+)(?:\\)|^([a-z]+)(?:\\)";
                Regex regex3 = new Regex(cityPattertn);
                var city = string.Empty;
                if (regex3.Match(input).Groups[1].Success)
                {
                    city = regex3.Match(input).Groups[1].ToString();
                }
                else
                {
                    city = regex3.Match(input).Groups[2].ToString();
                }                

                if (!dict.ContainsKey(country))
                {
                    dict[country] = new Dictionary<string, decimal>();
                }
                if (dict[country].ContainsKey(city))
                {
                    dict[country][city] = 0;
                }
                dict[country][city] = population;
                input = Console.ReadLine();
            }
            foreach (var pair in dict.OrderBy(x => x.Key))
            {
                Console.WriteLine($"{pair.Key} -> {pair.Value.Keys.Count}");
            }

            foreach (var pair in dict.OrderByDescending(x=>x.Value.Values.Sum()).Take(2))
            {               
                foreach (var pair1 in pair.Value)
                {
                    Console.WriteLine($"{pair1.Key} -> {pair1.Value}");
                }
            }
        }
    }
}
