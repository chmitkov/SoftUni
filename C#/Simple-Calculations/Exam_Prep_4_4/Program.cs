using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace PF_Exam_Preparation_IV_04._Cubic_Messages
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine(); 

            while (input != "Over!")
            {
                string pattern = @"^([0-9]+)([a-zA-Z]+)([^a-zA-Z]*)$"; // ^(\d+)([A-Za-z]+)([^A-Za-z]*)$
                Regex regex = new Regex(pattern);
                if (regex.IsMatch(input))
                {
                    int length = int.Parse(Console.ReadLine().Trim());
                    var matches = regex.Match(input);
                    string str = matches.Groups[2].ToString();
                    if (length.Equals(str.Length))
                    {
                        string line = string.Empty;
                        string pattern2 = @"([0-9]+)";
                        Regex regex2 = new Regex(pattern2);
                        var matches2 = regex2.Matches(input);
                        foreach (Match item in matches2)
                        {
                            string currentItemLine = item.Value;

                            for (int i = 0; i < currentItemLine.Length; i++)
                            {
                                int index = int.Parse(currentItemLine[i].ToString());

                                if (index < str.Length)
                                {
                                    line += str[index];
                                }
                                else
                                {
                                    line += " ";
                                }
                            }
                        }
                        
                        Console.WriteLine($"{str} == {line}");
                    }
                }

                //string result = string.Empty;
                //int n = int.Parse(Console.ReadLine());
                //string pattern = @"^([0-9]+)([A-Za-z]+)([^A-Za-z]+)$";
                //Regex regex = new Regex(pattern);
                //if (regex.IsMatch(input))
                //{
                //    var numberBefore = regex.Match(input).Groups[1].ToString();
                //    var message = regex.Match(input).Groups[2].ToString();
                //    var numberAfter = regex.Match(input).Groups[3].ToString();

                //    if (message.Length == n)
                //    {
                //        string numPattern = @"[0-9]+";
                //        Regex regex2 = new Regex(numPattern);
                //        var number2 = regex2.Match(numberAfter).ToString();
                //        for (int i = 0; i < numberBefore.Length; i++)
                //        {
                //            var currentNum = int.Parse(numberBefore[i].ToString());
                //            if (currentNum >= 0 && currentNum < message.Length)
                //            {
                //                result += message[currentNum];
                //            }
                //            else
                //            {
                //                result += " ";
                //            }
                //        }
                //        for (int i = 0; i < number2.Length; i++)
                //        {
                //            var currentNum = int.Parse(number2[i].ToString());
                //            if (currentNum >= 0 && currentNum < message.Length)
                //            {
                //                result += message[currentNum];
                //            }
                //            else
                //            {
                //                result += " ";
                //            }
                //        }
                //    }
                //    Console.WriteLine($"{message} == {result}");
                //}

                input = Console.ReadLine();
            }

        }
    }
}