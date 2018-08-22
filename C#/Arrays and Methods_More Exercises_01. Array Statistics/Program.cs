using System;
using System.Linq;

namespace Arrays_and_Methods_More_Exercises_01._Array_Statistics
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            var sum = 0;
            var max = int.MinValue;
            var min = int.MaxValue;

            for (int i = 0; i < array.Length; i++)
            {
                sum += array[i];
                if (array[i] > max)
                {
                    max = array[i];
                }
                if (array[i] < min)
                {
                    min = array[i];
                }
            }
            Console.WriteLine($"Min = {min}");
            Console.WriteLine($"Max = {max}");
            Console.WriteLine($"Sum = {sum}");
            Console.WriteLine($"Average = {sum*1.0/array}");
        }
    }
}
