using System;
using System.Collections.Generic;
using System.Numerics;

namespace PF_Exam_05November2017PartI_01._Anonymous_Downsite
{
    class Program
    {
        static void Main(string[] args)
        {
            int countOfSites = int.Parse(Console.ReadLine());
            int securityKey = int.Parse(Console.ReadLine());
            List<string> result = new List<string>();
            decimal total = 0m;
            while (countOfSites-- > 0)
            {
                string[] commands = Console.ReadLine()
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

                var siteName = commands[0];
                decimal siteVisites = decimal.Parse(commands[1]);
                decimal commercialPerVisit = decimal.Parse(commands[2]);
                total+= siteVisites * commercialPerVisit;
                result.Add(siteName);
            }
            foreach (var name in result)
            {
                Console.WriteLine(name);
            }
            Console.WriteLine($"Total Loss: {total:f20}");
            Console.WriteLine($"Security Token: {BigInteger.Pow(securityKey,result.Count):f0}");
        }
    }
}
