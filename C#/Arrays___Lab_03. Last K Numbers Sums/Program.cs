using System;

namespace Arrays___Lab_03._Last_K_Numbers_Sums
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int k = int.Parse(Console.ReadLine());

            long[] nums = new long[n];
            nums[0] = 1;

            for (int i = 1; i < nums.Length; i++)
            {
                var startIndex = Math.Max(0, i - k);
                var endIndex = i;
                var sum = 0L;
                for (int j = startIndex; j < endIndex; j++)
                {
                    sum += nums[j];
                }
                nums[i] = sum;
            }
            Console.WriteLine(string.Join(" ",nums));
        }
    }
}
