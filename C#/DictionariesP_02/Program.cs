using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DictionariesP_02
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            string[] command = new string[2];
            var grades = new Dictionary<string, List<double>>();
            for (int i = 0; i < n; i++)
            {
                command = Console.ReadLine()
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();
                var name = command[0];
                var mark = double.Parse(command[1]);
                if (!grades.ContainsKey(name))
                {                
                    grades[name] = new List<double>();                                     
                }
                grades[name].Add(mark);
            }
            foreach (var pair in grades)
            {
                var stu = pair.Key;               
                var studMark = pair.Value;
                var agerage = studMark.Average();
                Console.Write($"{stu} -> ");
                foreach (var m in studMark)
                {
                    Console.Write($"{m:F2} ");
                }
                Console.Write($"(avg: {agerage:F2})");
                Console.WriteLine();
            }
        }
    }
}
