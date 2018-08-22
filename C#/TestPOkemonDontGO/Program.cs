using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestPOkemonDontGO
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> sequence = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse).ToList();
            
            var sum = 0;
            var index = 0;
            var removed = 0;
            while (sequence.Count > 0)
            {
                 index = int.Parse(Console.ReadLine());
                if (index < 0)
                {
                    removed = sequence[0];
                    sequence.RemoveAt(0);
                    sequence.Insert(0, sequence[sequence.Count - 1]);
                }
                else if (index >= sequence.Count)
                {
                    removed = sequence[sequence.Count - 1];
                    sequence.Remove(sequence.Count - 1);
                    sequence.Add(sequence[0]);
                }
                else
                {
                    removed = sequence[index];
                    sequence.RemoveAt(index);
                }
                for (int i = 0; i < sequence.Count; i++)
                {
                    if (sequence[i] <= removed)
                    {
                        sequence[i] += removed;
                    }
                    else
                    {
                        sequence[i] -= removed;
                    }
                }

                sum += removed;
            }
            Console.WriteLine(sum);
        }
    }
}
