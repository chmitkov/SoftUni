using System;

namespace PF_Exam_Preparation_IV_01._Sweet_Dessert
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal money = decimal.Parse(Console.ReadLine());
            int guests = int.Parse(Console.ReadLine());
            double priceOfBanana = double.Parse(Console.ReadLine());
            double priceOfEggs = double.Parse(Console.ReadLine());
            double priceOfBerriesForKilo = double.Parse(Console.ReadLine());

            var sets = Math.Ceiling(guests / 6.0);
            decimal neededMoney = (decimal)(sets * (priceOfBanana * 2 + priceOfEggs * 4 + 0.2 * priceOfBerriesForKilo));
            if (money >= neededMoney)
            {
                Console.WriteLine($"Ivancho has enough money - it would cost {neededMoney:F2}lv.");
            }
            else
            {
                Console.WriteLine($"Ivancho will have to withdraw money - he will need {(neededMoney-money):F2}lv more.");
            }
        }
    }
}
