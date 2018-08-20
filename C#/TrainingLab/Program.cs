using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TrainingLab
{
    class Program
    {
        static void Main(string[] args)
        {
            var w = double.Parse(Console.ReadLine());
            var h = double.Parse(Console.ReadLine());

            w = (int)((w * 100) / 120);
            h = (h * 100) - 100;
            h = (int)h / 70;
            var all = (w * h) - 3;
            Console.WriteLine(all);
         }
    }
}
