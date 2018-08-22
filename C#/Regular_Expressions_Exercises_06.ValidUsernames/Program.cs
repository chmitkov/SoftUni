using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace Regular_Expressions_Exercises_06.ValidUsernames
{
    class Program
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine();

            string pattern = @"\b[A-Za-z]\w{2,24}\b";

            List<string> result = new List<string>();

            MatchCollection matches = Regex.Matches(text, pattern);
            var bestSum = int.MinValue;
            var bestIndex = 0;
            for (int i = 0; i < matches.Count-1; i++)
            {
                var currSum = matches[i].Value.Length + matches[i + 1].Value.Length;

                if (currSum > bestSum)
                {
                    bestSum = currSum;
                    bestIndex = i;
                }
            }
            Console.WriteLine(matches[bestIndex].Value);
            Console.WriteLine(matches[bestIndex+1].Value);
        }
    }
}
