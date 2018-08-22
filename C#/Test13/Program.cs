using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test13
{
    class Program
    {
        static void Main(string[] args)
        {
            ReadAndProcessMessage();
        }
        static void ShowErrorMessage(string errorText, string reason, string errorCode)
        {
            var firstRow = $"Error: Failed to execute {errorText}.";
            Console.WriteLine(firstRow);
            Console.WriteLine(new string('=', firstRow.Length));
            Console.WriteLine($"Reason: {reason}.");
            Console.WriteLine($"Error code: {errorCode}.");
        }
        static void ShowWarningMessage(string warningText)
        {
            var firstRow = $"Warning: {warningText}.";
            Console.WriteLine(firstRow);
            Console.WriteLine(new string('=',firstRow.Length));
        }
        static void ShowSuccessMessage(string successText, string reason)
        {
            var firstRow = $"Successfully executed {successText}.";
            Console.WriteLine(firstRow);
            Console.WriteLine(new string('=',firstRow.Length));
            Console.WriteLine($"{reason}.");
        }
        static void ReadAndProcessMessage()
        {
            int n = int.Parse(Console.ReadLine());         
            for (int i = 0; i < n; i++)
            {
                string type = Console.ReadLine().ToLower();
                if (type == "error")
                {                   
                    ShowErrorMessage(Console.ReadLine(), Console.ReadLine(), Console.ReadLine());
                }
                 if (type == "warning")
                {                    
                    ShowWarningMessage(Console.ReadLine());
                }
                 if (type == "success")
                {
                    ShowSuccessMessage(Console.ReadLine(), Console.ReadLine());
                }            
            }
        }
    }
}
