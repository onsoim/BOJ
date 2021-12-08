#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int N, S = 0;
    int A[50], B[50];

    cin >> N;
    for (int i = 0; i < N; i++) cin >> A[i];
    for (int i = 0; i < N; i++) cin >> B[i];

    sort(A, A+N);
    sort(B, B+N, greater<int>());

    for(int i = 0; i < N; i++) S += (A[i] * B[i]);
    cout << S;

    return 0;
}