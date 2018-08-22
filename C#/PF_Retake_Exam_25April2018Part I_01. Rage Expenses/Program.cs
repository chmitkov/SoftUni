using System;

namespace PF_Retake_Exam_25April2018Part_I_01._Rage_Expenses
{
    class Program
    {
        static void Main(string[] args)
        {
            int lostGames = int.Parse(Console.ReadLine());
            decimal headsetPrice = decimal.Parse(Console.ReadLine());
            decimal mousePrice = decimal.Parse(Console.ReadLine());
            decimal keyboardPrice = decimal.Parse(Console.ReadLine());
            decimal displayPrice = decimal.Parse(Console.ReadLine());
            decimal  total = 0;
            var counter = 0;
            for (int i = 1; i <= lostGames; i++)
            {
                if (i % 2 == 0)
                {
                    total += headsetPrice;
                }
                if (i % 3 == 0)
                {
                    total += mousePrice;
                }
                if (i % 2 == 0 && i % 3 == 0)
                {
                    total += keyboardPrice;
                    counter++;
                }
                if (counter == 2)
                {
                    total += displayPrice;
                    counter = 0;
                }
            }
            Console.WriteLine($"Rage expenses: {total:f2} lv.");
        }
    }
}
