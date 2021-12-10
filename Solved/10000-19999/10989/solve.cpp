#include <iostream>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);

    int N, n;
    int array[10001] = {0,};
    int vMin = 10000, vMax = 0;

    cin >> N;
    while (N--) {
        cin >> n;
        array[n]++;
        vMin = vMin > n ? n : vMin;
        vMax = vMax < n ? n : vMax;
    }

    for (int i = vMin; i <= vMax; i++)
        while (array[i]--) cout << i << "\n";

    return 0;
}