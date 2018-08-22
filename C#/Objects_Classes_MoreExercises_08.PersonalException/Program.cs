using System;

namespace Objects_Classes_MoreExercises_08.PersonalException
{
    class MyExcept : Exception
    {
        public void Message() 
        {
            Console.WriteLine("My first exception is awesome!!!");
        }
        
    }
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                while (true)
                {
                    int num = int.Parse(Console.ReadLine());
                    if (num >= 0)
                    {
                        Console.WriteLine(num);
                    }
                    else
                    {
                        throw new MyExcept();
                    }
                }
            }
            catch (MyExcept myE)
            {
                myE.Message();
            }
        }
    }
}
