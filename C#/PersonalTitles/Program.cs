using System;
using System.Collections.Generic;
using System.Text;
using System.Linq;
using System.Threading.Tasks;
namespace PersonalTitles
{
    class Program
    {
        static void Main(String[] args)
        {
            var age = double.Parse(Console.ReadLine());
            var gender = Console.ReadLine().ToLower();
            if (age <= 16)
            {
                if (gender == "m")
                {
                    Console.WriteLine("Master");
                }
                else
                {
                    Console.WriteLine("Miss");
                }
            }
            else
            {
                if (gender == "m")
                {
                    Console.WriteLine("Mr.");
                }
                else
                {
                    Console.WriteLine("Ms.");
                }
            }

        }
    }
}