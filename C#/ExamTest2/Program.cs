using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamTest2
{
    class Program
    {
        static void Main(string[] args)
        {
            var text = Console.ReadLine();
            var dict = new Dictionary<string, List<string>>();
            while (text != "Blaze it!")
            {
                var input = text
                .Split(new char[] { ' ', '-', '>' }
                , StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
                var creature = input[0];
                var mate = input[1];

                if (!dict.ContainsKey(creature))
                {
                    dict[creature] = new List<string>();
                }
                dict[creature].Add(mate);
                dict[creature].Distinct();
                if (dict[creature].Contains(mate) && dict[mate].Contains(creature))
                {
                    dict[creature].Remove(mate);
                    dict[mate].Remove(creature);
                }
                
                //if ((HaveMate(creature, dict[mate].ToArray())
                //    && HaveMate(mate, dict[creature].ToArray())))
                //{
                //    dict[creature].Remove(mate);
                //    dict[mate].Remove(creature);
                //}

                text = Console.ReadLine();
            }
            dict.OrderByDescending(x => x.Value.Count);
            foreach (var pair in dict)
            {
                Console.WriteLine($"{pair.Key} : {pair.Value.Count}");
            }
        }

        static bool HaveMate( string name , params string[] List)
        {
            var inCollection = false;
            foreach (var word in List)
            {
                if (word == name)
                {
                    inCollection = true;
                }
            }
            return inCollection;
             
        }
    }
}
