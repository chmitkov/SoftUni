using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace P01_HornetWings
{
    class Program
    {
        static void Main(string[] args)
        {
            int wingFlaps = int.Parse(Console.ReadLine());
            double distanseFor1000flaps = double.Parse(Console.ReadLine());
            int wingFlapsBeforeRest = int.Parse(Console.ReadLine());

            var distanse = (wingFlaps / 1000) * distanseFor1000flaps;
            var time = (wingFlaps / 100) + (wingFlaps / wingFlapsBeforeRest) * 5;

            Console.WriteLine($"{distanse:F2} m.\n{time} s.");
        }
    }
}
