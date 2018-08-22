using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test
{
    class Program
    {
        static void Main(string[] args)
        {
            int groupSize = int.Parse(Console.ReadLine());
            string package = Console.ReadLine().ToLower();
            double totalPrice = 0;
            var hall = "";
            double pricePerPerson = 0;
            switch (package)
            {
                case "normal":
                    totalPrice += 500;
                    if (groupSize <= 50)
                    {
                        totalPrice += 2500;
                        totalPrice = totalPrice * 0.95;
                        hall = "Small Hall";
                    }
                    else if (groupSize <= 100)
                    {
                        totalPrice += 5000;
                        totalPrice = totalPrice * 0.95;
                        hall = "Terrace";
                    }
                    else if (groupSize <= 120)
                    {
                        totalPrice += 7500;
                        totalPrice = totalPrice * 0.95;
                        hall = "Great Hall";
                    }
                    else
                    {
                        Console.WriteLine("We do not have an appropriate hall.");
                        return;
                    }
                    break;
                case "gold":
                    totalPrice += 750;
                    if (groupSize <= 50)
                    {
                        totalPrice += 2500;
                        totalPrice = totalPrice * 0.90;
                        hall = "Small Hall";
                    }
                    else if (groupSize <= 100)
                    {
                        totalPrice += 5000;
                        totalPrice = totalPrice * 0.90;
                        hall = "Terrace";
                    }
                    else if (groupSize <= 120)
                    {
                        totalPrice += 7500;
                        totalPrice = totalPrice * 0.90;
                        hall = "Great Hall";
                    }
                    else
                    {
                        Console.WriteLine("We do not have an appropriate hall.");
                        return;
                    }
                    break;
                case "platinum":
                    totalPrice += 1000;
                    if (groupSize <= 50)
                    {
                        totalPrice += 2500;
                        totalPrice = totalPrice * 0.85;
                        hall = "Small Hall";
                    }
                    else if (groupSize <= 100)
                    {
                        totalPrice += 5000;
                        totalPrice = totalPrice * 0.85;
                        hall = "Terrace";
                    }
                    else if (groupSize <= 120)
                    {
                        totalPrice += 7500;
                        totalPrice = totalPrice * 0.85;
                        hall = "Great Hall";
                    }
                    else
                    {
                        Console.WriteLine("We do not have an appropriate hall.");
                        return;
                    }
                    break;
            }
            Console.WriteLine($"We can offer you the {hall}");
            Console.WriteLine($"The price per person is" +
                $" {(totalPrice * 1.0 / groupSize):F2}$");
            //We can offer you the Small Hall
            //The price per person is 146.25$
        }
    }
}
