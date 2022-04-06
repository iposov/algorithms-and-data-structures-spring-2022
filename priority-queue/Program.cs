using System;
using System.IO;
using System.Linq;
using System.Collections.Generic;

namespace ConsoleApplication3
{
    internal class Program
    {
        private static List<int> heap = new List<int>();
        private static int N;
        private static StreamWriter writer;
        
        public static void Swap(int index1, int index2)
        {
            int temp = heap[index1];
            heap[index1] = heap[index2];
            heap[index2] = temp;
        }

        public static void SiftDown(int i)
        {
            while (2 * i + 1 < heap.Count)
            {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int j = left;

                if ((right < heap.Count) && (heap[right] > heap[left]))
                    j = right;
                
                if (heap[i] >= heap[j])
                    break;
                
                Swap(i, j);
                i = j;
            }
        }

        public static void SiftUp(int i)
        {
            while (heap[i] > heap[(i - 1) / 2])
            {
                Swap(i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }

        public static void Insert(int key)
        {
            heap.Add(key);
            SiftUp(heap.Count - 1);
        }

        public static void ExtractMax()
        {
            writer.WriteLine(heap[0]);
            
            heap[0] = heap[heap.Count - 1];
            heap.RemoveAt(heap.Count - 1);
            SiftDown(0);
        }

        public static void Main(string[] args)
        {
            StreamReader reader = new StreamReader("C:/Users/polin/RiderProjects/ConsoleApplication3/ConsoleApplication3/3.in");
            writer = new StreamWriter("C:/Users/polin/RiderProjects/ConsoleApplication3/ConsoleApplication3/result.out");
            
            N = int.Parse(reader.ReadLine());

            while (!reader.EndOfStream)
            {
                string elem = reader.ReadLine();
                
                if (elem=="GET")
                    ExtractMax();
                else
                    Insert(int.Parse(elem));
            }

            reader.Close();
            writer.Close();
        }
    }
}