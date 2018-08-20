using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace Regex_03
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            string input = Console.ReadLine();
            string num1 = "{" + $"{nums[0]}" +"}";
            string str = "{0," + $"{nums[1]}" + "}";
            string pattern = $@"\|<\b(.{num1})(\w{str})";

            MatchCollection matches = Regex.Matches(input, pattern);
            List<string> result = new List<string>();
            foreach (Match item in matches)
            {
                result.Add(item.Groups[1].Value);
            }
            Console.WriteLine(string.Join(", ",result));
        }
    }
}
