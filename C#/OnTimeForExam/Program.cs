using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
namespace OnTimeForExam
{
    class Program
    {
        static void Main(String[] args)
        {
            var examH = int.Parse(Console.ReadLine());
            var examM = int.Parse(Console.ReadLine());
            var stuH = int.Parse(Console.ReadLine());
            var stuM = int.Parse(Console.ReadLine());

            var examT = examH * 60 + examM;
            var stuT = stuH * 60 + stuM;
            var diff = Math.Abs(examT - stuT);
            var diffH = diff / 60;
            var diffM = diff % 60;

            if (stuT <= (examT - 30))
            {
                Console.WriteLine("Early");
                if (stuT != examT)
                {
                    if (diff < 60)
                    {
                        Console.WriteLine("{0} minutes before the start", diff);
                    }
                    else
                    {
                        Console.WriteLine("{0}:{1} hours " +
                            "before the start", diffH, diffM);
                    }
                }
            }
            else if (stuT < examT)
            {
                Console.WriteLine("On time");
                if (stuT != examT)
                {
                    if (diff < 60)
                    {
                        Console.WriteLine("{0} minutes before the start", diff);
                    }
                    
                }
            }
            else
            {
                Console.WriteLine("Late");
                if (stuT != examT)
                {
                    if (diff < 60)
                    {
                        Console.WriteLine("{0} minutes after the start", diff);
                    }
                    else
                    {
                        Console.WriteLine("{0}:{1} hours " +
                            "after the start", diffH, diffM);
                    }
                }
            }

         
        }
    }
}