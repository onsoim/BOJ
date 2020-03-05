#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> a;

bool bst(int b, int e, int s) {
    if (b > e) return false;
    int mid = (b + e) / 2;
    if (a[mid] > s) return bst(b, mid - 1, s);
    else if (a[mid] < s) return bst(mid + 1, e, s);
    else return true;
}

int main() {
    cin.tie(NULL);

    int N, M, A;

    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> A;
        a.push_back(A);
    }
    sort(a.begin(), a.end());

    cin >> M;
    while (M--) {
        cin >> A;
        if (A < a[0] || A > a[N-1]) cout << "0\n";
        else cout << bst(0, N - 1, A) << "\n";
    }
    return 0;
}