using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace A_Threat
{
    class Program
    {
        static void Main(string[] args)
        {

            List<string> words = Console.ReadLine().Split(' ').ToList();
            string[] command = Console.ReadLine().Split(' ').ToArray();
            while (command[0] != "3:1")
            {
                if (command[0] == "merge")
                {
                    var startIndex = int.Parse(command[1]);
                    var endIndex = int.Parse(command[2]);
                    if (startIndex < 0)
                    {
                        startIndex = 0;
                    }
                    if (endIndex >= words.Count)
                    {
                        endIndex = words.Count - 1;
                    }
                    for (int i = startIndex; i < endIndex; i++)
                    {
                        words[startIndex] += words[startIndex + 1];
                        words.RemoveAt(startIndex + 1);
                    }
                }  
                else if (command[0] == "divide")
                {
                    var index = int.Parse(command[1]);
                    var partitions = int.Parse(command[2]);
                    var current = words[index];
                    var part = current.Length / partitions;
                    List<string> divided = new List<string>();
                    for (int i = 0; i < partitions; i++)
                    {
                        divided.Add(current.Substring(0, part));
                        current.Remove(0, part);
                    }
                    divided[divided.Count-1]+=current;
                    words.RemoveAt(index);
                    words.InsertRange(index, divided);
                }

                command = Console.ReadLine().Split(' ').ToArray();

            }
            Console.WriteLine(string.Join(" ",words)); 
        }
    }
}
