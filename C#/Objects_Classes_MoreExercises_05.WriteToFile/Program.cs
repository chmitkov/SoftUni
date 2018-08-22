using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace Objects_Classes_MoreExercises_05.WriteToFile
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] allText = 
                File.ReadAllLines(@"C:\Users\9999\Desktop\sample_text.txt");
            char[] toSkip = new char[] { '.', ',', '!', '?', ':' };
            List<char> result = new List<char>();

            foreach (var row in allText)
            {
                for (int i = 0; i < row.Length; i++)
                {
                    if (!toSkip.Contains(row[i]))
                    {
                        result.Add(row[i]);
                    }
                }
            }
            File.WriteAllText(@"C:\Users\9999\Desktop\Output.txt",
                string.Join("", result));
        }
    }
}
