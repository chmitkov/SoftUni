using System;
using System.Collections.Generic;
using System.Linq;

namespace DictionariesandLists_MoreExercises_07.Take_Skip_Rope
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            List<int> digits = new List<int>();
            List<char> chars = new List<char>();
            for (int i = 0; i < input.Length; i++)
            {
                if (Char.IsDigit(input[i]))
                {
                    digits.Add(int.Parse(input[i].ToString()));
                }
                else 
                {
                    chars.Add(input[i]);
                }
            }
            List<int> takeList = new List<int>();
            List<int> skipList = new List<int>();
            for (int i = 0; i < digits.Count; i++)
            {
                if (i % 2 == 0)
                {
                    takeList.Add(digits[i]);
                }
                else
                {
                    skipList.Add(digits[i]);
                }
            }
            List<char> result = new List<char>();
            var sumOfSkip = 0;
            for (int i = 0; i < Math.Min(skipList.Count,takeList.Count); i++)
            {
                result.AddRange(chars.Skip(sumOfSkip).Take(takeList[i]));
                //sumOfSkip
                //var end = Math.Min((chars.Count - 1), sumOfSkip + takeList[i]);
                //for (int j = sumOfSkip; j <= sumOfSkip+takeList[i]; j++)
                //{
                //    result.Add(chars[j]);
                //}
                sumOfSkip += (takeList[i]+skipList[i]);
            }
            Console.WriteLine(string.Join("",result));
        }
    }
}
