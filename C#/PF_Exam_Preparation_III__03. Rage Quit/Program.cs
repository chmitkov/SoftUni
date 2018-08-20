using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using System.Linq;

namespace PF_Exam_Preparation_III__03._Rage_Quit
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine().ToUpper();
            var result = new List<string>();
            string final = string.Empty;
            string pattern = @"(\D)+([0-9]{1,2})";
            Regex regex = new Regex(pattern);
            MatchCollection m = regex.Matches(input);
            foreach (var match in m)
            {
                result.Add(match.ToString());
            }
            foreach (var item in result)
            {
                string num = regex.Match(item).Groups[2].ToString();
                string str = item.ToString();
                if (num.Length == 1)
                {
                    str = str.Substring(0, str.Length - 1);
                }
                else
                {
                    str = str.Substring(0, str.Length - 2);
                }
                int number = int.Parse(num);
                for (int i = 0; i < number; i++)
                {
                    final += str.ToUpper();
                }               
            }
            var diffChars = new List<char>();

            foreach (var ch in final)
            {
                if (!diffChars.Contains(ch))
                {
                    diffChars.Add(ch);
                }
            }
            Console.WriteLine($"Unique symbols used: {diffChars.Count}");
            Console.WriteLine(final);
        }
    }
}
