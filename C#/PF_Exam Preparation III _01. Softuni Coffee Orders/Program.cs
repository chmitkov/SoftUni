using System;
using System.Linq;
using System.Numerics;

namespace PF_Exam_Preparation_III__01._Softuni_Coffee_Orders
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal n = decimal.Parse(Console.ReadLine());
            decimal total = 0;

            for (decimal i = 0; i < n; i++)
            {
                decimal pricePerCapsule = decimal.Parse(Console.ReadLine());
                DateTime date = DateTime.Parse(Console.ReadLine());
                decimal capsuleCount = decimal.Parse(Console.ReadLine());
                decimal days = System.DateTime.DaysInMonth(date.Year, date.Month);
                decimal price = (days * capsuleCount) * pricePerCapsule;
                total += price;
                Console.WriteLine($"The price for the coffee is: ${price:F2}");
            }
            Console.WriteLine($"Total: ${total:F2}");
        }
    }
}
