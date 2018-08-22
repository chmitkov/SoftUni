using System;

namespace Conditional_Statements_and_Loops_04._Hotel
{
    class Program
    {
        static void Main(string[] args)
        {
            string month = Console.ReadLine();
            int nihgt = int.Parse(Console.ReadLine());
            var studio = 0.0;
            var doubleRoom = 0.0;
            var suite = 0.0;
            switch (month)
            {
                case "May":
                case "October":
                    studio = nihgt * 50;
                    doubleRoom = nihgt * 65;
                    suite = nihgt * 75;
                    if (nihgt > 7 && month == "October")
                    {
                        studio -= 50;
                    }
                     if (nihgt > 7)
                    {
                        studio = studio * 0.95;
                    }                    
                    break;
                case "June":
                case "September":
                    studio = nihgt * 60;
                    doubleRoom = nihgt * 72;
                    suite = nihgt * 82;
                    if (nihgt > 14)
                    {
                        doubleRoom = doubleRoom * 0.9;
                    }
                    if (nihgt > 7 && month == "September")
                    {
                        studio -= 60;
                    }
                    break;
                case "July":
                case "August":
                case "December":
                    studio = nihgt * 68;
                    doubleRoom = nihgt * 77;
                    suite = nihgt * 89;

                    if (nihgt > 14)
                    {
                        suite = suite * 0.85;
                    }
                    break;
            }
            Console.WriteLine($"Studio: {studio:F2} lv.");
            Console.WriteLine($"Double: {doubleRoom:F2} lv.");
            Console.WriteLine($"Suite: {suite:F2} lv.");            
        }
    }
}
