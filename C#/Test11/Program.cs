using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test11
{
    class Program
    {
        static void Main(string[] args)
        {
            int str = int.Parse(Console.ReadLine());
            int num = int.Parse(Console.ReadLine());
            
            int FindNthDigit(int numbers, int index)
            {
                var result = 0;
                while (index >= 1)
                {
                    if (index == 1)
                    {
                       return result =  numbers % 10;
                    }
                    else
                    {
                        numbers /= 10;
                        index--;
                    }
                }
                return result;
            }
            Console.WriteLine(FindNthDigit(str,num));
        }

    }
}
