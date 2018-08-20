using System;
using System.Collections.Generic;
using System.Linq;

namespace ObjectsAndClasses_Lab_05.ClosestTwoPoints
{
    class Point
    {
        public int x { get; set; }
        public int y { get; set; }
    }
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            var minDistance = double.MaxValue;
            string point1 = string.Empty; 
            string point2 = string.Empty; 
            List<Point> points = new List<Point>();
            for (int i = 0; i < n; i++)
            {
                int[] array = Console.ReadLine()
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse)
                    .ToArray();
                var currPoint = new Point() { x = array[0], y = array[1] };
                points.Add(currPoint);
            }
            for (int i = 0; i < points.Count; i++)
            {
                var curr = points[i];
                for (int j = i+1; j < points.Count; j++)
                {
                    var curr2 = points[j];
                    if (CalcDistance(curr, curr2) < minDistance)
                    {
                        minDistance = CalcDistance(curr, curr2);
                        point1 = $"{curr.x}, {curr.y}";
                        point2 = $"{curr2.x}, {curr2.y}";
                    }
                }

            }

            Console.WriteLine($"{minDistance:F3}");
            Console.WriteLine($"({point1})");
            Console.WriteLine($"({point2})");
        }
        static double CalcDistance(Point p1, Point p2)
        {
            var sideA = p1.x - p2.x;
            var sideB = p1.y - p2.y;
            double result = Math.Sqrt(Math.Pow(sideA, 2) + Math.Pow(sideB, 2));
            return result;
        }
    }
}
