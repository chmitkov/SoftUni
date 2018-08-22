using System;
using System.Text.RegularExpressions;
using System.Linq;
namespace _02._Hornet_Comm
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            Regex messageRegex = new Regex(@"^([\d]+) <-> ([A-Za-z0-9]+)$");
            Regex broadcastRegex = new Regex(@"^([^\d]+) <-> ([A-Za-z0-9]+)$");
            while (input != "Hornet is Green")
            {
                if (messageRegex.IsMatch(input))
                {
                    var recipientsCode = messageRegex.Match(input).Groups[1].Value;
                    var reverseCode = string.Join("", recipientsCode.ToCharArray().Reverse());
                    var message = messageRegex.Match(input).Groups[2].Value;
                    Console.WriteLine(reverseCode);
                }
                else if (broadcastRegex.IsMatch(input))
                {

                }


                input = Console.ReadLine();
            }
        }
    }
}
