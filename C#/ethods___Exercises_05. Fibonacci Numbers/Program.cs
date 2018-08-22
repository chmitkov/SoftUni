using System;

namespace Methods___Exercises_05._Fibonacci_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            Fib(int.Parse(Console.ReadLine()));

        }
        static void Fib(int n)
        {
            var fib0 = 1;
            var fib1 = 1;
            if (n == 0 || n == 1)
            {
                Console.WriteLine(1);
            }
            else if (n > 1)
            {
                var curr = 0;
                for (int i = 2; i <= n; i++)
                {
                    curr = fib0 + fib1;                   
                    fib0 = fib1;
                    fib1 = curr;                   
                }
                Console.WriteLine(curr);
            }
        }
    }
}
