using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hospital
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var doc = 7;
            var treated = 0;
            var untreated = 0;
            for (int i = 1; i <= n; i++)
            {
                if ((i % 3 == 0) && (untreated > treated))
                {
                    doc++;
                }
                var pac = int.Parse(Console.ReadLine());
              
                if (pac > doc)
                {
                    untreated += (pac - doc);
                    treated += doc;
                }
                else
                {
                    treated += pac;
                }
                
            }
            Console.WriteLine("Treated patients: {0}.\nUntreated patients: {1}.", treated, untreated);
        }
    }
}
