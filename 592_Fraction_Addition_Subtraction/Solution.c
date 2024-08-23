#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

// Function to calculate the greatest common divisor (GCD)
int gcd(int a, int b) {
    if (b == 0) return abs(a);
    return gcd(b, a % b);
}

char* fractionAddition(char* expression) {
    int numerator = 0, denominator = 1;
    int num = 0, denom = 0;
    char op = '+';
    char* p = expression;
    
    // '\0' is the null terminator (end of string)
    while (*p != '\0') {
        if (*p == '+' || *p == '-') {
            op = *p;
            p++;
        }
        
        // Parse numerator
        num = atoi(p);
        while (*p != '/') p++;
        p++;
        
        // Parse denominator
        denom = atoi(p);
        while (*p != '+' && *p != '-' && *p != '\0') p++;
        
        // Calculate the current fraction in the common denominator
        if (op == '+') {
            numerator = numerator * denom + num * denominator;
        } else {
            numerator = numerator * denom - num * denominator;
        }
        denominator *= denom;
        
        // Simplify the current fraction
        int common_divisor = gcd(numerator, denominator);
        numerator /= common_divisor;
        denominator /= common_divisor;
    }
    
    // Calculate the required length of the result string
    int num_len = snprintf(NULL, 0, "%d", numerator);
    int denom_len = snprintf(NULL, 0, "%d", denominator);
    int total_len = num_len + denom_len + 1; // 1 for '/' and 1 for null terminator

    // Allocate the necessary amount of memory
    char* result = (char*)malloc(total_len * sizeof(char));
    
    // Format the result
    sprintf(result, "%d/%d", numerator, denominator);
    
    return result;
}

int main() {
    char expression1[] = "-1/2+1/2";
    char expression2[] = "-1/2+1/2+1/3";
    char expression3[] = "1/3-1/2";
    
    printf("Result 1: %s\n", fractionAddition(expression1));
    printf("Result 2: %s\n", fractionAddition(expression2));
    printf("Result 3: %s\n", fractionAddition(expression3));
    
    return 0;
}
