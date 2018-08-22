using System;
using System.Collections.Generic;
using System.Linq;

namespace Dictionaries_LambdaAndLINQ_Lab_02._Odd_Occurrences
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().ToLower()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
            var dict = new Dictionary<string, int>();
            List<string> result = new List<string>();
            for (int i = 0; i < input.Length; i++)
            {
                if (!dict.ContainsKey(input[i]))
                {
                    dict[input[i]] = 0;
                }
                dict[input[i]]++;
            }
            foreach (var pair in dict)
            {
                if (pair.Value % 2 != 0)
                {
                    result.Add(pair.Key);
                }
            }
            Console.WriteLine(string.Join(", ",result));

        }
    }
}
