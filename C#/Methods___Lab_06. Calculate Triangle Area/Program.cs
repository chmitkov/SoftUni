using System;

namespace Methods___Lab_06._Calculate_Triangle_Area
{
    class Program
    {
        static void Main(string[] args)
        {
            double width = double.Parse(Console.ReadLine());
            double height = double.Parse(Console.ReadLine());
            TriangleArea(width, height);
        }

         static void TriangleArea(double width, double height)
        {
            var result = (width * height) / 2;
            Console.WriteLine($"{result}");
        }
    }
}
