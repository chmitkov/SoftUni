using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Retake_Exam_25April2018Part_I_03._Tseam_Account
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> games = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .ToList();

            string input = Console.ReadLine();

            while (input != "Play!")
            {
                string[] commands = input
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
                var action = commands[0];
                var game = commands[1];

                switch (action)
                {
                    case "Install":
                        if (!games.Contains(game))
                        {
                            games.Add(game);
                        }
                        break;
                    case "Uninstall":
                        if (games.Contains(game))
                        {
                            games.Remove(game);
                        }
                        break;
                    case "Update":
                        if (games.Contains(game))
                        {
                            games.Remove(game);
                            games.Add(game);
                        }
                        break;
                    case "Expansion":
                        var expan = game.Split("-");
                        var mainGame = expan[0];
                        var expanName = expan[1];
                        if (games.Contains(mainGame))
                        {
                           var index =  games.IndexOf(mainGame);
                            games.Insert(index+1, $"{mainGame}:{expanName}");
                        }
                        break;
                }
                input = Console.ReadLine();
            }
            Console.WriteLine(string.Join(" ",games));
        }
    }
}
