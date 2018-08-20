using System;
using System.Linq;

namespace Arrays_Exercises_05._Compare_Char_Arrays
{
    class Program
    {
        static void Main(string[] args)
        {
            char[] arr1 = Console.ReadLine()
                 .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                 .Select(char.Parse)
                 .ToArray();
            char[] arr2 = Console.ReadLine()
                 .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                 .Select(char.Parse)
                 .ToArray();
            bool firstFlag = false;
            for (int i = 0; i < Math.Min(arr1.Length,arr2.Length); i++)
            {
                if (arr1[i] == arr2[i])
                {
                    if (arr1.Length < arr2.Length)
                    {
                        firstFlag = true;
                    }
                }
                else if (arr1[i] < arr2[i])
                {
                    firstFlag = true;
                    break;
                }
                else
                {
                    firstFlag = false;
                    break;
                }
            }
            if (firstFlag == true)
            {
                Console.WriteLine(string.Join("",arr1));
                Console.WriteLine(string.Join("",arr2));
            }
            else
            {
                Console.WriteLine(string.Join("", arr2));
                Console.WriteLine(string.Join("", arr1));
            }

        }
    }
}
