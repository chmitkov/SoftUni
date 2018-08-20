using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Padawan_Equipment
{
    class Program
    {
        static void Main(string[] args)
        {
            int money = int.Parse(Console.ReadLine());
            int students = int.Parse(Console.ReadLine());
            double lightsabersPrice = double.Parse(Console.ReadLine());
            double robesPrice = double.Parse(Console.ReadLine());
            double beltsPrice = double.Parse(Console.ReadLine());

            var neededLightsabersPrice = lightsabersPrice * (Math.Ceiling(1.1*students));
            var neededBelts = beltsPrice * (students - students/6);
            var neededRobes = students * robesPrice;
            var neededMoney = neededBelts + neededLightsabersPrice + neededRobes;
            if (money >= neededMoney)
            {
                Console.WriteLine($"The money is enough - it will cost {neededMoney:F2}lv.");
            }
            else
            {
                Console.WriteLine($"Ivan Cho will need {neededMoney-money:F2}lv. more");
            }
        }
    }
}
