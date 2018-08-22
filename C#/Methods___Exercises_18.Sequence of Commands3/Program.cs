using System;
using System.Linq;

namespace Methods___Exercises_18.Sequence_of_Commands3
{
    class Program
    {
        static void Main(string[] args)
        {
            int sizeOfArray = int.Parse(Console.ReadLine());

            long[] array = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(long.Parse)
                .ToArray();
            string command = Console.ReadLine();
            while (command != "stop")
            {
                string[] commands = command
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();

                if (commands.Length == 1)
                {
                    var com = commands[0];
                    if (com == "rshift")
                    {
                        ArrayShiftRight(array);
                    }
                    else
                    {
                        ArrayShiftLeft(array);
                    }
                    Console.WriteLine(string.Join(" ", array));
                }
                else
                {
                    var com = commands[0];
                    var index = int.Parse(commands[1]);
                    var value = int.Parse(commands[2]);

                    switch (com)
                    {
                        case "add":
                            array[index - 1] = array[index - 1] + value;
                            break;
                        case "subtract":
                            array[index - 1] = array[index - 1] - value;
                            break;
                        case "multiply":
                            array[index - 1] = array[index - 1] * value;
                            break;
                    }
                    Console.WriteLine(string.Join(" ", array));
                }

                command = Console.ReadLine();
            }
           // Console.WriteLine(string.Join(" ",array));
        }
         static void ArrayShiftLeft(long[] array)
        {
            var current = array[0]; 
            for (int i = 0; i < array.Length - 1; i++)
            {
                array[i] = array[i + 1];
            }
            array[array.Length-1] = current;
        }

         static void ArrayShiftRight(long[] array)
        {
            var current = array[array.Length-1];
            for (int i = array.Length - 1; i >= 1; i--)
            {
                array[i] = array[i - 1];
            }
            array[0] = current;
        }
    }
}
