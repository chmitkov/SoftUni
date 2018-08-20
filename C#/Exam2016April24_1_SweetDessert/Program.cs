using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam2016April24_1_SweetDessert
{
    class Program
    {
        static void Main(string[] args)
        {
            double money = double.Parse(Console.ReadLine());
            long guests = long.Parse(Console.ReadLine());
            double bananaPricePerOne = double.Parse(Console.ReadLine());
            double eggPricePerOne = double.Parse(Console.ReadLine());
            double berryPriceForKg = double.Parse(Console.ReadLine());

            var sets = Math.Ceiling(guests / 6.0);
            var neededBananas = sets * 2;
            var neededEggs = sets * 4;
            var neededBerries = sets * 0.2;
            var neededMoney = neededBananas * bananaPricePerOne + neededEggs * eggPricePerOne + neededBerries * berryPriceForKg;
            if (money >= neededMoney)
            {
                Console.WriteLine($"Ivancho has enough money - it would cost {neededMoney:F2}lv.");
            }
            else
            {
                Console.WriteLine($"Ivancho will have to withdraw money - he will need {neededMoney * 1.0 - money:F2}lv more.");
            }


        }
    }
}
