using System;
using System.Text.RegularExpressions;

namespace Regular_Expressions_Lab_06._Replace_a_Tag
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string result = string.Empty;

            while (input != "end")
            {
                string pattern = @"<a.*?href.*?=(.*)>(.*?)<\/a>";
                string replace = @"[URL href=$1]$2[/URL]";
                string replaced = Regex.Replace(input, pattern, replace);
                Console.WriteLine(replaced);

                input = Console.ReadLine();
            }
        }
    }
}
