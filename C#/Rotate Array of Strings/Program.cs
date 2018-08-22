using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Rotate_Array_of_Strings
{
    class Program
    {
        static void Main(string[] args)
        {
            var str = Console.ReadLine().Split(' ').ToArray();
            string[] arr = new string[str.Length];
            for (int i = 0; i < str.Length-1; i++)
            {
                arr[i + 1] = str[i];
            }
            arr[0] = str[str.Length - 1];
            Console.WriteLine(string.Join(",",arr));
        }
    }
}
