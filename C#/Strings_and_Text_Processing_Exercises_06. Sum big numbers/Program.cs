using System;
using System.Linq;
using System.Text;
namespace Strings_and_Text_Processing_Exercises_06._Sum_big_numbers
{
    class Program
    {
        static void Main(string[] args)
        {

            string a = Console.ReadLine().TrimStart('0');
            string b = Console.ReadLine().TrimStart('0');
            var longerNum = string.Empty;
            var shoretNum = string.Empty;
            if (a.Length > b.Length)
            {
                longerNum = a;
                shoretNum = b;
            }
            else
            {
                shoretNum = a;
                longerNum = b;
            }

            StringBuilder sum = new StringBuilder();
            var toRemember = 0;
            for (int i = 0; i < longerNum.Length; i++)
            {
                if (i < shoretNum.Length)
                {
                    var currNum = int.Parse(longerNum[longerNum.Length-1-i].ToString())
                        + int.Parse(shoretNum[shoretNum.Length-1-i].ToString()) + toRemember;
                    if (currNum >= 10)
                    {
                        toRemember = 1;
                        sum.Append(currNum % 10);
                    }
                    else
                    {
                        sum.Append(currNum);
                        toRemember = 0;
                    }
                }
                else
                {
                    var currNum = int.Parse(longerNum[longerNum.Length - 1 - i].ToString()) + toRemember;
                    if (currNum >= 10)
                    {
                        toRemember = 1;
                        sum.Append(currNum % 10);
                    }
                    else
                    {
                        sum.Append(currNum);
                        toRemember = 0;
                    }
                }
                if (i == longerNum.Length - 1 && toRemember == 1)
                {
                    sum.Append("1");
                }
            }
            for (int i = sum.Length - 1; i >= 0; i--)
            {
                Console.Write(sum[i]);
            }
        }
    }
}
