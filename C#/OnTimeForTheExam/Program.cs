using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OnTimeForTheExam
{
    class Program
    {
        static void Main(string[] args)
        {
            var examH = int.Parse(Console.ReadLine());
            var examM = int.Parse(Console.ReadLine());
            var studH = int.Parse(Console.ReadLine());
            var studM = int.Parse(Console.ReadLine());

            var examT = examH * 60 + examM;
            var studT = studH * 60 + studM;
            var dif = Math.Abs(studT - examT);

            if (studT > examT)
            {
                Console.WriteLine("Late");
            }
            else if (studT <= examT && studT >= examT - 30)
            {
                Console.WriteLine("On time");
            }
            else
            {
                Console.WriteLine("Early");
            }
            if (studT != examT)
            {
                if (dif < 60 && studT < examT)
                {
                    Console.WriteLine("{0} minutes before the start", dif);
                }
                else if (dif < 60 && studT > examT)
                {
                    Console.WriteLine("{0} minutes after the start", dif);
                }
                else if (dif >= 60 && studT < examT)
                {
                    Console.WriteLine("{0}:{1:00} hours before the start", dif / 60, dif % 60);
                }
                else if (dif>=60 && studT > examT)
                {
                    Console.WriteLine("{0}:{1:00} hours after the start", dif / 60, dif % 60);
                }
            }

        }
    }
}
