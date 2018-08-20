using System;
using System.Collections.Generic;
using System.Linq;

namespace DIct2
{
    class Lesson
    {
        public string Name { get; set; }
        public string Exersize { get; set; }

        public Lesson(string name, string exersize)
        {
            Name = name;
            Exersize = exersize;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, string>();
            List<string> lessons = Console.ReadLine()
                 .Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries)
                  .Select(x => x.Trim())
                 .ToList();
            List<Lesson> result = new List<Lesson>();
            foreach (var l in lessons)
            {
                result.Add(new Lesson(l, string.Empty));
            }
            string input = Console.ReadLine();


            while (input != "course start")
            {
                string[] commands = input
                    .Split(new char[] { ':' }, StringSplitOptions.RemoveEmptyEntries);

                var action = commands[0].Trim();

                switch (action)
                {
                    case "Add":
                        var lessonToAdd = commands[1].Trim();
                        if (!result.Any(x => x.Name == lessonToAdd))
                        {
                            result.Add(new Lesson(lessonToAdd, string.Empty));
                        }
                        break;
                    case "Insert":
                        var lessonToInsert = commands[1].Trim();
                        int indexToInsert = int.Parse(commands[2].Trim());
                        if (result.Any(x => x.Name == lessonToInsert)==false
                            && indexToInsert >= 0 && indexToInsert < result.Count)
                        {
                            result.Insert(indexToInsert, new Lesson(lessonToInsert, string.Empty));
                        }
                        break;
                    case "Remove":
                        //Problem with list!!!!
                        var lessonToRemove = commands[1].Trim();
                        if (result.Any(x => x.Name == lessonToRemove))
                        {
                            var current = result.Where(x => x.Name == lessonToRemove).FirstOrDefault();
                            result.Remove(current);
                        }
                        break;
                    case "Swap":
                        var lessToSwap1 = commands[1].Trim();
                        var lessToSwap2 = commands[2].Trim();
                        if (result.Any(x => x.Name == lessToSwap1) &&
                            result.Any(x => x.Name == lessToSwap2))
                        {
                            var indexOfless1 = result.IndexOf(result.Where(x => x.Name == lessToSwap1).FirstOrDefault());
                            var indexOfless2 = result.IndexOf(result.Where(x => x.Name == lessToSwap2).FirstOrDefault());
                            var element1 = result.Where(x => x.Name == lessToSwap1).FirstOrDefault();
                            var element2 = result.Where(x => x.Name == lessToSwap2).FirstOrDefault();
                            result[indexOfless1] = element2;
                            result[indexOfless2] = element1;
                            //result.Insert(indexOfless2, element1);
                            //result.RemoveAt(indexOfless2 + 1);
                            //result.Insert(indexOfless1, element2);
                            //result.RemoveAt(indexOfless2+1);
                        }

                        break;
                    case "Exercise":
                        var exerForLesson = commands[1];
                        if (result.Any(x => x.Name == exerForLesson && x.Exersize == string.Empty))
                        {
                            var currEle = result.Where(x => x.Name == exerForLesson && x.Exersize == string.Empty).FirstOrDefault();
                            currEle.Exersize = "Exercise";
                        }
                        else
                        {
                            result.Add(new Lesson(exerForLesson, "Exercise"));
                        }
                        break;
                }
                input = Console.ReadLine();
            }
            var counter = 0;
            foreach (var l in result)
            {
                counter++;
                Console.WriteLine($"{counter}.{l.Name}");
                if (l.Exersize != string.Empty)
                {
                    counter++;
                    Console.WriteLine($"{counter}.{l.Name}-{l.Exersize}");
                }
                
            }
        }
    }
}
