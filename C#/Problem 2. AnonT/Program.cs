using System;
using System.Collections.Generic;
using System.Linq;

namespace Problem_2._AnonT
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> words = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .ToList();
            string input = Console.ReadLine();

            while (input != "3:1")
            {
                string[] commands = input
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

                var action = commands[0];

                switch (action)
                {
                    case "merge":
                        var startIndex = int.Parse(commands[1]);
                        var endIndex = int.Parse(commands[2]);
                        if (endIndex < 0
                            || startIndex >= words.Count - 1)
                        {
                            break;
                        }
                        if (startIndex < 0)
                        {
                            startIndex = 0;
                        }
                        if (endIndex >= words.Count)
                        {
                            endIndex = words.Count - 1;
                        }
                        words = Merge(startIndex, endIndex, words);
                        break;
                    case "divide":
                        var index = int.Parse(commands[1]);
                        var partitions = int.Parse(commands[1]);

                        words = Divide(index, partitions, words);
                        break;
                }


                input = Console.ReadLine();
            }
            Console.WriteLine(string.Join(" ", words));
        }

        private static List<string> Divide(int index, int partitions, List<string> words)
        {
            var part = words[index].Length / partitions;
            var str = words[index];
            var currList = new List<string>();
            for (int i = 0; i < partitions; i++)
            {
                if (str.Length %2 == 1 && i==partitions-1)
                {
                    currList.Add(str);
                }
                else
                {
                    currList.Add(str.Substring(0, part));
                    str = str.Substring(part);
                }
            }
            words.RemoveAt(index);
            words.InsertRange(index, currList);
            return words;
        }

        private static List<string> Merge(int startIndex, int endIndex, List<string> words)
        {
            var currStr = string.Empty;
            for (int i = startIndex; i <= endIndex; i++)
            {
                currStr += words[i];
            }
            words.RemoveRange(startIndex, endIndex - startIndex + 1);
            words.Insert(startIndex, currStr);
            return words;
        }
    }
}
