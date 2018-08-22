using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace Regular_Expressions_Lab_02._Match_Phone_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            Regex regex = new Regex(@"\+359( |-)2\1\d{3}\1\d{4}\b");

            MatchCollection matches = regex.Matches(input);
            List<string> result = new List<string>();
            foreach (Match m in matches)
            {
                result.Add(m.ToString());
            }

            Console.WriteLine(  string.Join(", ",result));
        }
    }
}
