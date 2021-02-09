#include <iostream>

using namespace std;

int main() {
    int N, cow, pos;
    int cows[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, count = 0;
    
    cin >> N;
    while (N--) {
        cin >> cow >> pos;
        if (cows[cow] == -1) cows[cow] = pos;
        else if (cows[cow] != pos) count++;
        cows[cow] = pos;
    }
    cout << count;
    return 0;
}