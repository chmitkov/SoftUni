using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SquareMatrix
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter row: ");
            var n = int.Parse(Console.ReadLine());
            Console.WriteLine("Enter cow: ");
            var m = int.Parse(Console.ReadLine());
            int[,] matrix = new int[n, m];

            for (int i = 1; i <= matrix.GetLength(0); i++)
            {
                
                for (int j = 0; j < matrix.GetLength(1); j++)
                {
                    matrix[i-1, j] = i + (4 * j);
                   // Console.Write("{0} ", i + (4 * j));
                }
                //Console.WriteLine();
            }
            for (int i = 0; i < matrix.GetLength(0); i++)
            {
                for (int j = 0; j < matrix.GetLength(1); j++)
                {
                    Console.Write("{0} ", matrix[i, j]);
                }
                Console.WriteLine();
            }
        }
    }
}
