using System;
using System.Collections.Generic;
using System.Linq;

namespace _05._Array_Manipulator
{
    class Program
    {
        class Customer
        {
            //public Customer(string name, Dictionary<string, int> orders,
            //    Dictionary<string, decimal> price)
            //{
            //    Name = name;
            //    Orders = orders;
            //    Price = price;
            //}

            public string Name { get; set; }
            public decimal AllBill { get; set; }
            public Dictionary<string, int> Orders { get; set; }
            public Dictionary<string, decimal> Price { get; set; }

            public void PrintOrders()
            {

            }

        }
        static void Main(string[] args)
        {
            var dictNameAndProduct = new Dictionary<string, Dictionary<string, int>>();
            var dictPrice = new Dictionary<string, decimal>();

            int n = int.Parse(Console.ReadLine());

            while (n-- > 0)
            {
                string[] prod = Console.ReadLine().Split(new char[] { '-' }, StringSplitOptions.RemoveEmptyEntries);
                if (!dictPrice.ContainsKey(prod[0]))
                {
                    dictPrice.Add(prod[0], decimal.Parse(prod[1]));
                }
                else
                {
                    dictPrice[prod[0]] = decimal.Parse(prod[1]);
                }
            }

            string str = Console.ReadLine();
            List<Customer> cust = new List<Customer>();
            while (str != "end of clients")
            {
                string[] commands = Console.ReadLine().Split(new char[] { '-', ',' }, StringSplitOptions.RemoveEmptyEntries);
                string name = commands[0]; 
                string currentProduct = commands[1];
                int quantity = int.Parse(commands[2]);
                if (dictNameAndProduct.ContainsKey(name))
                {
                    dictNameAndProduct.Add(name, new Dictionary<string, int>());
                    dictNameAndProduct[name].Add(currentProduct, quantity);
                }
                else
                {
                    if (!dictNameAndProduct[name].ContainsKey(currentProduct))
                    {
                        dictNameAndProduct[name].Add(currentProduct, quantity);
                    }
                    else
                    {
                        dictNameAndProduct[name][currentProduct] += quantity;
                    }
                }
                str = Console.ReadLine();
            }
            foreach (var pair in dictNameAndProduct)
            {
                var currSt = new Customer()
                {
                    Name = pair.Key,
                    Orders = pair.Value,



                }
                cust.Add(currSt);
            }
        }
    }
}
