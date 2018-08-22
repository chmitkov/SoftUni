using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Firm
{
    class Program
    {
        static void Main(string[] args)
        {
            var neededHours = int.Parse(Console.ReadLine());
            var days = int.Parse(Console.ReadLine());
            var workers = int.Parse(Console.ReadLine());

            var workHours = Math.Floor(workers * ((days - days * 0.1) * 10));
            if (workHours >= neededHours)
            {
                Console.WriteLine("Yes!{0} hours left.", workHours - neededHours);
            }
            else
            {
                Console.WriteLine("Not enough time!{0} hours needed.", neededHours-workHours);
            }

        }
    }
}
