using System;
using System.Linq;

namespace Arrays_and_Methods_More_Exercises_07._Inventory_Matcher
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] name = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            long[] quantities = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(long.Parse)
                .ToArray();
            decimal[] prices = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(decimal.Parse)
                .ToArray();

            string input = Console.ReadLine();

            while (input != "done")
            {
                var neededIndex = 0;
                for (int i = 0; i < name.Length; i++)
                {
                    if (name[i] == input)
                    {
                        neededIndex = i;
                    }
                }

                Console.WriteLine($"{name[neededIndex]} costs: {prices[neededIndex]};" +
                    $" Available quantity: {quantities[neededIndex]}");

                input = Console.ReadLine();
            }
        }
    }
}
