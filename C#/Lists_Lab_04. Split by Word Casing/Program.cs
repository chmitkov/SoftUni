using System;
using System.Collections.Generic;
using System.Linq;

namespace Lists_Lab_04._Split_by_Word_Casing
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] text = Console.ReadLine()
                .Split(new char[] { ' ', ',', ';', ':', '.', '!', '(', ')', '"', '\'', '\\', '/', '[', ']' }
                , StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            List<string> upperList = new List<string>();
            List<string> lowerList = new List<string>();
            List<string> mixedList = new List<string>();
            foreach (var word in text)
            {
                bool isLower = true;
                bool isUpper = true;
                for (int i = 0; i < word.Length; i++)
                {
                    if (Char.IsUpper(word[i]))
                    {
                        isLower = false;
                    }
                    else if (Char.IsLower(word[i]))
                    {
                        isUpper = false;
                    }
                    else
                    {
                        isLower = false;
                        isUpper = false;
                    }

                }
                if (isUpper)
                {
                    upperList.Add(word);
                }
                else if (isLower)
                {
                    lowerList.Add(word);
                }
                else
                {
                    mixedList.Add(word);
                }
            }
            Console.WriteLine($"Lower-case: {string.Join(", ", lowerList)}");
            Console.WriteLine($"Mixed-case: {string.Join(", ", mixedList)}");
            Console.WriteLine($"Upper-case: {string.Join(", ", upperList)}");

        }
    }
}
