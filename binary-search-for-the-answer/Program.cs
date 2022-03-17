using System;
using System.IO;
using System.Linq;
using System.Collections.Generic;

namespace ConsoleApplication2
{
    internal class Program
    {
        private static List<int> arr = new List<int>();
        private static int N, k;

        private static bool Check(int x)
        {
            int _k = 1;
            int last_cow = arr[0];
            
            foreach (var c in arr) 
            {
                if (c - last_cow >= x) 
                {
                    _k++;
                    last_cow = c;
                }
            }
            
            return _k >= k;
        }

        public static void Main(string[] args)
        {
            StreamReader reader = new StreamReader("C:/Users/polin/RiderProjects/ConsoleApplication2/ConsoleApplication2/5.in");
            StreamWriter writer = new StreamWriter("C:/Users/polin/RiderProjects/ConsoleApplication2/ConsoleApplication2/test.out");

            N = int.Parse(reader.ReadLine());
            k = int.Parse(reader.ReadLine()) + 1;

            while (!reader.EndOfStream)
                arr.Add(int.Parse(reader.ReadLine()));
            
            int left = 0;
            int right = arr[N-1] - arr[0] + 1;
            
            while (right - left > 1) 
            {
                int middle = (left + right) / 2;
                if (Check(middle)) left = middle;
                else right = middle;
            }
            
            writer.WriteLine(left);

            reader.Close();
            writer.Close();
        }
    }
}