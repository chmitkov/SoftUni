using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringAndRegEx_P_02
{
    class Program
    {
        static void Main(string[] args)
        {
            string str = Console.ReadLine().ToLower();
            string substr = Console.ReadLine().ToLower();
            int index = str.IndexOf(substr);
            int count = 0;
            while (index != -1)
            {
                count++;
                index = str.IndexOf(substr, index + 1);
            }
            Console.WriteLine(count);
        }
    }
}
