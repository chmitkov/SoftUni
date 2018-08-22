using System;
using System.Linq;

namespace PF_Exam_Preparation_II_02._Ladybugs
{
    class Program
    {
        static void Main(string[] args)
        {
            int fieldLength = int.Parse(Console.ReadLine());
            int[] field = new int[fieldLength];
            int[] ladybugsIndex = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            foreach (var index in ladybugsIndex)
            {
                field[index] = 1;
            }
            string input = Console.ReadLine();
            while (input != "end")
            {
                string[] commands = input
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                var startIndex = int.Parse(commands[0]);
                var direction = commands[1];
                var flyLength = int.Parse(commands[2]);

                if (!(field[startIndex] == 0 || startIndex < 0 
                    || startIndex >= field.Length))
                {
                    var currBug = field[startIndex];
                    field[startIndex] = 0;
                    var nextBugStopIndex = 0;
                    if (direction == "right")
                    {
                        nextBugStopIndex = startIndex + fieldLength;
                        while (true)
                        {
                            if (nextBugStopIndex >= field.Length)
                            {
                                break;
                            }
                            else if (field[nextBugStopIndex] == 1)
                            {
                                nextBugStopIndex += flyLength;
                            }
                            else if (field[nextBugStopIndex]== 0)
                            {
                                field[nextBugStopIndex] = 1;
                                break;
                            }
                        }
                    }
                    else
                    {
                        nextBugStopIndex = startIndex - flyLength;
                        while (true)
                        {
                            if (nextBugStopIndex < 0)
                            {
                                break;
                            }
                            else if (field[nextBugStopIndex] == 1)
                            {
                                nextBugStopIndex -= flyLength;
                            }
                            else if (field[nextBugStopIndex] == 0)
                            {
                                field[nextBugStopIndex] = 1;
                                break;
                            }
                        }
                    }
                    
                }
                input = Console.ReadLine();
            }
            Console.WriteLine(string.Join(" ",field));

        }
    }
}
