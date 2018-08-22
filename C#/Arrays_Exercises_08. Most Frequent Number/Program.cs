using System;
using System.Linq;

namespace Arrays_Exercises_08._Most_Frequent_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            var currCount = 1;
            var bestCount = 0;
            var bestNum = array[0];
            for (int i = 0; i < array.Length; i++)
            {
                currCount = 1;
                for (int j = i+1; j < array.Length; j++)
                {
                    if (array[i] == array[j])
                    {
                        currCount++;
                    }
                }
                if (currCount > bestCount)
                {
                    bestCount = currCount;
                    bestNum = array[i];
                }
            }
            Console.WriteLine(bestNum);
        }
    }
}
