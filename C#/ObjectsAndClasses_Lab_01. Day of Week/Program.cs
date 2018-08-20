using System;
using System.Globalization;

namespace ObjectsAndClasses_Lab_01._Day_of_Week
{
    class Program
    {
        static void Main(string[] args)
        {
            string str = Console.ReadLine();
            DateTime date = DateTime.ParseExact(str, "d-M-yyyy",
                CultureInfo.InvariantCulture);

            Console.WriteLine(date.DayOfWeek);
        }
    }
}
