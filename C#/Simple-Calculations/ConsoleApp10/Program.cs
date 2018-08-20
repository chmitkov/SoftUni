using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace ConsoleApp10
{
    class Program
    {
        private static string pattern = @"TO:\s([A-Z]+?);\sMESSAGE:\s(.*?);";
        static void Main(string[] args)
        {
            string key = Console.ReadLine().Trim();
            var dict = new Dictionary<int, Dictionary<string, string>>();
            string input = Console.ReadLine().Trim();
            var dictMessage = new Dictionary<string, string>();
            List<string> resultList= new List<string>();
            int index = 1;
            while (input.Trim().ToUpper() != "END")
            {                
                if (Regex.IsMatch(input, pattern))
                {
                    var match = Regex.Match(input, pattern);
                    var resiver = match.Groups[1].Value.Trim();
                    var message = match.Groups[2].Value.Trim();
                    resultList.Add(Decode(match.Value,key));
                    resultList.Sort();
                    var addedDict = new Dictionary<string, string>();
                    addedDict.Add(resiver, message);
                    dict.Add(resiver[0], addedDict);

                    
                }
                input = Console.ReadLine().Trim();
                index += 1;
            }

            //foreach (var pair in dict.OrderBy(x=>x.Key))
            //{
            //    foreach (var pair1 in pair.Value)
            //    {
            //        string current = $"TO: {pair.Key}; MESSAGE: {pair1.Value};";
            //        Console.WriteLine(Decode(current,key));
            //    }
            //}
            foreach (var pair in dict.orderby(x => x.key))
            {
                string current = $"to: {pair.key}; message: {pair.value};";
                console.writeline($"{decode(current, key)}");
            }
        }

        private static bool IsGreater(string lineA, string lineB)
        {
            return true;
        }

        private static string Decode(string value,string key)
        {
            string result = string.Empty;
            for (int i = 0; i < value.Length; i++)
            {
                result += (char)((int)value[i] + (int.Parse(key[i % key.Length].ToString())));
            }
            return result;
        }
    }
}
