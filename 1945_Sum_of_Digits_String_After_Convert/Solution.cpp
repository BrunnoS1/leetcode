#include <string>
#include <vector>
#include <numeric>
using namespace std;

class Solution {
public:
    int getLucky(string s, int k) 
    {
        string numStr = "";

        // Convert each letter to its corresponding number and get a string of digits
        for (int i = 0; i < s.length(); i++)
        {
            int num = (s[i] - 'a') + 1;
            numStr += to_string(num);  // convert number to string and append it
        }

        // Convert the string of digits to a sum of digits
        int num = 0;
        for (char ch : numStr)
        {
            num += ch - '0';
        }

        // Repeat k-1 times
        for (int i = 1; i < k; i++)
        {
            int tempNum = 0;
            while (num > 0)
            {
                tempNum += num % 10;
                num /= 10;
            }
            num = tempNum;
        }
        
        return num;
    }
};
