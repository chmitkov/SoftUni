using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CaminoFactory
{
    class Program
    {
        static void Main(string[] args)
        {
            int length = int.Parse(Console.ReadLine());
            string input = Console.ReadLine();
            int[] final = new int[length];
            int index = 0;
            int finalIndex = 0;
            int[] nums = new int[length];
            while (input != "Clone them!")
            {
                index++;
                nums = Console.ReadLine()
                    .Split(new char[] { '!', ' ' },
                    StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse).ToArray();
                int[] parameters = GetInfo(nums);
                if (isBetter(parameters, final))
                {
                    final = nums;
                    finalIndex = index;
                }

                input = Console.ReadLine();
            }
            Console.WriteLine($"Best DNA sample {finalIndex} " +
                $"with sum:{final.Sum()}");
            Console.WriteLine(string.Join(" ",final));
        }

        static bool isBetter(int[] parameters, int[] final)
        {
            throw new NotImplementedException();
        }

        static int[] GetInfo(int[] nums)
        {
            
        }
    }
}
