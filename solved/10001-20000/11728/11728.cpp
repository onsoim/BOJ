#include <iostream>
#include <list>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);

    int N, M;
    list<int> array;
    list<int>::iterator loc;
    int buf, cnt = 0;

    cin >> N >> M;

    while (N--) {
        cin >> buf;
        array.push_back(buf);
    }
    loc = array.begin();
    while (M--) {
        cin >> buf;
        for (;loc != array.end(); loc++)
            if (*loc > buf) break;
        array.insert(loc,buf);
    }

    for (auto num : array) cout << num << " ";

    return 0;
}