using System;

namespace Conditional_Statements_and_Loops_13._Game_of_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int m = int.Parse(Console.ReadLine());
            int magic = int.Parse(Console.ReadLine());
            int num = 0;
            bool isMagic = false;
            int num1 = 0;
            int num2 = 0;
            var counter = 0;

            for (int i = n; i <= m; i++)
            {
                for (int j = n; j <= m; j++)
                {
                    //Console.WriteLine($"{i} {j}");
                    counter++;
                    if (i + j == magic)
                    {
                        num = i + j;
                        num1 = i;
                        num2 = j;
                        isMagic = true;
                    }
                }
            }
            if (isMagic)
            {
                Console.WriteLine($"Number found! {num1} + {num2} = {magic}");
            }
            else
            {
                Console.WriteLine($"{counter} combinations - neither equals {magic}");
            }
        }
    }
}
