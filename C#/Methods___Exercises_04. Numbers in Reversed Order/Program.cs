using System;
using System.Collections.Generic;
using System.Linq;

namespace Methods___Exercises_04._Numbers_in_Reversed_Order
{
    class Program
    {
        static void Main(string[] args)
        {
            string str = Console.ReadLine();

            ReverseArray(str);
        }

         static void ReverseArray(string str)
        {
            Console.WriteLine(string.Join("",str.Reverse()));
        }
    }
}
