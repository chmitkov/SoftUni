using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;

namespace P05_SinoTheWalker
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] time = Console.ReadLine().Split(':').Select(int.Parse).ToArray();
            var hours = time[0] * 3600;
            var min = time[1] * 60;
            var sec = time[2];
            var startTime = hours + min + sec;
            BigInteger steps = int.Parse(Console.ReadLine());
            BigInteger secPerSteps = int.Parse(Console.ReadLine());

            BigInteger totalTimeInSec = steps * secPerSteps + startTime;

            BigInteger arriveHour = (totalTimeInSec / 3600) % 24;
            BigInteger arriveMinute = (totalTimeInSec / 60) % 60;
            BigInteger arriveSecond = totalTimeInSec % 60;

            Console.WriteLine($"Time Arrival: {arriveHour:00}:{arriveMinute:00}:{arriveSecond:00}");
        }
    }
}
