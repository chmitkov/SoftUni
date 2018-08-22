using System;
using System.Linq;

namespace Arrays_Exercises_09._Index_of_Letters
{
    class Program
    {
        static void Main(string[] args)
        {
            char[] array = Console.ReadLine().ToCharArray();
            for (int i = 0; i < array.Length; i++)
            {
                var ch = array[i].ToString();
                Console.WriteLine($"{ch} -> {(int)array[i]-97}");
            }
        }
    }
}
