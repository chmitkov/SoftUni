using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
namespace PF_Exam_26February2017PartI_02._Hornet_Comm
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            List<string> messages = new List<string>();
            List<string> broadcast = new List<string>();
            while (input != "Hornet is Green")
            {
                string messagePattern = @"^([0-9]+) <-> ([0-9A-Za-z]+)$";
                string broadcastPattern = @"^([^0-9]+) <-> ([0-9A-Za-z]+)$";
                Regex regex = new Regex(messagePattern);
                Regex regex2 = new Regex(broadcastPattern);
                string result = string.Empty;
                if (regex.IsMatch(input))
                {
                    var code = regex.Match(input).Groups[1].ToString();
                    var message = regex.Match(input).Groups[2].ToString();
                    result = $"{string.Join("", code.Reverse())} -> {message}";

                    messages.Add(result);
                }
                else if (regex2.IsMatch(input))
                {
                    var message = regex2.Match(input).Groups[1].ToString();
                    var frequency = regex2.Match(input).Groups[2].ToString();
                    var camelCaseFrequency = string.Empty;
                    for (int i = 0; i < frequency.Length; i++)
                    {
                        if (char.IsUpper(frequency[i]))
                        {
                            camelCaseFrequency += frequency[i].ToString().ToLower();
                        }
                        else if (char.IsLower(frequency[i]))
                        {
                            camelCaseFrequency += frequency[i].ToString().ToUpper();
                        }
                        else
                        {
                            camelCaseFrequency += frequency[i];
                        }
                    }
                    result = $"{camelCaseFrequency} -> {message}";
                    broadcast.Add(result);
                }
                input = Console.ReadLine();
            }
            Console.WriteLine("Broadcasts:");
            if (broadcast.Count > 0)
            {
                for (int i = 0; i < broadcast.Count; i++)
                {
                    Console.WriteLine(broadcast[i]);
                }
            }
            else
            {
                Console.WriteLine("None");
            }
            Console.WriteLine("Messages:");
            if (messages.Count > 0)
            {
                for (int i = 0; i < messages.Count; i++)
                {
                    Console.WriteLine(messages[i]);
                }
            }
            else
            {
                Console.WriteLine("None");
            }
        }
    }
}
