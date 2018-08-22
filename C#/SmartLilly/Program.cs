using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SmartLilly
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var wahsPrice = double.Parse(Console.ReadLine());
            var toyPrice = int.Parse(Console.ReadLine());
            var money = 0.0;
            var toys = 0;
            for (int i = 1; i <= n; i++)
            {
                if (i % 2 == 0)
                {
                    money += (i / 2 * 10);
                    money--;
                }
                else
                {
                    toys++;
                }
            }
            money += toys * toyPrice;
            var diff = Math.Abs(money - wahsPrice);
            if (money >= wahsPrice)
            {
                Console.WriteLine("Yes! {0:F2}", diff);
            }
            else
            {
                Console.WriteLine("No! {0:F2}", diff);
            }
        }
    }
}
