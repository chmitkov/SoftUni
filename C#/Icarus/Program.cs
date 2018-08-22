using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Icarus
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] sequence = Console.ReadLine().Split(' ')
                .Select(int.Parse).ToArray();
            int startPosition = int.Parse(Console.ReadLine());
            string[] commands = Console.ReadLine().Split(' ').ToArray();
            int damage = 1;
            while (commands[0] != "Supernova")
            {
                string direction = commands[0];
                int steps = int.Parse(commands[1]);
                if (direction == "right")
                {
                    for (int i = 0; i < steps; i++)
                    {
                        if (startPosition == sequence.Length - 1)
                        {
                            startPosition = 0;
                            damage++;

                        }
                        else
                        {
                            startPosition++;
                        }
                        sequence[startPosition] -= damage;
                    }
                }
                else if (direction == "left")
                {
                    for (int i = 0; i < steps; i++)
                    {
                        if (startPosition == 0)
                        {
                            startPosition = sequence.Length - 1;
                            damage++;
                        }
                        else
                        {
                            startPosition--;
                        }
                        sequence[startPosition] -= damage;
                    }
                }

                commands = Console.ReadLine().Split(' ').ToArray();
            }
            Console.WriteLine(string.Join(" ", sequence));
        }
    }
}
