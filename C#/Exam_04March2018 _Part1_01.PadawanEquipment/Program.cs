using System;

namespace Exam_04March2018__Part1_01.PadawanEquipment
{
    class Program
    {
        static void Main(string[] args)
        {
            double money = double.Parse(Console.ReadLine());
            int students = int.Parse(Console.ReadLine());
            double lightsabersPrice = double.Parse(Console.ReadLine());
            double robesPrice = double.Parse(Console.ReadLine());
            double beltsPrice = double.Parse(Console.ReadLine());
            var moreLights = Math.Ceiling(students * 0.1);
            double neededLightsabers = (double)(students+moreLights);
            var freeBelts = students / 6;
            var neededBelts = students - freeBelts;

            double totalNeededMoney = students * robesPrice + (neededLightsabers * lightsabersPrice)
                + neededBelts * beltsPrice;
            Console.WriteLine(money>=totalNeededMoney?
                $"The money is enough - it would cost {(totalNeededMoney):F2}lv."
                : $"Ivan Cho will need {Math.Abs(money - totalNeededMoney):F2}lv more.");

        }
    }
}
