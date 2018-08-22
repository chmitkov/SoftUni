using System;

namespace Methods___Exercises_15.Substring
{
    class Program
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine();
            int num = int.Parse(Console.ReadLine());

            //char searchChar = 'р';
            bool hasMatch = false;

            for (int i = 0; i < text.Length; i++)
            {
                if (text[i].ToString() == "p")
                {
                    hasMatch = true;

                  ;
                    if (num + i >= text.Length)
                    {
                        string matchedString = text.Substring(i);
                        Console.WriteLine(matchedString);
                    }
                    else
                    {
                        string matchedString = text.Substring(i, num+1);
                        Console.WriteLine(matchedString);
                        i += num;
                    }
                    
                }
                
            }
            if (!hasMatch)
            {
                Console.WriteLine("no");
            }
        }
    }
}