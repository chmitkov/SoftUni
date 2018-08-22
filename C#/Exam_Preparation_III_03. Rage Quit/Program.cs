using System;
using System.Collections.Generic;
using System.Text;
using System.Text.RegularExpressions;

namespace Exam_Preparation_III_03._Rage_Quit
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine().ToUpper();
            var dict = new Dictionary<char, int>();
            string result = string.Empty;
            var matches = Regex.Matches(input, "(.*?)([0-9]+)");
            foreach (Match item in matches)
            {
                result += MyStringRepeater(item.Groups[1].ToString(), int.Parse(item.Groups[2].ToString()));
            }
            for (int i = 0; i < result.Length; i++)
            {
                if (!dict.ContainsKey(result[i]))
                {
                    dict.Add(result[i], 1);
                }
                else
                {
                    dict[result[i]]++;
                }
            }
            Console.WriteLine($"Unique symbols used: {dict.Count}");
            Console.WriteLine(result);
        }

        private static string MyStringRepeater(string v1, int v2)
        {
            string result = string.Empty;
            for (int i = 0; i < v2; i++)
            {
                result+=v1;
            }
            return result.ToString();
        }
    }
}
