using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test10
{
    class Program
    {
        static void Main(string[] args)
        {
            string str = Console.ReadLine();
            int num = int.Parse(Console.ReadLine());

            Console.WriteLine(RepStr(str, num)); ;

        }
        static string RepStr(string strToRep, int count)
        {
            string text = "";
            for (int i = 0; i < count; i++)
            {
                text += strToRep;
            }
            return text;
        }
    }
}
