using System;
using System.Numerics;

namespace PF_Retake_Exam_05January2018PartI_01._Snowballs
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            BigInteger best = 0;
            int bestSnow = 0;
            int bestTime = 0;
            int bestQuality = 0;
            while (n-->0)
            {
                int snowballSnow = int.Parse(Console.ReadLine());
                int snowballTime = int.Parse(Console.ReadLine());
                int snowballQuality = int.Parse(Console.ReadLine());

                BigInteger currResult = BigInteger.Pow((snowballSnow / snowballTime), snowballQuality);
                if (currResult > best)
                {
                    best = currResult;
                    bestSnow = snowballSnow;
                    bestTime = snowballTime;
                    bestQuality = snowballQuality;
                }
            }
            Console.WriteLine($"{bestSnow} : {bestTime} = {best} ({bestQuality})");
        }
    }
}
