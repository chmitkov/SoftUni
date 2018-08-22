using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MatchTickets
{
    class Program
    {
        static void Main(string[] args)
        {
            double budget = double.Parse(Console.ReadLine());
            string type = Console.ReadLine().ToLower();
            int num = int.Parse(Console.ReadLine());
            double transport = 0;
            double price = 0;

            if (num <= 4)
            {
                transport = budget * 0.75;
            }
            else if (num <= 9)
            {
                transport = budget * 0.6;
            }
            else if (num <= 24)
            {
                transport = budget * 0.5;
            }
            else if (num <= 49)
            {
                transport = budget * 0.4;
            }
            else 
            {
                transport = budget * 0.25;
            }
            budget -= transport;
            if (type == "vip")
            {
                price = 499.99;
            }
            else
            {
                price = 249.99;
            }
            if (price * num < budget)
            {
                Console.WriteLine("Yes! You have {0:F2} leva left.", budget - (price * num));
            }
            else
            {
                Console.WriteLine("Not enough money! You need {0:F2} leva.", (price * num)-budget);
            }
        }
    }
}
