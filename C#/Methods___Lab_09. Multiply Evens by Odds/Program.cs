using System;
using System.Linq;

namespace Methods___Lab_09._Multiply_Evens_by_Odds
{
    class Program
    {
        static void Main(string[] args)
        {
            char[] num = Console.ReadLine().ToCharArray();
            var oddNumSum = 0;
            var evenNumSum = 0;
            foreach (var ch in num)
            {
                if (!(ch == '-'))
                {
                    if (int.Parse(ch.ToString()) % 2 == 0)
                    {
                        evenNumSum += int.Parse(ch.ToString());
                    }
                    else
                    {
                        oddNumSum += int.Parse(ch.ToString());
                    }
                }
                
            }
            Console.WriteLine(evenNumSum*oddNumSum);
        }
    }
}
