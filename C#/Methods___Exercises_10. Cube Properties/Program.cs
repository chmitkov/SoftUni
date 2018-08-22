using System;

namespace Methods___Exercises_10._Cube_Properties
{
    class Program
    {
        static void Main(string[] args)
        {
            double side = double.Parse(Console.ReadLine());
            string type = Console.ReadLine();

            CubeProperties(side, type);
        }

         static void CubeProperties(double side, string type)
        {
            var result = 0D;
            switch (type)
            {
                case "face":
                    result = Math.Sqrt(2 * Math.Pow(side, 2));
                    break;
                case "space":
                    result = Math.Sqrt(3 * Math.Pow(side, 2));
                    break;
                case "volume":
                    result =  Math.Pow(side, 3);
                    break;
                case "area":
                    result = 6 * Math.Pow(side, 2);
                    break;
            }
            Console.WriteLine($"{result:F2}");
        }
    }
}
