using System;
using System.Linq;

namespace ObjectsAndClasses_Lab_06._Rectangle_Position
{
    class Rectanle
    {
        public int Top { get; set; }
        public int Left { get; set; }
        public int Width { get; set; }
        public int Height { get; set; }

        public int CalcArea()
        {
            return Width * Height;
        }

        public int Bottom
        {
            get
            {
                return Top + Height;
            }
        }

        public int Right
        {
            get
            {
                return Left + Width;
            }
        }
        public bool IsInside(Rectanle other)
        {
            return (other.Left <= Left) && (other.Right >= Right)
                && (other.Top <= Top) && (other.Bottom >= Bottom);
        }
    }
    class Program
    {
        static void Main(string[] args)
        {

            var r1 = ReadRectangle(Console.ReadLine());
            var r2 = ReadRectangle(Console.ReadLine());

        
            Console.WriteLine(r1.IsInside(r2)?"Inside":"Not inside");
        }

        public static Rectanle ReadRectangle(string v)
        {
            int[] array = v.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse).ToArray();
            return new Rectanle() { Left = array[0], Top = array[1], Width = array[2], Height = array[3] };
        }
    }
}
