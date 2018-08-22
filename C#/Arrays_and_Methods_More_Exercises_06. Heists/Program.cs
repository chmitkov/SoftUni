using System;
using System.Linq;

namespace Arrays_and_Methods_More_Exercises_06._Heists
{
    class Program
    {
        static void Main(string[] args)
        {
            long[] priceArray = Console.ReadLine()
                 .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                 .Select(long.Parse)
                 .ToArray();
            var jewelPrice = priceArray[0];
            var goldPrice = priceArray[1];

            string input = Console.ReadLine();

            long totalEarnings = 0;
            long totalExpenses = 0;

            while (input != "Jail Time")
            {
                string[] lootArray = input
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                var loot = lootArray[0];
                var heistExpenses = long.Parse(lootArray[1]);
                var jewels = 0;
                var gold = 0;
                for (int i = 0; i < loot.Length; i++)
                {
                    if (loot[i] == '%')
                    {
                        jewels++;
                    }
                    else if (loot[i] == '$')
                    {
                        gold++;
                    }
                }
                totalEarnings += (jewels * jewelPrice + gold * goldPrice);
                totalExpenses += heistExpenses;

                input = Console.ReadLine();
            }
            if (totalEarnings >= totalExpenses)
            {
                Console.WriteLine($"Heists will continue. Total earnings: {totalEarnings - totalExpenses}.");
            }
            else
            {
                Console.WriteLine($"Have to find another job. Lost: {totalExpenses - totalEarnings}.");
            }
        }
    }
}
