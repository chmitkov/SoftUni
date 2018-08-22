using System;
using System.Linq;

namespace Arrays_and_Methods_More_Exercises_05._Pizza_Ingredients
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] array = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            int length = int.Parse(Console.ReadLine());
            string result = string.Empty;
            int count = 0;
            for (int i = 0; i < array.Length; i++)
            {
                if (count >= 10)
                {
                    break;
                }
                else
                {
                    if (array[i].Length == length)
                    {
                        Console.WriteLine($"Adding {array[i]}.");
                        result += $"{array[i]} ";
                        count++;
                    }
                }
            }
            string[] totalIngredients = result.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            Console.WriteLine($"Made pizza with total of {count} ingredients.");
            Console.WriteLine($"The ingredients are: {string.Join(", ",totalIngredients)}.");
        }
    }
}
