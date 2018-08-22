using System;
using System.Numerics;

namespace Basics___More_Exercises_04._Photo_Gallery
{
    class Program
    {
        static void Main(string[] args)
        {
            int photoNumber = int.Parse(Console.ReadLine());
            int day = int.Parse(Console.ReadLine());
            int month = int.Parse(Console.ReadLine());
            int year = int.Parse(Console.ReadLine());
            int hours = int.Parse(Console.ReadLine());
            int minutes = int.Parse(Console.ReadLine());
            long sizeInBytes = long.Parse(Console.ReadLine());
            int width = int.Parse(Console.ReadLine());
            int height = int.Parse(Console.ReadLine());
            var orient = string.Empty;
            var size = string.Empty;
            if (width > height)
            {
                orient = "landscape";
            }
            else if (width<height)
            {
                orient = "portrait";
            }
            else
            {
                orient = "square";
            }
            if (sizeInBytes < 1000)
            {
                size = $"{sizeInBytes}B";

            }
            else if (sizeInBytes < 1000000)
            {
                size = $"{sizeInBytes * 1.0 / 1000}KB";
            }
            else
            {
                 size = $"{sizeInBytes * 1.0 / 1000000}MB";
            }
            Console.WriteLine($"Name: DSC_{photoNumber:D4}.jpg");
            Console.WriteLine($"Date Taken: {day:D2}/{month:D2}/{year:D4} {hours:D2}:{minutes:D2}");
            Console.WriteLine($"Size: {size}");
            Console.WriteLine($"Resolution: {width}x{height} ({orient})");
           

        }
    }
}
