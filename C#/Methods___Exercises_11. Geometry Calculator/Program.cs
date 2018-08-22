using System;

namespace Methods___Exercises_11._Geometry_Calculator
{
    class Program
    {
        static void Main(string[] args)
        {
            GetArea(Console.ReadLine());
        }

         static void GetArea(string v)
        {
            double result = 0;
            switch (v)
            {
                case "triangle":
                    double side = double.Parse(Console.ReadLine());
                    double height = double.Parse(Console.ReadLine());
                    result = side * height/2 ;
                    break;
                case "square":
                    double squareSide = double.Parse(Console.ReadLine());
                    result = squareSide * squareSide;
                    break;
                case "rectangle":
                    double width = double.Parse(Console.ReadLine());
                    double rectangleHeight = double.Parse(Console.ReadLine());
                    result = width * rectangleHeight;
                    break;
                case "circle":
                    double radius = double.Parse(Console.ReadLine());
                    result = Math.PI * Math.Pow(radius, 2);
                    break;
            }
            Console.WriteLine($"{result:F2}");
        }
    }
}
