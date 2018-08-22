using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Duljina na masiv 1");
            int n = int.Parse(Console.ReadLine());
            int[] array1 = new int[n];
            for (int i = 0; i < array1.Length; i++)
            {
                Console.Write("Stojnosti na masiv 1");
                int num = int.Parse(Console.ReadLine());
                array1[i] = num;
            }
            Console.Write("Duljina na masiv 2");
            int m = int.Parse(Console.ReadLine());
            int[] array2 = new int[m];
            for (int i = 0; i < array2.Length; i++)
            {
                Console.Write("Stojnosti na masiv 2");
                int num = int.Parse(Console.ReadLine());
                array2[i] = num;
            }
            bool equal = true;
            if (n != m)
            {
                equal = false;
            }
            else
            {
                for (int i = 0; i < array1.Length; i++)
                {
                    if (array1[i] != array2[i])
                    {
                        equal = false;
                    }
                }
            }
            Console.WriteLine("{0}", equal);
        }
    }
}
