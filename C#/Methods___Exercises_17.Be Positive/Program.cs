using System;
using System.Collections.Generic;
using System.Linq;

namespace Methods___Exercises_17.Be_Positive
{
    class Program
    {
        static void Main(string[] args)
        {
            int countSequences = int.Parse(Console.ReadLine());

            for (int i = 0; i < countSequences; i++)
            {
                int[] input = Console.ReadLine()
                    .Split(new char[] {' '},StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse)
                    .ToArray();
                //Console.WriteLine(string.Join("--",input));
                bool found = false;
                for (int j = 0; j < input.Length; j++)
                {
                    if (input[j] >= 0)
                    {
                        found = true;
                        Console.Write(input[j]+" ");
                    }
                    else
                    {
                        if (j < input.Length - 1)
                        {
                            if ((input[j] + input[j + 1]) >= 0)
                            {
                                found = true; 
                                Console.Write(input[j]+input[j+1]+" ");
                                j++;
                            }
                            else
                            {
                                j++;
                            }
                        }
                    }
                }
                if (!found)
                {
                    Console.WriteLine("(empty)");
                }
                else
                {
                    Console.WriteLine();
                }
            }
        }
    }
}