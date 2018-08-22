using System;
using System.Collections.Generic;
using System.Linq;

namespace Dictionaries_LambdaAndLINQ_Lab_01._Count_Real_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            double[] array = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(double.Parse)
                .ToArray();
            var dict = new SortedDictionary<double, int>();
            for (int i = 0; i < array.Length; i++)
            {
                if (array[i].ToString().Contains("."))
                {
                    if (!dict.ContainsKey(array[i]))
                    {
                        dict[array[i]] = 0;
                    }
                    dict[array[i]]++;
                }
                else
                {
                    if (!dict.ContainsKey(array[i]))
                    {
                        dict[array[i]] = 0;
                    }
                    dict[array[i]]++;
                }
            }
            foreach (var pair in dict.OrderBy(x=>x.Key))
            {
                Console.WriteLine($"{pair.Key} -> {pair.Value}");
            }
        }
    }
}
