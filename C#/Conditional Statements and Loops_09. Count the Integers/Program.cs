using System;

namespace Conditional_Statements_and_Loops_09._Count_the_Integers
{
    class Program
    {
        static void Main(string[] args)
        {
            var counter = 0;
            try
            {
                while (true)
                {
                    var num = int.Parse(Console.ReadLine());
                    counter++;
                }
            }
            catch (Exception)
            {
                Console.WriteLine(counter);
                
                return;
            }
        }
    }
}
