using System;
using System.Text.RegularExpressions;

namespace PF_Retake_Exam_Part2_6January2017_04._Winning_Ticket
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] tickets = Console.ReadLine()
                .Split(new char[] { ' ',',' }, StringSplitOptions.RemoveEmptyEntries);
            Regex regexJackpot = new Regex(@"[@#$^]{20}");
            Regex regexWinTicket = new Regex(@"([@#$^]{6,9}).+\1");

            foreach (var tick in tickets)
            {
                if (tick.Length != 20)
                {
                    Console.WriteLine("invalid ticket");
                }
                else if (regexJackpot.IsMatch(tick))
                {
                    Console.WriteLine($"ticket \"{tick}\" - 10{tick[0].ToString()} Jackpot!");
                }
                else
                {
                    if (regexWinTicket.IsMatch(tick))
                    {
                        var winMatch = regexWinTicket.Match(tick).Groups[1].Value;
                        Console.WriteLine($"ticket \"{tick}\" - {winMatch.Length}{winMatch[0].ToString()}");
                    }
                    else
                    {
                        Console.WriteLine($"ticket \"{tick}\" - no match");
                    }
                }
            }
        }
    }
}
