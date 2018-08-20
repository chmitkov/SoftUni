using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam_Preparation_III__02._Command_Interpreter
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> list = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .ToList();
            string input = Console.ReadLine();
            while (input != "end")
            {
                string[] commands = input
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();



                switch (commands[0])
                {
                    case "reverse":
                        ReverseList(list, int.Parse(commands[2]), int.Parse(commands[4]));
                        break;
                    case "sort":
                        SortList(list, int.Parse(commands[2]), int.Parse(commands[4]));
                        break;
                    case "rollLeft":
                        RollLeftList(list, int.Parse(commands[1]));
                        break;
                    case "rollRight":
                        RollRightList(list, int.Parse(commands[1]));
                        break;
                }


                input = Console.ReadLine();
            }
            Console.WriteLine(string.Join("", list));
        }

        static void RollLeftList(List<string> list, int v)
        {
           
            var currentList = new List<string>();
            for (int j = 0; j < v; j++)
            {
                currentList[list.Count-1] = list[0];
                for (int i = list.Count - 1; i > 0 ; i--)
                {
                    currentList[i - 1] = list[i];
                }
            }
            list.Clear();
            list.AddRange(currentList);           
        }

        static void RollRightList(List<string> list, int v)
        {
            var currentList = new List<string>();
            for (int j = 0; j < v; j++)
            {
                currentList[0] = list[list.Count - 1];
                for (int i = 0; i < list.Count-1; i++)
                {
                    currentList[i + 1] = list[i];
                }
            }
            list.Clear();
            list.AddRange(currentList);          
        }

        static void SortList(List<string> list, int v1, int v2)
        {
            if (v1 >= list.Count || v1 < 0 || v1 + v2 >= list.Count)
            {
                Console.WriteLine("Invalid input parameters.");
            }
            else
            {
                var currentList = new List<string>();
                currentList.AddRange(list.Skip(v1).Take(v2));
                currentList.Sort();
                var listToReturn = new List<string>();
                listToReturn.AddRange(list.Take(v1));
                listToReturn.AddRange(currentList);
                listToReturn.AddRange(list.Skip(v1 + currentList.Count));
                list.Clear();
                list.AddRange(listToReturn);
            }
            
        }
        static void ReverseList(List<string> list, int v1, int v2)
        {
            if (v1 >= list.Count || v1 < 0 || v1 + v2 >= list.Count)
            {
                Console.WriteLine("Invalid input parameters.");
            }
            else
            {
                var currentList = new List<string>();
                currentList.AddRange(list.Skip(v1).Take(v2));
                currentList.Reverse();
                var listToReturn = new List<string>();
                listToReturn.AddRange(list.Take(v1));
                listToReturn.AddRange(currentList);
                listToReturn.AddRange(list.Skip(v1 + currentList.Count));
                list.Clear();
                list.AddRange(listToReturn);
            }
        }
    }
}
