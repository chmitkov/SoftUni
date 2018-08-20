using System;
using System.Collections.Generic;
using System.Linq;

namespace Exam_PF_Retake_25April2018_Part2_04._MOBA_Challenger
{
    class Player
    {
        public string Name { get; set; }
        public Dictionary<string,int> Place { get; set; }

        public Player(string name, Dictionary<string, int> place)
        {
            Name = name;
            Place = place;
        }

        public void Print()
        {
            Console.WriteLine($"{Name}: {Place.Values.Sum()} skill");
            foreach (var pair in Place.OrderByDescending(x=>x.Value).ThenBy(x=>x.Key))
            {
                Console.WriteLine($"- {pair.Key} <::> {pair.Value}");
            }
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            List<Player> players = new List<Player>();
            while (input != "Season end")
            {
                if (input.Contains("vs"))
                {
                    var commands = input.
                        Split(new [] { "vs"," "}, StringSplitOptions.RemoveEmptyEntries);
                    var player1 = commands[0];
                    var player2 = commands[1];

                    if (players.Any(x => x.Name== player1)
                        && players.Any(x => x.Name==player2))
                    {
                        var currP1 = players.Where(x => x.Name == player1).FirstOrDefault();
                        var currP2 = players.Where(x => x.Name == player2).FirstOrDefault();
                        bool flag = false;
                        foreach (var item in currP1.Place.Keys)
                        {
                            if (currP2.Place.Keys.Contains(item))
                            {
                                flag = true;
                            }
                        }
                        if (flag)
                        {
                            if (currP1.Place.Values.Sum() > currP2.Place.Values.Sum())
                            {
                                players.Remove(currP2);
                                players.Remove(players.Where(x => x.Name == currP2.Name).FirstOrDefault());
                            }
                            else if (currP1.Place.Values.Sum() < currP2.Place.Values.Sum())
                            {
                                players.Remove(currP1);
                                players.Remove(players.Where(x => x.Name == currP1.Name).FirstOrDefault());
                            }
                        }
                    }
                }
                else
                {
                    var commands = input
                        .Split(new char[] { '-', '>', ' ' }, StringSplitOptions.RemoveEmptyEntries);
                    var name = commands[0];
                    var place = commands[1];
                    var skill = int.Parse(commands[2]);


                    if (!players.Any(x => x.Name == name))
                    {
                        var currP = new Player(name,new Dictionary<string, int>());
                        currP.Place.Add(place, skill);
                        players.Add(currP);
                    }
                    else
                    {
                        var currP = players.Where(x => x.Name == name).FirstOrDefault();
                        if (!currP.Place.ContainsKey(place))
                        {
                            currP.Place.Add(place,skill);
                        }
                        else
                        {
                            if (currP.Place[place] < skill)
                            {
                                currP.Place[place] = skill;
                            }
                        }
                    }
                }

                input = Console.ReadLine();
            }
            foreach (var p in players.OrderByDescending(x=>x.Place.Values.Sum())
                .ThenBy(p=>p.Name))
            {
                p.Print();
            }
        }
    }
}
