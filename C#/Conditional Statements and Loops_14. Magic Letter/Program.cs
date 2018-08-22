using System;

namespace Conditional_Statements_and_Loops_14._Magic_Letter
{
    class Program
    {
        static void Main(string[] args)
        {
            char a = char.Parse(Console.ReadLine());
            char b = char.Parse(Console.ReadLine());
            string c = Console.ReadLine();
            var currString = "";

            for (char i = a; i <= b; i++)
            {
                for (char j = a; j <= b; j++)
                {
                    for (char k = a; k <= b; k++)
                    {
                        currString = $"{i}{j}{k} ";
                        if (!currString.Contains(c))
                        {
                            Console.Write(currString);
                        }
                    }
                }
            }
        }
    }
}
