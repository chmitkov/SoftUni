using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lists
{
    class Program
    {
        static void Main(string[] args)
        {
            //  var nums = Console.ReadLine();
            //  List<string> stringList = nums.Split(' ').ToList();
            //  List<int> intList = new List<int>();
            //  for (int i = 0; i < stringList.Count; i++)
            //  {
            //      intList.Add(int.Parse(stringList[i]));
            //      //Console.WriteLine(intList);
            //  }
            var nums = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            //Console.WriteLine(String.Join(" , ", nums));
            nums.Sort();
            Console.WriteLine(nums);
            
        }
    }
}
