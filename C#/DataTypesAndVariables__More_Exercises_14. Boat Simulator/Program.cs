using System;

namespace DataTypesAndVariables__More_Exercises_14._Boat_Simulator
{
    class Program
    {
        static void Main(string[] args)
        {
            char firstBoat = char.Parse(Console.ReadLine());
            char secondBoat = char.Parse(Console.ReadLine());
            int n = int.Parse(Console.ReadLine());

            var boat1Moves = 0;
            var boat2Moves = 0;
            for (int i = 1; i <= n; i++)
            {
                string str = Console.ReadLine();
                if (str == "UPGRADE")
                {
                    firstBoat = (char)(firstBoat + 3);
                    secondBoat = (char)(secondBoat + 3);
                }
                else
                {
                    if (i % 2 == 0)
                    {
                        boat2Moves += str.Length;
                    }
                    else if (i % 2 != 0)
                    {
                        boat1Moves += str.Length;
                    }
                    if (boat1Moves >= 50 || boat2Moves >= 50)
                    {
                        Console.WriteLine(boat1Moves > boat2Moves ? firstBoat : secondBoat);
                        return;
                    }
                }
            }
            Console.WriteLine(boat1Moves > boat2Moves ? firstBoat : secondBoat);
        }
    }
}
