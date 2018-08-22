using System;
using System.Collections.Generic;
using System.Linq;

namespace Lists_Lab_03._Sum_Adjacent_Equal_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<double> list = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(double.Parse)
                .ToList();

            for (int i = 0; i < list.Count-1; i++)
            {
                if (list[i] == list[i + 1])
                {
                    list[i + 1] = list[i] + list[i + 1];
                    list.RemoveAt(i);
                    i = -1;
                }
            }
            Console.WriteLine(string.Join(" ",list));

        }
    }
}
