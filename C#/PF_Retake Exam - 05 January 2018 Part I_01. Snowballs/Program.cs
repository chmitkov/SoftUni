using System;

namespace PF_Retake_Exam___05_January_2018_Part_I_01._Snowballs
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            decimal best = 0;
            decimal bestSnow = 0;
            decimal bestTime = 0;
            decimal bestQuality = 0;
            for (int i = 0; i < n; i++)
            {
                var snowballSnow = int.Parse(Console.ReadLine());
                var snowballTime = int.Parse(Console.ReadLine());
                var snowballQuality = int.Parse(Console.ReadLine());
                decimal snowballValue = (decimal)Math.Pow(snowballSnow* 1.0/ snowballTime, snowballQuality);
                if (snowballValue > best)
                {
                    best = snowballValue;
                    bestSnow = snowballSnow;
                    bestTime = snowballTime;
                    bestQuality = snowballQuality;
                }
            }
            Console.WriteLine($"{bestSnow} : {bestTime} = {best} ({bestQuality})");
        }
    }
}
