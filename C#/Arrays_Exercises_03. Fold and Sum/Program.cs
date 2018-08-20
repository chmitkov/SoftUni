using System;
using System.Linq;

namespace Arrays_Exercises_03._Fold_and_Sum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine().
                Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            int k = numbers.Length / 4;
            int[] nums1 = new int[numbers.Length / 2];
            int[] nums2 = new int[numbers.Length / 2];
            int[] sum = new int[numbers.Length / 2];

            for (int i = 0; i < k; i++)
            {
                nums1[i] = numbers[k - 1 - i];
                nums1[nums1.Length - k + i] = numbers[numbers.Length - 1 - i];
                nums2[i] = numbers[k + i];
                nums2[nums2.Length - 1 - i] = numbers[3 * k - 1 - i];
            }
            for (int i = 0; i < nums1.Length; i++)
            {
                sum[i] = nums1[i] + nums2[i];
            }
            Console.WriteLine(string.Join(" ", sum));

        }
    }
}
