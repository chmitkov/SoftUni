using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;

namespace DownSite
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            sbyte secKey = sbyte.Parse(Console.ReadLine());
            string[] array = new string[3];
            string site;
            long siteVisits = 0;
            decimal pricePerVisits = 0  ;          
            decimal total = 0;
            BigInteger key = BigInteger.Pow(secKey,n);

            for (int i = 0; i < n; i++)
            {
                array = Console.ReadLine().Split(' ').ToArray();
                site = array[0];
                siteVisits = long.Parse(array[1]);
                pricePerVisits = decimal.Parse(array[2]);
                total +=     siteVisits * pricePerVisits;
                Console.WriteLine(site);
            }
            Console.WriteLine($"Total Loss: {total:F20}");
                Console.WriteLine($"Sec token:{key}");
        }
    }
}
