#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int L, C;
    char c;
    vector<char> s;

    cin >> L >> C;
    for (int i = 0; i < C; i++) {
        cin >> c;
        s.push_back(c);
    }
    sort(s.begin(), s.end());
    
    for (int i = 0; i < C; i++) {
        cout << s[i] << " ";
    }

    return 0;
}