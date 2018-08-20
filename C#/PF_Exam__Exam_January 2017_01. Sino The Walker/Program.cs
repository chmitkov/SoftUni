using System;
using System.Globalization;
using System.Linq;
using System.Numerics;

namespace PF_Exam__Exam_January_2017_01._Sino_The_Walker
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] time = Console.ReadLine()
                .Split(new char[] { ':' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            BigInteger startTimeInSeconds = time[2] + time[1] * 60 + (60 * (time[0] * 60));
            BigInteger steps = BigInteger.Parse(Console.ReadLine()) % 86400;
            BigInteger timeForOneStep = BigInteger.Parse(Console.ReadLine()) % 86400;

            BigInteger travelTime = steps * timeForOneStep;
            BigInteger totalTime = travelTime + startTimeInSeconds;
            var h = totalTime / 3600;
            if (h >= 24)
            {
                h -= 24;
            }
            var min = (totalTime % 3600) / 60;
            var sec = (totalTime % 3600) % 60;

            Console.WriteLine($"Time Arrival: {h:D2}:{min:D2}:{sec:D2}");
        }
    }
}
