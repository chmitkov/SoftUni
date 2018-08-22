using System;

namespace DataTypesAndVariables___More_Exercises_07._Sentence_the_Thief
{
    class Program
    {

        static void Main(string[] args)
        {
            string id = Console.ReadLine();
            int n = int.Parse(Console.ReadLine());
            var best = long.MinValue;


            switch (id)
            {
                case "sbyte":
                    for (int i = 0; i < n; i++)
                    {
                        long num = long.Parse(Console.ReadLine());

                        if (num <= sbyte.MaxValue && num >= sbyte.MinValue && num > best)
                        {
                            best = num;
                        }
                    }
                    break;
                case "int":
                    for (int i = 0; i < n; i++)
                    {
                        long num = long.Parse(Console.ReadLine());

                        if (num <= int.MaxValue && num >= int.MinValue && num > best)
                        {
                            best = num;
                        }
                    }
                    break;
                case "long":
                    for (int i = 0; i < n; i++)
                    {
                        long num = long.Parse(Console.ReadLine());

                        if (num <= long.MaxValue && num >= long.MinValue && num > best)
                        {
                            best = num;
                        }
                    }
                    break;
            }
            var sentence = 0M;
            
            if (best > 0)
            {
                sentence = Math.Ceiling(best/127.0M);
            }
            else if (best<0)
            {
                sentence = Math.Ceiling(Math.Abs(best) / 128.0M);
            }
            if (sentence == 1)
            {
                Console.WriteLine($"Prisoner with id {best} is sentenced to {sentence} year");
            }
            else if (sentence > 1)
            {
                Console.WriteLine($"Prisoner with id {best} is sentenced to {sentence} years");
            }
        }
    }
}
