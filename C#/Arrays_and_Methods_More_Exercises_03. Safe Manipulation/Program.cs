using System;
using System.Linq;

namespace Arrays_and_Methods_More_Exercises_03._Safe_Manipulation
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] array = Console.ReadLine()
                 .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                 .ToArray();

            string input = Console.ReadLine();
            while (input != "END")
            {

                string[] commands = input
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();

                if (commands[0] == "Reverse")
                {
                    string[] current = new string[array.Length];
                    for (int j = 0; j < current.Length; j++)
                    {
                        current[current.Length - 1 - j] = array[j];
                    }
                    array = current;
                }
                else if (commands[0] == "Distinct")
                {
                    array = array.Distinct().ToArray();
                }
                else if (commands[0] == "Replace")
                {
                    var index = int.Parse(commands[1]);
                    var strForReplace = commands[2];
                    if (index < 0 || index >= array.Length)
                    {
                        Console.WriteLine("Invalid input!");
                    }
                    else
                    {
                        for (int j = 0; j < array.Length; j++)
                        {
                            if (j == index)
                            {
                                array[j] = strForReplace;
                            }
                        }
                    }
                }
                else
                {
                    Console.WriteLine("Invalid input!");
                }
                input = Console.ReadLine();
            }
            Console.WriteLine(string.Join(", ", array));
        }
    }
}
