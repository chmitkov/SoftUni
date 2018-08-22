using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test5
{
    class Program
    {
        static void Main(string[] args)
        {
            double n = double.Parse(Console.ReadLine());
            double m = double.Parse(Console.ReadLine());
            
            Console.WriteLine(S(n,m));
        }
        static double S(double a, double ha)
        {
            var s = (a * ha) / 2.0;
            return s;
         }
    }
}
