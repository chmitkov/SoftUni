using System;
using System.Text.RegularExpressions;

namespace PF_Exam_09July2017Part_1_03._Regexmon
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string bojoPattern = @"([A-Za-z]+)-([A-Za-z]+)";
            string didiPattern = @"[^A-Za-z\-]+";

            while (input.Length > 0)
            {
                if (Regex.IsMatch(input, didiPattern))
                {
                    var match = Regex.Match(input, didiPattern).Value;
                    Console.WriteLine(match);
                    int index = input.IndexOf(match[match.Length - 1]);
                    input = input.Substring(index + 1);
                }
                else
                {
                    return;
                }

                if (Regex.IsMatch(input, bojoPattern))
                {
                    var match = Regex.Match(input, bojoPattern).Value;
                    Console.WriteLine(match);
                    int index = input.IndexOf(match[match.Length - 1]);
                    input = input.Substring(index + 1);
                }
                else
                {
                    return;
                }

            }
        }
    }
}
