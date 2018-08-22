using System;
using System.Text;

namespace Strings_and_Text_Processing_Exercises_07.MultiplyBigNumber
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
            long sumInLong = 0;
            var toRemember = 0;
            var counter = 0;
            var finalResult = "0";
            for (int i = shoretNum.Length - 1; i >= 0; i--)
            {
                sum.Clear();
                for (int j = 0; j < longerNum.Length; j++)
                {
                    var currMult = (int.Parse(shoretNum[i].ToString()) 
                        * int.Parse(longerNum[longerNum.Length-1-j].ToString())
                        +toRemember);
                    if (currMult >= 10)
                    {
                        toRemember = currMult / 10;
                        sum.Append(currMult % 10);
                    }
                    else
                    {
                        toRemember = 0;
                        sum.Append(currMult);
                    }
                    if (j == longerNum.Length - 1 && toRemember > 0)
                    {
                        sum.Append(toRemember);
                    }
                }
                var tempSumInString = string.Empty;
                for (int k = sum.Length - 1; k >= 0; k--)
                {
                    tempSumInString += sum[k];
                }
                if (counter > 0)
                {
                    //sumInLong += (long.Parse(tempSumInString) * (counter * 10));
                    tempSumInString = tempSumInString += new string('0', counter);
                    finalResult = SumBigNums(finalResult, tempSumInString);
                    
                }
                else
                {
                    //sumInLong += (long.Parse(tempSumInString));
                    finalResult = SumBigNums(finalResult, tempSumInString);
                }
                counter++;
            }
            Console.WriteLine(finalResult.ToString());
        }
        public static string SumBigNums(string a, string b)
        {
             a = a.TrimStart('0');
             b = b.TrimStart('0');
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
                    var currNum = int.Parse(longerNum[longerNum.Length - 1 - i].ToString())
                        + int.Parse(shoretNum[shoretNum.Length - 1 - i].ToString()) + toRemember;
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
            var result = new StringBuilder();
            for (int i = sum.Length - 1; i >= 0; i--)
            {
                result.Append(sum[i]);
            }
            return result.ToString();
        }
    }
}