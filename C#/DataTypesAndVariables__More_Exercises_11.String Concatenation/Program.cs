using System;
using System.Text;

namespace DataTypesAndVariables__More_Exercises_11.String_Concatenation
{
    class Program
    {
        static void Main(string[] args)
        {
            string delimeter = Console.ReadLine();
            string type = Console.ReadLine();
            int n = int.Parse(Console.ReadLine());
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= n; i++)
            {
                string str = Console.ReadLine();
                if (type == "even")
                {
                    if (i % 2 == 0)
                    {
                        result.Append(str + delimeter);
                    }
                }
                else
                {
                    if (i % 2 != 0)
                    {
                        result.Append(str + delimeter);
                    }
                }
            }
            result.Remove(result.Length-delimeter.Length,delimeter.Length);
            Console.WriteLine(result);
        }
    }
}
