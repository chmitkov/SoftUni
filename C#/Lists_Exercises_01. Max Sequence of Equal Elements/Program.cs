using System;
using System.Collections.Generic;
using System.Linq;

namespace Lists_Exercises_01._Max_Sequence_of_Equal_Elements
{
    class Program
    {
        static void Main(string[] args)
        {
            long[] array = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(long.Parse)
                .ToArray();
            var counter = 0;
            var bestCounter = 0;
            var bestIndex = 0;
            for (int i = 0; i < array.Length-1; i++)
            {
                if (array[i] == array[i + 1])
                {
                    counter++;
                }
                else
                {
                    counter = 0;
                }
                if (counter > bestCounter)
                {
                    bestCounter = counter;
                    bestIndex = i;
                }
            }
            if (counter == 0)
            {
                Console.WriteLine(array[0]);
            }
            else
            {
                for (int i = bestIndex - bestCounter + 1; i <= bestIndex + 1; i++)
                {
                    Console.Write(array[i] + " ");
                }
            }
        }
    }
}
