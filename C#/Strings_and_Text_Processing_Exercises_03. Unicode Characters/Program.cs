using System;
using System.Linq;
using System.Text;

namespace Strings_and_Text_Processing_Exercises_03._Unicode_Characters
{
    class Program
    {
        static void Main(string[] args)
        {
            string str = Console.ReadLine();
            var sb = new StringBuilder();
            foreach (var c in str)
            {
                sb.Append($@"\u{(int)c:x4}");
            }
            Console.WriteLine(sb);
        }
    }
}