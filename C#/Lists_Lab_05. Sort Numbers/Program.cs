using System;
using System.Collections.Generic;
using System.Linq;

namespace Lists_Lab_05._Sort_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<decimal> list = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(decimal.Parse)
                .ToList();
            list.Sort();
            Console.WriteLine(string.Join(" <= ",list));

        }
    }
}
