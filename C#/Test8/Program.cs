using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test8
{
    class Program
    {
        static void Main(string[] args)
        {
            string name = Console.ReadLine();
            string  SayHello(string hisName)
            {
                return $"Hello, {name}!";
            }
            Console.WriteLine(SayHello(name));
        }
    }
}
