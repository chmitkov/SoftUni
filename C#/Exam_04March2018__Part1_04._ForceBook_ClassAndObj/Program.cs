using System;
using System.Collections.Generic;
using System.Linq;

namespace Exam_04March2018__Part1_04._ForceBook_ClassAndObj
{
    class Player
    {
        public string Side { get; set; }
        public string Name { get; set; }

        public Player(string side, string name)
        {
            Side = side;
            Name = name;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            List<Player> players = new List<Player>();
            while (input != "Lumpawaroo")
            {
                if (input.Contains("|"))
                {
                    string[] commands = input
                        .Split(new char[] { '|', }, StringSplitOptions.RemoveEmptyEntries);
                    var side = commands[0].Trim();
                    var name = commands[1].Trim();
                    if (!players.Any(x => x.Name == name))
                    {
                        var currPlayer = new Player(side,name);
                        players.Add(currPlayer);
                    }
                }
                else
                {
                    string[] commands = input
                        .Split(new char[] { '-', '>', }, StringSplitOptions.RemoveEmptyEntries);
                    var side = commands[1].Trim();
                    var name = commands[0].Trim();

                    if (players.Any(x => x.Name == name))
                    {
                        var currPlayer = players.Where(x => x.Name == name).FirstOrDefault();
                        players.Remove(currPlayer);
                    }

                    var currPlayer = 
                }

                    input = Console.ReadLine();
            }
        }
    }
}
