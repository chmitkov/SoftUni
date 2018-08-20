using System;
using System.Collections.Generic;
using System.Linq;

namespace PF_Exam_09July2017Part_1_02._Pokemon_Don_t_Go
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> nums = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToList();
            int removedElements = 0;


            while (nums.Count>0)
            {
                int index = int.Parse(Console.ReadLine());
                var currElement = 0;
                
                if (index < 0)
                {
                     currElement = nums[0];
                    nums.RemoveAt(0);
                    nums.Insert(0, nums[nums.Count - 1]);
                }
                else if (index >=nums.Count)
                {
                     currElement = nums[nums.Count-1];
                    nums.RemoveAt(nums.Count - 1);
                    nums.Add(nums[0]);
                }
                else
                {
                     currElement = nums[index];
                    nums.RemoveAt(index);
                }

                for (int i = 0; i < nums.Count; i++)
                {
                    if (nums[i] > currElement)
                    {
                        nums[i] -= currElement;
                    }
                    else
                    {
                        nums[i] += currElement;
                    }
                }
                removedElements += currElement;
            }
            Console.WriteLine(removedElements);
        }
    }
}
