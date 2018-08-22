using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Exam_Preparation4_03FootballLeague
{
    class Program
    {
        static void Main(string[] args)
        {
            string key = Console.ReadLine();
            string message = Console.ReadLine().ToLower();
            var table = new Dictionary<string, int>();
            var goals = new Dictionary<string, int>();
            var test = new List<string>();
            while (message != "final")
            {
                message.Replace(key, " ");
                var command = message.Split(' ')
                    .ToList();
                foreach (var word in command)
                {
                    test.Add(word);
                }
                var pattern = @"([A-Za-z]+)";
               
                //foreach (var word in command)
                //{
                //    var regex = new Regex(pattern);
                //    if (!regex.IsMatch(word))
                //    {
                //        command.Remove(word);
                //    }
                //}

                //    var team1 = command[0];
                //    var team2 = command[1];
                //    int[] result = command[2].Split(':').Select(int.Parse).ToArray();
                //    if (!table.ContainsKey(team1))
                //    {
                //        table.Add(team1, 0);
                //    }
                //    if (!table.ContainsKey(team2))
                //    {
                //        table.Add(team2, 0);
                //    }
                //    if (result[0] > result[1])
                //    {
                //        table[team1] += 3;
                //    }
                //    else if (result[0] < result[1])
                //    {
                //        table[team2] += 3;
                //    }
                //    else
                //    {
                //        table[team1] += 1;
                //        table[team2] += 1;
                //    }
                //    //Goals table:
                //    if (!goals.ContainsKey(team1))
                //    {
                //        goals.Add(team1, 0);
                //    }
                //    if (!goals.ContainsKey(team2))
                //    {
                //        goals.Add(team2, 0);
                //    }
                //    goals[team1] += result[0];
                //    goals[team2] += result[1];

                //    message = Console.ReadLine();
                //}

                //Console.WriteLine("League standings:");
                //var place = 1;
                //foreach (var pair in table.OrderByDescending(x=>x.Value))
                //{
                //    Console.WriteLine($"{place}.{pair.Key.Reverse()} {pair.Value}");
                //    place++;
                //}
                //Console.WriteLine("Top 3 scored goals:");
                //foreach (var pair in goals.OrderByDescending(x=>x.Value))
                //{
                //    Console.WriteLine($"- {pair.Key.Reverse()} -> {pair.Value}");
            }
            Console.WriteLine(String.Join(" ", test));

            //League standings:
            //1.BULGARIA 3
            //2.GERMANY 3
            //3.FRANCE 2
            //4.DENMARK 1
            //5.ITALY 1
            //6.ENGLAND 0
            //7.SPAIN 0


        }
    }
}
