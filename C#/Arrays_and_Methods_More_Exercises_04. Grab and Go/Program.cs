using System;
using System.Linq;

namespace Arrays_and_Methods_More_Exercises_04._Grab_and_Go
{
    class Program
    {
        static void Main(string[] args)
        {
            long[] array = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(long.Parse)
                .ToArray();

            long num = long.Parse(Console.ReadLine());
            var index = 0L;
            var sum = 0L;
            bool flag = false;
            for (long i = 0; i < array.Length; i++)
            {
                if (array[i] == num)
                {
                    index = i;
                    flag = true;
                }
            }
            for (long i = 0; i < index; i++)
            {
                sum += array[i];
            }
            if (flag)
            {
                Console.WriteLine(sum);
            }
            else
            {
                Console.WriteLine("No occurrences were found!");
            }
            
        }
    }
}
