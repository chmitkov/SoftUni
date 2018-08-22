using System;
using System.Collections.Generic;
using System.Linq;

namespace Exam_Swnowithe
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string,>();
            //int[0] - phisics //List<int>-hats count;

            string input = Console.ReadLine();

            while (input != "Once upon a time")
            {
                string[] commands = input
                    .Split(new char[] { '<', ':', '>', ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();

                var name = commands[0];
                var color = commands[1];
                var phisic = int.Parse(commands[2]);

            }
        }
    }
}
