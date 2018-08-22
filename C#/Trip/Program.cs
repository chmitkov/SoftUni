using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Trip
{
    class Program
    {
        static void Main(string[] args)
        {
            var budget = double.Parse(Console.ReadLine());
            var seasons = Console.ReadLine().ToLower();
            var total = 0.0;
            var place = "";
            var type = "";

            if (budget <= 100)
            {
                place = "Bulgaria";
                if ("summer" == seasons)
                {
                    total = budget * 0.3;
                    type = "Camp";
                }
                else
                {
                    total = budget * 0.7;
                    type = "Hotel";
                }
            }
            else if (budget <= 1000)
            {
                place = "Balkans";
                if ("summer" == seasons)
                {
                    total = budget * 0.4;
                    type = "Camp";
                }
                else
                {
                    total = budget * 0.8;
                    type = "Hotel";
                }
            }
            else
            {
                place = "Europe";
                total = budget * 0.9;
                type = "Hotel";
            }
            Console.WriteLine("Somewhere in {0}\n{1} - {2:F2}", place, type, total);
        }
    }
}
