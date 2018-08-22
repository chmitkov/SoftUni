using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace Regular_Expressions_Exercises_02._Extract_SentencesByKeyword
{
    class Program
    {
        static void Main(string[] args)
        {
            string word = Console.ReadLine();
            string input = Console.ReadLine();

            List<string> result = new List<string>();
            Regex regexSentence = new Regex(@"([A-Z]+(.)+?)[\.!?]");
            MatchCollection matches = regexSentence.Matches(input);
            Regex regexWord = new Regex($@"\b({word})\b");
            foreach (Match item in matches)
            {
                if (regexWord.IsMatch(item.Value))
                {
                    result.Add(item.Groups[1].Value);
                }
            }
            Console.WriteLine(string.Join("\n",result));
        }
    }
}
