using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Retake_Exam___25_April_2018_Part_I_03._Tseam_Account
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> allGames = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .ToList();
            string input = Console.ReadLine();
            List<string> result = new List<string>();
            while (input != "Play!")
            {
                var commands = input
                    .Split(new char[] { ' ', '-' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                switch (commands[0])
                {
                    case "Install":
                        var gameToInstall = commands[1];
                        if (!allGames.Contains(gameToInstall))
                        {
                            allGames.Add(gameToInstall);

                        }
                        break;
                    case "Uninstall":
                        var gameToUninstall = commands[1];
                        for (int i = 0; i < allGames.Count; i++)
                        {
                            if (allGames[i] == gameToUninstall)
                            {
                                allGames.RemoveAt(i);
                            }
                        }
                        break;
                    case "Update":
                        var gameToUpdate = commands[1];
                        if (allGames.Contains(gameToUpdate))
                        {
                            allGames.Remove(gameToUpdate);
                            allGames.Add(gameToUpdate);
                        }
                        break;
                    case "Expansion":
                        var gameToExp = commands[1];
                        var expan = commands[2];

                        if (allGames.Contains(gameToExp))
                        {
                            var index = allGames.IndexOf(gameToExp);
                            if (index != allGames.Count - 1)
                            {
                                allGames.Insert(index + 1, $"{gameToExp}:{expan}");
                            }
                            else
                            {
                                allGames.Add($"{gameToExp}:{expan}");
                            }
                        }
                        //for (int i = 0; i < allGames.Count; i++)
                        //{
                        //    if (allGames[i] == gameToExp)
                        //    {
                        //        result.AddRange(allGames.Take(i+1));
                        //        result.Add($"{gameToExp}:{expan}");
                        //        result.AddRange(allGames.Skip(i + 1));
                        //        allGames.Clear();
                        //        allGames.AddRange(result);
                        //    }
                        //}
                        break;
                }
                input = Console.ReadLine();
            }
            Console.WriteLine(string.Join(" ", allGames));
        }
    }
}
