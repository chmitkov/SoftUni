using System;
using System.Collections.Generic;
using System.Linq;

namespace Lists_Exercises_07._Bomb_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> list = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToList();

            int[] commands = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            var bomb = commands[0];
            var bombPower = commands[1];
            List<int> result = new List<int>();
            for (int i = 0; i < list.Count; i++)
            {
                if (list[i] == bomb)
                {
                    var indexToRemove = 0;
                    if (i - bombPower < 0)
                    {
                        indexToRemove = 0;
                    }
                    else
                    {
                        indexToRemove = i - bombPower;
                    }
                    var bombLenght = (bombPower * 2 + 1) + indexToRemove;
                    if ( bombLenght >= list.Count)
                    {
                        bombLenght = list.Count - indexToRemove;
                    }
                    else
                    {
                        bombLenght = (bombPower * 2 + 1);
                    }
                    list.RemoveRange(indexToRemove, bombLenght);
                    i --;
                }
            }
            Console.WriteLine(list.Sum());
        }
    }
}
