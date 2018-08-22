using System;
using System.Text.RegularExpressions;

namespace Regular_Expressions_Lab_03._Match_Hexadecimal_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            MatchCollection matches = Regex.Matches(input,
                @"\b(0x)?[A-F0-9]+\b");

            foreach (Match item in matches)
            {
                Console.Write(item.Value+" ");
            }

        }
    }
}
