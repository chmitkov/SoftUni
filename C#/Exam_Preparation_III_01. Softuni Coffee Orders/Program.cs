using System;
using System.Globalization;
using System.Numerics;

namespace Exam_Preparation_III_01._Softuni_Coffee_Orders
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            decimal total = 0;
            while (n-- > 0)
            {
                decimal currSum = 0;
                decimal pricePerCapsule = decimal.Parse(Console.ReadLine());
                DateTime orderDate = DateTime.ParseExact(Console.ReadLine(), "d/M/yyyy", CultureInfo.InvariantCulture);
                decimal capsulesCount = decimal.Parse(Console.ReadLine());

                int year = orderDate.Year;
                int month = orderDate.Month;
                int dayInMonths = DateTime.DaysInMonth(year, month);

                currSum = dayInMonths * pricePerCapsule * capsulesCount;
                total += currSum;
                Console.WriteLine($"The price for the coffee is: ${currSum:F2}");
            }
            Console.WriteLine($"Total: ${total:F2}");
        }
    }
}
