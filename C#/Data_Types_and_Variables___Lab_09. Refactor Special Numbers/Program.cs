﻿using System;

namespace Data_Types_and_Variables___Lab_09._Refactor_Special_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int digitGiven = int.Parse(Console.ReadLine());
            int total = 0;
            int cycleCopier = 0;
            bool dividedOrNot = false;

            for (int cycle = 1; cycle <= digitGiven; cycle++)
            {
                cycleCopier = cycle;
                while (cycleCopier > 0)
                {
                    total += cycleCopier % 10;
                    cycleCopier /= 10;
                }
                dividedOrNot = total == 5 || total == 7 || total == 11;
                Console.WriteLine($"{cycle} -> {dividedOrNot}");

                total = 0;
            }
        }
    }
}
