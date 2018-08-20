using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace PF_Retake_Exam___25_April_2018_Part_I_02._Memory_View
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string command = string.Empty;
            List<string> names = new List<string>();
            while (input != "Visual Studio crash")
            {
                command += input;
                input = Console.ReadLine();
            }
            string toRemovePattern = @"(32656 19759 32763)|( 0 )";
            Regex regex = new Regex(toRemovePattern);
            var removedString = regex.Replace(command, "!").ToString();            
            names = removedString
                .Split(new char[] { '!' }, StringSplitOptions.RemoveEmptyEntries)
                .Where(x=>x.Length>1)
                .ToList();
            foreach (var name in names)
            {
                var words = name.Split(' ')
                    .Select(int.Parse)
                    .ToArray();
                foreach (var word in words)
                {
                     
                    //Console.WriteLine((char)word);
                }
                Console.WriteLine(name);
            }
        }
    }
}
