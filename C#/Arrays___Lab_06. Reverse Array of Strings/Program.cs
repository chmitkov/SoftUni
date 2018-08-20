using System;
using System.Linq;

namespace Arrays___Lab_06._Reverse_Array_of_Strings
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] str = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            Console.WriteLine(string.Join(" ",str.Reverse()));
        }
    }
}
