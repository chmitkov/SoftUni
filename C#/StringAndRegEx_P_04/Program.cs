using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringAndRegEx_P_04
{
    class Program
    {
        static bool IsPalindrome(string text)
        {
            bool palindrome = true;
            for (int i = 0; i < text.Length / 2; i++)
            {
                if (text[i] != text[text.Length - 1 - i])
                {
                    palindrome = false;                  
                }               
            }
            return palindrome;
        }
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine()
                .Split(new char[] { ' ', ',', '!', '?' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            List<string> pals = new List<string>();
            for (int i = 0; i < input.Length; i++)
            {

                if (IsPalindrome(input[i]))
                {
                    pals.Add(input[i]);
                }
            }
            pals.Sort();
            Console.WriteLine(string.Join(",",pals));
        }
    }
}
