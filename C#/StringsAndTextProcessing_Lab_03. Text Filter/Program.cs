using System;
using System.Text.RegularExpressions;

namespace StringsAndTextProcessing_Lab_03._Text_Filter
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] toReplace = Console.ReadLine().Split(new char[] { ' ', ',' }
            , StringSplitOptions.RemoveEmptyEntries);
            string str = Console.ReadLine();

            foreach (var word in toReplace)
            {
                str = str.Replace(word, new string('*', word.Length));
            }
            Console.WriteLine(str);
        }
    }
}
