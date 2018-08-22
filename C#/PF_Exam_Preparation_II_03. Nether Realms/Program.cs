using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace PF_Exam_Preparation_II_03._Nether_Realms
{
    class Program
    {
        static void Main(string[] args)
        {

            string[] names = Console.ReadLine()
                .Split(new char[] { ' ', ',' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            var dict = new Dictionary<string, Dictionary<int, double>>();

            foreach (var name in names)
            {
                string healthPattern = @"[0-9+*-\/\.]";
                Regex regex = new Regex(healthPattern);
                string nameString = regex.Replace(name, "");
                var health = 0;
                foreach (var c in nameString)
                {
                    health += (int)c;
                }

                string powerPattern = @"\-*[0-9]*\.*[0-9]*";
                Regex regex2 = new Regex(powerPattern);
                double power = 0.0;
                MatchCollection m = regex2.Matches(name);
                foreach (var match in m)
                {
                    if (match.ToString().Length >= 1)
                    {
                        var currMatch = match.ToString();
                        if (currMatch.Contains("-"))
                        {
                            currMatch = currMatch.Substring(1);
                            power += -(double.Parse(currMatch));
                        }
                        else
                        {
                            power += double.Parse(currMatch);
                        }
                    }
                }

                foreach (var ch in name)
                {
                    if (ch == '/')
                    {
                        power /= 2;
                    }
                    else if (ch == '*')
                    {
                        power *= 2;
                    }
                }

                if (!dict.ContainsKey(name))
                {
                    dict[name] = new Dictionary<int, double>();
                }
                if (!dict[name].ContainsKey(health))
                {
                    dict[name][health] = 0.0;
                }
                dict[name][health] = power;
            }

            foreach (var pair in dict.OrderBy(x=>x.Key))
            {
                foreach (var pair1 in pair.Value)
                {
                    Console.WriteLine($"{pair.Key} - {pair1.Key} health, {pair1.Value:F2} damage");
                }
                
            }

        }
    }
}
