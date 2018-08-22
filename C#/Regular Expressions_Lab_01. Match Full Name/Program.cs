using System;
using System.Text.RegularExpressions;

namespace Regular_Expressions_Lab_01._Match_Full_Name
{
    class Program
    {
        static void Main(string[] args)
        {
            string names = Console.ReadLine();
                //.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

            Regex regex = new Regex(@"\b[A-Z][a-z]+ [A-Z][a-z]+\b");

            MatchCollection matches = regex.Matches(names);
            foreach (Match m in matches)
            {
                Console.Write(m.ToString()+" ");
            }
        }
    }
}
