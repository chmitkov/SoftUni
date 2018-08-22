using System;
using System.Linq;

namespace Exam_Preparation_1_03._Endurance_Rally
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] drivers = Console.ReadLine()
                 .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                 .ToArray();
            double [] track = Console.ReadLine()
                 .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                 .Select(double.Parse)
                 .ToArray();
            int [] checkpoint = Console.ReadLine()
                 .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                 .Select(int.Parse)
                 .ToArray();
            foreach (var driver in drivers)
            {
                var fuel = (double)driver.First();
                var counter = 0;
                foreach (var zone in track)
                {
                    
                    if (checkpoint.Contains(counter))
                    {
                        fuel += zone;
                    }
                    else
                    {
                        fuel -= zone;
                    }
                    if (fuel <= 0)
                    {
                        Console.WriteLine($"{driver} - reached {counter}");
                        break;
                    }
                    counter++;
                }
                if (fuel > 0)
                {
                    Console.WriteLine($"{driver} - fuel left {fuel:F2}");
                }
            }
        }
    }
}
