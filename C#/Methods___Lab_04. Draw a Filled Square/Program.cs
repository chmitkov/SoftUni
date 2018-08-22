using System;
using System.Text;

namespace Methods___Lab_04._Draw_a_Filled_Square
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            PrintSquare(n);
        }
        static void PrintSquare(int n)
        {
            PrintFirstAndLast(n);
            PrintMidRows(n);
            PrintFirstAndLast(n);
        }

         static void PrintMidRows(int n)
        {
            for (int i = 0; i < n-2; i++)
            {
                Console.Write("-");
                Console.Write(StrRepeat("\\/", n-1));
                Console.WriteLine("-");
            }
        }

         static string StrRepeat(string str, int count)
        {
            StringBuilder text = new StringBuilder();
            for (int i = 0; i < count; i++)
            {
                text.Append(str);
            }
            return text.ToString();
        }

        static void PrintFirstAndLast(int n)
        {
            Console.WriteLine(new string('-',n*2));
        }
    }
}
