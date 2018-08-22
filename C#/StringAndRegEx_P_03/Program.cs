using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringAndRegEx_P_03
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] bannWords = Console.ReadLine()
                .Split(new char[] {' ', ',' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            string text = Console.ReadLine();
            foreach(var banWord in bannWords)
            {
                if (text.Contains(banWord))
                {
                    text.Replace(banWord,
                        new string('*', banWord.Length));
                }
            }
            Console.WriteLine(text);
        }
    }
}
