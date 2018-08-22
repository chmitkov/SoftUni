using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestNastedDictionary
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            string[] command = new string[3];
            var countinents = 
                new Dictionary<string, Dictionary<string, List<string>>>();
            for (int i = 0; i < n; i++)
            {
                command = Console.ReadLine()
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                var countinent = command[0];
                var country = command[1];
                var city = command[2];
                if (!countinents.ContainsKey(countinent))
                {
                    countinents[countinent] = new Dictionary<string, List<string>>();
                }
                if (!countinents[countinent].ContainsKey(country))
                {
                    countinents[countinent][country] = new List<string>();
                }
                countinents[countinent][country].Add(city);
            }
            foreach (var coun in countinents)
            {
                var countinentName = coun.Key;
                Console.WriteLine($"{countinentName}: ");
                foreach (var pair in coun.Value)
                {
                    var countryName = pair.Key;
                    var cityName = string.Join(", ", pair.Value);
                    Console.WriteLine($"    {countryName} -> {cityName}");
                }
            }
        }
    }
}
