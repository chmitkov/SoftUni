using System;

namespace Data_Types_and_Variables___Lab_04._Elevator
{
    class Program
    {
        static void Main(string[] args)
        {
            int people = int.Parse(Console.ReadLine());
            int maxPeopleInElevator = int.Parse(Console.ReadLine());
            int courses = (int)Math.Ceiling((double)people / maxPeopleInElevator);
            Console.WriteLine(courses);
        }
    }
}
