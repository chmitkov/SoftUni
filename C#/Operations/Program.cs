using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Operations
{
    class Program
    {
        static void Main(string[] args)
        {
            var n1 = int.Parse(Console.ReadLine());
            var n2 = int.Parse(Console.ReadLine());
            var oper = Console.ReadLine();
            string even = "";

            if (oper.Equals("+"))
            {
                if ((n1 + n2) % 2 == 0)
                {
                    even = "even";
                }
                else
                {
                    even = "odd";
                }
                Console.WriteLine("{0} {1} {2} = {3} - {4}", n1, oper, n2, n1 + n2, even);
            }
            else if (oper.Equals("-"))
            {
                if ((n1 - n2) % 2 == 0)
                {
                    even = "even";
                }
                else
                {
                    even = "odd";
                }
                Console.WriteLine("{0} {1} {2} = {3} - {4}", n1, oper, n2, n1 - n2, even);
            }
            else if (oper.Equals("*"))
            {
                if ((n1 * n2) % 2 == 0)
                {
                    even = "even";
                }
                else
                {
                    even = "odd";
                }
                Console.WriteLine("{0} {1} {2} = {3} - {4}", n1, oper, n2, n1 * n2, even);
            }
            else if (oper.Equals("/"))
            {
                if (n2 == 0)
                {
                    Console.WriteLine("Cannot divide {0} by zero", n1);
                }
                else
                {
                    Console.WriteLine("{0} {1} {2} = {3:F2}", n1, oper, n2, n1 * 1.0 / n2);
                }
            }
            else if (oper.Equals("%"))
            {
                if (n2 == 0)
                {
                    Console.WriteLine("Cannot divide {0} by zero", n1);
                }
                else
                {
                    Console.WriteLine("{0} {1} {2} = {3}", n1, oper, n2, n1 % n2);
                }
            }
        }
    }
}
