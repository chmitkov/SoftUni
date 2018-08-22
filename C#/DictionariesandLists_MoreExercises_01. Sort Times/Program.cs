using System;
using System.Collections.Generic;
using System.Linq;

namespace DictionariesandLists_MoreExercises_01._Sort_Times
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> list = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .OrderBy(x => x)
                .ToList();
            Console.WriteLine(string.Join(", ",list));
        }
    }
}
