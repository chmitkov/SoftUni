using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace PF_Exam___05_November_2017_Part_I_03._Anonymous_Vox
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            string[] values = Console.ReadLine()
                            .Trim()
                            .Split(new string[] { "{", "}" }, StringSplitOptions
                            .RemoveEmptyEntries)
                            .ToArray();

            string pattern = @"([a-zA-Z]+)(.+)(\1)";

            Regex reg = new Regex(pattern);
            int index = 0;

            foreach (Match item in reg.Matches(input))
            {
                if (index < values.Length)
                {
                    string currentValue = values[index];
                    Regex regex = new Regex(Regex.Escape(item.Groups[2].Value));
                    input = regex.Replace(input, values[index], 1);
                }

                index++;
            }

            Console.WriteLine(input);
        }
    }
}
