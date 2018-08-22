using System;

namespace DrawAFilledSquare
{
    class Program
    {
        static void Main(String[] args)
        {
            int n = int.Parse(Console.ReadLine());
            FirstLast(n);
            for (int i = 0; i < n-2; i++)
            {
                Mid(n);
            }
            FirstLast(n);
        }
        static void FirstLast(int num)
        {
            for (int i = 1; i <= num * 2; i++)
            {
                Console.Write("-");
            }
            Console.WriteLine();
        }
        static void Mid(int num)
        {
            for (int i = 1; i <= num + 1; i++)
            {
                if (i == 1 || i == num + 1)
                {
                    Console.Write("-");
                }
                else
                {
                    Console.Write("\\/");
                }
            }
            Console.WriteLine();
        }
    }
}