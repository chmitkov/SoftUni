using System;
using System.Text;
using System.Text.RegularExpressions;

namespace PF_Retake_Exam_25April2018Part_I_02._Memory_View
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            StringBuilder alltext= new StringBuilder();
            while (input != "Visual Studio crash")
            {
                alltext.Append(input + " ");
                input = Console.ReadLine();
            }

            Regex regex = new Regex(@"32656 19759 32763 0 [0-9] 0 (([0-9]{2,3} )+)");
            var matches = regex.Matches(alltext.ToString());
            foreach (Match m in matches)
            {
                var current = m.Groups[1].Value.TrimEnd().ToString();
                FromStrToChar(current);
                Console.WriteLine();
            }
        }
        private static void FromStrToChar(string str)
        {
            string[] curr = str.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
            foreach (var c in curr)
            {
                char final = (char)(int.Parse(c));
                Console.Write(final);                
            }
        }
    }
}
