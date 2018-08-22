using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace StringAndRegEx_P_07
{
    class Program
    {
        static void Main(string[] args)
        {
            var pattern = @"\b(0x)?[0-9A-F]+\b";
            var input = Console.ReadLine();
            var match = Regex.Matches(input, pattern)
                .Cast<Match>()
                .Select(a => a.Value)
                .ToArray();
            Console.WriteLine(string.Join(" ", match));
            
        }
    }
}
