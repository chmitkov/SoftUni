using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DictionriesP01
{
    class Program
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine().ToLower();
            string[] words = input
                .Split(new char[]{' '}, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            var counted = new Dictionary<string, int>();
            foreach (var word in words)
            {
                if (counted.ContainsKey(word))
                {
                    counted[word]++;
                }
                else
                {
                    counted.Add(word, 1);
                    //counted[word] = 1;
                }
            }
            var result = new List<string>();
            foreach (var pair in counted)
            {
                if (pair.Value % 2 != 0)
                {
                    result.Add(pair.Key);
                }
            }
            Console.WriteLine(string.Join(", ", result));
        }
    }
}
