using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NumWithWordsTo100
{
    class Program
    {
        static void Main(String[] args)
        {
            var num = int.Parse(Console.ReadLine());
            var num1 = (num / 10) % 10;
            var num2 = num % 10;
            String output = "";
            if (num == 100)
            {
                Console.WriteLine("one hundred");
            }
            if (num < 20)
            {
                switch (num)
                {
                    case 0:
                        output = "zero";
                        break;
                    case 1:
                        output = "one";
                        break;
                    case 2:
                        output = "two";
                        break;
                    case 3:
                        output = "three";
                        break;
                    case 4:
                        output = "four";
                        break;
                    case 5:
                        output = "five";
                        break;
                    case 6:
                        output = "six";
                        break;
                    case 7:
                        output = "seven";
                        break;
                    case 8:
                        output = "eight";
                        break;
                    case 9:
                        output = "nine";
                        break;
                    case 10:
                        output = "ten";
                        break;
                    case 11:
                        output = "eleven";
                        break;
                    case 12:
                        output = "twelve";
                        break;
                    case 13:
                        output = "thirteen";
                        break;
                    case 14:
                        output = "fourteen";
                        break;
                    case 15:
                        output = "fifteen";
                        break;
                    case 16:
                        output = "sixteen";
                        break;
                    case 17:
                        output = "seventeen";
                        break;
                    case 18:
                        output = "eighteen";
                        break;
                    case 19:
                        output = "nineteen";
                        break;
                    case 20:
                        output = "twenty";
                        break;
                }
            }
            else
            {
                switch (num1)
                {
                    case 2:
                        output = "twenty";
                        break;
                    case 3:
                        output = "thirty";
                        break;
                    case 4:
                        output = "forty";
                        break;
                    case 5:
                        output = "fifty";
                        break;
                    case 6:
                        output = "sixty";
                        break;
                    case 7:
                        output = "seventy";
                        break;
                    case 8:
                        output = "eighty";
                        break;
                    case 9:
                        output = "ninety";
                        break;
                }
                switch (num2)
                {
                    case 0:
                        output += "";
                        break;
                    case 1:
                        output += " one";
                        break;
                    case 2:
                        output += " two";
                        break;
                    case 3:
                        output += " three";
                        break;
                    case 4:
                        output += " four";
                        break;
                    case 5:
                        output += " five";
                        break;
                    case 6:
                        output += " six";
                        break;
                    case 7:
                        output += " seven";
                        break;
                    case 8:
                        output += " eight";
                        break;
                    case 9:
                        output += " nine";
                        break;
                }
            }

            Console.WriteLine(output);
        }
    }
}
