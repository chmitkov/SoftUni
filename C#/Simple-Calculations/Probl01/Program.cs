using System;
using System.Text.RegularExpressions;

namespace Probl01
{
    class Program
    {
        static void Main(string[] args)
        {
            string str = Console.ReadLine();
            string pattern = @"([A-Za-z])([0-9]+)([A-Za-z])";
            Regex regex = new Regex(pattern);
            decimal total = 0;
            MatchCollection matches = regex.Matches(str);

            foreach (Match m in matches)
            {
                total += WordSum(m.ToString());
            }

            Console.WriteLine($"{total:f2}");
        }
        public static decimal WordSum(string word)
        {
            decimal tempSum = 0;
            int num = int.Parse(word.Substring(1, word.Length - 2));
            if (Char.IsUpper(word[0]))
            {
                tempSum = (decimal)(num * 1.0 / (word[0] - 64));
            }
            else
            {
                tempSum = (decimal)(num*1.0 * (word[0] - 96));
            }
            if (Char.IsUpper(word[word.Length - 1]))
            {
                tempSum -= (word[word.Length - 1] - 64);
            }
            else
            {
                tempSum += (word[word.Length - 1] - 96);
            }

            return tempSum;
        }
    }
}
