using System;

namespace Strings_and_Text_Processing_Exercises_04CharacterMultiplier
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] words = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
            var word1 = words[0];
            var word2 = words[1];
            
            var longer = string.Empty;
            var shortStr = string.Empty;
            if (word1.Length > word2.Length)
            {
                longer = word1;
                shortStr = word2;
            }
            else
            {
                longer = word2;
                shortStr = word1;
            }
            long sum = 0L;
            for (int i = 0; i <longer.Length; i++)
            {
                if (i < shortStr.Length)
                {
                    sum += ((int)word1[i] * (int)word2[i]);
                }
                else
                {
                    sum += (int)longer[i];
                }
            }
            Console.WriteLine(sum);
        }
    }
}
