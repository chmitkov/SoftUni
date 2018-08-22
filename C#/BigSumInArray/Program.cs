using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BigSumInArray
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = { 2, 3, -6, -1, 2, -1, 6, 4, -8, 8 };
            var sum = int.MinValue ;
            var currentSum = 0;
            for (int i = 0; i < array.Length; i++)
            {
                currentSum = array[i];
                for (int j = i+1; j < array.Length; j++)
                {
                    currentSum += array[j];
                    if (currentSum > sum)
                    {
                        sum = currentSum;
                    }
                }
            }
            Console.WriteLine("{0}", sum);
        }
    }
}
