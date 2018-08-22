using System;
using System.Collections.Generic;
using System.Linq;

namespace Dictionaries_LambdaAndLINQ_11._Dragon_Army
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, Dictionary<string, List<int>>>();
            var averageDict = new Dictionary<string, string>();
            int n = int.Parse(Console.ReadLine());
            while (n-- > 0)
            {
                string[] commands = Console.ReadLine()
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

                var type = commands[0];
                var name = commands[1];
                int damage = commands[2] == "null" ? 45 : int.Parse(commands[2]);
                int health = commands[3] == "null" ? 250 : int.Parse(commands[3]);
                int armor = commands[4] == "null" ? 10 : int.Parse(commands[4]);

                if (!dict.ContainsKey(type))
                {
                    dict.Add(type, new Dictionary<string, List<int>>());
                    dict[type].Add(name, new List<int>());
                    dict[type][name].Add(damage);
                    dict[type][name].Add(health);
                    dict[type][name].Add(armor);
                }
                else
                {
                    if (!dict[type].ContainsKey(name))
                    {
                        dict[type].Add(name, new List<int>());
                        dict[type][name].Add(damage);
                        dict[type][name].Add(health);
                        dict[type][name].Add(armor);
                    }
                    else
                    {
                        dict[type][name][0] = damage;
                        dict[type][name][1] = health;
                        dict[type][name][2] = armor;
                    }
                }
            }
            foreach (var pair in dict)
            {
                var type = pair.Key;
                var totalDamage = 0;
                var totalHealth = 0;
                var totalArmor = 0;
                var counter = 0;
                foreach (var pair1 in pair.Value)
                {
                    var name = pair1.Key;
                    counter++;
                    for (int i = 0; i < pair1.Value.Count; i++)
                    {
                        if (i == 0)
                        {
                            totalDamage += pair1.Value[0];
                        }
                        else if (i == 1)
                        {
                            totalHealth += pair1.Value[1];
                        }
                        else if (i == 2)
                        {
                            totalArmor += pair1.Value[2];
                        }
                    }
                }
                averageDict.Add(type, string.Empty);
                averageDict[type] = $"{type}::({(totalDamage * 1.0 / counter):F2}" +
                        $"/{(totalHealth * 1.0 / counter):F2}/{(totalArmor * 1.0 / counter):F2})";
            }
            foreach (var pair in dict)
            {
                Console.WriteLine(averageDict[pair.Key]);
                foreach (var pair1 in pair.Value.OrderBy(x => x.Key))
                {
                    Console.WriteLine($"-{pair1.Key} -> damage: {pair1.Value[0]}, health: {pair1.Value[1]}, armor: {pair1.Value[2]}");
                }
            }
        }
    }
}
