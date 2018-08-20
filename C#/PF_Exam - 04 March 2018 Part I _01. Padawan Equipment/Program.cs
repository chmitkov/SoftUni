using System;

namespace PF_Exam___04_March_2018_Part_I__01._Padawan_Equipment
{
    class Program
    {
        static void Main(string[] args)
        {
            long money = long.Parse(Console.ReadLine());
            int students = int.Parse(Console.ReadLine());
            double priceOfLightsabers = double.Parse(Console.ReadLine());
            double priceOfRobes = double.Parse(Console.ReadLine());
            double priceOfBelts = double.Parse(Console.ReadLine());

            double neededMoney = priceOfLightsabers * Math.Ceiling(students * 1.1)
                + (priceOfRobes * students) + (students - students / 6) * priceOfBelts;
            if (money > neededMoney)
            {
                Console.WriteLine($"The money is enough - it would cost {neededMoney:F2}lv.");
            }
            else
            {
                Console.WriteLine($"Ivan Cho will need {neededMoney - money:F2}lv more.");
            }
        }
    }
}
