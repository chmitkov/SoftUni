using System;

namespace Data_Types_and_Variables___Lab_01._Centuries_to_Minutes
{
    class Program
    {
        static void Main(string[] args)
        {
            int centuries = int.Parse(Console.ReadLine());

            //decimal result = centuries * 100;
           int years = centuries * 100;
           int days = (int)(years * 365.2422);
            int hours = days * 24;
           int minutes = hours * 60;
            Console.WriteLine(centuries);
            Console.WriteLine(years);
            Console.WriteLine(days);
            Console.WriteLine(hours);
            Console.WriteLine(minutes);
        }
    }
}
