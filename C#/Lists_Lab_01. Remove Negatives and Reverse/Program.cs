using System;
using System.Linq;

namespace Lists_Lab_01._Remove_Negatives_and_Reverse
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .Where(x => x > 0)
                .Reverse()
                .ToArray();
            Console.WriteLine(array.Length>0? string.Join(" ", array)
                : "empty");
        }
    }
}
