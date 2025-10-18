using System;

namespace Beakjoon
{
    class _02920
    {
        static void Main()
        {
            string scale = Console.ReadLine();
            if (scale == "1 2 3 4 5 6 7 8") { Console.WriteLine("ascending"); }
            else if (scale == "8 7 6 5 4 3 2 1") { Console.WriteLine("descending"); }
            else { Console.WriteLine("mixed"); }
        }
    }
}