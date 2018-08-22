using System;
using System.Linq;


namespace Dictionaries_LambdaAndLINQ_Lab_04._Largest_3_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .OrderByDescending(x => x)
                .Take(3)
                .ToArray();
            Console.WriteLine(string.Join(" ",nums));
        }
    }
}
