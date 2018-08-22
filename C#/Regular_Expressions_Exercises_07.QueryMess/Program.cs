using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace Regular_Expressions_Exercises_07.QueryMess
{
    class Program
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine();
            
            while (text != "END")
            {
                string pattern = @"(?<=&|^|\?)(.[^?]*?)=(.*?)(?=&|$|\?)";
                var dict = new Dictionary<string, List<string>>();
                var matches = Regex.Matches(text, pattern);
                foreach (Match item in matches)
                {
                    var field = item.Groups[1].ToString();
                    field = field.Replace("+", " ");
                    field = field.Replace("%20", " ");
                    field = field.Trim();
                    field = InsideTrim(field);
                    var val = item.Groups[2].ToString();
                    val = val.Replace("+", " ");
                    val = val.Replace("%20", " ");
                    val = val.Trim();
                    val = InsideTrim(val);

                    if (!dict.ContainsKey(field))
                    {
                        dict.Add(field, new List<string>());
                        dict[field].Add(val);
                    }
                    else
                    {
                        dict[field].Add(val);
                    }
                   
                }
                foreach (var pair in dict)
                {
                    Console.Write($"{pair.Key}=[{string.Join(", ", pair.Value)}]");
                }
                Console.WriteLine();
                text = Console.ReadLine();
            }
        }

        private static string InsideTrim(string field)
        {
            for (int i = 0; i < field.Length-1; i++)
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
