using System;

namespace Basics___More_Exercises_
{
    class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());
            string current = string.Empty;
            string result = string.Empty;
            var count = 0;
            for (int i = 1; i <= 4; i++)
            {
                for (int j = 1; j <= 4; j++)
                {
                    for (int k = 1; k <= 4; k++)
                    {
                        if ((i + j + k) >= num)
                        {
                            Console.Write("O" + ("" + i + j + k)
                                .Replace('1', 'A').Replace('2', 'C').Replace('3', 'G').Replace('4', 'T') + "O ");

                        }
                        else
                        {
                            Console.Write("X" + ("" + i + j + k)
                                .Replace('1', 'A').Replace('2', 'C').Replace('3', 'G').Replace('4', 'T') + "X ");
                        }
                        count++;
                        if (count % 4 == 0)
                        {
                            Console.WriteLine();
                        }
                    }
                }
            }
        }
    }
}


