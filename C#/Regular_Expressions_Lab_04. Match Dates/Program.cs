using System;
using System.Text.RegularExpressions;

namespace Regular_Expressions_Lab_04._Match_Dates
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

           MatchCollection matches= Regex.Matches(input,
               @"(?<day>\d{2})([-.\/])(?<month>[A-Z][a-z]{2})\1(?<year>\d{4})");

            foreach (Match item in matches)
            {
                Console.WriteLine($"Day: {item.Groups["day"].Value}, " +
                    $"Month: {item.Groups["month"].Value}, Year: {item.Groups["year"].Value}");
            }
        }
    }
}
