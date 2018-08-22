using System;

namespace Methods___Exercises_09._Longer_Line
{
    class Program
    {

        static void Main()
        {
            double x1 = double.Parse(Console.ReadLine());
            double y1 = double.Parse(Console.ReadLine());

            double x2 = double.Parse(Console.ReadLine());
            double y2 = double.Parse(Console.ReadLine());

            double x3 = double.Parse(Console.ReadLine());
            double y3 = double.Parse(Console.ReadLine());

            double x4 = double.Parse(Console.ReadLine());
            double y4 = double.Parse(Console.ReadLine());

            double lineA = CalculateLineLength(x1, y1, x2, y2);
            double lineB = CalculateLineLength(x3, y3, x4, y4);


            if (lineA >= lineB && CheckCloserPoint(x1, y1, x2, y2))
            {
                Console.Write($"({x1}, {y1})({x2}, {y2})");
            }
            else if (lineA >= lineB && CheckCloserPoint(x1, y1, x2, y2) == false)
            {
                Console.Write($"({x2}, {y2})({x1}, {y1})");
            }
            else if (lineA < lineB && CheckCloserPoint(x3, y3, x4, y4))
            {
                Console.Write($"({x3}, {y3})({x4}, {y4})");
            }
            else if (lineA < lineB && CheckCloserPoint(x3, y3, x4, y4) == false)
            {
                Console.Write($"({x4}, {y4})({x3}, {y3})");
            }

        }

        static bool CheckCloserPoint(double x1, double y1, double x2, double y2)
        {
            bool isCloserToZero = false;
            double dist1 = Math.Sqrt(Math.Pow(x1, 2) + Math.Pow(y1, 2));
            double dist2 = Math.Sqrt(Math.Pow(x2, 2) + Math.Pow(y2, 2));

            if (dist1 <= dist2)
            {
                isCloserToZero = true;
            }
            return isCloserToZero;
        }

        static double CalculateLineLength(double x1, double y1, double x2, double y2)
        {
            double lineLength = Math.Sqrt(Math.Pow((x2 - x1), 2) + Math.Pow((y2 - y1), 2));
            return lineLength;
        }
    }
}
