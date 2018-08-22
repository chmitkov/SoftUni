using System;
using System.Collections.Generic;
using System.Linq;

namespace Lists_Exercises_04LIS
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> list = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToList();

            List<int> result = new List<int>();
            for (int i = 1; i < list.Count; i++)
            {
                
                
            }
            Console.WriteLine(string.Join(" ",result));
        }
    }
}
