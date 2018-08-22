using System;
using System.Linq;
using System.Text;

namespace Arrays_and_Methods_More_Exercises_09._Jump_Around
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine()
                 .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                 .Select(int.Parse)
                 .ToArray();

            int result = 0;
            var nextIndex = 0;
            while (nextIndex >= 0 && nextIndex < array.Length)
            {
                result += array[nextIndex];
                if (nextIndex + array[nextIndex] < array.Length)
                {
                    nextIndex = nextIndex + array[nextIndex];
                }
                else if (nextIndex - array[nextIndex]>=0)
                {
                    nextIndex = nextIndex - array[nextIndex];
                }
                else
                {
                    Console.WriteLine(result);
                    return;
                }
            }
        }
    }
}
