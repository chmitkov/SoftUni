using System;
using System.Linq;

namespace Arrays_Exercises_11._Equal_Sums
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            var leftSum = 0;
            var rightSum = 0;
            var neededIndex = 0;
            var isFound = false;
            if (array.Length == 1)
            {
                Console.WriteLine(0);
                return; 
            }
            for (int i = 0; i < array.Length; i++)
            {
                var startIndex = 0;
                if (i == 0)
                {
                    leftSum = 0;
                    for (int k = i + 1; k < array.Length; k++)
                    {
                        rightSum += array[k];
                    }
                }
                else if (i == array.Length-1)
                {
                    rightSum = 0;
                    for (int j = startIndex; j < i; j++)
                    {
                        leftSum += array[j];
                    }
                }
                else
                {
                    for (int j = startIndex; j < i; j++)
                    {
                        leftSum += array[j];
                    }
                    for (int k = i+1; k < array.Length; k++)
                    {
                        rightSum += array[k];
                    }
                }
                if (leftSum == rightSum)
                {
                    neededIndex = i;
                    isFound = true;
                }
                leftSum = 0;
                rightSum = 0;
            }
            if (isFound)
            {
                Console.WriteLine(neededIndex);
            }
            else
            {
                Console.WriteLine("no");
            }
        }
    }
}
