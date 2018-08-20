using System;
using System.Text.RegularExpressions;

namespace String
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var total = 0m;
            while (input != "end of shift")
            {
                try
                {
                    int firstPercentIndex = input.IndexOf("%");
                    input = input.Substring(firstPercentIndex + 1);
                    int secondIndexOfPercent = input.IndexOf("%");
                    var name = input.Substring(0, secondIndexOfPercent);
                    int firstIndexArrow = input.IndexOf("<");
                    input = input.Substring(firstIndexArrow + 1);
                    var seconINdexArrow = input.IndexOf(">");
                    var product = input.Substring(0, seconINdexArrow);
                    int firstIndexPipe = input.IndexOf("|");
                    input = input.Substring(firstIndexPipe + 1);
                    var secondIndexPipe = input.IndexOf("|");
                    var count = int.Parse(input.Substring(0, secondIndexPipe));
                    input = input.Substring(secondIndexPipe + 1);
                    Regex regex = new Regex(@"([0-9]+\.*[0-9]*)\$");
                    var price = decimal.Parse(regex.Match(input).Groups[1].Value);
                    var currentPrice = count * price;
                    total += currentPrice;
                    Console.WriteLine($"{name}: {product} - {currentPrice:f2}");

                }
                catch (Exception)
                {
                    input = Console.ReadLine();

                }
                input = Console.ReadLine();
            }
            Console.WriteLine($"Total income: {total:f2}");
        }
    }
}
