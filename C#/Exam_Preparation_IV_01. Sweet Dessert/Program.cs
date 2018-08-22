using System;

namespace Exam_Preparation_IV_01._Sweet_Dessert
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal money = decimal.Parse(Console.ReadLine());
            int guestNumber = int.Parse(Console.ReadLine());
            decimal priceOfBanana = decimal.Parse(Console.ReadLine());
            decimal priceOfEggs = decimal.Parse(Console.ReadLine());
            decimal priceForKgBerries = decimal.Parse(Console.ReadLine());

            decimal sets = (decimal)Math.Ceiling(guestNumber / 6.0);

            decimal neededMoney = sets * (2 * priceOfBanana + 4 * priceOfEggs + 0.2M 
                * priceForKgBerries);

            Console.WriteLine(money>=neededMoney
                ?$"Ivancho has enough money - it would cost {neededMoney:f2}lv."
                :$"Ivancho will have to withdraw money - he will need {(neededMoney-money):f2}lv more."
                );
        }
    }
}
