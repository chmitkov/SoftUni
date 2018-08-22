using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;

namespace ObjectsAndClasses_Exercises_10._Student_Groups
{
    class Student
    {
        public string Name { get; set; }
        public string Mail { get; set; }
        public DateTime D { get; set; }

        public Student(string Name, string Mail, DateTime D)
        {
            this.Name = Name;
            this.Mail = Mail;
            this.D = D;
        }

    }
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, List<Student>>();
            var seatsDict = new Dictionary<string, int>();
            var groupDict = new Dictionary<string, int>();

            var currTown = string.Empty;
            var currTownSeats = 0;

            string input = Console.ReadLine();

            while (input != "End")
            {

                if (input.Contains("=>"))
                {
                    string[] townAndSeats = input
                        .Split(new char[] { '=', '>' }, StringSplitOptions.RemoveEmptyEntries);

                    currTown = townAndSeats[0];
                    string restStr = townAndSeats[1].TrimStart();
                    currTownSeats = int.Parse(restStr[0].ToString());

                    seatsDict.Add(currTown, currTownSeats);
                    if (!dict.ContainsKey(currTown))
                    {
                        dict.Add(currTown, new List<Student>());
                    }
                }
                else
                {
                    string[] commands = input
                        .Split(new char[] { '|' }, StringSplitOptions.RemoveEmptyEntries);
                    var currName = commands[0].Trim();
                    var currMail = commands[1].Trim();
                    var dateString = commands[2].Trim();
                    DateTime currDate = DateTime.Parse(dateString);
                    var currStudent = new Student(currName, currMail, currDate.Date);

                    dict[currTown].Add(currStudent);
                }

                input = Console.ReadLine();
            }
            var allGroup = 0;
            foreach (var tow in seatsDict)
            {
                var town = tow.Key;
                var seat = tow.Value;
                var numOfGroups = Math.Ceiling(dict[town].Count * 1.0 / seatsDict[town]);
                groupDict.Add(town, (int)numOfGroups);
                allGroup += (int)numOfGroups;
            }

            Console.Write($"Created {allGroup} groups in {groupDict.Count} towns:");
            foreach (var pair in dict.OrderBy(x => x.Key))
            {
                var groupLenght = seatsDict[pair.Key];
                var town = pair.Key;
                var currentMailCollection = pair.Value.OrderBy(x=>x.D)
                    .ThenBy(x=>x.Name).ThenBy(x=>x.Mail)
                    .Select(x => x.Mail).ToArray();
                for (int i = 0; i < currentMailCollection.Length; i++)
                {

                    if (i % groupLenght == 0)
                    {
                        Console.WriteLine();
                        Console.Write($"{town.Trim()} => ");
                        Console.Write(currentMailCollection[i]);
                    }
                    else
                    {
                        Console.Write(", " + currentMailCollection[i].Trim());
                    }
                }
            }
        }
    }
}
