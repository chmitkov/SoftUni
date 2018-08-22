using System;
using System.Text.RegularExpressions;

namespace PF_Retake_Exam_05January2018PartI_03._Snowflake
{
    class Program
    {
        static void Main(string[] args)
        {
            Regex regexSurface = new Regex(@"^([^A-Za-z0-9]+)$");
            Regex regexMantle = new Regex(@"^([0-9_]+)$");
            Regex regexMidRow = new Regex(@"^([^A-Za-z0-9]+)([0-9_]+)([A-Za-z]+)([0-9_]+)([^A-Za-z0-9]+)$");
            string coreStr = string.Empty ;
            

            if (!regexSurface.IsMatch(Console.ReadLine()))
            {
                Console.WriteLine("Invalid");
                return;
            }
            if (!regexMantle.IsMatch(Console.ReadLine()))
            {
                Console.WriteLine("Invalid");
                return;
            }
            string midRow = Console.ReadLine();
            if (!regexMidRow.IsMatch(midRow))
            {
                Console.WriteLine("Invalid");
                return;
            }
            else
            {
                coreStr = regexMidRow.Match(midRow).Groups[3].ToString();
            }
            if (!regexMantle.IsMatch(Console.ReadLine()))
            {
                Console.WriteLine("Invalid");
                return;
            }
            if (!regexSurface.IsMatch(Console.ReadLine()))
            {
                Console.WriteLine("Invalid");
                return;
            }
            Console.WriteLine($"Valid\n{coreStr.Length}");
        }
    }
}
