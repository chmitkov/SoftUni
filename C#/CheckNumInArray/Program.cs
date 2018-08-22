using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CheckNumInArray
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Vavedi Daljina:");
            int n = int.Parse(Console.ReadLine());
            int[] array = new int[n];

            for (int i = 0; i < array.Length; i++)
            {
                Console.WriteLine("Vavedi chislo:");
                array[i] = int.Parse(Console.ReadLine());
            }
            Console.WriteLine("Tyrseno chislo:");
            int num = int.Parse(Console.ReadLine());
            bool numInArr = false;
            for (int i = 0; i < array.Length; i++)
            {
                if (array[i] == num)
                {
                    numInArr = true;
                }
            }
            if (numInArr)
            {
                Console.WriteLine("yes");
            }
            else
            {
                Console.WriteLine("no");
            }
        }
    }
}
