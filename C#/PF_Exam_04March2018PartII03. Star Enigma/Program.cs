using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace PF_Exam_04March2018PartII03._Star_Enigma
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, List<string>>();
            int n = int.Parse(Console.ReadLine());
            char[] starChars = "STARstar".ToCharArray();
            while (n-->0)
            {
                string input = Console.ReadLine();
                var count = 0;
                for (int i = 0; i < input.Length; i++)
                {
                    if (starChars.Contains(input[i]))
                    {
                        count++;
                    }
                }
                string result = string.Empty;
                for (int i = 0; i < input.Length; i++)
                {
                    result += (char)((int)(input[i] - count));
                }
                Regex regex = new Regex(@"(?:@)([A-Za-z]+)[^@\-!:>]*:[0-9]+[^@\-!:>]*![A|D]![^@\-!:>]*->[0-9]+");
                if (regex.IsMatch(result))
                {
                    var planet = regex.Match(result).Groups[1].Value;

                    var attackType = result.Contains("!A!") ? "Attacked" : "Destroyed";

                    if (!dict.ContainsKey(attackType))
                    {
                        dict.Add(attackType, new List<string>());
                        dict[attackType].Add(planet);
                    }
                    else
                    {
                        dict[attackType].Add(planet);
                    }
                }
            }
            if (!dict.ContainsKey("Attacked"))
            {
                Console.WriteLine($"Attacked planets: 0");
            }
            foreach (var pair in dict.OrderBy(x=>x.Key))
            {
                Console.WriteLine($"{pair.Key} planets: {pair.Value.Count}");
                foreach (var planet in pair.Value.OrderBy(x=>x))
                {
                    Console.WriteLine($"-> {planet}");
                }
            }
            if (!dict.ContainsKey("Destroyed"))
            {
                Console.WriteLine("Destroyed planets: 0");
            }
        }
    }
}
