using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace StringAndRegEx_P_06
{
    class Program
    {
        static void Main(string[] args)
        {
            var phones = Console.ReadLine();
            var pattern = @"\b\+359 2 [0-9]+ [0-9]+\b";
            MatchCollection phoneMatches = Regex.Matches(phones, pattern);
            foreach (Match phone in phoneMatches)
            {
                Console.WriteLine(phone);
            }
           
        }
    }
}
