using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FruitOrVegetable
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = Console.ReadLine().ToLower();
            if (n == "banana" || n == "apple" || n == "kiwi" || n == "cherry" || n == "lemon" || n == "grapes")
            {
                Console.WriteLine("fruit");
            }
            else if (n == "tomato" || n == "cucumber" || n == "pepper" || n == "carrot")
            {
                Console.WriteLine("vegetable");
            }
            else
            {
                Console.WriteLine("unknown");
            }
        }
    }
}
