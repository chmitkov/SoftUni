using System;
using System.Collections.Generic;
using System.Linq;
using System.Globalization;

namespace ObjectsAndClasses_Exercises_05._BookLibrary
{
    class Program
    {
        class Book
        {
            public string Tittle { get; set; }
            public string Author { get; set; }
            public string Puiblisher { get; set; }
            public string ReleaseDate { get; set; }
            public string ISBN { get; set; }
            public decimal Price { get; set; }

            public Book(string Tittle, string Author, string Puiblisher, string ReleaseDate,
                string ISBN, decimal Price)
            {
                this.Tittle = Tittle;
                this.Author = Author;
                this.Puiblisher = Puiblisher;
                this.ReleaseDate = ReleaseDate;
                this.ISBN = ISBN;
                this.Price = Price;
            }
        }
        class Library
        {
            public string Name { get; set; }
            public List<Book> books { get; set; }

            public static Dictionary<string,decimal> Result(List<Book>books)
            {
                var dict = new Dictionary<string, decimal>();
                foreach (var item in books)
                {
                    if (!dict.ContainsKey(item.Author))
                    {
                        dict.Add(item.Author, item.Price);
                    }
                    else
                    {
                        dict[item.Author] += item.Price;
                    }
                }
                return dict;
            }

        }
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            var lib = new Library();
            List<Book> re = new List<Book>();
            for (int i = 0; i < n; i++)
            {
                string[] commands = Console.ReadLine()
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .ToArray();

                var currBook = new Book(commands[0],commands[1],commands[2],
                    commands[3],
                    commands[4],decimal.Parse(commands[5]));
                re.Add(currBook);
            }
            lib.books = re;
            foreach (var pair in Library.Result(lib.books).OrderByDescending(x=>x.Value)
                .ThenBy(x=>x.Key))
            {
                Console.WriteLine($"{pair.Key} -> {pair.Value:f2}");
            }
        }
    }
}
