using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace Regular_Expressions_Exercises_05.KeyReplacer
{
    class Program
    {
        static void Main(string[] args)
        {
            string startAndEnd = Console.ReadLine();

            string text = Console.ReadLine();
            string patternStartEnd = @"^([A-Za-z]+)[<\|\\].+[<\|\\]([A-Za-z]+)$";
            List<string> result = new List<string>();
            if (Regex.IsMatch(startAndEnd, patternStartEnd))
            {
                var start = Regex.Match(startAndEnd, patternStartEnd).Groups[1].Value;
                var end = Regex.Match(startAndEnd, patternStartEnd).Groups[2].Value;
               
                string patternMidPart = $@"{start}([A-Za-z]*?){end}";
                if (Regex.IsMatch(text, patternMidPart))
                {
                    MatchCollection matches = Regex.Matches(text, patternMidPart);

                    foreach (Match item in matches)
                    {
                        if (item.Groups[1].Value.Length >= 1)
                        {
                            result.Add(item.Groups[1].Value);
                        }
                    }
                }
                
                if (result.Count != 0)
                {
                    Console.WriteLine(string.Join("",result));
                }
                else
                {
                    Console.WriteLine("Empty result");
                }

            }
            else
            {
                Console.WriteLine("Empty result");
            }
        }
    }
}
