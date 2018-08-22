using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace P03_HornetAssault
{
    class Program
    {
        static void Main(string[] args)
        {
            long[] beehives = Console.ReadLine().Split(' ')
                .Select(long.Parse).ToArray();
            List<long> hornets = Console.ReadLine().Split(' ')
                .Select(long.Parse).ToList();
            for (long i = 0; i < beehives.Length; i++)
            {
                if (beehives[i] < hornets.Sum())
                {
                    beehives[i] = 0;
                }
                else
                {
                    beehives[i] -= hornets.Sum();
                    if (hornets.Count == 0)
                    {
                        break;
                    }
                    hornets.RemoveAt(0);
                }
            }
            List<long> newBeehavies = new List<long>();
            for (long i = 0; i < beehives.Length; i++)
            {
                if (beehives[i] != 0)
                {
                    newBeehavies.Add(beehives[i]);
                }
            }

            if (beehives.Sum() > 0)
            {
                Console.WriteLine(string.Join(" ", newBeehavies));
            }
            else
            {
                Console.WriteLine(string.Join(" ", hornets));
            }









            //long[] beehives = Console.ReadLine().Split(' ').Select(long.Parse).ToArray();
            //List<long> hornets = Console.ReadLine().Split(' ').Select(long.Parse).ToList();

            //for (long i = 0; i < beehives.Length; i++)
            //{
            //    if (beehives[i] >= hornets.Sum())
            //    {
            //        beehives[i] -= hornets.Sum();
            //        hornets.RemoveAt(0);
            //    }
            //    else
            //    {
            //        beehives[i] = 0;
            //    }
            //}
            //if (beehives.Sum() > 0)
            //{
            //    Console.WriteLine(string.Join(" ",hornets));
            //}
            //else
            //{
            //    Console.WriteLine(string.Join(" ",hornets));
            //}
        }
    }
}
