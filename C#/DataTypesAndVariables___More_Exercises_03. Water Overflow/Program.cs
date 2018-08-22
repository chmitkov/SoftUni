using System;

namespace DataTypesAndVariables___More_Exercises_03._Water_Overflow
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int capacity =0 ;
            for (int i = 0; i < n; i++)          
            {
                var num = int.Parse(Console.ReadLine());
                capacity += num;
                if (capacity > 255)
                {
                    capacity -= num;
                    Console.WriteLine("Insufficient capacity!");
                }
            }
            Console.WriteLine(capacity);
        }
    }
}
