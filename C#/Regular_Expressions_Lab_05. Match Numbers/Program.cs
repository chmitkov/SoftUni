using System;
using System.Text.RegularExpressions;

namespace Regular_Expressions_Lab_05._Match_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            var matches = Regex.Matches(input,
                @"(^|(?<=\s))-?(\d+)(\.\d+)?($|(?=\s))");

            foreach (Match item in matches)
            {
                Console.Write(item.Value + " ");
            }

        }
    }
}
