using System;
using System.Linq;

namespace Arrays___Exercises_03._Fold_and_Sum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            int n = numbers.Length / 4;
            int[] array1 = new int[n * 2];
            int[] array2 = new int[n * 2];
            for (int i = 0; i < numbers.Length; i++)
            {
                if (i <= n || i>=n*3)
                {
                    if (i <= n)
                    {
                        array1[i] = numbers[i];
                    }
                    else
                    {
                        array1[i - n * 2] = numbers[i];
                    }
                }
                else
                {
                    array2[i-n] = numbers[i];
                }
            }
            SumTwoSequence(array1, array2);
        }

         static void SumTwoSequence(int[] array1, int[] array2)
        {
            int[] sumArray = new int[array1.Length];
            for (int i = 0; i < sumArray.Length; i++)
            {
                sumArray[i] = array1[i] + array2[i];
            }
            Console.WriteLine(string.Join(" ",sumArray));
        }
        static void ReverseArray(int[] numbers)
        {
            var current = numbers[numbers.Length - 1];
            for (int i = numbers.Length - 1; i > 0; i--)
            {
                numbers[i] = numbers[i - 1];
            }
            numbers[0] = current;
        }
    }
}
