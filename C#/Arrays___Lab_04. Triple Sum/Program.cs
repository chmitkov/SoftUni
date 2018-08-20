using System;
using System.Linq;

namespace Arrays___Lab_04._Triple_Sum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            bool isFound = false;
            for (int i = 0; i < array.Length-1; i++)
            {

                for (int j = i; j < array.Length; j++)
                {
                    if (i != j)
                    {
                        var currSum = array[i] + array[j];
                        if (array.Contains(currSum))
                        {
                            isFound =true;
                            Console.WriteLine($"{array[i]} + {array[j]} == {currSum}");
                        }
                    }
                }
            }
            if (isFound == false)
            {
                Console.WriteLine("No");
            }
        }
    }
}
