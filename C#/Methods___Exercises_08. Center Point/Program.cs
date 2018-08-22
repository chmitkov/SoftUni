using System;

namespace Methods___Exercises_08._Center_Point
{
    class Program
    {
        static void Main(string[] args)
        {
            double x1 = double.Parse(Console.ReadLine());
            double y1 = double.Parse(Console.ReadLine());
            double x2 = double.Parse(Console.ReadLine());
            double y2 = double.Parse(Console.ReadLine());
            NearestToCenter(x1, y1, x2, y2);
        }

        private static void NearestToCenter(double x1, double y1, double x2, double y2)
        {
            double x1Abs = Math.Abs(x1);
            double y1Abs = Math.Abs(y1);
            double x2Abs = Math.Abs(x2);
            double y2Abs = Math.Abs(y2);
            Console.WriteLine(x1Abs + y1Abs <= x2Abs + y2Abs ? $"({x1}, {y1})" : $"({x2}, {y2})");
        }
    }
}
