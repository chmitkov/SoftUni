using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TransportPrice
{
    class Program
    {
        static void Main(String[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var time = Console.ReadLine().ToLower();
            var taxi = 0.0;
            var bus = 0.0;
            var train = 0.0;
            var best = "";


            if (n >= 100)
            {
                if (time == "day")
                {
                    taxi = n * 0.79 + 0.7;
                    bus = n * 0.09;
                    train = n * 0.06;
                }
                else
                {
                    taxi = n * 0.90 + 0.7;
                    bus = n * 0.09;
                    train = n * 0.06;
                }
                if (taxi < bus && taxi < train)
                {
                    Console.WriteLine(taxi);
                }
                else if (bus < taxi && bus < train)
                {
                    Console.WriteLine(bus);
                }
                else
                {
                    Console.WriteLine(train);      
                }
               
            }
            else if (n >= 20)
            {
                if (time == "day")
                {
                    taxi = n * 0.79 + 0.7;
                    bus = n * 0.09;

                }
                else
                {
                    taxi = n * 0.90 + 0.7;
                    bus = n * 0.09;

                }
                if (taxi < bus)
                {
                    Console.WriteLine(taxi);
                }
                else
                {
                    Console.WriteLine(bus);
                }
            }
            else
            {
                if (time == "day")
                {
                    taxi = n * 0.79 + 0.7;
                }
                else
                {
                    taxi = n * 0.90 + 0.7;
                }
                Console.WriteLine(taxi);
            }     
        }
    }
}
        
    
