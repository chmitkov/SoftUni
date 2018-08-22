using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MostEqualsChar
{
    class Program
    {
        static void Main(string[] args)
        {
            var maxRepeat = 0;
            
            int[] array = { 4, 1, 1, 4, 2, 3, 4, 4, 1, 2, 4, 9, 3 };
            for (int i = 0; i < array.Length; i++)
            {
                var current = array[i];
                var curRepeat = 0;
                for (int j = 0; j < array.Length; j++)
                {
                    if (current == array[j])
                    {
                        curRepeat++;
                    }
                }
                if (curRepeat > maxRepeat)
                {
                    maxRepeat = curRepeat;
                }
            }
            Console.WriteLine(maxRepeat);
        }
    }
}
