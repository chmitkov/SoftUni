using System;
using System.Collections.Generic;
using System.Linq;

namespace ObjectsAndClasses_Exercises_04.AverageGrades
{
    class Student
    {
        public string Name { get; set; }
        public List<double> Grades { get; set; }
        public double Average
        {
            get
            {
                return Grades.Average();
            }
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            List<Student> result = new List<Student>();
            for (int i = 0; i < n; i++)
            {
                string[] commands = Console.ReadLine().Split();
                var currList = new List<double>();
                for (int j = 1; j < commands.Length; j++)
                {
                    try
                    {
                        currList.Add(double.Parse(commands[j]));
                    }
                    catch (Exception)
                    {
                        var current = int.Parse(commands[j]);
                        currList.Add(current);
                    }
                }
                var currStudent = new Student()
                {
                    Name = commands[0],
                    Grades = currList
                };
                result.Add(currStudent);
            }
            foreach (var stu in result.OrderBy(x=>x.Name)
                .ThenByDescending(x=>x.Average).Where(x=>x.Average>=5.00).ToList())
            {
                Console.WriteLine($"{stu.Name} -> {stu.Average:F2}");
            }
        }
    }
}
