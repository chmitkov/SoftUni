using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam_Hornet_03HornetAssault
{
    class Program
    {
        static void Main(string[] args)
        {
            List<long> beehives = Console.ReadLine().Split(' ').Select(long.Parse).ToList();
            List<long> hornets = Console.ReadLine().Split(' ').Select(long.Parse).ToList();

            for (int i = 0; i < beehives.Count; i++)
            {
                if (hornets.Count == 0)
                {
                    break;
                }
                long summedHornetsPower = hornets.Sum();
                if (beehives[i] >= summedHornetsPower)
                {
                    hornets.RemoveAt(0);
                }
                beehives[i] -= summedHornetsPower;
            }
            foreach (var hive in beehives)
            {
                if (hive > 0)
                {
                    Console.Write(hive + " ");
                }
            }
            if (beehives.Exists(a => a <= 0))
            {
                Console.WriteLine(string.Join(" ", hornets));
            }
        }
    }