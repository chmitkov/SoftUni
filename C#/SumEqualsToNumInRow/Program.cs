using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SumEqualsToNumInRow
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            var start = 0;
            var end = 0;
            
            int[] array = { 4, 3, 1, 4, 2, 5, 8 };
            for (int i = 0; i < array.Length-1; i++)
            {
                var sum = array[i];
                for (int j = i+1; j < array.Length; j++)
                {
                    sum += array[j];
                    if (sum == n)
                    {
                        start = i;
                        end = j;

                    }
                }
            }
            for (int i = start; i <= end; i++)
            {
                Console.WriteLine("{0} ", array[i]);
            }
        }
    }
}
