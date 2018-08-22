using System;
using System.Text.RegularExpressions;

namespace PF_Exam_05January2018_PartII_03.Snowflake
{
    class Program
    {
        static void Main(string[] args)
        {
            string surface = Console.ReadLine();
            string mantle = Console.ReadLine();
            string core = Console.ReadLine();
            string mantle2 = Console.ReadLine();
            string surface2 = Console.ReadLine();

            Regex regexSurface = new Regex(@"[^0-9A-Za-z]+$");
            Regex regexMantle = new Regex(@"[0-9_]+$");
            Regex regexMidRow = new Regex(@"^[^A-Za-z0-9]+[0-9_]+([A-Za-z]+)[0-9_]+[^A-Za-z0-9]+$");
            var coreStr = regexMidRow.Match(core).Groups[1].ToString();
            bool isSnowflake = true;

            if (!regexSurface.IsMatch(surface))
            {
                isSnowflake = false;
            }
            if (!regexMantle.IsMatch(mantle))
            {
                isSnowflake = false;
            }
            if (!regexMidRow.IsMatch(core))
            {
                isSnowflake = false;
            }
            if (!regexMantle.IsMatch(mantle2))
            {
                isSnowflake = false;
            }
            if (!regexSurface.IsMatch(surface2))
            {
                isSnowflake = false;
            }

            if (isSnowflake)
            {
                Console.WriteLine("Valid");
                Console.WriteLine($"{coreStr.Length}");
            }
            else
            {
                Console.WriteLine("Invalid");
            }
        }
    }
}
