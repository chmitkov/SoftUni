using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using System.Linq;

namespace Exam_Preparation_IV_03.Football_League
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, int[]>();
            string key = Console.ReadLine();
            string escapedKey = string.Empty;
            for (int i = 0; i < key.Length; i++)
            {
                escapedKey += $@"\{key[i]}";
            }
            string input = Console.ReadLine();

            while (input != "final")
            {
                List<string> teams = new List<string>();
                string pattern = $"{escapedKey}([A-Za-z]+?){escapedKey}";
                //pattern =  + pattern;
                var matchesTeams = Regex.Matches(input,
                    pattern);
                foreach (Match team in matchesTeams)
                {
                    teams.Add(team.Groups[1].Value);
                }
                var team1 = teams[0].ToUpper().ToString();
                var team2 = teams[1].ToUpper().ToString();
                var score = Regex.Match(input,
                    @"(\d+):(\d+)");
                var team1score = int.Parse(score.Groups[1].Value);
                var team2score = int.Parse(score.Groups[2].Value);

                if (!dict.ContainsKey(team1))
                {
                    dict.Add(team1, new int[2]);
                }
                if (!dict.ContainsKey(team2))
                {
                    dict.Add(team2, new int[2]);
                }

                if (team1score > team2score)
                {
                    dict[team1][0] += 3;
                    dict[team1][1] += team1score;
                    dict[team2][1] += team2score;
                }
                else if (team2score > team1score)
                {
                    dict[team2][0] += 3;
                    dict[team1][1] += team1score;
                    dict[team2][1] += team2score;
                }
                else
                {
                    dict[team1][0] += 1;
                    dict[team2][0] += 1;
                    dict[team1][1] += team1score;
                    dict[team2][1] += team2score;
                }
                input = Console.ReadLine();
            }
            var position = 1;
            Console.WriteLine("League standings:");
            foreach (var pair in dict.OrderByDescending(x => x.Value[0])
                .ThenBy(x => x.Key))
            {

                Console.WriteLine($"{position}. {string.Join("", pair.Key.ToCharArray().Reverse())} {pair.Value[0]}");
                position++;

            }
            Console.WriteLine("Top 3 scored goals:");
            foreach (var pair in dict.OrderByDescending(x => x.Value[1]).Take(3))
            {

                Console.WriteLine($"- {string.Join("", pair.Key.ToCharArray().Reverse())} -> {pair.Value[1]}");
            }
        }
    }
}
