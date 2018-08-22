using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace StringAndRegEx_P_05
{
    class Program
    {
        static void Main(string[] args)
        {
            var pattern = @"\b[A-Z][a-z]+ [A-Z][a-z]+\b";
            string names = Console.ReadLine();

            MatchCollection match = Regex.Matches(names, pattern);
            foreach (var name in match)
            {
                Console.WriteLine(name+" ");
            }
        }
    }
}
