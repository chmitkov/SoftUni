using System;
using System.Linq;

namespace Dictionaries_LambdaAndLINQ_Lab_05._Short_Words_Sorted
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] array = Console.ReadLine()
                .ToLower()
                .Split(new char[] { ' ', ',', '.', ':', ';', '(', ')', '[', ']', '"', '\'', '\\', '/', '!', '?' }, StringSplitOptions.RemoveEmptyEntries)
                .Where(x => x.Length < 5)
                .Distinct()
                .OrderBy(x => x)
                .ToArray();

            Console.WriteLine(string.Join(", ",array));
                
        }
    }
}
