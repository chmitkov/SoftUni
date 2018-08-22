using System;
using System.Collections.Generic;
using System.Linq;
namespace Dictionaries_LambdaAndLINQ_09._Legendary_Farming
{
    class Program
    {
        static void Main(string[] args)
        {
            var keyMatherials = new Dictionary<string, int>();
            keyMatherials.Add("fragments", 0);
            keyMatherials.Add("motes", 0);
            keyMatherials.Add("shards", 0);
            var junk = new Dictionary<string, int>();
            bool flag = true;
            var key = string.Empty;
            var item = string.Empty;
            while (flag)
            {
                string[] commands = Console.ReadLine().ToLower()
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
                for (int i = 1; i < commands.Length; i+=2)
                {
                    var mat = commands[i];
                    var quantity = int.Parse(commands[i - 1]);

                    if (keyMatherials.ContainsKey(mat))
                    {
                        keyMatherials[mat] += quantity;

                        if (keyMatherials[mat] >= 250)
                        {
                            flag = false;
                            keyMatherials[mat] -= 250;
                            key = mat;
                            break;
                        }
                    }
                    else
                    {
                        if (!junk.ContainsKey(mat))
                        {
                            junk.Add(mat, quantity);
                        }
                        else
                        {
                            junk[mat] += quantity;
                        }
                    }
                }
            }
            if (key == "shards")
            {
                item = "Shadowmourne";
            }
            else if (key == "fragments")
            {
                item = "Valanyr";
            }
            else if (key == "motes")
            {
                item = "Dragonwrath";
            }
            Console.WriteLine($"{item} obtained!");
            foreach (var pair in keyMatherials.OrderByDescending(x=>x.Value))
            {
                Console.WriteLine($"{pair.Key}: {pair.Value}");
            }
            foreach (var pair in junk.OrderBy(x=>x.Key))
            {
                Console.WriteLine($"{pair.Key}: {pair.Value}");
            }
        }
    }
}