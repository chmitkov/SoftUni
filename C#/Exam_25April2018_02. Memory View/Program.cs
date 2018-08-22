using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace Exam_25April2018_02._Memory_View
{
    class Program
    {
        static void Main(string[] args)
        {
            string str = Console.ReadLine();
            string allRows = string.Empty;
            while (str != "Visual Studio crash")
            {
                allRows += " ";
                allRows += str;
                str = Console.ReadLine();
            }
            var pattern = @"(?:32656 19759 32763) 0\s*([0-9]) 0 (([0-9]{2,3}+ )+)";
            Regex regex = new Regex(pattern);
            MatchCollection maches = regex.Matches(allRows);
            List<string> result = new List<string>();
            foreach (Match word in maches)
            {
                result.Add(word.Groups[2].ToString());
            }
            foreach (var nums in result)
            {
                string[] currNums = nums.Split();
                string currWord = string.Empty;
                foreach (var n in currNums)
                {
                    currWord += char.Parse(n);
                }
                Console.WriteLine(currWord);
            }
        }
    }
}
