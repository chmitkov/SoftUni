using System;
using System.Numerics;

namespace Exam_1
{
    class Program
    {
        static void Main(string[] args)
        {
            long wingFlaps = long.Parse(Console.ReadLine());
            long metersPer1000wingFlaps = long.Parse(Console.ReadLine());
            long endurance = long.Parse(Console.ReadLine());

            long distance = (wingFlaps / 1000) * metersPer1000wingFlaps;
            long time = (wingFlaps / 100.) + (wingFlaps/ endurance*1.0 * 5);
            Console.WriteLine($"{distance:F2} m.");
            Console.WriteLine($"{time:F0} s.");

        }
    }
}
