using System;
using System.Numerics;

namespace DataTypesAndVariables___More_Exercises_10._Sum_of_Chars
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            BigInteger result = 0;
            for (int i = 0; i < n; i++)
            {
                char ch = char.Parse(Console.ReadLine());
                result += ch;
            }
            Console.WriteLine($"The sum equals: {result}");
        }
    }
}
