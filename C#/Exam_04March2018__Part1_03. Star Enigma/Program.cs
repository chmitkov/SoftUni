using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace Exam_04March2018__Part1_03._Star_Enigma
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> attacked = new List<string>();
            List<string> destroyed = new List<string>();

            int n = int.Parse(Console.ReadLine());

            while (n-- > 0)
            {
                string input = Console.ReadLine();
                char[] neededChars = new char[] { 's', 't', 'a', 'r','S','T','A','R' };
                var counter = 0;
                for (int i = 0; i < input.Length; i++)
                {
                    if (neededChars.Contains(input[i]))
                    {
                        counter++;
                    }
                }
                string decodeStr = string.Empty;
                for (int i = 0; i < input.Length; i++)
                {
                    decodeStr += (char)(input[i] - counter);
                }

                Regex regexName = new Regex(@"(?:@)([A-Za-z]+)[^@\-!:>]*:[0-9]+[^@\-!:>]*![A|D]![^@\-!:>]*->[0-9]+");
                var planetName = regexName.Match(decodeStr).Groups[1].ToString();

                if (regexName.IsMatch(decodeStr))
                {
                    if (decodeStr.Contains("!A!"))
                    {
                        attacked.Add(planetName);
                    }
                    else if (decodeStr.Contains("!D!"))
                    {
                        destroyed.Add(planetName);
                    }
                }
            }
            Console.WriteLine($"Attacked planets: {attacked.Count}");
            foreach (var planet in attacked.OrderBy(x => x))
            {
                Console.WriteLine($"-> {planet}");
            }
            Console.WriteLine($"Destroyed planets: {destroyed.Count}");
            foreach (var planet in destroyed.OrderBy(x=>x))
            {
                Console.WriteLine($"-> {planet}");
            }
        }
    }
}
