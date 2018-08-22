using System;

namespace Methods___Exercises_12._Master_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());
            for (int i = 1; i < num; i++)
            {
                if (IsMagicNumber(i))
                {
                    Console.WriteLine(i);
                }
            }
        }

         static bool IsMagicNumber(int i)
        {

            if (IsSimetric(i) && IsDivisible7(i) && HaveOneEvenDigits(i))
            {
                return true;
            }
            else
            {
               return false;
            }
        }

         static bool HaveOneEvenDigits(int i)
        {
            var str = i.ToString();
            for (int j = 0; j < str.Length; j++)
            {
                if (int.Parse(str[j].ToString()) % 2 == 0)
                {
                    return true;
                }
            }
            return false;
        }

        static bool IsDivisible7(int i)
        {
            var str = i.ToString();
            var sum = 0;
            for (int j = 0; j < str.Length; j++)
            {
                sum += int.Parse(str[j].ToString());
            }
            if (sum % 7 == 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        static bool IsSimetric(int i)
        {
            var str = i.ToString();
            for (int j = 0; j < str.Length/2; j++)
            {
                if (str[j] != str[str.Length - 1 - j])
                {
                    return false;
                }
            }
            return true;
        }
    }
}
