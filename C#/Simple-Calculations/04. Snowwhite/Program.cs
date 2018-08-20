using System;
using System.Collections.Generic;
using System.Linq;

namespace _04._Snowwhite
{
    class Dwarf
    {
        public string Name { get; set; }
        public string Color { get; set; }
        public long Physic { get; set; }

        static Dictionary<string, int> ColorCount { get; set; }

        public Dwarf(string name, string color, long physic)
        {
            Name = name;
            Color = color;
            Physic = physic;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            List<Dwarf> dwarfs = new List<Dwarf>();
            var colorDict = new Dictionary<string, Dictionary<string, int>>();
            while (input != "Once upon a time")
            {
                string[] str = input
                .Split(new char[] { ' ', '<', ':', '>' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();


                var name = str[0];
                var color = str[1];
                long physic = long.Parse(str[2]);

                if (dwarfs.Any(x => x.Name == name && x.Color == color))
                {
                    var curr = dwarfs.Where(x => x.Name == name && x.Color == x.Color).FirstOrDefault();
                    int index = dwarfs.IndexOf(curr);
                    if (dwarfs[index].Physic < physic)
                    {
                        dwarfs[index].Physic = physic;
                    }
                }
                else
                {
                    var curr = new Dwarf(name, color, physic);
                    dwarfs.Add(curr);
                }
                if (!colorDict.ContainsKey(name))
                {
                    colorDict.Add(name, new Dictionary<string, int>());
                    colorDict[name].Add(color, 0);
                }
                else
                {
                    if (!colorDict[name].ContainsKey(color))
                    {
                        colorDict[name].Add(color, 0);
                    }
                    else
                    {
                        colorDict[name][color]++;
                    }
                }
                input = Console.ReadLine();
            }

            foreach (var dwarf in dwarfs.OrderByDescending(x => x.Physic))
            {
                foreach (var pair in colorDict)
                {
                    foreach (var pair2 in pair.Value)
                    {
                        Console.WriteLine($"({pair2.Key}) {pair.Key} <-> {dwarfs.Where(x => x.Name == pair.Key).FirstOrDefault().Physic}");
                    }
                }
                Console.WriteLine($"({dwarf.Color}) {dwarf.Name} <-> {dwarf.Physic}");
            }
        }
    }
}
