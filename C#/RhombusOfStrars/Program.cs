using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RhombusOfStrars
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                Console.WriteLine(new String(' ', n - 1 - i) + new String('*', i + 1).Replace("*", "* "));//string.Concat(Enumerable.Repeat("* ", i+1)));
            }
            for (int j = 0; j < n-1; j++)
            {
                Console.WriteLine(new String(' ', j + 1) + new String('*', n - 1 - j).Replace("*","* "));
            }
        }
    }
}
