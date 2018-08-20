using System;
using System.Linq;

namespace PF_Exam__Exam_January_2017_03._Endurance_Rally
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] drivers = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
            double[] track = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(double.Parse)
                .ToArray();
            int[] checkpoints = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();

            foreach (var driver in drivers)
            {
                double fuel = (double)driver[0];
                var bestPart = 0;
                for (int i = 0; i < track.Length; i++)
                {
                    if (fuel > 0)
                    {
                        bestPart = i;
                        if (checkpoints.Contains(i))
                        {
                            fuel += track[i];
                        }
                        else
                        {
                            fuel -= track[i];
                        }
                    }
                    else
                    {
                        break;
                    }
                }
                if (fuel > 0)
                {
                    Console.WriteLine($"{driver} - fuel left {fuel:f2}");
                }
                else
                {
                    Console.WriteLine($"{driver} - reached {bestPart}");
                }
            }
        }
    }
}
