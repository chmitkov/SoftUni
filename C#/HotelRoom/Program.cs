using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HotelRoom
{
    class Program
    {
        static void Main(string[] args)
        {
            string month = Console.ReadLine().ToLower();
            int num = int.Parse(Console.ReadLine());
            double studio = 0;
            double app = 0;

            switch (month)
            {
                case "may":
                case "october":
                    studio = num * 50;
                    app = num * 65;
                    if (num > 14)
                    {

                        studio -= studio * 0.3;
                        app -= app * 0.1;
                    }
                    else if (num > 7)
                    {
                        studio -= studio * 0.05;
                    }
                    break;
                case "june":
                case "september":
                    studio = num * 75.20;
                    app = num * 68.70;
                    if (num > 14)
                    {
                        studio -= studio * 0.2;
                        app -= app * 0.1;
                    }
                    break;
                case "july":
                case "august":
                    studio = num * 76;
                    app = num * 77;
                    if (num > 14)
                    {
                        app -= app * 0.1;
                    }
                    break;
            }
            Console.WriteLine("Apartment: {0:F2} lv.\nStudio: {1:F2} lv.", app, studio);

        }
    }
}
