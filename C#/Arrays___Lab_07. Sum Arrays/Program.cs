using System;
using System.Linq;

namespace Arrays___Lab_07._Sum_Arrays
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums1 = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            int[] nums2 = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            int maxLength = Math.Max(nums1.Length, nums2.Length);
            int[] sum = new int[maxLength];
            if (nums1.Length == nums2.Length)
            {
                for (int i = 0; i < maxLength; i++)
                {
                    sum[i] = nums1[i] + nums2[i];
                }
            }
            else
            {

                if (nums1.Length > nums2.Length)
                {
                    for (int i = 0; i < maxLength; i++)
                    {
                        sum[i] = nums1[i] + nums2[i % nums2.Length];
                    }
                }
                else
                {
                    for (int i = 0; i < maxLength; i++)
                    {
                        sum[i] = nums2[i] + nums1[i % nums1.Length];
                    }
                }

            }
            Console.WriteLine(string.Join(" ",sum));
        }
    }
}
