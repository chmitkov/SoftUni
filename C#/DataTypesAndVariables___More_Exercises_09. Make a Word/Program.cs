using System;
using System.Text;

namespace DataTypesAndVariables___More_Exercises_09._Make_a_Word
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            StringBuilder result = new StringBuilder(); 
            for (int i = 0; i < n; i++)
            {
                result.Append(Console.ReadLine());
            }
            Console.WriteLine($"The word is: {result}");
        }
    }
}
