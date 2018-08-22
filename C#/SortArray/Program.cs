using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SortArray
{
    class Program
    {
        static void Main(string[] args)
        {

            int[] array = { 2,5,6,3,7,1,9,8};
          
            for (int i = 0; i < array.Length; i++)
            {             
                for (int j = 0; j < array.Length-i; j++)
                {
                    if (array[i] > array[i + j])
                    {
                        int big = array[i];
                        array[i] = array[i + j];
                        array[i + j] = big;
                    }
                }
            }
            for (int i = 0; i < array.Length; i++)
            {
                Console.WriteLine("{0}", array[i]);
            }
        }
    }
}
