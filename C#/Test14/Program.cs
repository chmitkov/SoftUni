using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test14
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < length; i++)
            {
                int num = int.Parse(Console.ReadLine());

            }

        }
        static string Hundreds(int number)
        {
            string hundreds = string.Empty;
            if (number == 1)
            {
                hundreds = "one";
            }
            else if (number == 2)
            {
                hundreds = "two";
            }
            else if (number == 3)
            {
                hundreds = "three";
            }
            else if (number == 4)
            {
                hundreds = "four";
            }
            else if (number == 5)
            {
                hundreds = "five";
            }
            else if (number == 6)
            {
                hundreds = "six";
            }
            else if (number == 7)
            {
                hundreds = "seven";
            }
            else if (number == 8)
            {
                hundreds = "eight";
            }
            else if (number == 9)
            {
                hundreds = "nine";
            }
           return  hundreds += "-hundred";
        }
        static string Tens(int number,int units)
        {
            string tens = string.Empty;
            string edinici = string.Empty;
            if (number == 1)
            {
                tens = string.Empty;
                if (units == 1)
                {
                    edinici = "eleven";
                }
                else if (units == 2)
                {
                    edinici = "twelve";
                }
                else if (units == 3)
                {
                    edinici = "thirteen";
                }
                else if (units == 4)
                {
                    edinici = "fourteen";
                }
                else if (units == 5)
                {
                    edinici = "fifteen";
                }
                else if (units == 6)
                {
                    edinici = "sixteen";
                }
                else if (units == 7)
                {
                    edinici = "seventeen";
                }
                else if (units == 8)
                {
                    edinici = "eighteen";
                }
                else if (units == 9)
                {
                    edinici = "nineteen";
                }

            }
            else if (number == 2)
            {
                tens = "twenty";
            }
            else if (number == 3)
            {
                tens = "thirty";
            }
            else if (number == 4)
            {
                tens = "fourty";
            }
            else if (number == 5)
            {
                tens = "fifty";
            }
            else if (number == 6)
            {
                tens = "sixty";
            }
            else if (number == 7)
            {
                tens = "seventy";
            }
            else if (number == 8)
            {
                tens = "eighty";
            }
            else if (number == 9)
            {
                tens = "ninety";
            }
            else if (number == 0)
            {
                tens = string.Empty;
            }
            if (number != 1)
            {
                if (units == 1)
                {
                    edinici = "one";
                }
                else if (units == 2)
                {
                    edinici = "two";
                }
                else if (units == 3)
                {
                    edinici = "three";
                }
                else if (units == 4)
                {
                    edinici = "four";
                }
                else if (units == 5)
                {
                    edinici = "five";
                }
                else if (units == 6)
                {
                    edinici = "six";
                }
                else if (units == 7)
                {
                    edinici = "seven";
                }
                else if (units == 8)
                {
                    edinici = "eight";
                }
                else if (units == 9)
                {
                    edinici = "nine";
                }
            }
            
            return $"{tens} {edinici}";
        }
        static void NumToText(int number)
        {
            if (number >= 1000)
            {
                Console.WriteLine($"too large");
            }
            else if (number < 20 && number > -20)
            {
                Console.WriteLine();
            }
            else if (number < -20)
            {
                Console.WriteLine("-" + Hundreds(number / 100)); 
                   // +Tens((number/10)%10),number%10);
            }
        }
    }
}
