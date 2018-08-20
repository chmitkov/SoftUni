
using System;
using System.Linq;

namespace ObjectsAndClasses_Lab_04._Distance_between_Points
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
            int[] nums1 = Console.ReadLine()
                 .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                 .Select(int.Parse)
                 .ToArray();
            Point p1 = new Point() { x = nums1[0], y = nums1[1] };
            int[] nums2 = Console.ReadLine()
                 .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                 .Select(int.Parse)
                 .ToArray();
            Point p2 = new Point() { x = nums2[0], y = nums2[1] };

            Console.WriteLine($"{CalcDistance(p1,p2):F3}");
        }

         static double CalcDistance(Point p1, Point p2)
        {
            var sideA = p1.x - p2.x;
            var sideB = p1.y - p2.y;
            double result = Math.Sqrt(Math.Pow(sideA, 2) + Math.Pow(sideB, 2));
            return result ;
        }
    }
}
