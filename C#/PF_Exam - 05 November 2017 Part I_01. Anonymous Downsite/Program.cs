using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;

namespace PF_Exam___05_November_2017_Part_I_01._Anonymous_Downsite
{
    class Program
    {
        static void Main(string[] args)
        {

            int n = int.Parse(Console.ReadLine());
            int securityKey = int.Parse(Console.ReadLine());

            List<string> affectedSites = new List<string>(); 

            decimal total = 0;

            for (int i = 0; i < n; i++)
            {
                string[] command = Console.ReadLine()
                    .Split(new char[] {' '},StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();

                string name = command[0];
                long site = long.Parse(command[1]); 
                decimal incomePerVisit = decimal.Parse(command[2]); 

                affectedSites.Add(name);
                total += incomePerVisit * site; 
            }

            foreach (var name in affectedSites)
            {
                Console.WriteLine(name);
            }
            Console.WriteLine($"Total Loss: {total:F20}"); 
            Console.WriteLine($"Security Token: {BigInteger.Pow(new BigInteger(securityKey), n)}");
        }
    }
}

