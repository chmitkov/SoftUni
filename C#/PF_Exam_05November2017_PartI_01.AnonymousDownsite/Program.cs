using System;
using System.Collections.Generic;
using System.Numerics;

namespace PF_Exam_05November2017_PartI_01.AnonymousDownsite
{
    class Program
    {
        static void Main(string[] args)
        {
            int numberOfSites = int.Parse(Console.ReadLine());
            List<string> sites = new List<string>();
            int securityKey = int.Parse(Console.ReadLine());

            decimal total = 0;
            while (numberOfSites-- > 0)
            {
                string[] commands = Console.ReadLine()
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
                var siteName = commands[0];
                var siteVisits = decimal.Parse(commands[1]);
                var pricePerVisit = decimal.Parse(commands[2]);
                sites.Add(siteName);
                var currSiteLoss = siteVisits * pricePerVisit;
                total += currSiteLoss;
            }
            foreach (var s in sites)
            {
                Console.WriteLine(s);
            }
            Console.WriteLine($"Total Loss: {total:F20}");
            Console.WriteLine($"Security Token: {BigInteger.Pow(securityKey,sites.Count)}");
        }
    }
}
