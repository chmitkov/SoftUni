using System;
using System.Linq;

namespace Arrays___Exercises_02._Rotate_and_Sum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            int n = int.Parse(Console.ReadLine());
            int[] sumArray = new int[numbers.Length];
            for (int i = 0; i < n; i++)
            {
                ReverseArray(numbers);
                for (int j = 0; j < sumArray.Length; j++)
                {
                    sumArray[j] = sumArray[j] + numbers[j]; 
                }
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

