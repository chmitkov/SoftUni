using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_SampleExam_June2016_04._Population_Aggregation
{
    class Country
    {
        public string CountryName { get; set; }
        public List<Town> Towns { get; set; }

        public Country(string countryName, List<Town> towns)
        {
            CountryName = countryName;
            Towns = towns;
        }
    }
    class Town
    {
        public string TownName { get; set; }
        public long Population { get; set; }

        public Town(string townName, long population)
        {
            TownName = townName;
            Population = population;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            List<Country> result = new List<Country>();
            
            char[] prohibitedSymbols = new[] { '@', '#', '$', '&' };
            while (input!="stop")
            {
                string[] commands = input
                    .Split(new char[] { '\\' }, StringSplitOptions.RemoveEmptyEntries);
                var population = long.Parse(commands[2]);
                input = commands[0] + commands[1];
                string clearStr = string.Empty;
                foreach (var ban in prohibitedSymbols)
                {
                    input = input.Replace(ban,'1');
                }
                for (int i = 0; i < input.Length; i++)
                {
                    if (!Char.IsDigit(input[i]))
                    {
                        clearStr += input[i];
                    }
                }
                string[] com2 = clearStr.Split(new char[] { '\\' }, StringSplitOptions.RemoveEmptyEntries);

                var country = Char.IsUpper(com2[0][0])
                    ? com2[0]
                    : com2[1];
                var city = Char.IsLower(com2[0][0])
                    ? com2[0]
                    : com2[1];
                if (result.Any(x => x.CountryName == country))
                {
                    var currCountry = result.Where(x => x.CountryName == country).FirstOrDefault();
                    currCountry.Towns.Add(new Town(city, population));
                }
                else
                {
                    var currTown = new Country(country, new List<Town>());
                    currTown.Towns.Add(new Town(city, population));
                    result.Add(currTown);
                }
                input = Console.ReadLine();
            }
            foreach (var country  in result.OrderByDescending(x=>x.Towns.Count))
            {
                Console.WriteLine($"{country.CountryName} -> {country.Towns.Count}");
            }
            var allTown = result.SelectMany(x => x.Towns).ToList();
            foreach (var town in allTown.OrderByDescending(x=>x.Population).Take(3))
            {
                Console.WriteLine($"{town.TownName} -> {town.Population}");
            }
        }
    }
}
