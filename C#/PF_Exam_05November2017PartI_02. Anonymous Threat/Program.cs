using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PF_Exam_05November2017PartI_02._Anonymous_Threat
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
                if (action == "merge")
                {
                    var startIndex = int.Parse(commands[1]);
                    var endIndex = int.Parse(commands[2]);
                    startIndex = IndexChecker(startIndex,words);
                    endIndex = IndexChecker(endIndex, words);
                    words = Merge(words, startIndex, endIndex);

                }
                else if (action == "divide")
                {
                    var index = int.Parse(commands[1]);
                    var partitions = int.Parse(commands[2]);

                    words = Divide(words, index, partitions);
                }
                input = Console.ReadLine();
            }
            Console.WriteLine(string.Join(" ",words));
        }

        private static List<string> Divide(List<string> words, int index, int partitions)
        {
            var currList = new List<string>();
            string str = words[index];
            var part = str.Length / partitions;
            for (int i = 0; i < partitions; i++)
            {
                if (i == partitions - 1)
                {
                    currList.Add(str.Substring(i * part));
                }
                else
                {
                    currList.Add(str.Substring(i * part, part));
                }
            }
            words.RemoveAt(index);
            words.InsertRange(index, currList);
            return words;
        }

        private static List<string> Merge(List<string>words, int startIndex, int endIndex)
        {
            StringBuilder str = new StringBuilder();
            for (int i = startIndex; i <= endIndex; i++)
            {
                str .Append(words[i]);
            }
            words.RemoveRange(startIndex, endIndex - startIndex+1);
            words.Insert(startIndex, str.ToString());
            return words;
        }

        private static int IndexChecker(int startIndex, List<string> words)
        {
            if (startIndex < 0)
            {
                return 0;
            }
            else if (startIndex >= words.Count)
            {
                return (words.Count - 1);
            }
            else
            {
                return startIndex;
            }

        }
    }
}
