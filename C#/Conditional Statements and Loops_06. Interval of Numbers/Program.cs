using System;

namespace Conditional_Statements_and_Loops_06._Interval_of_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int num1 = int.Parse(Console.ReadLine());
            int num2 = int.Parse(Console.ReadLine());
            for (int i = Math.Min(num1,num2); i <= Math.Max(num1,num2); i++)
            {
                Console.WriteLine(i);
            }
        }
    }
}
