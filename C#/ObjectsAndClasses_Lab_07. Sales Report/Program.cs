using System;
using System.Collections.Generic;
using System.Linq;

namespace ObjectsAndClasses_Lab_07._Sales_Report
{
    class Sale
    {
        public string Town { get; set; }
        public string Product { get; set; }
        public double Price { get; set; }
        public double Quantity { get; set; }
        
        public decimal Total
        {
            get
            {
                return (decimal)(Price * Quantity);
            }
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            var dict = new Dictionary<string, decimal>();
            while (n-- > 0)
            {
                var curr = ReadTownSale(Console.ReadLine());
                if (!dict.ContainsKey(curr.Town))
                {
                    dict.Add(curr.Town, curr.Total);
                }
                else
                {
                    dict[curr.Town] += curr.Total;
                }
            }
            foreach (var pair  in dict.OrderBy(x=>x.Key))
            {
                Console.WriteLine($"{pair.Key} -> {pair.Value:f2}");
            }
        }

        public static Sale ReadTownSale(string v)
        {
            string[] a = v.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

            return new Sale()
            {
                Town = a[0],
                Product = a[1],
                Price = double.Parse(a[2]),
                Quantity = double.Parse(a[3])
            };
        }
    }
}
