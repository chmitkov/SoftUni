using System;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace Exam_PF_Retake_25April2018_Part1_02.Memory_View
{
    class Program
    {
        static void Main(string[] args)
        {
            string str = Console.ReadLine();
            string allText = string.Empty;
            while (str != "Visual Studio crash")
            {
                allText += " " + str;
                str = Console.ReadLine();
            }
            string pattern = @"32656 19759 32763 0 ([0-9]) 0 (([0-9]{2,3} )+)";
            Regex regex = new Regex(pattern);

            MatchCollection matches = regex.Matches(allText);
            foreach (Match m in matches)
            {
                var result = string.Empty;
                var numbers = m.Groups[2].ToString()
                    .Split(new char[] {' '},StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                for (int i = 0; i < numbers.Length; i++)
                {
                    var currNum = int.Parse(numbers[i]);
                    result += (char)currNum;
                }
                Console.WriteLine(result);
            }
        }
    }
}
