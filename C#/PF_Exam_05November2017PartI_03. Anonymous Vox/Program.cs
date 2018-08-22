using System;
using System.Text.RegularExpressions;

namespace PF_Exam_05November2017PartI_03._Anonymous_Vox
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string[] placeholders = Console.ReadLine()
                .Split(new char[] { '{', '}' }, StringSplitOptions.RemoveEmptyEntries);
            Regex regex = new Regex(@"([A-Za-z]+)(.+)\1");
            MatchCollection matches = regex.Matches(input);
            var counter = 0;
            foreach (Match match in matches)
            {
                var currMatch = match.Groups[2].Value;
                input = input.Replace(currMatch, placeholders[counter]);
                counter++;
            }
            Console.WriteLine(input);
        }
    }
}
