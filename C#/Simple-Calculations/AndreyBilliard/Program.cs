using System;
using System.Collections.Generic;
using System.Linq;

namespace AndreyAndBilliard
{
    class Customer
    {
        //public decimal TotalPrice
        //{
        //    get;
        //    set;
        //}
        //public string Name { get; set; }
        //public Dictionary<string, int> Orders { get; set; }
        public string ProductName { get; set; }
        public int Quantity { get; set; }

        //public void Bill(Dictionary<string, decimal> dict)
        //{
        //    Console.WriteLine($"{Name}");
        //    var totalSum = 0M;
        //    foreach (var pair in Orders)
        //    {
        //        Console.WriteLine($"-- {pair.Key} - {pair.Value}");
        //        totalSum += dict[pair.Key] * pair.Value;
        //    }
        //    Console.WriteLine($"Bill: {this.TotalPrice:F2}");
        //}

    }
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, decimal>();
            var clients = new List<Customer>();
            int n = int.Parse(Console.ReadLine());

            while (n-- > 0)
            {
                string[] products = Console.ReadLine()
                    .Split(new char[] { '-' }, StringSplitOptions.RemoveEmptyEntries);
                if (!dict.ContainsKey(products[0]))
                {
                    dict.Add(products[0], decimal.Parse(products[1]));
                }
                else
                {
                    dict[products[0]] = decimal.Parse(products[1]);
                }
            }

            string input = Console.ReadLine();

            var productsDict = new Dictionary<string, List<Customer>>();
            while (input != "end of clients")
            {
                string[] commands = input.Split(new char[] { '-', ',' }, StringSplitOptions.RemoveEmptyEntries);
                if (dict.ContainsKey(commands[1]))
                {
                    //var currentCustomer = new Customer()
                    //{
                    //    ProductName = commands[1],
                    //    Quantity = int.Parse(commands[2])

                    //};

                    if (!productsDict.ContainsKey(commands[0]))
                    {
                        productsDict.Add(commands[0], new List<Customer>() { currentCustomer });
                    }
                    else
                    {
                        productsDict[commands[0]].Add(currentCustomer);
                        
                    }
            
                }
                input = Console.ReadLine();
            }
            var totalBill = 0M;
            foreach (var item in productsDict.OrderBy(m => m.Key))
            {
                Console.WriteLine(item.Key);
                
                var currSum = 0M;
                foreach (var pair in item.Value)
                {
                    Console.WriteLine($"-- {pair.ProductName} - {pair.Quantity}");
                    currSum += (pair.Quantity * dict[pair.ProductName]);
                }
                Console.WriteLine($"Bill: {currSum:F2}");
                totalBill += currSum;
            };
            Console.WriteLine($"Total bill: {totalBill:f2}");
        }
    }
}
