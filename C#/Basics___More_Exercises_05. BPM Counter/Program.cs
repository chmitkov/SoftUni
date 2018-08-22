using System;

namespace Basics___More_Exercises_05._BPM_Counter
{
    class Program
    {
        static void Main(string[] args)
        {
            int beatsPerMinute = int.Parse(Console.ReadLine());
            int beatsCount = int.Parse(Console.ReadLine());

            decimal time = (decimal)beatsCount / beatsPerMinute * 60;
            decimal minutes = Math.Floor(time / 60);
            decimal secounds = Math.Truncate(time % 60);

            decimal bars = Math.Round((decimal)beatsCount / 4, 1);

            Console.WriteLine("{0} bars - {1}m {2}s", bars, minutes, secounds);
        }
    }
}
