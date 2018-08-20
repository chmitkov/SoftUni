using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Wormtest
{
    class Program
    {
        static void Main(string[] args)
        {
            int wormsLength = int.Parse(Console.ReadLine());
            double wormsWidth = double.Parse(Console.ReadLine());

            wormsLength *= 100;
            var reminder = wormsLength % wormsWidth;
            if (reminder == 0 || wormsWidth == 0)
            {
                Console.WriteLine("{0:F2}", wormsLength * wormsWidth);
            }
            else
            {
                Console.WriteLine("{0:P}", wormsLength / wormsWidth);
            }
        }
    }
}
