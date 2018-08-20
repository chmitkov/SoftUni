using System;

namespace PF_Exam_09July2017Part_1_01._Hornet_Wings
{
    class Program
    {
        static void Main(string[] args)
        {
            int wingFlaps = int.Parse(Console.ReadLine());
            double distancePer1000flaps = double.Parse(Console.ReadLine());
            int endurance = int.Parse(Console.ReadLine());

            var distance = (wingFlaps / 1000.0) * distancePer1000flaps;

            var time = wingFlaps / 100.0 + (wingFlaps / endurance) * 5;

            Console.WriteLine($"{distance:f2} m.");
            Console.WriteLine($"{time} s.");
        }
    }
}
