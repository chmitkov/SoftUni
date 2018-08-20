using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam2016April24_2GameOfNames
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            var name = "";
            var bestName = "";
            var score = 0;
            var bestScore = 0;
            for (int i = 0; i < n; i++)
            {
                name = Console.ReadLine();
                score = int.Parse(Console.ReadLine());
                for (int j = 0; j < name.Length; j++)
                {
                    var current = (int)name[j];
                    if (current % 2 == 0)
                    {
                        score += current;
                    }
                    else
                    {
                        score -= current;
                    }
                }
                if (score > bestScore)
                {
                    bestScore = score;
                    bestName = name;
                }
            }
            Console.WriteLine($"The winner is {bestName} - {bestScore} points");
        }
    }
}
