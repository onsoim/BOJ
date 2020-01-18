#include <iostream>
#include <algorithm>
#include <functional>

using namespace std;

int main() {
    int N, triangle[500][500] = {0};

    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j <= i; j++) {
            cin >> triangle[i][j];
            if (!i) continue;
            else if (i && !j) triangle[i][0] += triangle[i-1][0];
            else if (i && i == j) triangle[i][j] += triangle[i-1][j-1];
            else triangle[i][j] += (triangle[i-1][j-1] > triangle[i-1][j])?triangle[i-1][j-1]:triangle[i-1][j];
        }
    }
    sort(triangle[N-1], triangle[N-1]+N, greater<int>());
    cout << triangle[N-1][0];

    return 0;
}