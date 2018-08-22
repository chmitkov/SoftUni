using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam_II___June_2016_01._SoftUni_Airline
{
    class Program
    {
        static void Main(string[] args)
        {
            int numberOfFlights = int.Parse(Console.ReadLine());
            var totalEarnedMoney = new List<decimal>();
            while (numberOfFlights-- > 0)
            {
                int adultPassCount = int.Parse(Console.ReadLine());
                decimal adultTicketPrice = decimal.Parse(Console.ReadLine());
                int youthPassCount = int.Parse(Console.ReadLine());
                decimal youthTicketPrice = decimal.Parse(Console.ReadLine());
                decimal fuelPricePerHour = decimal.Parse(Console.ReadLine());
                decimal fuelConsumptnionPerHour = decimal.Parse(Console.ReadLine());
                int flightDuration = int.Parse(Console.ReadLine());

                var fuelPrice = (flightDuration * fuelConsumptnionPerHour) * fuelPricePerHour;
                var allTicket = adultPassCount * adultTicketPrice + youthPassCount * youthTicketPrice;

                var earnedMoney = allTicket - fuelPrice;
                totalEarnedMoney.Add(earnedMoney);
                Console.WriteLine(earnedMoney >= 0
                    ? $"You are ahead with {earnedMoney:f3}$."
                    : $"We've got to sell more tickets! We've lost {earnedMoney:f3}$."
                    );
            }
            Console.WriteLine($"Overall profit -> {totalEarnedMoney.Sum():f3}$.");
            Console.WriteLine($"Average profit -> {totalEarnedMoney.Average():f3}$.");
        }
    }
}
