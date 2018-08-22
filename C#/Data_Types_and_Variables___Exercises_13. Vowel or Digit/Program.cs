using System;
using System.Collections.Generic;

namespace Data_Types_and_Variables___Exercises_13._Vowel_or_Digit
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> vowels = new List<string> { "a", "o", "u", "e", "i" };
            List<string> nums = new List<string> { "0","1", "2", "3", "4", "5", "6", "7", "8", "9", };
            string input = Console.ReadLine();
            if (vowels.Contains(input))
            {
                Console.WriteLine("vowel");
            }
            else if (nums.Contains(input))
            {
                Console.WriteLine("digit");
            }
            else
            {
                Console.WriteLine("other");
            }
        }
    }
}
