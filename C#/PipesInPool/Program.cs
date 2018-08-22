using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PipesInPool
{
    class Program
    {
        static void Main(string[] args)
        {
            var v = int.Parse(Console.ReadLine());
            var p11 = int.Parse(Console.ReadLine());
            var p22 = int.Parse(Console.ReadLine());
            var time = double.Parse(Console.ReadLine());

            var p1 = p11 * time;
            var p2 = p22 * time;
            double waterInPool = p1+p2;
            
            
            var result1 = Math.Truncate(waterInPool / v * 100);
            var result2 = Math.Truncate(p1 / waterInPool * 100);
            var result3 = Math.Truncate(p2 / waterInPool * 100);
            if (waterInPool < v)
            {
                Console.WriteLine("The pool is {0:0}% full. Pipe 1: {1:0}%. Pipe 2: {2:0}%."
                    , result1,result2,result3);
            }
            else
            {
                Console.WriteLine("For {0} hours the pool overflows with {1} liters.", time, waterInPool-v);
            }
        }
    }
}
