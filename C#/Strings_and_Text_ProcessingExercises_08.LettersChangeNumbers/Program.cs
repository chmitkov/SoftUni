using System;

namespace Strings_and_Text_ProcessingExercises_08.LettersChangeNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] words = Console.ReadLine()
                .Split(new char[] { ' ','\t' }, StringSplitOptions.RemoveEmptyEntries);

            decimal result = 0;
            foreach (var word in words)
            {
                result += WordSum(word);
            }
            Console.WriteLine($"{result:f2}");
        }

        public static decimal WordSum(string word)
        {
            decimal tempSum = 0;
            int num = int.Parse(word.Substring(1, word.Length - 2));
            if (Char.IsUpper(word[0]))
            {
                tempSum = (decimal)(num*1.0 / (word[0] - 64));
            }
            else
            {
                tempSum = num * (word[0] - 96);
            }
            if (Char.IsUpper(word[word.Length - 1]))
            {
                tempSum -= (word[word.Length - 1] - 64);
            }
            else
            {
                tempSum += (word[word.Length - 1] - 96);
            }

            return tempSum;
        }
    }
}
