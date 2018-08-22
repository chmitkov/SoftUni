using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace Exam_Preparation_II_03._Nether_Realms
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] names = Console.ReadLine()
                .Split(new char[] { ' ', ',' }, StringSplitOptions.RemoveEmptyEntries);
            var dict = new SortedDictionary<string, Dictionary<int, double>>();
            
            foreach (var input in names)
            {
                var nums = Regex.Matches(input, @"-*[0-9]+\.*[0-9]*");
                var words = Regex.Matches(input, @"[^0-9+*-\/\.]");
                var damage = 0D;
                var health = 0;
                foreach (Match item in nums)
                {
                    damage += double.Parse(item.Value);
                }
                for (int i = 0; i < input.Length; i++)
                {
                    if (input[i] == '*')
                    {
                        damage *= 2;
                    }
                    else if (input[i] == '/')
                    {
                        damage /= 2;
                    }
                }
                foreach (Match item in words)
                {
                    var currChar = char.Parse(item.Value);
                    health += (int)currChar;
                }
                if (!dict.ContainsKey(input))
                {
                    dict.Add(input, new Dictionary<int, double>());
                    dict[input].Add(health, damage);
                }
                else
                {
                    dict[input].Add(health, damage);
                }
            }
            foreach (var pair in dict)
            {
                foreach (var pair1 in pair.Value)
                {
                    Console.WriteLine($"{pair.Key} - {pair1.Key} health, {pair1.Value:f2} damage");
                }
            }

        }
    }
}
