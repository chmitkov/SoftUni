using System;

namespace DataTypesAndVariables__More_Exercises_12._Beer_Kegs
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            string bestKeg = string.Empty;
            var bestVolume = 0D;
            for (int i = 0; i < n; i++)
            {
                string model = Console.ReadLine();
                double radius = double.Parse(Console.ReadLine());
                int height = int.Parse(Console.ReadLine());
                var volume = Math.PI * Math.Pow(radius, 2) * height;
                if (volume > bestVolume)
                {
                    bestVolume = volume;
                    bestKeg = model;
                }
            }
            Console.WriteLine(bestKeg);
        }
    }
}
