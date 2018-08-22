using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestIcarus
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] planes = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse).ToArray();
            int startPosition = int.Parse(Console.ReadLine());
            string[] commands = Console.ReadLine()
                .Split(' ')
                .ToArray();

            var power = 1;
            while (commands[0] != "Supernova")
            {

                if (commands[0] == "right")
                {
                    for (int i = 0; i < int.Parse(commands[1]); i++)
                    {

                        if (startPosition == planes.Length - 1)
                        {
                            startPosition = 0;
                            power++;
                        }
                        else
                        {
                            startPosition++;
                        }
                        planes[startPosition] = planes[startPosition] - power;
                    }

                }
                else if (commands[0] == "left")
                {
                    for (int i = 0; i < int.Parse(commands[1]); i++)
                    {

                        if (startPosition == 0)
                        {
                            startPosition = planes.Length - 1;
                            power++;
                        }
                        else
                        {
                            startPosition--;
                        }
                        planes[startPosition] = planes[startPosition] - power;
                    }
                }


                commands = Console.ReadLine()
                .Split(' ')
                .ToArray();
            }
            Console.WriteLine(string.Join(" ", planes));
        }
    }
}
