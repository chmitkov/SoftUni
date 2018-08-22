using System;
using System.Text.RegularExpressions;

namespace PF_Retake_Exam___05_January_2018_Part_I_03._Snowflake
{
    class Program
    {
        static void Main(string[] args)
        {
            string row1 = Console.ReadLine();
            string row2 = Console.ReadLine();
            string row3 = Console.ReadLine();
            string row4 = Console.ReadLine();
            string row5 = Console.ReadLine();

            string surfacePattern = @"[^0-9A-Za-z]+$";
            string mantlePattern = @"[0-9_]+$";
            string corePattern = @"[A-Za-z]+";
            string midRowPattern = @"[^0-9A-Za-z]+[0-9_]+[A-Za-z]+[0-9_]+[^0-9A-Za-z]+";

            Regex regex1 = new Regex(surfacePattern);
            Regex regex2 = new Regex(mantlePattern);
            Regex regex3 = new Regex(corePattern);
            Regex regex4 = new Regex(midRowPattern);
            var core = regex3.Match(row3).ToString();

            if (!regex1.IsMatch(row1))
            {
                Console.WriteLine("Invalid");
                return;
            }
            if (!regex2.IsMatch(row2))
            {
                Console.WriteLine("Invalid");
                return;
            }
            if (!regex4.IsMatch(row3))
            {
                Console.WriteLine("Invalid");
                return;
            }
            if (!regex2.IsMatch(row4))
            {
                Console.WriteLine("Invalid");
                return;
            }
            if (!regex1.IsMatch(row5))
            {
                Console.WriteLine("Invalid");
                return;
            }
            Console.WriteLine("Valid");
            Console.WriteLine($"{core.Length}");
        }
    }
}
