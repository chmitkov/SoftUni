using System;
using System.Collections.Generic;
using System.Text;

namespace Objects_Classes_MoreExercises_02.VehicleCatalogue
{
    class Veahicle
    {
        public string Type { get; set; }
        public string Model { get; set; }
        public string Color { get; set; }
        public int HP { get; set; }
    }
    class Program
    {
        static void Main(string[] args)
        {
            int totalCarHP = 0;
            int totalCar = 0;
            int totalTruckHP = 0;
            int totalTruck = 0;
            List<Veahicle> list = new List<Veahicle>();
            string input = Console.ReadLine();
            while (input != "End")
            {
                string[] commands = input
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
                var curr = new Veahicle()
                {
                    Type = commands[0].ToLower(),
                    Model = commands[1],
                    Color = commands[2],
                    HP = int.Parse(commands[3])
                };
                list.Add(curr);
                if (commands[0].ToLower() == "car")
                {
                    totalCar++;
                    totalCarHP += int.Parse(commands[3]);
                }
                else
                {
                    totalTruck++;
                    totalTruckHP += int.Parse(commands[3]);
                }

                input = Console.ReadLine();
            }
            string input2 = Console.ReadLine();
            while (input2 != "Close the Catalogue")
            {
                foreach (var obj in list)
                {
                    if (obj.Model == input2)
                    {
                        Console.WriteLine($"Type: {FirstCharToUpper(obj.Type)}");
                        Console.WriteLine($"Model: {obj.Model}");
                        Console.WriteLine($"Color: {obj.Color}");
                        Console.WriteLine($"Horsepower: {obj.HP}");
                    }
                }
                input2 = Console.ReadLine();
            }
            if (totalCar == 0)
            {
                Console.WriteLine($"Cars have average horsepower of: 0.00.");
                Console.WriteLine($"Trucks have average horsepower of: {(totalTruckHP * 1.0 / totalTruck):F2}.");
            }
            else if (totalTruck == 0)
            {
                Console.WriteLine($"Cars have average horsepower of: {(totalCarHP * 1.0 / totalCar):F2}.");
                Console.WriteLine($"Trucks have average horsepower of: 0.00.");
            }
            else
            {
                Console.WriteLine($"Cars have average horsepower of: {(totalCarHP * 1.0 / totalCar):F2}.");
                Console.WriteLine($"Trucks have average horsepower of: {(totalTruckHP * 1.0 / totalTruck):F2}.");
            }
        }

        public static string FirstCharToUpper(string type)
        {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < type.Length; i++)
            {
                if (i == 0)
                {
                    s.Append(Char.ToUpper(type[i]));
                }
                else
                {
                    s.Append(type[i].ToString());
                }
            }
            return s.ToString();
        }
    }
}
