using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test6
{
    class Program
    {
        static void Main(string[] args)
        {
            double  n = double.Parse(Console.ReadLine());
            int m  = int.Parse(Console.ReadLine());
            Console.WriteLine(Pow(n,m));
        }
        static double Pow(double a, int b)
        {
             
            var sum = a;
            for (int i = 1; i < b; i++)
            {
                sum*=a;
                 
            }
            return sum;
        }
    }
}
