using System;
using System.Collections.Generic;
using System.Linq;

namespace ObjectsAndClasses_Exercises_05.BookLibrary
{
    class Library
    {
        public string Name { get; set; }
        public List<Book> B { get; set; }
    }
    class Book
    {
        public string Title { get; set; }
        public string Author { get; set; }
        public string Publisher { get; set; }
        public string ReleaseDate { get; set; }
        public string ISBN { get; set; }
        public decimal Price { get; set; }
    }
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            List<Book> allBook = new List<Book>();
            var dict = new Dictionary<string, List<Book>>();
            for (int i = 0; i < n; i++)
            {
                string[] commands = Console.ReadLine()
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
                var currBook = new Book()
                {
                    Title = commands[0],
                    Author = commands[1],
                    Publisher = commands[2],
                    ReleaseDate = commands[3],
                    ISBN = commands[4],
                    Price = decimal.Parse(commands[5])
                };
                allBook.Add(currBook);
                if (!dict.ContainsKey(currBook.Author))
                {
                    dict.Add(currBook.Author, new List<Book>());
                    dict[currBook.Author].Add(currBook);
                }
                else
                {
                    dict[currBook.Author].Add(currBook);
                }
            }
            foreach (var pair in dict)
            {
                var totalMoney = 0M;
                var aut = string.Empty;
                foreach (var book in pair.Value.OrderBy(x=>x.Price).ThenBy(x=>x.Author))
                {
                    totalMoney += book.Price;
                    aut = book.Author;
                    //Console.WriteLine($"{book.Author} -> {book.Price}");
                }
                Console.WriteLine($"{aut} -> {totalMoney:F2}");

            }

        }
    }
}
