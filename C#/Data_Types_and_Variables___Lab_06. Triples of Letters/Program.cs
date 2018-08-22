using System;

namespace Data_Types_and_Variables___Lab_06._Triples_of_Letters
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 97; i < n+97; i++)
            {
                for (int j = 97; j < n+97; j++)
                {
                    for (int k = 97; k < n+97; k++)
                    {
                        Console.WriteLine($"{(char)i}{(char)j}{(char)k}");
                    }
                }
            }
        }
    }
}
