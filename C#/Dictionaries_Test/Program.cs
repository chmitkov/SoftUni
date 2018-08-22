using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dictionaries_Test
{
    class Program
    {
        static void Main(string[] args)
        {
            var phonebook = new Dictionary<string, string>();
            phonebook["John Smit"] = "123343465";
            phonebook["Lisa Smit"] = "99913343465";
            phonebook["Sam Doe"] = "99868633343465";
            phonebook["Nakov"] = "1299868633343465";
            phonebook.Remove("Sam Doe");
            phonebook.Add("Ivanov", "0983242423");
            phonebook.Remove("Ivanov");
            //phonebook.Clear();
            Console.WriteLine(phonebook.ContainsKey("Dinko"));
            Console.WriteLine(phonebook.ContainsKey("Nakov"));
            Console.WriteLine(phonebook.ContainsValue("123343465"));
            Console.WriteLine(string.Join(" ", phonebook.Keys));
            Console.WriteLine(phonebook.ContainsKey("Nakov"));
            Console.WriteLine(phonebook.ContainsValue("1231242"));
            

            foreach (var phone in phonebook)
            {
                Console.WriteLine($"Key: {phone.Key} => Value: {phone.Value}");
            }
           
            // Console.WriteLine(string.Join(" ", phonebook.Keys));
            //foreach (var key in phonebook.Values)
            //{
            //    Console.WriteLine(key);
            //}
        }
    }
}
