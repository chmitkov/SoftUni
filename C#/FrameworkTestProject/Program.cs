using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace FrameworkTestProject
{
    class Message
    {
        public string ResipientsCode { get; set; }
        public string Mess { get; set; }

        public Message(string resipientsCode, string message)
        {
            this.ResipientsCode = resipientsCode;
            this.Mess = message;
        }

    }
    class Broadcast
    {
        public string Frequency { get; set; }
        public string Message { get; set; }

        public Broadcast(string frequency, string message)
        {
            this.Frequency = frequency;
            this.Message = message;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            List<Message> listOfmessages = new List<Message>();
            List<Broadcast> listOfBroadcas = new List<Broadcast>();
            Regex messageRegex = new Regex(@"^([0-9]+)\s<->\s([A-Za-z0-9]+)$");
            Regex broadcastRegex = new Regex(@"^([^0-9]+)\s<->\s([A-Za-z0-9]+)$");

            while (input != "Hornet is Green")
            {
                if (messageRegex.IsMatch(input))
                {
                    var recipCode = messageRegex.Match(input).Groups[1].Value;
                    var reverseCode = string.Join("", recipCode.ToCharArray().Reverse());
                    var message = messageRegex.Match(input).Groups[2].Value;
                    listOfmessages.Add(new Message(reverseCode, message));
                }
                else if (broadcastRegex.IsMatch(input))
                {
                    var message = broadcastRegex.Match(input).Groups[1].Value;
                    var frequency = broadcastRegex.Match(input).Groups[2].Value;
                    frequency = ChangeSmallBigLetters(frequency);
                    listOfBroadcas.Add(new Broadcast(frequency, message));
                }
                input = Console.ReadLine();
            }
            Console.WriteLine("Broadcasts:");
            if (listOfBroadcas.Count > 0)
            {
                foreach (Broadcast broad in listOfBroadcas)
                {
                    Console.WriteLine($"{broad.Frequency} -> {broad.Message}");
                }
            }
            else
            {
                Console.WriteLine("None");
            }
            Console.WriteLine("Messages:");
            if (listOfmessages.Count > 0)
            {
                foreach (Message mess in listOfmessages)
                {
                    Console.WriteLine($"{mess.ResipientsCode} ->{mess.Mess}");
                }
            }
            else
            {
                Console.WriteLine("None");
            }
        }

        private static string ChangeSmallBigLetters(string frequency)
        {
            var result = string.Empty;
            for (int i = 0; i < frequency.Length; i++)
            {
                if (Char.IsUpper(frequency[i]))
                {
                    result += (Char.ToLower(frequency[i]));
                }
                else if (Char.IsLower(frequency[i]))
                {
                    result += (Char.ToUpper(frequency[i]));
                }
                else
                {
                    result += frequency[i];
                }
            }
            return result;
        }
    }
}