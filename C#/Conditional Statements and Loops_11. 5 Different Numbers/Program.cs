using System;

namespace Conditional_Statements_and_Loops_11._5_Different_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            bool noNumber = false;

            for (int i = a; i <= b - 4; i++)
            {
                for (int j = a; j <= b - 3; j++)
                {
                    for (int k = a; k <= b - 2; k++)
                    {
                        for (int l = a; l <= b - 1; l++)
                        {
                            for (int m = a; m <= b; m++)
                            {
                                if (i < j && j < k && k < l && l < m)
                                {
                                    Console.WriteLine($"{i} {j} {k} {l} {m}");
                                    noNumber = true;
                                    
                                }
                            }
                        }
                    }
                }
            }
            if (!noNumber)
            {
                Console.WriteLine("No");
            }
        }
    }
}
