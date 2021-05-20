#include <iostream>

using namespace std;

int main() {
    int price[3];
    int s = 100, e = 1, in, out;
    int parking[100] = {0,}, sum = 0;

    cin >> price[0] >> price[1] >> price[2];
    for (int i = 0; i < 3; i++) {
        price[i] *= (i + 1);
        cin >> in >> out;
        for (int j = in; j < out; j++) parking[j]++;
        if (s > in) s = in;
        if (e < out) e = out;
    }

    for (int i = s; i < e; i++) sum += price[parking[i] - 1];
    cout << sum;

    return 0;
}