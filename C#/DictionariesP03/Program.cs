using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DictionariesP03
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var input = new string[3];
            var countData = new Dictionary<string, Dictionary<string, List<string>>>();
            for (int i = 0; i < n; i++)
            {
                input = Console.ReadLine()
                    .Split(new char[] { ' ' }, StringSplitOptions
                    .RemoveEmptyEntries)
                    .ToArray();
                var countinent = input[0];
                var country = input[1];
                var city = input[2];
                if (!countData.ContainsKey(countinent))
                {
                    countData[countinent] = new Dictionary<string, List<string>>();
                }
                if (!countData[countinent].ContainsKey(country))
                {
                    countData[countinent][country] = new List<string>();
                }
                countData[countinent][country].Add(city);
            }
            foreach (var pair in countData)
            {
                var countinentName = pair.Key;
                var country = pair.Value;
                Console.WriteLine($"{countinentName}: ");
                foreach (var countryCities in country)
                {
                    var countriesName = countryCities.Key;
                    var cities = string.Join(", ", countryCities.Value);
                    Console.WriteLine($"    {countriesName} -> {cities} ");
                       
                }
            }
        }
    }
}
