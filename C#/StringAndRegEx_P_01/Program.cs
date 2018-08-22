using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringAndRegEx_P_01
{
    class Program
    {
        static void Main(string[] args)
        {
            List<char> list = Console.ReadLine().ToList();
            list.Reverse();

            
           
            //array.Sort();
            //array.Reverse();
            //var result = array.ToString();
            Console.WriteLine(string.Join("",list));
        }
    }
}
