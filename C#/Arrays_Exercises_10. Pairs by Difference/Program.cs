using System;
using System.Linq;

namespace Arrays_Exercises_10._Pairs_by_Difference
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            int num = int.Parse(Console.ReadLine());
            var count = 0;
            for (int i = 0; i < array.Length-1; i++)
            {
                for (int j = i+1; j < array.Length; j++)
                {
                    var diff = Math.Abs(array[i] - array[j]);
                    if (diff == num)
                    {
                        count++;
                    }
                }
            }
            Console.WriteLine(count);
        }
    }
}
