using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace Exam_2
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            List<string> broadcast = new List<string>();
            List<string> messages = new List<string>();
            while (input != "Hornet is Green")
            {
                string messagePattern = @"([0-9]+) <-> ([A-Za-z]+)";
                string broadcastPattern = @"([^0-9]+) <-> ([A-Za-z0-9]+)";
                Regex regex = new Regex(messagePattern);
                Regex regex2 = new Regex(broadcastPattern);
                if (regex.IsMatch(input))
                {

                }
                else if (regex2.IsMatch(input))
                {

                }
                input = Console.ReadLine();
            }
        }
    }
}
