using System;

namespace Methods___Exercises_01._Hello__Name_
{
    class Program
    {
        static void Main(string[] args)
        {
            SayHallo(Console.ReadLine());
        }
       

        static void SayHallo(string name)
        {
            Console.WriteLine($"Hello, {name}!");           
        }
    }
}
