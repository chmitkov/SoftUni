using System;

namespace Data_Types_and_Variables___Exercises_17.PrintPartOfASCIITable
{
    class Program
    {
        static void Main(string[] args)
        {
            int startIndex = int.Parse(Console.ReadLine());
            int endIndex = int.Parse(Console.ReadLine());
            for (int i = startIndex; i <= endIndex; i++)
            {
                Console.Write($"{(char)i} ");
            }
        }
    }
}
