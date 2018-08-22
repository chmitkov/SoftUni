using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DictionariesP06
{
    class Program
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            var n = input.Length / 2;
            var array1 = input.Skip(n / 2).Take(n).ToList();
            var array2 = input.Take(n/2).ToList();
            array2.Reverse();
            var array3 = input.Skip(n / 2 + n).Reverse();
            array2.AddRange(array3);
            Console.WriteLine(string.Join(" ", array1));
            Console.WriteLine(string.Join(" ", array2));
            var result = new List<int>();
            for (int i = 0; i < n; i++)
            {
                result.Add(array1[i] + array2[i]);
            }
            Console.WriteLine(string.Join(" ", result));
        }
    }
}
