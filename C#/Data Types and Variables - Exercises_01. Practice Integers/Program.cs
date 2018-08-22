using System;

namespace Data_Types_and_Variables___Exercises_01._Practice_Integers
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            Console.WriteLine($"Before:\na = {a}\nb = {b}");
            var current = a;
            a = b;
            b = current;

            Console.WriteLine($"After:\na = {a}\nb = {b}");
            
        }
    }
}
