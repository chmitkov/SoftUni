using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ListTest
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> list = new List<string>();
            list.Add("Peter");
            list.Add("Maria");
            list.Add("George");
            Console.WriteLine(string.Join(" ", list));
            list.Remove("Maria");
            Console.WriteLine(string.Join(" ", list));
            list.Insert(1,"100");
            Console.WriteLine(string.Join(" ", list));
            list.Add("Todor");
            Console.WriteLine(string.Join(" ", list));
            Console.WriteLine(list.Contains("100"));
         



        }
    }
}
