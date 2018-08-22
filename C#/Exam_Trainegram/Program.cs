using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Exam_Trainegram
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            List<string> result = new List<string>();
            var pattern = @"^(\<\[[^A-Za-z0-9]*\][\.]{1})+([\.]{1}\[[A-Za-z0-9]*\][\.]{1})*$";
            while (input != "Traincode!")
            {
                
                Match train = Regex.Match(input, pattern);
                if (train.Success)
                {
                    result.Add(train.ToString());
                }
                input = Console.ReadLine();
            }
            Console.WriteLine(string.Join("\n", result ));
        }
    }
}
