using System;
using System.Collections.Generic;
using System.Linq;

namespace Dictionaries_LambdaAndLINQ_Lab_03._Min__Max__Sum__Average
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            List<int> array = new List<int>();
            for (int i = 0; i < n; i++)
            {
                array.Add(int.Parse(Console.ReadLine()));
            }
            

            Console.WriteLine($"Sum = {array.Sum()}");
            Console.WriteLine($"Min = {array.Min()}");
            Console.WriteLine($"Max = {array.Max()}");
            Console.WriteLine($"Average = {(array.Sum()*1.0/array.Count)}");
        }
    }
}
