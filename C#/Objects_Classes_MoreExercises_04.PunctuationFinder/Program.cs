using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;

namespace Objects_Classes_MoreExercises_04.PunctuationFinder
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] allText = File.ReadAllLines(@"C:\Users\9999\Desktop\sample_text.txt");
            List<char> result = new List<char>();
            char[] toTake = new char[] { '.', ',', '!', '?', ':' };
            foreach (var row in allText)
            {
                for (int i = 0; i < row.Length; i++)
                {
                    if (toTake.Contains(row[i]))
                    {
                        result.Add(row[i]);
                    }
                }
            }
            Console.WriteLine(string.Join(", ",result));
        }
    }
}
