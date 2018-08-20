using System;

namespace PF_Retake_Exam___25_April_2018_Part_I_01._Rage_Expenses
{
    class Program
    {
        static void Main(string[] args)
        {
            int lostGame = int.Parse(Console.ReadLine());
            double headset = double.Parse(Console.ReadLine());
            double mouse = double.Parse(Console.ReadLine());
            double keyboard = double.Parse(Console.ReadLine());
            double display = double.Parse(Console.ReadLine());
            double total = 0;
            var count = 1;

            for (int i = 1; i <= lostGame; i++)
            {
                if (i % 2 == 0)
                {
                    total += headset;
                }
                if (i % 3 == 0)
                {
                    total += mouse;
                }
                if (i % 2 == 0 && i % 3 == 0)
                {
                    total += keyboard;
                    if (count % 2 == 0)
                    {
                        total += display;
                    }
                    count++;
                }
            }
            Console.WriteLine($"Rage expenses: {total:f2} lv.");
        }
    }
}
