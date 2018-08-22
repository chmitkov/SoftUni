using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam_pokeEvoTest
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine()
                .Split(new char[] { ' ', '-', '>' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            
            var dict = new Dictionary<string, List<string>>();
            while (input[0] != "wubbalubbadubdub")
            {
                
                if (input.Length < 1)
                {
                    var pokemonName = input[0];
                    var evoType = input[1];
                    var evoIndex = int.Parse(input[2]);
                    if (!dict.ContainsKey(pokemonName))
                    {
                        dict[pokemonName] = new List<string>();
                    }
                    dict[pokemonName].Add($"{evoType} <-> {evoIndex}");
                }
                else
                {
                    var name = input[0];
                    if (dict.ContainsKey(name))
                    {
                        foreach (var evos in dict.Values)
                        {
                            Console.WriteLine($"# {name}");
                            Console.WriteLine($"{evos}");
                        }
                    }
                }
                input = Console.ReadLine()
                .Split(new char[] { ' ', '-', '>' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            }
            foreach (var pair in dict)
            {
                var name = pair.Key;
                Console.WriteLine($"# {name}");
                foreach (var evo in pair.Value.OrderByDescending(
                    x => x.Split(new char[] { ' ', '-', '>', '<' }
                    , StringSplitOptions.RemoveEmptyEntries)
                    .Last()))
                {
                    Console.WriteLine(evo);
                }
                //var typeColl = new Dictionary<string, int>();
                //foreach (var word in pair.Value)
                //{
                //    var row = word.Split(new char[] { ' ', '-', '>', '<' }
                //    , StringSplitOptions.RemoveEmptyEntries).ToArray();
                //    typeColl.Add(row[0], int.Parse(row[1]));

                //}
                //foreach (var pair1 in typeColl.OrderByDescending(x=>x.Value))
                //{
                //    Console.WriteLine($"{pair1.Key} <-> {pair.Value}");
                //}
            }
        }
    }
}
