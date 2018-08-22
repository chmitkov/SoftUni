using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace StringAndRegEx_P_09
{
    class Program
    {
        static void Main(string[] args)
        {
            var pattern = @"(^|(?<=\s))-?\d+(\.\d+)?($|(?=\s))";
            var input = Console.ReadLine();
            var match = Regex.Matches(input, pattern);
            foreach (var num in match)
            {
                Console.WriteLine(num +" ");
            }
        }
    }
}
