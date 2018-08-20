using System;
using System.Numerics;

namespace Exam_05January2018_Part1_01._Snowballs
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            BigInteger bestSnowballValue = 0;
            var bestSnowballSnow = 0;
            var bestSnowballTime = 0;
            var bestSnowballQuality = 0;
            while (n-- > 0)
            {
                var snowballSnow = int.Parse(Console.ReadLine());
                var snowballTime = int.Parse(Console.ReadLine());
                var snowballQuality = int.Parse(Console.ReadLine());

                BigInteger snowballValue = BigInteger.Pow((BigInteger)(snowballSnow * 1.0 / snowballTime), snowballQuality);
                if (bestSnowballValue < snowballValue)
                {
                    bestSnowballValue = snowballValue;
                    bestSnowballTime = snowballTime;
                    bestSnowballSnow = snowballSnow;
                    bestSnowballQuality = snowballQuality;
                }
            }
            Console.WriteLine($"{bestSnowballSnow} : {bestSnowballTime} = {bestSnowballValue} ({bestSnowballQuality})");
        }
    }
}
