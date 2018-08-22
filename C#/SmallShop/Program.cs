using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SmallShop
{
    class Program
    {
        static void Main(string[] args)
        {
            var type = Console.ReadLine().ToLower();
            var town = Console.ReadLine().ToLower();
            var count = int.Parse(Console.ReadLine());
            var total = 0.0;

            switch (type)
            {
                case "coffee":
                    if ("sofia" == town)
                    {
                        total = count * 0.5;
                    }
                    else if ("plovdiv" == town)
                    {
                        total = count * 0.4;
                    }
                    else
                    {
                        total = count * 0.45;
                    }
                    break;
                case "water":
                    if ("sofia" == town)
                    {
                        total = count * 0.8;
                    }
                    else if ("plovdiv" == town)
                    {
                        total = count * 0.7;
                    }
                    else
                    {
                        total = count * 0.7;
                    }
                    break;
                case "beer":
                    if ("sofia" == town)
                    {
                        total = count * 1.2;
                    }
                    else if ("plovdiv" == town)
                    {
                        total = count * 1.15;
                    }
                    else
                    {
                        total = count * 1.10;
                    }
                    break;
                case "sweets":
                    if ("sofia" == town)
                    {
                        total = count * 1.45;
                    }
                    else if ("plovdiv" == town)
                    {
                        total = count * 1.3;
                    }
                    else
                    {
                        total = count * 1.35;
                    }
                    break;
                case "peanuts":
                    if ("sofia" == town)
                    {
                        total = count * 1.6;
                    }
                    else if ("plovdiv" == town)
                    {
                        total = count * 1.5;
                    }
                    else
                    {
                        total = count * 1.55;
                    }
                    break;
            }
            Console.WriteLine(total);
        }
    }
}
