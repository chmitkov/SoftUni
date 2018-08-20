using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace PF_Exam___04_March_2018_Part_I__03._Star_Enigma
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            char[] letters = { 's', 't', 'a', 'r', 'S', 'T','A','R' };
            string [] collection = {"@", "-", "!", ":", ">" };
            
            List<string> attackedPlanets = new List<string>();
            List<string> destroyedPlanets = new List<string>();
            for (int i = 0; i < n; i++)
            {
                string input = Console.ReadLine();
                var decriptText = string.Empty;
                var lettersCountInText = 0;
                bool isValid = true;
                for (int j = 0; j < input.Length; j++)
                {
                    foreach (var ch in letters)
                    {
                        if (ch == input[j])
                        {
                            lettersCountInText++;
                        }
                    }
                }
                foreach (var ch in input)
                {
                    var newCh = (int)ch - lettersCountInText;
                    decriptText += (char)newCh;
                }
                foreach (var item in collection)
                {
                    if (!decriptText.Contains(item))
                    {
                        isValid = false;
                    }
                }
                if (isValid)
                {
                    string planetPattern = @"@([A-Za-z]+)";
                    Regex regex = new Regex(planetPattern);
                    var planet = regex.Match(decriptText).Groups[1].ToString();

                    //string populationPattern = @":([0-9]+)";
                    //Regex regex2 = new Regex(populationPattern);
                    //var population = int.Parse(regex2.Match(decriptText).Groups[1].ToString());

                    string attackType = @"!(A|D)!";
                    Regex regex3 = new Regex(attackType);
                    var attack = regex3.Match(decriptText).Groups[1].ToString();

                    //string soldiersPattern = @"(?:->)([0-9]+)";
                    //Regex regex4 = new Regex(soldiersPattern);
                    //var soldiers = int.Parse(regex4.Match(decriptText).Groups[1].ToString());

                    if (attack == "A")
                    {
                        attackedPlanets.Add(planet);
                    }
                    else if (attack == "D")
                    {
                        destroyedPlanets.Add(planet);
                    }
                }                               
            }
            Console.WriteLine($"Attacked planets: {attackedPlanets.Count}");
            attackedPlanets.Sort();
            foreach (var planet in attackedPlanets)
            {
                Console.WriteLine($"-> {planet}");
            }
            Console.WriteLine($"Destroyed planets: {destroyedPlanets.Count}");
            destroyedPlanets.Sort();
            foreach (var planet in destroyedPlanets)
            {
                Console.WriteLine($"-> {planet}");
            }
        }
    }
}
