using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Exam_Trinegram2
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            List<Match> result = new List<Match>();
            var pattern = @"(<\[\W*\]\.)(\.\[\w*\]\.)+";

            while (input != "Traincode!")
            {
                if (Regex.IsMatch(input, pattern))
                {
                    result.Add(Regex.Match(input, pattern));
                }
                input = Console.ReadLine();
            }
            Console.WriteLine(string.Join("\n",result));
        }
    }
}
