using System;

namespace Conditional_Statements_and_Loops_15._Neighbour_Wars
{
    class Program
    {
        static void Main(string[] args)
        {
            int damagePesho = int.Parse(Console.ReadLine());
            int damageGosho = int.Parse(Console.ReadLine());
            int rounds = 1;

            int healtPesho = 100;
            int healtGosho = 100;

            while (true)
            {
                if (rounds % 2 == 1)
                {
                    healtGosho -= damagePesho;

                    if (healtGosho <= 0)
                    {
                        Console.WriteLine($"Pesho won in {rounds}th round.");
                        break;
                    }
                    else
                    {
                        Console.WriteLine($"Pesho used Roundhouse kick and reduced Gosho to {healtGosho} health.");
                    }
                }
                else
                {
                    healtPesho -= damageGosho;

                    if (healtPesho <= 0)
                    {
                        Console.WriteLine($"Gosho won in {rounds}th round.");
                        break;
                    }
                    else
                    {
                        Console.WriteLine($"Gosho used Thunderous fist and reduced Pesho to {healtPesho} health.");
                    }
                }

                if (rounds % 3 == 0)
                {
                    healtPesho += 10;
                    healtGosho += 10;
                }
                rounds++;
            }
        }
    }
