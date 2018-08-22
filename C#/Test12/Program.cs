using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test12
{
    class Program
    {
        static void Main(string[] args)
        {
            int num1 = int.Parse(Console.ReadLine());
            int num2 = int.Parse(Console.ReadLine());
            Console.WriteLine(IntegerToBase(num1,num2));

        }
        static string IntegerToBase(int number, int toBase)
        {

            //return number.toString(number, toBase);
            //  string result = string.Empty;
            //  while (number != 0)
            //  {
            //      var firstNum = number / toBase;
            //      var secNum = number % toBase;
            //      number /= toBase;
            //     return result = ""+firstNum+secNum;
            //  }
            //  return result;
        }
    }
}
