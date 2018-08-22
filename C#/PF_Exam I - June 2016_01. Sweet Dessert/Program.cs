using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam_Preparation4_01SweetDessert
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal avalebleMoney = decimal.Parse(Console.ReadLine());
            int guestsNumber = int.Parse(Console.ReadLine());
            decimal bananaPricePerUnit = decimal.Parse(Console.ReadLine());
            decimal eggsPricePerUnit = decimal.Parse(Console.ReadLine());
            decimal berriesPricePerKg = decimal.Parse(Console.ReadLine());

            int portions = (int)Math.Ceiling(guestsNumber / 6.0);


            decimal pricePerPortion = (bananaPricePerUnit * 2M) + (eggsPricePerUnit * 4M) + (berriesPricePerKg * 0.2M);
            decimal neededMoney = (decimal)portions * pricePerPortion;

            Console.WriteLine(neededMoney <= avalebleMoney ? $"Ivancho has enough money - it would cost {neededMoney:F2}lv."
                : $"Ivancho will have to withdraw money - he will need {neededMoney - avalebleMoney:F2}lv more.");
        }
    }
}
