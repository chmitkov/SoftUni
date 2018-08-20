using System;

namespace ObjectsAndClasses_Lab_02._Randomize_Words
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] array = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
            var rand = new Random();
            for (int i = 0; i < array.Length; i++)
            {
                var curr = array[i];
                var randomIndex = rand.Next(0, array.Length);
                var randomWord = array[randomIndex];
                array[i] = randomWord;
                array[randomIndex] = curr;
            }
            foreach (var word in array)
            {
                Console.WriteLine(word);
            }

        }
    }
}
