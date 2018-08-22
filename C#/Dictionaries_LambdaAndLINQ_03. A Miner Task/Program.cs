using System;
using System.Collections.Generic;

namespace Dictionaries_LambdaAndLINQ_03._A_Miner_Task
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, decimal>();
            string input = Console.ReadLine();
            while (input!="stop")
            {
                var name = input;
                var quantity = decimal.Parse(Console.ReadLine());

                if (!dict.ContainsKey(name))
                {
                    dict.Add(name, quantity);
                }
                else
                {
                    dict[name] += quantity;
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
