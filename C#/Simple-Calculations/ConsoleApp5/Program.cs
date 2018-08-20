using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Project
{
    class Program
    {
        static void Main(String[] args)
        {
            var r = int.Parse(Console.ReadLine());
            var area = Math.PI * Math.Pow(r, 2);
            var perimeter = 2 * Math.PI * r;
            Console.WriteLine("Area= {0}\nPeripeter: {1}", area, perimeter);
        }
    }
}