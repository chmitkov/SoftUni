using System;
using System.Collections.Generic;
using System.Linq;

namespace ObjectsAndClasses_Exercises_07._AndreyAndBilliard
{
    class Customer
    {
        public string Name { get; set; }
        public Dictionary<string, int> Orders { get; set; }
        
        public void Bill(Dictionary<string, decimal> dict)
        {
            Console.WriteLine($"{Name}");
           var totalSum = 0M;
            foreach (var pair in Orders)
            {
                Console.WriteLine($"-- {pair.Key} - {pair.Value}");
                totalSum += dict[pair.Key] * pair.Value;
            }
            Console.WriteLine($"Bill: {totalSum:F2}");
        }
        
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

            while (input != "end of clients")
            {
                string[] commands = input.Split(new char[] { '-', ',' }, StringSplitOptions.RemoveEmptyEntries);
                if (dict.ContainsKey(commands[1]))
                {
                    if (clients.Where(x=>x.Nam)
                    {

                    }
                    else
                    {
                        var currentCustomer = new Customer()
                        {
                            Name = commands[0],
                            Orders = new Dictionary<string, int>()
                        };
                        if (!currentCustomer.Orders.ContainsKey(commands[1]))
                        {
                            currentCustomer.Orders.Add(commands[1], int.Parse(commands[2]));
                        }
                        else
                        {
                            currentCustomer.Orders[commands[1]] += int.Parse(commands[2]);
                        }
                        clients.Add(currentCustomer);
                    }
                }
                input = Console.ReadLine();
            }
            var totalBill = 0M;
            foreach (var item in clients.OrderBy(x => x.Name))
            {
                var currSum = 0m;
                Console.WriteLine(item.Name);
                foreach (var pair in item.Orders)
                {
                    Console.WriteLine($"-- {pair.Key} - {pair.Value}");
                    currSum += dict[pair.Key] * pair.Value;
                }
                Console.WriteLine($"Bill: {currSum:F2}");
                totalBill += currSum;
            };
            Console.WriteLine($"Total bill: {totalBill:f2}");
        }
    }
}
