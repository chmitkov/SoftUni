using System;
using System.Collections.Generic;

namespace Dictionaries_LambdaAndLINQ_Exercises_01._Phonebook
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, string>();

            string input = Console.ReadLine();

            while (input != "END")
            {
                string[] commands = input
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

                if (commands[0] == "A")
                {
                    var name = commands[1];
                    var number = commands[2];

                    if (!dict.ContainsKey(name))
                    {
                        dict.Add(name, number);
                    }
                    else
                    {
                        dict[name] = number;
                    }
                }
                else if (commands[0] == "S")
                {
                    var name = commands[1];
                    if (dict.ContainsKey(name))
                    {
                        foreach (var pair in dict)
                        {
                            if (pair.Key == name)
                            {
                                Console.WriteLine($"{pair.Key} -> {pair.Value}");
                            }
                        }
                    }
                    else
                    {
                        Console.WriteLine($"Contact {name} does not exist.");
                    }
                }

                input = Console.ReadLine();
            }

        }
    }
}
