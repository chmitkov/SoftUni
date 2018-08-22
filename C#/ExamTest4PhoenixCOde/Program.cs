using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamTest4PhoenixCOde
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var dict = new Dictionary<string, List<string>>();
            while (input != "Blaze it!")
            {
                var command = input.Split(new char[] { '-', '>' }
                , StringSplitOptions.RemoveEmptyEntries).ToArray();
                var creature = command[0];
                var mate = command[1];
                if (!dict.ContainsKey(creature))
                {
                    dict[creature] = new List<string>();
                }
                else
                {
                    if (!dict[creature].Contains(mate) && mate != creature)
                    {
                        dict[creature].Add(mate);
                    }
                }
                input = Console.ReadLine();
            }
            foreach (var pair in dict)
            {
                for (int i = 0; i < pair.Value.Count; i++)
                {
                    if (pair.Value.Contains(pair.Value[i]))
                    {
                        if (pair.Value.Contains(pair.Key))
                        {
                            dict[pair.Key].Remove(pair.Value[i]);
                            dict[pair.Value[i]].Remove(pair.Key);
                            i--;
                        }
                    }
                }
            }
            foreach (var pair in dict.OrderByDescending(x=>x.Value.Count))
            {
                Console.WriteLine($"{pair.Key} : {pair.Value.Count}");
            }
        }
    }
}
