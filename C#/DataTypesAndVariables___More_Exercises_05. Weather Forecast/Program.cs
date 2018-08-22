using System;

namespace DataTypesAndVariables___More_Exercises_05._Weather_Forecast
{
    class Program
    {
        static void Main(string[] args)
        {
            string number = Console.ReadLine();
            if (number.Contains("."))
            {
                Console.WriteLine("Rainy");
                return;
            }
            long num = long.Parse(number);
            if (num >= sbyte.MinValue && num <= sbyte.MaxValue)
            {
                Console.WriteLine("Sunny");
                return;
            }
            else if (num >= int.MinValue && num <= int.MaxValue)
            {
                Console.WriteLine("Cloudy");
                return;
            }
            else if (num >= long.MinValue && num <= long.MaxValue)
            {
                Console.WriteLine("Windy");
                return;
            }
        }
    }
}
