using System;
using System.Collections.Generic;

namespace DictionariesandLists_MoreExercises_04._Supermarket_Database
{
    class Program
    {
        static void Main(string[] args)
        {
            var dictPrice = new Dictionary<string, decimal>();
            var dictQuantity = new Dictionary<string, decimal>();

            string input = Console.ReadLine();

            while (input != "stocked")
            {
                string[] commands = input
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
                var name = commands[0];
                var price = decimal.Parse(commands[1]);
                var quantity = decimal.Parse(commands[2]);

                if (!dictPrice.ContainsKey(name))
                {
                    dictPrice.Add(name, price);
                }
                else
                {
                    dictPrice[name] = price;
                }
                if (!dictQuantity.ContainsKey(name))
                {
                    dictQuantity.Add(name, quantity);
                }
                else
                {
                    dictQuantity[name] += quantity;
                }
                input = Console.ReadLine();
            }
            var total = 0m;
            foreach (var pair in dictPrice)
            {
                var currSum = pair.Value * dictQuantity[pair.Key];
                Console.WriteLine($"{pair.Key}: ${pair.Value:F2} * {dictQuantity[pair.Key]} = ${currSum:F2}");
                total += currSum;
            }
            Console.WriteLine(new string('-',30));
            Console.WriteLine($"Grand Total: ${total:F2}");
        }
    }
}
