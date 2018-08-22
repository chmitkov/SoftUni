using System;
using System.Linq;

namespace PF_Exam_04March2018PartI_02._Kamino_Factory
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int[] bestDNA = new int[n];
            string input =Console.ReadLine();
            int sampleCounter = 0;
            int bestSample = 0;
            while (input !="Clone them!")
            {
                int[] currentDNA = input
                    .Split(new char[] { '!',' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse)
                    .ToArray();
                sampleCounter++;
                if (IsBetter(currentDNA, bestDNA))
                {
                    bestDNA = currentDNA;
                    bestSample = sampleCounter;
                }
                if (bestSample == 0)
                {
                    bestDNA = currentDNA;
                    bestSample = sampleCounter;
                }
                input = Console.ReadLine();
            }
            Console.WriteLine($"Best DNA sample {bestSample} with sum: {bestDNA.Sum()}.");
            Console.WriteLine(string.Join(" ",bestDNA));
        }

        private static bool IsBetter(int[] currentDNA, int[] bestDNA)
        {
            if (dnaStats(currentDNA)[0] > dnaStats(bestDNA)[0])
            {
                return true;
            }
            else if (dnaStats(currentDNA)[0] == dnaStats(bestDNA)[0])
            {
                if (dnaStats(currentDNA)[1] < dnaStats(bestDNA)[1])
                {
                    return true;
                }
                else if (dnaStats(currentDNA)[1] == dnaStats(bestDNA)[1])
                {
                    if (dnaStats(currentDNA)[2] > dnaStats(bestDNA)[2])
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
        private static int[] dnaStats(int[] currentDNA)
        {
            var bestLength = 0;
            var bestIndex = 0;
            var counter = 0;
            var bestSum = 0;
            var endIndex = 0;
            for (int i = 0; i < currentDNA.Length; i++)
            {
                if (currentDNA[i] == 1)
                {
                    bestSum++;
                    counter++;
                    if (counter > bestLength)
                    {
                        bestLength = counter;
                        endIndex = i;
                    }
                }
                else
                {
                    counter = 0;
                }
            }
            bestIndex = endIndex - bestLength + 1;
            return new int[] { bestLength, bestIndex, bestSum };
        }
    }
}
