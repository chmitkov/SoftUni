using System;
using System.Collections.Generic;
using System.Linq;

namespace Exam_Problem_04
{
    class Program
    {
        static void Main(string[] args)
        {
            var languageDict = new Dictionary<string, int>();
            var playerDict  = new Dictionary<string, int>();
            List<string> banned = new List<string>();

            string input = Console.ReadLine();

            while (input!= "exam finished")
            {
                string[] commands = input
                    .Split(new char[] { '-' }, StringSplitOptions.RemoveEmptyEntries);
                if (commands.Length == 3)
                {
                    var name = commands[0];
                    var language = commands[1];
                    var points = int.Parse(commands[2]);

                    if (!languageDict.ContainsKey(language))
                    {
                        languageDict.Add(language, 1);
                    }
                    else
                    {
                        languageDict[language]++;
                    }
                    if (!playerDict.ContainsKey(name))
                    {
                        playerDict.Add(name, points);
                    }
                    else
                    {
                        if (playerDict[name] < points)
                        {
                            playerDict[name] = points;
                        }
                    }
                }
                else
                {
                    var nameToBann = commands[0];
                    banned.Add(nameToBann);

                }

                input = Console.ReadLine();
            }
            Console.WriteLine("Results:");
            foreach (var p in playerDict.OrderByDescending(x=>x.Value).ThenBy(x=>x.Key))
            {
                if (!banned.Contains(p.Key))
                {
                    Console.WriteLine($"{p.Key} | {p.Value}");
                }
            }
            Console.WriteLine("Submissions:");
            foreach (var sub in languageDict.OrderByDescending(x=>x.Value).ThenBy(x=>x.Key))
            {
                Console.WriteLine($"{sub.Key} - {sub.Value}");
            }
        }
    }
}
