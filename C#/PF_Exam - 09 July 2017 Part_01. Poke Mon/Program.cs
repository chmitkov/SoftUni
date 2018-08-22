using System;

namespace PF_Exam___09_July_2017_Part_01._Poke_Mon
{
    class Program
    {
        static void Main(string[] args)
        {
            int power = int.Parse(Console.ReadLine());
            int currentPower = power;
            int distance = int.Parse(Console.ReadLine());
            int exhaustionFactor = int.Parse(Console.ReadLine());
            int count = 0;
            while (currentPower>=distance)
            {
                count++;
                currentPower -= distance;
                if (currentPower == power * 0.5 && exhaustionFactor>0)
                {
                    currentPower /= exhaustionFactor;
                }
                
            }
            Console.WriteLine(currentPower);
            Console.WriteLine(count);

        }
    }
}
