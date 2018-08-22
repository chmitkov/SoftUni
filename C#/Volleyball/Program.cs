using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Volleyball
{
    class Program
    {
        static void Main(string[] args)
        {
            var year = Console.ReadLine().ToLower() ;
            double p = double.Parse(Console.ReadLine());
            double h = double.Parse(Console.ReadLine());

            double totalPlays = h;
            double normalWeekends = 48 - h;
            totalPlays = totalPlays + (normalWeekends * 0.75);
            totalPlays = totalPlays + (p * 2 / 3);
            if (year == "leap")
            {
                totalPlays = totalPlays + (totalPlays * 0.15);
            }
            Console.WriteLine((int)totalPlays);
        }
    }
}
