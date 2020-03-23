#include <iostream>

using namespace std;
#define min(x,y) (x < y ? x : y)

int main() {
    int N, price[1000][3] = {0,};

    cin >> N;
    for (int i = 0; i < N; i++) cin >> price[i][0] >> price[i][1] >> price[i][2];

    for (int i = 0; i < N - 1; i++)
        for (int j = 0; j < 3; j++)
            switch(j) {
                case 0:
                    price[i + 1][0] += min(price[i][1], price[i][2]);
                    break;
                case 1:
                    price[i + 1][1] += min(price[i][0], price[i][2]);
                    break;
                case 2:
                    price[i + 1][2] += min(price[i][0], price[i][1]);
                    break;
            }

    cout << min(min(price[N - 1][0], price[N - 1][1]), price[N - 1][2]);

    return 0;
}