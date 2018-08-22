using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MaxIncreseRow
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Dyljina na masiv");
            int n = int.Parse(Console.ReadLine());
            int[] array = new int[n];
            Console.WriteLine("Stoinosti na masiva");
            for (int i = 0; i < array.Length; i++)
            {                
                int num = int.Parse(Console.ReadLine());
                array[i] = num;
            }
            var count = 1;
            var current = array[0];
            for (int i = 1; i < array.Length; i++)
            {
                if (array[i] == current + 1)
                {
                    count++;
                }
                current = array[i];
            }
            Console.WriteLine(count);
        }
    }
}
