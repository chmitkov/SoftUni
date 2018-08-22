using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EqualPairs
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
          

            int pairSum = 0;
            int maxDiff = 0;
            int lastSum = 0;

            for (int i = 0; i < n; i++)
            {
                int a = int.Parse(Console.ReadLine());
                int b = int.Parse(Console.ReadLine());
                
                pairSum = a + b;

                if (i > 0)
                {
                    int diff = Math.Abs(pairSum - lastSum);

                    if (diff > maxDiff)
                    {
                        maxDiff = diff;
                    } 
                }
                lastSum = pairSum;
            }

            Console.WriteLine((maxDiff == 0) ? "Yes, value=" + pairSum : "No, maxdiff=" + maxDiff);
           
        }
    }
    }

