using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PokeMon
{
    class Program
    {
        static void Main(string[] args)
        {
            int pokePower = int.Parse(Console.ReadLine());
            int distance = int.Parse(Console.ReadLine());
            byte exhaustionFactor = byte.Parse(Console.ReadLine());
            var poke = 0;
            int currPow = pokePower;
            while (currPow >= distance)
            { 
                
                if (currPow == pokePower / 2 && pokePower % 2 == 0 && exhaustionFactor != 0) 
                { 
                    currPow /= exhaustionFactor;
                }
                if (currPow < distance)
                {
                    break;
                }
                currPow -= distance;
                poke++;

            }
            Console.WriteLine(currPow);
            Console.WriteLine(poke);
        }
    }
}
