using System;
using System.Linq;
using System.Text.RegularExpressions;

namespace Exam_Preparation_1_04._Winning_Ticket
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] tickets = Console.ReadLine()
                .Split(new char[] { ',', ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            bool ticketWin = false;
            foreach (var ticket in tickets)
            {
                if (ticket.Length == 20)
                {
                    string left = new string(ticket.Take(10).ToArray());
                    string right = new string(ticket.Skip(10).ToArray());

                    string[] winningSimbols = { "@", "#", "\\$", "\\^" };
                    foreach (var simbol in winningSimbols)
                    {

                        Regex regex = new Regex($"{simbol}{{6,}}");
                        Match leftMatch = regex.Match(left);
                        if (leftMatch.Success)
                        {
                            Match rightMatch = regex.Match(right);
                            if (rightMatch.Success)
                            {
                                ticketWin = true;
                                if (rightMatch.Length == 10 && leftMatch.Length == 10)
                                {
                                    Console.WriteLine($"ticket \"{ticket}\" - 10{simbol.Trim('\\')} Jackpot!");
                                }
                                else
                                {
                                    Console.WriteLine($"ticket \"{ticket}\" - {leftMatch.Length}{simbol.Trim('\\')}");  
                                }
                            }
                        }
                        
                    }
                }
                else
                {
                    Console.WriteLine("invalid ticket");
                }
            }
            
        }
    }
}

