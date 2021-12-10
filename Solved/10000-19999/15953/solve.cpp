#include <iostream>

using namespace std;

int fest2017(int g) {
    int cut = 0;
    int reward[] = {500, 300, 200, 50, 30, 10};
    if (g != 0)
        for (int i = 1; i < 7; i++) {
            cut += i;
            if (g <= cut) return reward[i-1];
        }
    return 0;
}

int fest2018(int g) {
    int cut = 0;
    if (g != 0)
        for (int i = 0; i < 5; i++) {
            cut += 1 << i;
            if (g <= cut) return 512 >> i;
        }
    return 0;
}

int main() {
    int N, a, b;

    cin >> N;
    while(N--) {
        cin >> a >> b;
        cout << (fest2017(a) + fest2018(b)) * 10000 << "\n";
    }
    return 0;
}