using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            dynamic[] arr = { "Gosho", 5, new[] { 1, 2, 3 }, new Program() };

            Console.WriteLine(string.Join(" ", arr[2]));
        }
    }
}
