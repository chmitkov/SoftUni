using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SleepyTomCat
{
    class Program
    {
        static void Main(string[] args)
        {
            var holydays = int.Parse(Console.ReadLine());
            var workDays = 365 - holydays;
            var playTime = holydays * 127 + workDays * 63;
            var time = Math.Abs(playTime - 30000);
            var h = time / 60;
            var m = time % 60;
            if (playTime > 30000)
            {
                Console.WriteLine("Tom will run away\n{0} hours and {1} minutes more for play", h, m);
            }
            else
            {
                Console.WriteLine("Tom sleeps well\n{0} hours and {1} minutes less for play", h, m);
            }
        }
    }
}
