using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam_09July2017Part_1_03._Hornet_Assault
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> beehives = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToList();
            List<int> hornets = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToList();
            for (int i = 0; i < beehives.Count; i++)
            {
                if (beehives[i] >= hornets.Sum())
                {
                    beehives[i] =beehives[i]- hornets.Sum();
                    hornets.RemoveAt(0);
                }
                else
                {
                    beehives.RemoveAt(i) ;
                }
            }
            if (beehives.Count != 0)
            {
                Console.WriteLine(string.Join(" ",beehives));
            }
            else
            {
                Console.WriteLine(string.Join(" ",hornets));
            }
        }
    }
}
