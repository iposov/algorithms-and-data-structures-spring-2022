using System;
using System.IO;
using System.Linq;

namespace ConsoleApplication1
{
    internal class Program
    {
        private static int[] arr;

        public static void Main(string[] args)
        {
            StreamReader reader = new StreamReader("C:/Users/polin/RiderProjects/ConsoleApplication1/5.in");
            StreamWriter writer = new StreamWriter("C:/Users/polin/RiderProjects/ConsoleApplication1/test.out");

            int N = int.Parse(reader.ReadLine());
            arr = reader.ReadLine().Split(' ').Select(x => int.Parse(x)).ToArray();
            int K = int.Parse(reader.ReadLine());

            int left = 0;
            int right = N - 1;

            while (!reader.EndOfStream)
                writer.WriteLine(Search(left, right, int.Parse(reader.ReadLine())));
                //Console.WriteLine(Search(left, right, int.Parse(reader.ReadLine())));

            reader.Close();
            writer.Close();
        }

        private static int Search(int left, int right, int searchElem)
        {
            int middle = (left + right) / 2;
            if (searchElem == arr[middle]) return middle;

            if (Math.Abs(right - left) <= 1)
            {
                if (arr[right] == searchElem) return right;
                if (arr[left] == searchElem) return left; 
                else return -1;
            }

            if (searchElem > arr[middle]) return Search(middle, right, searchElem);
            if (searchElem < arr[middle]) return Search(left, middle, searchElem);
            else return -1;
        }
    }
}