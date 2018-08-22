using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LOgistic
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            double total = 0;
            double totalPrice = 0;
            double buss = 0;
            double truck = 0;
            double train = 0;
            for (int i = 0; i < n; i++)
            {
                var num = int.Parse(Console.ReadLine());
                total += num;
                if (num <= 3)
                {
                    buss += num;
                }
                else if (num <= 11)
                {
                    truck += num;
                }
                else if (num > 11)
                {
                    train += num;
                }

            }
            totalPrice = buss * 200 + truck * 175 + train * 120;
            Console.WriteLine("{0:F2}%\n{1:F2}%\n{2:F2}%\n{3:F2}%", totalPrice / total, buss / total * 100, truck / total *100, train / total*100);
        }
    }
}
