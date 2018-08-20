using System;

namespace PF_Exam_09July2017Part_1_01._Poke_Mon
{
    class Program
    {
        static void Main(string[] args)
        {
            int pokePower = int.Parse(Console.ReadLine());
            int currPower = pokePower;
            int distance = int.Parse(Console.ReadLine());
            int exhaustionFactor = int.Parse(Console.ReadLine());
            int counter = 0;
            while (distance<=currPower)
            {
                currPower -= distance;
                counter++;
                if (currPower == pokePower / 2)
                {
                    if (exhaustionFactor != 0)
                    {
                        currPower /= exhaustionFactor;
                    }
                }
            }
            Console.WriteLine($"{currPower}");
            Console.WriteLine($"{counter}");
        }
    }
}
