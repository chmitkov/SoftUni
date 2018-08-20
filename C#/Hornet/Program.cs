using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hornet
{
    class Program
    {
        static void Main(string[] args)
        {
            int wingFlaps = int.Parse(Console.ReadLine());
            double distansFor1000 = double.Parse(Console.ReadLine());
            int endurance = int.Parse(Console.ReadLine());

            double distance = (wingFlaps / 1000)*distansFor1000;
            int time = ((wingFlaps / endurance) * 5) + (wingFlaps / 100);
            Console.WriteLine($"{distance:f2}m.\n{time}s.");
        }
    }
}
 