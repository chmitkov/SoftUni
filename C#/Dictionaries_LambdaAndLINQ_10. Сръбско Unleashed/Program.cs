using System;
using System.Collections.Generic;
using System.Linq;

namespace Dictionaries_LambdaAndLINQ_10._Сръбско_Unleashed
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, Dictionary<string, decimal>>();

            string input = Console.ReadLine();

            while (input != "End")
            {
                if (input.Contains(" @") )
                {
                    string[] commands = input
                    .Split(new char[] { '@' }, StringSplitOptions.RemoveEmptyEntries);
                    var singer = commands[0].Trim();
                    var rest = commands[1].Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
                    if (rest.Length >= 3 && Char.IsDigit(rest[rest.Length - 2][0]))
                    {
                        decimal sum = decimal.Parse(rest[rest.Length - 1]) * decimal.Parse(rest[rest.Length - 2]);
                        var place = string.Empty;
                        for (int i = 0; i < rest.Length - 2; i++)
                        {
                            place += rest[i] + " ";
                        }
                        place = place.Trim();
                        if (!dict.ContainsKey(place))
                        {
                            dict.Add(place, new Dictionary<string, decimal>());
                            dict[place].Add(singer, sum);
                        }
                        else
                        {
                            if (!dict[place].ContainsKey(singer))
                            {
                                dict[place].Add(singer, sum);
                            }
                            else
                            {
                                dict[place][singer] += sum;
                            }
                        }
                    }
                }
                
                input = Console.ReadLine();
            }
            foreach (var pair in dict)
            {
                Console.WriteLine(pair.Key);
                foreach (var pair1 in pair.Value.OrderByDescending(x=>x.Value))
                {
                    Console.WriteLine($"#  {pair1.Key} -> {pair1.Value}");
                }
            }
        }
    }
}
