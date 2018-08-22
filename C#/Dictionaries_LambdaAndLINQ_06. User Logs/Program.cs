using System;
using System.Collections.Generic;
using System.Linq;

namespace Dictionaries_LambdaAndLINQ_06._User_Logs
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, Dictionary<string, int>>();

            string input = Console.ReadLine();

            while (input != "end")
            {
                string[] commands = input
                    .Split(new char[] { ' ', '=' }, StringSplitOptions.RemoveEmptyEntries);
                var ip = commands[1];
                var user = commands[commands.Length-1];
                if (!dict.ContainsKey(user))
                {
                    dict.Add(user, new Dictionary<string, int>());
                    dict[user].Add(ip, 1);
                }
                else
                {
                    if (!dict[user].ContainsKey(ip))
                    {
                        dict[user].Add(ip, 1);
                    }
                    else
                    {
                        dict[user][ip]++;
                    }
                }
                input = Console.ReadLine();
            }
            List<string> result = new List<string>();
            foreach (var pair in dict.OrderBy(x => x.Key))
            {
                Console.WriteLine($"{pair.Key}:");
                foreach (var pair1 in pair.Value)
                {
                    result.Add($"{pair1.Key} => {pair1.Value}");
                }
                Console.WriteLine(string.Join(", ", result) + ".");
                result.Clear();
            }
        }
    }
}
