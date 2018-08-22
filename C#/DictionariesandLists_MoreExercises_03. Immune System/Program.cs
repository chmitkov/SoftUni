using System;
using System.Collections.Generic;
using System.Linq;

namespace DictionariesandLists_MoreExercises_03._Immune_System
{
    class Program
    {
        static void Main(string[] args)
        {
            long initialHealth = long.Parse(Console.ReadLine());
            var currentHealth = initialHealth;
            string input = Console.ReadLine();
            var dict = new Dictionary<string, long>();
            while (input != "end")
            {
                var virusStrength = 0;
                for (int i = 0; i < input.Length; i++)
                {
                    virusStrength += input[i];
                }
                virusStrength /= 3;
                long timeToDefeat = virusStrength * input.Length;
                if (!dict.ContainsKey(input))
                {
                    dict[input] = timeToDefeat;
                }
                else
                {
                    dict[input] = (timeToDefeat / 3);
                    timeToDefeat = dict[input];
                }

                var mlongodefeat = dict[input] / 60;
                var secTodefeat = dict[input] % 60;

                if (currentHealth - timeToDefeat >= 0)
                {
                    Console.WriteLine($"Virus {input}: {virusStrength} => {timeToDefeat} seconds");
                    Console.WriteLine($"{input} defeated in {mlongodefeat}m {secTodefeat}s.");
                    currentHealth -= timeToDefeat;
                    Console.WriteLine($"Remaining health: {currentHealth}");
                }
                else 
                {
                    Console.WriteLine($"Virus {input}: {virusStrength} => {timeToDefeat} seconds");
                    Console.WriteLine("Immune System Defeated.");
                    return;
                }

                if ((currentHealth + currentHealth * 0.2) > initialHealth)
                {
                    currentHealth = initialHealth;
                }
                else
                {
                    currentHealth+=(long)(currentHealth*0.2);
                }
                input = Console.ReadLine();
            }
            Console.WriteLine($"Final Health: {currentHealth}");

        }
    }
}
