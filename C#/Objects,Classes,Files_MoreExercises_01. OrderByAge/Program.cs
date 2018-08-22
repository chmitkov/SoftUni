using System;

namespace Objects_Classes_Files_MoreExercises_01._OrderByAge
{
    class Program
    {

        class Student
        {
            public string Name { get; set; }
            public string Id { get; set; }
            public int Age { get; set; }
        }
        class Program
        {
            static void Main(string[] args)
            {
                string input = Console.ReadLine();
                List<Student> list = new List<Student>();
                while (input != "End")
                {
                    string[] arr = input.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
                    var currStudent = new Student() { Name = arr[0], Id = arr[1], Age = int.Parse(arr[2]) };
                    list.Add(currStudent);
                    input = Console.ReadLine();
                }
                foreach (var st in list.OrderBy(x => x.Age))
                {
                    Console.WriteLine($"{st.Name} with ID: {st.Id} is {st.Age} years old.");
                }
            }
        }
    }
}