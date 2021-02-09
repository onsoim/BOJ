#include <iostream>

using namespace std;

int isPrime(int check) {
    for (int i = 2; i * i <= check; i++)
        if (!(check % i)) return 0;
    return 1;
}

int main() {
    int M, N;

    cin >> M >> N;
    if (M < 3) {
        if (M <= 2) cout << "2\n";
        M = 3;
    }
    else if (!(M % 2)) M++;
    
    for (int i = M; i <= N; i += 2)
        if (isPrime(i)) cout << i << "\n";
    return 0;
}