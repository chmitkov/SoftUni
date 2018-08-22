using System;
using System.Linq;

namespace Arrays_and_Methods_More_Exercises_08._Upgraded_Matcher
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
                string[] commands = input
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                var neededName = commands[0];
                var neededQuant = long.Parse(commands[1]);
                var neededIndex = 0;
                for (int i = 0; i < name.Length; i++)
                {
                    if (name[i] == neededName)
                    {
                        neededIndex = i;
                    }
                }
                var price = prices[neededIndex];
                var quant = 0L;
                if (neededIndex < quantities.Length)
                {
                    quant = quantities[neededIndex];
                }

                if (quant-neededQuant >= 0)
                {
                    Console.WriteLine($"{neededName} x {neededQuant} costs {(neededQuant*price):F2}");
                    quantities[neededIndex] -= neededQuant;
                }
                else
                {
                    Console.WriteLine($"We do not have enough {neededName}");
                }


                

                input = Console.ReadLine();
            }
        }
    }
}
