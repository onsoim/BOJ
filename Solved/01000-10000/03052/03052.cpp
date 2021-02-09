#include <iostream>

using namespace std;

int main() {
    int A, mod[42] = {0,};
    int cnt = 0;
    
    for (int i = 0; i < 10; i++) {
        cin >> A;
        mod[A % 42]++;
    }

    for (int i = 0; i < 42; i++)
        if (mod[i]) cnt++;
        
    cout << cnt;
    return 0;
}