using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n / 2; i++)
            {
                Console.WriteLine(new string(' ', i) + "x" + new string(' ', (n - 2) - 2 * i)
                    + "x" + new string(' ', i));
            }
            Console.WriteLine(new string(' ', n / 2) + "x" + new string(' ', n / 2));
            for (int i = 0; i < n / 2; i++)
            {
                Console.WriteLine(new string(' ', (n - 3) / 2 - i) + "x" + new string(' ', 2 * i + 1)
                    + "x" + new string(' ', (n - 3) / 2 - i));
            }
        }
    }
}
