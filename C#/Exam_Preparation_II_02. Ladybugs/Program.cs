using System;
using System.Linq;

namespace Exam_Preparation_II_02._Ladybugs
{
    class Program
    {
        static void Main(string[] args)
        {
            int sizeOfField = int.Parse(Console.ReadLine());
            int[] field = new int[sizeOfField]; 
            int[] indexOfLadybugs = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            for (int i = 0; i < indexOfLadybugs.Length; i++)
            {
                field[indexOfLadybugs[i]] = 1;
            }

            string input = Console.ReadLine();

            while (input != "end")
            {
                string[] commands = input
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
                var action = commands[1];
                var startIndex = int.Parse(commands[0]);
                var lenghtOfJump = int.Parse(commands[2]);

                if (action == "right")
                {
                    if (startIndex >= 0 && startIndex < field.Length
                        && field[startIndex] != 0)
                    {
                        field[startIndex] = 0;
                        MoveRight(field,startIndex, lenghtOfJump);
                    }
                   
                }
                else
                {
                    if (startIndex >= 0 && startIndex < field.Length
                         && field[startIndex] != 0)
                    {
                        field[startIndex] = 0;
                        MoveLeft(field, startIndex, lenghtOfJump);
                    }
                }

                input = Console.ReadLine();
            }
            Console.WriteLine(string.Join(" ",field));
        }

        public static int[] MoveLeft(int[] field, int startIndex, int lenghtOfJump)
        {
            if (startIndex - lenghtOfJump < 0)
            {
                return field;
            }
            if (field[startIndex - lenghtOfJump] == 0)
            {
                field[startIndex - lenghtOfJump] = 1;
                return field;
            }
            
            else
            {
                return MoveLeft(field, (startIndex - lenghtOfJump), lenghtOfJump);
            }
        }

        public static int[] MoveRight(int[] field, int startIndex, int lenghtOfJump)
        {
            if (startIndex + lenghtOfJump >= field.Length)
            {
                return field;
            }
            if (field[startIndex + lenghtOfJump] == 0)
            {
                field[startIndex + lenghtOfJump] = 1;
                return field;
            }
            else
            {
                return MoveRight(field, (startIndex + lenghtOfJump), lenghtOfJump);
            }
        }
    }
}
