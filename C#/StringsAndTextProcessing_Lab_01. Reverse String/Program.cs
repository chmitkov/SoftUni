using System;
using System.Linq;

namespace StringsAndTextProcessing_Lab_01._Reverse_String
{
    class Program
    {
        static void Main(string[] args)
        {
            string str = Console.ReadLine();
           
            Console.WriteLine(string.Join("",str.Reverse()));
        }
    }
}
