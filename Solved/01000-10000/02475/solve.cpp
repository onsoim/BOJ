#include <iostream>

using namespace std;

int main() {
    int n, v = 0;
    
    for (int i = 0; i < 5; i++) {
        cin >> n;
        v += n * n;
    }
    cout << v % 10;
    
    return 0;
}