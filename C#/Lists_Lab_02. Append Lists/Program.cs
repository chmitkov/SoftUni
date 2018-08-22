using System;
using System.Collections.Generic;
using System.Linq;

namespace Lists_Lab_02._Append_Lists
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] array = Console.ReadLine()
                .Split(new char[] { '|' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            List<string> result = new List<string>();

            for (int i = array.Length - 1; i >= 0; i--)
            {
                var current = array[i]
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                result.AddRange(current);
            }
            Console.WriteLine(string.Join(" ",result));

        }
    }
}
