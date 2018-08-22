using System;

namespace DataTypesAndVariables___More_Exercises_02._Number_Checker
{
    class Program
    {
        static void Main(string[] args)
        {
            string num = Console.ReadLine();
            if (num.Contains("."))
            {
                Console.WriteLine("floating-point");
            }
            else
            {
                Console.WriteLine("integer");
            }
        }
    }
}
