using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace House
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var width = n;
            var stars = 0;
            if (n % 2 ==0)
            {
                stars = 2;
            }
            else
            {
                stars = 1;
            }
            for (int i = 0; i <= n-2; i++)
            {
                Console.WriteLine(new String('-', ((width - stars) / 2 - i)) + new String('*', stars + i * 2)
                   + new String('-', (width - stars) / 2 - i));
            }
            for (int i = 0; i < n/2; i++)
            {
                Console.WriteLine("|" + new String('*', n - 2) + "|");
            }
        }
    }
}
