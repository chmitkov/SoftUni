using System;
using System.Linq;

namespace Arrays_and_Methods_More_Exercises_02._Manipulate_Array
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] array = Console.ReadLine()
                 .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                 .ToArray();

            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string[] commands = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
                if (commands[0] == "Reverse")
                {
                    string[] current = new string[array.Length];
                    for (int j = 0; j < current.Length; j++)
                    {
                        current[current.Length - 1 - j] = array[j];
                    }
                    array = current;
                }
                else if (commands[0] == "Distinct")
                {
                    //string result = string.Empty;
                    //for (int j = 0; j < array.Length - 1; j++)
                    //{
                    //    if (array[j] != array[j + 1])
                    //    {
                    //        if (j == (array.Length - 2))
                    //        {
                    //            result += $"{array[j]} ";
                    //            result += $"{array[j + 1]} ";
                    //        }
                    //        else
                    //        {
                    //            result += $"{array[j]} ";
                    //        }
                    //    }
                    //}
                    array = array.Distinct().ToArray();
                       
                }
                else if (commands[0] == "Replace")
                {
                    var index = int.Parse(commands[1]);
                    var strForReplace = commands[2];
                    for (int j = 0; j < array.Length; j++)
                    {
                        if (j == index)
                        {
                            array[j] = strForReplace;
                        }
                    }
                }
            }
            Console.WriteLine(string.Join(", ", array));
        }
    }
}
