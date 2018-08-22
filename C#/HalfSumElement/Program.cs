using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HalfSumElement
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var big = int.MinValue;
            var sum = 0;
            for (int i = 0; i < n; i++)
            {
                var num = int.Parse(Console.ReadLine());
                if (big < num)
                {
                    big = num;
                }
                sum += num;
            }
            if ((sum - big) == big)
            {
                Console.WriteLine("Yes\nSum = {0}", big);
            }
            else
            {
                Console.WriteLine("No\nDiff = {0}", Math.Abs(big - (sum - big)));
            }

        }
    }
}
