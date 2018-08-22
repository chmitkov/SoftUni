using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            int count = int.Parse(Console.ReadLine());
            switch (input)
            {
                case "Athlete":
                    Console.WriteLine($"The {input} has to pay {(count * 0.7):F2}.");
                    break;
                case "Businessman":
                case "Businesswoman":
                    Console.WriteLine($"The {input} has to pay {(count * 1):F2}.");
                    break;
                case "SoftUni Student":
                    Console.WriteLine($"The {input} has to pay {(count * 1.7):F2}.");
                    break;
                default:
                    Console.WriteLine($"The {input} has to pay {(count * 1.2):F2}.");
                    break;
            }
        }
    }
}
