using System;
using System.Collections.Generic;

namespace DictionariesandLists_MoreExercises_05._Parking_Validation
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            var dict = new Dictionary<string, string>();

            for (int i = 0; i < n; i++)
            {
                string[] commands = Console.ReadLine()
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

                var action = commands[0];

                if (action == "register")
                {
                    var name = commands[1];
                    var plate = commands[2];

                    if (dict.ContainsKey(name))
                    {
                        Console.WriteLine($"ERROR: already registered with plate number {dict[name]}");
                    }
                    else if (!IsValidPlate(plate))
                    {
                        Console.WriteLine($"ERROR: invalid license plate {plate}");
                    }
                    else if (dict.ContainsValue(plate))
                    {
                        Console.WriteLine($"ERROR: license plate {plate} is busy");
                    }
                    else
                    {
                        dict.Add(name, plate);
                        Console.WriteLine($"{name} registered {plate} successfully");
                    }
                }
                else if (action == "unregister")
                {
                    var name = commands[1];
                    if (!dict.ContainsKey(name))
                    {
                        Console.WriteLine($"ERROR: user {name} not found");
                    }
                    else
                    {
                        Console.WriteLine($"user {name} unregistered successfully");
                        dict.Remove(name);
                    }
                }
            }
            foreach (var pair in dict)
            {
                Console.WriteLine($"{pair.Key} => {pair.Value}");
            }
        }

        static bool IsValidPlate(string plate)
        {
            bool valid = false;
            if (plate.Length == 8)
            {
                if (Char.IsUpper(plate[0]) && Char.IsUpper(plate[1]) &&
                    Char.IsUpper(plate[6]) && Char.IsUpper(plate[7]))
                {
                    if (Char.IsDigit(plate[2]) && Char.IsDigit(plate[3]) &&
                        Char.IsDigit(plate[4]) && Char.IsDigit(plate[5]))
                    {
                        valid = true;
                    }
                }
            }
            return valid;
        }
    }
}
