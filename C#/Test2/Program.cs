using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test2
{
    class Program
    {
        static void Main(string[] args)
        {
            var num = Console.ReadLine();
            string[] stringArr = num.Split();
            int[] array = new int[stringArr.Length];
            for (int i = 0; i < array.Length; i++)
            {
                array[i] = int.Parse(stringArr[i]);
            }
            for (int i = array.Length-1; i >= 0; i--)
            {
                Console.WriteLine(array[i]);
            }
            foreach (var n in array)
            {
                Console.Write(n);
            }
        }
    }
}
