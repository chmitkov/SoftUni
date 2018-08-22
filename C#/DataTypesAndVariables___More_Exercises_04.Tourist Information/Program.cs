using System;

namespace DataTypesAndVariables___More_Exercises_04.Tourist_Information
{
    class Program
    {
        static void Main(string[] args)
        {
            string imperialUnit = Console.ReadLine();
            decimal count = decimal.Parse(Console.ReadLine());
            decimal result = 0M;
            string final = string.Empty;
            switch (imperialUnit)
            {
                case "miles":
                    result = count * 1.6M;
                    final ="kilometers";
                    break;
                case "inches":
                    result = count * 2.54M;
                    final ="centimeters";
                    break;
                case "feet":
                    result = count * 30M;
                    final ="centimeters";
                    break;
                case "yards":
                    result = count * 0.91M;
                    final ="meters";
                    break;
                case "gallons":
                    result = count * 3.8M;
                    final = "liters";
                    break;
            }
            Console.WriteLine($"{count} {imperialUnit} = {result:F2} {final}");
        }
    }
}
