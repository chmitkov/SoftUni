using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace Regular_Expressions_Exercises_08.UseYourChains_Buddy
{
    class Program
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine();

            string pattern = @"<p>(.*?)<\/p>";
            List<string> result = new List<string>();
            string endStr = string.Empty;
            var matches = Regex.Matches(text, pattern);
            foreach (Match item in matches)
            {
                result.Add(item.Groups[1].Value);
            }
            for (int i = 0; i < result.Count; i++)
            {
                result[i] = Regex.Replace(result[i], @"[^a-z0-9]", " ");
                result[i] = DecodeWord(result[i]);
                result[i] = result[i].Trim();
                result[i] = InsideTrim(result[i]);
                endStr += result[i] + " ";
            }
            Console.WriteLine(endStr);
        }

        private static string DecodeWord(string v)
        {
            string str = string.Empty;
            for (int i = 0; i < v.Length; i++)
            {
                if (v[i] > 96 && v[i] < 110)
                {
                    str += (char)(v[i] + 13);
                }
                else if (v[i] > 109 && v[i] < 123)
                {
                    str += (char)(v[i] - 13);
                }
                else if (v[i] > 47 && v[i] < 58)
                {
                    str += v[i];
                }
                else if (v[i] == 32)
                {
                    str += v[i];
                }
            }
            return str;
        }
        private static string InsideTrim(string field)
        {
            for (int i = 0; i < field.Length - 1; i++)
            {
                if (field[i] == ' ' && field[i + 1] == ' ')
                {
                    field = field.Remove(i, 1);
                    i--;
                }
            }
            return field;
        }
    }
}
