using System;
using System.Collections.Generic;
using System.Linq;

namespace StringsAndTextProcessing_Lab_04._Palindromes
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] words = Console.ReadLine()
                .Split(new char[] { ' ', ',', '!', '?','.',':' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            List<string> result = new List<string>();
            foreach (var word in words)
            {
                if (word.Length == 1)
                {
                    result.Add(word);
                }
                else
                {
                    if (IsPalindrome(word))
                    {
                        result.Add(word);
                    }
                }
                
            }
            
            Console.WriteLine(string.Join(", ", result.OrderBy(x => x).Distinct()));
        }

         static bool IsPalindrome(string word)
        {
            for (int i = 0; i < word.Length/2; i++)
            {
                if (word[i] != word[word.Length -1- i])
                {
                    return false;
                }
            }
            return true;
        }
    }
}
