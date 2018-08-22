using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cinema
{
    class Program
    {
        static void Main(string[] args)
        {
            var type = Console.ReadLine().ToLower();
            var row = int.Parse(Console.ReadLine());
            var col = int.Parse(Console.ReadLine());

            var hall = row * col;
            var total = 0.0;
            switch (type)
            {
                case "premiere":
                    total = hall * 12.00;
                    break;
                case "normal":
                    total = hall * 7.50;
                    break;
                case "discount":
                    total = hall * 5.00;
                    break;
            }
            Console.WriteLine("{0:F2} leva", total);
        }
    }
}
