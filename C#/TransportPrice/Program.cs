using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TransportPrice
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var time = Console.ReadLine().ToLower();
            var total = 0.0;
            if (n < 20)
            {
                if (time == "day")
                {
                    total = n * 0.79 + 0.7;
                }
                else
                {
                    total = n * 0.9 + 0.7;
                }
            }
            else if (n < 100)
            {
                total = n * 0.09;
            }
            else
            {
                total = n * 0.06;
            }
            Console.WriteLine(total);
        }
    }
}
