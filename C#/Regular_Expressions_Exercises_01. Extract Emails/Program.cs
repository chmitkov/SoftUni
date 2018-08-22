using System;
using System.Text.RegularExpressions;

namespace Regular_Expressions_Exercises_01._Extract_Emails
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            var matches = Regex.Matches(input,
                @"(^|(?<=\s))(([a-zA-Z0-9]+)([\.\-_]?)([A-Za-z0-9]+)(@)([a-zA-Z]+([\.\-_][A-Za-z]+)+))(\b|(?=\s))");

            foreach (Match item in matches)
            {
                Console.WriteLine(item.Value);
            }
        }
    }
}
