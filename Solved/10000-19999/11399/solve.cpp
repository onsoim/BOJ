#include <iostream>
#include <set>
#include <iterator>

using namespace std;

int main() {
    int N, p, T = 0;
    multiset<int, greater<int>> P;

    cin >> N;
    while (N--) {
        cin >> p;
        P.insert(p);
    }

    N++;
    for (set<int>::iterator it = P.begin(); it != P.end(); it++) N++, T += N * *it;
    cout << T;

    return 0;
}