using System;
using System.Collections.Generic;
using System.Linq;

namespace Exam_Problem_02
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> lessons = Console.ReadLine()
                 .Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries)
                 .Select(x=>x.Trim())
                 .ToList();
            List<string> exersise = new List<string>();
            string input = Console.ReadLine();

            while (input != "course start")
            {
                string[] commands = input
                    .Split(new char[] { ':' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();

                var action = commands[0].Trim();

                switch (action)
                {
                    case "Add":
                        var lessonToAdd = commands[1].Trim();
                        if (!lessons.Contains(lessonToAdd))
                        {
                            lessons.Add(lessonToAdd);
                        }
                        break;
                    case "Insert":
                        var lessonToInsert = commands[1].Trim();
                        int indexToInsert = int.Parse(commands[2].Trim());
                        if (!lessons.Contains(lessonToInsert)
                            && indexToInsert >= 0 && indexToInsert < lessons.Count)
                        {
                            lessons.Insert(indexToInsert, lessonToInsert);
                        }
                        break;
                    case "Remove":
                        //Problem with list!!!!
                        var lessonToRemove = commands[1].Trim();
                        if (lessons.Contains(lessonToRemove))
                        {
                            lessons.Remove(lessonToRemove);
                        }
                        break;
                    case "Swap":
                        var lessonToSwap1 = commands[1].Trim();
                        var lessonToSwap2 = commands[2].Trim();
                        if (lessons.Contains(lessonToSwap1) && lessons.Contains(lessonToSwap2))
                        {
                            var index1 = lessons.IndexOf(lessonToSwap1);
                            var index2 = lessons.IndexOf(lessonToSwap2);
                            var current = lessonToSwap1;
                            lessons[index1] = lessonToSwap2;
                            lessons[index2] = current;
                        }
                        break;
                    case "Exercise":
                        var exersiseForLesson = commands[1].Trim();
                        if (lessons.Contains(exersiseForLesson)
                            && (!exersise.Contains(exersiseForLesson)))
                        {
                            exersise.Add(exersiseForLesson);
                        }
                        break; 
                }
                input = Console.ReadLine();
            }
            var counter = 0;
            foreach (var less in lessons)
            {
                counter++; 
                var currentEx = string.Empty;
                if (exersise.Contains(less))
                {
                    currentEx = "-Exercise";
                    Console.WriteLine($"{counter}.{less}");
                    counter++;
                }
                
                Console.WriteLine($"{counter}.{less}{currentEx}");
            }
        }
    }
}
