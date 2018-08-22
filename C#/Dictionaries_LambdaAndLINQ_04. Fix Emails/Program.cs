using System;
using System.Collections.Generic;
using System.Linq;

namespace Dictionaries_LambdaAndLINQ_04._Fix_Emails
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, string>();

            string input = Console.ReadLine();

            while (input != "stop")
            {
                var name = input;
                var mail = Console.ReadLine();
                string[] lastString = mail.Split('.').ToArray();
                var last = lastString[1];

                if (!(last == "us" || last == "uk"))
                {
                    if (!dict.ContainsKey(name))
                    {
                        dict.Add(name, mail);
                    }
                    else
                    {
                        dict[name] = mail;
                    }
                }
                input = Console.ReadLine();
            }
            foreach (var pair in dict)
            {
                Console.WriteLine($"{pair.Key} -> {pair.Value}");
            }
        }
    }
}
