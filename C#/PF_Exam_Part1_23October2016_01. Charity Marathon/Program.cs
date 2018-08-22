using System;

namespace PF_Exam_Part1_23October2016_01._Charity_Marathon
{
    class Program
    {
        static void Main(string[] args)
        {
            var daysOfMarathon = int.Parse(Console.ReadLine());
            long numberOfrunners = long.Parse(Console.ReadLine());
            int averageNumbersOfLaps = int.Parse(Console.ReadLine());
            long lapLength = long.Parse(Console.ReadLine());
            int trackCapacity = int.Parse(Console.ReadLine());
            decimal moneyPerKm = decimal.Parse(Console.ReadLine());

            if (daysOfMarathon * trackCapacity < numberOfrunners)
            {
                numberOfrunners = daysOfMarathon * trackCapacity;
            }
            var totalKm = (lapLength * averageNumbersOfLaps) * numberOfrunners;
            decimal totalMoney = totalKm * moneyPerKm;

            Console.WriteLine($"Money raised: {(totalMoney/1000):F2}");

        }
    }
}
