using System;
using System.Text;

namespace DataTypesAndVariables__More_Exercises_15._Balanced_Brackets
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++)
            {
                string str = Console.ReadLine();
                if (str == "(" || str == ")")
                {
                    result.Append(str);
                }
            }
            if (result.Length % 2 == 0)
            {
                if (result.Equals(StrToRepeat("()", result.Length / 2)))
                {
                    Console.WriteLine("BALANCED");
                }
                else
                {
                    Console.WriteLine("UNBALANCED");
                }
            }
            else
            {
                Console.WriteLine("UNBALANCED");
            }
        }

         static StringBuilder StrToRepeat(string v1, int v2)
        {
            StringBuilder text = new StringBuilder();
            for (int i = 0; i < v2; i++)
            {
                text.Append(v1);
            }
            return text;
        }
    }
}
