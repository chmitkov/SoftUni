using System;
using System.Collections.Generic;
using System.Linq;

namespace Exam_PF_Retake_25April2018_Part2_03.TseamAccount
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> allGames = Console.ReadLine()
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
                        if (!allGames.Contains(game))
                        {
                            allGames.Add(game);
                        }
                        break;
                    case "Uninstall":
                        if (allGames.Contains(game))
                        {
                            allGames.Remove(game);
                        }
                        break;
                    case "Update":
                        if (allGames.Contains(game))
                        {
                            allGames.Remove(game);
                            allGames.Add(game);
                        }
                        break;
                    case "Expansion":
                        var mainGameAndExp = game
                            .Split(new char[] { '-' }, StringSplitOptions.RemoveEmptyEntries);
                        var mainGame = mainGameAndExp[0];
                        var expan = mainGameAndExp[1];
                        if (allGames.Contains(mainGame))
                        {
                            int index = allGames.IndexOf(mainGame);
                            allGames.Insert(index + 1, $"{mainGame}:{expan}");
                        }
                        break;
                }
                input = Console.ReadLine();
            }
            Console.WriteLine(string.Join(" ",allGames));
        }
    }
}
