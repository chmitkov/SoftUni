using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam___09_July_2017_Part_02._Pokemon_Don_t_Go
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> pokemons = Console.ReadLine()
                 .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                 .Select(int.Parse)
                 .ToList();
            int count = 0;
            while (pokemons.Count > 0)
            {
                int index = int.Parse(Console.ReadLine());
                int neededElement = 0;
                if (index < 0)
                {
                    neededElement = pokemons[0];
                    pokemons[0] = pokemons[pokemons.Count - 1];
                    count+=neededElement;
                }
                else if (index >= pokemons.Count)
                {
                    neededElement = pokemons[pokemons.Count - 1];
                    pokemons[pokemons.Count - 1] = pokemons[0];
                    count += neededElement;
                }
                else
                {
                    neededElement = pokemons[index];
                    pokemons.RemoveAt(index);
                    count += neededElement;
                }
                for (int i = 0; i < pokemons.Count; i++)
                {
                    if (pokemons[i] <= neededElement)
                    {
                        pokemons[i] += neededElement;
                    }
                    else
                    {
                        pokemons[i] -= neededElement;
                    }
                }

            }
            Console.WriteLine(count);
        }
    }
}
