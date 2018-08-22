using System;
using System.Linq;

namespace Lists_Lab_07._Count_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            int[] result = new int[1001];
            for (int i = 0; i < array.Length; i++)
            {
                result[array[i]]++;
            }
            for (int i = 0; i < result.Length; i++)
            {
                if (result[i] != 0)
                {
                    Console.WriteLine($"{i} -> {result[i]}");
                }
            }

        }
    }
}
