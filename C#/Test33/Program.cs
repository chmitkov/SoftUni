using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test33
{
    class Program
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine()
            .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(int.Parse)
            .ToList();
            var k = input.Count / 4;
            var array1 = new List<int>();
            var array2 = new List<int>();
            var tempArr = new List<int>();
            tempArr.AddRange(input.Take(k));
            tempArr.Reverse();
            array1.AddRange(tempArr);
            tempArr.Clear();
            tempArr.AddRange(input.Skip(3 * k).Take(k));
            tempArr.Reverse();
            array1.AddRange(tempArr);
            tempArr.Clear();
            array2.AddRange(input.Skip(k).Take(2 * k));
            for (int i = 0; i < array1.Count; i++)
            {
                tempArr.Add(array1[i] + array2[i]);
            }
            Console.WriteLine(string.Join(" ",tempArr));

        }
    }
}
