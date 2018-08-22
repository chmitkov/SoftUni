using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sunglasses
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var mid = 0;
            String firstAndLastRow = new String('*', n * 2) + new String(' ', n) + new String('*', n * 2);
            Console.WriteLine(firstAndLastRow);
            if (n % 2 == 0)
            {
                mid = n / 2 - 2;
            }
            else
            {
                mid = n / 2-1;
            }

            for (int i = 0; i < n - 2; i++)
            {
                if (i == mid)
                {
                    Console.WriteLine("*" + new String('/', n * 2 - 2) + "*" + new String('|', n)
                    + "*" + new String('/', n * 2 - 2) + "*");
                }
                else
                {
                    Console.WriteLine("*" + new String('/', n * 2 - 2) + "*" + new String(' ', n)
                    + "*" + new String('/', n * 2 - 2) + "*");
                }
                
            }
            Console.WriteLine(firstAndLastRow);
        }
    }
}
