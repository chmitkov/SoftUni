using System;

namespace Methods___Lab_08._Greater_of_Two_Values
{
    class Program
    {
        static void Main(string[] args)
        {
            string type = Console.ReadLine();
            if (type == "int")
            {
                int num1 = int.Parse(Console.ReadLine());
                int num2 = int.Parse(Console.ReadLine());
                Console.WriteLine(GetMax(num1,num2));
            }
            else if (type == "char")
            {
                char num1 = char.Parse(Console.ReadLine());
                char num2 = char.Parse(Console.ReadLine());
                Console.WriteLine(GetMax(num1,num2));
            }
            else
            {
                string num1 = Console.ReadLine();
                string num2 = Console.ReadLine();
                Console.WriteLine(GetMax(num1, num2));
            }
        }

         static int GetMax(int num1, int num2)
        {
            return num1 > num2 ? num1 : num2;
        }
        static char GetMax(char num1, char num2)
        {
            return num1 > num2 ? num1 : num2;
        }
        static string GetMax(string num1, string num2)
        {
            if (num1.CompareTo(num2) > 0)
            {
                return num1;
            }
            else
            {
                return num2;
            }
        }
    }
}
