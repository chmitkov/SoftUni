using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TradeComissions
{
    class Program
    {
        static void Main(string[] args)
        {
            var town = Console.ReadLine().ToLower();
            var s = double.Parse(Console.ReadLine());
            var total = 0.0;

            switch (town)
            {
                case "sofia":
                    if (s >= 0 && s <= 500)
                    {
                        total = s * 0.05;
                    }
                    else if (s <= 1000)
                    {
                        total = s * 0.07;
                    }
                    else if (s <= 10000)
                    {
                        total = s * 0.08;
                    }
                    else if (s > 10000)
                    {
                        total = s * 0.12;
                    }
                    else
                    {
                        Console.WriteLine("error");
                    }
                    break;
                case "varna":
                    if (s >= 0 && s <= 500)
                    {
                        total = s * 0.045;
                    }
                    else if (s <= 1000)
                    {
                        total = s * 0.075;
                    }
                    else if (s <= 10000)
                    {
                        total = s * 0.1;
                    }
                    else if (s > 10000)
                    {
                        total = s * 0.13;
                    }
                    else
                    {
                        Console.WriteLine("error");
                    }
                    break;
                case "plovdiv":
                    if (s >= 0 && s <= 500)
                    {
                        total = s * 0.055;
                    }
                    else if (s <= 1000)
                    {
                        total = s * 0.08;
                    }
                    else if (s <= 10000)
                    {
                        total = s * 0.12;
                    }
                    else if (s > 10000)
                    {
                        total = s * 0.145;
                    }
                    else
                    {
                        Console.WriteLine("error");
                    }
                    break;
                default:
                    Console.WriteLine("error");
                    break;
            }
            Console.WriteLine("{0:F2}", total);
        }
    }
}
