using System;
using System.Collections.Generic;
using System.Linq;

namespace RollyTheCoderWitchClassAndObjects
{
    class Events
    {
        public string Name { get; set; }
        public List<string> Participants { get; set; }

        public Events(string name, List<string> participants)
        {
            Name = name;
            Participants = participants;
        }
        public void Print()
        {
            Console.WriteLine($"{Name} - {Participants.Count}");
            foreach (var n in Participants.OrderBy(x => x))
            {
                Console.WriteLine($"@{n}");
            }
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var dict = new Dictionary<string, Events>();
            while (input != "Time for Code")
            {
                if (input.Contains("#"))
                {
                    string[] commands = input
                    .Split(new char[] { '#', ' ', '@' }, StringSplitOptions.RemoveEmptyEntries);

                    var id = commands[0];
                    var eventName = commands[1];
                    List<string> currParicipants = new List<string>();
                    for (int i = 2; i < commands.Length; i++)
                    {
                        if (!dict.Values.Any(x => x.Participants.Contains(commands[i])))
                        {
                            currParicipants.Add(commands[i]);
                        }
                    }
                    if (!dict.ContainsKey(id))
                    {
                        dict.Add(id, new Events(eventName, currParicipants));
                    }
                    else
                    {
                        if (dict[id].Name == eventName)
                        {
                            dict[id].Participants.AddRange(currParicipants);
                            dict[id].Participants = dict[id].Participants.Distinct().ToList();
                        }
                    }
                }
                input = Console.ReadLine();
            }
            foreach (var pair in dict.OrderByDescending(x => x.Value.Participants.Count)
                .ThenBy(x => x.Value.Name))
            {
                pair.Value.Print();
            }
        }
    }
}
