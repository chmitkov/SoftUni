using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;

namespace ObjectsAndClasses_Exercises_08.MentorGroup
{
    class Student
    {
        public string Name { get; set; }
        public List<string> Comments { get; set; }
        public List<DateTime> Dates { get; set; }

        public Student(string name, List<string> comments, List<DateTime> dates)
        {
            this.Name = name;
            this.Comments = comments;
            this.Dates = dates;
        }

        public void Prints()
        {
            Console.WriteLine($"{Name}");
            Console.WriteLine("Comments:");
            foreach (var item in Comments)
            {
                Console.WriteLine($"- {item}");
            }
            Console.WriteLine("Dates attended:");
            foreach (var item in Dates.OrderBy(x => x))
            {
                Console.WriteLine($"-- {item.Date:dd/MM/yyyy}");
            }
        }

    }
    class Program
    {
        static void Main(string[] args)
        {
            List<Student> students = new List<Student>();
            string strDate = Console.ReadLine();
            while (strDate != "end of dates")
            {
                string[] dates = strDate
                    .Split(new char[] { ' ', ',' }, StringSplitOptions.RemoveEmptyEntries);
                var name = dates[0];
                List<DateTime> currDates = new List<DateTime>();
                for (int i = 1; i < dates.Length; i++)
                {
                    currDates.Add(DateTime.ParseExact(dates[i], "dd/MM/yyyy"
                    , CultureInfo.InvariantCulture));
                }
                if (students.Any(x => x.Name == dates[0]))
                {
                    foreach (var stu in students)
                    {
                        if (stu.Name == name)
                        {
                            stu.Dates.AddRange(currDates);
                        }
                    }
                }
                else
                {
                    var currStudent = new Student(dates[0], new List<string>()
                        , new List<DateTime>());
                    currStudent.Dates.AddRange(currDates);
                    students.Add(currStudent);
                }
                strDate = Console.ReadLine();
            }
            string strCom = Console.ReadLine();
            while (strCom != "end of comments")
            {
                string[] comments = strCom
                    .Split(new char[] { '-' }, StringSplitOptions.RemoveEmptyEntries);
                var name = comments[0];
                List<string> currComments = new List<string>();
                for (int i = 1; i < comments.Length; i++)
                {
                    currComments.Add(comments[i]);
                }
                if (students.Any(x => x.Name == name))
                {
                    foreach (var st in students)
                    {
                        if (st.Name == name)
                        {
                            st.Comments.AddRange(currComments);
                        }
                    }
                }
                strCom = Console.ReadLine();
            }
            foreach (var stud in students.OrderBy(x=>x.Name))
            {
                stud.Prints();
            }
        }
    }
}
