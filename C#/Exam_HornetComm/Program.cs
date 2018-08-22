using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Exam_HornetComm
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            List<Match> broadcast = new List<Match>();
            List<Match> messages = new List<Match>();
            string broadcastPattern = @"^([^0-9]+) <-> ([0-9A-Za-z]+)$";
            string messagesPattern = @"^([0-9]+) <-> ([0-9A-Za-z]+)$";

            while (input != "Hornet is Green")
            {
                if (Regex.IsMatch(input, broadcastPattern))
                {
                    broadcast.Add(Regex.Match(input, broadcastPattern));
                }
                else if (Regex.IsMatch(input, messagesPattern))
                {
                    messages.Add(Regex.Match(input, messagesPattern));
                }
                input = Console.ReadLine();
            }
            Console.WriteLine($"Broadcasts:");
            if (broadcast.Count == 0)
            {
                Console.WriteLine($"None");
            }
            else
            {
                foreach (Match m in broadcast)
                {
                    Console.WriteLine($"{ChangeLetter(m.Groups[2].Value)}" +
                        $" -> {m.Groups[1]}");
                }
            }
            Console.WriteLine($"Messages:");
            if (messages.Count == 0)
            {
                Console.WriteLine($"None");
            }
            else
            {
                foreach (Match m in messages)
                {
                    Console.WriteLine($"{Reverse(m.Groups[1].Value)} ->" +
                        $" {m.Groups[2].Value}");
                }
            }
        }

        static string ChangeLetter(string value)
        {
            var text = value.ToArray();
            var result = "";
            for (int i = 0; i < value.Length; i++)
            {
                if (char.IsUpper(text[i]))
                {
                    result += char.ToLower(text[i]);
                }
                else if (char.IsLower(text[i]))
                {
                    result += char.ToUpper(text[i]);
                }
                else
                {
                    result += text[i];
                }
            }
            return result;
        }

        static string Reverse(string value)
        {
            var result = "";
            for (int i = value.Length-1; i >=0 ; i--)
            {
                result += value[i];
            }
            return result;
        }
    }
}
