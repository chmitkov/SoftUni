using System;
using System.Linq;

namespace PF_Retake_Exam___05_January_2018_Part_I_02._Snowmen
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] snowmans = Console.ReadLine()
                 .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                 .Select(int.Parse)
                 .ToArray();
        }
    }
}
