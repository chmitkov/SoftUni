using System;
using System.Text.RegularExpressions;

namespace Exam_Problem_03
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            Regex regex = new Regex(@"%([A-Z][a-z]+)%[^\%\|\$\.]*<(\w+)>[^\%\|\$\.]*\|([0-9]*)\|[^\%\|\$\.0-9]*([0-9]+\.*[0-9]*)\$");
            var total = 0m;
            while (input != "end of shift")
            {
                if (regex.IsMatch(input))
                {
                    var name = regex.Match(input).Groups[1].Value;
                    var product = regex.Match(input).Groups[2].Value;
                    var count = int.Parse(regex.Match(input).Groups[3].ToString());
                    decimal price = decimal.Parse(regex.Match(input).Groups[4].Value);
                    decimal currTotal = count * price;
                    total += currTotal;
                    Console.WriteLine($"{name}: {product} - {currTotal:f2}");
                }
                input = Console.ReadLine();
            }
            Console.WriteLine($"Total income: {total:f2}");
        }
    }
}
