
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test9
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            int c = int.Parse(Console.ReadLine());
            int GetMin(int n , int m, int l )
            {
                if (n < m && n < l)
                {
                    return a;
                }
                else if (m < n && m < l)
                {
                    return m;
                }
                else
                {
                    return l;
                }
            }
            Console.WriteLine(GetMin(a,b,c));
        }
    }
}
