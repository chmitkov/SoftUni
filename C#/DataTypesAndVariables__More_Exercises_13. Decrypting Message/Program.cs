using System;
using System.Text;

namespace DataTypesAndVariables__More_Exercises_13._Decrypting_Message
{
    class Program
    {
        static void Main(string[] args)
        {
            int key = int.Parse(Console.ReadLine());
            int n = int.Parse(Console.ReadLine());
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++)
            {
                char ch = char.Parse(Console.ReadLine());
                char newChar = (char)(ch + key);
                result.Append(newChar);
            }
            Console.WriteLine(result);
        }
    }
}
