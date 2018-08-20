using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam_09July2017Part_1_04._Pokemon_Evolution
{
    class Pokemon
    {
        public string Name { get; set; }
        public List<Types> tipeList { get; set; }

        public Pokemon(string name, List<Types> tipeList)
        {
            Name = name;
            this.tipeList = tipeList;
        }
    }
    class Types
    {
        public string typeName { get; set; }
        public int evos { get; set; }

        public Types(string typeName, int evos)
        {
            this.typeName = typeName;
            this.evos = evos;
        }

        public void Print()
        {
            Console.WriteLine($"{typeName} <-> {evos}");
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            List<Pokemon> result = new List<Pokemon>();
            while (input != "wubbalubbadubdub")
            {
                string[] commands = input
                    .Split(new char[] { ' ','-','>' }, StringSplitOptions.RemoveEmptyEntries);

                if (commands.Length == 1)
                {
                    var name = commands[0];
                    if (result.Any(x => x.Name == name))
                    {
                        Console.WriteLine($"# {name}");
                       var currentPoke= result.Where(x => x.Name == name).FirstOrDefault();
                        foreach (var item in currentPoke.tipeList)
                        {
                            item.Print();
                        }
                    }
                }
                else
                {
                    var name = commands[0];
                    var type = commands[1];
                    var evos = int.Parse(commands[2]);

                    if (!result.Any(x => x.Name == name))
                    {
                        var currPokemon = new Pokemon(name, new List<Types>());
                        currPokemon.tipeList.Add(new Types(type, evos));
                        result.Add(currPokemon);
                    }
                    else
                    {
                        var currPokemon = result.Where(x => x.Name == name).FirstOrDefault();
                        currPokemon.tipeList.Add(new Types(type,evos));
                    }
                }
                input = Console.ReadLine();
            }
            foreach (var poke in result)
            {
                Console.WriteLine($"# {poke.Name}");
                foreach (var t in poke.tipeList.OrderByDescending(x=>x.evos))
                {
                    t.Print();
                }
            }
            
        }
    }
}
