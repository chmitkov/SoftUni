using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PF_Exam___05_November_2017_Part_I_02._Anonymous_Threat
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> list = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .ToList();
            var result = new List<string>();
            string input = Console.ReadLine();
            while (input != "3:1")
            {
                string[] commands = input
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                if (commands[0] == "merge")
                {
                    var startIndex = int.Parse(commands[1]);
                    var endIndex = int.Parse(commands[2]);

                    list = Merge(list, startIndex, endIndex);
                }
                else if (commands[0] == "divide")
                {
                    var index = int.Parse(commands[1]);
                    var partitions = int.Parse(commands[2]);

                    list = Divide(list, index, partitions);
                }

                input = Console.ReadLine();
            }

            Console.WriteLine(string.Join(" ", list));
        }

        static int ChangeIndex(int index, int maxLength)
        {
            if (index < 0)
            {
                index = 0;
            }
            else if (index >= maxLength)
            {
                index = maxLength - 1;
            }
            return index;
        }

        static List<string> Merge(List<string> list, int startIndex, int endIndex)
        {
            startIndex = ChangeIndex(startIndex, list.Count);
            endIndex = ChangeIndex(endIndex, list.Count);

            List<string> newList = new List<string>();
            for (int i = 0; i < startIndex; i++)
            {
                newList.Add(list[i]);
            }
            StringBuilder result = new StringBuilder();
            for (int i = startIndex; i <= endIndex; i++)
            {
                result.Append(list[i]);
            }
            newList.Add(result.ToString());
            for (int i = endIndex + 1; i < list.Count; i++)
            {
                newList.Add(list[i]);
            }
            return newList;
        }

        static List<string> Divide(List<string> list, int index, int partitions)
        {
            string element = list[index];
            int partLength = element.Length / partitions;

            List<string> dividedPartitions = new List<string>();
            for (int i = 0; i < partitions; i++)
            {
                if (i == partitions - 1)
                {
                    dividedPartitions.Add(element.Substring(i * partLength));
                }
                else
                {
                    dividedPartitions.Add(element.Substring(i * partLength, partLength));
                }
            }
            list.RemoveAt(index);
            list.InsertRange(index, dividedPartitions);
            return list;
        }
    }
}
