using System;
using System.Linq;

namespace ObjectsAndClasses_Exercises_03.Circles_Intersection
{
    class Circle
    {
        public Point Center { get; set; }
        public int Radius { get; set; }
    }
    class Point
    {
        public int X { get; set; }
        public int Y { get; set; }

         public double Distance(Point other)
        {
            var sideA = Math.Abs(X - other.X);
            var sideB = Math.Abs(Y - other.Y);
            return Math.Sqrt(Math.Pow(sideA, 2) + Math.Pow(sideB, 2));
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            int[] row1 = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();

            var point1 = new Circle()
            {
                Center = new Point
                {
                    X = row1[0],
                    Y = row1[1]
                },
                Radius = row1[2]
            };
            int[] row2 = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            var point2 = new Circle()
            {
                Center = new Point
                {
                    X = row2[0],
                    Y = row2[1]
                },
                Radius = row2[2]
            };

            var diff = point1.Center.Distance(point2.Center);

            Console.WriteLine((diff<=((point1.Radius+point2.Radius)*1.0))?
                "Yes":"No");
            
        }
    }
}
