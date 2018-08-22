using System;
using System.Collections.Generic;
using System.Linq;

namespace Lists_Exercises_05._Array_Manipulator
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

            while (input != "print")
            {
                string[] commands = input
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                var action = commands[0];

                switch (action)
                {
                    case "add":
                        var index = int.Parse(commands[1]);
                        var element = int.Parse(commands[2]);
                        list.Insert(index, element);
                        break;
                    case "addMany":
                        var ind = int.Parse(commands[1]);
                        int[] seq = input.Split().Select(int.Parse).Skip(2).ToArray();
                        list.InsertRange(ind, seq);
                        break;
                    case "contains":
                        var el = int.Parse(commands[1]);
                        if (!list.Contains(el))
                        {
                            Console.WriteLine("-1");
                        }
                        else
                        {
                            for (int i = 0; i < list.Count; i++)
                            {
                                if (list[i] == el)
                                {
                                    Console.WriteLine(i);
                                    break;
                                }
                            }
                        }
                        break;
                    case "remove":
                        var ind1 = int.Parse(commands[1]);
                        list.RemoveAt(ind1);
                        break;
                    case "shift":
                        var position = int.Parse(commands[1]);
                        if (list.Count > 1)
                        {
                            int[] currArr = new int[list.Count];
                            while (position-- > 0)
                            {
                                var current = list[0];
                                for (int i = 0; i < currArr.Length - 1; i++)
                                {
                                    currArr[i] = list[i + 1];
                                }
                                currArr[currArr.Length - 1] = current;
                                list = currArr.ToList();
                            }
                        }
                        break;
                    case "sumPairs":
                        for (int i = 0; i < list.Count - list.Count % 2; i += 2)
                        {
                            list[i] += list[i + 1];
                            list[i + 1] = -1;
                        }
                        list.RemoveAll(x => x == -1);
                        break;

                }
                input = Console.ReadLine();
            }
            Console.Write("[");
            for (int i = 0; i < list.Count; i++)
            {
                if (i != list.Count - 1)
                {
                    Console.Write(list[i] + ", ");
                }
                else
                {
                    Console.Write(list[i]);
                }
            }
            Console.Write("]");
        }
    }
}
