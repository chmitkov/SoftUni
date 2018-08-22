using System;
using System.Linq;

namespace PF_Exam_I___June_2016_02._Array_Modifier
{
    class Program
    {
        static void Main(string[] args)
        {
            long[] array = Console.ReadLine()
                 .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                 .Select(long.Parse)
                 .ToArray();
            string command = Console.ReadLine();
            while (command != "end")
            {
                string[] commands = command
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                
                if (commands[0] == "swap")
                {
                    var index1 = long.Parse(commands[1]);
                    var index2 = long.Parse(commands[2]);
                    var current = array[index1];
                    array[index1] = array[index2];
                    array[index2] = current;
                    
                }
                else if (commands[0] == "multiply")
                {
                    var index1 = long.Parse(commands[1]);
                    var index2 = long.Parse(commands[2]);
                    array[index1] = array[index1] * array[index2];
                }
                else if (commands[0] == "decrease")
                {
                    for (long i = 0; i < array.Length; i++)
                    {
                        array[i]--;
                    }
                }
                command = Console.ReadLine();
            }
            Console.WriteLine(string.Join(", ",array));

        }
    }
}
