using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam_Hornet_01HornetWings
{
    class Program
    {
        static void Main(string[] args)
        {
            int wingFlaps = int.Parse(Console.ReadLine());
            double distanceFor1000flaps = double.Parse(Console.ReadLine());
            int endurance = int.Parse(Console.ReadLine());

            var distance = (wingFlaps * 1.0 / 1000) * distanceFor1000flaps;
            var time = (wingFlaps / endurance) * 5 + (wingFlaps * 1.0 / 100) * 1;
            Console.WriteLine($"{distance:F2} m.");
            Console.WriteLine($"{time} s.");
        }
    }
}
