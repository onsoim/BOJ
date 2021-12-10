#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

#define iswap(a,b) {int t=a;a=b;b=t;};

int main() {
    string A, B, C;
    int flag = 0, l1, l2;
    int sum;
    
    cin >> A >> B;
    
    reverse(A.begin(), A.end());
    reverse(B.begin(), B.end());
    l1 = A.length(), l2 = B.length();
    if (l1 > l2) {
        iswap(l1, l2);
        A.swap(B);
    }
    C = B + "1";
        
    for (int i = 0; i < l1; i++) {
        sum = A.at(i) + B.at(i) - 0x60 + flag;
        if (sum > 9) flag = 1;
        else flag = 0;
        
        C.at(i) = sum % 10 + 0x30;
    }
    
    for (int i = l1; i < l2; i++) {
        sum = B.at(i) + flag - 0x30;
        if (sum > 9) flag = 1;
        else flag = 0;
        
        C.at(i) = sum % 10 + 0x30;
    }
    
    if (!flag) C.resize(l2);
    reverse(C.begin(), C.end());
    cout << C;
    
    return 0;
}