using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Exam_Anon
{
    class Program
    {
        static void Main(string[] args)
        {
            string placeholders = Console.ReadLine();
            string placeholderPattern = @"([A-Za-z]+)(.+)(\1)";
            string values = Console.ReadLine();
            string valuesPattern = @"({)(.*?)(})";
            MatchCollection placeholderCollection = Regex.Matches(placeholders, placeholderPattern);
            MatchCollection valueCollection = Regex.Matches(values, valuesPattern);
            for (int i = 0; i < Math.Min(placeholderCollection.Count,
                valueCollection.Count); i++)
            {
                string toChange = placeholderCollection[i].Groups[2].Value;
                string toPut = valueCollection[i].Groups[2].Value;
                int index = placeholders.IndexOf(toChange);
                placeholders = placeholders.Remove(index, toChange.Length);
                placeholders = placeholders.Insert(index, toPut);
            }
            Console.WriteLine(placeholders);
        }
    }
}
