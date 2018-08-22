using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test7
{
    class Program
    {
        static void Main(string[] args)
        {
            var type = Console.ReadLine().ToLower();
            if (type == "int")
            {
                int a = int.Parse(Console.ReadLine());
                int b = int.Parse(Console.ReadLine());
                int max = GetMax(a, b);
                Console.WriteLine(max);
            }
            else if (type == "char")
            {
                string n = Console.ReadLine();
                char a = n[0];
                string m = Console.ReadLine();
                char b = m[0];
                char max = GetMax(a, b);
                Console.WriteLine(max);
            }
            else if (type == "string")
            {
                string a = Console.ReadLine();
                string b = Console.ReadLine();
                string max = GetMax(a, b);
                Console.WriteLine(max);

            }
        }
        static int GetMax(int a, int b)
        {
            if (a > b)
            {
                return a;            }
            else
            {
                return b;
            }
        }
        static char GetMax(char a, char b)
        {
            if (a > b)
            {
                return a;
            }
            else
            {
                return b;
            }
        }
        static string GetMax(string  a, string b)
        {
            if (a.CompareTo(b)>=0)
            {
                return a;
            }
            else
            {
                return b;
            }
        }
    }
}
