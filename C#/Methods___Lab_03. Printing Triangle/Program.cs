using System;

namespace Methods___Lab_03._Printing_Triangle
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            for (int i = 1; i <= n; i++)
            {
                PrintNumbers(i);
                Console.WriteLine();
            }
            for (int i = n - 1; i >= 0; i--)
            {
                PrintNumbers(i);
                Console.WriteLine();
            }
        }
        static void PrintNumbers(int v)
        {
            for (int i = 1; i <= v; i++)
            {
                Console.Write($"{i} ");
            }
        }
    }
}
