using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Harvest
{
    class Program
    {
        static void Main(string[] args)
        {
            var vineyard = int.Parse(Console.ReadLine());
            var grapeFromM2 = double.Parse(Console.ReadLine());
            var neededWine = int.Parse(Console.ReadLine());
            var workers = int.Parse(Console.ReadLine());

            var grape = vineyard * 0.4 * grapeFromM2;
            var wine = grape / 2.5;
            if (wine < neededWine)
            {
                Console.WriteLine("It will be a tough winter! More {0} liters wine needed.", Math.Floor(neededWine - wine));
            }
            else
            {
                Console.WriteLine("Good harvest this year! Total wine: {0} liters.", Math.Floor(wine));
                Console.WriteLine("{0} liters left -> {1} liters per person.", Math.Ceiling(wine - neededWine), Math.Ceiling((wine - neededWine) / workers));
            }
        }
    }
}
