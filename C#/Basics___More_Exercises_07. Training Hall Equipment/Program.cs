using System;

namespace Basics___More_Exercises_07._Training_Hall_Equipment
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal budget = decimal.Parse(Console.ReadLine());
            decimal subtotal = 0;
            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                var itemName = Console.ReadLine();
                decimal itemPrice = decimal.Parse(Console.ReadLine());
                var itemCount = int.Parse(Console.ReadLine());
                if (itemCount > 1)
                {
                    Console.WriteLine($"Adding {itemCount} {itemName}s to cart.");
                }
                else
                {
                    Console.WriteLine($"Adding {itemCount} {itemName} to cart.");
                }
                decimal currPrice = itemPrice * itemCount;
                subtotal += currPrice;
            }
            Console.WriteLine($"Subtotal: ${subtotal:F2}");
            if (budget >= subtotal)
            {
                Console.WriteLine($"Money left: ${(budget - subtotal):F2}");
            }
            else
            {
                Console.WriteLine($"Not enough. We need ${(subtotal-budget):F2} more.");
            }
        }
    }
}
