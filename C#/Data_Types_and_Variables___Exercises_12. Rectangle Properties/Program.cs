using System;

namespace Data_Types_and_Variables___Exercises_12._Rectangle_Properties
{
    class Program
    {
        static void Main(string[] args)
        {
            double width = double.Parse(Console.ReadLine());
            double height = double.Parse(Console.ReadLine());
            Console.WriteLine($"{(width+height)*2}");
            Console.WriteLine($"{width*height}");
            double diagonal = Math.Sqrt((Math.Pow(width, 2) + Math.Pow(height, 2)));
            Console.WriteLine($"{diagonal}");
        }
    }
}
