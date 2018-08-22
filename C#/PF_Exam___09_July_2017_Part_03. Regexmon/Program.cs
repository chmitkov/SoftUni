using System;
using System.Text.RegularExpressions;

namespace PF_Exam___09_July_2017_Part_03._Regexmon
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string didiPattern = @"[^A-Za-z\-]+";
            string bojoPattern = @"[A-Za-z]+-[A-Za-z]+";
            Regex regex = new Regex(didiPattern);
            Regex regex2 = new Regex(bojoPattern);
            var neededM = string.Empty;
            for (int i = 0; i < 100; i++)
            {
                if (i % 2 == 0 && regex.IsMatch(input))
                {
                    neededM = regex.Match(input).ToString();
                    Console.WriteLine(neededM);
                    var remove = input.IndexOf(neededM);
                    input = input.Remove(0,remove+neededM.Length);
                }
                else if (i % 2 != 0 && regex2.IsMatch(input))
                {
                    neededM = regex2.Match(input).ToString();
                    Console.WriteLine(neededM);
                    var remove = input.IndexOf(neededM);
                    input = input.Remove(0, remove + neededM.Length);
                }
                else
                {
                    break;
                }
            }
        }
    }
}
