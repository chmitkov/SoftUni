using System;
using System.Linq;

namespace PF_Exam_Part1_23October2016_02._Ladybugs
{
    class Program
    {
        static void Main(string[] args)
        {
            int fieldSize = int.Parse(Console.ReadLine());
            int[] indexes = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            int[] ladyBugs = new int[fieldSize];
            for (int i = 0; i < indexes.Length; i++)
            {
                if (indexes[i] >= 0 && indexes[i] < ladyBugs.Length)
                {
                    ladyBugs[indexes[i]] = 1;
                }
            }
            string input = Console.ReadLine();
            while (input != "end")
            {
                string[] commands = input
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

                var ladyIndex = int.Parse(commands[0]);
                var direction = commands[1];
                var flightLength = int.Parse(commands[2]);
                if (ladyIndex >= 0 && ladyIndex < ladyBugs.Length
                    && ladyBugs[ladyIndex] != 0)
                {
                    ladyBugs[ladyIndex] = 0;
                    if (direction == "right")
                    {
                        var endIndex = ladyIndex + flightLength;
                        while (endIndex < ladyBugs.Length)
                        {
                            if (ladyBugs[endIndex] == 0)
                            {
                                ladyBugs[endIndex] = 1;
                                break;
                            }
                            else
                            {
                                endIndex += flightLength;
                            }
                        }
                    }
                    else
                    {
                        var endIndex = ladyIndex - flightLength;
                        while (endIndex >= 0)
                        {
                            if (ladyBugs[endIndex] == 0)
                            {
                                ladyBugs[endIndex] = 1;
                                break;
                            }
                            else
                            {
                                endIndex -= flightLength;
                            }
                        }
                    }
                }
                input = Console.ReadLine();
            }
            Console.WriteLine(string.Join(" ", ladyBugs));
        }
    }
}

