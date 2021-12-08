#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    int N;
    string word, buf;
    vector<pair<int,string>> dictionary;

    cin >> N;
    while (N--) {
        cin >> word;
        dictionary.push_back({word.length(), word});
    }
    sort(dictionary.begin(), dictionary.end());

    for(auto l:dictionary) {
        if (buf != l.second) cout << l.second << "\n";
        buf = l.second;
    }
    return 0;
}