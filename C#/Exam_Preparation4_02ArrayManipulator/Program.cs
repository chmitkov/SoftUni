using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam_Preparation4_02ArrayManipulator
{
    class Program
    {
        static void Main(string[] args)
        {
            var array = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            string command = Console.ReadLine();
            var result = new List<int>();
            while (command != "end")
            {
                string[] command2 = command.Split(' ').ToArray();
                if (command2.Length == 2)
                {
                    if (command2[0] == "exchange")
                    {
                        var index = int.Parse(command2[1]);
                        
                        if (index < array.Length - 1)
                        {
                            result.AddRange(array.Skip(index+1));
                            result.AddRange(array.Take(array.Length - index));
                        }
                        else
                        {
                            Console.WriteLine("Invalid index");
                            return;
                        }
                    }
                    else if (command2[0] == "max")
                    {
                        if (command2[1] == "even")
                        {
                            result.AddRange(array.Where(x => x % 2 == 0)
                                .OrderByDescending(x => x).Take(1));
                        }
                        else
                        {
                            result.AddRange(array.Where(x => x % 2 != 0)
                                .OrderByDescending(x => x).Take(1));
                        }
                    }
                    else if (command2[0] == "min")
                    {
                        if (command2[1] == "even")
                        {
                            result.AddRange(array.Where(x => x % 2 == 0)
                                .OrderBy(x => x).Take(1));
                        }
                        else
                        {                        
                            result.AddRange(array.Where(x => x % 2 != 0)
                                .OrderBy(x => x).Take(1));
                        }
                    }                  
                }
                else
                {
                    var firstOrLast = command2[0];
                    var count = int.Parse(command2[1]);
                    var oddOrEven = command2[2];
                    if (count >= array.Length)
                    {
                        Console.WriteLine("Invalid count");
                    }
                    else
                    {
                        if (firstOrLast == "first")
                        {
                            if (oddOrEven == "even")
                            {
                                result.AddRange(array.Where(x => x % 2 == 0)
                                    .Take(count));
                            }
                            else
                            {
                                result.AddRange(array.Where(x => x % 2 != 0)
                                    .Take(count));
                            }
                        }
                        else
                        {
                            if (oddOrEven == "even")
                            {
                                result.AddRange(array.Where(x => x % 2 == 0)
                                    .Reverse()
                                    .Take(count));
                            }
                            else
                            {
                                result.AddRange(array.Where(x => x % 2 != 0)
                                    .Reverse()
                                    .Take(count));
                            }
                        }
                    }
                }
                array = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            }
            Console.WriteLine(string.Join(" ", result));
        }
    }
}
