#include <iostream>

using namespace std;

int main() {
    int A, B, C, D;
    
    cin >> A >> B >> C >> D;
    
    C += D % 60;
    B += (D / 60) % 60;
    A += D / 3600;
    
    if (C >= 60) B += 1;
    if (B >= 60) A += 1;
    
    printf("%d %d %d\n", A % 24, B % 60, C % 60);
    return 0;
}