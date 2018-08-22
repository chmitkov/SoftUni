using System;

namespace PF_Exam_04March2018PartI_01._Padawan_Equipment
{
    class Program
    {
        static void Main(string[] args)
        {
            double money = double.Parse(Console.ReadLine());
            int students = int.Parse(Console.ReadLine());
            double priceOfLightsabers = double.Parse(Console.ReadLine());
            double priceOfRobes = double.Parse(Console.ReadLine());
            double priceOfBelts = double.Parse(Console.ReadLine());

            var neededLightPrice = Math.Ceiling(students * 1.1)*priceOfLightsabers;
            var neededBeltsPrice = (students - students/6)*priceOfBelts;
            var totalNeeded = students * priceOfRobes + neededBeltsPrice + neededLightPrice;

            Console.WriteLine(money>=totalNeeded
                ?$"The money is enough - it would cost {totalNeeded:f2}lv."
                :$"Ivan Cho will need {(totalNeeded-money):f2}lv more."
                );
        }
    }
}
