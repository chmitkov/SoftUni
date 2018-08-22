using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace PF_Exam_Preparation_IV_03._Football_League
{
    class Program
    {
        static void Main(string[] args)
        {
            string key = Console.ReadLine();
            string input = Console.ReadLine();
            var table = new Dictionary<string, int>();
            var scoreTable = new Dictionary<string, int>();
            while (input != "final")
            {
                string[] commands = input
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                string str = "(.{" + $"{key.Length}" + "})([A-Za-z]+)\\1";
                string pattern = @""+str;
                Regex regex = new Regex(pattern);
                var team1 = regex.Match(commands[0])
                    .Groups[2]
                    .ToString().ToUpper();
                var team1Name = ReverseTeam(team1); 
                var team2 = regex.Match(commands[1])
                    .Groups[2]
                    .ToString().ToUpper();
                var team2Name = ReverseTeam(team2);
                var scoreBoard = commands[2]
                    .Split(new char[] { ':' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                var team1Score = int.Parse(scoreBoard[0]);
                var team2Score = int.Parse(scoreBoard[1]);
                if (!table.ContainsKey(team1Name))
                {
                    table[team1Name] = 0;
                }
                if (!table.ContainsKey(team2Name))
                {
                    table[team2Name] = 0;
                }

                if (team1Score > team2Score)
                {
                    table[team1Name] += 3;
                }
                else if (team2Score > team1Score)
                {
                    table[team2Name] += 3;
                }
                else
                {
                    table[team1Name]++;
                    table[team2Name]++;
                }
                if (!scoreTable.ContainsKey(team1Name))
                {
                    scoreTable.Add(team1Name, team1Score);
                }
                else
                {
                    scoreTable[team1Name] += team1Score;
                }
                if (!scoreTable.ContainsKey(team2Name))
                {
                    scoreTable.Add(team2Name, team2Score);
                }
                else
                {
                    scoreTable[team2Name] += team2Score;
                }

                input = Console.ReadLine();
            }
            Console.WriteLine("League standings:");
            var position = 1;
            foreach (var pair in table.OrderByDescending(x=>x.Value))
            {
                Console.WriteLine($"{position++}. {pair.Key} {pair.Value}");
            }
            Console.WriteLine("Top 3 scored goals:");
            foreach (var pair in scoreTable.OrderByDescending(x => x.Value)
                .ThenBy(x => x.Key).Take(3))
            {
                Console.WriteLine($"- {pair.Key} -> {pair.Value}");
            }
        }
         static string ReverseTeam(string team1)
        {
            char[] currentArray = team1.ToCharArray();
            team1 = string.Empty;
            for (int i = currentArray.Length - 1; i >= 0; i--)
            {
                team1 += currentArray[i];
            }
            return team1;
        }
    }
}
