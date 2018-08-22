using System;
using System.Collections.Generic;
using System.Linq;

namespace ObjectsAndClasses_Exercises_07._AndreyAndBilliard
{
    class Customer
    {
        public string Name { get; set; }
        public Dictionary<string, int> Orders { get; set; }
    }
    class Program
    {
        static void Main(string[] args)
        {
            var shop = new Dictionary<string, decimal>();
            var clients = new List<Customer>();
            int n = int.Parse(Console.ReadLine());

            while (n-- > 0)
            {
                string[] products = Console.ReadLine()
                    .Split(new char[] { '-' }, StringSplitOptions.RemoveEmptyEntries);
                if (!shop.ContainsKey(products[0]))
                {
                    shop.Add(products[0], decimal.Parse(products[1]));
                }
                else
                {
                    shop[products[0]] = decimal.Parse(products[1]);
                }
            }
            string input = Console.ReadLine();
            while (input != "end of clients")
            {
                string[] commands = input.Split(new char[] { '-', ',' }, StringSplitOptions.RemoveEmptyEntries);
                if (shop.ContainsKey(commands[1]))
                {
                    if (clients.Any(x => x.Name == commands[0]))
                    {

                        foreach (var item in clients)
                        {
                            if (item.Name == commands[0])
                            {
                                if (!item.Orders.ContainsKey(commands[1]))
                                {
                                    item.Orders.Add(commands[1], int.Parse(commands[2]));
                                }
                                else
                                {
                                    item.Orders[commands[1]] += int.Parse(commands[2]);
                                }
                            }
                        }
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
                    currSum += shop[pair.Key] * pair.Value;
                }
                Console.WriteLine($"Bill: {currSum:F2}");
                totalBill += currSum;
            };
            Console.WriteLine($"Total bill: {totalBill:f2}");
        }
    }
}
