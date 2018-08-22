using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam_Part1_23October2016_04._Roli_The_Coder
{
    class PartyID
    {
        public string Name { get; set; }
        public string Id { get; set; }
        public HashSet<string> Participants { get; set; }

        public PartyID(string name, string id, HashSet<string> participants)
        {
            Name = name;
            Id = id;
            Participants = participants;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, Dictionary<string, List<string>>>();
            string input = Console.ReadLine();
            HashSet<PartyID> result = new HashSet<PartyID>();
            while (input != "Time for Code")
            {
                string[] commands = input
                    .Split(new char[] { ' ', '#', '@' }, StringSplitOptions.RemoveEmptyEntries);

                var id = commands[0];
                var partyName = commands[1];
                var participants = commands.Skip(2).ToHashSet();

                if (input.Contains("#"))
                {
                    if (result.Any(x => x.Id == id))
                    {
                        if (result.Any(x => x.Name == partyName))
                        {
                            var currParty = result.Where(x => x.Name == partyName).FirstOrDefault();
                            foreach (var p in participants)
                            {
                                currParty.Participants.Add(p);
                            }
                        }
                    }
                    else
                    {
                        var currentParty = new PartyID(partyName, id, participants);
                        result.Add(currentParty);
                    }
                }
                
                input = Console.ReadLine();
            }
            foreach (var part in result.OrderByDescending(x=>x.Participants.Count())
                .ThenBy(x=>x.Name))
            {
                Console.WriteLine($"{part.Name} - {part.Participants.Count}");
                foreach (var p in part.Participants.OrderBy(x=>x))
                {
                    Console.WriteLine($"@{p}");
                }
            }
        }
    }
}
