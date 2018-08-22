using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace PF_Exam_05November2017_PartII_03._Anonymous_Vox
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string[] names = Console.ReadLine()
                .Split(new char[] { '{', '}' }, StringSplitOptions.RemoveEmptyEntries);
            List<string> placeholders = new List<string>();
            Regex regex = new Regex(@"([A-Za-z]+)(.+)\1");
            var result = string.Empty;
            var counter = 0;
            MatchCollection matches = regex.Matches(input);

            foreach (Match m in matches)
            {
                if(counter < names.Length)
                {
                    string currentValue = names[counter];
                    Regex regex1 = new Regex(Regex.Escape(m.Groups[2].Value));
                    input = regex1.Replace(input, names[counter], 1);
                }

                counter++;
            }
            Console.WriteLine(input);
        }
    }
}
