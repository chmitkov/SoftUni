using System;

namespace Data_Types_and_Variables___Exercises_11._Convert_Speed_Units
{
    class Program
    {
        static void Main(string[] args)
        {
            float distanceInMeters = float.Parse(Console.ReadLine());
            float hours = float.Parse(Console.ReadLine());
            float min = float.Parse(Console.ReadLine());
            float sec = float.Parse(Console.ReadLine());
            float time = time = hours * 3600 + min * 60 + sec;
            float metersPerSec = distanceInMeters / time;
            float kilometersPerHour = (distanceInMeters / 1000) / (time / 3600);
            float milesPerHour = (distanceInMeters / 1609) / (time / 3600);

            Console.WriteLine($"{metersPerSec:F6}");
            Console.WriteLine($"{kilometersPerHour:F6}");
            Console.WriteLine($"{milesPerHour:F6}");
        }
    }
}
