using System;
using System.Linq;

namespace Lists_Exercises_06._Sum_Reversed_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            var sum = 0;
           
            for (int i = 0; i < input.Length; i++)
            {
                var currentNum = string.Empty;
                for (int j = input[i].Length - 1; j >= 0; j--)
                {
                    currentNum += input[i][j].ToString();
                }
                sum += int.Parse(currentNum);
            }
            Console.WriteLine(sum);
        }
    }
}
