using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Resurrection
{
    class Program
    {
        static void Main(string[] args)
        {
            int phoenixes = int.Parse(Console.ReadLine());
            decimal totalYears = 0M;
            long totalLength = 0;
            decimal totalWidth = 0;
            int lengthOfOneWing = 0;
            for (int i = 0; i < phoenixes; i++)
            {
                totalLength = long.Parse(Console.ReadLine());
                totalWidth = decimal.Parse(Console.ReadLine());
                lengthOfOneWing = int.Parse(Console.ReadLine());

                totalYears = (totalLength * totalLength) * (totalWidth + 2 * lengthOfOneWing);
                //totalYears = {totalLength} ^ 2 * ({totalWidth} + 2 * {wingLength})
                Console.WriteLine($"{totalYears:F20}");
            }
        }
    }
}
