using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PokemonDon_tGo
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> sequence = Console.ReadLine().Split(' ')
                .Select(int.Parse).ToList();
            int sum = 0;
            int index = 0;
            int current = 0;

            while (sequence.Count > 0)
            {
                index = int.Parse(Console.ReadLine());
                if (index < 0)
                {
                    current = sequence[0];
                    sequence.RemoveAt(0);
                    sequence.Insert(0, sequence[sequence.Count - 1]);
                }
                else if (index >= sequence.Count)
                {
                    current = sequence[sequence.Count - 1];
                    sequence.Remove(sequence.Count - 1);
                    sequence.Add(sequence[0]);

                }
                else
                {
                    current = sequence[index];
                    sequence.RemoveAt(index);
                }
                for (int i = 0; i < sequence.Count; i++)
                {
                    if (sequence[i] <= current)
                    {
                        sequence[i] += current;
                    }
                    else
                    {
                        sequence[i] -= current;

                    }
                }
                sum += current;
            }

            //    List<int> list = Console.ReadLine().Split(' ')
            //        .Select(int.Parse).ToList();
            //    int sum = 0;
            //    while (list.Count != 0)
            //    {
            //        int index = int.Parse(Console.ReadLine());
            //        int number = list[index];
            //        list.RemoveAt(index);
            //        if (index < 0)
            //        {
            //            number = list[0];
            //            list[0] = list[list.Count - 1];
            //        }
            //        if (index > list.Count - 1)
            //        {
            //            number = list[list.Count - 1];
            //            list[list.Count - 1] = list[0];
            //        }

            //        for (int i = 0; i < list.Count; i++)
            //        {
            //            if (list[i] <= number)
            //            {
            //                list[i] += number;
            //            }
            //            else
            //            {
            //                list[i] -= number;
            //            }
            //        }
            //        sum += number;

            //    }
            //    Console.WriteLine(sum);
            //}
            Console.WriteLine(sum);
        }
    }
}
