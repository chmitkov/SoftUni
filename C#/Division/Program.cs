using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Division
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            double p1 = 0;
            double p2 = 0;
            double p3 = 0;
            for (int i = 0; i < n; i++)
            {
                var num = int.Parse(Console.ReadLine());
                if (num % 4 == 0)
                {
                    p3++;
                }
                if (num % 3 == 0)
                {
                    p2++;
                } 
                if (num % 2 == 0)
                {
                    p1++;
                }
            }
            Console.WriteLine("{0:P}\n{1:P}\n{2:P}", p1 / n, p2 / n, p3 / n);
        }
    }
}
