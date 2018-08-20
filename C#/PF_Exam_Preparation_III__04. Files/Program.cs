using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam_Preparation_III__04._Files
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            var dict = new Dictionary<string, Dictionary<string, List<string>>>();
            for (int i = 0; i < n; i++)
            {
                string[] commands = Console.ReadLine()
                    .Split(new char[] { '\\' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                var root = commands[0];
                var allStr = commands[commands.Length - 1];
                var fileAndSize = allStr
                    .Split(new char[] {';','.'},StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                var fileName = fileAndSize[0];
                var fileExtention = fileAndSize[1]; 
                var fileSize = long.Parse(fileAndSize[2]);
                if (!dict.ContainsKey(root))
                {
                    dict[root] = new Dictionary<string, List<string>>();
                }
                if (!dict[root].ContainsKey(fileExtention))
                {
                    dict[root][fileExtention] = new List<string>();
                }
                dict[root][fileExtention].Add(allStr);
                dict[root][fileExtention].Distinct();
            }
            string[] needed = Console.ReadLine().Split(' ').ToArray();
            string neededExtention = needed[0];
            string neededRoot = needed[2];

        }
    }
}
