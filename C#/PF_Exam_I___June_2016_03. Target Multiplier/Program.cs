using System;
using System.Linq;

namespace PF_Exam_I___June_2016_03._Target_Multiplier
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] dimentions = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            var rows = dimentions[0];
            var cols = dimentions[1];
            int[,] matrix = new int[rows, cols];
            for (int row = 0; row < rows; row++)
            {
                string[] line = Console.ReadLine().Split(' ');
                for (int col = 0; col < cols; col++)
                {
                    matrix[row, col] = int.Parse(line[col]);
                }
            }
            int[] targerCell = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();
            int targetRow = targerCell[0];
            int targetCol = targerCell[1];

            var sumOfNeighbours = matrix[targetRow - 1, targetCol - 1]
                + matrix[targetRow - 1, targetCol] + matrix[targetRow - 1, targetCol + 1]
                + matrix[targetRow, targetCol - 1] + matrix[targetRow, targetCol + 1]
                + matrix[targetRow + 1, targetCol - 1] + matrix[targetRow + 1, targetCol]
                + matrix[targetRow + 1, targetCol + 1];
            var targetCellOriginalValue = matrix[targetRow, targetCol];
            matrix[targetRow, targetCol] = sumOfNeighbours * targetCellOriginalValue;
            matrix[targetRow - 1, targetCol - 1] = matrix[targetRow - 1, targetCol - 1] * targetCellOriginalValue;
            matrix[targetRow - 1, targetCol] = matrix[targetRow - 1, targetCol] * targetCellOriginalValue;
            matrix[targetRow - 1, targetCol + 1] = matrix[targetRow - 1, targetCol + 1] * targetCellOriginalValue;
            matrix[targetRow, targetCol - 1] = matrix[targetRow, targetCol - 1] * targetCellOriginalValue;
            matrix[targetRow, targetCol + 1] = matrix[targetRow, targetCol + 1] * targetCellOriginalValue;
            matrix[targetRow + 1, targetCol - 1] = matrix[targetRow + 1, targetCol - 1] * targetCellOriginalValue;
            matrix[targetRow + 1, targetCol] = matrix[targetRow + 1, targetCol] * targetCellOriginalValue;
            matrix[targetRow + 1, targetCol + 1] = matrix[targetRow + 1, targetCol + 1] * targetCellOriginalValue;
            for (int row = 0; row < rows; row++)
            {
                for (int col = 0; col < cols; col++)
                {
                    Console.Write($"{matrix[row, col]} ");
                }
                Console.WriteLine();
            }
        }
    }
}
