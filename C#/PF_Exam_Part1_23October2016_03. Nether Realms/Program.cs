using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace PF_Exam_Part1_23October2016_03._Nether_Realms
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] names = Console.ReadLine()
                .Split(new char[] { ' ',',' }, StringSplitOptions.RemoveEmptyEntries);
            HashSet<string> result = new HashSet<string>();
            char[] bannedSimbols = new char[] { '+', '-', '*', '/', '.' };
            Regex regex = new Regex(@"(-+)*([\d]+\.*[\d]*)"); 
            foreach (var name in names)
            {
                var health = 0;
                foreach (var ch in name)
                {
                    if (!bannedSimbols.Contains(ch)&&!Char.IsDigit(ch))
                    {
                        health += (int)ch;
                    }
                }
                var power = 0.0;
                var matches = regex.Matches(name);
                foreach (Match m in matches)
                {
                    if (m.Groups[1].Value == "-")
                    {
                        power -= double.Parse(m.Groups[2].Value);
                    }
                    else
                    {
                        power += double.Parse(m.Groups[2].Value);
                    }
                }
                foreach (var ch in name)
                {
                    if (ch == '*')
                    {
                        power *= 2;
                    }
                    else if (ch == '/')
                    {
                        power /= 2;
                    }
                }
                result.Add($"{name} - {health} health, {power:f2} damage");
            }
            foreach (var name in result.OrderBy(x=>x))
            {
                Console.WriteLine(name);
            }
        }
    }
}
