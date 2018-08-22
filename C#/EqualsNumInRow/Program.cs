using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EqualsNumInRow
{
    class Program
    {
        static void Main(string[] args)
        {
            //  int n = int.Parse(Console.ReadLine());
            //  int[] array = new int[n];
            //  for (int i = 0; i < array.Length; i++)
            //  {
            //      int num = int.Parse(Console.ReadLine());
            //      array[i] = num;           
            //  }
            int[] array = { 0, 2, 4, 4, 4, 6, 7 }; 
            int count = 1;
            var current = array[0];
            for (int i = 1; i < array.Length; i++)
            {
               
                if (array[i] == current)
                {
                    count++;
                }
                current = array[i];
            }
            Console.WriteLine(count);
        }
    }
}
