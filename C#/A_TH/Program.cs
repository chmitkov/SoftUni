using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace A_TH
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> words = Console.ReadLine().Split(' ').ToList();
            string[] command = Console.ReadLine().Split().ToArray();
            while (command[0] != "3:1")
            {
                if (command[0] == "merge")
                {
                    var start = int.Parse(command[1]);
                    var end = int.Parse(command[2]);
                    if (start < 0)
                    {
                        start = 0;
                    }
                    if (end >= words.Count)
                    {
                        end = words.Count - 1;
                    }
                    for (int i = start; i < end; i++)
                    {
                        words[start] = words[start] + words[start + 1];
                        words.RemoveAt(start + 1);
                    }

                }
                else if (command[0] == "divide")
                {
                    int index = int.Parse(command[1]);
                    int partitions = int.Parse(command[2]);
                    int numberOfLetters = words[index].Length / partitions;
                    string current = words[index];
                    List<string> divided = new List<string>();
                    for (int i = 0; i < partitions; i++)
                    {
                        divided.Add(current.Substring(0, numberOfLetters));
                        current = current.Substring(0, numberOfLetters);
                    }
                    divided[divided.Count - 1] = divided[divided.Count - 1] + current;
                    words.RemoveAt(index);
                    words.InsertRange(index, divided);
                }
                command = Console.ReadLine().Split().ToArray();
            }
            Console.WriteLine(string.Join(",", words));
        }
    }
}
