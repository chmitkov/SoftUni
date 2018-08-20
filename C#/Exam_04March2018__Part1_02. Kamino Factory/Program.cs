using System;
using System.Linq;

namespace Exam_04March2018__Part1_02._Kamino_Factory
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int[] bestDNA = new int[n];
            int bestSample = 0;
            int sample = 0;
            string input = Console.ReadLine();

            while (input != "Clone them!")
            {
                int[] currentDNA = input
                    .Split(new char[] { '!' }, StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse)
                    .ToArray();
                sample++;
                if (IsBetterDNA(currentDNA, bestDNA))
                {
                    bestDNA = currentDNA;
                    bestSample = sample;
                }

                input = Console.ReadLine();
            }
            Console.WriteLine($"Best DNA sample {bestSample} with sum: {bestDNA.Sum()}.");
            Console.WriteLine(string.Join(" ",bestDNA));
        }

        public static bool IsBetterDNA( int[] currentDNA, int[] bestDNA)
        {
            var bestInfo = FindLongSequence(bestDNA);
            var currInfo = FindLongSequence(currentDNA);

            if (bestInfo[0]>currInfo[0])
            {
                return false;
            }
            else if (bestInfo[0]<currInfo[0])
            {
                return true;
            }
            else
            {
                if (bestInfo[1] < currInfo[1])
                {
                    return false;
                }
                else if (bestInfo[1] > currInfo[1])
                {
                    return true;
                }
                else
                {
                    if (bestInfo[2] > currInfo[2])
                    {
                        return false;
                    }
                    else if (bestInfo[2] < currInfo[2])
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }

        public static int[] FindLongSequence(int[] bestDNA)
        {
            var bestSum = 0;
            var bestIndex = 0;
            var bestCounter = 0;
            var counter = 0;
            for (int i = 0; i < bestDNA.Length; i++)
            {
                if (bestDNA[i] == 1)
                {
                    counter++;
                    bestSum++;
                }
                else
                {
                    counter = 0;
                }
                if (counter > bestCounter)
                {
                    bestCounter = counter;
                    bestIndex = i - counter + 1;
                }
            }
            return new int[] { bestCounter, bestIndex, bestSum };
        }
    }
}
