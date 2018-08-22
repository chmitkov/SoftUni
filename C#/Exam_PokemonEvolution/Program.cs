using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam_PokemonEvolution
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var dict = new Dictionary<string, Dictionary<string, int>>();
            while (input != "wubbalubbadubdub")
            {
                var command = input
                    .Split(new char[] { ' ', '-', '>' }
                , StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
                if (command.Length == 3)
                {
                    var pokemonName = command[0];
                    var evoType = command[1];
                    var evoIndex = int.Parse(command[2]);
                    if (!dict.ContainsKey(pokemonName))
                    {
                        dict[pokemonName] = new Dictionary<string, int>();
                    }
                    if (!dict[pokemonName].ContainsKey(evoType))
                    {
                        dict[pokemonName][evoType] = 0;
                    }
                    dict[pokemonName][evoType] = evoIndex;
                }
                else
                {
                    var pokemonName = command[0];
                    if (dict.ContainsKey(pokemonName))
                    {
                        foreach (var pair in dict[pokemonName])
                        {
                            Console.WriteLine($"# {pokemonName}");
                            Console.WriteLine($"{pair.Key} <-> {pair.Value}");
                        }
                    }

                }
                input = Console.ReadLine();
            }
            foreach (var pair in dict)
            {
                var name = pair.Key;
                Console.WriteLine($"# {name}");
                foreach (var pair1 in pair.Value.OrderByDescending(x=>x.Value))
                {
                    var evoType = pair1.Key;
                    var evoIndex = pair1.Value;
                    Console.WriteLine($"{evoType} <-> {evoIndex}");
                }
            }
        }
    }
}
