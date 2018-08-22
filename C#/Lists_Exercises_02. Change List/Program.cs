using System;
using System.Collections.Generic;
using System.Linq;

namespace Lists_Exercises_02._Change_List
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> list = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToList();

            string input = Console.ReadLine();
            while (input != "Even" && input != "Odd")
            {
                string[] commands = input
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                var action = commands[0];
                switch (action)
                {
                    case "Delete":
                        var element = int.Parse(commands[1]);
                        for (int i = 0; i < list.Count; i++)
                        {
                            if (list[i] == element)
                            {
                                list.RemoveAt(i);
                                i--;
                            }
                        }
                        break;
                    case "Insert":
                        var position = int.Parse(commands[2]);
                        var element1 = int.Parse(commands[1]);
                        list.Insert(position, element1);
                        break;
                }
                input = Console.ReadLine();
            }
            if (input == "Even")
            {
                for (int i = 0; i < list.Count; i++)
                {
                    if (list[i] % 2 == 0)
                    {
                        Console.Write(list[i] + " ");
                    }
                }
            }
            else
            {
                for (int i = 0; i < list.Count; i++)
                {
                    if (list[i] % 2 != 0)
                    {
                        Console.Write(list[i] + " ");
                    }
                }
            }
        }
    }
}
