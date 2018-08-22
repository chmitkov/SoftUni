using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tests
{
    class Program
    {
        static void Main(string[] args)
        {
            string nums = Console.ReadLine();
            string[] stringArray = nums.Split(' ');
            int[] intArray = new int[stringArray.Length];
            for (int i = 0; i < stringArray.Length; i++)
            {
                intArray[i] = int.Parse(stringArray[i]);
            }
            foreach (var newNum in intArray)
            {
                Console.WriteLine(newNum);
            }
            Console.WriteLine(string.Join(",", intArray));

        }
    }
}
