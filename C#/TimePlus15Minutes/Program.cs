using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TimePlus15Minutes
{
    class Program
    {
        static void Main(string[] args)
        {
            var h = int.Parse(Console.ReadLine());
            var m = int.Parse(Console.ReadLine());
            var totalM = h * 60 + m+15;
            var hour = totalM / 60;
            var min = totalM % 60;
            if (hour >= 24)
            {
                hour -= 24;
            }
            Console.WriteLine("{0}:{1:00}", hour, min);
        }
    }
}
