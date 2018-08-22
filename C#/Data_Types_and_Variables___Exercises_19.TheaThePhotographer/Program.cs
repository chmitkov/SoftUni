using System;

namespace Data_Types_and_Variables___Exercises_19.TheaThePhotographer
{
    class Program
    {
        static void Main(string[] args)
        {
            long numberOfPics = long.Parse(Console.ReadLine());
            long filterTime = long.Parse(Console.ReadLine());
            long filterFactor = long.Parse(Console.ReadLine());
            long uploadTime = long.Parse(Console.ReadLine());

            var percent = filterFactor * 0.01;
            long goodPic = (long)Math.Ceiling(numberOfPics * percent);
            long totalTime = numberOfPics * filterTime + goodPic * uploadTime;
            TimeSpan time = TimeSpan.FromSeconds(totalTime);
            Console.WriteLine($"{time.Days}:{time.Hours:D2}:" +
                $"{time.Minutes:D2}:{time.Seconds:D2}");
        }
    }
}
