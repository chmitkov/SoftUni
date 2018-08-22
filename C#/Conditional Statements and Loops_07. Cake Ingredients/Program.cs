using System;

namespace Conditional_Statements_and_Loops_07._Cake_Ingredients
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            var total = 0;
            for (int i = 0; i < n; i++)
            {
                string input = Console.ReadLine().ToLower();
                switch (input)
                {
                    case "cheese":
                        total += 500;
                        break;
                    case "tomato sauce":
                        total += 150;
                        break;
                    case "salami":
                        total += 600;
                        break;
                    case "pepper":
                        total += 50;
                        break;
                }
            }
            Console.WriteLine($"Total calories: {total}");
        }
    }
}
