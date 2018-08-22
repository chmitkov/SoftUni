using System;
using System.Collections.Generic;
using System.Linq;

namespace Exam_Preparation_III_04._Files
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, Dictionary<string, long>>();
            int n = int.Parse(Console.ReadLine());
            while (n-- > 0)
            {
                string[] files = Console.ReadLine()
                    .Split(new char[] { '\\' }, StringSplitOptions.RemoveEmptyEntries);
                var dir = files[0];
                var lastElement = files[files.Length - 1].Split(';');
                var fileName = lastElement[0];
                var fileSize = long.Parse(lastElement[1]);

                if (!dict.ContainsKey(dir))
                {
                    dict.Add(dir, new Dictionary<string, long>());
                    dict[dir].Add(fileName, fileSize);
                }
                else
                {
                    if (!dict[dir].ContainsKey(fileName))
                    {
                        dict[dir].Add(fileName, fileSize);
                    }
                    else
                    {
                        dict[dir][fileName] = fileSize;
                    }
                }
            }
            string[] command = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
            var searchFile = command[0];
            var searchDir = command[2];

            if (dict.ContainsKey(searchDir))
            {
                foreach (var pair in dict[searchDir].OrderByDescending(x=>x.Value)
                    .ThenBy(x=>x.Key))
                {
                    var currSplit = pair.Key.Split('.');
                    var currFileExt = currSplit[currSplit.Length - 1];
                    if (currFileExt == searchFile)
                    {
                        Console.WriteLine($"{pair.Key} - {pair.Value} KB");
                    }
                }

            }
            else
            {
                Console.WriteLine("No");
            }
        }
    }
}
