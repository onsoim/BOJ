#include <iostream>
#include <map>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);

    int N, M, n;
    map<int,int> card;
    map<int,int>::iterator it;

    cin >> N;
    while (N--) {
        cin >> n;
        card[n]++;
    }

    cin >> M;
    while (M--) {
        cin >> n;
        it = card.find(n);
        if (n == it->first) n = it->second;
        else n = 0;
        cout << n << " ";
    }
    return 0;
}