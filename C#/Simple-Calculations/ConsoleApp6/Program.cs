using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RectangleS
{
    class Program
    {
        static void Main(String[] args)
        {
            var x1 = double.Parse(Console.ReadLine());
            var y1 = double.Parse(Console.ReadLine());
            var x2 = double.Parse(Console.ReadLine());
            var y2 = double.Parse(Console.ReadLine());

            var s = (Math.Abs(x1 - x2) * Math.Abs(y1 - y2));
            var p = 2 * (Math.Abs(x1 - x2) + Math.Abs(y1 - y2));
            Console.WriteLine(s + "\n" + p);

        }
            }
}
