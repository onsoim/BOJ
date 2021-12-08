#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int N, x, y;
    vector<pair<int,int>> location;

    cin >> N;
    while (N--) {
        cin >> x >> y;
        location.push_back({y,x});
    }
    sort(location.begin(), location.end());

    for(auto l:location) cout << l.second << " " << l.first << "\n";
    return 0;
}