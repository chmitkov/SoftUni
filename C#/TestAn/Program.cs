using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestAn
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> input = Console.ReadLine().
                Split(new char[] { ' ' },
                StringSplitOptions.RemoveEmptyEntries)
                .ToList();
            string[] command = new string[3];
            command = Console.ReadLine().Split(' ').ToArray();
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
                    if (endIndex >= input.Count)
                    {
                        endIndex = input.Count - 1;
                    }
                    for (int i = startIndex; i < endIndex; i++)
                    {
                        input[startIndex]=input[startIndex] + input[startIndex + 1];
                        input.RemoveAt(startIndex + 1);
                    }
                }
                else if (command[0] == "divide")
                {
                    var index = int.Parse(command[1]);
                    var partitions = int.Parse(command[2]);
                    var str = input[index];
                    List<string> divided = new List<string>();
                    for (int i = 0; i < partitions; i++)
                    {
                        divided.Add(str.Substring(0, str.Length / partitions));
                        str.Remove(0, str.Length / partitions);
                    }
                    divided[divided.Count - 1] += str;
                    input.RemoveAt(index);
                    input.InsertRange(index, divided);

                }

                command = Console.ReadLine().Split(' ').ToArray();
            }
            Console.WriteLine(string.Join(" ", input));
        }
    }
}
