using System;
using System.Numerics;

namespace Exam_Preparation_II_01._Charity_Marathon
{
    class Program
    {
        static void Main(string[] args)
        {


            long maratonDays = long.Parse(Console.ReadLine());
            long numOfRunners = long.Parse(Console.ReadLine());
            long averageNumOfLapsPerRunner = long.Parse(Console.ReadLine());
            long lengthOfTrack = long.Parse(Console.ReadLine());
            long capacityOfTrack = long.Parse(Console.ReadLine());
            double moneyDonatedPerKm = double.Parse(Console.ReadLine());
            if (numOfRunners > capacityOfTrack * maratonDays)
            {
                numOfRunners = capacityOfTrack * maratonDays;
            }
            var total = ((numOfRunners * averageNumOfLapsPerRunner * lengthOfTrack) / 1000.0) * moneyDonatedPerKm;
            Console.WriteLine($"Money raised: {total:F2}");
        }
    }
}


