using System;
using System.Linq;

namespace Data_Types_and_Variables___Lab_05._Special_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            for (int i = 1; i <= n; i++)
            {
                string numStr = i.ToString();
                if (numStr.Length == 1)
                {
                    if (int.Parse(numStr) == 5 || int.Parse(numStr) == 7)
                    {
                        Console.WriteLine($"{numStr} -> True");
                    }
                    else
                    {
                        Console.WriteLine($"{numStr} -> False");
                    }
                }
                else if (numStr.Length == 2)
                {
                    int part1 = i / 10;
                    int part2 = i % 10;
                    if (part1 + part2 == 5 || part1 + part2 == 7
                        || part1 + part2 == 11)
                    {
                        Console.WriteLine($"{numStr} -> True");
                    }
                    else
                    {
                        Console.WriteLine($"{numStr} -> False");
                    }
                }
                
            }
           

        }
    }
}
