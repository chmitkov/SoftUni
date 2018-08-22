using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FruitShop
{
    class Program
    {
        static void Main(string[] args)
        {
            var fruit = Console.ReadLine();
            var day = Console.ReadLine().ToLower();
            var count = double.Parse(Console.ReadLine());
            var total = 0.0;

            Boolean weekend = (day == "saturday" || day == "sunday");
            switch (fruit)
            {
                case "banana":
                    if (!weekend)
                    {
                        total = count * 2.5;
                    }
                    else
                    {
                        total = count * 2.7;
                    }
                    break;
                case "apple":
                    if (!weekend)
                    {
                        total = count * 1.2;
                    }
                    else
                    {
                        total = count * 1.25;
                    }
                    break;
                case "orange":
                    if (!weekend)
                    {
                        total = count * 0.85;
                    }
                    else
                    {
                        total = count * 0.9;
                    }
                    break;
                case "grapefruit":
                    if (!weekend)
                    {
                        total = count * 1.45;
                    }
                    else
                    {
                        total = count * 1.6;
                    }
                    break;
                case "kiwi":
                    if (!weekend)
                    {
                        total = count * 2.7;
                    }
                    else
                    {
                        total = count * 3;
                    }
                    break;
                case "pineapple":
                    if (!weekend)
                    {
                        total = count * 5.5;
                    }
                    else
                    {
                        total = count * 5.6;
                    }
                    break;
                case "grapes":
                    if (!weekend)
                    {
                        total = count * 3.85;
                    }
                    else
                    {
                        total = count * 4.2;
                    }
                    break;
                default:

                    Console.WriteLine("error");
                    break;

            }
            Console.WriteLine("{0:F2}",total);

        }
    }
}
