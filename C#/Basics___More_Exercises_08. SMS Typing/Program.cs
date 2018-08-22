using System;

namespace Basics___More_Exercises_08._SMS_Typing
{
    class Program
    {
        static void Main(string[] args)
        {
            int numCount = int.Parse(Console.ReadLine());
            int[] array = new int[26];
            string result = string.Empty;
            for (int i = 0; i < numCount; i++)
            {
                int textMessage = int.Parse(Console.ReadLine());
                if (textMessage == 0)
                {
                    result += " ";
                }
                else
                {
                    int rowLength = textMessage.ToString().Length;
                    int digit = textMessage % 10;
                    int index = (digit - 2) * 3;

                    if (digit == 8 || digit == 9)
                    {
                        index++;
                    }

                    int letterIndex = index + rowLength - 1;
                    result += (char)(97 + letterIndex);
                }
            }

            Console.WriteLine(result);
        }
    }
}
