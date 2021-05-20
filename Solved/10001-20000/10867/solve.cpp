#include <iostream>
#include <set>
#include <iterator>

using namespace std;

int main() {
    int N, n;
    set<int> s;

    cin >> N;
    while (N--) {
        cin >> n;
        s.insert(n);
    }

    for (set<int>::iterator it = s.begin(); it != s.end(); it++) cout << *it << " ";
    return 0;
}